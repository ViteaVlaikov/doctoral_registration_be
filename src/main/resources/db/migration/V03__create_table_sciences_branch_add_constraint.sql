CREATE SEQUENCE IF NOT EXISTS sciences_branch_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE sciences_branch
(
    id                 FLOAT NOT NULL default nextval('sciences_branch_sequence'),
    name               VARCHAR(255),
    sciences_domain_id FLOAT,
    science_school_id         BIGINT default null,
    CONSTRAINT pk_sciences_branch PRIMARY KEY (id)
);
