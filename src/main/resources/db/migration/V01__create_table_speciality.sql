CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE speciality
(
    id                  BIGINT NOT NULL,
    name                VARCHAR(255),
    sciences_profile_id BIGINT,
    CONSTRAINT pk_speciality PRIMARY KEY (id)
);

