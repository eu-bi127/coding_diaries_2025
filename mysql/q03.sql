use my_cat;

drop table member;
select * from member;
create table member(
n int primary key auto_increment,
id char(50) unique not null,       #unique가 들어가면 중복 허용이 안되서 같은 id로 증복 실행하면 오류남.
name char(50) not null,
age int not null,
gender char(1) not null,
tel char(20) not null,     #아무것도 없으면 열 자체가 없는거
hobby char(50) null        # 취미처럼 아무것도 입력 안해도 열이 없어지는게 아니라 null이라고 적혀짐.
);

insert into member (id,name,age,gender,tel,hobby) values('cat1','고양이',5,'여','010-1234-1234',null);
insert into member (id,name,age,gender,tel,hobby) values('cat2','개냥이',4,'남','010-1234-1234',null);
insert into member (id,name,age,gender,tel,hobby) values('cat3','호랑이',9,'남','010-1234-1234',null);