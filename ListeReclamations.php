<?php
include '../../HeroBiz/Controller/reclamationC.php';
$reclamationC = new reclamationC();
$listereclamations = $reclamationC->afficherreclamations();
?>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Modifier Reclamations</title>
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

    <!-- ======= Header ======= -->
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
    <section style="padding:170px">
        
    <center>
            <h1>Liste des reclamations</h1>
        </center>

       <table class="table table-border table-striped">
            <thead>
                <tr>
                    <th scope="col">Type</th>
                    <th scope="col">Description</th>
                    <th scope="col">Idrec</th>
                    <th scope="col">Email</th>
                    <th scope="col">statut</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>

            <?php
            foreach ($listereclamations as $reclamation) {
            ?>
                <tr>

                    <td>
                        <?php echo $reclamation['type']; ?>
                    </td>
                    <td>
                        <?php echo $reclamation['description']; ?>
                    </td>
                    <td>
                        <?php echo $reclamation['idrec']; ?>
                    </td>


                    <td>
                        <?php echo $reclamation['Email']; ?>
                    </td>
                    <td>
                       <?php if($reclamation['statut']==0){echo ' <p><a class="btn btn-warning" aria-disabled="true"> En cours </a></p>';}else {echo ' <p><a aria-disabled="true" class="btn btn-success">Réglée</a></p>';}?>
                    </td>
                    <td>
                        <!-- <form method="POST" action="modifierReclamation.php">
                            <input type="submit" name="Modifier" value="Modifier">
                            <input type="hidden" value=<?PHP echo $reclamation['idrec']; ?> name="idrec">
                        </form> -->
                        <a class="btn btn-primary fa fa-pencil" href="modifierReclamation.php?idrec=<?php echo $reclamation['idrec']; ?>">Modifier</a>

                        <a class="btn btn-danger fa fa-trash" href="supprimerReclamation.php?idrec=<?php echo $reclamation['idrec']; ?>">Supprimer</a>
                    </td>
                </tr>
            <?php
            }
            ?>

        </table>
    </section>
</body>

</html>