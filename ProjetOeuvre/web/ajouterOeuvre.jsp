<%--
  Created by IntelliJ IDEA.
  User: Christian TAGUEJOU
  Date: 17/02/2018
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajouter une Oeuvre</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/leftMenu.css">
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <div class="row content">
            <div class="col-md-3 col-xs-3 padding-0">
                <div class="panel panel-default ">
                    <div class="panel-heading">
                        <div class="panel-title ">Navigation</div>
                    </div>
                    <div class="panel-body-big menu" >
                        <div><a href="index.jsp"> Accueil </a></div>
                        <div><a href="Controleur?action=listerAdherent"> Liste des Adhérents </a></div>
                        <div><a href="Controleur?action=ajouterAdherent"> Ajouter un Adhérents </a></div>
                        <div><a href="#"> Quitter </a></div>
                    </div>
                </div>
            </div>

            <div class="col-md-9 col-xs-9 ">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-title ">Ajouter une Oeuvre</div>
                    </div>
                    <div class="panel-body">

                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>
