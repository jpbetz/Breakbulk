ALTER TABLE STATEMENTS ADD COLUMN UUID {6};
CREATE INDEX SRUUID ON STATEMENTS (UUID);
REORG TABLE STATEMENTS;
UPDATE STATEMENTS SET UUID=(SELECT DISTINCT UUID FROM NAMEDGRAPHS WHERE NAMEDGRAPHS.HEND IS NULL AND (NAMEDGRAPHS.ID=STATEMENTS.NAMEDGRAPHID OR NAMEDGRAPHS.METAID=STATEMENTS.NAMEDGRAPHID));
ALTER TABLE STATEMENTS ALTER COLUMN UUID SET NOT NULL;
REORG TABLE STATEMENTS;