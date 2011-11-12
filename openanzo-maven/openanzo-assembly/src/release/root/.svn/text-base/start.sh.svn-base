#!/bin/bash
#*******************************************************************************
# Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Portions of the script based on the Apache Tomcat startup scripts
# obtained from the Apache Software Foundation (ASF) under the
# Apache License v2.0 found at: http://www.apache.org/licenses/LICENSE-2.0
#
# Contributors:
#   Cambridge Semantics Incorporated
#*******************************************************************************
#
# Bootstrap script for starting the Open Anzo server.
#
# Environment Variable Prerequisites
#
#   ANZO_HOME    Must point at your Open Anzo installation directory.
#
#   ANZO_OPTS    (Optional) Java runtime options given to the JVM.
#
#   JAVA_HOME    Must point at your Java Development Kit.
#                Just a JRE is not supported by default, a JDK is required.
#

if [ -z "$ANZO_HOME" ] ; then
        ANZO_HOME=$PWD
fi

if [ ! -e "$ANZO_HOME/start.sh" ] ; then
	echo "The ANZO_HOME environment variable is not defined correctly."
	echo "Please set ANZO_HOME to the Open Anzo installation directory."
	echo "Current ANZO_HOME value is: $ANZO_HOME"
	exit 1
fi

if [ -z "$ANZO_OPTS" ] ; then
        ANZO_OPTS=-server 
fi

ANZO_CONF=$ANZO_HOME/configuration
ANZO_LOGS=$ANZO_HOME/var
ANZO_LIB=$ANZO_HOME/plugins

####  SET PATH TO JAVA DIRECTORY IF NOT ALREADY SET #########
#JAVA_HOME=/opt/jdk1.5.0/jre

pushd . > /dev/null

touch $ANZO_LOGS/stderr
touch $ANZO_LOGS/stdout

if [ -z "$JAVA_EXE" ] ; then
  if [ -z "$JAVA_HOME" ] ; then
  		echo "Error: JAVA_HOME is not defined correctly."
        echo "Please set JAVA_HOME to the install directory of a JDK."
        exit 1
  elif [ ! -x "$JAVA_HOME/jre/bin/java" ] && [ ! -x "$JAVA_HOME/bin/java" ]; then
        echo "Error: JAVA_HOME is not defined correctly."
        echo "We cannot find $JAVA_HOME/jre/bin/java or $JAVA_HOME/bin/java."
        echo "Please set JAVA_HOME to the install directory of a JDK."
        exit 1
  elif [ ! -x "$JAVA_HOME/jre/bin/javac" ] && [ ! -x "$JAVA_HOME/bin/javac" ]; then
        echo "Error: JAVA_HOME is not defined correctly."
        echo "It appears to point to a JRE rather than a JDK."
        echo "Please set JAVA_HOME to the install directory of a JDK."
        exit 1
  elif [ -x "$JAVA_HOME/jre/bin/java" ]; then
  	JAVA_EXE=$JAVA_HOME/jre/bin/java
  elif [ -x "$JAVA_HOME/bin/java" ]; then
  	JAVA_EXE=$JAVA_HOME/bin/java
  fi
fi

EXECUTION_COMMAND="$JAVA_EXE \
    $ANZO_OPTS \
    -classpath $ANZO_HOME/plugins/org.eclipse.equinox.launcher_1.0.200.v20090520.jar \
     org.eclipse.equinox.launcher.Main "
    
#If using with java5, edit one of the previous lines to look like this:
# dir:${ANZO_LIB}/dependencies@1 dir:${ANZO_LIB}/dependencies/java5@1\

NO_ARGS=0

if [ $# -eq "$NO_ARGS" ]  # Script invoked with no command-line args?
then
  $EXECUTION_COMMAND -console
fi

while getopts ":d" Option
do
  case $Option in
    d    )      echo "Daemon starting"
                $EXECUTION_COMMAND -console 1234  1>> $ANZO_LOGS/stdout 2>> $ANZO_LOGS/stderr &
                echo $! > $ANZO_LOGS/anzo.pid
                popd > /dev/null

        ;;
    *    ) $EXECUTION_COMMAND -console;;   # DEFAULT 
  esac
done
