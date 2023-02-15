CREATE SEQUENCE IF NOT EXISTS science_domain_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE science_domain
(
    id                INTEGER NOT NULL default nextval('science_domain_sequence'),
    number            INTEGER NOT NULL,
    name              VARCHAR(255),
    science_school_id INTEGER,
    CONSTRAINT pk_science_domain PRIMARY KEY (id)
);

ALTER TABLE science_domain
    ADD CONSTRAINT FK_SCIENCE_DOMAIN_ON_SCIENCE_SCHOOL FOREIGN KEY (science_school_id) REFERENCES science_school (id);