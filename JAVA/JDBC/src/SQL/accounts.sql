-- 계좌 정보가 저장될 accounts 테이블 생성(트랜잭션 실습을 위한 테이블
create table accounts( --accounts 테이블 생성
 ano varchar2(50) primary key -- 계좌 번호
 , owner varchar2(50) not null -- 계좌 소유주(예금주)
 , balance number(38) not null -- 예금 잔액(입금/출금)
 );
 
 select * from accounts order by balance asc;
 
 insert into accounts values('111-111-1111', '홍길동', 1000000);
 insert into accounts values('222-222-2222', '이순신', 0);
 
 commit; --트랜잭션에서 commit 명령어는 저장쿼리문을 성공반영