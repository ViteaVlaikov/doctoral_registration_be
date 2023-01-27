CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE sciences_profile
(
    id                 FLOAT NOT NULL,
    name               VARCHAR(255),
    sciences_branch_id FLOAT,
    CONSTRAINT pk_sciences_profile PRIMARY KEY (id)
);

ALTER TABLE speciality
    ADD CONSTRAINT FK_SPECIALITY_ON_SCIENCES_PROFILE FOREIGN KEY (sciences_profile_id) REFERENCES sciences_profile (id);