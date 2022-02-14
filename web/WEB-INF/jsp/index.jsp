<%@page import="model.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.controladorActual"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Login</title>
        <!-- HTML5 Shim and Respond.js IE10 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 10]>
                    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
                    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
                    <![endif]-->
        <!-- Meta -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Datta Able Bootstrap admin template made using Bootstrap 4 and it has huge amount of ready made feature, UI components, pages which completely fulfills any dashboard needs.">
        <meta name="keywords" content="admin templates, bootstrap admin templates, bootstrap 4, dashboard, dashboard templets, sass admin templets, html admin templates, responsive, bootstrap admin templates free download,premium bootstrap admin templates, datta able, datta able bootstrap admin template, free admin theme, free dashboard template">
        <meta name="author" content="CodedThemes">

        <!-- Favicon icon -->
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
        <!-- fontawesome icon -->
        <link rel="stylesheet" href="assets/fonts/fontawesome/css/fontawesome-all.min.css">
        <!-- animation css -->
        <link rel="stylesheet" href="assets/plugins/animation/css/animate.min.css">
        <!-- vendor css -->
        <link rel="stylesheet" href="assets/css/style.css">
        <script type="text/javascript" src="assets/js/validar1.js"></script> 
        <script>
            var input = document.getElementById('usuario');
            input.oninvalid = function (event) {
                event.target.setCustomValidity('Username should only contain lowercase letters. e.g. john');
            }
        </script>

    </head>
    <body>
        <div class="auth-wrapper">
            <div class="auth-content">
                <div class="auth-bg">
                    <span class="r"></span>
                    <span class="r s"></span>
                    <span class="r s"></span>
                    <span class="r"></span>
                </div>
                <div class="card">
                    <form action="controladorActual" method="post" name="addForm">
                        <div class="card-body text-center">
                            <div class="mb-4">
                                <%-- ${usuar}--%>
                                <i class="feather icon-unlock auth-icon"></i>                                  
                            </div>
                            <div>
                                <%            if (Variables.mensajeRegistrado == 1) {
                                        Variables.mensajeRegistrado = 0;
                                %>
                                <div class="alert alert-success alert-dismissible fade show text-center" role="alert" style="float: top;" id="alert">
                                    <strong>Genial!</strong> Cambio realizado.
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </div>
                                <script>
                                    setTimeout(function () {
                                        $(".alert").each(function (index) {
                                            $(this).delay(200 * index).fadeTo(1500, 0).slideUp(500, function () {
                                                $(this).remove();
                                            });
                                        });
                                    }, 1000);
                                </script>
                                <% }%> 
                            </div>
                            <div>
                                <%            if (Variables.mensajeError == 1) {
                                        Variables.mensajeError = 0;
                                %>
                                <div class="alert alert-danger alert-dismissible fade show text-center" role="alert" style="float: top;" id="alert">
                                    <strong>Ups!</strong> Usuario o contraseña erroneo.
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </div>
                                <script>
                                    setTimeout(function () {
                                        $(".alert").each(function (index) {
                                            $(this).delay(200 * index).fadeTo(1500, 0).slideUp(500, function () {
                                                $(this).remove();
                                            });
                                        });
                                    }, 2000);
                                </script>
                                <% }%> 
                            </div>
                            <div>
                                <%            if (Variables.mensajeError == 2) {
                                        Variables.mensajeError = 0;
                                %>
                                <div class="alert alert-danger alert-dismissible fade show text-center" role="alert" style="float: top;" id="alert">
                                    <strong>Ndi!</strong> Usuario bloqueado. Contacte con el administrador.
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </div>
                                <script>
                                    setTimeout(function () {
                                        $(".alert").each(function (index) {
                                            $(this).delay(200 * index).fadeTo(1500, 0).slideUp(500, function () {
                                                $(this).remove();
                                            });
                                        });
                                    }, 5000);
                                </script>
                                <% }%> 
                            </div>
                            <div>
                                <%            if (Variables.mensajeError == 3) {
                                        Variables.mensajeError = 0;
                                %>
                                <div class="alert alert-primary alert-dismissible fade show text-center" role="alert" style="float: top;" id="alert">
                                    <strong>Ndi!</strong> Este usuario está bloqueado. Contacte con el administrador.
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </div>
                                <script>
                                    setTimeout(function () {
                                        $(".alert").each(function (index) {
                                            $(this).delay(200 * index).fadeTo(1500, 0).slideUp(500, function () {
                                                $(this).remove();
                                            });
                                        });
                                    }, 5000);
                                </script>
                                <% }%> 
                            </div>
                            <h3 class="mb-4">Bienvenido al sistema</h3>
                            <h3 class="mb-4">Ingrese sus credenciales</h3> <!-- ESTE DIV MUESTRA EL MENSAJE -->
                            <div id="alerta1"></div> 
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="txtusuario" placeholder="usuario" id="usuario" autofocus="true">
                            </div>
                            <div class="input-group mb-4">
                                <input type="password" class="form-control" name="txtcontrasena" placeholder="contraseña" id="password">
                            </div>
                            <div class="form-group text-left">
                                <%--
                                <div class="checkbox checkbox-fill d-inline">
                                    <input type="checkbox" name="checkbox-fill-1" id="checkbox-fill-a1" checked="">
                                    <label for="checkbox-fill-a1" class="cr"> Save Details</label>
                                </div>
                                --%>
                            </div>
                         <!--   <input type="submit" name="accion" value="Ingresar" class="btn btn-primary shadow-2 mb-4"> -->
                            <button type="button" onclick="validarFormulario1();" class="btn btn-primary shadow-2 mb-4">Ingresar</button>
                            <%--
                                                        <p class="mb-2 text-muted">Olvido su password? <a href="auth-reset-password.html">Reset</a></p>
                                                        <p class="mb-0 text-muted">No tiene una cuenta? <a href="auth-signup.html">Signup</a></p>
                            --%>
                        </div>
                    </form>

                </div>
            </div>
        </div>
        <!-- Required Js -->
        <script src="assets/js/vendor-all.min.js"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>