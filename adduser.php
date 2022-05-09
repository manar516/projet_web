
<?PHP
include "entities/user.php";
include "core/userC.php";

if (isset($_POST['nom']) and isset($_POST['mail']) and isset($_POST['pass'])){
    $User1=new user($_POST['nom'],$_POST['mail'],$_POST['pass'],"client");
//Partie2
    /*
    var_dump($User1);
    }
    */
//Partie3
    $User1C=new UserC();
    $User1C->ajouterUser($User1);
    header('Location: home.php');

}else{
    echo "vérifier les champs";
}
//*/

