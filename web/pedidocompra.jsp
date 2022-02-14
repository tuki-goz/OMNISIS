<%-- 
    Document   : pedidodecompra
    Created on : 15/08/2021, 06:20:14 PM
    Author     : Alvaro
--%>

<%@page import="java.util.HashMap"%>
<%@page import="model.Servicio"%>
<%@page import="model.Proveedor"%>
<%@page import="model.Variables"%>
<%@page import="model.Ordencompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Ordencompra orden_com;
    orden_com = (Ordencompra) request.getAttribute("OrdenCompra");
    Proveedor prov;
    prov = (Proveedor) request.getAttribute("Proveedor");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pedido de compra</title>

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
        <%@ page import="model.Ordencompra, java.util.ArrayList"%>
        <%@ page import="controller.ordencompra"%>
        <%            ArrayList<Ordencompra> AA = null;
            AA = (ArrayList<Ordencompra>) request.getAttribute("OrdenCompraL");
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
                                            <form action="pago" method="POST">
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
                                <!-- Compra-->
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
                                <!-- Venta-->
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
                                <!-- Referenciales-->
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
                                <!-- Importacion-->
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
                                <!-- Servicio-->
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
                                <!-- Pago-->
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
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Pendientes">Pendientes</button>
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
        <%--PANEL DE PEDIDO COMPRA--%>
        <section class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <div class="pcoded-content">
                    <div class="pcoded-inner-content">                        
                        <div class="page-header">
                            <div class="page-block">
                                <div class="row align-items-center">
                                    <div class="col-md-12">
                                        <div class="page-header-title">
                                            <h3 class="m-b-10">Registrar Nuevo Pedido de Compra</h3>
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
                                                <h5>Datos del pedido de compra</h5>
                                            </div>
                                            <div class="card-body">
                                                <form action="ordencompra" method="POST">  
                                                    <div class="row">                                                        
                                                        <div class="col-2 text-left">
                                                            <h6 class="text-center text-center">Fecha del Pedido</h6>
                                                            <input id="fechaActual" type="date" name="fechapedtxt" class="form-control text-center" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                                           
                                                        </div>
                                                        <div class="col-2 text-center">  
                                                            <label for="card-holder">N° de Orden</label>
                                                            <% if (Variables.nro_orden1 != 0) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nropedtxt" class="form-control text-center" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.nro_orden1%>">                                                            
                                                            <% } else {%>
                                                            <input id="card-holder" type="text" name="nropedtxt" class="form-control text-center" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="">
                                                            <% }%>
                                                        </div>
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
                                                                <% if (orden_com.getId_cond() == 1 || Variables.id_condicion == 1) {%>
                                                                <input type="radio" id="cbox1" name="checkbox" class="only-one" value="1" checked="true">
                                                                <label for="card-holder cbox1 text-center">Contado</label>
                                                                <%  Variables.condicion = "Contado";
                                                                } else {%>
                                                                <input type="radio" id="cbox1" name="checkbox" class="only-one" value="1" checked>
                                                                <label for="card-holder cbox1 text-center">Contado</label>
                                                                <% }%>
                                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                <% if (orden_com.getId_cond() == 2 || Variables.id_condicion == 2) {%>
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
                                                        <div class="col-4 text-center">                                                                                                                               
                                                            <label for="card-holder">Nombre o Razon Social</label>
                                                            <% if (Variables.nombre_prov_orden != null) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control text-center" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.nombre_prov_orden%>">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="">
                                                            <% }%>
                                                        </div>
                                                        <div class="col-1 text-right">  
                                                            <button type="submit" class="btn btn-info" name="accion" value="ListaProv">
                                                                <i class="fas fa-user-plus"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                    <div class="row">   
                                                        <div class="col-3 text-center">                                                                                                                               
                                                            <label for="card-holder">RUC</label>
                                                            <% if (Variables.ruc_prov_orden != null) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control text-center" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.ruc_prov_orden%>">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="">
                                                            <% }%>
                                                        </div>
                                                        <div class="col-3 text-center">                                                                                                                               
                                                            <label for="card-holder">Telefono</label>
                                                            <% if (Variables.tel_prov_orden != null) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control text-center" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.tel_prov_orden%>">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="">
                                                            <% }%>
                                                        </div>
                                                        <div class="col-3 text-center">                                                                                                                               
                                                            <label for="card-holder">Ciudad</label>
                                                            <% if (Variables.ciudad_prov_orden != null) {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control text-center" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="<%= Variables.ciudad_prov_orden%>">
                                                            <%  } else {%>
                                                            &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nombretxt" class="form-control" aria-label="Card Holder" readonly="true" aria-describedby="basic-addon1" value="">
                                                            <% }%>
                                                        </div>
                                                        <div class="col-3 text-center"> 
                                                            <label for="card-holder">Servicio Tecnico</label>
                                                            <select id="drop_st" name="drop_st" class="form-control" onChange="update()" >
                                                                <%
                                                                    Servicio st = new Servicio();
                                                                    HashMap<String, String> drop = st.seleccionarServicio();
                                                                    for (String i : drop.keySet()) {
                                                                        if (orden_com.getNro_orden_com() != null) {
                                                                            if (drop.get(i).toString().equals(orden_com.getNro_orden_com().toString())) {
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
                                                    <hr>
                                                    <div>
                                                     <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Ver Producto2">Ver Producto</button>
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
                                                                        for (Ordencompra orden_comLL : AA) {
                                                                    %>  
                                                                    <td class="text-center">                                                                        
                                                                        <%= orden_comLL.getCant_orden_comd()%>
                                                                    </td>
                                                                    <td class="text-center"> 
                                                                        <%= orden_comLL.getDescrip_orden_comd()%>
                                                                    </td>
                                                                    <td class="text-center">
                                                                        <%= orden_comLL.getPrecio_orden_comd()%>
                                                                    </td>
                                                                    <td class="text-center">
                                                                        <%= orden_comLL.getExenta_orden_comd()%>                                                                                  
                                                                    </td>
                                                                    <td class="text-center">                                                                               
                                                                        <%= orden_comLL.getIva5_orden_comd()%>
                                                                    </td>
                                                                    <td class="text-center">                                                                               
                                                                        <%= orden_comLL.getIva10_orden_comd()%>  
                                                                        <input type="hidden" name="idProdtxt" value="<%= orden_comLL.getId_pr()%>"> 
                                                                    </td>
                                                                    <%
                                                                        if (Variables.ban2 == 1) {
                                                                    %>
                                                                    <td class="text-center">
                                                                        <form action="ordencompra" method="POST">
                                                                            <input type="hidden" name="exentxt" value="<%= orden_comLL.getExenta_orden_comd()%>"> 
                                                                            <input type="hidden" name="cincotxt" value="<%= orden_comLL.getIva5_orden_comd()%>"> 
                                                                            <input type="hidden" name="dieztxt" value="<%= orden_comLL.getIva10_orden_comd()%>"> 
                                                                            <input type="hidden" name="tamatxt" value="<%= AA.size()%>"> 
                                                                            <input type="hidden" name="id" value="<%= AA.indexOf(orden_comLL)%>"> 
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
                                                        <% if (Variables.subtotal_exenta_orden != 0) {%>
                                                        <input id="card-holder" type="text" name="totalextxt" class="form-control col-1" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= Variables.subtotal_exenta_orden%>" readonly="true">
                                                        <%  } else {%>
                                                        <input id="card-holder" type="text" name="totalextxt" class="form-control col-1" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <% if (Variables.subtotal_5_orden != 0) {%>
                                                        <input id="card-holder" type="text" name="total5txt" class="form-control col-1" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= Variables.subtotal_5_orden%>" readonly="true">
                                                        <%  } else {%>
                                                        <input id="card-holder" type="text" name="total5txt" class="form-control col-1" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>  
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <% if (Variables.subtotal_10_orden != 0) {%>
                                                        <input id="card-holder" type="text" name="total10txt" class="form-control col-1" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= Variables.subtotal_10_orden%>" readonly="true">
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
                                                        <% if (Variables.total_orden != 0) {%>
                                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text"  name="totaltxt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= Variables.total_orden%>" readonly="true">
                                                        <%  } else {%>
                                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="totaltxt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>
                                                    </div>
                                                    <br> 
                                                    <div class="row">
                                                        <label class="text-left">Liquidación del IVA:</label>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label class="text-left">5%</label>
                                                        <% if (Variables.total_liq5_orden != 0) {%>
                                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="liqiva5txt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%=  Variables.total_liq5_orden%>" readonly="true">
                                                        <%  } else {%>
                                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="liqiva5txt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label class="text-left">10%</label>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                                        <% if (Variables.total_liq10_orden != 0) {%>
                                                        <input id="card-holder" type="text" name="liqiva10txt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%=  Variables.total_liq10_orden%>" readonly="true">
                                                        <%  } else {%>
                                                        <input id="card-holder" type="text" name="liqiva10txt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label class="text-left">Total</label>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <% if (Variables.total_liqtotal_orden != 0) {%>
                                                        <input id="card-holder" type="text" name="liqtotalivatxt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%=  Variables.total_liqtotal_orden%>" readonly="true">
                                                        <%  } else {%>
                                                        <input id="card-holder" type="text" name="liqtotalivatxt" class="form-control col-2" aria-label="Card Holder" aria-describedby="basic-addon1" value="" readonly="true">
                                                        <% }%>
                                                    </div>
                                                    <div>
                                                        <nav class="navbar navbar-dark navbar-expand-md navigation-clean-search">
                                                            <ul class="nav navbar-nav">
                                                                <li class="dropdown">
                                                                    <input id="card-holder" type="hidden" name="idtxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= orden_com.getId_orden_com()%>">                                                                     
                                                                    <input type="submit" name="accion" target="_blank" class="btn btn-dark btn-icon-split" value="Registrar">
                                                                    <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Atras3">Atrás</button>
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

