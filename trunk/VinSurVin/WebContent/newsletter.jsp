<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vin sur Vin - Newsletter</title>
<link rel="stylesheet"
	href="/VinSurVin/faces/resources/css/cssNewsletter.css" type="text/css" />
</head>
<body>
	<div class="header"></div>
	<div class="corps">
		<div class="newsletterDiv">
			<a href="/VinSurVin/faces/pagesFrontOffice/accueil.xhtml"
				title="Vin sur Vin" class="logo-one"> <img
				src="/VinSurVin/faces/resources/images/logo.png" alt="Vin sur Vin"
				width="200px" /></a> <br>
			<h2>Inscription à notre newsletter</h2>
			<form action="newsletterAction.perform" method="post">

				<label>Pour vous abonner ou vous désabonner, veuillez saisir
					votre adresse mail : </label><br> <input type="text" id="emailInput"
					name="email" value="${newsletterForm.email}" /> <input
					type="submit" value="S'inscrire" /> <br>

				<c:forEach items="${newsletterForm.messagesValidate}" var="message">
					<tr>
						<td><label style="color: red"><c:out
									value="${message}" /></label><br></td>
					</tr>
				</c:forEach>

				<a href="/VinSurVin/faces/pagesFrontOffice/accueil.xhtml"
					target="_blank" class="retourSite">Retourner sur le site Vin
					sur Vin </a>
					<br>
					<label class="cnil"><i >Conformément à la loi Informatique et Liberté du
				6 janvier 1978, vous disposez d'un droit d'accès, de rectification
				et d'opposition relatif aux informations vous concernant.</i> </label>
					
			</form>
		</div>
		
	</div>
	<div class="footer">
		<div id="table">
			<div class="row">
				<span class="cell"><a>Conditions générales de vente</a></span> <span
					class="cell"><a>Aide en ligne</a></span>
			</div>
			<div class="row">
				<span class="cell"><a>Copyright 2013 Vin sur Vin</a></span> <span
					class="cell">Contact technique : <a
					href="mailto:contact@vinsurvin.fr">contact@vinsurvin.fr</a></span>
			</div>
			<div class="row">
				<span class="cell"><a>Plan du site</a></span> <span class="cell"><a>Mentions
						légales</a></span>
			</div>
		</div>
	</div>
</body>
</html>