<%-- 
    Document   : nuevaVenta
    Created on : 25/09/2021, 10:19:30 PM
    Author     : Francisca Gómez
--%>

<%@page import="java.util.HashMap"%>
<%@page import="model.Producto"%>
<%@page import="model.Cliente"%>
<%@page import="model.Variables"%>
<%@page import="model.Contrato"%>
<%@page import="model.Moneda"%>
<%@page import="model.Tipo_pago"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Venta"%>
<%
    Venta ven;
    ven = (Venta) request.getAttribute("Venta");
    Cliente clie;
    clie = (Cliente) request.getAttribute("Cliente");

%>
<!DOCTYPE html>

<html>
    <head>
        <title>Ventas</title>

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
        <link rel="icon" href="img/favicon.ico">
        <!-- fontawesome icon -->
        <link rel="stylesheet" href="assets/fonts/fontawesome/css/fontawesome-all.min.css">
        <!-- animation css -->
        <link rel="stylesheet" href="assets/plugins/animation/css/animate.min.css">
        <!-- vendor css -->
        <link rel="stylesheet" href="assets/css/style.css">



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

        .inputcentrado {
            text-align: right
        }

    </style>   
    <body>
        <div class="loader-bg">
            <div class="loader-track">
                <div class="loader-fill"></div>
            </div>
        </div>

        <%@ page import="model.Venta, java.util.ArrayList"%>
        <%@ page import="controller.venta"%>
        <%            ArrayList<Venta> AA = null;
            AA = (ArrayList<Venta>) request.getAttribute("VentaL");
        %>  
        <%
            ArrayList<Producto> BB = null;
            BB = (ArrayList<Producto>) request.getAttribute("ProductoL");
        %>
        <%
            ArrayList<Venta> CC = null;
            CC = (ArrayList<Venta>) request.getAttribute("VentaL2");
        %>
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
                                <%--
                                <ul class="pro-body">
                                    <li><a href="javascript:" class="dropdown-item"><i class="feather icon-settings"></i> Settings</a></li>
                                    <li><a href="javascript:" class="dropdown-item"><i class="feather icon-user"></i> Profile</a></li>
                                    <li><a href="message.html" class="dropdown-item"><i class="feather icon-mail"></i> My Messages</a></li>
                                    <li><a href="auth-signin.html" class="dropdown-item"><i class="feather icon-lock"></i> Lock Screen</a></li>
                                </ul>
                                --%>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>            
        </header>
        <%--PANEL DE VENTA--%>
        <section class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <div class="pcoded-content">
                    <div class="pcoded-inner-content">                        
                        <div class="page-header">
                            <div class="page-block">
                                <div class="row align-items-center">
                                    <div class="col-md-12">
                                        <div class="page-header-title">
                                            <h3 class="m-b-10">Registrar Nueva Venta</h3>
                                        </div>                                        
                                    </div>
                                </div>
                            </div>
                        </div>                        
                        <div class="main-body">
                            <div class="page-wrapper">
                                <!-- [ Main Content ] start -->
                                <div class="row">                                 
                                    <!-- [ Hover-table ] start -->
                                    <div class="col-xl-12">
                                        <div class="card">
                                            <div class="card-header">
                                                <h5>Datos de la venta</h5>
                                            </div>
                                            <div class="card-body">
                                                <form action="venta" method="POST"> 
                                                    <div class="row">  
                                                        <div class="col-6 text-center">
                                                            <label for="card-holder"><h2>OMNI S.A.</h2> </label> 
                                                            <br>
                                                            <br>
                                                            <label for="card-holder">Sistemas de energía, seguridad y defensa</label> 
                                                            <label for="card-holder">Molas López N° 670 c/ Dr. Geronimo Zubizarreta</label>                                                             
                                                            <label for="card-holder">Tel (595-21)608699</label>                                                             
                                                        </div>                                                        
                                                        <hr width="1" size="500">
                                                        <div class="col-3 text-center">
                                                            <label for="card-holder" class="text-left">Timbrado N°</label>
                                                            <% if (Variables.nro_timbrado != "") {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nrofactxt" class="form-control text-center" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.nro_timbrado%>">                                                            
                                                            <% }%>
                                                            <label for="card-holder">Fecha Inicio Vigencia:</label>    
                                                            <% if (Variables.fecha_ini_tim != "") {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nrofactxt" class="form-control text-center" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.fecha_ini_tim%>">                                                            
                                                            <% }%>
                                                            <label for="card-holder">Fecha Fin Vigencia: </label>  
                                                            <% if (Variables.fecha_fin_tim != "") {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nrofactxt" class="form-control text-center" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.fecha_fin_tim%>">                                                            
                                                            <% }%>                                                                                                                     
                                                        </div>                                                        
                                                        <div class="col-2 text-center">                                                                   
                                                            <input id="card-holder" type="hidden" name="idtxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= ven.getId_venta()%>">                                                                
                                                            <label for="card-holder">N° Factura</label>
                                                            <% if (Variables.nro_factura1 != 0) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nrofactxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="N° 001-001-0000<%= Variables.nro_factura1%>">                                                            
                                                            <% }%>
                                                            <label for="card-holder">R.U.C</label> 
                                                            <input id="card-holder" type="text" name="nrofactxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="N°  80020160-4">                                                            
                                                        </div> 
                                                    </div>
                                                    <hr>
                                                    <div class="row">                                                        
                                                        <div class="col-2 text-left">
                                                            <h6 class="text-center text-uppercase">Fecha Facturada</h6>
                                                            <input id="fechaActual" type="date" name="fechafactxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                                           
                                                        </div>
                                                        <div class="col-3 text-center">  
                                                            <label for="card-holder">Contrato</label>
                                                            <% if (Variables.codigo_cont != null) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="codconttxt" class="form-control" aria-label="Card Holder"  readonly="true" aria-describedby="basic-addon1" value="<%=  Variables.codigo_cont%>">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="codconttxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="">
                                                            <% }%>
                                                        </div>
                                                        <input id="card-holder" type="hidden" name="idcontxt"  value="<%= Variables.id_cont%>">
                                                        <script>
                                                            window.onload = function () {
                                                                var fecha = new Date(); //Fecha actual
                                                                var mes = fecha.getMonth() + 1; //obteniendo mes
                                                                var dia = fecha.getDate(); //obteniendo dia
                                                                var ano = fecha.getFullYear(); //obteniendo año
                                                                if (dia < 10)
                                                                    dia = '0' + dia; //agrega cero si el menor de 10
                                                                if (mes < 10)
                                                                    mes = '0' + mes //agrega cero si el menor de 10
                                                                document.getElementById('fechaActual').value = ano + "-" + mes + "-" + dia;
                                                                document.getElementById('fechaActual2').value = ano + "-" + mes + "-" + dia;
                                                                document.getElementById('fechaActual3').value = ano + "-" + mes + "-" + dia;
                                                            }
                                                        </script>
                                                        <div class="col-3 text-center">
                                                            <label for="card-holder">Condición</label>                                                                
                                                            <div class="custom-control custom-radio">
                                                                <% if (ven.getId_tipo_pago() == 1 || Variables.id_tipo_pago == 1) {%>
                                                                <input type="radio" id="cbox1" name="checkbox" class="only-one" value="1" checked="true">
                                                                <label for="card-holder cbox1 text-center">Contado</label>
                                                                <%  Variables.condicion = "Contado";
                                                                } else {%>
                                                                <input type="radio" id="cbox1" name="checkbox" class="only-one" value="1" checked>
                                                                <label for="card-holder cbox1 text-center">Contado</label>
                                                                <% }%>
                                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                <% if (ven.getId_tipo_pago() == 2 || Variables.id_tipo_pago == 2) {%>
                                                                <input type="radio" id="cbox2" name="checkbox" class="only-one" value="2" checked="true">
                                                                <label for="card-holder cbox2 text-center">Crédito</label>
                                                                <% Variables.condicion = "Credito";
                                                                } else {%>
                                                                <input type="radio" id="cbox2" name="checkbox" class="only-one" value="2">
                                                                <label for="card-holder cbox2 text-center">Crédito</label>
                                                                <% }%>
                                                            </div>
                                                            <script>
                                                                let Checked = null;
                                                                for (let CheckBox of document.getElementsByClassName('only-one')) {
                                                                    CheckBox.onclick = function () {
                                                                        if (Checked != null) {
                                                                            Checked.checked = false;
                                                                            Checked = CheckBox;
                                                                        }
                                                                        Checked = CheckBox;
                                                                    }
                                                                }
                                                            </script>
                                                        </div>                                                        
                                                        <div class="col-3 text-center">
                                                            <label for="card-holder">Moneda</label>                                                                
                                                            <div class="custom-control custom-radio">
                                                                <% if (ven.getId_mon() == 1 || Variables.id_mon == 1) {%>
                                                                <input type="radio" id="cbox1" name="radio" class="only-one" value="1" checked="true">
                                                                <label for="card-holder cbox1 text-center">Guaranies</label>
                                                                <%  } else {%>
                                                                <input type="radio" id="cbox1" name="radio" class="only-one" value="1" checked>
                                                                <label for="card-holder cbox1 text-center">Guaranies</label>
                                                                <% }%>
                                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                <% if (ven.getId_mon() == 2 || Variables.id_mon == 2) {%>
                                                                <input type="radio" id="cbox2" name="radio" class="only-one" value="2" checked="true">
                                                                <label for="card-holder cbox2 text-center">Dólar</label>
                                                                <%  } else {%>
                                                                <input type="radio" id="cbox2" name="radio" class="only-one" value="2">
                                                                <label for="card-holder cbox2 text-center">Dólar</label>
                                                                <% }%>
                                                            </div>
                                                            <script>
                                                                let Checked = null;
                                                                for (let CheckBox of document.getElementsByClassName('only-one')) {
                                                                    CheckBox.onclick = function () {
                                                                        if (Checked != null) {
                                                                            Checked.checked = false;
                                                                            Checked = CheckBox;
                                                                        }
                                                                        Checked = CheckBox;
                                                                    }
                                                                }
                                                            </script>
                                                        </div>
                                                    </div>
                                                    <div class="row">                                                         
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <div class="col-3 text-center">  
                                                            <label for="card-holder">RUC</label>
                                                            <% if (Variables.ruc_clie != null) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="ructxt" class="form-control" aria-label="Card Holder"  readonly="true" aria-describedby="basic-addon1" value="<%=  Variables.ruc_clie%>">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="ructxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="">
                                                            <% }%>
                                                        </div>
                                                        <div class="col-6 text-center">                                                                                                                               
                                                            <label for="card-holder">Nombre o Razon Social</label>
                                                            <% if (Variables.nombre_clie != null) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.nombre_clie%>">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="">
                                                            <% }%>
                                                        </div>  
                                                        <div class="col-1">  
                                                            <form action="cliente" method="POST">
                                                                <button type="submit" class="btn btn-info" name="accion" value="ListaClie">
                                                                <i class="fas fa-user-plus"></i>
                                                            </button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="row">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                                      
                                                        <div class="col-4 text-center">                                                                   
                                                            <label for="card-holder">Dirección</label>
                                                            <% if (Variables.direccion_clie != null) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="dirtxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.direccion_clie%>">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="dirtxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="">
                                                            <% }%>
                                                        </div>
                                                        <div class="col-3 text-center">                                                                   
                                                            <label for="card-holder">Barrio</label>
                                                            <% if (Variables.barrio_clie != null) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="bartxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.barrio_clie%>">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="bartxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="">
                                                            <% }%>
                                                        </div> 
                                                        <div class="col-3 text-center">                                                                   
                                                            <label for="card-holder">Teléfono</label>
                                                            <% if (Variables.tel_clie != null) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="teltxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.tel_clie%>">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="teltxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="">
                                                            <% }%>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    <div>
                                                        <form action="producto" method="POST">

                                                            <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Ver Producto">Ver Producto</button>
                                                        </form>
                                                    </div>
                                                    <div class="card-block table-border-style">
                                                        <div class="table-responsive">
                                                            <table class="table table-hover">
                                                                <thead>
                                                                    <tr>
                                                                        <th class="text-center">Cantidad</th>
                                                                        <th class="text-center">Descripción</th>
                                                                        <th class="text-center">Precio Unit.</th>
                                                                        <th class="text-center">Exentas</th>
                                                                        <th class="text-center">5%</th>
                                                                        <th class="text-center">10%</th>
                                                                            <%
                                                                                if (Variables.ban2 == 1) {
                                                                            %>
                                                                        <th class="text-center">Remover</th>
                                                                            <%
                                                                                }
                                                                            %>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>            
                                                                <input type="hidden" name="descriptxt" value="<%= Variables.descrip_vd%>">                                                  
                                                                <input type="hidden" name="preciotxt" value="<%= Variables.precio_uni_vd%>"> 
                                                                <input type="hidden" name="impuetxt" value="<%= Variables.cifra_imp_vd%>"> 
                                                                <input type="hidden" name="canttxt" value="<%= Variables.cantidad_vd%>"> 
                                                                <input type="hidden" name="idProducto" value="<%= Variables.id_producto_vd%>">  

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
                                                                        if (AA != null) {
                                                                    %> 
                                                                    <%
                                                                        for (Venta ventaLL : AA) {
                                                                    %>  
                                                                    <td class="text-center">                                                                        
                                                                        <%= ventaLL.getCantidad_vd()%>
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
                                                                        <input type="hidden" name="idProdtxt" value="<%= ventaLL.getId_producto_vd()%>"> 
                                                                    </td>
                                                                    <%
                                                                        if (Variables.ban2 == 1) {
                                                                    %>
                                                                    <td class="text-center">
                                                                        <form action="venta" method="POST">
                                                                            <input type="hidden" name="cantVentxt" value="<%= ventaLL.getCantidad_vd()%>"> 
                                                                            <input type="hidden" name="idProtxt" value="<%= ventaLL.getId_producto_vd()%>"> 
                                                                            <input type="hidden" name="exentxt" value="<%= ventaLL.getExenta_vd()%>"> 
                                                                            <input type="hidden" name="cincotxt" value="<%= ventaLL.getIva5_vd()%>"> 
                                                                            <input type="hidden" name="dieztxt" value="<%= ventaLL.getIva10_vd()%>"> 
                                                                            <input type="hidden" name="tamatxt" value="<%= AA.size()%>"> 
                                                                            <input type="hidden" name="id" value="<%= AA.indexOf(ventaLL)%>"> 
                                                                            <input type="submit" name="accion" class="btn btn-danger action-button" value="Si">       
                                                                        </form>
                                                                    </td>                                                                                                                           
                                                                    <% } %>  
                                                                </tr>                                                                                                                              
                                                                <% } %>         
                                                                <% } %>         
                                                                <% } %>                                                                                                                                       
                                                                <% AA.size();%> 
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <script>
                                                        $(function () {
                                                            $(document).on('click', '.borrar', function (event) {
                                                                event.preventDefault();
                                                                $(this).closest('tr').remove();
                                                            });
                                                        });
                                                    </script>
                                                    <hr>     
                                                    <div class="row">
                                                        <label class="text-left">Sub Total</label>  
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                                        <% if (Variables.subtotal_exenta != 0) {%>
                                                        <input id="card-holder" type="text" name="totalextxt" class="form-control col-1" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= Variables.subtotal_exenta%>" readonly="true">
                                                        <%  } else {%>
                                                        <input id="card-holder" type="text" name="totalextxt" class="form-control col-1" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <% if (Variables.subtotal_5 != 0) {%>
                                                        <input id="card-holder" type="text" name="total5txt" class="form-control col-1" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= Variables.subtotal_5%>" readonly="true">
                                                        <%  } else {%>
                                                        <input id="card-holder" type="text" name="total5txt" class="form-control col-1" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>  
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <% if (Variables.subtotal_10 != 0) {%>
                                                        <input id="card-holder" type="text" name="total10txt" class="form-control col-1" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= Variables.subtotal_10%>" readonly="true">
                                                        <%  } else {%>
                                                        <input id="card-holder" type="text" name="total10txt" class="form-control col-1" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>   
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                                    </div>
                                                    <br> 
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
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                                        <% if (Variables.total_venta != 0) {%>
                                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text"  name="totaltxt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= Variables.total_venta%>" readonly="true">
                                                        <%  } else {%>
                                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="totaltxt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>

                                                    </div>
                                                    <br> 
                                                    <div class="row">
                                                        <label class="text-left">Liquidación del IVA:</label>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label class="text-left">5%</label>
                                                        <% if (Variables.total_liq5_venta != 0) {%>
                                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="liqiva5txt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%=  Variables.total_liq5_venta%>" readonly="true">
                                                        <%  } else {%>
                                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="liqiva5txt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label class="text-left">10%</label>
                                                        &nbsp;
                                                        <% if (Variables.total_liq10_venta != 0) {%>
                                                        <input id="card-holder" type="text" name="liqiva10txt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%=  Variables.total_liq10_venta%>" readonly="true">
                                                        <%  } else {%>
                                                        <input id="card-holder" type="text" name="liqiva10txt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label class="text-left">Total</label>
                                                        &nbsp;
                                                        <% if (Variables.total_liqtotal_venta != 0) {%>
                                                        <input id="card-holder" type="text" name="liqtotalivatxt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%=  Variables.total_liqtotal_venta%>" readonly="true">
                                                        <%  } else {%>
                                                        <input id="card-holder" type="text" name="liqtotalivatxt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>
                                                    </div>
                                                    <div>
                                                        <nav class="navbar navbar-dark navbar-expand-md navigation-clean-search">
                                                            <ul class="nav navbar-nav">
                                                                <li class="dropdown">
                                                                    <form action="venta" method="POST">

                                                                        <input id="card-holder" type="hidden" name="idtxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= ven.getId_venta()%>"> 

                                                                        <input id="card-holder" type="hidden" name="idclie" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= clie.getId_clie()%>"> 
                                                                        <input id="card-holder" type="hidden" name="idusu" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= Variables.usuarioConectado.getId_usuario()%>"> 

                                                                        <input id="card-holder" type="hidden" name="idmon" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="1"> 
                                                                        <input id="card-holder" type="hidden" name="idtipo" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="1"> 
                                                                        <input id="card-holder" type="hidden" name="idtim" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="1"> 
                                                                        <input id="card-holder" type="hidden" name="idest" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="1"> 

                                                                        <input type="submit" name="accion" target="_blank" class="btn btn-dark btn-icon-split" value="Registrar">
                                                                        <a class="btn btn-light action-button" role="button" href="Principal.jsp">Salir</a>
                                                                    </form>
                                                                </li>                                                                        

                                                            </ul>
                                                        </nav>
                                                    </div>
                                                </form>
                                            </div>                   
                                        </div>
                                    </div>                                  
                                    <!-- [ Hover-table ] end -->
                                </div>
                                <!-- [ Main Content ] end -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section> 
        <!-- Modal -->
        <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Aguarda</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Una caja se encuentra abierta.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-block" data-dismiss="modal">OK</button>
                    </div>
                </div>
            </div>
        </div>       

        <script src="assets/js/vendor-all.min.js"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/pcoded.min.js"></script>
    </body>
</html>
