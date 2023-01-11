CREATE TABLE student
(
    corporate_email           VARCHAR(255) NOT NULL,
    first_name                VARCHAR(255),
    last_name                 VARCHAR(255),
    patronymic_name           VARCHAR(255),
    ident_number              VARCHAR(255),
    gender                    INT,
    citizenship               INT,
    diploma_series            VARCHAR(255),
    diploma_number            BIGINT,
    personal_email            VARCHAR(255),
    phone_number              VARCHAR(255),
    registration_type         INT,
    registration_order_number BIGINT,
    registration_order_date   TIMESTAMP,
    year_study                TIMESTAMP,
    begin_studies             TIMESTAMP,
    end_studies               TIMESTAMP,
    study                     INT,
    financing                 INT,
    school                    VARCHAR(255),
    CONSTRAINT pk_student PRIMARY KEY (corporate_email)
);