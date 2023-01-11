CREATE SEQUENCE IF NOT EXISTS country_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE country
(
    id      INT NOT NULL default nextval('country_seq'),
    country    VARCHAR(30),
    CONSTRAINT pk_country PRIMARY KEY (id)
);