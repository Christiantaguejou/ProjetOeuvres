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
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/leftMenu.css">
    <link rel="stylesheet" href="css/listerAdherent.css">
</head>
<body>
<jsp:include page="header.jsp" />

    <div class="container">
        <div class="row content">
            <div class="col-md-3 ">
                <div class="panel panel-default ">
                    <div class="panel-heading">
                        <div class="panel-title ">Navigation</div>
                    </div>
                    <div class="panel-body-big menu" >
                        <div><a href="index.jsp"> Accueil </a></div>
                        <div><a href="Controleur?action=ajouterAdherent"> Ajouter un Adhérents </a></div>
                        <div><a href="#"> Quitter </a></div>
                    </div>
            </div>
            </div>
            <div class="col-md-9 ">
        <div class="panel panel-default ">
            <div class="panel-heading">
                <div class="panel-title ">Listing des Adhérents</div>
            </div>
            <div class="panel-body-big menu" >
            <table id="tableFilter" class="table table-striped table-hover">
                <br/>
                <thead>
                    <tr>
                        <th onclick="sortTable(0)"><p class="glyphicon glyphicon-sort" style="display: inline"></p>  N° des adhérents</th>
                        <th onclick="sortTable(1)"><p class="glyphicon glyphicon-sort" style="display: inline"></p>  Nom</th>
                        <th onclick="sortTable(2)"><p class="glyphicon glyphicon-sort" style="display: inline"></p>  Prénom</th>
                        <th onclick="sortTable(3)"><p class="glyphicon glyphicon-sort" style="display: inline"></p>  Ville</th>
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
        </div>
    </div>

<jsp:include page="footer.jsp" />

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
                    if(n == 0){
                        var a = parseInt(x.textContent);
                        var b = parseInt(y.textContent);
                        if(a > b){
                            aChanger = true;
                            break;
                        }
                    }
                    else if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        aChanger= true;
                        break;
                    }
                } else if (dir == "desc") {
                    if(n == 0){
                        var a = parseInt(x.textContent);
                        var b = parseInt(y.textContent);
                        if(a < b){
                            aChanger = true;
                            break;
                        }
                    }
                    else if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
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