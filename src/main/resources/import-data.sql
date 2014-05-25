/* Demo Account */
INSERT INTO account (id_account, type, username, password) VALUES (1, 'internal', 'demo', '10eeb458cb670fab1b3291f28206002fa54f18862953f0c2edbd7b46d351efee');
INSERT INTO account (id_account, type, username, password) VALUES (2, 'internal', 'jeremie', '10eeb458cb670fab1b3291f28206002fa54f18862953f0c2edbd7b46d351efee');
INSERT INTO account (id_account, type, username, password) VALUES (3, 'internal', 'yann', '10eeb458cb670fab1b3291f28206002fa54f18862953f0c2edbd7b46d351efee');

/* Demo Projects */
INSERT INTO project (id_project, id_owner, title, description, compilation_state) VALUES (1, 1, 'demo', 'Projet de demo', 'SUCCESS');
INSERT INTO project (id_project, id_owner, title, description, compilation_state) VALUES (2, 1, 'Hackathon', 'Mon super projet pour le Hackathon !', 'FAIL');
INSERT INTO project (id_project, id_owner, title, description, compilation_state) VALUES (3, 1, 'Aptenodytes', 'La meilleure application au monde !', 'FAIL');
INSERT INTO project (id_project, id_owner, title, description, compilation_state) VALUES (4, 1, 'Projet Societe Générale', 'Pour la meilleure entreprise au monde', 'SUCCESS');

/* Fake mails */
INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('super.client@gmail.com', 1, 'Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException at Button_lable.actionPerformed(Button_lable.java:34)', 'Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException \nat Button_lable.actionPerformed(Button_lable.java:34) \nat javax.swing.AbstractButton.fireActionPerformed(Unknown Source) \nat javax.swing.AbstractButton$Handler.actionPerformed(Unknown Source) \nat javax.swing.DefaultButtonModel.fireActionPerformed(Unknown Source) \nat javax.swing.DefaultButtonModel.setPressed(Unknown Source) \nat javax.swing.plaf.basic.BasicButtonListener.mouseReleased(Unknown Source) \nat java.security.ProtectionDomain$1.doIntersectionPrivilege(Unknown Source)', 'UNREAD');
INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('dorothee@bemyapp.com', 1, 'Pensez à m envoyer les slides !', '', 'UNREAD');
INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('jerome.kerviel@socgen.com', 1, 'Vous me manquez les gars !', '', 'UNREAD');
INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('adrianna@42.fr', 1, 'Je porte porte plainte pour usurpation d\identité', '', 'UNREAD');

INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('jerome.kerviel@socgen.com', 2, 'Vous me manquez les gars !', '', 'UNREAD');

INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('adrianna@42.fr', 3, 'Je porte porte plainte pour usurpation d identité', '', 'UNREAD');

/* Demo Tickets */
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Optimisation chargement page', 'Utiliser Jquery min', 'OPEN', 'ENHANCEMENT', 1, 1, 1);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Améliorer la récupération des mails', 'Passer par le protocole IMAP au lieu POP', 'OPEN', 'ENHANCEMENT', 1, 1, 3);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Correction BUG ecran de login', 'Mauvais hash du password', 'RESOLVED', 'BUG', 1, 1, 1);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Améliorations graphiques', 'Harmoniser le thème du site', 'IN_PROGRESS', 'ENHANCEMENT', 1, 1, 2);

INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Optimisation chargement page', 'Utiliser Jquery min', 'OPEN', 'ENHANCEMENT', 2, 1, 1);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Améliorer la récupération des mails', 'Passer par le protocole IMAP au lieu POP', 'OPEN', 'WONTFIX', 2, 1, 3);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Correction BUG ecran de login', 'Mauvais hash du password', 'RESOLVED', 'BUG', 2, 1, 1);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Améliorations graphiques', 'Harmoniser le thème du site', 'IN_PROGRESS', 'WONTFIX', 2, 1, 2);

INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Optimisation chargement page', 'Utiliser Jquery min', 'OPEN', 'ENHANCEMENT', 3, 1, 1);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Améliorer la récupération des mails', 'Passer par le protocole IMAP au lieu POP', 'OPEN', 'QUESTION', 3, 1, 3);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Correction BUG ecran de login', 'Mauvais hash du password', 'RESOLVED', 'BUG', 3, 1, 1);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Améliorations graphiques', 'Harmoniser le thème du site', 'IN_PROGRESS', 'QUESTION', 3, 1, 2);

INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Optimisation chargement page', 'Utiliser Jquery min', 'OPEN', 'ENHANCEMENT', 4, 1, 1);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Améliorer la récupération des mails', 'Passer par le protocole IMAP au lieu POP', 'OPEN', 'BUG', 4, 1, 3);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Correction BUG ecran de login', 'Mauvais hash du password', 'RESOLVED', 'BUG', 4, 1, 1);
INSERT INTO ticket (title, description, state, type, id_project, id_creator, id_affectedTo) VALUES ('Améliorations graphiques', 'Harmoniser le thème du site', 'IN_PROGRESS', 'BUG', 4, 1, 2);

commit;