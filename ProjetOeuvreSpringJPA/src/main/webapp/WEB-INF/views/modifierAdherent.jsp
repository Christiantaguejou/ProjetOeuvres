<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajouter un  adhérent</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/ajoutAdherent.css">
    <title>Modifier Adhérent</title>

</head>
<SCRIPT language="Javascript" type="text/javascript"></SCRIPT>
<script type="text/javascript" src="/resources/js/fonctControle.js"></script>


<body>
<jsp:include page="header.jsp" />

<div class="container">
    <div class="row content">

        <jsp:include page="menu.jsp" />

        <div class="col-md-9 col-xs-9 ">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="panel-title ">Modifier un Adhérents</div>
            </div>
            <div class="panel-body">
            <DIV align="center">
                <form class="form-horizontal" name='identification' method="post" action="saveAdherent.htm" onsubmit="return teste()">
                    <div class="form-group">
                        <input type="text" class="form-control hidden" id="idAdherent" name="id" value="${adherent.idAdherent}" required>
                        <label class="col-sm-4 col-xs-4">Nom de l'adhérent:</label>
                        <div class="col-sm-8 col-xs-4">
                            <input type="text" class="form-control" id="nom" name="nom" value="${adherent.nomAdherent}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 col-xs-4">Prénom de l'adhérent:</label>
                        <div class="col-sm-8 col-xs-4">
                            <input type="text" class="form-control"  id="prenom"  name="prenom" value="${adherent.prenomAdherent}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 col-xs-4">Ville de l'adhérent:</label>
                        <div class="col-sm-8 col-xs-4">
                            <input type="text" class="form-control"  id="ville" name="ville" value="${adherent.villeAdherent}" required>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-default">Sauvegarder</button>
                    <a href="#" id="cancel" class="btn btn-default">Annuler</a>
                    <a href="#" id="deleteAdherent" class="btn btn-default">Supprimer</a>
                </form>
            </DIV>
            </div>
        </div>
    </div>
</div>
</div>

<jsp:include page="footer.jsp" />

<BR>
<script type="application/javascript">
    $('#deleteAdherent').click(function () {
        if (confirm("Êtes vous sûr de vouloir supprimer cet Adhérent ?") ){
            $.post(
                'Controleur',
                {
                    action: 'deleteAdherent',
                    id: $('#idAdherent').val()
                }
            ).done(function(data){
                if(data === 'AdherentSupprimer') {
                    window.location = "listerAdherent.htm";
                } else if(data === "error") {
                    alert("Une erreur s'est produite..");
                }
            });
        }
    });

    $('#cancel').click(function(){
        window.location = "Controleur?action=listerAdherent";
    });
</script>
</body>
</html>