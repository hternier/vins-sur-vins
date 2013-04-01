﻿INSERT INTO TYPECOMPTE VALUES (null, 'Client');
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

INSERT INTO TYPELIVRAISON VALUES (null, 'La poste');

INSERT INTO TARIFLIVRAISON VALUES (null, 1, 'La poste', 1, 10, 5);
INSERT INTO TARIFLIVRAISON VALUES (null, 1, 'La poste', 11, 20, 10);
INSERT INTO TARIFLIVRAISON VALUES (null, 1, 'La poste', 21, 30, 14.5);

INSERT INTO ETATCOMMANDE VALUES (null, 'En attente de validation');
INSERT INTO ETATCOMMANDE VALUES (null, 'En attente de paiement');
INSERT INTO ETATCOMMANDE VALUES (null, 'En préparation');
INSERT INTO ETATCOMMANDE VALUES (null, 'En livraison');
INSERT INTO ETATCOMMANDE VALUES (null, 'Traité');
INSERT INTO ETATCOMMANDE VALUES (null, 'Annulé');

INSERT INTO COMMANDE VALUES (null, 1, 2, 1, 2, current_timestamp);

INSERT INTO TVA VALUES (null, 0.196);
INSERT INTO TVA VALUES (null, 0.055);

INSERT INTO TYPEPRODUIT VALUES (null, 'Vin');
INSERT INTO TYPEPRODUIT VALUES (null, 'Spiritueux');
INSERT INTO TYPEPRODUIT VALUES (null, 'Accessoire');

INSERT INTO CATEGORIEPRODUIT VALUES (null,1 , 'Vin rouge');
INSERT INTO CATEGORIEPRODUIT VALUES (null,1 , 'Vin blanc');
INSERT INTO CATEGORIEPRODUIT VALUES (null,1 , 'Vin rosé');
INSERT INTO CATEGORIEPRODUIT VALUES (null,1 , 'Champagnes');
INSERT INTO CATEGORIEPRODUIT VALUES (null,2 , 'Armagnac');
INSERT INTO CATEGORIEPRODUIT VALUES (null,2 , 'Cognac');
INSERT INTO CATEGORIEPRODUIT VALUES (null,2 , 'Rhum');
INSERT INTO CATEGORIEPRODUIT VALUES (null,2 , 'Whisky');

INSERT INTO PRODUIT VALUES (null, 1, 1, 1, 'libelleProduit', 100, null, 'descriptionProduit', null, 1, 'France', 'Champagne Ardenne', 'Bordeaux', '2009', 75, null, null, null, null, null, null);
INSERT INTO PRODUIT VALUES (null, 1, 2, 1, 'libelleProduit2', 100, null, 'descriptionProduit2', null, 1, null, null, null, null, null, 'Wiskey', 2009, 45, 75, null, null);
INSERT INTO PRODUIT VALUES (null, 1, 1, 1, 'libelleProduit3', 100, null, 'descriptionProduit3', null, 1, 'France', 'Aquitaine', 'Bordeaux', '2001', 75, null, null, null, null, null, null);
INSERT INTO PRODUIT VALUES (null, 1, 3, 1, 'Verres x6', 30, null, 'descriptionVerres', null, 1, null, null, null, null, null, null, null, null, null, 'Verres and co', 350);

INSERT INTO PRIX VALUES (null, 1, '2013-03-29 10:36:37', '2018-03-29 10:36:37', 4.75);
INSERT INTO PRIX VALUES (null, 2, '2013-03-29 10:36:37', '2018-03-29 10:36:37', 15);
INSERT INTO PRIX VALUES (null, 3, '2013-03-29 10:36:37', '2018-03-29 10:36:37', 4.75);

INSERT INTO PRODUITCOMMANDE VALUES (1, 1, 3);