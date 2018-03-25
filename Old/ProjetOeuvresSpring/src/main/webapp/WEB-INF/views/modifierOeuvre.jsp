<%--
  Created by IntelliJ IDEA.
  User: Christian TAGUEJOU
  Date: 20/02/2018
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modifier une oeuvre</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/style.css">
    <title>Modifier Oeuvre</title>
</head>
<body>

<jsp:include page="header.jsp" />

<div class="container">
    <div class="row content">

        <jsp:include page="menu.jsp" />

        <div class="col-md-9 col-xs-9 ">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title ">Modifier une Oeuvre</div>
                </div>
                <div class="panel-body">
                    <DIV align="center">
                        <form class="form-horizontal" name='identification' method="post" action="saveOeuvre.htm" >
                            <div class="form-group">
                                <input type="text" class="form-control hidden" id="idOeuvre" name="idOeuvre" value="${oeuvre.idOeuvrevente}" required>
                                <label class="col-sm-4 col-xs-4">Titre de l'Oeuvre:</label>
                                <div class="col-sm-8 col-xs-4">
                                    <input type="text" class="form-control" id="titreOeuvre" name="titreOeuvre" value="${oeuvre.titreOeuvrevente}" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-4">Prix de l'Oeuvre:</label>
                                <div class="col-sm-8 col-xs-4">
                                    <input type="text" class="form-control"  id="prixOeuvre"  name="prixOeuvre" value="${oeuvre.prixOeuvrevente}" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-4">Etat de l'Oeuvre:</label>
                                <div class="col-sm-8 col-xs-4">
                                    <select class="form-control" name="etatOeuvre" id="etatOeuvre">
                                        <option <c:if test ="${oeuvre.etatOeuvrevente == 'L'}"> selected="selected"</c:if> >L</option>
                                        <option <c:if test ="${oeuvre.etatOeuvrevente == 'R'}"> selected="selected"</c:if> >R</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-4">Propriétaire de l'Oeuvre:</label>
                                <div class="col-sm-8 col-xs-4">
                                    <select class="form-control" name="proprio" id="proprio">
                                        <c:forEach items="${mesProprio}" var="item">
                                            <option
                                                <c:if test = "${item.idProprietaire == oeuvre.proprietaire.idProprietaire}">
                                                    selected="selected"
                                                </c:if> > ${item.nomProprietaire} ${item.prenomProprietaire}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-default">Modifier</button>
                            <a href="listerOeuvre.htm" class="btn btn-default">Annuler</a>
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
