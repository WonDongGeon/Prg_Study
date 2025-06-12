
/* Drop Tables */

DROP TABLE member;




/* Create Tables */

CREATE TABLE member
(
	id varchar NOT NULL,
	password varchar(255) NOT NULL,
	hp varchar(20) NOT NULL,
	email varchar(255) NOT NULL,
	address varchar(255) NOT NULL,
	pic varchar,
	PRIMARY KEY (id)
);



