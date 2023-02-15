CREATE SEQUENCE IF NOT EXISTS science_school_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE science_school
(
    id   INTEGER NOT NULL default nextval('science_school_sequence'),
    name VARCHAR(255),
    CONSTRAINT pk_science_school PRIMARY KEY (id)
);