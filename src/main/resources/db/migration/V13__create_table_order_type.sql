CREATE SEQUENCE IF NOT EXISTS order_type_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE order_type
(
    id      INTEGER NOT NULL default nextval('order_type_sequence'),
    "order" VARCHAR(100),
    CONSTRAINT pk_order_type PRIMARY KEY (id)
);
