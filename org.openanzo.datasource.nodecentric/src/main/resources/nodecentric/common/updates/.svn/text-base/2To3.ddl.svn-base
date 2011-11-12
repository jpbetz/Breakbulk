CREATE TABLE {0}_USED_IDS (
    ID            {6} NOT NULL,
   	TRANSACTIONID {6} NOT NULL
)  {2};

ALTER TABLE TRANSACTIONTIME ADD SERVERID {7}({4}) {3};
ALTER TABLE LOCKED_GRAPHS ADD TRANSACTIONID {6};		


CREATE INDEX {0}_UIDS_TI ON 	{0}_USED_IDS(TRANSACTIONID,ID)   {1};
CREATE INDEX {0}_UIDS_IT ON 	{0}_USED_IDS(ID,TRANSACTIONID)   {1};

CREATE UNIQUE INDEX LOCKEDS ON LOCKED_GRAPHS(TRANSACTIONID,ID);

CREATE INDEX TCSID ON TRANSACTIONTIME(SERVERID,COMMITED);

UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#datasource' WHERE VALUE='http://openanzo.org/predicates/datasource';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#hasMetadataGraph' WHERE VALUE='http://openanzo.org/predicates/hasMetadataGraph';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#revisioned' WHERE VALUE='http://openanzo.org/predicates/revisioned';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#persisted' WHERE VALUE='http://openanzo.org/predicates/persisted';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#uuid' WHERE VALUE='http://openanzo.org/predicates/uuid';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#Dataset' WHERE VALUE='http://openanzo.org/types/Dataset';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph' WHERE VALUE='http://openanzo.org/types/NamedGraph';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#namedGraph' WHERE VALUE='http://openanzo.org/predicates/namedGraph';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#createdBy' WHERE VALUE='http://openanzo.org/predicates/createdBy';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#lastModifiedByUser' WHERE VALUE='http://openanzo.org/predicates/lastModifiedByUser';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#modified' WHERE VALUE='http://openanzo.org/predicates/modified';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#revision' WHERE VALUE='http://openanzo.org/predicates/revision';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#canBeAddedToBy' WHERE VALUE='http://openanzo.org/RBAC#canBeAddedToBy';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#canBeReadBy' WHERE VALUE='http://openanzo.org/RBAC#canBeReadBy';
UPDATE ANZO_U SET VALUE='http://openanzo.org/ontologies/2008/07/Anzo#canBeRemovedFromBy' WHERE VALUE='http://openanzo.org/RBAC#canBeRemovedFromBy';
