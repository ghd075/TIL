create table member(
    id varchar2(10) primary key,
    passwd varchar2(10),
    name varchar2(10),
    mail varchar2(20));
create table login(
    id varchar2(10) primary key,
    passwd varchar2(10),
    role varchar2(20));