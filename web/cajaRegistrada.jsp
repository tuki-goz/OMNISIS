<%-- 
    Document   : cajaRegistrada
    Created on : 24/09/2021, 06:03:39 PM
    Author     : Francisca Gómez
--%>

<%@page import="model.Variables"%>
<%@page import="model.Caja"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    Caja caj;
    caj = (Caja) request.getAttribute("Caja");

%>
<!DOCTYPE html>

<html>
    <head>
        <title>Cajas</title>

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

    </style>    

    <body>

        <%@ page import="model.Caja, java.util.ArrayList"  %>
        <%@ page import="controller.caja"  %>


        <%            ArrayList<Caja> AA = null;
            AA = (ArrayList<Caja>) request.getAttribute("CajaL");
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

        <section class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <div class="pcoded-content">
                    <div class="pcoded-inner-content">                        
                        <div class="page-header">
                            <div class="page-block">
                                <div class="row align-items-center">
                                    <div class="col-md-12">
                                        <div class="page-header-title">
                                            <h3 class="m-b-10">Listado de Cajas Registradas</h3>
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
                                                <li>
                                                    <form action="caja" method="POST">
                                                        <input id="card-holder" type="text" name="buscartxt" class="form-control" placeholder="Buscar Caja 01" aria-label="Card Holder" aria-describedby="basic-addon1"  title="Santísima Trinidad" id="descri">
                                                        <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar"> 
                                                    </form>
                                                    <form action="caja" method="POST">
                                                        <input type="hidden" name="buscartxt" value=""> 
                                                        <input type="submit" name="accion" target="_blank" class="btn btn-success action-button" value="Nuevo">
                                                    </form>
                                                </li>


                                            </div>
                                            <div class="card-body">

                                                <hr>

                                                <div class="card-block table-border-style">
                                                    <div class="table-responsive">
                                                        <table class="table table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th class="text-center">#</th>
                                                                    <th class="text-center">Descripción</th>
                                                                    <th class="text-center">Estado</th>
                                                                    <th class="text-center">Opción</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <%
                                                                    if (AA != null) {
                                                                %> 
                                                                <%
                                                                    for (Caja cajaLL : AA) {
                                                                %>                                            
                                                                <tr>  
                                                                    <td class="text-center"> 
                                                                        <%= cajaLL.getId_caja()%>
                                                                    </td>
                                                                    <td class="text-center"> 
                                                                        <%= cajaLL.getDesc_caja()%>
                                                                    </td>                                          
                                                                    <td class="text-center"> 
                                                                        <%= cajaLL.getEstado_caja()%>
                                                                    </td>                                                                         
                                                                    <td class="text-center">
                                                                        <%-- no llama al index del array, guarda el id del usuario --%>

                                                                        <div class="container-fluid margin">
                                                                            <form action="caja" method="POST">  <%-- ubicar el form  action de forma que todo lo que se quiere hacer este afectado, con sus inputs --%>

                                                                                <% if (Variables.abierto == 0) {%> 

                                                                                <input type="hidden" name="codigo" value="<%= cajaLL.getId_caja()%>"> 
                                                                                <input type="hidden" name="descriptxt" value="<%= cajaLL.getDesc_caja()%>"> 
                                                                                <input type="hidden" name="estadotxt" value="<%= cajaLL.getEstado_caja()%>"> 
                                                                                <input type="submit" name="accion" target="_blank" class="btn btn-theme2 action-button" value="Apertura">
                                                                                <%}%>
                                                                                <% if (Variables.abierto == 1) {%> 
                                                                                <input type="hidden" name="codigo2" value="<%= cajaLL.getId_caja()%>">
                                                                                <input type="submit" name="accion" target="_blank" class="btn btn-danger action-button" value="Cierre">
                                                                                <%}%>
                                                                            </form>
                                                                            <form name="form1" action="pdf_3.jsp" target="_blank" method="post" >                                                                                
                                                                                <input type="hidden" name="txtparametro" class="form-control" >
                                                                                <input type="text" name="txtparametro" value="<%= Variables.usuarioConectado.getNumero_usuario()%>" style="color: white; border: none;">

                                                                                <br>
                                                                                <% if (Variables.arq == 3) {%> 
                                                                                <input type="submit" name="btn1" target="_blank" class="btn btn-success action-button" value="Generar Reporte Arqueo">
                                                                                <%}%>                                                                                 
                                                                            </form>

                                                                        </div> 
                                                                    </td> 
                                                                </tr>
                                                                <% } %>
                                                                <% } %>
                                                                <% AA.clear();%>                                                       
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div>
                                                    <nav class="navbar navbar-dark navbar-expand-md navigation-clean-search">
                                                        <ul class="nav navbar-nav">
                                                            <li class="dropdown">

                                                                <%--    <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Atras">   --%>

                                                                <a class="btn btn-light action-button" role="button" href="Principal.jsp">Salir</a>
                                                            </li>                                                                        

                                                        </ul>
                                                    </nav>
                                                </div>

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

        <script src="assets/js/vendor-all.min.js"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/pcoded.min.js"></script>
    </body>
</html>
