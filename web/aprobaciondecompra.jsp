<%-- 
    Document   : aprobaciondecompra
    Created on : 15/08/2021, 06:19:38 PM
    Author     : Alvaro
--%>

<%@page import="model.Funcionario"%>
<%@page import="model.Aprobacioncompra"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Usuario01"%>
<%@page import="model.Pedidocompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Aprobacioncompra apr;
    apr = (Aprobacioncompra) request.getAttribute("Aprobacion");

%>
<!DOCTYPE html>

<html>
    <head>
        <title>Aprobación</title>
        <link rel="icon" href="img/favicon.ico">  
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <link rel="stylesheet" href="css/estiloformulario.css">
    </head>
    <style>
        input:invalid { border-color: red; } input, input:valid { border-color: #ccc; }

        .payment-form{
            padding-bottom: 50px;
            font-family: 'Montserrat', sans-serif;
        }

        .payment-form.dark{

        }
        .payment-form .content{
            box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
            background-color: white;
        }

        .payment-form .block-heading{
            padding-top: 50px;
            margin-bottom: 40px;
            text-align: center;
        }

        .payment-form .block-heading p{
            text-align: center;
            max-width: 420px;
            margin: auto;
            opacity:0.7;
        }

        .payment-form.dark .block-heading p{
            opacity:0.8;
            color: #ffffff;
        }

        .payment-form .block-heading h1,
        .payment-form .block-heading h2,
        .payment-form .block-heading h3 {
            margin-bottom:1.2rem;
            color: #ffffff;
        }

        .payment-form form{
            border-top: 2px solid #ffffff;
            box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
            background-color: #e9e9e9;
            padding: 0;
            max-width: 800px;
            margin: auto;
        }

        .payment-form .title{
            font-size: 1em;
            border-bottom: 1px solid rgba(0,0,0,0.1);
            margin-bottom: 0.8em;
            font-weight: 600;
            padding-bottom: 8px;
        }

        .payment-form .products{
            background-color: #f7fbff;
            padding: 25px;
        }

        .payment-form .products .item{
            margin-bottom:1em;
        }

        .payment-form .products .item-name{
            font-weight:600;
            font-size: 0.9em;
        }

        .payment-form .products .item-description{
            font-size:0.8em;
            opacity:0.6;
        }

        .payment-form .products .item p{
            margin-bottom:0.2em;
        }

        .payment-form .products .price{
            float: right;
            font-weight: 600;
            font-size: 0.9em;
        }

        .payment-form .products .total{
            border-top: 1px solid rgba(0, 0, 0, 0.1);
            margin-top: 10px;
            padding-top: 19px;
            font-weight: 600;
            line-height: 1;
        }

        .payment-form .card-details{
            padding: 25px 25px 15px;
        }

        .payment-form .card-details label{
            font-size: 12px;
            font-weight: 600;
            margin-bottom: 15px;
            color: #722f37;
            text-transform: uppercase;
        }

        .payment-form .card-details button{
            margin-top: 0.6em;
            padding:12px 0;
            font-weight: 600;
        }

        .payment-form .date-separator{
            margin-left: 10px;
            margin-right: 10px;
            margin-top: 5px;
        }

        @media (min-width: 576px) {
            .payment-form .title {
                font-size: 1.2em; 
            }

            .payment-form .products {
                padding: 40px; 
            }

            .payment-form .products .item-name {
                font-size: 1em; 
            }

            .payment-form .products .price {
                font-size: 1em; 
            }

            .payment-form .card-details {
                padding: 40px 40px 30px; 
            }

            .payment-form .card-details button {
                margin-top: 2em; 
            } 
        }
        /*BOTON CHECKBOX*/
        .text-small {
            font-size: 0.9rem !important;
        }

        body {
            background: linear-gradient(to left, #56ab2f, #a8e063);
        }

        .cursor-pointer {
            cursor: pointer;
        }
        body {
            background-color: #808080;
            background-image: url("data:image/svg+xml,%3Csvg width='40' height='40' viewBox='0 0 40 40' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M20 20.5V18H0v-2h20v-2H0v-2h20v-2H0V8h20V6H0V4h20V2H0V0h22v20h2V0h2v20h2V0h2v20h2V0h2v20h2V0h2v20h2v2H20v-1.5zM0 20h2v20H0V20zm4 0h2v20H4V20zm4 0h2v20H8V20zm4 0h2v20h-2V20zm4 0h2v20h-2V20zm4 4h20v2H20v-2zm0 4h20v2H20v-2zm0 4h20v2H20v-2zm0 4h20v2H20v-2z' fill='%23722f37' fill-opacity='0.4' fill-rule='evenodd'/%3E%3C/svg%3E");
        }
    </style>
    <script>
        var input = document.getElementById('descri');
        input.oninvalid = function (event) {
            event.target.setCustomValidity('Username should only contain lowercase letters. e.g. john');
        }
        var input = document.getElementById('numero');
        input.oninvalid = function (event) {
            event.target.setCustomValidity('Username should only contain lowercase letters. e.g. john');
        }
    </script>
    <body>
        <main class="page payment-page">
            <section class="payment-form dark">
                <div class="container">
                    <div class="block-heading">
                        <h2>Aprobación de compras</h2>
                        <p>Por favor, complete los campos</p>
                    </div>
                    <form action="aprobaciondecompra" method="POST">
                        <div class="card-details">
                            <h3 class="title">Detalles de la aprobación de compras</h3>
                            <div class="row">
                                <div class="form-group col-sm-7">
                                    <label for="card-holder">Buscar</label>
                                    <input id="card-holder" type="text" name="buscartxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01" aria-describedby="basic-addon1">
                                    <span>
                                        <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar">
                                    </span>
                                </div>
                                <%-- Campo para completar--%>
                                <div class="form-group col-sm-12"> <%-- agregar espacio entre los labels &nbsp --%>
                                    <div class="input-group">
                                        <label for="card-holder">Descripción</label>
                                        <% if (apr.getDescripcion_aprobacion_compra() != null) {%> 
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="descriptxt" class="form-control" aria-label="Card Holder" placeholder="Ej: Aprobado" aria-describedby="basic-addon1"  title="Aprobado" id="descri" value="<%= apr.getDescripcion_aprobacion_compra()%>">
                                        <%  } else {%>
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="descriptxt" class="form-control" aria-label="Card Holder" placeholder="Ej: Aprobado" aria-describedby="basic-addon1"  title="Aprobado" id="descri" value="">
                                        <% }%>
                                        <input id="card-holder" type="hidden" name="idtxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= apr.getId_aprobacion()%>">
                                        &nbsp;&nbsp;&nbsp;<label for="card-holder">Numero de aprobacion</label>
                                        <% if (apr.getNro_aprobacion() != null) {%> 
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="aprobtxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01" aria-describedby="basic-addon1" pattern="[0-9]{1,}" title="01" id="numero" value="<%= apr.getNro_aprobacion()%>">
                                        <%  } else {%>
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="aprobtxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01" aria-describedby="basic-addon1" pattern="[0-9]{1,}" title="01" id="numero" value="">
                                        <% }%>
                                    </div>
                                </div>                                

                                <%--BOTON CHEKBOX PARA ESTADO--%>
                                <div class="form-group col-sm-12"> <%-- agregar espacio entre los labels &nbsp --%>
                                    <div class="input-group">
                                        <label for="card-holder">Estado</label>
                                        &nbsp;&nbsp;&nbsp;
                                        <ul class="list-group">
                                            <li class="list-group-item rounded-0 d-flex align-items-center justify-content-between">
                                                <div class="custom-control custom-radio">
                                                    <input class="custom-control-input" id="customRadio1" type="radio" name="customRadio" checked="true" value="activo">
                                                    <label class="custom-control-label" for="customRadio1">
                                                        <p class="mb-0">Activo</p>
                                                    </label>
                                                </div>
                                                <label for="customRadio1"><img src="https://res.cloudinary.com/mhmd/image/upload/v1579682182/2_rqo4zs.gif" alt="" width="60"></label>
                                            </li>
                                            <li class="list-group-item d-flex align-items-center justify-content-between">
                                                <div class="custom-control custom-radio">
                                                    <input class="custom-control-input" id="customRadio2" type="radio" name="customRadio" value="inactivo">
                                                    <label class="custom-control-label" for="customRadio2">
                                                        <p class="mb-0">Inactivo</p>
                                                    </label>
                                                </div>
                                                <label for="customRadio2"><img src="https://res.cloudinary.com/mhmd/image/upload/v1579682182/1_ezgo0i.png" alt="" width="60"></label>
                                            </li>
                                        </ul>
                                        <%--BUSCADOR DEL PAÍS--%>
                                        <div class="form-group col-sm-7">
                                            <label for="card-holder">Aprobado por:</label>
                                            <select id="dropusu_usu" name="dropusu_usu" class="form-control" onChange="update()" >
                                                <%
                                                    Usuario01 usu = new Usuario01();
                                                    HashMap<String, String> dropusu = usu.seleccionarUsuario();
                                                    for (String i : dropusu.keySet()) {
                                                        if (apr.getNombre_usu() != null) {
                                                            if (dropusu.get(i).toString().equals(apr.getNombre_usu().toString())) {
                                                                out.println("<option value='" + i + "' selected>" + dropusu.get(i) + "</option>");
                                                            } else {
                                                                out.println("<option value='" + i + "'>" + dropusu.get(i) + "</option>");
                                                            }
                                                        } else {
                                                            out.println("<option value='" + i + "'>" + dropusu.get(i) + "</option>");
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        
                                        <% if (apr.getNombre_usu()!= null) {%> 
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nomusua" class="form-control" aria-label="Card Holder" placeholder="Ej: 01" aria-describedby="basic-addon1" pattern="[0-9]{1,}" title="01" id="numero" disabled="true"value="<%= apr.getNombre_usu()%>">
                                        <%  } else {%>
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="nomusua" class="form-control" aria-label="Card Holder" placeholder="Ej: 01" aria-describedby="basic-addon1" pattern="[0-9]{1,}" title="01" id="numero" value="">
                                        <% }%>
                                        <div class="form-group col-sm-7">
                                            <label for="card-holder">Pedido</label>
                                            <select id="dropped_ped" name="dropped_ped" class="form-control" onChange="update()" >
                                                <%
                                                    Pedidocompra pedc = new Pedidocompra();
                                                    HashMap<String, String> dropped_ped = pedc.seleccionarPedidocompra();
                                                    for (String i : dropped_ped.keySet()) {
                                                        if (apr.getDecripcion_pedido() != null) {
                                                            if (dropped_ped.get(i).toString().equals(apr.getDecripcion_pedido().toString())) {
                                                                out.println("<option value='" + i + "' selected>" + dropped_ped.get(i) + "</option>");
                                                            } else {
                                                                out.println("<option value='" + i + "'>" + dropped_ped.get(i) + "</option>");
                                                            }
                                                        } else {
                                                            out.println("<option value='" + i + "'>" + dropped_ped.get(i) + "</option>");
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <%--BOTONES--%>
                                <div>
                                    <nav class="navbar navbar-dark navbar-expand-md navigation-clean-search">
                                        <ul class="nav navbar-nav">

                                            <li class="dropdown">
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Guardar">
                                            </li>

                                            <li class="dropdown">
                                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Modificar">
                                            </li>
                                            <a class="btn btn-light action-button" role="button" href="Principal.jsp">Atrás</a>
                                        </ul>
                                    </nav>
                                </div>
                                <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                                <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
        </main>
    </body>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>
