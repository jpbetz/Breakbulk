#!/bin/bash
DB_LIB=/opt/ibm/db2/V9.1/java

if [ -z "$DB_LIB" ]; then
	echo "Error: DB_LIB is not defined correctly."
        echo "Please set in this script or as an environment variable and try again"
        exit 1
elif [ ! -x "$DB_LIB" ]; then
    echo "Error: DB_LIB was defined, but directory specified does not exist."
        echo " Please correct DB_LIB and try again"
        exit 1
fi

mvn install:install-file -DgroupId=com.ibm.db2 -DartifactId=jcc -Dversion=9.1.0 -Dpackaging=jar -Dfile=${DB_LIB}/db2jcc.jar
mvn install:install-file -DgroupId=com.ibm.db2 -DartifactId=jcc_license -Dversion=9.1.0 -Dpackaging=jar -Dfile=${DB_LIB}/db2jcc_license_cu.jar
mvn package
cp target/*.jar ../../../plugins/dependencies
