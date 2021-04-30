CREATE DATABASE IF NOT EXISTS MYPROJECT;

ALTER DATABASE MYPROJECT
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON petclinic.* TO root@localhost;

USE MYPROJECT;

CREATE TABLE IF NOT EXISTS letters (
                                       id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                       letter VARCHAR(1),
    INDEX(letter)
) engine=InnoDB;