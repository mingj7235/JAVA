
--customer db

create table customer (
    id varchar2(20),
	pw varchar2(20),
	name varchar2(10),
	img varchar2(40),
	hp varchar2(15),
	talk varchar2(20),
	CONSTRAINT customer_pk primary key(id));

insert into customer values ('3mins1', '7235','김','','01064707235','');
select * from customer;
--chatting room db

create table chattingroom (
    chat_name varchar2(200),
    img varchar2(40),
    time varchar2(30),
    id varchar2(50),
    chatid varchar2(500),
    CONSTRAINT chattingroom_fk FOREIGN KEY (id) REFERENCES customer(id),
    CONSTRAINT chattingroom_pk primary key(id, chatid));


--message format
create table messageformat(
    chatid varchar2(200),
    type number,
    send_name varchar2(20),
    time varchar2(30),
    message varchar2(500),
    CONSTRAINT messageformat_fk FOREIGN KEY (send_name, chatid) REFERENCES chattingroom(id, chatid));

create table friendlist (
    from_id varchar2(100),
    id varchar2(100),
    constraint friendlist_pk primary key (from_id, id));


 desc chattingroom;
    
    commit;