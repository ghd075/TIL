
/* 계정 : pdb 비번 : 1234
 * ip : 192.168.0.62
 *  경로 : C:\oraclexe\app\oracle\product\11.2.0\server\network\ADMIN\tnsnames.ora 연다
 * XE_C =
  (DESCRIPTION =
    (ADDRESS = (PROTOCOL = TCP)(HOST = 192.168.0.62)(PORT = 1521))
    (CONNECT_DATA =
      (SERVER = DEDICATED)
      (SERVICE_NAME = XE)
    )
  )
  붙여넣는다.
 * Drop Tables */

DROP TABLE likes CASCADE CONSTRAINTS;
DROP TABLE evaluation CASCADE CONSTRAINTS;
DROP TABLE reples CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE food CASCADE CONSTRAINTS;
DROP TABLE locations CASCADE CONSTRAINTS;
DROP TABLE members CASCADE CONSTRAINTS;
DROP TABLE notice CASCADE CONSTRAINTS;




/* Create Tables */

-- 게시글
CREATE TABLE board
(
	-- 게시글번호
	board_no number(3,0) NOT NULL,
	-- 제목
	title varchar2(100) NOT NULL,
	-- 게시글
	board_text clob,
	-- 이미지
	images varchar2(100),
	-- 조회수
	cnt number DEFAULT 0,
	-- 등록날짜
	b_date date NOT NULL,
	-- 유저코드
	user_code number(4,0) NOT NULL,
	-- 음식코드
	food_code varchar2(3) NOT NULL,
	-- 지역코드
	loc_code varchar2(3) NOT NULL,
	PRIMARY KEY (board_no)
);


-- 평가
CREATE TABLE evaluation
(
	-- 댓글번호
	reple_no number NOT NULL,
	-- 평가점수
	eval_score number(5,2),
	-- 상태코드
	check_code char(2) DEFAULT 'f' NOT NULL,
	PRIMARY KEY (reple_no)
);


-- 음식카테고리
CREATE TABLE food
(
	-- 음식코드
	food_code varchar2(3) NOT NULL,
	-- 음식이름
	food_name varchar2(50) NOT NULL,
	PRIMARY KEY (food_code)
);


-- 좋아요
CREATE TABLE likes
(
	-- 유저코드
	user_code number(4,0) NOT NULL,
	-- 게시글번호
	board_no number(3,0) NOT NULL
);


-- 지역
CREATE TABLE locations
(
	-- 지역코드
	loc_code varchar2(3) NOT NULL,
	-- 지역이름
	loc_name varchar2(20) NOT NULL,
	PRIMARY KEY (loc_code)
);


-- 회원
CREATE TABLE members
(
	-- 유저코드
	user_code number(4,0) NOT NULL,
	-- 유저ID
	id varchar2(13) NOT NULL,
	-- 사용자이름
	user_name varchar2(20) NOT NULL,
	-- 패스워드
	password varchar2(50) NOT NULL,
	-- 전화번호
	phone varchar2(13),
	-- 주소
	address varchar2(100),
	-- 등록날짜
	r_date date NOT NULL,
	PRIMARY KEY (user_code)
);


-- 공지사항
CREATE TABLE notice
(
	-- 공지번호
	notice_no number(2,0) NOT NULL,
	-- 공지제목
	notice_title varchar2(20) NOT NULL,
	-- 공지내용
	notice_contents clob,
	-- 등록날짜
	n_date date NOT NULL,
	PRIMARY KEY (notice_no)
);


-- 댓글
CREATE TABLE reples
(
	-- 댓글번호
	reple_no number NOT NULL,
	-- 부모번호
	p_no number NOT NULL,
	-- 그룹내 순서
	re_seq number(3,0) NOT NULL,
	-- 그룹내계층
	re_level number(2,0) NOT NULL,
	-- 댓글내용
	reple_text varchar2(255),
	-- 등록날짜
	re_date date NOT NULL,
	-- 유저코드
	user_code number(4,0) NOT NULL,
	-- 게시글번호
	board_no number(3,0) NOT NULL,
	PRIMARY KEY (reple_no)
);



/* Create Foreign Keys */

ALTER TABLE likes
	ADD FOREIGN KEY (board_no)
	REFERENCES board (board_no)
;


ALTER TABLE reples
	ADD FOREIGN KEY (board_no)
	REFERENCES board (board_no)
;


ALTER TABLE board
	ADD FOREIGN KEY (food_code)
	REFERENCES food (food_code)
;


ALTER TABLE board
	ADD FOREIGN KEY (loc_code)
	REFERENCES locations (loc_code)
;


ALTER TABLE board
	ADD FOREIGN KEY (user_code)
	REFERENCES members (user_code)
;


ALTER TABLE likes
	ADD FOREIGN KEY (user_code)
	REFERENCES members (user_code)
;


ALTER TABLE reples
	ADD FOREIGN KEY (user_code)
	REFERENCES members (user_code)
;


ALTER TABLE evaluation
	ADD FOREIGN KEY (reple_no)
	REFERENCES reples (reple_no)
;



/* Comments */

COMMENT ON TABLE board IS '게시글';
COMMENT ON COLUMN board.board_no IS '게시글번호';
COMMENT ON COLUMN board.title IS '제목';
COMMENT ON COLUMN board.board_text IS '게시글';
COMMENT ON COLUMN board.images IS '이미지';
COMMENT ON COLUMN board.cnt IS '조회수';
COMMENT ON COLUMN board.b_date IS '등록날짜';
COMMENT ON COLUMN board.user_code IS '유저코드';
COMMENT ON COLUMN board.food_code IS '음식코드';
COMMENT ON COLUMN board.loc_code IS '지역코드';
COMMENT ON TABLE evaluation IS '평가';
COMMENT ON COLUMN evaluation.reple_no IS '댓글번호';
COMMENT ON COLUMN evaluation.eval_score IS '평가점수';
COMMENT ON COLUMN evaluation.check_code IS '상태코드';
COMMENT ON TABLE food IS '음식카테고리';
COMMENT ON COLUMN food.food_code IS '음식코드';
COMMENT ON COLUMN food.food_name IS '음식이름';
COMMENT ON TABLE likes IS '좋아요';
COMMENT ON COLUMN likes.user_code IS '유저코드';
COMMENT ON COLUMN likes.board_no IS '게시글번호';
COMMENT ON TABLE locations IS '지역';
COMMENT ON COLUMN locations.loc_code IS '지역코드';
COMMENT ON COLUMN locations.loc_name IS '지역이름';
COMMENT ON TABLE members IS '회원';
COMMENT ON COLUMN members.user_code IS '유저코드';
COMMENT ON COLUMN members.id IS '유저ID';
COMMENT ON COLUMN members.user_name IS '사용자이름';
COMMENT ON COLUMN members.password IS '패스워드';
COMMENT ON COLUMN members.phone IS '전화번호';
COMMENT ON COLUMN members.address IS '주소';
COMMENT ON COLUMN members.r_date IS '등록날짜';
COMMENT ON TABLE notice IS '공지사항';
COMMENT ON COLUMN notice.notice_no IS '공지번호';
COMMENT ON COLUMN notice.notice_title IS '공지제목';
COMMENT ON COLUMN notice.notice_contents IS '공지내용';
COMMENT ON COLUMN notice.n_date IS '등록날짜';
COMMENT ON TABLE reples IS '댓글';
COMMENT ON COLUMN reples.reple_no IS '댓글번호';
COMMENT ON COLUMN reples.p_no IS '부모번호';
COMMENT ON COLUMN reples.re_seq IS '그룹내 순서';
COMMENT ON COLUMN reples.re_level IS '그룹내계층';
COMMENT ON COLUMN reples.reple_text IS '댓글내용';
COMMENT ON COLUMN reples.re_date IS '등록날짜';
COMMENT ON COLUMN reples.user_code IS '유저코드';
COMMENT ON COLUMN reples.board_no IS '게시글번호';



