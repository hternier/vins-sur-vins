CREATE DATABASE IF NOT EXISTS atod18_g1_gestionfournisseur;
USE atod18_g1_gestionfournisseur;

/*==============================================================*/
/* Table : Produit                                             */
/*==============================================================*/
create table atod18_g1_gestionfournisseur.PRODUIT
(
   IDPRODUIT            int not null,
   NOMBRECOMMANDES      int not null,
   IDFOURNISSEUR  		int not null
   primary key (IDPRODUIT)
);

/*==============================================================*/
/* Table : Fournisseur                                          */
/*==============================================================*/
create table atod18_g1_gestionfournisseur.FOURNISSEUR
(
   IDFOURNISSEUR            int not null,
   LIBELLEFOURNISSEUR      String not null
   primary key (IDPRODUIT)
);