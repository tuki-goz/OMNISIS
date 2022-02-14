<%-- 
    Document   : usuario.jsp
    Created on : 07/06/2021, 03:49:40 PM
    Author     : Alvaro
--%>

<%@page import="model.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario01"%>
<%@page import="model.Perfil"%>
<%@page import="model.Funcionario"%>
<%@page import="java.util.HashMap"%>
<%
    Usuario01 usu;
    usu = (Usuario01) request.getAttribute("Usuario01");

%>
<!DOCTYPE html>
<html>
    <head>
        <title>Usuario</title>
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
        <script type = "text/javascript">
            (function () {
                var input = document.getElementById('descri');
                var form = document.getElementById('form');
                var elem = document.createElement('div');
                elem.id = 'notify';
                elem.style.display = 'none';
                form.appendChild(elem);
                input.addEventListener('invalid', function (event) {
                    event.preventDefault();
                    if (!event.target.validity.valid) {
                        input.className = 'invalid animated shake';
                        elem.textContent = 'Username should only contain lowercase letters e.g. john';
                        elem.className = 'error';
                        elem.style.display = 'block';
                    }
                });
                input.addEventListener('input', function (event) {
                    if ('block' === elem.style.display) {
                        input.className = '';
                        elem.style.display = 'none';
                    }
                });
            })();
        </script>
        <script type = "text/javascript">
            (function () {
                var input = document.getElementById('email');
                var form = document.getElementById('form');
                var elem = document.createElement('div');
                elem.id = 'notify';
                elem.style.display = 'none';
                form.appendChild(elem);
                input.addEventListener('invalid', function (event) {
                    event.preventDefault();
                    if (!event.target.validity.valid) {
                        input.className = 'invalid animated shake';
                        elem.textContent = 'Username should only contain lowercase letters e.g. john';
                        elem.className = 'error';
                        elem.style.display = 'block';
                    }
                });
                input.addEventListener('input', function (event) {
                    if ('block' === elem.style.display) {
                        input.className = '';
                        elem.style.display = 'none';
                    }
                });
            })();
        </script>
    </head>
    <style>
        .btn-light {
            color: #f4f7fa;
            background-color: #3f4d67;
            border-color: #3f4d67;
        }

        .body {
            font-family: "Open Sans", sans-serif;
            font-size: 14px;
            color: #212529;
            font-weight: 400;
            background: #f4f7fa;
            position: relative;
        }

        .card {
            border-radius: 0;
            -webkit-box-shadow: 0 1px 20px 0 rgb(69 90 100 / 8%);
            box-shadow: 0 1px 20px 0 rgb(69 90 100 / 8%);
            border: none;
            margin-bottom: 30px;
            -webkit-transition: all 0.5s ease-in-out;
            transition: all 0.5s ease-in-out;
        }

        *, ::after, ::before {
            box-sizing: border-box;
        }
    </style>    
    <body>
        <div class="loader-bg">
            <div class="loader-track">
                <div class="loader-fill"></div>
            </div>
        </div>
        <nav class="pcoded-navbar">
            <div class="navbar-wrapper">
                <div class="navbar-brand header-logo">
                    <a href="Principal.jsp" class="b-brand">
                        <div class="b-bg">
                            <i class="feather icon-trending-up"></i>
                        </div>
                        <span class="b-title">OMNISIS</span>
                    </a>
                    <a class="mobile-menu" id="mobile-collapse" href="javascript:"><span></span></a>
                </div>
                <div class="navbar-content scroll-div">
                    <ul class="nav pcoded-inner-navbar">
                        <li class="nav-item pcoded-menu-caption">
                            <label>Modulos del Sistema</label>
                        </li>
                        <%-- ------------------- Modulo Referenciales ------------------- --%>
                        <% if (Variables.usuarioConectado.getId_perfil() == 1) { %> 
                        <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">

                            <a href="javascript:" class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">Referenciales</span></a>
                            <ul class="pcoded-submenu" style="display: none;">
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="pais" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Pais"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="departamento" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Departamento"></span>
                                            </form>
                                    </a>
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="ciudad" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Ciudad"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="barrio" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Barrio"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="funcionario" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Funcionario"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="proveedor" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Proveedor"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="cliente" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Cliente"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="tipo_pago" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Tipo de Pago"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="forma_cobro" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Condicion de Pago"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="caja" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Caja"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="tipo_servicio" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Tipo de Servicio"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="moneda" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Moneda"></span>
                                            </form>
                                    </a> 
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="impuesto" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Impuesto"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="banco" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Banco"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="timbrado" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Timbrado"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-refresh-cw"></i></span><span class="pcoded-mtext">
                                            <form action="fiscal" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Fiscal"></span>
                                            </form>
                                    </a> 
                                </li>                                
                            </ul>
                        </li>
                        <% } %>

                        <%-- ------------------- Modulo Usuarios ------------------- --%>
                        <% if (Variables.usuarioConectado.getId_perfil() == 1) { %> 
                        <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                            <a href="javascript:" class="nav-link "><span class="pcoded-micon"><i class="feather icon-users"></i></span><span class="pcoded-mtext">Usuarios</span></a>
                            <ul class="pcoded-submenu" style="display: none;">
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-users"></i></span><span class="pcoded-mtext">
                                            <form action="perfil" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Perfil"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-users"></i></span><span class="pcoded-mtext">
                                            <form action="usuario" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Usuarios"></span>
                                            </form>
                                    </a>  
                                </li>
                            </ul>
                        </li>
                        <% } %>

                        <%-- ------------------- Modulo Servicios ------------------- --%>
                        <% if (Variables.usuarioConectado.getId_perfil() == 1 || Variables.usuarioConectado.getId_perfil() == 3) { %>
                        <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                            <a href="javascript:" class="nav-link "><span class="pcoded-micon"><i class="feather icon-settings"></i></span><span class="pcoded-mtext">Servicios</span></a>
                            <ul class="pcoded-submenu" style="display: none;">                                
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-settings"></i></span><span class="pcoded-mtext">
                                            <form action="producto" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Producto"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-settings"></i></span><span class="pcoded-mtext">
                                            <form action="servicio" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Servicio"></span>
                                            </form>
                                    </a> 
                                </li>
                            </ul>
                        </li>
                        <% } %>

                        <%-- ------------------- Modulo Importaciones ------------------- --%>
                        <% if (Variables.usuarioConectado.getId_perfil() == 1 || Variables.usuarioConectado.getId_perfil() == 4) { %>
                        <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                            <a href="javascript:" class="nav-link "><span class="pcoded-micon"><i class="feather icon-anchor"></i></span><span class="pcoded-mtext">Importación</span></a>
                            <ul class="pcoded-submenu" style="display: none;">
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-anchor"></i></span><span class="pcoded-mtext">
                                            <form action="importacion" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Importacion"></span>
                                            </form>
                                    </a> 
                                </li>
                            </ul>
                        </li>
                        <% } %>

                        <%-- ------------------- Modulo Compras ------------------- --%>
                        <% if (Variables.usuarioConectado.getId_perfil() == 1 || Variables.usuarioConectado.getId_perfil() == 4) { %>
                        <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                            <a href="javascript:" class="nav-link "><span class="pcoded-micon"><i class="feather icon-shopping-cart"></i></span><span class="pcoded-mtext">Compras</span></a>
                            <ul class="pcoded-submenu" style="display: none;">
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-shopping-cart"></i></span><span class="pcoded-mtext">
                                            <form action="ordencompra" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Pedido de Compra"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-shopping-cart"></i></span><span class="pcoded-mtext">
                                            <form action="ordencompra" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Orden de Compra"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-shopping-cart"></i></span><span class="pcoded-mtext">
                                            <form action="compra" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Compra"></span>
                                            </form>
                                    </a> 
                                </li>
                            </ul>
                        </li>
                        <% } %>

                        <%-- ------------------- Modulo Ventas ------------------- --%>
                        <% if (Variables.usuarioConectado.getId_perfil() == 1 || Variables.usuarioConectado.getId_perfil() == 2) { %>
                        <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                            <a href="javascript:" class="nav-link "><span class="pcoded-micon"><i class="feather icon-percent"></i></span><span class="pcoded-mtext">Ventas</span></a>
                            <ul class="pcoded-submenu" style="display: none;">
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-percent"></i></span><span class="pcoded-mtext">
                                            <form action="tipocontrato" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Tipo Contrato"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-percent"></i></span><span class="pcoded-mtext">
                                            <form action="contrato" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Contrato"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-percent"></i></span><span class="pcoded-mtext">
                                            <form action="venta" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Venta"></span>
                                            </form>
                                    </a>  
                                </li>
                            </ul>
                        </li>
                        <% } %>

                        <%-- ------------------- Modulo Cobranzas y Pagos ------------------- --%>
                        <% if (Variables.usuarioConectado.getId_perfil() == 1) { %> 
                        <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                            <a href="javascript:" class="nav-link "><span class="pcoded-micon"><i class="feather icon-credit-card"></i></span><span class="pcoded-mtext">Cobranzas y Pagos</span></a>
                            <ul class="pcoded-submenu" style="display: none;">
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-credit-card"></i></span><span class="pcoded-mtext">
                                            <form action="caja" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Administrar Caja"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-credit-card"></i></span><span class="pcoded-mtext">
                                            <form action="cobro" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Cobro"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-credit-card"></i></span><span class="pcoded-mtext">
                                            <form action="cta_pagar" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Pago"></span>
                                            </form>
                                    </a> 
                                </li>
                            </ul>
                        </li>
                        <% } %>

                        <%-- ------------------- Modulo Informes ------------------- --%>
                        <% if (Variables.usuarioConectado.getId_perfil() == 1 || Variables.usuarioConectado.getId_perfil() == 2 || Variables.usuarioConectado.getId_perfil() == 4 || Variables.usuarioConectado.getId_perfil() == 3 || Variables.usuarioConectado.getId_perfil() == 5) { %>
                        <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                            <a href="javascript:" class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">Informes</span></a>
                            <ul class="pcoded-submenu" style="display: none;">
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <form action="informeCompra" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Compra"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <form action="informeVentas" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Venta"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <form action="informeReferenciales" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Referenciales"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <form action="informeContratos" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Contratos"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <form action="informeImportaciones" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Importacion"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <form action="informeServicios" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Servicios"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <form action="informeProductos" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Productos"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <form action="informePagos" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Pagos"></span>
                                            </form>
                                    </a> 
                                </li>
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <form action="informeCobros" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Cobros"></span>
                                            </form>
                                    </a> 
                                </li>

                            </ul>
                        </li>
                        <% } %> 

                        <form class="form-inline mr-auto" target="_self">
                        </form>


                    </ul>
                    <br>
                    <br>
                    <br>
                    <br>
                    <ul class="nav pcoded-inner-navbar">
                        <a class="btn btn-light action-button" role="button" href="index.htm">Salir</a>

                    </ul>
                </div> 
            </div>      
        </nav>
          <header class="navbar pcoded-header navbar-expand-lg navbar-light">
            <div class="m-header">
                <a class="mobile-menu" id="mobile-collapse1" href="javascript:"><span></span></a>
                <a href="Principal.jsp" class="b-brand">
                    <div class="b-bg">
                        <i class="feather icon-trending-up"></i>
                    </div>
                    <span class="b-title">OMNISIS</span>
                </a>
            </div>
            <a class="mobile-menu" id="mobile-header" href="javascript:">
                <i class="feather icon-more-horizontal"></i>
            </a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav mr-auto">
                    <li><a href="javascript:" class="full-screen" onclick="javascript:toggleFullScreen()"><i class="feather icon-maximize"></i></a></li>                    
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li>
                        <div class="dropdown drp-user show">   
                            <a href="javascript:" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <i class="icon feather icon-settings"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right profile-notification show">
                                <div class="pro-head">
                                    <img src="assets/images/user/avatar-1.jpg" class="img-radius" alt="User-Profile-Image">
                                    <span>
                                        <%= Variables.usuarioConectado.getNumero_usuario()%>
                                    </span>
                                    <a href="index.htm" class="dud-logout" title="Logout">
                                        <i class="feather icon-log-out"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>            
        </header>
        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <div class="pcoded-content">
                    <div class="pcoded-inner-content">
                        <!-- [ breadcrumb ] start -->
                        <div class="page-header">
                            <div class="page-block">
                                <div class="row align-items-center">
                                    <div class="col-md-12">
                                        <div class="page-header-title">
                                            <h1 class="m-b-10">Registrar nuevo usuario</h1>
                                        </div>
                                        <div class="page-header-title">
                                            <h5 class="m-b-10"></h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- [ breadcrumb ] end -->
                        <div class="main-body">
                            <div class="page-wrapper">
                                <!-- [ Main Content ] start -->
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card">
                                            <div>
                                                <%            if (Variables.mensajeCampoVacio == 1) {
                                                %>
                                                <div class="alert alert-danger alert-dismissible fade show text-center" role="alert" style="float: top;" id="alert">
                                                    <strong>Jeje!</strong> El campo no puede quedar vacío.
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
                                                %>
                                                <div class="alert alert-danger alert-dismissible fade show text-center" role="alert" style="float: top;">
                                                    <strong>Ups!</strong> Hubo un error.
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
                                                <%            if (Variables.existe == 1) {
                                                %>
                                                <div class="alert alert-warning alert-dismissible fade show text-center" role="alert" style="float: top;">
                                                    <strong>Ups!</strong> Este usuario ya existe. Cambie el nombre de usuario o el funcionario.
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
                                                    }, 3000);
                                                </script>
                                                <% }%>   
                                            </div>
                                            <div class="card-body">
                                                <h5>Por favor, complete los campos</h5>
                                                <hr>
                                                <form action="usuario" method="POST" id="form">
                                                    <div class="row">
                                                        <div class="col-md-6">                                                            
                                                            <div class="form-group">                                                                 
                                                                <h5 class="mt-5">Usuario</h5>
                                                                <% if (usu.getNom_usu() != null) {%>  <%--para sacar null--%>
                                                                &nbsp;&nbsp;&nbsp;<input type="text" name="nombretxt" class="form-control" placeholder="Ej: ramon_m" aria-label="Card Holder" aria-describedby="basic-addon1" pattern="[[A-Z]{1}[a-z_-.+]{2}\D{1,}" id="descri" title="ramonm" value="<%=usu.getNom_usu()%>">
                                                                <%  } else {%>
                                                                &nbsp;&nbsp;&nbsp;<input type="text" name="nombretxt" class="form-control" placeholder="Ej: ramon_m" aria-label="Card Holder" aria-describedby="basic-addon1" pattern="[[A-Z]{1}[a-z_-.+]{2}\D{1,}" id="descri" title="ramonm" autofocus="true" value="">
                                                                <% }%>  
                                                                <input id="card-holder" type="hidden" name="idtxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= usu.getId_usua()%>">
                                                            </div>
                                                            <div class="form-group">                                                                 
                                                                <h5 class="mt-5">Clave</h5>
                                                                <% if (usu.getClave_usu() != null) {%> 
                                                                &nbsp;&nbsp;&nbsp;<input id="clavetxt" type="password" name="clavetxt" class="form-control" placeholder="Ej: *****" aria-label="Card Holder" aria-describedby="basic-addon1" pattern="[[A-Z]{1}[a-z]{2}{8,}" title="Debe contener minimo 8 caracteres" id="clave" value="<%= usu.getClave_usu()%>">
                                                                <%  } else {%>
                                                                &nbsp;&nbsp;&nbsp;<input id="clavetxt" type="password" name="clavetxt" class="form-control" placeholder="Ej: *****" aria-label="Card Holder" aria-describedby="basic-addon1" pattern="[[A-Z]{1}[a-z]{2}{8,}" title="Debe contener minimo 8 caracteres" id="clave" value="123" readonly="true">
                                                                <% }%>

                                                                <h5 class="mt-5">Perfil</h5>
                                                                <select id="drop_per" name="drop_per" class="form-control" onChange="update()">
                                                                    <%
                                                                        Perfil per = new Perfil();
                                                                        HashMap<String, String> drop = per.seleccionarPerfil();
                                                                        for (String i : drop.keySet()) {
                                                                            if (usu.getDescr_per() != null) {
                                                                                if (drop.get(i).toString().equals(usu.getDescr_per().toString())) {
                                                                                    out.println("<option value='" + i + "' selected>" + drop.get(i) + "</option>");
                                                                                } else {
                                                                                    out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                                                                                }
                                                                            } else {
                                                                                out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                                                                            }
                                                                        }
                                                                    %>
                                                                </select>

                                                            </div>
                                                        </div>


                                                        <div class="col-md-6">
                                                            <div class="form-group "> 
                                                                <h5 class="mt-5">Email</h5>
                                                                <% if (usu.getEmail_usu() != null) {%> 
                                                                &nbsp;&nbsp;&nbsp;<input id="emailtxt" type="text" name="emailtxt" class="form-control" placeholder="Email" aria-label="Card Holder" aria-describedby="basic-addon1" pattern="^[^@]+@[^@]+\.[a-zA-Z]{2,}$" title="rmendez@radar.com" id="email" value="<%= usu.getEmail_usu()%>">
                                                                <%  } else {%>
                                                                &nbsp;&nbsp;&nbsp;<input id="emailtxt" type="text" name="emailtxt" class="form-control" placeholder="Email" aria-label="Card Holder" aria-describedby="basic-addon1" pattern="^[^@]+@[^@]+\.[a-zA-Z]{2,}$" title="rmendez@radar.com" id="email" value="">
                                                                <% }%>
                                                                <br>                                                             

                                                                <h5 class="mt-5">Funcionario</h5>
                                                                <select id="drop_fun" name="drop_fun" class="form-control" onChange="update()" >
                                                                    <%
                                                                        Funcionario fun = new Funcionario();
                                                                        HashMap<String, String> drop_fun = fun.seleccionarFuncionario();
                                                                        for (String i : drop_fun.keySet()) {
                                                                            if (usu.getDescr_fun() != null) {
                                                                                if (drop_fun.get(i).toString().equals(usu.getDescr_fun().toString())) {
                                                                                    out.println("<option value='" + i + "' selected>" + drop_fun.get(i) + "</option>");
                                                                                } else {
                                                                                    out.println("<option value='" + i + "'>" + drop_fun.get(i) + "</option>");
                                                                                }
                                                                            } else {
                                                                                out.println("<option value='" + i + "'>" + drop_fun.get(i) + "</option>");
                                                                            }
                                                                        }
                                                                    %>
                                                                </select>

                                                                <h5 class="mt-5">Estado</h5>
                                                                <hr>
                                                                <div class="custom-control custom-radio">
                                                                    <input type="radio" id="customRadio1" name="customRadio" class="custom-control-input" checked="true" value="activo">
                                                                    <label class="custom-control-label" for="customRadio1">Activo</label>
                                                                </div>
                                                                <div class="custom-control custom-radio">
                                                                    <input type="radio" id="customRadio2" name="customRadio" class="custom-control-input" value="inactivo">
                                                                    <label class="custom-control-label" for="customRadio2">Inactivo</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group "> <%-- agregar espacio entre los labels &nbsp --%>
                                                                <br>
                                                                <br>
                                                                <div>
                                                                    <nav class="navbar navbar-dark navbar-expand-md navigation-clean-search">
                                                                        <ul class="nav navbar-nav">

                                                                            <li class="dropdown">
                                                                                <% if (Variables.gua == 0) {%>
                                                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button"  value="Registrar"> 
                                                                                <%}%>
                                                                            </li>                                                                          
                                                                            <li class="dropdown">
                                                                                <% if (Variables.mod == 0) {%>
                                                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button"  value="Modificar">
                                                                                <%}%>
                                                                            </li>  
                                                                            <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Volver"> 
                                                                            <%--
                                                                            <a class="btn btn-light action-button" role="button" href="Principal.jsp">Salir</a>
                                                                            --%>
                                                                        </ul>
                                                                    </nav>
                                                                </div>
                                                            </div> 
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>                                        
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>                
        </div>        

        <%--Datepicker --%>
        <link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>  
        <%--Datepicker --%>
        <script src="assets/js/vendor-all.min.js"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/pcoded.min.js"></script>



    </body>


</html>



