bind sqllib/bnd/@db2cli.lst grant all CLIPKG 20
create bufferpool ANZOBP SIZE 32768 PAGESIZE 4k
alter tablespace userspace1 bufferpool ANZOBP
update db cfg using LOCKLIST 10000
update db cfg using MAXLOCKS 25
update db cfg using LOGFILSIZ 16384
update db cfg using LOGPRIMARY 8
update db cfg using LOGSECOND 4
update db cfg using APPLHEAPSZ 8192
update db cfg using STMTHEAP 8192
force application all

