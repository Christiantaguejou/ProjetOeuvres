<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="refresh" content="0;URL=javascript:fermer();">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Expo : Médiathèque De POLYTECH LYON</title>
</head>


<script language="JavaScript">
    function fermer() {

    }
</script>

<body style="background-color: lightgrey">

</body>
	<nav class="navbar navbar-default" style="height: 90px">
		<a class="navbar-brand" href="#">
			<div style="display: inline-block;"> <img src="/img/polytech.png" width="90" height="70" alt=""> </div>
			<div style="display: inline-block"> Médiathèque de POLYTECH LYON </div>
		</a>
	</nav>

	<div class="container-fluid" style="width: 900px; background-color: white">
		<p align="center"></p>

		<p align="center">
			<font color="#004080" face="Arial" size="4">Gestion de
				l'exposition 2018</font>
		</p>
		<p align="left">
			<font color="#004080" face="Arial"><u>Sélectionnez la
				fonctionnalité voulue:</u></font>
		</p>
		<ul class="list-group">
			<a class="list-group-item" href="Controleur?action=ajouterAdherent">Ajout Adhérent</a>
			<a class="list-group-item" href="Controleur?action=listerAdherent">lister les adhérents</a>
			<a class="list-group-item" href="javascript:fermer()">Quitter</a>
		</ul>
	</div>
</html>