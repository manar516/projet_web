<?php
    include_once '../Model/commande.php';
    include_once '../Controller/commandeC.php';

    $error = "";

    // create commande
    $commande = null;

    // create an instance of the controller
    $commandeC = new commandeC();
    if (
        isset($_POST["id"]) &&
		isset($_POST["nbr"]) &&		
        isset($_POST["prix"])
	
    ) {
        if (
       
            !empty($_POST["id"]) && 
			!empty($_POST['nbr']) &&
            !empty($_POST["prix"])
        ) {
            $commande = new commande(
                $_POST['id'],
				$_POST['nbr'],
                $_POST['prix']
            );
            $commandeC->ajoutercommande($commande);
            header('Location:afficherListecommandes.php');
        }
        else
            $error = "Missing information";
    }

    
?>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Display</title>
</head>
    <body>
        <button><a href="afficherListecommandes.php">Retour à la liste des commande</a></button>
        <hr>
        
        <div id="error">
            <?php echo $error; ?>
        </div>
        
        <form action="" method="POST">
            <table border="1" align="center">
                <tr>
                    <td>
                        <label for="id">identifiant commande:
                        </label>
                    </td>
                    <td><input type="text" name="id" id="id"  required pattern="[0-9a-z]" maxlength="20"></td>
                </tr>
				<tr>
                    <td>
                        <label for="nbr">nbr:
                        </label>
                    </td>
                    <td><input type="text" name="nbr" id="nbr" maxlength="20"></td>
                </tr>
                <tr>
                    <td>
                        <label for="prix">prix:
                        </label>
                    </td>
                    <td><input type="text" name="prix" id="prix" maxlength="20"></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Envoyer"> 
                    </td>
                    <td>
                        <input type="reset" value="Annuler" >
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>