#!/bin/sh
# Script which runs the Anzo.JS Unit tests inside the Rhino JavaScript debugger.
# Go to this script's directory
cd `dirname $0`
cd ../lib/dojo/util/doh
java -cp ../shrinksafe/custom_rhino.jar org.mozilla.javascript.tools.debugger.Main runner.js testUrl=../../../../anzo/tests/prepareAnzo.js testModule=anzo.tests.module
