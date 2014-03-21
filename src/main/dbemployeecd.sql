drop database if exists tiendacd;
create database tiendacd;
use tiendacd;

CREATE TABLE  CD(
name VARCHAR(255) NOT NULL ,
grup VARCHAR(255) NOT NULL ,
pais VARCHAR(255) NOT NULL,
price float NOT NULL ,
  PRIMARY KEY (grup)
);

CREATE TABLE compras(
ID integer NOT NULL AUTO_INCREMENT,
numcds VARCHAR(255) NOT NULL ,
total float NOT NULL ,
  PRIMARY KEY (ID)
);




INSERT INTO CD VALUES( 'Pepito', 'grup1', 'Spain', 4.92);
INSERT INTO CD VALUES( 'Laura', 'grup2', 'Belgica', 8.11);
INSERT INTO CD VALUES( 'MAria', 'grup3', 'Italia', 6.82);
INSERT INTO CD VALUES( 'KLO', 'grup4', 'FRancia', 10.34);
INSERT INTO CD VALUES( 'KLA', 'grup5', 'Suecia', 23.19);
INSERT INTO CD VALUES( 'KLU', 'grup6', 'Luxemburg', 114.92);