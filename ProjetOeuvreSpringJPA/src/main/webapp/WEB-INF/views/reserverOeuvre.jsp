<%--
  Created by IntelliJ IDEA.
  User: Christian TAGUEJOU
  Date: 19/02/2018
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Réserver une Oeuvre</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/style.css">
    <title>Emprunter une Oeuvre</title>
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container">
    <div class="row content">

        <jsp:include page="menu.jsp" />

        <div class="col-md-9 col-xs-9 ">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title ">Réserver une Oeuvre</div>
                </div>
                <div class="panel-body">
                    <DIV align="center">
                        <form class="form-horizontal" name='identification' method="post" action="saveReservation.htm">
                            <div class="form-group">
                                <input type="text" class="form-control hidden" id="idOeuvrevente" name="id"  value="${oeuvre.idOeuvrevente}" readonly>
                                <label class="col-sm-4 col-xs-4">Titre de L'Oeuvre:</label>
                                <div class="col-sm-8 col-xs-4">
                                    <input type="text" class="form-control" id="titreOeuvre" name="titreOeuvre" value="${oeuvre.titreOeuvrevente}" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-4">Prix de l'Oeuvre:</label>
                                <div class="col-sm-8 col-xs-4">
                                    <input type="number" step="0.01" class="form-control"  id="prixOeuvre"  name="prixOeuvre"  value="${oeuvre.prixOeuvrevente}" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-4 col-xs-4">Adhérent:</label>
                                <div class="col-md-8 col-xs-8">
                                    <select class="form-control" name="adherent" id="adherent">
                                        <c:forEach items="${lesAdherents}" var="item">
                                            <option value="${item.idAdherent}">
                                                ${item.nomAdherent} ${item.prenomAdherent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-4">Date de Réservation:</label>
                                <div class="col-sm-8 col-xs-4">
                                    <input type="date" class="form-control"  id="dateReservation"  name="dateReservation" required>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-default">Reserver</button>
                        </form>
                    </DIV>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
<script type="application/javascript">
    function checkError() {
        var url = window.location.href;
        var tab = url.split('?');
        console.log(tab);
        console.log(tab.length);
        if (tab.length < 2){
            console.log(tab.length);
            return;
        }
        if(tab[1] == "success=false"){
            console.log("echec");
            alert('Vous avez essayez de réserver une oeuvre qui est déjà réserver par cet adhérent');
        }
    }
    checkError();
</script>
