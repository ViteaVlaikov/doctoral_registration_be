DROP SEQUENCE IF EXISTS student_sequence;
CREATE SEQUENCE IF NOT EXISTS student_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE student
(
    id                BIGINT  NOT NULL,
    corporate_email   VARCHAR(255),
    first_name        VARCHAR(255),
    last_name         VARCHAR(255),
    patronymic_name   VARCHAR(255),
    year_birth        INTEGER NOT NULL,
    ident_number      VARCHAR(255),
    gender            VARCHAR(255),
    citizenship_id    INTEGER,
    diploma_series    VARCHAR(255),
    diploma_number    BIGINT  NOT NULL,
    personal_email    VARCHAR(255),
    phone_number      VARCHAR(255),
    status            VARCHAR(255),
    registration_type VARCHAR(255),
    year_study        VARCHAR(255),
    begin_studies     date,
    end_studies       date,
    study             VARCHAR(255),
    financing         VARCHAR(255),
    supervisor_id     BIGINT,
    speciality        REAL,
    science_topic     VARCHAR(255),
    remark            VARCHAR(255),
    CONSTRAINT pk_student PRIMARY KEY (id)
);

ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_CITIZENSHIP FOREIGN KEY (citizenship_id) REFERENCES country (id);

ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_SPECIALITY FOREIGN KEY (speciality) REFERENCES speciality (id);

ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_SUPERVISOR FOREIGN KEY (supervisor_id) REFERENCES supervisor (id);


CREATE SEQUENCE IF NOT EXISTS student_sequence START WITH 1 INCREMENT BY 50;

CREATE TABLE steering_committee
(
    student_id    BIGINT NOT NULL,
    supervisor_id BIGINT NOT NULL,
    CONSTRAINT pk_steering_committee PRIMARY KEY (student_id, supervisor_id)
);


ALTER TABLE steering_committee
    ADD CONSTRAINT FK_STEERING_COMMITTEE_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student (id);

ALTER TABLE steering_committee
    ADD CONSTRAINT FK_STEERING_COMMITTEE_ON_SUPERVISOR FOREIGN KEY (supervisor_id) REFERENCES supervisor (id);