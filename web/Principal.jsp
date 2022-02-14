<%-- 
    Document   : Principal
    Created on : 05/08/2020, 09:33:50 AM
    Author     : Alvaro
--%>

<%@page import="model.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Principal</title>
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

        <script>
            var input = document.getElementById('usuario');
            input.oninvalid = function (event) {
                event.target.setCustomValidity('Username should only contain lowercase letters. e.g. john');
            }
        </script>
        <script type="text/javascript">
            function preventBack() {
                window.history.forward();
            }
            setTimeout("preventBack()", 0);
            window.onunload = function () {
                null
            };
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
        <%@page import="controller.contrato"%>
        <%@page import="controller.venta"%>
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
                        <% if (Variables.usuarioConectado.getId_perfil() == 1 || Variables.usuarioConectado.getId_perfil() == 2 || Variables.usuarioConectado.getId_perfil() == 4) { %> 
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
                                <% if (Variables.usuarioConectado.getId_perfil() == 1 || Variables.usuarioConectado.getId_perfil() == 2) { %> 
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-credit-card"></i></span><span class="pcoded-mtext">
                                            <form action="cobro" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Cobro"></span>
                                            </form>
                                    </a> 
                                </li>
                                <%}%>
                                 <% if (Variables.usuarioConectado.getId_perfil() == 1 || Variables.usuarioConectado.getId_perfil() == 4) { %> 
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-credit-card"></i></span><span class="pcoded-mtext">
                                            <form action="pago" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Pago"></span>
                                            </form>
                                    </a> 
                                </li>
                              <%}%>
                            </ul>
                        </li>
                        <% } %>
                        <%-- ------------------- Modulo Informes ------------------- --%>
                   <%-- <% if (Variables.usuarioConectado.getId_perfil() == 1 || Variables.usuarioConectado.getId_perfil() == 2 || Variables.usuarioConectado.getId_perfil() == 4 || Variables.usuarioConectado.getId_perfil() == 3 || Variables.usuarioConectado.getId_perfil() == 5) { %> --%>
                        <% if (Variables.usuarioConectado.getId_perfil() == 1 || Variables.usuarioConectado.getId_perfil() == 2 || Variables.usuarioConectado.getId_perfil() == 3 || Variables.usuarioConectado.getId_perfil() == 4 || Variables.usuarioConectado.getId_perfil() == 5) { %>
                        <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                            <a href="javascript:" class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">Informes</span></a>
                            <ul class="pcoded-submenu" style="display: none;">
                                <!-- Compra-->
                                 <% if (Variables.usuarioConectado.getId_perfil() == 4 || Variables.usuarioConectado.getId_perfil() == 1) { %> 
                                <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Compra"></span>                                                 
                                    </a> 
                                    <ul class="pcoded-submenu" style="display: none;">                                
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeCompra" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <!-- <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Cliente y Fecha"> -->
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Proveedor y Fecha">Proveedor y Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeCompra" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Solo Proveedor">Proveedor</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeCompra" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Solo Fecha">Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeCompra" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar General">General</button>
                                                    </form>
                                            </a> 
                                        </li>
                                    </ul>
                                </li>
                                <%}%>
                                <!-- Venta-->
                                 <% if (Variables.usuarioConectado.getId_perfil() == 2 || Variables.usuarioConectado.getId_perfil() == 1) { %> 
                                <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Venta"></span>                                                 
                                    </a> 
                                    <ul class="pcoded-submenu" style="display: none;">                                
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeVentas" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <!-- <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Cliente y Fecha"> -->
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Cliente y Fecha">Cliente y Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeVentas" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Solo Cliente">Cliente</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeVentas" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Solo Fecha">Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeVentas" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar General">General</button>
                                                    </form>
                                            </a> 
                                        </li>
                                    </ul>
                                </li>  
                                <%}%>                                
                                <!-- Referenciales-->
                                 <% if (Variables.usuarioConectado.getId_perfil() == 1) { %> 
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <form action="informeReferenciales" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Referenciales"></span>
                                            </form>
                                    </a> 
                                </li>
                                <!-- Contrato-->                               
                                <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Contrato"></span>                                                 
                                    </a> 
                                    <ul class="pcoded-submenu" style="display: none;">                                
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeContratos" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <!-- <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Cliente y Fecha"> -->
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Cliente y Fecha">Cliente y Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeContratos" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Solo Cliente">Cliente</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeContratos" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Solo Fecha">Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeContratos" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar General">General</button>
                                                    </form>
                                            </a> 
                                        </li>
                                    </ul>
                                </li>
                                <%}%>
                                <!-- Importacion-->
                                <% if (Variables.usuarioConectado.getId_perfil() == 4 || Variables.usuarioConectado.getId_perfil() == 1) { %> 
                                <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Importación"></span>                                                 
                                    </a> 
                                    <ul class="pcoded-submenu" style="display: none;">                                
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeImportaciones" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <!-- <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Cliente y Fecha"> -->
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Proveedor y Fecha">Proveedor y Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeImportaciones" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <!-- <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Cliente y Fecha"> -->
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Proveedor">Proveedor</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeImportaciones" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Solo Fecha">Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeImportaciones" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar General">General</button>
                                                    </form>
                                            </a> 
                                        </li>
                                    </ul>
                                </li>
                                <%}%>
                                <!-- Servicio-->
                                <% if (Variables.usuarioConectado.getId_perfil() == 3 || Variables.usuarioConectado.getId_perfil() == 1) { %> 
                                <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Servicio"></span>                                                 
                                    </a> 
                                    <ul class="pcoded-submenu" style="display: none;">                                
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeServicios" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Contrato y Fecha">Contrato y Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeServicios" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Solo Contrato">Contrato</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeServicios" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Solo Fecha">Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeServicios" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar General">General</button>
                                                    </form>
                                            </a> 
                                        </li>
                                    </ul>
                                </li>                               
                                <!-- Producto-->
                                <li>
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <form action="informeProductos" method="POST">
                                                <input type="hidden" name="buscartxt" value=""> 
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Productos"></span>
                                            </form>
                                    </a> 
                                </li>  
                                 <%}%>
                                <!-- Pago-->
                                <% if (Variables.usuarioConectado.getId_perfil() == 5 || Variables.usuarioConectado.getId_perfil() == 1) { %> 
                                <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Pago"></span>                                                 
                                    </a> 
                                    <ul class="pcoded-submenu" style="display: none;">                                
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informePagos" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <!-- <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Cliente y Fecha"> -->
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Pago Pendiente">Pago Pendiente</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informePagos" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Solo Fecha">Pago por Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informePagos" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar General">General</button>
                                                    </form>
                                            </a> 
                                        </li>
                                    </ul>
                                </li>
                                <!-- Cobro-->
                                <li data-username="basic components Button Alert Badges breadcrumb Paggination progress Tooltip popovers Carousel Cards Collapse Tabs pills Modal Grid System Typography Extra Shadows Embeds" class="nav-item pcoded-hasmenu pcoded-trigger">
                                    <a  class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">
                                            <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Cobro"></span>                                                 
                                    </a> 
                                    <ul class="pcoded-submenu" style="display: none;">                                
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeCobros" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <!-- <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Cliente y Fecha"> -->
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Pendientes">Cliente</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeCobros" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <!-- <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Cliente y Fecha"> -->
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Cliente y Fecha">Cliente y Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeCobros" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Fecha">Fecha</button>
                                                    </form>
                                            </a> 
                                        </li>
                                        <li>
                                            <a  class="nav-link "><span class="pcoded-micon"><i class="fas fa-file-pdf"></i></span><span class="pcoded-mtext">
                                                    <form action="informeCobros" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="General">General</button>
                                                    </form>
                                            </a> 
                                        </li>
                                    </ul>
                                </li>
                                <%}%>
                            </ul>
                        </li>
                        <% }%> 
                        <form class="form-inline mr-auto" target="_self">
                        </form>
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
                                            <h1 class="m-b-10">Bienvenido al sistema </h1> 
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
                                            <div class="card-body">
                                                <div class="row">
                                                    <div class="brand_logo_container">
                                                      <!--  <img src="https://omni.com.py/img/logo.png" width="350" height="300" class="brand_logo" alt="Logo"> -->
                                                        <img src="img/logo.png" width="350" height="300" class="brand_logo" alt="Logo">
                                                    </div>
                                                </div>
                                                <div class="row">
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
        </div>                               
        <footer class="col-md-12 text-center">
            <p><h5>Authors: Alvaro Ortega / Micaela Gómez</h5></p>
        <p><a href="mailto:hege@example.com">bitemegc@gmail.com</a></p>
        <p>2021</p>
    </footer>
    <script src="assets/js/vendor-all.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/pcoded.min.js"></script>
</body>
</html>


