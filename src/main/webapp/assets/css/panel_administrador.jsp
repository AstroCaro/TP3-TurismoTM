<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="assets/css/estilos_panel_administrador.css">
    <script type="text/javascript" src="assets/js/admin_app.js" defer></script>
    <script src="https://kit.fontawesome.com/7cc28fa7fa.js" crossorigin="anonymous"></script>
    <title>Menú Lateral</title>
</head>

<body class="fondo">
    <nav>
        <div class="menulateral-top">
            <img src="assets/img/logo.png" class="logo" alt="">
            <h3 class="oculto">TierraMedia</h3>
        </div>

        <div class="buscador">
            <i class='bx bx-search'></i>
            <input type="text" class="oculto" placeholder="Buscar...">
        </div>

        <div class="menu-links">
            <ul>
                <div class="active-tab"></div>
                <li class="elemento-tooltip" data-tooltip="0">
                    <a href="#" class="active" data-active="0">
                        <div class="icon">
                            <i class='bx bx-layout'></i>
                            <i class='bx bxs-layout'></i>
                        </div>
                        <span class="link oculto">Tablero</span>
                    </a>
                </li>
                <li class="elemento-tooltip" data-tooltip="1">
                    <a href="#" data-active="1">
                        <div class="icon">
                            <i class="far fa-address-card"></i>
                            <i class="fas fa-address-card"></i>
                        </div>
                        <span class="link oculto">Usuarios</span>
                    </a>
                </li>
                <li class="elemento-tooltip" data-tooltip="2">
                    <a href="#" data-active="2">
                        <div class="icon">
                            <i class='bx bx-landscape'></i>
                            <i class='bx bxs-landscape'></i>
                        </div>
                        <span class="link oculto">Atracciones</span>
                    </a>
                </li>
                <li class="elemento-tooltip" data-tooltip="3">
                    <a href="#" data-active="3">
                        <div class="icon">
                            <i class='bx bx-box'></i>
                            <i class='bx bxs-box'></i>
                        </div>
                        <span class="link oculto">Promociones</span>
                    </a>
                </li>
                <li class="elemento-tooltip" data-tooltip="4">
                    <a href="#" data-active="4">
                        <div class="icon">
                            <i class='bx bx-collection'></i>
                            <i class='bx bxs-collection'></i>
                        </div>
                        <span class="link oculto">Tipo de atracciones</span>
                    </a>
                </li>
                <li class="elemento-tooltip" data-tooltip="5">
                    <a href="#" data-active="5">
                        <div class="icon">
                            <i class='bx bx-map-alt'></i>
                            <i class='bx bxs-map-alt'></i>
                        </div>
                        <span class="link oculto">Itinerarios </span>
                    </a>
                </li>
                <div class="tooltip">
                    <span class="mostrar">Tablero</span>
                    <span>Usuarios</span>
                    <span>Atracciones</span>
                    <span>Promociones</span>
                    <span>Tipo de atracciones</span>
                    <span>Itinerarios</span>
                </div>
            </ul>
        </div>
    </nav>
    <main>
        <div class="topbar">
            <div class="menu">
                <i class="fas fa-bars"></i>
            </div>

            <div class="action">
                <div class="profile">
                    <img src="assets/img/admin/gollum.jpg" alt="usuario">
                </div>

                <div class="menu-usuario fondo">
                    <h3>Gollum</h3>
                    <h5>Administrador de TurismoTM</h5>
                    <ul>
                        <li>
                            <a href="#">
                                <i class='bx bx-user-circle'></i>
                                <span>Mi Perfil</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class='bx bx-cog'></i>
                                <span>Configuracion</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class='bx bx-log-out'></i>
                                <span>Cerrar Sesion</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="contenido">
            <h1>Panel de Administracion</h1>
            <p class="text">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Explicabo voluptatibus iusto aliquam repudiandae perspiciatis officia atque reprehenderit distinctio maxime sint ratione consequatur sapiente repellendus quo doloribus cumque numquam dolores, ex
                earum quidem in alias exercitationem. Iste eos tempore ea reprehenderit debitis. Autem nisi optio saepe soluta culpa fuga a enim quidem excepturi. Aliquam soluta sunt perspiciatis alias fugiat? Eum, quam.
            </p>

        </div>
        <div class="copyright">
            <p>
                &copy; 2021 - <span>GrupoNULL</span> Todos los derechos reservados.
            </p>
        </div>
    </main>
</body>

</html>