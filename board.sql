create table board
(
	num 		number			 primary key,
	name 		varchar2(10),
	title 		varchar2(100),
	content 	varchar2(1000),
	hits 		number 			 default 0,
	wdate 		date 			 default sysdate,
	attachment  varchar2(50)
)

-- 시퀀스 생성
create sequence board_seq

insert into board
values(board_seq.nextval,'홍길동','제목','게시판',default,default,'첨부')
 
select * from board
order by num desc

delete board

drop table board



