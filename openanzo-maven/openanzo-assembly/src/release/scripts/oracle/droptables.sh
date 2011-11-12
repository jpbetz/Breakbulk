#!/bin/bash
sqlplus $1/$2@$3 @droptables.sql
