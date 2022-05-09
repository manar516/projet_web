<?php
	class commande{
		private $id=null;
		private $nbr=null;
		private $prix=null;
		
	//	private $dateinscription;
		
		private $password=null;
		function __construct($id, $nbr, $prix){
			$this->id=$id;
			$this->nbr=$nbr;
			$this->prix=$prix;
		
		}
		function getid(){
			return $this->id;
		}
		function getnbr(){
			return $this->nbr;
		}
		function getprix(){
			return $this->prix;
		}
		
		function setnbr(string $nbr){
			$this->nbr=$nbr;
		}
		function setprix(string $prix){
			$this->prix=$prix;
		}
		
	}


?>