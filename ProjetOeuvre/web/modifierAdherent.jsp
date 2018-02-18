<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajouter un  adhérent</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/ajoutAdherent.css">
    <link rel="stylesheet" href="css/leftMenu.css">
    <title>Expo : Médiathèque De POLYTECH</title>

</head>
<SCRIPT language="Javascript" type="text/javascript"></SCRIPT>
<script type="text/javascript" src="js/fonctControle.js"></script>


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

       <!-- <div class="col-sm-10 ">
            <H1 style="text-align: center"> Ajout d'un adhérent </H1>-->
        <div class="col-md-9 col-xs-9 ">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="panel-title ">Modifier un Adhérents</div>
            </div>
            <div class="panel-body">
            <DIV align="center">
                <form class="form-horizontal" name='identification' method="post" action="Controleur?action=saveAdherent" onsubmit="return teste()">
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
                    <button type="submit" class="btn btn-default">Modifier</button>
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
                    window.location = "Controleur?action=listerAdherent";
                } else if(data === "error") {
                    alert("Une erreur s'est produite..");
                }
            });
        }
    })
</script>
</body>
</html>