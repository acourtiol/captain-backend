INSERT INTO account (id_account, type, username, password) VALUES (1, 'internal', 'demo', '10eeb458cb670fab1b3291f28206002fa54f18862953f0c2edbd7b46d351efee');

INSERT INTO project (id_project, id_owner, title, description) VALUES (1, 1, 'demo', 'Projet de demo');
INSERT INTO project (id_project, id_owner, title, description) VALUES (2, 1, 'Hackathon', 'Mon super projet pour le Hackathon !');
INSERT INTO project (id_project, id_owner, title, description) VALUES (3, 1, 'Aptenodytes', 'La meilleure application au monde !');
INSERT INTO project (id_project, id_owner, title, description) VALUES (4, 1, 'Projet Societe Générale', 'Pour la meilleure entreprise au monde');
commit;