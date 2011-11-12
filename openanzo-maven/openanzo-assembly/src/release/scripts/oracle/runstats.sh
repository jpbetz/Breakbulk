#!/bin/bash
ORACLE_SID=$3
ORAENV_ASK=NO
. oraenv
sqlplus $1/$2@$3 @runstats.sql
