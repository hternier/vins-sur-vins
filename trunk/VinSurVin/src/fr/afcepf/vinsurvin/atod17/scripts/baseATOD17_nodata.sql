drop database if exists atod17_g2_vins;

create database atod17_g2_vins;

/*==============================================================*/
/* Table : ADRESSE                                              */
/*==============================================================*/
create table atod17_g2_vins.ADRESSE
(
   IDADRESSE            int not null auto_increment,
   IDVILLE              int not null,
   DESTINATAIREADRESSE  varchar(100),
   ADRESSE1ADRESSE      varchar(255) not null,
   ADRESSE2ADRESSE      varchar(255),
   primary key (IDADRESSE)
);

/*==============================================================*/
/* Table : CATEGORIEPRODUIT                                     */
/*==============================================================*/
create table atod17_g2_vins.CATEGORIEPRODUIT
(
   IDCATEGORIEPRODUIT   int not null auto_increment,
   IDTYPEPRODUIT              int not null,
   LIBELLECATEGORIEPRODUIT varchar(255) not null,
   primary key (IDCATEGORIEPRODUIT)
);

/*==============================================================*/
/* Table : COMMANDE                                             */
/*==============================================================*/
create table atod17_g2_vins.COMMANDE
(
   IDCOMMANDE           int not null auto_increment,
   IDCOMPTE             int not null,
   IDETATCOMMANDE       int not null,
   IDADRESSECOMMANDE    int,
   IDTARIFLIVRAISON     int,
   DATECOMMANDE         timestamp not null,
   primary key (IDCOMMANDE)
);

/*==============================================================*/
/* Table : COMPTE                                               */
/*==============================================================*/
create table atod17_g2_vins.COMPTE
(
   IDCOMPTE             int not null auto_increment,
   IDTYPECOMPTECOMPTE   int not null,
   IDADRESSEFACTURATIONCOMPTE int,
   IDADRESSELIVRAISONCOMPTE int,
   IDETATCOMPTE         int,
   NOMCOMPTE            varchar(50) not null,
   PRENOMCOMPTE         varchar(50) not null,
   MAILCOMPTE           varchar(75) not null,
   MDPCOMPTE            varchar(50) not null,
   TELCOMPTE            varchar(20) not null,
   DROITACCESCOMPTE    varchar(255) not null,
   DATEINSCRIPTIONCOMPTE timestamp not null,
   DERNIERECONNEXIONCOMPTE timestamp,
   primary key (IDCOMPTE)
);

/*==============================================================*/
/* Table : ETATCOMMANDE                                         */
/*==============================================================*/
create table atod17_g2_vins.ETATCOMMANDE
(
   IDETATCOMMANDE       int not null auto_increment,
   LIBELLEETATCOMMANDE  varchar(255) not null,
   primary key (IDETATCOMMANDE)
);

/*==============================================================*/
/* Table : ETATCOMPTE                                           */
/*==============================================================*/
create table atod17_g2_vins.ETATCOMPTE
(
   IDETATCOMPTE         int not null auto_increment,
   LIBELLEETATCOMPTE    varchar(255) not null,
   primary key (IDETATCOMPTE)
);

/*==============================================================*/
/* Table : PRIX                                                 */
/*==============================================================*/
create table atod17_g2_vins.PRIX
(
   IDPRIX               int not null auto_increment,
   IDPRODUIT            int not null,
   DATEDEBUTPRIX        timestamp not null,
   DATEFINPRIX          timestamp,
   VALEURHTPRIX         double not null,
   primary key (IDPRIX)
);

/*==============================================================*/
/* Table : PRODUIT                                              */
/*==============================================================*/
create table atod17_g2_vins.PRODUIT
(
   IDPRODUIT            int not null auto_increment,
   IDTVA                int not null,
   IDTYPEPRODUIT        int,
   IDCATEGORIEPRODUIT   int,
   LIBELLEPRODUIT       varchar(255) not null,
   DATEMISEENLIGNEPRODUIT timestamp not null,
   DESCRIPTIONPRODUIT   varchar(1024) not null,
   IMAGEPRODUIT         varchar(255),
   UNITELIVRAISONPRODUIT int not null,
   PAYSVINPRODUIT       varchar(255),
   REGIONVINPRODUIT     varchar(255),
   APPELLATIONVINPRODUIT varchar(255),
   MILLESIMEVINPRODUIT  varchar(255),
   CONTENANCEVINPRODUIT int,
   APPELLATIONSPIRITUEUXPRODUIT varchar(255),
   MILLESIMESPIRITUEUXPRODUIT varchar(255),
   DEGRESSPIRITUEUXPRODUIT varchar(255),
   CONTENANCESPIRITUEUXPRODUIT int,
   MARQUEACCESSOIREPRODUIT varchar(255),
   POIDSACCESSOIREPRODUIT int,
   DEGRESVINPRODUIT varchar(255),
   primary key (IDPRODUIT)
);

/*==============================================================*/
/* Table : PRODUITCOMMANDE                                      */
/*==============================================================*/
create table atod17_g2_vins.PRODUITCOMMANDE
(
   IDPRODUIT            int not null,
   IDCOMMANDE           int not null,
   QUANTITEPRODUITCOMMANDE int not null,
   primary key (IDPRODUIT, IDCOMMANDE)
);

/*==============================================================*/
/* Table : TARIFLIVRAISON                                       */
/*==============================================================*/
create table atod17_g2_vins.TARIFLIVRAISON
(
   IDTARIFLIVRAISON     int not null auto_increment,
   IDTYPELIVRAISON      int not null,
   SOCIETETARIFLIVRAISON varchar(255) not null,
   UNITELIVRAISONMINTARIFLIVRAISON int not null,
   UNITELIVRAISONMAXTARIFLIVRAISON int not null,
   TARIFTARIFLIVRAISON  double not null,
   primary key (IDTARIFLIVRAISON)
);

/*==============================================================*/
/* Table : TVA                                                  */
/*==============================================================*/
create table atod17_g2_vins.TVA
(
   IDTVA                int not null auto_increment,
   VALEURTVA            double not null,
   primary key (IDTVA)
);

/*==============================================================*/
/* Table : TYPECOMPTE                                           */
/*==============================================================*/
create table atod17_g2_vins.TYPECOMPTE
(
   IDTYPECOMPTE         int not null auto_increment,
   LIBELLETYPECOMPTE    varchar(255) not null,
   primary key (IDTYPECOMPTE)
);

/*==============================================================*/
/* Table : TYPELIVRAISON                                        */
/*==============================================================*/
create table atod17_g2_vins.TYPELIVRAISON
(
   IDTYPELIVRAISON      int not null auto_increment,
   LIBELLETYPELIVRAISON varchar(255) not null,
   primary key (IDTYPELIVRAISON)
);

/*==============================================================*/
/* Table : TYPEPRODUIT                                          */
/*==============================================================*/
create table atod17_g2_vins.TYPEPRODUIT
(
   IDTYPEPRODUIT        int not null auto_increment,
   LIBELLETYPEPRODUIT   varchar(255) not null,
   primary key (IDTYPEPRODUIT)
);

/*==============================================================*/
/* Table : VILLE                                                */
/*==============================================================*/
create table atod17_g2_vins.VILLE
(
   IDVILLE              int not null auto_increment,
   CPVILLE              varchar(5) not null,
   VILLEVILLE           varchar(50) not null,
   PAYSVILLE            varchar(40) not null,
   primary key (IDVILLE)
);

alter table atod17_g2_vins.ADRESSE add constraint FK_ADRESSE_VILLE foreign key (IDVILLE)
      references VILLE (IDVILLE) on delete restrict on update restrict;

alter table atod17_g2_vins.COMMANDE add constraint FK_COMMANDE_ADRESSE foreign key (IDADRESSECOMMANDE)
      references ADRESSE (IDADRESSE) on delete restrict on update restrict;

alter table atod17_g2_vins.COMMANDE add constraint FK_COMMANDE_COMPTE foreign key (IDCOMPTE)
      references COMPTE (IDCOMPTE) on delete restrict on update restrict;

alter table atod17_g2_vins.COMMANDE add constraint FK_COMMANDE_ETATCOMMANDE foreign key (IDETATCOMMANDE)
      references ETATCOMMANDE (IDETATCOMMANDE) on delete restrict on update restrict;

alter table atod17_g2_vins.COMMANDE add constraint FK_COMMANDE_TARIFLIVRAISON foreign key (IDTARIFLIVRAISON)
      references TARIFLIVRAISON (IDTARIFLIVRAISON) on delete restrict on update restrict;

alter table atod17_g2_vins.COMPTE add constraint FK_COMPTE_ADRESSEFACTURATION foreign key (IDADRESSEFACTURATIONCOMPTE)
      references ADRESSE (IDADRESSE) on delete restrict on update restrict;

alter table atod17_g2_vins.COMPTE add constraint FK_COMPTE_ADRESSELIVRAISON foreign key (IDADRESSELIVRAISONCOMPTE)
      references ADRESSE (IDADRESSE) on delete restrict on update restrict;

alter table atod17_g2_vins.COMPTE add constraint FK_COMPTE_ETATCOMPTE foreign key (IDETATCOMPTE)
      references ETATCOMPTE (IDETATCOMPTE) on delete restrict on update restrict;

alter table atod17_g2_vins.COMPTE add constraint FK_COMPTE_TYPECOMPTE foreign key (IDTYPECOMPTECOMPTE)
      references TYPECOMPTE (IDTYPECOMPTE) on delete restrict on update restrict;

alter table atod17_g2_vins.PRIX add constraint FK_PRIX_PRODUIT foreign key (IDPRODUIT)
      references PRODUIT (IDPRODUIT) on delete restrict on update restrict;

alter table atod17_g2_vins.PRODUIT add constraint FK_PRODUIT_CATEGORIEPRODUIT foreign key (IDCATEGORIEPRODUIT)
      references CATEGORIEPRODUIT (IDCATEGORIEPRODUIT) on delete restrict on update restrict;

alter table atod17_g2_vins.PRODUIT add constraint FK_PRODUIT_TVA foreign key (IDTVA)
      references TVA (IDTVA) on delete restrict on update restrict;

alter table atod17_g2_vins.PRODUIT add constraint FK_PRODUIT_TYPEPRODUIT foreign key (IDTYPEPRODUIT)
      references TYPEPRODUIT (IDTYPEPRODUIT) on delete restrict on update restrict;

alter table atod17_g2_vins.PRODUITCOMMANDE add constraint FK_PRODUITCOMMANDE_COMMANDE foreign key (IDCOMMANDE)
      references COMMANDE (IDCOMMANDE) on delete restrict on update restrict;

alter table atod17_g2_vins.PRODUITCOMMANDE add constraint FK_PRODUITCOMMANDE_PRODUIT foreign key (IDPRODUIT)
      references PRODUIT (IDPRODUIT) on delete restrict on update restrict;

alter table atod17_g2_vins.TARIFLIVRAISON add constraint FK_TARIFLIVRAISON_TYPELIVRAISON foreign key (IDTYPELIVRAISON)
      references TYPELIVRAISON (IDTYPELIVRAISON) on delete restrict on update restrict;

alter table atod17_g2_vins.CATEGORIEPRODUIT add constraint FK_CATEGORIEPRODUIT_TYPEPRODUIT foreign key (IDTYPEPRODUIT)
      references TYPEPRODUIT (IDTYPEPRODUIT) on delete restrict on update restrict;