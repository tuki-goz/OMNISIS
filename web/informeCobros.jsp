<%-- 
    Document   : usuarioActivo
    Created on : 05/09/2021, 03:51:49 PM
    Author     : Francisca Gómez
--%>

<%@page import="model.Variables"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>

<html>
    <head>
        <title>Informe de Cobros</title>

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

                //    fecha = ano + '-' + mes + '-' + dia;
                //   document.getElementById("fechaActual").setAttribute("max", fecha);
            }
        </script>
        <%--
        <script>
            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1; //January is 0!
            var yyyy = today.getFullYear();
            if (dd < 10) {
                dd = '0' + dd
            }
            if (mm < 10) {
                mm = '0' + mm
            }

            today = yyyy + '-' + mm + '-' + dd;
            document.getElementById("fechaActual").setAttribute("max", today);

        </script>
        --%>

        <%@ page import="model.InformeCobros, java.util.ArrayList"  %>
        <%@ page import="controller.informeCobros"  %>


        <%
            ArrayList<InformeCobros> AA = null;
            AA = (ArrayList<InformeCobros>) request.getAttribute("InformeCobrosL");
        %>  
        <%
            InformeCobros infcob;
            infcob = (InformeCobros) request.getAttribute("InformeCobros");

        %>
        <%            //  Variables.sumarventa = 0.0;
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
                                                        <button type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Pendientes">Por Condicion</button>
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
        <section class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <div class="pcoded-content">
                    <div class="pcoded-inner-content">                        
                        <div class="page-header">
                            <div class="page-block">
                                <div class="row align-items-center">
                                    <div class="col-md-12">
                                        <div class="page-header-title">
                                            <h3 class="m-b-10">Informe de Cobros Realizados</h3>
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
                                                <hr>
                                                <div class="col-6">
                                                    <form name="form1" action="reporte\pdf_10.jsp" target="_blank" method="post"> 
                                                        <div class="input-group">

                                                            <input type="text" name="txtparametro" class="form-control" placeholder="Razón social"> 
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <input type="submit" name="btn1" target="_blank" class="btn btn-success action-button" value="Informe Cobros Pendientes">
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                                        </div>
                                                    </form>

                                                </div>
                                                <hr>
                                                <br>
                                                <br> 
                                                <div class="col-6">
                                                    <div class="input-group">
                                                        <form name="form1" action="reporte\pdf_41.jsp" target="_blank" method="post">  
                                                            <input type="submit" name="btn1" target="_blank" class="btn btn-success action-button" value="Informe General"> 
                                                        </form> 
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;


                                                    </div>
                                                </div>
                                                <br> 
                                                <br>
                                                <hr>
                                                <div class="col-2">
                                                    <form name="form1" action="pdf_2.jsp" target="_blank" method="post"> 
                                                        <div class="form-group "> <%-- agregar espacio entre los labels &nbsp --%>
                                                            <div>
                                                                <label>Fecha Desde</label>&nbsp;&nbsp;&nbsp;
                                                                <%--   <input type="text" name="fechainitxt" id="dateofbirth" > --%>
                                                                <input type="date" name="fechainitxt" id="fechaActual" min='1899-01-01' max='2000-13-13' class="form-control"  aria-label="Card Holder" aria-describedby="basic-addon1">                                
                                                            </div>

                                                        </div>
                                                        <div class="form-group "> <%-- agregar espacio entre los labels &nbsp --%>
                                                            <div>
                                                                <label>Fecha Hasta</label>&nbsp;&nbsp;&nbsp;&nbsp; 
                                                                &nbsp;&nbsp;
                                                                <input type="date" name="fechafintxt" id="fechaActual2" class="form-control"  aria-label="Card Holder" aria-describedby="basic-addon1"> 
                                                                <%--       <input type="text" name="fechafintxt" id="dateofbirth2" >  --%>

                                                            </div>                                                                                                                   
                                                        </div> 
                                                        <input type="submit" name="btn1" target="_blank" class="btn btn-success action-button" value="Informe de Cobros por Fecha">

                                                    </form>
                                                </div>
                                                <%--

                                                <form action="informeCobros" method="POST">
                                                    <input id="card-holder" type="text" name="buscartxt" class="form-control" placeholder="Buscar Nombre de Cliente" aria-label="Card Holder" aria-describedby="basic-addon1"  title="Santísima Trinidad" id="descri">
                                                    <br>
                                                    <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Cliente y Fecha"> 
                                                    <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar Solo Cliente"> 
                                                    
                                                <%--
                                                <div class="col-md-3">
                                                    <div class="form-group "> 
                                                        <div>
                                                            <label>Fecha Desde</label>&nbsp;&nbsp;&nbsp;
                                                            
                                                            <input type="date" name="fechainitxt" id="fechaActual" class="form-control"  aria-label="Card Holder" aria-describedby="basic-addon1">                                
                                                        </div>

                                                        </div>
                                                        <div class="form-group "> 
                                                            <div>
                                                                <label>Fecha Hasta</label>&nbsp;&nbsp;&nbsp;&nbsp; 
                                                                &nbsp;&nbsp;
                                                                <input type="date" name="fechafintxt" id="fechaActual2" class="form-control"  aria-label="Card Holder" aria-describedby="basic-addon1"> 
                                                               

                                                            </div>                                                                                                                   
                                                        </div> 
                                                    </div> 
                                                    
                                                </form>  --%>                                                  

                                            </div>
                                            <hr>
                                            <form action="informeCobros" method="POST"> 
                                                <%--
                                                <div class="card-block table-border-style">
                                                    <div class="table-responsive">
                                                        <table class="table table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th class="text-center">#</th>
                                                                    <th class="text-center">Nro Factura</th>
                                                                    <th class="text-center">Fecha factura</th>
                                                                    <th class="text-center">Razon Social</th>
                                                                    <th class="text-center">R.U.C.</th>                                                                        
                                                                    <th class="text-center">Condicion</th>
                                                                    <th class="text-center">Estado</th>
                                                                    <th class="text-center">Total a pagar</th>
                                                                    <th class="text-center">Total IVA</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <%
                                                                    if (AA != null) {
                                                                %> 
                                                                <%
                                                                    for (InformeCobros informeCobrosLL : AA) {
                                                                %>                                            
                                                                <tr>  
                                                                    <td class="text-center"> 
                                                                        <%= informeCobrosLL.getId_venta()%>
                                                                    </td>
                                                                    <td class="text-center"> 
                                                                        <%= informeCobrosLL.getNro_factura_venta()%>
                                                                    </td>                                          
                                                                    <td class="text-center"> 
                                                                        <%= informeCobrosLL.getFecha_factura_venta()%>
                                                                    </td> 
                                                                    <td class="text-center"> 
                                                                        <%= informeCobrosLL.getNombre_razon_venta()%>
                                                                    </td>
                                                                    <td class="text-center"> 
                                                                        <%= informeCobrosLL.getRuc_venta()%>
                                                                    </td>                                          
                                                                    <td class="text-center"> 
                                                                        <%= informeCobrosLL.getCondicion_venta()%>
                                                                    </td>
                                                                    <td class="text-center"> 
                                                                        <%= informeCobrosLL.getEstado_venta()%>
                                                                    </td>
                                                                    <td class="text-center"> 
                                                                        <%= informeCobrosLL.getTotal_pagar_venta()%>
                                                                    </td>
                                                                    <td class="text-center"> 
                                                                        <%= informeCobrosLL.getLiq_total_iva_venta()%>
                                                                    </td>
                                                                    <td class="text-center">
                                                                       

                                                                    </td> 
                                                                </tr>
                                                                <% } %>
                                                                <% } %>
                                                <%--       <% AA.clear();%>                                                       
                                            </tbody>
                                        </table>
                                        <div class="form-group col-sm-3" >
                                            <div class="input-group">
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                                                <h5>TOTAL:</h5>  

                                                                &nbsp;&nbsp;&nbsp;<input  type="text" name="descriptxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1"    id="descri" value="<%=Variables.sumarventa%>">                                                            
                                                            </div>  

                                                        </div>  
                                                    </div>
                                                </div>
                                                --%>
                                                <div>
                                                    <nav class="navbar navbar-dark navbar-expand-md navigation-clean-search">
                                                        <ul class="nav navbar-nav">
                                                            <li class="dropdown">

                                                                <%--    <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Atras">   --%>

                                                                <a class="btn btn-light action-button" role="button" href="Principal.jsp">Atras</a>
                                                                <input  type="hidden" name="txtprueba" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1"    id="descri" value="<%= infcob.getDesc_banco()%>">
                                                            </li>                                                                        

                                                        </ul>
                                                    </nav>
                                                </div>
                                            </form>




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

