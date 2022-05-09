<?php
	include '../Controller/commandeC.php';
	$commandeC=new commandeC();
	$listecommandes=$commandeC->affichercommande(); 
?>

<html>
	<head></head>
	<body>
	    <button><a href="ajoutercommande.php">Ajouter un commande</a></button>
		<center><h1>Liste des commandes</h1></center>
		<table border="1" align="center">
			<tr>
				<th>id</th>
				<th>nbr</th>
				<th>prix</th>
				<th>Modifier</th>
				<th>Supprimer</th>
			</tr>
			<?php
				foreach($listecommandes as $commande){
			?>
			<tr>
				<td><?php echo $commande['id']; ?></td>
				<td><?php echo $commande['nbr']; ?></td>
				<td><?php echo $commande['prix']; ?></td>
			
				<td>
					<form method="POST" action="modifiercommande.php">
						<input type="submit" name="Modifier" value="Modifier">
						<input type="hidden" value=<?PHP echo $commande['id']; ?> name="id">
					</form>
				</td>
				<td>
					<a href="supprimercommande.php?id=<?php echo $commande['id']; ?>">Supprimer</a>
				</td>
			</tr>
			<?php
				}
			?>
		</table>
	</body>
</html>
