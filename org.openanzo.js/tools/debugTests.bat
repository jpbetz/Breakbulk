@ECHO OFF
REM Batch file which runs the Anzo.JS Unit tests inside the Rhino JavaScript debugger.

REM Go to this batch file's directory
cd /d %~dp0

cd ..\lib\dojo\util\doh
java -cp ..\shrinksafe\custom_rhino.jar org.mozilla.javascript.tools.debugger.Main runner.js testUrl=../../../../anzo/tests/prepareAnzo.js testModule=anzo.tests.module
