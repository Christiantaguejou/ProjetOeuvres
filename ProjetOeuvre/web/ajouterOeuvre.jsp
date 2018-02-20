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
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <div class="row content">

            <jsp:include page="menu.jsp" />

            <div class="col-md-9 col-xs-9 ">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-title ">Ajouter une Oeuvre</div>
                    </div>
                    <div class="panel-body">
                        <DIV align="center">
                            <form class="form-horizontal" name='identification' method="post" action="Controleur?action=insererOeuvre">
                                <div class="form-group">
                                    <label class="col-md-4 col-xs-4">Titre de l'oeuvre:</label>
                                    <div class="col-md-8 col-xs-8">
                                        <input type="text" class="form-control" id="titreOeuvre" name="titreOeuvre" placeholder="Titre de l'oeuvre" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 col-xs-4">Prix de l'oeuvre:</label>
                                    <div class="col-md-8 col-xs-8">
                                        <input type="number" step="0.01" min="0" class="form-control"  id="prixOeuvre" name="prixOeuvre" placeholder="Prix de l'oeuvre" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 col-xs-4">Nom du propriétaire:</label>
                                    <div class="col-md-8 col-xs-8">
                                        <select class="form-control" name="proprio" >
                                            <c:forEach items="${mesPropio}" var="item">
                                                <option> ${item.nomProprietaire} ${item.prenomProprietaire}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-default">Ajouter</button>
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
