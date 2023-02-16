INSERT INTO order_type (id, "order")
VALUES (nextval('order_type_sequence'), 'Inmatriculat in anul I');
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Înmatriculare', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Aprobarea conducătorului', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Schimbarea conducătorului', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Aprobarea membrilor comisiei de îndrumare', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Modificarea componenței comisie de îndrumare', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Modificarea specialității', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Trasfer forma de învățământ', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Concediu academic', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Concediu boală', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Mobilitatea academică', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Exmatriculare', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Restabilire', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Promovare în anul II', 1);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Transfer din altă instituție', 1);

INSERT INTO order_type (id, "order")
VALUES (nextval('order_type_sequence'), 'Inmatriculat in anul II');
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Înmatriculare/trasfer din altă instituție', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Aprobarea conducătorului', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Schimbarea conducătorului', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Aprobarea membrilor comisiei de îndrumare', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Modificarea componenței comisie de îndrumare', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Modificarea specialității', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Trasfer forma de învățământ', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Concediu academic', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Concediu boală', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Mobilitatea academică', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Exmatriculare', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Restabilire', 2);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Promovare în anul III', 2);

INSERT INTO order_type (id, "order")
VALUES (nextval('order_type_sequence'), 'Inmatriculat in anul III');
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Înmatriculare/trasfer din altă instituție', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Aprobarea conducătorului', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Schimbarea conducătorului', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Aprobarea membrilor comisiei de îndrumare', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Modificarea componenței comisie de îndrumare', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Modificarea specialității', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Trasfer forma de învățământ', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Concediu academic', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Concediu boală', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Mobilitatea academică', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Exmatriculare', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Restabilire', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Promovare în anul IV', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Promovat în perioada de grație', 3);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Susținerea publică a tezei de doctorat', 3);


INSERT INTO order_type (id, "order")
VALUES (nextval('order_type_sequence'), 'Inmatriculat in anul IV');
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Înmatriculare/trasfer din altă instituție', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Aprobarea conducătorului', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Schimbarea conducătorului', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Aprobarea membrilor comisiei de îndrumare', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Modificarea componenței comisie de îndrumare', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Modificarea specialității', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Trasfer forma de învățământ', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Concediu academic', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Concediu boală', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Mobilitatea academică', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Exmatriculare', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Restabilire', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Promovat în perioada de grație', 4);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Susținerea publică a tezei de doctorat', 4);

INSERT INTO order_type (id, "order")
VALUES (nextval('order_type_sequence'), 'Exmatriculat');
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Pentru restanțe academice', 5);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Din propria inițiativă', 5);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Nerevenire din concediu academic', 5);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Pentru neachitarea taxei', 5);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Susținerea tezei înainte de termen', 5);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Finalizarea perioadei de studii', 5);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Alte motive', 5);

INSERT INTO order_type (id, "order")
VALUES (nextval('order_type_sequence'), 'Transfer');
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('la alta specialitate', 6);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('forma de studii frecvență', 6);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('forma de studii frecvență redusă', 6);

INSERT INTO order_type (id, "order")
VALUES (nextval('order_type_sequence'), 'Schimbare datele personale');
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Numele de familie', 7);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Prenumele', 7);
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Patronimicul', 7);

INSERT INTO order_type (id, "order")
VALUES (nextval('order_type_sequence'), 'Revocare');
    INSERT INTO order_subtype ("order", order_type_id)
    VALUES ('Revocare ordin', 8);