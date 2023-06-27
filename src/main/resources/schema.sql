CREATE DATABASE report_portal;
USE report_portal;

CREATE TABLE launches (
    id int NOT NULL,
    name varchar(255),
    total int,
    passed int,
    skipped int,
    failed int,

    PRIMARY KEY (id)

);