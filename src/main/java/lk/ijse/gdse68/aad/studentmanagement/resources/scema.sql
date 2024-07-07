DROP DATABASE IF EXISTS student_management;

CREATE DATABASE IF NOT EXISTS  student_management;

SHOW DATABASES;

USE student_management;

CREATE TABLE student(
                      id VARCHAR(50) PRIMARY KEY,
                      name VARCHAR(50),
                      email VARCHAR(155) NOT NULL,
                      city VARCHAR(55) NOT NULL,
                      level VARCHAR(55) NOT NULL


);

