@echo off
if "%OS%" == "Windows_NT" setlocal
rem *******************************************************************************
rem * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
rem * All rights reserved. This program and the accompanying materials
rem * are made available under the terms of the Eclipse Public License v1.0
rem * which accompanies this distribution, and is available at
rem * http://www.eclipse.org/legal/epl-v10.html
rem *
rem * Portions of the script based on the Apache Tomcat startup scripts
rem * obtained from the Apache Software Foundation (ASF) under the
rem * Apache License v2.0 found at: http://www.apache.org/licenses/LICENSE-2.0
rem *
rem * Contributors:
rem *   Cambridge Semantics Incorporated
rem *******************************************************************************
rem
rem Bootstrap script for Open Anzo Command Line Interface
rem
rem Environment Variable Prerequisites
rem
rem   ANZO_CLI_HOME    Must point at your Open Anzo installation directory.
rem
rem   ANZO_CLI_OPTS    (Optional) Java runtime options given to the JVM.
rem
rem   JAVA_HOME        Must point at your Java Development Kit or Java
rem                    Runtime Environment installation.
rem 

if not "%JAVA_HOME%" == "" goto gotJdkHome
echo The JAVA_HOME environment variable is not defined.
echo It is needed to run this program.
echo Please set JAVA_HOME to the install directory of a JDK or JRE.
goto error

:gotJdkHome
if not exist "%JAVA_HOME%\bin\java.exe" goto noJavaHome
goto okJavaHome

:noJavaHome
echo The JAVA_HOME environment variable is not defined correctly.
echo This environment variable is needed to run this program.
goto error

:okJavaHome
rem Set standard command for invoking Java.
rem Note that NT requires a window name argument when using start.
rem Also note the quoting as JAVA_HOME may contain spaces.
set _RUNJAVA="%JAVA_HOME%\bin\java"

if "%WORKSPACE%"=="" goto noAnzoCliHome
if exist "%WORKSPACE%\org.openanzo.client\cli\bin\anzo.bat" goto okHome
echo The WORKSPACE environment variable is not defined correctly.
echo Please set WORKSPACE to you Eclipse workspace directory.
echo Current WORKSPACE value is:
echo %WORKSPACE%
goto error
:noAnzoCliHome
echo ERROR: WORKSPACE not found in your environment.
echo Please set the WORKSPACE variable in your environment to match the
echo location of you Eclipse workspace with the Open Anzo project.
goto error

:okHome
rem Setup default ANZO_CLI_OPTS 
if "%ANZO_CLI_OPTS%"=="" set ANZO_CLI_OPTS=-Xmx256M

set ANZO_CMD_LINE_ARGS=
:getArg
if %1a==a goto endInit
set ANZO_CMD_LINE_ARGS=%ANZO_CMD_LINE_ARGS% %1
shift
goto getArg

:error
exit /b 1

:endInit
%_RUNJAVA% %ANZO_CLI_OPTS% "-Dws=%WORKSPACE%" -classpath "%WORKSPACE%/org.openanzo.client/cli/lib/classworlds-1.0.1.jar" "-Dclassworlds.conf=%WORKSPACE%\org.openanzo.client\cli\conf\classworlds.conf" "-Dlog4j.configuration=file:///%WORKSPACE%/openanzo-maven/openanzo-assembly/src/release/root/cli/log4j-cli.properties" org.codehaus.classworlds.Launcher %ANZO_CMD_LINE_ARGS%
