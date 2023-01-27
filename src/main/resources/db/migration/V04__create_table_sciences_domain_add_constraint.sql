CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE sciences_domain
(
    id   FLOAT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_sciences_domain PRIMARY KEY (id)
);

ALTER TABLE sciences_branch
    ADD CONSTRAINT FK_SCIENCES_BRANCH_ON_SCIENCES_DOMAIN FOREIGN KEY (sciences_domain_id) REFERENCES sciences_domain (id);