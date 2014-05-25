/* Demo Account */
INSERT INTO account (id_account, type, username, password) VALUES (1, 'internal', 'demo', '10eeb458cb670fab1b3291f28206002fa54f18862953f0c2edbd7b46d351efee');

/* Demo Projects */
INSERT INTO project (id_project, id_owner, title, description) VALUES (1, 1, 'demo', 'Projet de demo');
INSERT INTO project (id_project, id_owner, title, description) VALUES (2, 1, 'Hackathon', 'Mon super projet pour le Hackathon !');
INSERT INTO project (id_project, id_owner, title, description) VALUES (3, 1, 'Aptenodytes', 'La meilleure application au monde !');
INSERT INTO project (id_project, id_owner, title, description) VALUES (4, 1, 'Projet Societe Générale', 'Pour la meilleure entreprise au monde');

/* Fake mails */
INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('super.client@gmail.com', 1, 'Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException at Button_lable.actionPerformed(Button_lable.java:34)', 'Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException \nat Button_lable.actionPerformed(Button_lable.java:34) \nat javax.swing.AbstractButton.fireActionPerformed(Unknown Source) \nat javax.swing.AbstractButton$Handler.actionPerformed(Unknown Source) \nat javax.swing.DefaultButtonModel.fireActionPerformed(Unknown Source) \nat javax.swing.DefaultButtonModel.setPressed(Unknown Source) \nat javax.swing.plaf.basic.BasicButtonListener.mouseReleased(Unknown Source) \nat java.security.ProtectionDomain$1.doIntersectionPrivilege(Unknown Source)', 'UNREAD');
INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('dorothee@bemyapp.com', 1, 'Pensez à m envoyer les slides !', '', 'UNREAD');
INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('jerome.kerviel@socgen.com', 1, 'Vous me manquez les gars !', '', 'UNREAD');
INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('adrianna@42.fr', 1, 'Je porte porte plainte pour usurpation d\identité', '', 'UNREAD');

INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('jerome.kerviel@socgen.com', 2, 'Vous me manquez les gars !', '', 'UNREAD');

INSERT INTO mail (sender, id_project, subject, content, state) VALUES ('adrianna@42.fr', 3, 'Je porte porte plainte pour usurpation d identité', '', 'UNREAD');


commit;