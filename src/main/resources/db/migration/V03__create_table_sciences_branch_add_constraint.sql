CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE sciences_branch
(
    id                 BIGINT NOT NULL,
    name               VARCHAR(255),
    sciences_domain_id BIGINT,
    CONSTRAINT pk_sciences_branch PRIMARY KEY (id)
);

ALTER TABLE sciences_profile
    ADD CONSTRAINT FK_SCIENCES_PROFILE_ON_SCIENCES_BRANCH FOREIGN KEY (sciences_branch_id) REFERENCES sciences_branch (id);