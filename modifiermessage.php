<?php
include_once '../../NiceAdmin/Model/message.php';
include_once '../../NiceAdmin/Controller/messageC.php';

$error = "";

// create message
$message = null;

// create an instance of the controller
$messageC = new messageC();
if (

    isset($_POST["idmessage"]) &&
    isset($_POST["email"]) &&
    isset($_POST["subject"]) &&
    isset($_POST["contenu"]) 
    //isset($_POST["recl"]) 
 
) {
    if (
        !empty($_POST["idmessage"]) &&
        !empty($_POST["email"]) &&
        !empty($_POST['subject']) &&
        !empty($_POST["contenu"]) 
        //!empty($_POST["recl"])

    ) {
        $message = new message(

            $_POST['idmessage'],
            $_POST['email'],
            $_POST['subject'],
            $_POST['contenu']
           // $_POST['recl']
        );
        $messageC->modifiermessage($message, $_POST["idmessage"]);
        header('Location:Listemessagess.php');
    } else
        $error = "Missing information";
}
?>



<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Modifier messages</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
    <link href="../../NiceAdmin/assets/img/favicon.png" rel="icon">
    <link href="../../NiceAdmin/assets/img/apple-touch-icon.png" rel="apple-touch-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Source+Sans+Pro:ital,wght@0,300;0,400;0,600;0,700;1,300;1,400;1,600;1,700&display=swap" rel="stylesheet">
    <link href="../../NiceAdmin/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../NiceAdmin/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="../../NiceAdmin/assets/vendor/aos/aos.css" rel="stylesheet">
    <link href="../../NiceAdmin/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="../../NiceAdmin/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
    <link href="../../NiceAdmin/assets/css/variables.css" rel="stylesheet">

    <link href="../../NiceAdmin/assets/css/main.css" rel="stylesheet">
</head>

<body>

    <!-- ======= Header ======= -->
    <header id="header" class="header fixed-top" data-scrollto-offset="0">
        <div class="container-fluid d-flex align-items-center justify-content-between">

            <a href="index.html" class="logo d-flex align-items-center scrollto me-auto me-lg-0">
                <!-- Uncomment the line below if you also wish to use an image logo -->
                <!-- <img src="assets/img/logo.png" alt=""> -->
                <h1>NiceAdmin<span>.</span></h1>
            </a>

            <nav id="navbar" class="navbar">


                <a class="nav-link" href="index.html#about">Home</a>
                <a class="nav-link" href="index.html#services">Services</a>
                <a class="nav-link" href="index.html#portfolio">Portfolio</a>
                <a class="nav-link" href="index.html#team">Team</a>

                <li style="list-style-type:none;" class="dropdown megamenu"><a href="#"><span>messages</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
                    <ul style="list-style-type:none;">
                        <li>
                            <a href="Listemessages.php">Listemessages</a>
                        </li>
                        <li>
                            <a href="ajoutermessage.php">Envoyer message </a>
                        </li>

                    </ul>
                </li>


                <a class="nav-link" href="index.html#contact">Contact</a>

                <i class="bi bi-list mobile-nav-toggle d-none"></i>
            </nav>
            <!-- .navbar -->

            <a class="btn-getstarted scrollto" href="index.html#about">Get Started</a>

        </div>
    </header>
    <section style="padding:170px">

    <center>
            <h1>Modifier des messages</h1>
        </center>
        <br>
        <br>
    <div style="color:red" id="error">
            <?php echo $error; ?>
        </div>
			
		<?php
			if (isset($_GET['idmessage'])){
				$message = $messageC->recuperermessage($_GET['idmessage']);
				
		?>
   


        <form action="" method="POST">
            <div class="form-group">
                <label for="Email">Email</label>
                <input type="Email" name="Email" id="Email" value="<?php echo $message['Email']; ?>" class="form-control" >

            </div>
            <div class="form-group">
                <label for="type">Type</label>
                <input type="text" name="type" id="type" value="<?php echo $message['type']; ?>" minlength="10" maxlength="50" class="form-control">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" name="description" id="description" value="<?php echo $message['description']; ?>" maxlength="200000" class="form-control">
            </div>
           
           
            <div class="form-group">
                <label for="idmessage">idmesg</label>
                <input type="text" name="idmessage" id="idmessage" value="<?php echo $message['idmessage']; ?>" maxlength="20"class="form-control">
            </div>
            <br>
            
                <button type="submit" class="btn btn-primary bi-check">Modifier</button>
                <button type="reset" class="btn btn-danger bi-x">Annuler</button>
        
        </form>
        <?php
		}
		?>


    </section>
</body>

</html>