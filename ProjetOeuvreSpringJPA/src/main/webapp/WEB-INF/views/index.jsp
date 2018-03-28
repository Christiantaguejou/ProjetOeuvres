<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="refresh" content="0;URL=javascript:fermer();">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/resources/css/style.css">
	<link rel="stylesheet" href="/resources/css/index.css">
	<title>Expo : Médiathèque De POLYTECH</title>

</head>

<body>
		<jsp:include page="header.jsp" />
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title ">Gestion de l'exposition 2018</div>
				</div>
				<div class="panel-body">
                    <h4 align="center">Sélectionnez la fonctionnalité voulue:</h4>

					<div class="row content">
                        <div class="col-md-1 col-xs-1"></div>
                        <div class="col-md-10 col-xs-10">
                            <div class="col-md-4 col-xs-4 fonctionnalite">
                                <img src="/resources/img/add.PNG" class="img-responsive image" alt="Image">
                                <div class="middle">
                                    <a class="text" href="ajouterAdherent.htm">Ajout Adhérent</a>
                                </div>
                            </div>
                            <div class="col-md-4 col-xs-4 fonctionnalite">
                                <img src="/resources/img/list.png" class="img-responsive image"  alt="Image">
                                <div class="middle">
                                    <a class="text" href="listerAdherent.htm">Lister Les Adhérents</a>
                                </div>
                            </div>
                            <div class="col-md-4 col-xs-4 fonctionnalite">
                                <img src="/resources/img/quit.png" class="img-responsive image"  alt="Image">
                                <div class="middle">
                                    <a class="text" ref="javascript:fermer()">Quitter</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-1 col-xs-1"></div>
					</div>

                    <div class="row content rowSpace">
                        <div class="col-md-1 col-xs-1"></div>
                        <div class="col-md-10 col-xs-10">
                            <div class="col-md-4 col-xs-4 fonctionnalite">
                                <img src="/resources/img/oeuvre.png" class="img-responsive image"  alt="Image">
                                <div class="middle">
                                    <a class="text" href="ajouterOeuvre.htm">Ajouter Une Oeuvre</a>
                                </div>
                            </div>
                            <div class="col-md-4 col-xs-4 fonctionnalite">
                                <img src="/resources/img/gestion.png" class="img-responsive image"  alt="Image">
                                <div class="middle">
                                    <a class="text" href="listerOeuvre.htm">Lister Oeuvres</a>
                                </div>
                            </div>
                            <div class="col-md-4 col-xs-4 fonctionnalite">
                                <img src="/resources/img/reservation.png" class="img-responsive image"  alt="Image">
                                <div class="middle">
                                    <a class="text" href="listerReservations.htm">Lister Réservations</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-1 col-xs-1"></div>
                    </div>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp" />

	<script language="JavaScript">
        function fermer() {

        }
	</script>
</body>
</html>