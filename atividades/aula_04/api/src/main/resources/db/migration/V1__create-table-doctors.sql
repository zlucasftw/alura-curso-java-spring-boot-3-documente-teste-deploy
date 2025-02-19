CREATE TABLE doctor (
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    md VARCHAR(10) NOT NULL UNIQUE,
    specialty VARCHAR(20) NOT NULL,
    street VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    zip VARCHAR (10) NOT NULL,
    number VARCHAR(20),
    state VARCHAR(6) NOT NULL,
    complement VARCHAR(100),
    city VARCHAR(100) NOT NULL
);