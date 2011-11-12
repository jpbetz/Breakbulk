#!/bin/bash
HERE=$PWD
db2 connect to $1
cd $HOME
db2 -f $HERE/db2setup.sql
db2 disconnect $1
