ALTER TABLE {0}_DATATYPE ALTER ID TYPE {6};
ALTER TABLE {0}_LANGUAGE ALTER ID TYPE {6};
CREATE SEQUENCE LANG_SEQ    START WITH 1 INCREMENT BY 1 CACHE 20000;
CREATE SEQUENCE DATATYPE_SEQ  START WITH 1 INCREMENT BY 1 CACHE 20000;