CREATE SEQUENCE IF NOT EXISTS science_sequence START WITH 1 INCREMENT BY 1;
CREATE TABLE science
(
    id   BIGINT NOT NULL default nextval('science_sequence'),
    name VARCHAR(255),
    CONSTRAINT pk_science PRIMARY KEY (id)
);

ALTER TABLE sciences_branch
    ADD CONSTRAINT FK_SCIENCES_BRANCH_ON_SCIENCE FOREIGN KEY (science_id) REFERENCES science (id);

insert into science(name) VALUES ('Științe Biologice, Geonomice, Chimice și Tehnologice');
insert into science(name) VALUES ('Științe Fizice, Matematice, ale Informației și Inginerești');
insert into science(name) VALUES ('Științe Economice');
insert into science(name) VALUES ('Științe Juridice');
insert into science(name) VALUES ('Științe Sociale și ale Educației');
insert into science(name) VALUES ('Științe Umanistice');