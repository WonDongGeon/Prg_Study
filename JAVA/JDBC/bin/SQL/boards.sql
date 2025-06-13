-- boards 테이블 생성(자료실 => 게시판)
create table boards(
	bno number(38) primary key --번호
	, bwriter varchar2(38) not null --글쓴이
	, btitle varchar2(200) not null --글제목
	, bcontent varchar2(4000) not null --글내용
	, bdate date default sysdate --등록날짜, date는 오라클 날짜 타입, sysdate는 오라클 날짜함수, default sysdate 제약조건을 주면
	--해당 컬럼에 굳이 날짜/시간값을 저장하지 않아도 기본값 날짜/시간값이 저장된다.
	, bfilename varchar2(200) null -- 첨부파일명
	, bfiledata blob null --blob은 오라클에서 대용량 이진 데이터를 저장할 수 있는 자료형이다. BLOB은 'Binary  Large Object'의 약자 이다.
	-- 최대 4GB까지 저장 가능하다. 수눗 이진 데이터이므로 테스트가 아닌 파일데이터(그림, 동영상, 오디오, PDF, 워드 파일 등)을 그대로 저장가능하다.
);

select * from boards order by bno desc;

--seq_bno 시퀀스 생성
create sequence seq_bno
start with 1
increment by 1
nocache
nocycle;

--seq_bno
select seq_bno.nextval as "다음 시퀀스 번호값" from dual;

create table tbl_board7 (
	bno number(38) primary key
	,bname varchar2(50) not null
	,btitle varchar2(200) not null
	,bcont varchar2(4000) not null
	,bdate date default sysdate
);

create sequence bno_seq2 
start with 1
increment by 1
nocache
nocycle;

select bno_seq2.nextval from dual;

select * from tbl_board7 order by bno desc;

update tbl_board7 set bname = '수정 홍길동', btitle = '수정 제목', bcont = '수정 내용' where bno = 3;

drop table tbl_board7;

drop table boards;