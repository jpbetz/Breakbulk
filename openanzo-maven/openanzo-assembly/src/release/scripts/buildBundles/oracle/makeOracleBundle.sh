#!/bin/bash
DB_LIB=/opt/oracle

if [ -z "$DB_LIB" ]; then
	echo "Error: DB_LIB is not defined correctly."
        echo "Please set in this script or as an environment variable and try again"
        exit 1
elif [ ! -x "$DB_LIB" ]; then
    echo "Error: DB_LIB was defined, but directory specified does not exist."
        echo " Please correct DB_LIB and try again"
        exit 1
fi

mvn install:install-file -DgroupId=com.oracle -DartifactId=jdbc -Dversion=11.1.0.6.0 -Dpackaging=jar -Dfile=${DB_LIB}/jdbc/ojdbc5_g.jar
mvn install:install-file -DgroupId=com.oracle -DartifactId=i18n -Dversion=11.1.0.6.0 -Dpackaging=jar -Dfile=${DB_LIB}/jlib/orai18n.jar
mvn package
cp target/*.jar ../../../plugins/dependencies
