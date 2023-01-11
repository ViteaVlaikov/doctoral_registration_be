CREATE SEQUENCE IF NOT EXISTS speciality_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE speciality
(
    id                  FLOAT NOT NULL default nextval('speciality_sequence'),
    name                VARCHAR(255),
    sciences_profile_id FLOAT,
    CONSTRAINT pk_speciality PRIMARY KEY (id)
);