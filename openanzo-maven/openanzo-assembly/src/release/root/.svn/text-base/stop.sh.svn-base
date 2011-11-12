#!/bin/bash
#*******************************************************************************
# Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#   Cambridge Semantics Incorporated
#*******************************************************************************
#
# Bootstrap script for stopping the Open Anzo server.
#
# Environment Variable Prerequisites
#
#   ANZO_HOME    Must point at your Open Anzo installation directory.
#

if [ -z "$ANZO_HOME" ] ; then
        ANZO_HOME=$PWD
fi

if [ ! -e "$ANZO_HOME/stop.sh" ] ; then
	echo "The ANZO_HOME environment variable is not defined correctly."
	echo "Please set ANZO_HOME to the Open Anzo installation directory."
	echo "Current ANZO_HOME value is: $ANZO_HOME"
	exit 1
fi

kill `cat $ANZO_HOME/var/anzo.pid`
