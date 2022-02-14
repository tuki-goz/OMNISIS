<%-- 
    Document   : ventas
    Created on : 17/06/2021, 04:43:10 PM
    Author     : Alvaro
--%>

<%@page import="model.Tipo_pago"%>
<%@page import="model.Cliente"%>
<%@page import="model.Forma_cobro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Venta"%>
<%@page import="model.Producto"%>
<%
    Venta ven;
    ven = (Venta) request.getAttribute("Venta");
    Producto pr;
    pr = (Producto) request.getAttribute("Producto");
    Cliente clie;
    clie = (Cliente) request.getAttribute("Cliente");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nueva Venta</title>
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

        <meta http-equiv="pragma" content='no-cache'>
        <meta http-equiv="Cache-Control" content='no-cache, must-revalidate'>
        <meta content="0" http-equiv="expires">

        <!-- Favicon icon -->
        <link rel="icon" href="img/favicon.ico">
        <!-- fontawesome icon -->
        <link rel="stylesheet" href="assets/fonts/fontawesome/css/fontawesome-all.min.css">
        <!-- animation css -->
        <link rel="stylesheet" href="assets/plugins/animation/css/animate.min.css">
        <!-- vendor css -->
        <link rel="stylesheet" href="assets/css/style.css">

        <%
            response.setHeader("Cache-Control", "no-cache,post-check=0,pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "Thu,01 Dec 1994 16:00:00 GMT");
            response.setDateHeader("Expires", -1);
        %>
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
    <script>
        function validateForm() {
            var x = document.forms["myForm"]["buscartxt"].value;
            if (x == "") {
                alert("El campo no puede quedar vacío");
                return false;
            }
        }
    </script>
    <body>
        <%
            ArrayList<Producto> AA = null;
            AA = (ArrayList<Producto>) request.getAttribute("ProductoL");
        %>
        <%
            ArrayList<Venta> BB = null;
            BB = (ArrayList<Venta>) request.getAttribute("VentaL");
        %>
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
                <a href="index.html" class="b-brand">
                    <div class="b-bg">
                        <i class="feather icon-trending-up"></i>
                    </div>
                    <span class="b-title">Datta Able</span>
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

                            <a href="javascript:" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                <i class="icon feather icon-settings"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right profile-notification show">
                                <div class="pro-head">
                                    <img src="assets/images/user/avatar-1.jpg" class="img-radius" alt="User-Profile-Image">
                                    <span>${usuar}</span>
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
                                            <h1 class="m-b-10">Registrar nueva venta</h1>
                                        </div>
                                        <div class="page-header-title">
                                            <h5 class="m-b-10">Por favor, complete los campos</h5>
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
                                                <h4 class="text-center text-uppercase">Datos de la venta</h4>
                                                <hr>
                                                <form action="venta"  method="POST">
                                                    <div class="row">
                                                        <div class="container-fluid">
                                                            <div class="row">
                                                                <div class="col-2 text-center">                                                                   
                                                                    <input id="card-holder" type="hidden" name="idtxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= ven.getId_venta()%>">                                                                
                                                                    <label for="card-holder">N° Factura</label>
                                                                    <% if (ven.getNro_factura_venta() != null) {%>
                                                                    &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="ructxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= ven.getNro_factura_venta()%>">
                                                                    <%  } else {%>
                                                                    &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="ructxt" class="form-control" readonly="true" aria-label="Card Holder" aria-describedby="basic-addon1" value="">
                                                                    <% }%>
                                                                </div>
                                                                <div class="col-1 text-left">
                                                                    <h6 class="text-left text-uppercase">Fecha</h6>
                                                                    <script>
                                                                        var f = new Date();
                                                                        document.write(f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear());
                                                                    </script>
                                                                </div>
                                                                <div class="col-2 text-center">
                                                                    <label for="card-holder">Condición</label>
                                                                    <select id="drop_cond" name="drop_cond" class="form-control" onChange="update()" >
                                                                        <%
                                                                            Tipo_pago tp = new Tipo_pago();
                                                                            HashMap<String, String> drop = tp.seleccionarTipoPago();
                                                                            for (String i : drop.keySet()) {
                                                                                if (ven.getCondicion_venta() != null) {
                                                                                    if (drop.get(i).toString().equals(ven.getCondicion_venta().toString())) {
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
                                                                <div class="col-2 text-center">                                                                   
                                                                    <input id="card-holder" type="hidden" name="idtxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= ven.getId_venta()%>">                                                                
                                                                    <label for="card-holder">RUC</label>
                                                                    <% if (Variables.ruc_clie != null) {%>
                                                                    &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="ructxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%=  Variables.ruc_clie%>">
                                                                    <%  } else {%>
                                                                    &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="ructxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="">
                                                                    <% }%>
                                                                </div>
                                                                <div class="col-4 text-center">                                                                                                                               
                                                                    <label for="card-holder">Nombre o Razon Social</label>
                                                                    <% if (Variables.nombre_clie != null) {%>
                                                                    &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= Variables.nombre_clie%>">
                                                                    <%  } else {%>
                                                                    &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="">
                                                                    <% }%>
                                                                </div>      
                                                                <button type="submit" class="btn btn-info" name="accion" value="ListaClie">
                                                                    <i class="fas fa-user-plus"></i>
                                                                </button>
                                                            </div>
                                                            <hr> 
                                                        </div>
                                                        <%--------------------------- AQUI EMPIEZA EL DETALLE ---------------------------%>                                                           
                                                        <div class="col-12 col-lg-12">
                                                            <div class="container-fluid">
                                                                <form class="row align-items-center" id="sale-barcode-form" autocomplete="off">                                                            
                                                                    <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Ver Producto">
                                                                </form>                                                                
                                                                <% if (ven.getId_vd() != 0) {%> 
                                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="hidden" name="idtxt2" class="form-control" aria-label="Card Holder" value="<%= ven.getId_vd()%>">
                                                                <% }%>
                                                                <div class="table-responsive">
                                                                    <table class="table table-hover table-bordered table-sm">
                                                                        <thead class="bg-info">
                                                                            <tr class="text-center">
                                                                                <th scope="col">Cantidad</th>
                                                                                <th scope="col">Descripción</th>
                                                                                <th scope="col">Precio Unit.</th>
                                                                                <th scope="col">Exentas</th>
                                                                                <th scope="col">5%</th>
                                                                                <th scope="col">10%</th>
                                                                                <th scope="col">Confirmar</th>
                                                                            </tr>
                                                                        </thead>                                                                        
                                                                        <%
                                                                            if (AA != null) {
                                                                        %> 
                                                                        <%
                                                                            for (Producto productoLL : AA) {
                                                                        %>                                                                        
                                                                        <input type="hidden" name="descriptxt" value="<%= Variables.descrip_vd%>">                                                  
                                                                        <input type="hidden" name="preciotxt" value="<%= Variables.precio_uni_vd%>"> 
                                                                        <input type="hidden" name="impuetxt" value="<%= Variables.cifra_imp_vd%>"> 
                                                                        <input type="hidden" name="idProducto" value="<%= Variables.id_producto_vd%>">  
                                                                        <% } %>
                                                                        <% } %>  
                                                                        <tr>                                                                        
                                                                            <%
                                                                                if (Variables.chaumensaje == 0) {
                                                                            %>
                                                                            <td class="text-center">
                                                                            <th colspan="9" class="text-center">No hay productos agregados</th>
                                                                            </td>
                                                                            <%
                                                                                }
                                                                            %>
                                                                            <%
                                                                                if (Variables.chaumensaje == 1) {
                                                                            %>
                                                                            <%
                                                                                if (BB != null) {
                                                                            %> 
                                                                            <%
                                                                                for (Venta ventaLL : BB) {
                                                                            %>  
                                                                            <td class="text-center"> 
                                                                                <%---AQUI HAY QUE CONTROLAR ------%>  
                                                                                <%
                                                                                    if (Variables.capi == 1) {
                                                                                %>
                                                                                <%= ventaLL.getCantidad_vd()%>       
                                                                                <% } else if (Variables.ban == 2) {%>  
                                                                                <input type="text" name="canttxt" class="form-control" value="" required="true">
                                                                                <% } else {%>
                                                                                <input type="text" name="canttxt" class="form-control" value="" required="true">
                                                                                <% }%>
                                                                            </td>
                                                                            <td class="text-center"> 
                                                                                <%= ventaLL.getDescrip_vd()%>
                                                                            </td>
                                                                            <td class="text-center">
                                                                                <%= ventaLL.getPrecio_uni_vd()%>
                                                                            </td>
                                                                            <td class="text-center">
                                                                                <%= ventaLL.getExenta_vd()%>                                                                                  
                                                                            </td>
                                                                            <td class="text-center">                                                                               
                                                                                <%= ventaLL.getIva5_vd()%>
                                                                            </td>
                                                                            <td class="text-center">                                                                               
                                                                                <%= ventaLL.getIva10_vd()%>                                                                                
                                                                            </td>
                                                                            <td class="text-center">
                                                                                <input type="hidden" name="idVenta" value="<%= ventaLL.getId_venta()%>">                                                                     
                                                                                <input type="hidden" name="idVentaDet" value="<%= ventaLL.getId_vd()%>">
                                                                                <input type="submit" name="accion" target="_blank" class="btn btn-dark btn-icon-split" value="Si">  
                                                                            </td> 
                                                                        </tr>                                                                                                                              
                                                                        <% } %>         
                                                                        <% } %>         
                                                                        <% } %>                                                                                                                                       
                                                                        <% BB.size();%> 
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <%------------------------------- AQUI TERMINA EL DETALLE ---------------------------%>
                                                    <hr>
                                                    <div class="container-fluid">
                                                        <div class="row">
                                                            <label class="text-left">Total a Pagar</label>
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <% if (Variables.total_venta != 0) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="totaltxt" class="form-control col-4" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= Variables.total_venta%>" readonly="true">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="totaltxt" class="form-control col-4" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                            <% }%>
                                                        </div>
                                                        <br> 
                                                        <div class="row">
                                                            <label class="text-left">Liquidación del IVA:</label>
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <label class="text-left">5%</label>
                                                            <% if (Variables.total_liq5_venta != 0) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="iva5txt" class="form-control col-4" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%=  Variables.total_liq5_venta%>" readonly="true">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="iva5txt" class="form-control col-4" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                            <% }%>
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <label class="text-left">10%</label>
                                                            <% if (Variables.total_liq10_venta != 0) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="iva10txt" class="form-control col-4" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%=  Variables.total_liq10_venta%>" readonly="true">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="iva10txt" class="form-control col-4" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                            <% }%>
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
