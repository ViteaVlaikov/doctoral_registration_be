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