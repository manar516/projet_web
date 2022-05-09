<?php
	include 'C:/xampp/htdocs/HeroBiz/config.php';
	include_once 'C:/xampp/htdocs/HeroBiz/Model/message.php';
	class messageC {
		function affichermessage(){
			$sql="SELECT * FROM message";
			$db = config::getConnexion();
			try{
				$liste = $db->query($sql);
				return $liste;
			}
			catch(Exception $e){
				die('Erreur:'. $e->getMessage());
			}
		}
		function supprimerMessage($idmessage){
			$sql="DELETE FROM message WHERE idmessage=:idmessage";
			$db = config::getConnexion();
			$req=$db->prepare($sql);
			$req->bindValue(':idmessage', $idmessage);
			try{
				$req->execute();
			}
			catch(Exception $e){
				die('Erreur:'. $e->getMessage());
			}
		}
		function ajoutermessage($message){
			$db = config::getConnexion();
			try{
				$query = $db->prepare('INSERT INTO message VALUES (:idmes,:Em,:sub,:cont)');
				$query->execute([
					'idmes'=> $message->getIdmessage(),
					'Em' => $message->getEmail(),
					'sub' => $message->getSubject(),
					'cont' => $message->getContenu()
					
				]);			
			}
			catch (Exception $e){
				echo $e->getMessage();
			}			
		}
		function recuperermessage($idmessage){
			$sql="SELECT * from message where id=$idmessage";
			$db = config::getConnexion();
			try{
				$query=$db->prepare($sql);
				$query->execute();

				$message=$query->fetch();
				return $message;
			}
			catch (Exception $e){
				die('Erreur: '.$e->getMessage());
			}
		}
		
		function modifiermessage($message, $idmessage){
			try {
				$db = config::getConnexion();
				$query = $db->prepare(
					'UPDATE message SET 
						 
						email= :email, 
						subject= :subject, 
						contenue= :contenue 
						
					WHERE id= :idmessage'
				);
				$query->execute([
					
					'email' => $message->getEmail(),
					'subject' => $message->getSubject(),
					'contenue' => $message->getContenue(),
					'idmessage' => $idmessage
				]);
				echo $query->rowCount() . " records UPDATED successfully <br>";
			} catch (PDOException $e) {
				$e->getMessage();
			}
		}

	}
?>