<<<<<<< HEAD:Old/ProjetOeuvreSpringJPA/target/oeuvrespringjpa-0.0.1-SNAPSHOT/WEB-INF/views/ajouterAdherent.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un  adhérent</title>
</head>
<SCRIPT language="Javascript" type="text/javascript">
<script type="text/javascript" src="js/foncControle.js"></script>


<body>
	<H1> Ajout d'un adhérent </H1> 

<DIV align="center">
<FORM  name='identification' method="post" action="insererAdherent.htm" onsubmit="return teste()">
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
<BR>
</body>
=======
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
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/ajoutAdherent.css">
    <title>Expo : Médiathèque De POLYTECH</title>

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
                <div class="panel-title ">Ajouter un Adhérent</div>
            </div>
            <div class="panel-body">
            <DIV align="center">
                <form class="form-horizontal" name='identification' method="post" action="insererAdherent.htm"  onsubmit="return teste()">
                    <div class="form-group">
                        <label class="col-md-4 col-xs-4">Nom de l'adhérent:</label>
                        <div class="col-md-8 col-xs-8">
                            <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom de l'adhérent" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 col-xs-4">Prénom de l'adhérent:</label>
                        <div class="col-md-8 col-xs-8">
                            <input type="text" class="form-control"  id="prenom" name="prenom" placeholder="Prénom de l'adhérent" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 col-xs-4">Ville de l'adhérent:</label>
                        <div class="col-md-8 col-xs-8">
                            <input type="text" class="form-control"  id="ville" name="ville" placeholder="Ville de l'adhérent" required>
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
<BR>
</body>
>>>>>>> config-spring-jpa:ProjetOeuvreSpringJPA/src/main/webapp/WEB-INF/views/ajouterAdherent.jsp
</html>