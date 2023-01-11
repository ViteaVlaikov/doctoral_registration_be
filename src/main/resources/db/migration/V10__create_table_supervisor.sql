CREATE SEQUENCE IF NOT EXISTS supervisor_sequence START WITH 1 INCREMENT BY 1;
CREATE TABLE supervisor
(
    id                 BIGINT NOT NULL default nextval('supervisor_sequence'),
    first_name         VARCHAR(255),
    last_name          VARCHAR(255),
    post               VARCHAR(255),
    speciality         VARCHAR(255),
    science_id         BIGINT,
    academician        VARCHAR(255) default '',
    CONSTRAINT pk_supervisor PRIMARY KEY (id)
);

ALTER TABLE supervisor
    ADD CONSTRAINT FK_SUPERVISOR_ON_SCIENCE FOREIGN KEY (science_id) REFERENCES science (id);
