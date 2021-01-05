select * from kakao_member;

create table kakao_member (name varchar2(20) not null,
                           phone varchar2(12) not null,
                           password varchar2(20) not null,
                           CONSTRAINT kakao_pk PRIMARY key (phone));
insert into kakao_member values ('김민재', '01064707235', '7235');
insert into kakao_member values ('테스트', '01077777777', '1234');
insert into kakao_member values ('고희광', '01011111111', '1234');


create table kakao_member (
	 id varchar2(20),
	pw varchar2(20),
	name varchar2(10),
	Image varchar2(40),
	phoneNumber char(13),
	talkName varchar2(20),
	primary key(id));
 
drop table kakao_member;

desc kakao_member;

commit;


-----------------------------------------------------------------
CREATE SEQUENCE user_seq START WITH 1;

CREATE TABLE usert (
user_num NUMBER PRIMARY KEY,
phonenum varchar2(11) NOT NULL UNIQUE CHECK(phonenum LIKE '010%'),
name varchar2(10) NOT NULL,
password varchar2(20) NOT NULL);

INSERT INTO usert VALUES (user_seq.nextval, '01011111111', '고희광', '1111');
INSERT INTO usert VALUES (user_seq.nextval, '01022222222', '김민재', 2222);
INSERT INTO usert VALUES (user_seq.nextval, '01033333333', '홍아현', 3333);

select * from usert;

drop table usert;

--------------------------------------------------------------

CREATE TABLE kakaouser (
    user_num NUMBER(4) NOT NULL,
    tel VARCHAR2(11) PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    PASSWORD VARCHAR2(20) NOT NULL
    );

ALTER TABLE kakaouser
    RENAME COLUMN tel TO phonenum;

CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;









