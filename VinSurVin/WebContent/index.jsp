<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
</head>
<body>
<f:view>
<h:form>
	<h:outputText value="#{mbTest.produit.libelle}" />
	<h:outputText value="#{mbTest.prixActuel}" />
	<h:panelGroup rendered="#{mbTest.listeProduitLength > 0}">
		<h:dataTable value="#{mbTest.listeProduit }" var="produit">
			<h:column>
				<f:facet name="header"><h:outputText value="Id" /></f:facet>
				<h:outputText value="#{produit.id}" />
			</h:column>
		</h:dataTable>
	</h:panelGroup>
	<h:commandButton value="Salut" action="#{mbTest.testAction }" />
	
	<h:commandLink value="Ajout Produit 1" actionListener="#{mbPanier.ajoutPanier}">
		<f:attribute name="produit" value="#{mbTest.produit}"/>
		<f:attribute name="quantite" value="1"/>
	</h:commandLink>
	<h:commandLink value="Ajout Produit 2" actionListener="#{mbPanier.ajoutPanier}">
		<f:attribute name="produit" value="#{mbTest.produit2}"/>
		<f:attribute name="quantite" value="1"/>
	</h:commandLink><br>
	<h:commandLink value="Retirer Produit 1" actionListener="#{mbPanier.retirerPanier}">
		<f:attribute name="produit" value="#{mbTest.produit}"/>
		<f:attribute name="quantite" value="1"/>
	</h:commandLink>
	<h:commandLink value="Retirer Produit 2" actionListener="#{mbPanier.retirerPanier}">
		<f:attribute name="produit" value="#{mbTest.produit2}"/>
		<f:attribute name="quantite" value="1"/>
	</h:commandLink><br>
	<h:outputText value="#{mbPanier.totalPanier}" />
</h:form>
</f:view>
</body>
</html>