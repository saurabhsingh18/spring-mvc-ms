--
-- Current Database: bookstore
--

DROP DATABASE IF EXISTS `bookstore`;

CREATE DATABASE `bookstore` CHARACTER SET utf8 COLLATE utf8_bin;

USE `bookstore`;

--
-- Table structure for table `BOOKS`
--
DROP TABLE IF EXISTS `BOOKS`;
CREATE TABLE BOOKS (
	BOOKID INT(9) NOT NULL AUTO_INCREMENT,
	TITLE VARCHAR(20) NOT NULL,
	AUTHOR VARCHAR(20) NOT NULL,
	PRICE INT(5) NOT NULL,
	TAGS VARCHAR(50) NOT NULL,
	PRIMARY KEY (BOOKID)
)ENGINE=InnoDB;

--
-- Table structure for table `PROPERTIES`
--
DROP TABLE IF EXISTS `PROPERTIES`;
CREATE TABLE PROPERTIES (
	BOOKID INT(9) NOT NULL,
	STATUS VARCHAR(10) NOT NULL,
	LANGUAGE VARCHAR(10) NOT NULL,
	TYPE VARCHAR(10) NOT NULL,
	PRIMARY KEY (BOOKID),
	KEY FK_BOOKS_PROPS_BOOKID (BOOKID),
	CONSTRAINT FK_BOOKS_PROPS_BOOKID FOREIGN KEY (BOOKID) REFERENCES BOOKS(BOOKID)
)ENGINE=InnoDB;

--
-- Table structure for table `GENRE`
--
DROP TABLE IF EXISTS `GENRE`;
CREATE TABLE GENRE(
	GENREID INT(9) AUTO_INCREMENT,
	GENRENAME VARCHAR(50) UNIQUE,
	PRIMARY KEY (GENREID)
)ENGINE=InnoDB;

--
-- Table structure for table `BINDING`
--
DROP TABLE IF EXISTS `BINDING`;
CREATE TABLE BINDING(
	BINDINGTYPE VARCHAR(50),
	PRIMARY KEY (BINDINGTYPE)
)ENGINE=InnoDB;

INSERT INTO GENRE(GENRENAME) VALUES ('Drama');
INSERT INTO GENRE(GENRENAME) VALUES ('Romance');
INSERT INTO GENRE(GENRENAME) VALUES ('Mystery');
INSERT INTO GENRE(GENRENAME) VALUES ('Horror');
INSERT INTO GENRE(GENRENAME) VALUES ('Action/Adventure');
INSERT INTO GENRE(GENRENAME) VALUES ('Health');
INSERT INTO GENRE(GENRENAME) VALUES ('Travel');
INSERT INTO GENRE(GENRENAME) VALUES ('Religion/Spirituality');
INSERT INTO GENRE(GENRENAME) VALUES ('Science');
INSERT INTO GENRE(GENRENAME) VALUES ('History');
INSERT INTO GENRE(GENRENAME) VALUES ('Poetry');
INSERT INTO GENRE(GENRENAME) VALUES ('Comics');
INSERT INTO GENRE(GENRENAME) VALUES ('Cookbooks');
INSERT INTO GENRE(GENRENAME) VALUES ('Fantasy');
INSERT INTO GENRE(GENRENAME) VALUES ('Autobiographies');
INSERT INTO GENRE(GENRENAME) VALUES ('Biographies');
INSERT INTO GENRE(GENRENAME) VALUES ('Math');

COMMIT;