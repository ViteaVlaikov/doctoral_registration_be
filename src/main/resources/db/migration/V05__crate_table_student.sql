CREATE TABLE student
(
    corporate_email           VARCHAR(100) NOT NULL,
    first_name                VARCHAR(100) NOT NULL,
    last_name                 VARCHAR(100) NOT NULL,
    patronymic_name           VARCHAR(100),
    ident_number              VARCHAR(20),
    gender                    VARCHAR(20) NOT NULL,
    citizenship               VARCHAR(50),
    diploma_series            VARCHAR(50),
    diploma_number            BIGINT,
    personal_email            VARCHAR(100),
    phone_number              VARCHAR(30),
    registration_type         VARCHAR(20) DEFAULT 'ENROLLED',
    registration_order_number BIGINT,
    registration_order_date   TIMESTAMP,
    year_study                INT,
    begin_studies             TIMESTAMP,
    end_studies               TIMESTAMP,
    study                     VARCHAR(20),
    financing                 VARCHAR(20),
    school                    VARCHAR(255),
    CONSTRAINT pk_student PRIMARY KEY (corporate_email)
);