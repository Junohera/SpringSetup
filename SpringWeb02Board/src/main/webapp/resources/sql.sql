SELECT * FROM member;

SELECT * FROM board;

DROP TABLE BOARD;

DROP SEQUENCE board_seq;
CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE BOARD(
    NUM NUMBER(5) PRIMARY KEY,
    PASS VARCHAR2(30),
    USERID VARCHAR2(30),
    EMAIL VARCHAR2(30),
    TITLE VARCHAR2(100),
    CONTENT VARCHAR2(1000),
    READCOUNT NUMBER(4) DEFAULT 0,
    WRITEDATE DATE DEFAULT SYSDATE
);


INSERT INTO board (num, userid, email, pass, title, content) VALUES (board_seq.NEXTVAL, 'test', 'abcd@naver.com', '1234', '첫방문', '반갑습니다');
INSERT INTO board (num, userid, email, pass, title, content) VALUES (board_seq.NEXTVAL, 'juno', 'abdd@naver.com', '1234', '게시물', '하잉');

CREATE TABLE SPMEMBER (
    ID VARCHAR2(30),
    PW VARCHAR2(30),
    NAME VARCHAR2(30),
    PHONE1 VARCHAR2(15),
    PHONE2 VARCHAR2(15),
    PHONE3 VARCHAR2(15),
    EMAIL VARCHAR2(30)
);

INSERT INTO SPMEMBER VALUES('scott', '1234', '박지성', '010', '1234', '5678', 'scott@naver.com');
INSERT INTO SPMEMBER VALUES('juno', '1234', '박지성', '010', '1234', '5678', 'scott@naver.com');
INSERT INTO SPMEMBER VALUES('test', '1234', '박지성', '010', '1234', '5678', 'scott@naver.com');
INSERT INTO SPMEMBER VALUES('admin', '1234', '박지성', '010', '1234', '5678', 'scott@naver.com');
INSERT INTO SPMEMBER VALUES('hong', '1234', '박지성', '010', '1234', '5678', 'scott@naver.com');

SELECT * FROM member;

UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = 2;

SELECT * FROM BOARD;

SELECT * FROM spmember;

SELECT * FROM BOARD ORDER BY NUM DESC;

select count(*) as totalCount from board;

SELECT * FROM BOARD ORDER BY NUM DESC;

SELECT 
SELECT  FROM BOARD ORDER BY NUM DESC

SELECT * FROM
(SELECT * FROM
(SELECT ROWNUM AS RN, T.* FROM
(SELECT * FROM board ORDER BY num DESC) T
) WHERE RN >= 0
) WHERE RN <= 2;


INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test1', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test2', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test3', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test4', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test5', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test6', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test7', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test8', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test9', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test10', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test11', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test12', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test13', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test14', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test15', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test16', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test17', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test18', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test19', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test20', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test21', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test22', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test23', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test24', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test25', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test26', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test27', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test28', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test29', 'congtent');
INSERT INTO BOARD (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 1234, 'juno', 'select@gmail.com', 'test30', 'congtent');


select * from reply;
select * from board order by num desc;

ALTER TABLE BOARD ADD
(
  REPLY NUMBER (3)
);

insert into reply (num, boardnum, userid, content) values (REPLY_SEQ.NEXTVAL, 325, 'juno', '멍청이');