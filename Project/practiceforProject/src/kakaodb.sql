select * from kakao_member;

create table kakao_member (phone varchar2(12) not null,
                           password varchar2(20) not null,
                           CONSTRAINT kakao_pk PRIMARY key (phone));
insert into kakao_member values ('01064707235', '7235');
insert into kakao_member values ('01077777777', '1234');

commit;