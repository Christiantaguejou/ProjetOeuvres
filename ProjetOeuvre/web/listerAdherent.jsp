<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage de tous les adhérents</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        html, body
        {
            background-color: lightgrey;
        }
        .container{
            padding-left: 20px;
            padding-right: 30px;
            border-radius: 10px;
            width: 1100px;
            height: 100%;
            background-color: white;
        }
        footer {
            background-color: #f8f8f8;
            color: grey;
            padding: 15px;
            width: 100%;
            position: fixed;
            bottom: 0;
        }
        .table-hover > tbody > tr:hover {
            background-color: rgba(129, 228, 255, 0.43);
        }
        #menu{
            margin-top: 65px;
        }
        .padding-0{
            padding-right:2px;
            padding-left:2px;
        }
       /* .panel-primary > .panel-heading {
            color: #333;
            background-color: #49e1ff;
            border-color: #ddd;
        }*/
    </style>
</head>
<body>
    <nav class="navbar navbar-default" style="height: 70px">
        <a class="navbar-brand" href="#">
            <div style="display: inline-block;"> <img src="/img/polytech.png" width="70" height="55" alt=""> </div>
            <div style="display: inline-block"> Médiathèque de POLYTECH LYON </div>
        </a>
    </nav>

    <div class="container">
        <div class="row content">
            <div class="col-sm-2 padding-0">
                <div id="menu" class="panel panel-default ">
                    <div class="panel-heading">
                        <div class="panel-title ">Navigation</div>
                    </div>
                    <div class="panel-body-big" style="height: 90px">
                        <a class="glyphicon glyphicon-plus" style="margin-left: 5px; margin-bottom: 10px" href="Controleur?action=ajouterAdherent"> Ajout Adhérent</a>
                        <a class="glyphicon glyphicon-home" style="margin-left: 5px; margin-bottom: 10px; display: block" href="index.jsp">  Accueil</a>
                        <a class="glyphicon glyphicon-remove" style="margin-left: 5px; margin-bottom: 10px" href="#">  Quitter</a>
                    </div>
            </div>
            </div>
            <div class="col-sm-10 padding-0 ">
          <!--  <P>
                <A href="index.jsp"><FONT face="Arial" color="#004080">Retour Accueil</FONT></A>
            </P>-->
            <P align="center">
                <STRONG>Listing&nbsp;des Adhérents </STRONG>
            </P>

            <table id="tableFilter" class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th onclick="sortTable(0)">Numéro des adhérents</th>
                        <th onclick="sortTable(1)">Nom</th>
                        <th onclick="sortTable(2)">Prénom</th>
                        <th onclick="sortTable(3)">Ville</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${mesAdherents}" var="item">
                        <tr class="clickable-row" data-href="Controleur?action=modifierAdherent&id=${item.idAdherent}">
                            <td>${item.idAdherent}</td>
                            <td>${item.nomAdherent}</td>
                            <td>${item.prenomAdherent}</td>
                            <td>${item.villeAdherent}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </div>
        </div>
    </div>

    <footer class="container-fluid text-center">
        <p>Projet Oeuvres Par Mark, Fabien et Christian</p>
    </footer>
<script type="application/javascript">
    function sortTable(n) {
        var table, ligne, trier, i, x, y, aChanger, dir, cpt = 0;
        table = document.getElementById("tableFilter");
        trier = true;
        dir = "asc";
        while (trier) {
            trier = false;
            ligne = table.getElementsByTagName("tr");
            for (i = 1; i < (ligne.length - 1); i++) {
                aChanger = false;
                x = ligne[i].getElementsByTagName("td")[n];
                y = ligne[i + 1].getElementsByTagName("td")[n];

                if (dir == "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        aChanger= true;
                        break;
                    }
                } else if (dir == "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        aChanger= true;
                        break;
                    }
                }
            }
            if (aChanger) {

                ligne[i].parentNode.insertBefore(ligne[i + 1], ligne[i]);

                trier = true;
                cpt ++;
            } else {
                if (cpt == 0 && dir == "asc") {
                    dir = "desc";
                    trier = true;
                }
            }
        }
    }
    $('.clickable-row').click(function(){
        window.location = $(this).data('href');
    });
</script>
</body>
</html>