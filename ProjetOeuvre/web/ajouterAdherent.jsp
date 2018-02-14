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
    </style>
</head>
<SCRIPT language="Javascript" type="text/javascript"></SCRIPT>
<script type="text/javascript" src="js/foncControle.js"></script>


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
                    <div class="panel-body-big" style="height: 60px">
                        <a class="glyphicon glyphicon-plus" style="margin-left: 5px; margin-bottom: 10px" href="Controleur?action=listerAdherent"> Liste des Adhérents</a>
                        <a class="glyphicon glyphicon-home" style="margin-left: 5px; margin-bottom: 10px" href="#">  Quitter</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-10 ">
	        <H1> Ajout d'un adhérent </H1>

            <DIV align="center">
                <FORM  name='identification' method="post" action="Controleur?action=insererAdherent" onsubmit="return teste()">
                     <P align="left"><FONT face="Arial" color="#004080"></FONT>
                        <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Nom de l'adherent : </FONT>
                        <INPUT type="text" name="txtnom" value=""  id ="nom"> <BR>
                        <FONT face="Arial" color="#004080">
                        <BR>Prenom de l'adherent : </FONT>
                        <INPUT type="text" name="txtprenom"  id ="prenom"  > <BR>

                        <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Ville de l'adherent :</FONT>
                        <INPUT type="text" name="txtville" id ="ville">
                        <FONT face="Arial" color="#004080">	<BR></FONT><BR>

                          <!-- Boutons Ajouter -->

                        <INPUT type="submit" name="bt"  value="Ajouter" >
                        <FONT face="Arial" color="#004080"></FONT>
                        &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                </P></FORM>
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