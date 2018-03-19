
create table boardgame.admin(
id varchar(100) not null,
password varchar(60) not null,
nickname varchar(50) not null,
fail_count int default 0,
PRIMARY KEY (id)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table boardgame.notice(
    no int not null auto_increment,
    title varchar(200) not null,
    description text not null,
    showtime date null,
    endtime date null,
    type varchar(2) not null,
    regdate date not null,
    link varchar(250) null,
    writer varchar(100) not null,
    primary key(no),
    foreign key(writer) references boardgame.admin (id)
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

create table boardgame.user(
email varchar(100) not null,
password varchar(60) not null,
nickname varchar(50) not null,
birthday date null,
join_date date null,
fail_count int default 0,
PRIMARY KEY (email)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table boardgame.history(
email varchar(100) not null,
total int,		
win int,		
lose int,		
disconnect int,		
game_no int not null,
PRIMARY KEY (email, game_no),
FOREIGN KEY (email) REFERENCES boardgame.user (email),
FOREIGN KEY (game_no) REFERENCES boardgame.game (game_no)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;		

create table boardgame.device(
	email varchar(100) not null,
    uuid varchar(100) not null,
    os varchar(10) not null,
    version varchar(20) null,
    foreign key(email) references boardgame.user(email)
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
	value ('admin', '1234', '관리자');
	
# 관리자에게 권한 부여
INSERT INTO boardgame.admin_authority
	VALUES ('admin', 10);
	
	select * from boardgame.authority;


