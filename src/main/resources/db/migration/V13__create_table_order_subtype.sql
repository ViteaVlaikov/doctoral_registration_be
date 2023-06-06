CREATE SEQUENCE IF NOT EXISTS order_subtype_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE order_subtype
(
    id            INTEGER NOT NULL default nextval('order_subtype_sequence'),
    "order"       VARCHAR(100),
    order_type_id INTEGER,
    CONSTRAINT pk_order_subtype PRIMARY KEY (id)
);

ALTER TABLE order_subtype
    ADD CONSTRAINT FK_ORDER_SUBTYPE_ON_ORDERTYPE FOREIGN KEY (order_type_id) REFERENCES order_type (id);