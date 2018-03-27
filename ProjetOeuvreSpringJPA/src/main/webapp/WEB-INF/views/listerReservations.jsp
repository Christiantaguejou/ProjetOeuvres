<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 26/03/2018
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Affichage de tous les prêts</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="/resources/css/style.css">
            <link rel="stylesheet" href="/resources/css/liste.css">
            <script type="application/javascript" src="/resources/js/listerAdherent.js"></script>
        </head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <div class="row content">

        <jsp:include page="menu.jsp"/>

        <div class="col-md-9 col-xs-9">
            <div class="panel panel-default ">
                <div class="panel-heading">
                    <div class="panel-title ">Listing des Adhérents</div>
                </div>
                <div class="panel-body-big menu">
                    <table id="tableFilter" class="table table-striped table-hover">
                        <br/>
                        <thead>
                        <tr>
                            <th onclick="sortTable(0)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Titre</th>
                            <th onclick="sortTable(1)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  ID Propriétaire</th>
                            <th onclick="sortTable(2)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  ID Pret</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listeReservations}" var="item">
                            <tr>
                                <td>${item.titreOeuvrepret}</td>
                                <td>${item.proprietaireEntity.nomProprietaire} ${item.proprietaireEntity.prenomProprietaire}</td>
                                <td>${item.idOeuvrepret}</td>
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

    $('.clickable-row').click(function () {
        window.location = $(this).data('href');
    });

</script>
</body>
</html>
</title>
</head>
<body>

</body>
</html>
