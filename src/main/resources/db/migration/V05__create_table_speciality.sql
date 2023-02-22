CREATE TABLE speciality
(
    id                 real NOT NULL,
    name               VARCHAR(255),
    science_profile_id INTEGER,
    CONSTRAINT pk_speciality PRIMARY KEY (id)
);

ALTER TABLE speciality
    ADD CONSTRAINT FK_SPECIALITY_ON_SCIENCE_PROFILE FOREIGN KEY (science_profile_id) REFERENCES science_profile (id);