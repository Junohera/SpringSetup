CREATE TABLE STUDENT(
    sNum VARCHAR2(20), 
    sId VARCHAR2(20),
    sPw VARCHAR2(20),
    sName VARCHAR2(20),
    sAge NUMBER(3),
    sGender VARCHAR2(20),
    sMajor VARCHAR2(80)
);

SELECT * FROM student;

DELETE FROM STUDENT;

DROP TABLE WORKSET;

CREATE TABLE WORDSET (
    WORDKEY VARCHAR2(20),
    WORDVALUE VARCHAR2(500)
);

INSERT INTO WORDSET (
    WORDKEY, WORDVALUE
) VALUES (
    'WORKKEY' , 'WORDVALUE'
);
DELETE FROM WORDSET;
WHERE /* WHERE_EXPRESSION */;