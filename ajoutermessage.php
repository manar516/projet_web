<?php
include_once 'C:/xampp/htdocs/HeroBiz/Model/message.php';
include_once 'C:/xampp/htdocs/HeroBiz/Controller/messageC.php';

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
        !empty($_POST['idmessage']) &&
        !empty($_POST['email']) &&
        !empty($_POST["subject"]) &&
        !empty($_POST["contenu"]) 
       // !empty($_POST["recl"]) 
        
    ) {
        $message = new message(
            $_POST['idmessage'],
            $_POST['email'],
            $_POST['subject'],
            $_POST['contenu']
            //$_POST['recl']
            
        );

        $messageC->ajoutermessage($message);

        header('Location:Listemessages.php');
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
    <link href="../../HeroBiz/assets/img/favicon.png" rel="icon">
    <link href="../../HeroBiz/assets/img/apple-touch-icon.png" rel="apple-touch-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Source+Sans+Pro:ital,wght@0,300;0,400;0,600;0,700;1,300;1,400;1,600;1,700&display=swap" rel="stylesheet">
    <link href="../../HeroBiz/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../HeroBiz/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="../../HeroBiz/assets/vendor/aos/aos.css" rel="stylesheet">
    <link href="../../HeroBiz/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="../../HeroBiz/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
    <link href="../../HeroBiz/assets/css/variables.css" rel="stylesheet">

    <link href="../../HeroBiz/assets/css/main.css" rel="stylesheet">
</head>


<body>
    <header id="header" class="header fixed-top" data-scrollto-offset="0">
        <div class="container-fluid d-flex align-items-center justify-content-between">

            <a href="index.html" class="logo d-flex align-items-center scrollto me-auto me-lg-0">
                <!-- Uncomment the line below if you also wish to use an image logo -->
                <!-- <img src="assets/img/logo.png" alt=""> -->
                <h1>HeroBiz<span>.</span></h1>
            </a>

            <nav id="navbar" class="navbar">


                <a class="nav-link" href="index.html#about">Home</a>
                <a class="nav-link" href="index.html#services">Services</a>
                <a class="nav-link" href="index.html#portfolio">Portfolio</a>
                <a class="nav-link" href="index.html#team">Team</a>

                <li style="list-style-type:none;" class="dropdown megamenu"><a href="#"><span>Reclamations</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
                    <ul style="list-style-type:none;">
                        <li>
                            <a href="ListeReclamations.php">ListeReclamations</a>
                        </li>
                        <li>
                            <a href="ajouterReclamation.php">Envoyer Reclamation </a>
                        </li>

                    </ul>
                </li>


                <li style="list-style-type:none;" class="dropdown megamenu"><a href="#"><span>Message</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
                    <ul style="list-style-type:none;">
                        <li>
                            <a href="Listemessages.php">Listemessages</a>
                        </li>
                        <li>
                            <a href="ajoutermessage.php">Envoyer message</a>
                        </li>

                    </ul>
                </li>

                <i class="bi bi-list mobile-nav-toggle d-none"></i>
            </nav>
            <!-- .navbar -->

            <a class="btn-getstarted scrollto" href="index.html#about">Get Started</a>

        </div>
    </header>
    <section id="contact" class="contact">
    <div class="container">

<div class="section-header">
    <h2>Contact Us</h2>
    <p>Ea vitae aspernatur deserunt voluptatem impedit deserunt magnam occaecati dssumenda quas ut ad dolores adipisci aliquam.</p>
</div>

</div>

<div class="map">
<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12097.433213460943!2d-74.0062269!3d40.7101282!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb89d1fe6bc499443!2sDowntown+Conference+Center!5e0!3m2!1smk!2sbg!4v1539943755621" frameborder="0"
    allowfullscreen></iframe>
</div>
        <div style="color:red" id="error">
            <?php echo $error; ?>
        </div>
        <div class="container">

<div class="row gy-4 gx-lg-4">
<div class="col-lg-12">
        <form action="" method="POST">
            <center>Contacter Nous</center>
        <div class="form-group">
                <label for="idmessage">Idmessage</label>
                <input  type="text" name="idmessage" id="idmessage" maxlength="20" class="form-control">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" name="email" id="email"  class="form-control">

            </div>
          
            <div class="form-group">
                <label for="subject">Subject</label>
                <input  type="text" name="subject" id="subject" maxlength="2000" class="form-control" >
</div>
        
            <div class="form-group">
                <label for="contenu">Contenu</label>
                <input  type="text" name="contenu" id="contenu" maxlength="20" class="form-control">
            </div>
            <br>
            
                <button type="submit" class="btn btn-primary  bi-check">Envoyer</button>
                <button type="reset" class="btn btn-danger bi-x">Annuler</button>
            
        </form>
</div>
</div>
</div>
    </section>
</body>

</html>