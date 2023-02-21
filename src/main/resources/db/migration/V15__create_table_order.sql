CREATE SEQUENCE IF NOT EXISTS order_sequence START WITH 1 INCREMENT BY 50;

CREATE TABLE "order"
(
    id            INTEGER NOT NULL,
    order_type_id INTEGER,
    number        VARCHAR(255),
    date          date,
    student_id    BIGINT,
    CONSTRAINT pk_order PRIMARY KEY (id)
);

ALTER TABLE "order"
    ADD CONSTRAINT FK_ORDER_ON_ORDERTYPE FOREIGN KEY (order_type_id) REFERENCES order_type (id);

ALTER TABLE "order"
    ADD CONSTRAINT FK_ORDER_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student (id);