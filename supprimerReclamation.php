<?php
	include '../../HeroBiz/Controller/reclamationC.php';
	$reclamationC=new reclamationC();
	$reclamationC->supprimerreclamation($_GET["idrec"]);
	header('Location:ListeReclamations.php');
?>