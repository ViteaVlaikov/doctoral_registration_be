CREATE SEQUENCE IF NOT EXISTS student_sequence START WITH 1 INCREMENT BY 50;

CREATE TABLE student
(
    id                BIGINT       NOT NULL,
    corporate_email   VARCHAR(255) NOT NULL,
    first_name        VARCHAR(255),
    last_name         VARCHAR(255),
    patronymic_name   VARCHAR(255),
    year_birth        INTEGER      NOT NULL,
    ident_number      VARCHAR(255),
    gender            VARCHAR(255),
    citizenship_id    INTEGER,
    diploma_series    VARCHAR(255),
    diploma_number    BIGINT       NOT NULL,
    personal_email    VARCHAR(255),
    phone_number      VARCHAR(255),
    status            INTEGER,
    remark            VARCHAR(255),
    supervisor_id     BIGINT,
    registration_type VARCHAR(255),
    year_study        VARCHAR(255),
    begin_studies     date,
    end_studies       date,
    study             VARCHAR(255),
    financing         VARCHAR(255),
    speciality        FLOAT,
    CONSTRAINT pk_student PRIMARY KEY (id)
);

ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_CITIZENSHIP FOREIGN KEY (citizenship_id) REFERENCES country (id);

ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_SPECIALITY FOREIGN KEY (speciality) REFERENCES speciality (id);

ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_SUPERVISOR FOREIGN KEY (supervisor_id) REFERENCES supervisor (id);