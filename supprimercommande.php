<?php
	include '../Controller/commandeC.php';
	$commandeC=new commandeC();
	$commandeC->supprimercommande($_GET["id"]);
	header('Location:afficherListecommandes.php');
?>