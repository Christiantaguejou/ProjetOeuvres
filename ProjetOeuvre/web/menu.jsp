<%--
  Created by IntelliJ IDEA.
  User: Christian TAGUEJOU
  Date: 18/02/2018
  Time: 01:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="css/leftMenu.css">
</head>
<div class="col-md-3 col-xs-3 padding-0">
    <div class="panel panel-default ">
        <div class="panel-heading">
            <div class="panel-title ">Navigation</div>
        </div>
        <div class="panel-body-big menu" >
            <div><a href="index.jsp"> Accueil </a></div>
            <div><a href="Controleur?action=listerAdherent"> Liste des Adhérents </a></div>
            <div><a href="Controleur?action=ajouterAdherent"> Ajouter un Adhérent </a></div>
            <div><a href="Controleur?action=ajouterOeuvre"> Ajouter une Oeuvre </a></div>
            <div><a href="#"> Quitter </a></div>
        </div>
    </div>
</div>
