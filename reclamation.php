<?php
	class reclamation{
	
		private $type=null;
		private $description=null;
        private $idrec=null;
		//private $datedenv;
        private $Email=null;
		private $statut=null;
		
		private $password=null;
		function __construct( $type, $description, $idrec, $Email){
			
			$this->type=$type;
			$this->description=$description;
			//$this->datedenv=$datedenv;
            $this->idrec=$idrec;
            $this->Email=$Email;
			$this->statut=0;

		}
		
		
		function getType(){
			return $this->type;
		}
		function getDescription(){
			return $this->description;
		}
        function getIdrec(){
			return $this->idrec;
		}
         //function getDatedenv(){
			//return $this->datedenv=$datedenv;
		// }
		function getEmail(){
			return $this->Email;
		}
		function getStatut(){
			return $this->statut;
		}
		
		function setType(string $type){
			$this->type=$type;
		}
		function setDescription(string $description){
			$this->description=$description;
		}
		
		// function setdatedenv(string $datedenv){
		//	$this->datedenv=$datedenv;
		//} 
        function setEmail(string $Email){
			$this->Email=$Email;
		}
		function setStatut(string $statut){
			$this->statut=$statut;
		}
		
	}


?>

