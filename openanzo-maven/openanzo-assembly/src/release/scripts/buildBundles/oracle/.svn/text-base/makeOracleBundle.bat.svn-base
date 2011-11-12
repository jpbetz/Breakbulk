@echo off
set DB_LIB=C:\Program Files\oracle

call mvn install:install-file -DgroupId=com.oracle -DartifactId=jdbc -Dversion=11.1.0.6.0 -Dpackaging=jar -Dfile="%DB_LIB%\jdbc\ojdbc5_g.jar"
call mvn install:install-file -DgroupId=com.oracle -DartifactId=i18n -Dversion=11.1.0.6.0 -Dpackaging=jar -Dfile="%DB_LIB%\jlib\orai18n.jar"
call mvn package
copy target\*.jar ..\..\..\plugins\dependencies
