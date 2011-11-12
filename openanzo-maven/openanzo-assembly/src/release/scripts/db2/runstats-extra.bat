db2 connect to %1 user %2
db2 -f runstats.sql
db2 commit work
db2 disconnect %1
