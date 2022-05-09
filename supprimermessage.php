<?php
	include 'C:/xampp/htdocs/HeroBiz/Controller/messageC.php';
	$messageC=new messageC();
	$messageC->supprimermessage($_GET["idmessage"]);
	header('Location:Listemessages.php');
?>