<?php
	include '../config.php';
	include_once '../Model/commande.php';
	class commandeC {
		function affichercommande(){
			$sql="SELECT * FROM commande";
			$db = config::getConnexion();
			try{
				$liste = $db->query($sql);
				return $liste;
			}
			catch(Exception $e){
				die('Erreur:'. $e->getMeesage());
			}
		}
		function supprimercommande($id){
			$sql="DELETE FROM commande WHERE id=:id";
			$db = config::getConnexion();
			$req=$db->prepare($sql);
			$req->bindValue(':id', $id);
			try{
				$req->execute();
			}
			catch(Exception $e){
				die('Erreur:'. $e->getMeesage());
			}
		}
		function ajoutercommande($commande){
			$sql="INSERT INTO commande (id, nbr, prix) 
			VALUES (:id,:nbr,:prix)";
			$db = config::getConnexion();
			try{
				$query = $db->prepare($sql);
				$query->execute([
					'id' => $commande->getid(),
					'nbr' => $commande->getnbr(),
					'prix' => $commande->getprix()
				]);			
			}
			catch (Exception $e){
				echo 'Erreur: '.$e->getMessage();
			}			
		}
		function recuperercommande($id){
			$sql="SELECT * from commande where id=$id";
			$db = config::getConnexion();
			try{
				$query=$db->prepare($sql);
				$query->execute();

				$commande=$query->fetch();
				return $commande;
			}
			catch (Exception $e){
				die('Erreur: '.$e->getMessage());
			}
		}
		
		function modifiercommande($commande, $id){
			try {
				$db = config::getConnexion();
				$query = $db->prepare(
					'UPDATE commande SET 
						id= :id, 
						nbr= :nbr, 
						prix= :prix
					WHERE id= :id'
				);
				$query->execute([
					'id' => $commande->getid(),
					'nbr' => $commande->getnbr(),
					'prix' => $commande->getprix(),
					'id' => $id
				]);
				echo $query->rowCount() . " records UPDATED successfully <br>";
			} catch (PDOException $e) {
				$e->getMessage();
			}
		}

	}
?>