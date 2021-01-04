select * from kakao_member;

create table kakao_member (name varchar2(20) not null,
                           phone varchar2(12) not null,
                           password varchar2(20) not null,
                           CONSTRAINT kakao_pk PRIMARY key (phone));
insert into kakao_member values ('김민재', '01064707235', '7235');
insert into kakao_member values ('테스트', '01077777777', '1234');

drop table kakao_member;

desc kakao_member;

commit;