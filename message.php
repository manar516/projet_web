<?php
	class message{
		private $idmessage=null;
		private $email=null;
		private $subject=null;
		private $contenu=null;
		//private $recl=null;
		
		
		function __construct( $idmessage,$email,$subject, $contenu){
			
			$this->idmessage=$idmessage;
			$this->email=$email;
            $this->subject=$subject;
			$this->contenu=$contenu;
			//$this->recl=$recl;
			
		}

        
		function getIdmessage(){
			return $this->idmessage;
		}
		
		function getEmail(){
			return $this->email;
		}
		function getSubject(){
			return $this->subject;
        }
		function getContenu(){
			return $this->contenu;
		}
		//function getRecl(){
			//return $this->recl;
		//}

		function setIdmessage($idmessage){
			return $this->idmessage= $idmessage;
		}
		
		
	    function setemail($email){
			return $this->email= $email;
		}
		
		function setsubject($subject){
			return $this->subject= $subject;
		}

		
		function setconetenue($contenu){
			return $this->contenu= $contenu;
		}
		//function setrecl($recl){
			//return $this->recl= $recl;
		//}




	}


?>