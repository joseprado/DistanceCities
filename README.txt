Hi,

It was used for the development of the API, the Google Directions API.
It was chosen due to the great variety of possibility of use, not only to return distances, but also the route and the means of transport.
Even the need for the project being minimal for the size of the library, it was used for future evolution.

For the test to be performed use the URL below

http://localhost:8081/WebServiceRest/rest/cities/{xml or json}/{km or mi}


Technologies used
Java 8
Tomcat 8
Jersey 
Mysql
JDBC Connection

script data base

create database testedev;

use testedev;


CREATE TABLE `testedev`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `latitude` DECIMAL(15,8) NOT NULL,
  `longitude` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
  
insert into city values (1,'São Paulo', -23.5505, -46.6333);
insert into city values (2,'São José do Rio Preto',-20.8118,-49.3762);
insert into city values (5,'Rio de Janeiro', -22.9116, -43.1883);