create table board ( id number,
username varchar2(20),
contents varchar2(400)
);

insert into board values ( 1, 'html', 'html');
insert into board values ( 2, 'css','css');
insert into board values ( 3, 'javascript','javascript');
insert into board values ( 4, 'jquery','jquery');
insert into board values ( 5, 'html5','html5');
insert into board values ( 6, 'mobile','mobile');
insert into board values ( 7, 'android','android');
insert into board values ( 8, 'framework','framework');
insert into board values ( 9, 'struts','struts');
insert into board values ( 10, 'spring','spring');
insert into board values ( 11, 'ibatis','ibatis');
insert into board values ( 12, 'hibernate','hibernate');
insert into board values ( 13, 'jsp','jsp');
insert into board values ( 14, 'php','php');
insert into board values ( 15, 'asp','asp');
insert into board values ( 16, 'title1','content1');
insert into board values ( 16, 'title2','content2');
insert into board values ( 17, 'title3','content3');
insert into board values ( 18, 'title4','content4');
insert into board values ( 19, 'title5','content5');
insert into board values ( 20, 'title6','content6');
insert into board values ( 21, 'title7','content7');
insert into board values ( 22, 'title8','content8');

select * from board;

commit;