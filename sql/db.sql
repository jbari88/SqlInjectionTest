CREATE DATABASE SECURE DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use SECURE;

CREATE TABLE member(
	id VARCHAR(32) NOT NULL,
	name VARCHAR(32),
	passwd VARCHAR(32),
	PRIMARY KEY(id)
);

INSERT INTO member (id, name, passwd) values ('admin','admin00','1q2w3e4r');