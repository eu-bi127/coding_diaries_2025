use my_cat;

drop table board_guest;
create table board_guest(
	no int primary key auto_increment,         #이 문장이 들어가면 1,2,3.. 같은 숫자가 매겨진다. 아닐경우, 'no int,'만 해서 숫자가 안나오게 핤 수도 있다.
    con char(255),
    writer char(50)
);
insert into board_guest (con,writer) values ('안녕','안');
insert into board_guest (con,writer) values ('하이','가');
insert into board_guest (con,writer) values ('바이','나');
select * from board_guest;
