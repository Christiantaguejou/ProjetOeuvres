<%--
  Created by IntelliJ IDEA.
  User: Christian TAGUEJOU
  Date: 18/02/2018
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Affichage de toutes les oeuvres</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/listerOeuvre.css">
    <link rel="stylesheet" href="css/liste.css">
    <script type="application/javascript" src="js/listerOeuvre.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container">
    <div class="row content">

        <jsp:include page="menu.jsp" />

        <div class="col-md-9 col-xs-9">
            <div class="panel panel-default ">
                <div class="panel-heading">
                    <div class="panel-title ">Listing des Oeuvres</div>
                </div>
                <div class="panel-body-big" >
                    <table id="tableFilter" class="table table-striped table-hover">
                        <br/>
                        <thead>
                        <tr>
                            <th onclick="sortTable(0)" class="cursorClic"><p class="glyphicon glyphicon-sort "></p> <a>Titre</a></th>
                            <th onclick="sortTable(1)" class="cursorClic"><p class="glyphicon glyphicon-sort "></p>  <a>Prix</a></th>
                            <th onclick="sortTable(2)" class="cursorClic"><p class="glyphicon glyphicon-sort "></p>  <a>Prénom Propriétaire</a></th>
                            <th onclick="sortTable(3)" class="cursorClic"><p class="glyphicon glyphicon-sort "></p>  <a>Nom Propriétaire</a></th>
                            <th><p>Réserver/Modifier</p></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${mesOeuvres}" var="item">
                            <tr>
                                <td>${item.titreOeuvrevente}</td>
                                <td>${item.prixOeuvrevente}</td>
                                <td>${item.proprietaire.prenomProprietaire} </td>
                                <td>${item.proprietaire.nomProprietaire}</td>
                                <td align="center">
                                    <a class="btn btn-primary clickable-row" data-href="#"><em class="fa fa-pencil"></em></a>
                                    <a class="btn btn-danger clickable-row" data-href="#"><em class="fa fa-trash"></em></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="application/javascript">

    $('.clickable-row').click(function(){
        window.location = $(this).data('href');
    });

</script>
</body>
</html>
