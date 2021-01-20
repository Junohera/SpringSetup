SELECT * FROM member;

SELECT * FROM board;

DROP TABLE BOARD;

DROP SEQUENCE board_seq;
CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE BOARD(
    NUM NUMBER(5) PRIMARY KEY,
    PASS VARCHAR2(30),
    NAME VARCHAR2(30),
    EMAIL VARCHAR2(30),
    TITLE VARCHAR2(100),
    CONTENT VARCHAR2(1000),
    READCOUNT NUMBER(4) DEFAULT 0,
    WRITEDATE DATE DEFAULT SYSDATE
);


INSERT INTO board (num, name, email, pass, title, content) VALUES (board_seq.NEXTVAL, '홍길동', 'abcd@naver.com', '1234', '첫방문', '반갑습니다');
INSERT INTO board (num, name, email, pass, title, content) VALUES (board_seq.NEXTVAL, '홍길남', 'abdd@naver.com', '1234', '게시물', '하잉');

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

