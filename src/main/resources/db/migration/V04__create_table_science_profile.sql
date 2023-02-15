CREATE TABLE science_profile
(
    id                INTEGER NOT NULL,
    name              VARCHAR(255),
    science_branch_id INTEGER,
    CONSTRAINT pk_science_profile PRIMARY KEY (id)
);

ALTER TABLE science_profile
    ADD CONSTRAINT FK_SCIENCE_PROFILE_ON_SCIENCE_BRANCH FOREIGN KEY (science_branch_id) REFERENCES science_branch (id);