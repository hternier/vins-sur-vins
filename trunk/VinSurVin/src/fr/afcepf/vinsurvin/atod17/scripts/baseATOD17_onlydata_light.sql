USE atod17_g2_vins;

INSERT INTO TYPECOMPTE VALUES (null, 'Client');
INSERT INTO TYPECOMPTE VALUES (null, 'Interne');

INSERT INTO ETATCOMPTE VALUES (null, 'Actif');
INSERT INTO ETATCOMPTE VALUES (null, 'Desactif');

INSERT INTO VILLE VALUES (null, '75010', 'PARIS 10EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75011', 'PARIS 11EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75012', 'PARIS 12EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75013', 'PARIS 13EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75014', 'PARIS 14EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75015', 'PARIS 15EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75116', 'PARIS 16EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75016', 'PARIS 16EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75017', 'PARIS 17EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75018', 'PARIS 18EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75019', 'PARIS 19EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75001', 'PARIS 1ER ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75020', 'PARIS 20EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75002', 'PARIS 2EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75003', 'PARIS 3EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75004', 'PARIS 4EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75005', 'PARIS 5EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75006', 'PARIS 6EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75007', 'PARIS 7EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75008', 'PARIS 8EME ARRONDISSEMENT', 'FRANCE');
INSERT INTO VILLE VALUES (null, '75009', 'PARIS 9EME ARRONDISSEMENT', 'FRANCE');

INSERT INTO ADRESSE VALUES (null, 1, null, '255 rue du faubourg saint-martin', null);

INSERT INTO COMPTE VALUES (null, 1, 1, 1, 1, 'Chalet', 'Nicolas', 'client', 'afcepf', '0123456789', 'Client', current_timestamp, null);
INSERT INTO COMPTE VALUES (null, 2, null, null, 1, 'Ternier', 'Hadrien', 'interne', 'afcepf', '0123456789', 'Gestionnaire', null, null);

INSERT INTO TYPELIVRAISON VALUES (null, 'Colisimo');
INSERT INTO TYPELIVRAISON VALUES (null, 'Chronoposte');

INSERT INTO TARIFLIVRAISON VALUES (null, 1, 'La poste', 1, 10, 5);
INSERT INTO TARIFLIVRAISON VALUES (null, 1, 'La poste', 11, 20, 10);
INSERT INTO TARIFLIVRAISON VALUES (null, 1, 'La poste', 21, 30, 14.5);
INSERT INTO TARIFLIVRAISON VALUES (null, 1, 'La poste', 31, 1000, 20);
INSERT INTO TARIFLIVRAISON VALUES (null, 2, 'La poste', 1, 10, 7.55);
INSERT INTO TARIFLIVRAISON VALUES (null, 2, 'La poste', 11, 20, 14.65);
INSERT INTO TARIFLIVRAISON VALUES (null, 2, 'La poste', 21, 30, 21.10);
INSERT INTO TARIFLIVRAISON VALUES (null, 2, 'La poste', 31, 1000, 30);

INSERT INTO ETATCOMMANDE VALUES (null, 'En attente de validation');
INSERT INTO ETATCOMMANDE VALUES (null, 'En attente de paiement');
INSERT INTO ETATCOMMANDE VALUES (null, 'En préparation');
INSERT INTO ETATCOMMANDE VALUES (null, 'En livraison');
INSERT INTO ETATCOMMANDE VALUES (null, 'Traité');
INSERT INTO ETATCOMMANDE VALUES (null, 'Annulé');

INSERT INTO COMMANDE VALUES (null, 1, 5, 1, 2, '2013-03-23 09:22:01');
INSERT INTO COMMANDE VALUES (null, 1, 4, 1, 7, '2013-03-29 10:36:37');
INSERT INTO COMMANDE VALUES (null, 1, 6, 1, 5, '2013-04-01 22:36:44');
INSERT INTO COMMANDE VALUES (null, 1, 3, 1, 3, '2013-04-03 10:31:00');
INSERT INTO COMMANDE VALUES (null, 1, 2, 1, 1, current_timestamp);



INSERT INTO TVA VALUES (null, 0.196);
INSERT INTO TVA VALUES (null, 0.055);

INSERT INTO TYPEPRODUIT VALUES (null, 'Vin');
INSERT INTO TYPEPRODUIT VALUES (null, 'Spiritueux');
INSERT INTO TYPEPRODUIT VALUES (null, 'Accessoire');

INSERT INTO CATEGORIEPRODUIT VALUES (null,1 , 'Vin rouge');
INSERT INTO CATEGORIEPRODUIT VALUES (null,1 , 'Vin blanc');
INSERT INTO CATEGORIEPRODUIT VALUES (null,1 , 'Vin rosé');
INSERT INTO CATEGORIEPRODUIT VALUES (null,1 , 'Vin blanc effervescent');
INSERT INTO CATEGORIEPRODUIT VALUES (null,2 , 'Armagnac');
INSERT INTO CATEGORIEPRODUIT VALUES (null,2 , 'Cognac');
INSERT INTO CATEGORIEPRODUIT VALUES (null,2 , 'Rhum');
INSERT INTO CATEGORIEPRODUIT VALUES (null,2 , 'Whisky');
INSERT INTO CATEGORIEPRODUIT VALUES (null,3,'Accessoire vin');
INSERT INTO CATEGORIEPRODUIT VALUES (null,3,'raffraichisseur');
INSERT INTO CATEGORIEPRODUIT VALUES (null,3,'Tire bouchon');
INSERT INTO CATEGORIEPRODUIT VALUES (null,3,'Verre');
INSERT INTO CATEGORIEPRODUIT VALUES (null,3,'Carafe');

INSERT INTO PRODUIT VALUES (1,1,1,1,'Château Bellerm Bordeaux Supérieur 2009',35,'2013-04-05 11:46:45','Récolté uniquement sur de très vieilles vignes, vendanges et tri manuels. Excellent pour toutes les années goûtées de 2002 à 2005. Premier nez de fruits rouges, deuxième nez épices douces (cannelle, vanille). Très grande longueur en bouche.','coccinelle-de-la-grolet_1_1_1.jpg',1,'France','Bordeaux','Bordeaux','2009',75,NULL,NULL,NULL,NULL,NULL,NULL,'12');
INSERT INTO PRODUIT VALUES (2,1,2,8,'LINLITHGOW 25 ans 1982',24,'2013-04-05 11:46:45','Plus corsé que subtil, ce Linlithgow âgé de 25 ans bouleverse les habituels clichés à propos des single malts des Lowlands, souvent qualifiés de légers, sucrés voire évanescents. Il faut en effet apprivoiser sa puissance tannique et son tempérament de feu pour savourer pleinement toute la richesse de son fruité. ','hine-vsop_1.jpg',1,NULL,NULL,NULL,NULL,NULL,'Malt Whisky','1982','59',70,NULL,NULL,NULL);
INSERT INTO PRODUIT VALUES (3,1,1,1,'Château Gugès Haut-Médoc 2004',256,'2013-04-05 11:46:45','Issu d\'une exploitation de 5 hectares, ce vin d\'une grande finesse arômatique est vinifié et élevé de façon très artisanale. Vendanges manuelles, pas de filtration, on y retrouve tout le caractère du terroir graveleux de Cissac-Médoc.','closdesboutes-pluriel_1_1.jpg',1,'France','Médoc','Haut-Médoc','2004',75,NULL,NULL,NULL,NULL,NULL,NULL,'12');
INSERT INTO PRODUIT VALUES (4,1,3,12,'Verre INAO 12 cl x6',30,'2013-04-05 11:46:45','Verre INAO 12 cl - Verre dégustation Conditionnement : Lot de 6 Matériaux : Verre Couleur(s) : Incolore Contenance : 12cl Diamètre : 5,3cm Hauteur : 13,1cm Entretien : Lavable en machine Conseils d utilisation : Ne pas entrechoquer','verres.jpg',5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'INAO',350,NULL);
INSERT INTO PRODUIT VALUES (5,1,3,13,'Carafe à décanter',10,'2013-04-05 11:46:45','Moderne et originale avec sa coupe en biais, cette carafe en cristallin saura vous séduire. Le passage en carafe d un vin plutôt jeune va avoir plusieurs effets : il va réveiller ses arômes, le vin va nous paraître plus ouvert.','carafe_1.jpg',4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'Swarowzky',200,NULL);
INSERT INTO PRODUIT VALUES (6,1,1,2,'Château Gugès Haut-Médoc 2004',254,'2013-04-05 11:46:45','Issu d\'une exploitation de 5 hectares, ce vin d\'une grande finesse arômatique est vinifié et élevé de façon très artisanale. Vendanges manuelles, pas de filtration, on y retrouve tout le caractère du terroir graveleux de Cissac-Médoc.','viognier-delas_1.jpg',1,'France','Médoc','Haut-Médoc','2004',75,NULL,NULL,NULL,NULL,NULL,NULL,'12');
INSERT INTO PRODUIT VALUES (7,1,1,4,'René Collard Champagne Brut Carte Or 2007',300,'2013-04-05 11:46:45','Ce vin, travaillé avec amour ne vous décevra jamais. Il est issu de cépages cultivés sans pesticides ni engrais chimiques. Les arômes sont développés au maximum.','drappier_5.jpg',2,'France','Champagne','Champagne','2007',75,NULL,NULL,NULL,NULL,NULL,NULL,'12');

INSERT INTO PRIX VALUES (null, 1, '2013-03-29 10:36:37', '2018-03-29 10:36:37', 4.75);
INSERT INTO PRIX VALUES (null, 2, '2013-03-29 10:36:37', '2018-03-29 10:36:37', 15.99);
INSERT INTO PRIX VALUES (null, 3, '2013-03-29 10:36:37', '2018-03-29 10:36:37', 112.21);
INSERT INTO PRIX VALUES (null, 4, '2013-03-29 10:36:37', '2018-03-29 10:36:37', 31.45);
INSERT INTO PRIX VALUES (null, 5, '2013-03-29 10:36:37', '2018-03-29 10:36:37', 12.30);
INSERT INTO PRIX VALUES (null, 6, '2013-03-29 10:36:37', '2018-03-29 10:36:37', 7.99);
INSERT INTO PRIX VALUES (null, 7, '2013-03-29 10:36:37', '2018-03-29 10:36:37', 18.12);

INSERT INTO PRODUITCOMMANDE VALUES (1, 1, 3);
INSERT INTO PRODUITCOMMANDE VALUES (2, 1, 3);
INSERT INTO PRODUITCOMMANDE VALUES (1, 2, 5);
INSERT INTO PRODUITCOMMANDE VALUES (3, 2, 3);
INSERT INTO PRODUITCOMMANDE VALUES (4, 2, 1);
INSERT INTO PRODUITCOMMANDE VALUES (2, 3, 5);
INSERT INTO PRODUITCOMMANDE VALUES (3, 4, 1);
INSERT INTO PRODUITCOMMANDE VALUES (6, 4, 1);
INSERT INTO PRODUITCOMMANDE VALUES (2, 4, 2);
INSERT INTO PRODUITCOMMANDE VALUES (7, 5, 3);

