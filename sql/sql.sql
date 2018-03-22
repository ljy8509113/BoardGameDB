
create table admin(
id varchar(100) not null,
password varchar(60) not null,
nickname varchar(50) not null,
fail_count int default 0,
PRIMARY KEY (id)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

// 타입이 B면 B인것에 대해서만 보여줌
create table notice(
    no int not null auto_increment,
    title varchar(200) not null,
    description text not null,
    showtime date null,
    endtime date null,
    type varchar(2) not null,
    regdate date not null,
    link varchar(250) null,
    writer varchar(100) not null,
    game_no int default 0,
    primary key(no),
    foreign key(writer) references admin (id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table game(
game_no int not null auto_increment,
description text null,
title varchar(150) not null,
cover_image varchar(150) null,
state varchar(3) not null,
file_name varchar(150),
version varchar(10) null,
PRIMARY KEY (game_no) ) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table user(
email varchar(100) not null,
password varchar(60) not null,
nickname varchar(50) not null,
birthday date null,
join_date date null,
fail_count int default 0,
PRIMARY KEY (email)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table score(
email varchar(100) not null,
total int not null default 0,		
win int not null default 0,		
lose int not null default 0,		
disconnect int not null default 0,		
game_no int not null,
point int not null default 0,
PRIMARY KEY (email, game_no),
FOREIGN KEY (email) REFERENCES user (email),
FOREIGN KEY (game_no) REFERENCES game (game_no)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;		

create table device(
	email varchar(100) not null,
    uuid varchar(100) not null,
    os varchar(10) not null,
    version varchar(20) null,
    foreign key(email) references user(email)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

# 사용자 권한 정의한 테이블 
CREATE TABLE boardgame.authority(
	id		INT 			NOT NULL	PRIMARY KEY,
	name	VARCHAR(30)		NOT NULL
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

# 사용자 번호와 사용자 권한 아이디값을 연결하는 테이블
CREATE TABLE boardgame.admin_authority(
	admin_id		varchar(100) 	NOT NULL,
	authority_id	INT		NOT NULL,
	FOREIGN KEY (admin_id) REFERENCES boardgame.admin (id),
	FOREIGN KEY (authority_id) REFERENCES boardgame.authority (id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

# 권한 입력
INSERT INTO boardgame.authority (id, name) 
	VALUES (10, 'ADMIN');
	
# 관리자 입력
INSERT INTO boardgame.admin (id, password, nickname)
	value ('admin', '$2a$10$/XtN8X03leQWfjpIcGFCkOOihGxr3a/m/KjxYK6tpbQsubauUGxdu', '관리자');
	
# 관리자에게 권한 부여
INSERT INTO boardgame.admin_authority
	VALUES ('admin', 10);
	
	select * from boardgame.admin WHERE id = 'admin';

	select * from boardgame.game;


desc boardgame.notice;
INSERT INTO boardgame.notice (title,description, showtime, endtime, type, regdate,
		link, writer) values('공지사항-테스트1','설명-테스트1',null, null,'B',CURDATE(),"", 'admin');
		
alter table boardgame.notice modify regdate DATETIME;
		
INSERT INTO boardgame.notice (title,description, showtime, endtime, type, regdate,
		link, writer) values('공지사항-테스트2','설명-테스트2',null, null,'B',CURDATE(),"", 'admin');
		
INSERT INTO boardgame.notice (title,description, showtime, endtime, type, regdate,
		link, writer) values('공지사항-테스트3','설명-테스트3',null, null,'B',CURDATE(),"", 'admin');
		
INSERT INTO boardgame.notice (title,description, showtime, endtime, type, regdate,
		link, writer) values('공지사항-테스트4','설명-테스트4',now(), CURTIME(),'G',sysdate(),"", 'admin');

SELECT * FROM boardgame.notice WHERE game_no = 1 or game_no = 0;

<<<<<<< HEAD
SELECT * FROM boardgame.notice WHERE no ORDER BY no DESC;

=======
INSERT INTO boardgame.user (email, password, nickname, birthday, join_date, fail_count)
	values ('test@gamil.com', '1234', 'Nick', null, null, null);
INSERT INTO boardgame.user (email, password, nickname, birthday, join_date, fail_count)
	values ('test2@gamil.com', '1234', 'Lick', null, null, null);
INSERT INTO boardgame.user (email, password, nickname, birthday, join_date, fail_count)
	values ('test3@gamil.com', '1234', 'Rick', null, null, null);

SELECT * FROM boardgame.score;
SELECT s.email, s.game_no, s.total, s.lose, s.win, s.disconnect, s.point, u.nickname 
  		FROM boardgame.score s INNER JOIN user u ON s.email = u.email ORDER BY point DESC;
 
 SELECT * FROM boardgame.game;
 
 
 update boardgame.game set title = '제목', description = '내용출력 테스트 게임 테스트', state = 'D'
 	, cover_image = '1231624c2e6178.jpg' where game_no = 11;
 
 
>>>>>>> branch 'master' of https://github.com/ljy8509113/BoardGameDB.git
