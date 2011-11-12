@echo off
set DB_LIB=C:\Program Files\IBM\SQLLIB\java

call mvn install:install-file -DgroupId=com.ibm.db2 -DartifactId=jcc -Dversion=9.1.0 -Dpackaging=jar -Dfile="%DB_LIB%/db2jcc.jar"
call mvn install:install-file -DgroupId=com.ibm.db2 -DartifactId=jcc_license -Dversion=9.1.0 -Dpackaging=jar -Dfile="%DB_LIB%/db2jcc_license_cu.jar"
call mvn package
copy target\*.jar ..\..\..\plugins\dependencies
