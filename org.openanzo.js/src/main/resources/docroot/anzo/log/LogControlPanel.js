/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
 /*
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>) 
 */
 
dojo.provide("anzo.log.LogControlPanel");

dojo.require("dijit._Widget");
dojo.require("dijit._Container");
dojo.require("dijit._Templated");

dojo.require("dijit.form.Button");
dojo.require("dijit.form.TextBox");

dojo.require("anzo.log");
dojo.require("anzo.log.log4javascript");

(function(){

var log = anzo.log.getLogger("anzo.log.LogControlPanel");

dojo.declare("anzo.log.LogControlPanel", [ dijit._Widget, dijit._Templated ], {
    
    templatePath : dojo.moduleUrl("anzo.log" , "LogControlPanel.html"),
    
    widgetsInTemplate : true,
    
    ROW_SIZE : 2.6, // in 'em' units
    
    _levels : [ anzo.log.log4javascript.Level.ALL, anzo.log.log4javascript.Level.TRACE, anzo.log.log4javascript.Level.DEBUG, anzo.log.log4javascript.Level.INFO, anzo.log.log4javascript.Level.WARN, anzo.log.log4javascript.Level.ERROR, anzo.log.log4javascript.Level.FATAL, anzo.log.log4javascript.Level.OFF ],
    
    constructor : function LogControlPanelConstructor() {
        // Add the CSS for the control panel.
        var headElem = dojo.doc.getElementsByTagName("head")[0];
        var cssUrl = dojo.moduleUrl("anzo.log" , "LogControlPanel.css");
        var linkElems = headElem.getElementsByTagName("link");
        var alreadyHaveCSS = false;
        for (var i = 0; i < linkElems.length; i++) {
            if (linkElems[i].href == cssUrl) {
                alreadyHaveCSS = true;
                break;    
            }
        }
        if (!alreadyHaveCSS) {
            var cssNode = dojo.doc.createElement('link');
            cssNode.type = 'text/css';
            cssNode.rel = 'stylesheet';
            cssNode.href = cssUrl;
            cssNode.media = 'screen';
            headElem.appendChild(cssNode);
        }
    },
    
    startup : function startup() {
        this._renderCurrentLoggers();
        this.inherited("startup", arguments); // call superclass method
    },
    
    tearDown : function tearDown() {
        this.inherited("tearDown", arguments); // call superclass method
         console.debug("tearing down log");
    },
    
    _onClickEnableLogging : function _onClickEnableLogging() {
        anzo.log.log4javascript.setEnabled(true);
    },

    _onClickDisableLogging : function _onClickDisableLogging() {
        anzo.log.log4javascript.setEnabled(false);
    },
    
    _onClickAddMethodTracing : function _onClickAddMethodTracing(event) {
        dojo.stopEvent(event);  // since we use a form's onsubmit for this event, we stop the event so the form doesn't actually submit. Normally one could return false from a handler but that doesn't work from a handler setup by dojoAttachEvent.

        var namespace = this.methodTracingTextBox.value;
        anzo.log.addMethodTracing(namespace);
        this._renderCurrentLoggers();
    },
    
    _onClickRefresh : function _onClickRefresh() {
        this._renderCurrentLoggers();
    },
    
    _onClickAddLogger : function _onClickAddLogger(event) {
        dojo.stopEvent(event);  // since we use a form's onsubmit for this event, we stop the event so the form doesn't actually submit. Normally one could return false from a handler but that doesn't work from a handler setup by dojoAttachEvent.
        
        var loggerName = this.newLoggerTextBox.value;
        if (loggerName) {
            loggerName = dojo.trim(loggerName);

            // Initialize the logger (will do essentially nothing if logger already exists)
            anzo.log.getLogger(loggerName);
            
            // Refresh the list of loggers
            this._renderCurrentLoggers();
            
            // Look for the logger in the table and ensure it's visible
            var loggerNameCells = dojo.query(".loggerNameCell", this.logGridBody);
            for (var i = 0; i < loggerNameCells.length; i++) {
                if (loggerNameCells[i].innerHTML == loggerName) {
                    loggerNameCells[i].scrollIntoView();
                    break;
                }
            }
        }
    },
    
    _onClickSetAllLoggers : function _onClickSetAllLoggers() {
        var selectedIndex = this.setAllLoggersSelect.selectedIndex;
        if (selectedIndex < 0 || selectedIndex >= this._levels.length) {
            log.error("Invalid index selected for level.");
            return;
        }
        var selectedLevel = this._levels[this.setAllLoggersSelect.selectedIndex];
        log.debug("Setting all loggers to " + selectedLevel);

        var loggers = anzo.log.log4javascript.evalInScope("loggers"); // grab the private loggers map from log4javascript. We'll be nice. We won't mess with it, we'll just take a quick look at it.
        if (!loggers) {
            return;
        }
        for (var i in loggers) {
            var logger = loggers[i];
            logger.setLevel(selectedLevel);
        }
        this._renderCurrentLoggers();
    },
    
    _renderCurrentLoggers : function _renderCurrentLoggers() {
        // summary: Read all of the currently loaded loggers in the log4javascript system
        //  and render them in a table.
        var sortedLoggers = [];
        var loggers = anzo.log.log4javascript.evalInScope("loggers"); // grab the private loggers map from log4javascript. We'll be nice. We won't mess with it, we'll just take a quick look at it.
        if (!loggers) {
            return;
        }

        // Copy the logger data into an array and sort
        for (var i in loggers) {
            var logger = loggers[i];
            if (logger) {
                sortedLoggers.push(logger);
            }
        }
        sortedLoggers.sort(this._loggerComparator);

        // Clear the table        
        while(this.logGridBody.hasChildNodes()) {
            this.logGridBody.removeChild(this.logGridBody.firstChild);
        }
 
        // Add the row for each logger
        var len = sortedLoggers.length;
        var contentSize = len * this.ROW_SIZE;
        this.logGridContent.style.height = contentSize + "em";
        for (var i = 0; i < len; i++) {
            var rowElem = this._createRowForLogger(sortedLoggers[i], (i % 2 == 1));
            if (rowElem) {
                this.logGridBody.appendChild(rowElem);
            }
        }
    },
    
    _createRowForLogger : function _createRowForLogger(logger, isOddRow) {
        // summary: Create the HTML table row to render a logger's name and a select box for the log level

        var rowDiv = dojo.doc.createElement("div");
        // Use a string and innerHTML because IE seems to have trouble applying the styles 
        // to the programatically created nodes.
        var html = [
            '<div class="logGrid-row',
            (isOddRow ? ' logGrid-row-odd">' : '">'),
            '<table border="0" class="logGrid-row-table" cellspacing="0" cellpadding="0"><tbody><tr><td style="width: 27em;" class="logGrid-cell loggerNameCell">',
            logger.name,
            '</td><td style="width: 10em;" class="logGrid-cell loggerLevelCell"><select>'
        ];
        for (var i = 0; i < this._levels.length; i++) {
            var loglevel = this._levels[i];
            html.push("<option" + (logger.getLevel().equals(loglevel) ? ' selected="selected">' : '>') + loglevel.name + '</option>');
        }
        html.push('</select></td></tr></tbody></table></div>');
        rowDiv.innerHTML = html.join('');
        
        // Setup log level change event handlers 
        var selectElems = rowDiv.getElementsByTagName("select");
        for (var i = 0; i < selectElems.length; i++) {
            dojo.connect(selectElems[i], "onchange", null, function onLogLevelChange() {
                var selectedIndex = this.selectedIndex;
                var levels = anzo.log.LogControlPanel.prototype._levels;
                if (selectedIndex < 0 || selectedIndex >= levels.length) {
                    log.error("Invalid log level index selected for logger:" + logger.name);
                    return;
                }
                log.debug("Changing log level for '" + logger.name + "' to " + levels[selectedIndex].name);
                logger.setLevel(levels[selectedIndex]);
            });
        }
        return rowDiv;
    },
    
    _loggerComparator : function _loggerComparator(a, b) {
        // summary: lexically compares loggers base on the names.
        if (a.name < b.name) {
            return -1;
        }
        if (a.name > b.name) {
            return 1;
        }
        return 0;
    }

});

anzo.log.LogControlPanel.launchLogControlPanel = function launchLogControlPanel() {
    // summary: Launches the anzo.log.LogControlPanel in its own popup window. This is useful to
    //   use from a bookmarklet.
    // description: To use this, make sure to dojo.require the "anzo.log.LogControlPanel" namespace.
    //   Add a bookmark with the URL set to: javascript:anzo.log.LogControlPanel.launchLogControlPanel()
    
    // This bookmarklet technique is similar to MochiKit's technique. 
    // MochiKit is Copyright 2005 Bob Ippolito <bob@redivi.com>. Licensed under the
    // MIT License: http://www.opensource.org/licenses/mit-license.php 
    if (window) {
        var loggerWindow = window.open("", "_blank", "dependent,resizable=yes,scrollbars=yes,height=330,width=490");
        if (!loggerWindow) {
            alert("Could not open the Anzo.JS LogControlPanel window due to pop-up blocking.");
            return
        }
        loggerWindow.document.write(
            '<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">'
            + '<html><head><title>[Anzo.JS LogControlPanel]</title></head><body style="margin:0; padding:0"><div id="logPanel"></div></body></html>'
        );
        loggerWindow.document.close();
        var logPanelDiv = loggerWindow.document.getElementById("logPanel");
        dojo.withDoc(loggerWindow.document, function() {
        	var logPanel = new anzo.log.LogControlPanel({}, logPanelDiv);		
        	logPanel.startup();
        });
    }
}

})();
