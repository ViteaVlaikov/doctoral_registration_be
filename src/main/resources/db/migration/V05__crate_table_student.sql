CREATE TABLE student
(
    corporate_email           VARCHAR(255) NOT NULL,
    first_name                VARCHAR(255),
    last_name                 VARCHAR(255),
    patronymic_name           VARCHAR(255),
    ident_number              VARCHAR(255),
    gender                    VARCHAR(255),
    citizenship               VARCHAR(255),
    diploma_series            VARCHAR(255),
    diploma_number            BIGINT,
    personal_email            VARCHAR(255),
    phone_number              VARCHAR(255),
    registration_type         VARCHAR(255),
    registration_order_number BIGINT,
    registration_order_date   TIMESTAMP,
    year_study                TIMESTAMP,
    begin_studies             TIMESTAMP,
    end_studies               TIMESTAMP,
    study                     VARCHAR(255),
    financing                 VARCHAR(255),
    school                    VARCHAR(255),
    CONSTRAINT pk_student PRIMARY KEY (corporate_email)
);