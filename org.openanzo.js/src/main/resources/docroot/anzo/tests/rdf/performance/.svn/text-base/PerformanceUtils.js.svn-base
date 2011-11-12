
/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * Created on:  Oct 10, 2007
 * Revision:
 $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
dojo.provide("anzo.tests.rdf.performance.PerformanceUtils")


function performFind(store, s, p, o, cArray, numTimes) {
    
    var startTimer = 0;
	var endTimer   = 0;
	
	var total = 0;
	var numStmts = 0;
	
    if(numTimes == null)
        numTimes = 1;
        
    for(var i = 1; i <= numTimes; i++) {
        startTime=new Date().getTime();
        var stmts = store.find(s, p, o, cArray);
        endTime=new Date().getTime();
        total += (endTime-startTime);
        if(stmts)
            numStmts = stmts.length;
    }
    return {
        avgElapsed: total/numTimes,
        numStmts : numStmts
    }
}

function performAdds(store, numAdds, numTimes) {
    
    var startTimer = 0;
	var endTimer   = 0;
	
	var total = 0;
	var numStmts = 0;
	
    if(numTimes == null)
        numTimes = 1;
        
    for(var z = 1; z < numTimes; z++) {
        startTime=new Date().getTime();
        var stmts = [];
        for(var i = 1; i <= numAdds; i++)
            stmts.push(anzo.createStatement('http://www.w3.org/1999/02/22-rdf-syntax-ns#'+Math.random(), 'http://www.w3.org/1999/02/22-rdf-syntax-ns#'+Math.random(), 'http://www.w3.org/1999/02/22-rdf-syntax-ns#'+Math.random(), 'http://www.w3.org/1999/02/22-rdf-syntax-ns#'+Math.random()));
        store.add(stmts);
        endTime=new Date().getTime();
        total += (endTime-startTime);
    }
     
    return {
        avgElapsed: total/numTimes,
        numStmts : numAdds
    }
}



function performRemoves(store, numRemoves, numTimes) {
    
    var startTimer = 0;
	var endTimer   = 0;
	
	var total = 0;
	var numStmts = 0;
	
    if(numTimes == null)
        numTimes = 1;
    
    var stmts = store.find();
    var _stmts = [];
    for(var i; i < numRemoves; i++) {
        if(i > stmts.length)
            break;
        _stmts.push(stmts[i]);
    }
    
    for(var z = 1; z < numTimes; z++) {
        startTime=new Date().getTime();
        var stmts = [];
        store.remove(_stmts);
        endTime=new Date().getTime();
        total += (endTime-startTime);
    }
     
    return {
        avgElapsed: total/numTimes,
        numStmts : _stmts.length
    }
}

function getFindPerformanceNumbers(store, patternLow, patternMiddle, patternHigh) {
    
    
    var NUM_WARMUPS = 2;
    var NUM_RUNS = 3;
    
    var data = null;
	    
    console.debug("----------------------------------------------")
    console.debug("find(s, p, o, c)")
    
    
    data = performFind(store, patternLow.subject, patternLow.predicate, patternLow.object, [ patternLow.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternLow.subject, patternLow.predicate, patternLow.object, [ patternLow.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, o, c) on first added statement pattern: '+data.avgElapsed+' milliseconds.  Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternMiddle.subject, patternMiddle.predicate, patternMiddle.object, [ patternMiddle.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternMiddle.subject, patternMiddle.predicate, patternMiddle.object, [ patternMiddle.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, o, c) on middle added statement pattern: '+data.avgElapsed+' milliseconds.  Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternHigh.subject, patternHigh.predicate, patternHigh.object, [ patternHigh.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternHigh.subject, patternHigh.predicate, patternHigh.object, [ patternHigh.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, o, c) on last added statement pattern: '+data.avgElapsed+' milliseconds.  Num stmts found: '+data.numStmts);
    
    
    console.debug("----------------------------------------------")
    console.debug("find(?, p, o, c)")
    
    
    data = performFind(store, null, patternLow.predicate, patternLow.object, [ patternLow.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, null, patternLow.predicate, patternLow.object, [ patternLow.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, o, c) on first added statement pattern: '+data.avgElapsed+' milliseconds.  Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, patternMiddle.predicate, patternMiddle.object, [ patternMiddle.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, null, patternMiddle.predicate, patternMiddle.object, [ patternMiddle.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, o, c) on middle added statement pattern: '+data.avgElapsed+' milliseconds.  Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, patternHigh.predicate, patternHigh.object, [ patternHigh.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, null, patternHigh.predicate, patternHigh.object, [ patternHigh.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, o, c) on last added statement pattern: '+data.avgElapsed+' milliseconds.  Num stmts found: '+data.numStmts);
    
    
    console.debug("----------------------------------------------")
    console.debug("find(s, ?, o, c)")
    
    
    data = performFind(store, patternLow.subject, null, patternLow.object, [ patternLow.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternLow.subject, null, patternLow.object, [ patternLow.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, o, c) on first added statement pattern: '+data.avgElapsed+' milliseconds.  Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternMiddle.subject, null, patternMiddle.object, [ patternMiddle.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternMiddle.subject, null, patternMiddle.object, [ patternMiddle.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, o, c) on middle added statement pattern: '+data.avgElapsed+' milliseconds.  Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternHigh.subject, null, patternHigh.object, [ patternHigh.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternHigh.subject, null, patternHigh.object, [ patternHigh.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, o, c) on last added statement pattern: '+data.avgElapsed+' milliseconds.  Num stmts found: '+data.numStmts);
    
    console.debug("----------------------------------------------")
    console.debug("find(s, p, ?, c)")
    
    
    data = performFind(store, patternLow.subject, patternLow.predicate, null, [ patternLow.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternLow.subject, patternLow.predicate, null, [ patternLow.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, ?, c) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternMiddle.subject, patternMiddle.predicate, null, [ patternMiddle.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternMiddle.subject, patternMiddle.predicate, null, [ patternMiddle.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, ?, c) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternHigh.subject, patternHigh.predicate, null, [ patternHigh.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternHigh.subject, patternHigh.predicate, null, [ patternHigh.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, ?, c) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    console.debug("----------------------------------------------")
    console.debug("find(s, p, o, ?)")
    
    
    data = performFind(store, patternLow.subject, patternLow.predicate, patternLow.object, null, NUM_WARMUPS);
    data = performFind(store, patternLow.subject, patternLow.predicate, patternLow.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, o, ?) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternMiddle.subject, patternMiddle.predicate, patternMiddle.object, null, NUM_WARMUPS);
    data = performFind(store, patternMiddle.subject, patternMiddle.predicate, patternMiddle.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, o, ?) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternHigh.subject, patternHigh.predicate, patternHigh.object, null, NUM_WARMUPS);
    data = performFind(store, patternHigh.subject, patternHigh.predicate, patternHigh.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, o, ?) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    console.debug("----------------------------------------------")
    console.debug("find(?, ?, o, c)")
    
    
    data = performFind(store, null, null, patternLow.object, [ patternLow.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, null, null, patternLow.object, [ patternLow.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (?, ?, o, c) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, null, patternMiddle.object, [ patternMiddle.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, null, null, patternMiddle.object, [ patternMiddle.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (?, ?, o, c) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, null, patternHigh.object, [ patternHigh.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, null, null, patternHigh.object, [ patternHigh.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (?, ?, o, c) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    console.debug("----------------------------------------------")
    console.debug("find(s, ?, ?, c)")
    
    
    data = performFind(store, patternLow.subject, null, null, [ patternLow.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternLow.subject, null, null, [ patternLow.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, ?, c) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternMiddle.subject, null, null, [ patternMiddle.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternMiddle.subject, null, null, [ patternMiddle.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, ?, c) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternHigh.subject, null, null, [ patternHigh.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, patternHigh.subject, null, null, [ patternHigh.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, ?, c) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    console.debug("----------------------------------------------")
    console.debug("find(s, p, ?, ?)")
    
    
    data = performFind(store, patternLow.subject, patternLow.predicate, null, null, NUM_WARMUPS);
    data = performFind(store, patternLow.subject, patternLow.predicate, null, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, ?, ?) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternMiddle.subject, patternMiddle.predicate, null, null, NUM_WARMUPS);
    data = performFind(store, patternMiddle.subject, patternMiddle.predicate, null, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, ?, ?) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternHigh.subject, patternHigh.predicate, null, null, NUM_WARMUPS);
    data = performFind(store, patternHigh.subject, patternHigh.predicate, null, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, p, ?, ?) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    console.debug("----------------------------------------------")
    console.debug("find(?, p, ?, c)")
    
    
    data = performFind(store, null, patternLow.predicate, null, [ patternLow.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, null, patternLow.predicate, null, [ patternLow.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, ?, c) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, patternMiddle.predicate, null, [ patternMiddle.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, null, patternMiddle.predicate, null, [ patternMiddle.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, ?, c) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, patternHigh.predicate, null, [ patternHigh.namedGraphUri ], NUM_WARMUPS);
    data = performFind(store, null, patternHigh.predicate, null, [ patternHigh.namedGraphUri ], NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, ?, c) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    console.debug("----------------------------------------------")
    console.debug("find(s, ?, o, ?)")
    
    
    data = performFind(store, patternLow.subject, null, patternLow.object, null, NUM_WARMUPS);
    data = performFind(store, patternLow.subject, null, patternLow.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, o, ?) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternMiddle.subject, null, patternMiddle.object, null, NUM_WARMUPS);
    data = performFind(store, patternMiddle.subject, null, patternMiddle.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, o, ?) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternHigh.subject, null, patternHigh.object, null, NUM_WARMUPS);
    data = performFind(store, patternHigh.subject, null, patternHigh.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, o, ?) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    console.debug("----------------------------------------------")
    console.debug("find(?, p, o, ?)")
    
    
    data = performFind(store, null, patternLow.predicate, patternLow.object, null, NUM_WARMUPS);
    data = performFind(store, null, patternLow.predicate, patternLow.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, o, ?) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, patternMiddle.predicate, patternMiddle.object, null, NUM_WARMUPS);
    data = performFind(store, null, patternMiddle.predicate, patternMiddle.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, o, ?) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, patternHigh.predicate, patternHigh.object, null, NUM_WARMUPS);
    data = performFind(store, null, patternHigh.predicate, patternHigh.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, o, ?) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    console.debug("----------------------------------------------")
    console.debug("find(?, ?, ?, c)")
    
    
    data = performFind(store, null, null, null, [patternLow.namedGraphUri], NUM_WARMUPS);
    data = performFind(store, null, null, null, [patternLow.namedGraphUri], NUM_RUNS);
    console.debug('Elapsed time calling find (?, ?, ?, c) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, null, null, [patternMiddle.namedGraphUri], NUM_WARMUPS);
    data = performFind(store, null, null, null, [patternMiddle.namedGraphUri], NUM_RUNS);
    console.debug('Elapsed time calling find (?, ?, ?, c) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, null, null, [patternHigh.namedGraphUri], NUM_WARMUPS);
    data = performFind(store, null, null, null, [patternHigh.namedGraphUri], NUM_RUNS);
    console.debug('Elapsed time calling find (?, ?, ?, c) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    console.debug("----------------------------------------------")
    console.debug("find(?, ?, o, ?)")
    
    
    data = performFind(store, null, null, patternLow.object, null, NUM_WARMUPS);
    data = performFind(store, null, null, patternLow.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (?, ?, o, ?) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, null, patternMiddle.object, null, NUM_WARMUPS);
    data = performFind(store, null, null, patternMiddle.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (?, ?, o, ?) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, null, patternHigh.object, null, NUM_WARMUPS);
    data = performFind(store, null, null, patternHigh.object, null, NUM_RUNS);
    console.debug('Elapsed time calling find (?, ?, o, ?) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    console.debug("----------------------------------------------")
    console.debug("find(?, p, ?, ?)")
    
    
    data = performFind(store, null, patternLow.predicate, null, null, NUM_WARMUPS);
    data = performFind(store, null, patternLow.predicate, null, null, NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, ?, ?) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, patternMiddle.predicate, null, null, NUM_WARMUPS);
    data = performFind(store, null, patternMiddle.predicate, null, null, NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, ?, ?) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, null, patternHigh.predicate, null, null, NUM_WARMUPS);
    data = performFind(store, null, patternHigh.predicate, null, null, NUM_RUNS);
    console.debug('Elapsed time calling find (?, p, ?, ?) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    console.debug("----------------------------------------------")
    console.debug("find(s, ?, ?, ?)")
    
    
    data = performFind(store, patternLow.subject, null, null, null, NUM_WARMUPS);
    data = performFind(store, patternLow.subject, null, null, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, ?, ?) on first added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternMiddle.subject, null, null, null, NUM_WARMUPS);
    data = performFind(store, patternMiddle.subject, null, null, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, ?, ?) on middle added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    data = performFind(store, patternHigh.subject, null, null, null, NUM_WARMUPS);
    data = performFind(store, patternHigh.subject, null, null, null, NUM_RUNS);
    console.debug('Elapsed time calling find (s, ?, ?, ?) on last added statement pattern: '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
    
    
    console.debug("----------------------------------------------")
    console.debug("find(?, ?, ?, ?)")
    
    
    data = performFind(store, null, null, null, null, NUM_WARMUPS);
    data = performFind(store, null, null, null, null, NUM_RUNS);
    console.debug('Elapsed time calling find (?, ?, ?, ?): '+data.avgElapsed+' milliseconds. Num stmts found: '+data.numStmts);
            
}		

function getAddPerformanceNumbers(store) {
    
    
    var NUM_WARMUPS = 2;
    var NUM_RUNS = 3;
    var NUM_ADD_STMTS = 100;
    
    var data = null;
    
    console.debug("----------------------------------------------")
    console.debug("adding num stmts: "+NUM_ADD_STMTS)
    
    data = performAdds(store, NUM_ADD_STMTS, NUM_WARMUPS);
    data = performAdds(store, NUM_ADD_STMTS, NUM_RUNS);
    
    console.debug('Elapsed time adding statements: '+data.avgElapsed+' milliseconds.');
    
}


function getRemovePerformanceNumbers(store) {
    
    var NUM_WARMUPS = 2;
    var NUM_RUNS = 3;
    var NUM_REMOVE_STMTS = 100;
    
    var data = null;
    
    console.debug("----------------------------------------------")
    console.debug("removing num stmts: "+NUM_REMOVE_STMTS)
    
    data = performRemoves(store, NUM_REMOVE_STMTS, NUM_WARMUPS);
    data = performRemoves(store, NUM_REMOVE_STMTS, NUM_RUNS);
    
    console.debug('Elapsed time removing statements: '+data.avgElapsed+' milliseconds.');
    
}
	