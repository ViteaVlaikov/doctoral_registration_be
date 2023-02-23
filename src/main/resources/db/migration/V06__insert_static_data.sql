insert into science_school(id, name)
values (1, 'Științe Biologice, Geonomice, Chimice și Tehnologice');
    insert into science_domain(id, number, name, science_school_id)
    VALUES (1, 1,'Științe ale naturii', 1);
        insert into science_branch(id, name, science_domain_id)
        VALUES (14, 'Ştiinţe chimice', 1);
            insert into science_profile(id, name, science_branch_id)
            VALUES (141, 'Chimie anorganică', 14);
                insert into speciality(id, name, science_profile_id)
                VALUES (141.01,'Chimie anorganică', 141);
                insert into speciality(id, name, science_profile_id)
                VALUES (141.02,'Chimie coordinativă', 141);
            insert into science_profile(id, name, science_branch_id)
            VALUES (143, 'Chimie organică', 14);
                insert into speciality(id, name, science_profile_id)
                VALUES (143.01,'Chimie organică', 143);
                insert into speciality(id, name, science_profile_id)
                VALUES (143.04,'Chimie bioorganică ,chimia compușilor naturali și filozofic activi', 143);
            insert into science_profile(id, name, science_branch_id)
            VALUES (145, 'Chimie ecologică', 14);
                insert into speciality(id, name, science_profile_id)
                VALUES (145.01,'Chimie ecologică',145);
        insert into science_branch(id, name, science_domain_id)
        VALUES (15, 'Științe geonomice', 1);
            insert into science_profile(id, name, science_branch_id)
            VALUES (153, 'Geografie', 15);
                insert into speciality(id, name, science_profile_id)
                VALUES (153.05,'Meteorologie, climatologie, agroclimatologi',153);
            insert into science_profile(id, name, science_branch_id)
            VALUES (155, 'Pedologie', 15);
                insert into speciality(id, name, science_profile_id)
                VALUES (155.01,'Pedologie',155);
        insert into science_branch(id, name, science_domain_id)
        VALUES (16, 'Ştiinţe biologice', 1);
            insert into science_profile(id, name, science_branch_id)
            VALUES (162, 'Genetică', 16);
                insert into speciality(id, name, science_profile_id)
                VALUES (162.01,'Genetică vegetal',162);
            insert into science_profile(id, name, science_branch_id)
            VALUES (163, 'Biologie celulară', 16);
                insert into speciality(id, name, science_profile_id)
                VALUES (163.01,'Biologie molecular',163);
                insert into speciality(id, name, science_profile_id)
                VALUES (163.04,'Microbiologie',163);
            insert into science_profile(id, name, science_branch_id)
            VALUES (164, 'Biologie vegetală', 16);
                insert into speciality(id, name, science_profile_id)
                VALUES (164.01,'Botanică',164);
                insert into speciality(id, name, science_profile_id)
                VALUES (164.02,'Fiziologie vegetală',164);
            insert into science_profile(id, name, science_branch_id)
            VALUES (165, 'Biologia omului și animalelor', 16);
                insert into speciality(id, name, science_profile_id)
                VALUES (165.01,'Fiziologia omului și animalelor',165);
                insert into speciality(id, name, science_profile_id)
                VALUES (165.02,'Zoologie',165);
                insert into speciality(id, name, science_profile_id)
                VALUES (165.03,'Ihtiologie',165);
                insert into speciality(id, name, science_profile_id)
                VALUES (165.04,'Entomologie',165);
            insert into science_profile(id, name, science_branch_id)
            VALUES (166, 'Ecologia și protecția mediului', 16);
                insert into speciality(id, name, science_profile_id)
                VALUES (166.01,'Ecologie',166);
                insert into speciality(id, name, science_profile_id)
                VALUES (166.02,'Protecţia mediului şi folosirea raţională a resurselor naturale',166);
                insert into science_profile(id, name, science_branch_id)
                VALUES (167, 'Biotehnologie', 16);
            insert into speciality(id, name, science_profile_id)
            VALUES (167.01,'Biotehnologie, bionanotehnologie',167);

insert into science_school(id, name)
values (2, 'Științe Fizice, Matematice, ale Informației și Inginerești');
    insert into science_domain(id, number, name, science_school_id)
    VALUES (2, 1,'Științe ale naturii', 2);
        insert into science_branch(id, name, science_domain_id)
        VALUES (11, 'Matematică', 2);
            insert into science_profile(id, name, science_branch_id)
            VALUES (111, 'Matematică pură', 11);
                insert into speciality(id, name, science_profile_id)
                VALUES (111.03,'Logică matematică, algebră și teoria numerelor',111);
            insert into science_profile(id, name, science_branch_id)
            VALUES (112, 'Matematică aplicată', 11);
                insert into speciality(id, name, science_profile_id)
                VALUES (112.03,'Cibernetică matematică și cercetări operaționale',112);
        insert into science_branch(id, name, science_domain_id)
        VALUES (12, 'Ştiinţa informaţiei', 2);
            insert into science_profile(id, name, science_branch_id)
            VALUES (121, ' Informatică teoretică', 12);
                insert into speciality(id, name, science_profile_id)
                VALUES (121.03,'Programarea calculatoarelor',121);
                insert into speciality(id, name, science_profile_id)
                VALUES (122.03,'Modelare, metode matematice, produse program',121);
        insert into science_branch(id, name, science_domain_id)
        VALUES (13, 'Ştiinţe fizice', 2);
            insert into science_profile(id, name, science_branch_id)
            VALUES (131, 'Fizică teoretic', 13);
                insert into speciality(id, name, science_profile_id)
                VALUES (131.03,'Fizică statistică și cinetică',131);
            insert into science_profile(id, name, science_branch_id)
            VALUES (133, 'Fizica sistemelor macroscopice', 13);
                insert into speciality(id, name, science_profile_id)
                VALUES (133.04,'Fizica stării solide',133);
            insert into science_profile(id, name, science_branch_id)
            VALUES (134, 'Ecologia și protecția mediului', 13);
                insert into speciality(id, name, science_profile_id)
                VALUES (134.01,'Fizica și tehnologia materialelor',134);
    insert into science_domain(id, number, name, science_school_id)
    VALUES (3, 2,'Științe inginerești și tehnologii ', 2);
        insert into science_branch(id, name, science_domain_id)
        VALUES (23, 'Inginerie electronică și a informației', 2);
            insert into science_profile(id, name, science_branch_id)
            VALUES (232, 'Calculatoare și tehnologii informaționale', 23);
                insert into speciality(id, name, science_profile_id)
                VALUES (232.02,'Tehnologii, produse și sisteme informațional',232);


insert into science_school(id, name)
values (3, 'Științe Economice');
    insert into science_domain(id, number, name, science_school_id)
    VALUES (4, 5,'Științe sociale și economice', 3);
        insert into science_branch(id, name, science_domain_id)
        VALUES (52, 'Ştiinţe economice', 4);
            insert into science_profile(id, name, science_branch_id)
            VALUES (521, 'Economie, business, administrar', 52);
                insert into speciality(id, name, science_profile_id)
                VALUES (521.01,'Teorie economică și politici economice',521);
                insert into speciality(id, name, science_profile_id)
                VALUES (521.02,'Economie mondială; relații economice internaționale',521);
                insert into speciality(id, name, science_profile_id)
                VALUES (521.03,'Economie și management în domeniul de activitate',521);
                insert into speciality(id, name, science_profile_id)
                VALUES (521.04,'Marketing și logistică',521);
            insert into science_profile(id, name, science_branch_id)
            VALUES (522, 'Finanțe, contabilitate, analiză economică', 52);
                insert into speciality(id, name, science_profile_id)
                VALUES (522.01,'Finanțe',522);
                insert into speciality(id, name, science_profile_id)
                VALUES (522.02,'Contabilitate; audit; analiză economică',522);


insert into science_school(id, name)
values (4, 'Științe Juridice');
    insert into science_domain(id, number, name, science_school_id)
    VALUES (5, 5,'Științe sociale și economice', 4);
        insert into science_branch(id, name, science_domain_id)
        VALUES (55, 'Ştiinţe juridice', 5);
            insert into science_profile(id, name, science_branch_id)
            VALUES (551, 'Economie, business, administrar', 55);
                insert into speciality(id, name, science_profile_id)
                VALUES (551.01,'Teoria generală a dreptului',551);
            insert into science_profile(id, name, science_branch_id)
            VALUES (552, 'Drept public', 55);
                insert into speciality(id, name, science_profile_id)
                VALUES (552.01,'Drept constituțional',552);
                insert into speciality(id, name, science_profile_id)
                VALUES (552.02,'Drept administrativ',552);
                insert into speciality(id, name, science_profile_id)
                VALUES (552.03,'Drept financiar (bancar, fiscal, vamal)',552);
                insert into speciality(id, name, science_profile_id)
                VALUES (552.07,'Drept contravenţional',552);
                insert into speciality(id, name, science_profile_id)
                VALUES (552.08,'Drept internațional și european public',552);
            insert into science_profile(id, name, science_branch_id)
            VALUES (553, 'Drept privat', 55);
                insert into speciality(id, name, science_profile_id)
                VALUES (553.01,'Drept civil',553);
                insert into speciality(id, name, science_profile_id)
                VALUES (553.02,'Dreptul afacerilor',553);
                insert into speciality(id, name, science_profile_id)
                VALUES (553.03,'Drept procesual civil',553);
                insert into speciality(id, name, science_profile_id)
                VALUES (553.04,'Dreptul familiei',553);
                insert into speciality(id, name, science_profile_id)
                VALUES (553.05,'Dreptul muncii și protecției sociale',553);
                insert into speciality(id, name, science_profile_id)
                VALUES (553.06,'Drept internațional și european privat',553);
            insert into science_profile(id, name, science_branch_id)
            VALUES (554, 'Drept penal', 55);
                insert into speciality(id, name, science_profile_id)
                VALUES (554.01,'Drept penal şi execuţional penal',554);
                insert into speciality(id, name, science_profile_id)
                VALUES (554.02,'Criminologie',554);
                insert into speciality(id, name, science_profile_id)
                VALUES (554.03,'Drept procesual penal',554);
                insert into speciality(id, name, science_profile_id)
            VALUES (554.04,'Criminalistică, expertiza judiciară, investigații operative',554);


insert into science_school(id, name)
values (5, 'Științe Sociale și ale Educației');
    insert into science_domain(id, number, name, science_school_id)
    VALUES (6, 5,'Științe sociale și economice', 5);
        insert into science_branch(id, name, science_domain_id)
        VALUES (51,  'Psihologie', 6);
            insert into science_profile(id, name, science_branch_id)
            VALUES (511, 'Drept penal', 51);
                insert into speciality(id, name, science_profile_id)
                VALUES (511.01,'Psihologie generală',511);
        insert into science_branch(id, name, science_domain_id)
        VALUES (53,  'Științe ale educației', 6);
            insert into science_profile(id, name, science_branch_id)
            VALUES (531, 'Pedagogie generală', 53);
                insert into speciality(id, name, science_profile_id)
                VALUES (531.01,'Teoria generală a educației',531);
            insert into science_profile(id, name, science_branch_id)
            VALUES (533, 'Pedagogie profesională', 53);
                insert into speciality(id, name, science_profile_id)
                VALUES (533.01,'Pedagogie universitară',533);
                insert into speciality(id, name, science_profile_id)
                VALUES (533.03,'Pedagogia adulţilor',533);
        insert into science_branch(id, name, science_domain_id)
        VALUES (54,  'Sociologie', 6);
            insert into science_profile(id, name, science_branch_id)
            VALUES (541, 'Sociologie', 54);
                insert into speciality(id, name, science_profile_id)
                VALUES (541.01,'Teoria și metodologia sociologiei',541);
                insert into speciality(id, name, science_profile_id)
                VALUES (541.02,'Structură socială, instituții și procese sociale',541);
            insert into science_profile(id, name, science_branch_id)
            VALUES (542, 'Asistență socială', 54);
                insert into speciality(id, name, science_profile_id)
                VALUES (542.01,'Teoria și practica asistenței sociale',542);
        insert into science_branch(id, name, science_domain_id)
        VALUES (56,  'Științe politice', 6);
            insert into science_profile(id, name, science_branch_id)
            VALUES (561, 'Politologie', 56);
                insert into speciality(id, name, science_profile_id)
                VALUES (561.01,'Teoria, metodologia și istoria politologiei; instituții și procese politice',561);
            insert into science_profile(id, name, science_branch_id)
            VALUES (562, 'Relații internaționale', 56);
                insert into speciality(id, name, science_profile_id)
                VALUES (562.01,'Teoria și metodologia relațiilor internaționale și a diplomației',562);
                insert into speciality(id, name, science_profile_id)
                VALUES (562.02,'Istoria relaţiilor internaţionale şi politicii externe',562);
                insert into speciality(id, name, science_profile_id)
                VALUES (562.03,'Probleme și strategii ale dezvoltării globale și regionale',562);
            insert into science_profile(id, name, science_branch_id)
            VALUES (563, 'Ştiinţe administrative', 56);
                insert into speciality(id, name, science_profile_id)
                VALUES (563.01,'Teoria, metodologia administraţiei publice',563);
                insert into speciality(id, name, science_profile_id)
                VALUES (563.02,'Organizarea şi dirijarea în instituţiile administraţiei publice; servicii publice',563);
        insert into science_branch(id, name, science_domain_id)
        VALUES (57,  'Media şi comunicare', 6);
            insert into science_profile(id, name, science_branch_id)
            VALUES (571, 'Jurnalism şi comunicare', 57);
                insert into speciality(id, name, science_profile_id)
                VALUES (571.01,'Jurnalism şi procese mediatice',571);
                insert into speciality(id, name, science_profile_id)
                VALUES (571.02,'Comunicare și relații publice',571);
            insert into science_profile(id, name, science_branch_id)
            VALUES (572, 'Științe ale informării și documentări', 57);
                insert into speciality(id, name, science_profile_id)
                VALUES (572.02,'Infodocumentare; biblioteconomie și știința informării',572);


insert into science_school(id, name)
values (6, 'Științe Umanistice');
    insert into science_domain(id, number, name, science_school_id)
    VALUES (7, 6,'Științe umaniste', 6);
        insert into science_branch(id, name, science_domain_id)
        VALUES (61,  'Istorie şi arheologie', 7);
            insert into science_profile(id, name, science_branch_id)
            VALUES (611, 'Istorie', 61);
                insert into speciality(id, name, science_profile_id)
                VALUES (611.02,'Istoria românilor (pe perioade)',571);
                insert into speciality(id, name, science_profile_id)
                VALUES (611.07,'Istoria științei și tehnicii (pe domenii)',571);
            insert into science_profile(id, name, science_branch_id)
            VALUES (612, 'Etnologie', 61);
                insert into speciality(id, name, science_profile_id)
                VALUES (612.01,'Etnologie',612);
            insert into science_profile(id, name, science_branch_id)
            VALUES (613, 'Arheologie', 61);
                insert into speciality(id, name, science_profile_id)
                VALUES (613.01,'Arheologie',613);
        insert into science_branch(id, name, science_domain_id)
        VALUES (62,  'Filologie', 7);
            insert into science_profile(id, name, science_branch_id)
            VALUES (621, 'Științe ale limbajului', 62);
                insert into speciality(id, name, science_profile_id)
                VALUES (621.03,'Fonetică şi fonologie; dialectologie; istoria limbii; sociolingvistică; etnolingvistică (cu specificarea limbii după caz)',621);
                insert into speciality(id, name, science_profile_id)
                VALUES (621.04,'Lexicologie şi lexicografie; terminologie şi limbaje specializate; traductologie (cu specificarea limbii după caz)',621);
                insert into speciality(id, name, science_profile_id)
                VALUES (621.05,'Semiotică; semantică; pragmatică (cu specificarea limbii după caz)',621);
                insert into speciality(id, name, science_profile_id)
                VALUES (621.06,'Teoria textului; analiza discursului; stilistică (cu specificarea limbii, după caz – limba franceză)',621);
            insert into science_profile(id, name, science_branch_id)
            VALUES (622, 'Literatură', 62);
                insert into speciality(id, name, science_profile_id)
                VALUES (622.01,'Literatura română',622);
                insert into speciality(id, name, science_profile_id)
                VALUES (622.03,'Teoria literaturii',622);
                insert into speciality(id, name, science_profile_id)
                VALUES (622.04,'Folcloristică',622);
        insert into science_branch(id, name, science_domain_id)
        VALUES (63,  'Filosofie', 7);
            insert into science_profile(id, name, science_branch_id)
            VALUES (631, 'Filosofie', 63);
                insert into speciality(id, name, science_profile_id)
                VALUES (631.01,'Ontologie și gnoseologie',631);
                insert into speciality(id, name, science_profile_id)
                VALUES (631.02,'Filosofie istorică',631);
                insert into speciality(id, name, science_profile_id)
                VALUES (631.05,'Filosofie socială, antropologie filosofică și filosofia culturii',631);

-- Довести sequences до действительных значений:
-- school_sequence до last_value 6:

SELECT nextval('science_school_sequence');
SELECT nextval('science_school_sequence');
SELECT nextval('science_school_sequence');
SELECT nextval('science_school_sequence');
SELECT nextval('science_school_sequence');
SELECT nextval('science_school_sequence');

-- domain_sequence до last_value 7:

SELECT nextval('science_domain_sequence');
SELECT nextval('science_domain_sequence');
SELECT nextval('science_domain_sequence');
SELECT nextval('science_domain_sequence');
SELECT nextval('science_domain_sequence');
SELECT nextval('science_domain_sequence');
SELECT nextval('science_domain_sequence');