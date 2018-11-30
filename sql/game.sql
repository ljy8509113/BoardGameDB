//게임관련 sql
create table boardgame.user(
id varchar(150) NOT NULL,
nickname varchar(30) NOT NULL ,
primary key(id, nickname)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table boardgame.notice(
    no int not null auto_increment primary key,
    title varchar(100) not null,
    description text not null,
    regdate date not null,
    game_no int default 0
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table boardgame.game(
game_no int not null auto_increment primary key,
description text null,
title varchar(50) not null,
cover_image varchar(150) null,
state varchar(3) not null,
file_name varchar(150)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table boardgame.score(
nickname varchar(30) not null,
total int not null default 0,		
win int not null default 0,		
lose int not null default 0,		
draw int not null default 0,
game_no int not null,
primary key(nickname, game_no)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;	
