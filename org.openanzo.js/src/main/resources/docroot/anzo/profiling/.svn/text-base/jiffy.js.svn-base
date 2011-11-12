/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * The code below if Jiffy as taken from http://code.google.com/p/jiffy-web/
 * and is Copyright 2008 Whitepages.com, Inc. obtained under the Apache License 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0.
 * 
 * The code was modified by Cambridge Semantics Incorporated 
 * to add the SEND_MEASURES option, remove unused code, and
 * make it loadable using the Dojo loader.
 * 
 *******************************************************************************/

dojo.provide("anzo.profiling.jiffy");

/*								
  Copyright 2008 Whitepages.com, Inc.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var Jiffy = function (){
  this.getUID = function(){
    return Math.round(Math.random() * 1000000000000000);
  }
  
  this.checkRemoveEvent = function(eventName){
	if(eventsForRemoval[eventName] != null){
	  var captureDetails = eventsForRemoval[eventName];
	  Jiffy.utils.removeEvent(captureDetails.element_id, captureDetails.browser_event, captureDetails.callback_func, true);
	}
  }
  
	this.addMarksMeasures = function(referenceID, eventName, elapseTime, refTime){
		marks_measures.push({name: referenceID, evt:eventName, et:elapseTime, rt:refTime});
	}
	
  var eventsForRemoval = {};
  var pageTimer = (window.JiffyParams != undefined && JiffyParams.jsStart != undefined) ? JiffyParams.jsStart : (new Date()).getTime();
  
  var pname = (window.JiffyParams != undefined && JiffyParams.pname != undefined) ? JiffyParams.pname : encodeURI(window.location);
  var uid = (window.JiffyParams != undefined && JiffyParams.uid != undefined) ? JiffyParams.uid : getUID();
  
  var cUri = '/rx'
  var cMethod = 'get';

  var markers = [];
  	/* marks_measures
	JSON Obj used for storing all captured marks and measures. This is mainly used by the 
	Jiffy Firebug plugin but we use it for the bulk load operation. sample layout of the 
	object looks like the following:
	{
     	"PageStart": { et: 2676, m: [
			{et:2676, evt:"load", rt:1213159816044}
      ]},
      	"onLoad": { et: 74, m: [
        	{et:7,  evt:"carouselcreated", rt:1213159818722},
        	{et:67, evt:"finishedonLoad",  rt:1213159818729}
      ]}
	}
	*/
  var marks_measures = [];
  
  return{
  	// Creating a mark sets the startTime and lastTime to the curr time
	mark : function(referenceID){
		if(Jiffy.options.USE_JIFFY == undefined || !Jiffy.options.USE_JIFFY){return};
		var currTime = (new Date()).getTime();
		markers[referenceID] = {startTime: currTime, lastTime: currTime}; 
	},
	
	// Creating a measure will calculate 
	// et (elapsed time) as current time - markers[].currTime
	measure : function(eventName, referenceID){
		if(Jiffy.options.USE_JIFFY == undefined || !Jiffy.options.USE_JIFFY){return};
		/*Check to see if the eventName is a string which we use for wrapping
		around tags or an Event Object being passed by the attachevent
		method for builtin browser events we are tracking.*/

		var _eventName = (typeof eventName == "string" ? eventName : eventName.type); 
		// -- >

		var currTime = new Date().getTime();
		
		var refStartTime;
		var elapsedTime;
		
		// We want the previous time stamp to measure this event against
		if(referenceID != null && markers[referenceID] != null) {
			refStartTime = markers[referenceID].lastTime;
			elapsedTime = currTime - refStartTime;
			markers[referenceID].lastTime = currTime;
		}
		else
		{
			refStartTime = pageTimer;
			elapsedTime = currTime - refStartTime;
		}
		
		if(referenceID != null) {
			addMarksMeasures(referenceID, _eventName, elapsedTime, refStartTime);
		}
		else{
			markers["PageStart"] = {startTime: refStartTime, lastTime: currTime};
			addMarksMeasures("PageStart", _eventName, elapsedTime, refStartTime); // pageTimer?
		}

		if(Jiffy.options.SEND_MEASURES && (!Jiffy.options.ISBULKLOAD || _eventName == "unload")){		
            var curMeasures = Jiffy.utils.formatMeasure(_eventName,elapsedTime);
            Jiffy.Ajax.report(cMethod,cUri,{uid:uid,st:pageTimer,pn:pname,ets:curMeasures});
		}
		checkRemoveEvent(eventName);
	},

	_bulkLoad: function(){
	  if(!Jiffy.options.SEND_MEASURES){return};
	  var bulkmeasures = Jiffy.getMeasures();
	  var bulkmeasuresCount = bulkmeasures.length;
	  var measuresStr = "";
	  for(x=0;x<bulkmeasuresCount;x++){
		measuresStr += Jiffy.utils.formatMeasure(bulkmeasures[x].evt,bulkmeasures[x].et) +",";
	  }
	  measuresStr = measuresStr.replace(/\,$/g,'');
	  Jiffy.Ajax.report(cMethod,cUri,{uid:uid,st:pageTimer,pn:pname,ets:measuresStr});	
	},

	getMeasures: function(){
	  return marks_measures;
	},
	
	clearMeasures: function() {
		marks_measures = [];
		markers = [];
	}
  } 
}();

/*Default options
  These can be overridden by providing a globally scoped hash named 'JiffyOptions' with
  values for each option you would like to override.
  
  bool USE_JIFFY: When false, this stops Jiffy from creating any marks or measures and it will prevent Jiffy from sending data to the server. This is useful to remove any Jiffy execution overhead. Default is 'true'.
  
  bool SEND_MEASURES: When false, Jiffy will collect marks and measures but will NOT send them to the server. This is useful when you want to view the measures using a tool like the Jiffy Firebug plugin (http://billwscott.com/jiffyext/). It avoids the need for the Jiffy-web server infrastructure for quick and simple uses. Default is 'true'.

  bool ISBULKLOAD: This will enable bulk loading of all Jiffy measures to be sent in one call to the server logger. Default is 'true'.
  
  object/hash BROWSER_EVENTS: These are builin events such as load and unload events and the object to which we should attach a measure callback to. These will automaticly be mmaeasured against the start time mark.
  
  bool SOFT_ERRORS: In some functions we will use a try catch statement and if these are enabled they will alert with the message or the error. This is meant for developer debugging only and should left to false in a production enviroment.
  */
Jiffy.options = {
  USE_JIFFY: true,
  SEND_MEASURES: true,
  ISBULKLOAD: true,
  BROWSER_EVENTS: {"unload":window,"load":window},
  SOFT_ERRORS: false
};

Jiffy.utils = {
  inArray: function(ary,target) {
	for ( var i=0,len=ary.length;i<len;i++ ) {
	  if ( target == ary[i] ) {
		return true;
	  }
	}
	return false;
  },
  get: function(id) {
	return document.getElementById(id);
  },
  onDOMReady: function(func) {
	if (document.addEventListener) {
	  document.addEventListener("DOMContentLoaded",func,false);
	}
	/*@cc_on @*/
	/*@if (@_win32)
	document.write("<script id=__ie_onload defer src=javascript:void(0)><\/script>");
	var script = document.getElementById("__ie_onload");
	script.onreadystatechange = function() {
	  if (this.readyState == "complete") {
		func.call();
	  }
	};
	/*@end @*/
	if ( /WebKit/i.test(navigator.userAgent)) {
	  var _timer = setInterval(function() {
		if ( /loaded|complete/.test(document.readyState)) {
		  func;
		}
	  },10);
	}
  },
  on: function(elem,evt,func,bubble) {
	bubble = bubble || false;
	if (evt=='DOMReady') {
	  this.onDOMReady(func);
	  return true;
	}
	else {
	  var el = (typeof(elem)=='string') ? this.get(elem) : elem;
	  if (window.addEventListener) {
		el.addEventListener(evt,func,bubble); return true;
	  }
	  else 
	  if (window.attachEvent) {
		el.attachEvent('on'+evt,func); return true;
	  }
	  else {
		return false;
	  }
	}
  },
  serialize: function(obj) {
	var str = '';
	if ( typeof(obj) == 'object' ) {
	  for (key in obj) { str += key+'='+obj[key]+'&'; }
	}
	return str.replace(/&$/,'');
  },
  formatMeasure: function(name,val) {
	return name + ":" + val;
  },
  hashToJiffyList: function(obj) {
	var str = '';
	if ( typeof(obj) == 'object' ) {
	  for (key in obj) {
		if(typeof(obj[key]) == 'object'){Jiffy.utils.hashToJiffyList(obj[key]);}
		else{str += Jiffy.utils.formatMeasure(key,obj[key])+',';}
	  }
	}
	return str.replace(/,$/,'');
  },
  removeEvent: function(elem, evt, func, bubble){
	var el = (typeof(elem)=='string') ? this.get(elem) : elem;
	if (window.removeEventListener) {
	  el.removeEventListener(evt,func,bubble); return true;
	}
	else 
	if (window.detachEvent) {
	  el.detachEvent('on'+evt,func); return true;
	}
	else {
	  return false;
	}
  },
  getUID: function(){
    return Math.round(Math.random() * 1000000000000000);
  },
  hashMerge: function(hash1, hash2){
	for (var option in hash1)
	{
	  if(hash2[option] != null){
		hash2[option] = hash1[option];
	  }
	}
  }
};

Jiffy.Ajax = {
  connection: function(){
	return ((window.XMLHttpRequest) 
	? new XMLHttpRequest() : (window.ActiveXObject) 
	  ? new ActiveXObject("Microsoft.XMLHTTP") : null);
	},
  report: function(method, url, params, success, failure) {
	var req = this.connection();	
	var strParams = (typeof(params)=='string') ? params : Jiffy.utils.serialize(params);
	url += '?'+strParams;
	req.onreadystatechange = (!success && !failure)
	  ? function() { return; }
	  : function() {
	if (req.readyState != 4)
	  return;

	  if (req.status == 200) { if (success){success.call(req);} }
	  else { if(failure){failure.call(req);} }
	};

	switch(method) {
		case 'get':
			req.open('GET',url,true);
			req.send(null);
			break;
		case 'post':
			req.open('POST',url,true);
			req.send(strParams);
			break;
		case 'img':
			var image = document.createElement('img');
	    	image.setAttribute('src',url);
			break;
	}
  }
};

Jiffy.init = function(){
  //Merge the site defined options with the defaults if the site has provided overrides.
  if(window.JiffyOptions != undefined){Jiffy.utils.hashMerge(window.JiffyOptions, Jiffy.options);}
  //insure that we should execute Jiffy by reviewing the options hash
  if(Jiffy.options.USE_JIFFY == undefined || !Jiffy.options.USE_JIFFY){return};
  //Set up built in brower events to fire if they are in the options settings
  var BROWSER_EVENTS = Jiffy.options.BROWSER_EVENTS;
  for (var bEvents in BROWSER_EVENTS)
  {
	var objToBind = BROWSER_EVENTS[bEvents];
	if(objToBind){
	  Jiffy.utils.on(objToBind,bEvents, Jiffy.measure);
	}
  }
  if(Jiffy.options.SEND_MEASURES && Jiffy.options.ISBULKLOAD){
	//Attach body onload to call bulk loader sending all data at once.
	Jiffy.utils.on(window, "load", Jiffy._bulkLoad);
  }
};

Jiffy.init();
