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
rem Start Script for the Open Anzo server
rem
rem Environment Variable Prerequisites
rem
rem   ANZO_HOME    Must point at your Open Anzo installation directory.
rem
rem   ANZO_OPTS    (Optional) Java runtime options given to the JVM.
rem                If not set, the "-server" is the default used. 
rem
rem   JAVA_HOME    Must point at your Java Development Kit installation.
rem                Just a JRE is not supported by default, a JDK is required.
rem 

if not "%JAVA_HOME%" == "" goto gotJdkHome
echo The JAVA_HOME environment variable is not defined.
echo It is needed to run this program.
echo Please set JAVA_HOME to the install directory of a JDK.
goto error

:gotJdkHome
if not exist "%JAVA_HOME%\bin\java.exe" goto noJavaHome
if not exist "%JAVA_HOME%\bin\javaw.exe" goto noJavaHome
if not exist "%JAVA_HOME%\bin\jdb.exe" goto noJavaHome
if not exist "%JAVA_HOME%\bin\javac.exe" goto noJavaHome
goto okJavaHome

:noJavaHome
echo The JAVA_HOME environment variable is not defined correctly.
echo This environment variable is needed to run this program.
echo NB: JAVA_HOME should point to a JDK not a JRE.
goto error

:okJavaHome
rem Set standard command for invoking Java.
rem Note that NT requires a window name argument when using start.
rem Also note the quoting as JAVA_HOME may contain spaces.
set _RUNJAVA="%JAVA_HOME%\bin\java"

if "%ANZO_HOME%"=="" goto guessAnzoHome
goto verifyAnzoHome
:guessAnzoHome
if "%OS%"=="Windows_NT" set ANZO_HOME=%~dp0
if "%ANZO_HOME%"=="" goto noAnzoHome
:verifyAnzoHome
if exist "%ANZO_HOME%\startAnzo.bat" goto okHome
echo The ANZO_HOME environment variable is not defined correctly.
echo Please set ANZO_HOME to the Open Anzo installation directory.
echo Current ANZO_HOME value is:
echo %ANZO_HOME%
goto error
:noAnzoHome
echo ERROR: ANZO_HOME not found in your environment.
echo Please set the ANZO_HOME variable in your environment to match the
echo location of the Open Anzo installation.
goto error

:error
exit /b 1

:okHome
rem Default to the JVM "-server" option for more reasonable heap size defaults, etc.
if "%ANZO_OPTS%"=="" set ANZO_OPTS=-server

%_RUNJAVA% %ANZO_OPTS% -classpath "%ANZO_HOME%/plugins/org.eclipse.equinox.launcher_1.0.200.v20090520.jar" org.eclipse.equinox.launcher.Main -console
