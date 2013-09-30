CREATE DATABASE IF NOT EXISTS atod18_g1_gestionfournisseur;
USE atod18_g1_gestionfournisseur;

/*==============================================================*/
/* Table : Produit                                             */
/*==============================================================*/
DROP TABLE IF EXISTS `atod18_g1_gestionfournisseur.PRODUIT`;
CREATE TABLE atod18_g1_gestionfournisseur.PRODUIT
(
   IDPRODUIT            int not null,
   QUANTITECOMMANDES      int not null,
   IDFOURNISSEUR  		int not null
   primary key (IDPRODUIT)
);

/*==============================================================*/
/* Table : Fournisseur                                          */
/*==============================================================*/
DROP TABLE IF EXISTS `atod18_g1_gestionfournisseur.FOURNISSEUR`;
create table atod18_g1_gestionfournisseur.FOURNISSEUR
(
   IDFOURNISSEUR            int not null,
   LIBELLEFOURNISSEUR      varchar(50) not null
   primary key (IDFOURNISSEUR)
);

alter table atod18_g1_gestionfournisseur.PRODUIT add constraint FK_PRODUIT_FOURNISSEUR foreign key (IDFOURNISSEUR)
      references FOURNISSEUR (IDFOURNISSEUR) on delete restrict on update restrict;

