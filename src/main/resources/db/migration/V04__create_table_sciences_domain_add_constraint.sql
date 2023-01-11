CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE doctoral_school
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_doctoral_school PRIMARY KEY (id)
);


ALTER TABLE sciences_branch
    ADD CONSTRAINT FK_SCIENCES_BRANCH_ON_SCIENCES_DOMAIN FOREIGN KEY (sciences_domain_id) REFERENCES doctoral_school (id);