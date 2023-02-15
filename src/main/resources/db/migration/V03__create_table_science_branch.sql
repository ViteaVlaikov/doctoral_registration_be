CREATE TABLE science_branch
(
    id                INTEGER NOT NULL,
    name              VARCHAR(255),
    science_domain_id INTEGER,
    CONSTRAINT pk_science_branch PRIMARY KEY (id)
);

ALTER TABLE science_branch
    ADD CONSTRAINT FK_SCIENCE_BRANCH_ON_SCIENCE_DOMAIN FOREIGN KEY (science_domain_id) REFERENCES science_domain (id);