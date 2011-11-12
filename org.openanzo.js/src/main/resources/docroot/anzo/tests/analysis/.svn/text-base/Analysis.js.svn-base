/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * 
 * Simple Analysis utilties, including playback.
 * 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.analysis.Analysis");

dojo.require("anzo.messaging.JMSClient");
dojo.require("anzo.messaging.JMSMessage");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.log");

(function() {
var log = anzo.log.getLogger("anzo.tests.analysis.Analysis");

anzo.tests.analysis = {
	
	playback : function(requestFile, concurrentRequests, callback) {
	
		anzo.messaging.JMSClient.connect(anzo.tests.properties.sysadmin, function connectCallback(status, message) {
	        log.debug("STATUS: " + status);
	    	
	    	// TODO: how can we load this from the filesystem?
	    	// When we try with a file URL we get access restrictions
	    	var requestsStr = anzo.tests.utilities.loadTextFile(requestFile);
	    	var lines = requestsStr.split("\r\n");
	    	log.debug("LINES: " + lines.length);
	    	
	    	var request = true;
	    	var msgProps = null;
	    	var body = "";
	    	var firstBodyLine = false;
	    	
	    	var requests = [];
	    	
	    	for (var i=0;i<lines.length;i++) {
	    		var line = lines[i];
	    		if (line.indexOf("@request") == 0 || line.indexOf("@response") == 0) {
	                if (msgProps != null) {
	                    if (request) {
	                    	var req = {};
	                    	//req["body"] = dojo.eval('(' + body + ')');
	                    	req["body"] = body;
	                    	req["msgProps"] = msgProps;
	                    	requests.push(req);
	                    } 
	                }
	                msgProps = null;
	                body = null;
	                request = line.indexOf("@request") == 0;
	            } else if (line.indexOf("@properties") == 0) {
	                msgProps = {};
	            } else if (line.indexOf("@body") == 0) {
	                body = "";
	                firstBodyLine = true;
	            } else {
	                if (msgProps != null && body == null) {
	                    var parts = line.split("=");
	                    if (parts.length == 2) {
	                        msgProps[parts[0]] = parts[1];
	                    }
	                } else {
	                    if (!firstBodyLine) {
	                        body += ("\n");
	                    } else {
	                        firstBodyLine = false;
	                    }
	                    body += line;
	                }
	            }
	    	}
	        
	        var stats = { totalRequestDurations : 0, operationDurationTotal : {}, operationCount: {} };
	        var startTime = new Date().getTime();

	    	anzo.tests.analysis.processRequests(requests, 0, stats, concurrentRequests, function(success, errors) {
    	        var endTime = new Date().getTime();
	    		if (success) {
	    			log.info("All request completed successfully");
	    			anzo.messaging.JMSClient.disconnect(function disconnectCallback(status, message) {
                        anzo.tests.analysis.outputStats(stats, requests.length, endTime - startTime);
	    	            callback(true, null);
	    	        });
	    		} else {
	    			log.error("Requests failed: " + dojo.toJson(errors, true));
	    			anzo.messaging.JMSClient.disconnect(function disconnectCallback(status, message) {
	    	            callback(false, errors);
	    	        });
	    		}
	    	});
		});
     },
     
     processRequests : function(requests, ind, stats, concurrentRequests, callback) {
    	 log.debug("Process requests " + ind + "/" + requests.length + "," + concurrentRequests);
    	 if (ind >= requests.length) {
    		 log.debug("All requests processed...");
    		 callback(true, null);
    		 return;
    	 }
    	 
    	 
    	 var ser = anzo.client.Serialization;
    	 var responseFormat = ser.MIMETYPE_JSON;
    	 
    	 var msgs = [];
    	 var starts = [];
    	 var destinations = [];
    	 
    	 for (var i=0;i<concurrentRequests;i++) {
    		 if (ind + i >= requests.length) {
    	         break;
    		 }
    		 var req = requests[ind + i];
    		 var msg = new anzo.messaging.JMSMessage(req.body, responseFormat);
        	 for (var prop in req.msgProps) {
                 if (prop == "requestUser") {
                	 continue;
                 }
                 if (prop == "destination") {
                     var val = req.msgProps[prop];
                     val = val.substring(8);
                     destinations.push(val);
                     continue;
                 }
                 if (prop == "jmsCorrelationId") {
                	 var val = req.msgProps[prop];
                	 msg.properties[anzo.messaging.JMS_MSG_PROPERTY_CORRELATION_ID] = val;
                	 continue;
                 }
                 msg.properties[prop] = req.msgProps[prop];
        	 }
        	 msgs.push(msg);
    	 }
    	 
    	 var failed = false;
		 var responses = [];
    	 var getResponseCallback = function(index) {
	    	 var responseCallback = function(response) {
	    		 var end = new Date().getTime();
	    		 if (failed) {
	    			 return;
	    		 }
	    		 responses.push(index);
	    		 var start = starts[index];
	    		 var msg = msgs[index];
	    		 var op = msg.properties["operation"];
	
	             // Collect some statistics
	    		 var duration = end-start;
	    		 stats.totalRequestDurations += duration;
	    		 stats.operationDurationTotal[op] = (op in stats.operationDurationTotal) ? (stats.operationDurationTotal[op] + duration) : duration;
	    		 stats.operationCount[op] = (op in stats.operationCount) ? (stats.operationCount[op] + 1) : 1;
	    		     
	    		 var cor = msg.properties[anzo.messaging.JMS_MSG_PROPERTY_CORRELATION_ID];
	    		 var responseError = false;
	    		 if (response.error) {
	    		     responseError = true;
	    		 } else if (response.jmsMessages) {
	    		     for (var i = 0; i < response.jmsMessages.length; i++) {
	    		         if (response.jmsMessages[i].data.properties.operationFailed == "true") {
	    		             responseError = true;
	    		             break;
	    		         }
	    		     }
	    		 } else if (response.message && response.message.properties.operationFailed == "true") {
	    		     responseError = true;
	    		 }
	    		 
	             if (responseError) {
	            	 log.info("Request failed " + op + " (" + cor + ") " + duration + " responses: " + responses.length);
	            	 failed = true;
	                 callback(false, response);
	             } else {
	            	 log.info("Request complete " + op + " (" + cor + ") " + duration + " responses: " + responses.length);
	            	 if (responses.length == msgs.length) {
	            		 log.debug("All concurrent requests received, procesing next batch");
		            	 anzo.tests.analysis.processRequests(requests, ind + concurrentRequests, stats, concurrentRequests, function(success, errors) {
		            		 callback(success, errors);
		            	 });
	            	 }
	             }
	         };
	         return responseCallback;
    	 };
    	 
         for (var i=0;i<msgs.length;i++) {
        	 log.debug("publishing message: " + i);
        	 starts[i] = new Date().getTime();
        	 anzo.messaging.JMSClient.publish(msgs[i], destinations[i], getResponseCallback(i));
         }
    	 
     },
     
     outputStats : function(stats, totalRequests, overallDuration) {
         
         var csvHeader = "Total Time,Duration Sum";
         var csvResults = "" + overallDuration + "," + stats.totalRequestDurations;

         // Sort the per-request information so that it's a predictable order. Makes it easier for use in analysis of multiple runs.
         var sortedOpDurations = [];
         var sortedOpCounts = [];
         for (var operation in stats.operationDurationTotal) {
             sortedOpDurations.push({ operation: operation, val: stats.operationDurationTotal[operation] });
         }
         for (var operation in stats.operationCount) {
             sortedOpCounts.push({ operation: operation, val: stats.operationCount[operation] });
         }
         function operationComparator(a, b) {
            if (a.operation > b.operation)
                return 1;
            if (a.operation < b.operation)
                return -1;
            return 0;
         }
         sortedOpDurations.sort(operationComparator);
         sortedOpCounts.sort(operationComparator);
         
         var str = "";
         str += "Total requests sent: " + totalRequests + "\n";
         str += "Total time (ms): " + overallDuration + "\n";
         str += "Sum of request durations (ms):" + stats.totalRequestDurations + "\n";
         str += "Total Duration By Operation in ms (with % of sum):\n";
         for (var i = 0; i < sortedOpDurations.length; i++) {
             var operation = sortedOpDurations[i].operation;
             var val = sortedOpDurations[i].val;
             var percent = Math.floor(val / stats.totalRequestDurations * 10000.0) / 100.0;
             str += "\t" + operation + ": " + val + " (" + percent + "%)\n"; 
             
             csvHeader += ",Duration (" + operation + "),% Duration(" + operation + ")";
             csvResults += "," + val + "," + (Math.floor(val / stats.totalRequestDurations * 10000.0) / 10000.0);
         }
         str += "Total Requests By Operation (with % of total):\n"
         for (var i = 0; i < sortedOpCounts.length; i++) {
             var operation = sortedOpCounts[i].operation;
             var val = sortedOpCounts[i].val;
             var percent = Math.floor(val / totalRequests * 10000.0) / 100.0;
             str += "\t" + operation + ": " + val + " (" + percent + "%)\n";

             csvHeader += ",Request Count (" + operation + "),% Request Count (" + operation + ")";
             csvResults += "," + val + "," + (Math.floor(val / totalRequests * 10000.0) / 10000.0);
         }
         
         var csv = csvHeader + "\n" + csvResults + "\n";
         if (typeof doh == "undefined") {
             log.info(str);
             log.info(csv);
         } else {
             doh.debug(str);
             doh.debug(csv);
         }
     }
     
}

})();
