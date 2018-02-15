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
    <title>Expo : Médiathèque De POLYTECH</title>
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
            padding-right:10px;
            padding-left:2px;
        }
        form{
            margin-bottom: 10px;
        }
    </style>
</head>
<SCRIPT language="Javascript" type="text/javascript"></SCRIPT>
<script type="text/javascript" src="js/fonctControle.js"></script>


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
                        <a class="glyphicon glyphicon-th-list" style="margin-left: 5px; margin-bottom: 10px" href="Controleur?action=listerAdherent"> Liste des Adhérents</a>
                        <a class="glyphicon glyphicon-home" style="margin-left: 5px; margin-bottom: 10px; display: block" href="index.jsp">  Accueil</a>
                        <a class="glyphicon glyphicon-remove" style="margin-left: 5px; margin-bottom: 10px" href="#">  Quitter</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-10 ">
	        <H1 style="text-align: center"> Ajout d'un adhérent </H1>

            <DIV align="center">
                <form class="form-horizontal" name='identification' method="post" action="Controleur?action=insererAdherent"  onsubmit="return teste()">
                    <div class="form-group">
                        <label class="col-sm-3">Nom de l'adhérent:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom de l'adhérent">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3">Prénom de l'adhérent:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control"  id="prenom" name="prenom" placeholder="Prénom de l'adhérent">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3">Ville de l'adhérent:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control"  id="ville" name="ville" placeholder="Ville de l'adhérent">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-default">Ajouter</button>
                </form>
            </DIV>
            </div>
        </div>
    </div>
    <footer class="container-fluid text-center">
        <p>Projet Oeuvres Par Mark, Fabien et Christian</p>
    </footer>
<BR>
</body>
</html>