<%-- 
    Document   : compra
    Created on : 04/09/2021, 11:21:04 AM
    Author     : Alvaro
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Compra"%>
<%@page import="model.Ordencompra"%>
<%@page import="model.Moneda"%>
<%@page import="model.Contrato"%>
<%@page import="model.Usuario01"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Compra com;
    com = (Compra) request.getAttribute("Compra");

%>
<!DOCTYPE html>
<html>
    <head>
        <title>Importación</title>
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
    <body>
        <%@ page import="model.Compra, java.util.ArrayList"  %>
        <%@ page import="controller.compra"  %>

        <%             ArrayList<Compra> compraDetalle = null;
            compraDetalle = (ArrayList<Compra>) request.getAttribute("CompraDet");
        %> 
        <main class="page payment-page">
            <section class="payment-form dark">
                <div class="container">
                    <div class="block-heading">
                        <h2>Registro de importaciones</h2>
                        <p>Por favor, complete los campos</p>
                    </div>
                    <form action="compra" method="POST">
                        <div class="card-details">
                            <h3 class="title">Detalles de la Compra</h3>
                            <div class="row">
                                <div class="form-group col-sm-7">
                                    <label for="card-holder">Buscar</label>
                                    <input id="card-holder" type="text" name="buscartxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" placeholder="Ej: 01" pattern="[0-9]{1,}" title="01" id="numero">
                                    <span>
                                        <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Buscar">
                                    </span>
                                </div> <br>
                                <%-- Campo para completar--%>
                                <div class="form-group col-sm-7"> <%-- agregar espacio entre los labels &nbsp --%>
                                    <div class="input-group">
                                        <label for="card-holder">Código</label>
                                        <% if (com.getCod_contrato() != null) {%> 
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="codtxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01" aria-describedby="basic-addon1" pattern="[0-9]{1,}" title="01" id="numero" value="<%= com.getCod_contrato()%>">                                        
                                        <%  } else {%>
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="codtxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01" aria-describedby="basic-addon1" pattern="[0-9]{1,}" title="01" id="numero" value="">                                        
                                        <% }%>
                                        <%--   <input id="card-holder" type="hidden" name="idtxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= com.getId_compra()%>">  --%>
                                        <%--
                                        <label for="card-holder">Proveedor</label>
                                        <% if (com.getProveedor() != null) {%> 
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="provtxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01-12-2020" aria-describedby="basic-addon1" pattern="[[A-Z]{1}[a-z]{2}\D{1,}" title="Rolm" id="descri" value="<%= com.getProveedor()%>">                                       
                                        <%  } else {%>
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="provtxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01-12-2020" aria-describedby="basic-addon1" pattern="[[A-Z]{1}[a-z]{2}\D{1,}" title="Rolm" id="descri" value="">                                       
                                        <% }%> --%>
                                    </div>
                                </div><br>
                                <br>

                                <div class="form-group col-sm-12"> <%-- agregar espacio entre los labels &nbsp --%>
                                    <div class="input-group">
                                        <label for="card-holder">Fecha</label>
                                        <% if (com.getFecha_compra() != null) {%> 
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="fechatxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01-12-2020" aria-describedby="basic-addon1" pattern="[0-9-]{1,}" title="01-12-2020" id="fecha" value="<%= com.getFecha_compra()%>">                                       
                                        <%  } else {%>
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="fechatxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01-12-2020" aria-describedby="basic-addon1" pattern="[0-9-]{1,}" title="01-12-2020" id="fecha" value="">                                       
                                        <% }%>
                                        <label for="card-holder">   Total de la Compra</label>
                                        <% if (com.getTotal_compra() != null) {%> 
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="totaltxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01-12-2020" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="14000000" id="precio" value="<%= com.getTotal_compra()%>">                                       
                                        <%  } else {%>
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="totaltxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01-12-2020" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="14000000" id="precio" value="">                                       
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
                                        <%--BUSCADOR DEL PROVEEDOR--%>
                                        <div class="form-group col-sm-7">
                                            <label for="card-holder">Proveedor</label>
                                            <select id="drop_prov" name="drop_prov" class="form-control" onChange="update()" >
                                                <%
                                                    Proveedor prov = new Proveedor();
                                                    HashMap<String, String> dropprov = prov.seleccionarProveedor();
                                                    for (String i : dropprov.keySet()) {
                                                        if (com.getDescrip_prov() != null) {
                                                            if (dropprov.get(i).toString().equals(com.getDescrip_prov().toString())) {
                                                                out.println("<option value='" + i + "' selected>" + dropprov.get(i) + "</option>");
                                                            } else {
                                                                out.println("<option value='" + i + "'>" + dropprov.get(i) + "</option>");
                                                            }
                                                        } else {
                                                            out.println("<option value='" + i + "'>" + dropprov.get(i) + "</option>");
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-7">
                                            <label for="card-holder">Usuario</label>
                                            <select id="drop_usu" name="drop_usu" class="form-control" onChange="update()" >
                                                <%
                                                    Usuario01 usu = new Usuario01();
                                                    HashMap<String, String> drop = usu.seleccionarUsuario();
                                                    for (String i : drop.keySet()) {
                                                        if (com.getNom_usu_mod() != null) {
                                                            if (drop.get(i).toString().equals(com.getNom_usu_mod().toString())) {
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
                                        <%--BUSCADOR DEL CONTRATO--%>
                                        <div class="form-group col-sm-4">
                                            <label for="card-holder">Contrato</label>
                                            <select id="drop_contr" name="drop_contr" class="form-control" onChange="update()" >
                                                <%
                                                    Contrato contr = new Contrato();
                                                    HashMap<String, String> dropcontr = contr.seleccionarContrato();
                                                    for (String i : dropcontr.keySet()) {
                                                        if (com.getCod_contrato() != null) {
                                                            if (dropcontr.get(i).toString().equals(com.getCod_contrato().toString())) {
                                                                out.println("<option value='" + i + "' selected>" + dropcontr.get(i) + "</option>");
                                                            } else {
                                                                out.println("<option value='" + i + "'>" + dropcontr.get(i) + "</option>");
                                                            }
                                                        } else {
                                                            out.println("<option value='" + i + "'>" + dropcontr.get(i) + "</option>");
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-7">
                                            <label for="card-holder">Moneda</label>
                                            <select id="drop_mon" name="drop_mon" class="form-control" onChange="update()" >
                                                <%
                                                    Moneda mon = new Moneda();
                                                    HashMap<String, String> dropmon = mon.seleccionarMoneda();
                                                    for (String i : dropmon.keySet()) {
                                                        if (com.getDescrip_moneda() != null) {
                                                            if (dropmon.get(i).toString().equals(com.getDescrip_moneda().toString())) {
                                                                out.println("<option value='" + i + "' selected>" + dropmon.get(i) + "</option>");
                                                            } else {
                                                                out.println("<option value='" + i + "'>" + dropmon.get(i) + "</option>");
                                                            }
                                                        } else {
                                                            out.println("<option value='" + i + "'>" + dropmon.get(i) + "</option>");
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>                                        
                                        <%--BUSCADOR DEL Usuario--%>
                                        <%--     <div class="form-group col-sm-7">

                                        </div>  --%>                                      
                                        <div class="form-group col-sm-12"> <%-- agregar espacio entre los labels &nbsp --%>
                                            <div class="input-group">
                                                <label for="card-holder">Cantidad</label>
                                                <% if (com.getCantidad_Det() != 0) {%> 
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="cantidadtxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01" aria-describedby="basic-addon1" pattern="[0-9]{1,}" title="1" id="descri" value="<%= com.getCantidad_Det()%>">
                                                <%  } else {%>
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="cantidadtxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01" aria-describedby="basic-addon1" pattern="[0-9]{1,}" title="1" id="descri" value="">
                                                <% }%>
                                                &nbsp;&nbsp;&nbsp;<label for="card-holder">Descripcion</label>
                                                <% if (com.getDescripcion_Det() != null) {%> 
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="descriptxt" class="form-control" aria-label="Card Holder" placeholder="Ej: Itemiser" aria-describedby="basic-addon1" pattern="[[A-Z]{1}[a-z]{2}\D{1,}" title="XXXX" id="cantidad" value="<%= com.getDescripcion_Det()%>">
                                                <%  } else {%>
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="descriptxt" class="form-control" aria-label="Card Holder" placeholder="Ej: Itemiser" aria-describedby="basic-addon1" pattern="[[A-Z]{1}[a-z]{2}\D{1,}" title="XXXX" id="cantidad" value="">
                                                <% }%>
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
                                                    <a class="btn btn-light action-button" role="button" href="compras.jsp">Atrás</a>
                                                </ul>
                                            </nav>
                                        </div>

                                        <%-- ----------------------------------------------------------HASTA ACA FUNCIONA EN EL JSP, EL RESTO NO MUESTRA---------------------------------------------------------- --%>
                                        <%-- ----------------------------------------------------------HASTA ACA FUNCIONA EN EL JSP, EL RESTO NO MUESTRA---------------------------------------------------------- --%>
                                        <%-- ----------------------------------------------------------HASTA ACA FUNCIONA EN EL JSP, EL RESTO NO MUESTRA---------------------------------------------------------- --%>

                                        <div class="form-group col-sm-7"> <%-- agregar espacio entre los labels &nbsp --%>
                                            <div class="input-group">
                                                <label for="card-holder">Iva 5</label>
                                                <% if (com.getIva5_Det() != null) {%> 
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="iva5txt" class="form-control" aria-label="Card Holder" placeholder="Ej: Scanner" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="19000" id="precio" value="<%= com.getIva5_Det()%>">
                                                <%  } else {%>
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="iva5txt" class="form-control" aria-label="Card Holder" placeholder="Ej: Scanner" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="19000" id="precio" value="">
                                                <% }%>
                                                &nbsp;&nbsp;&nbsp;<label for="card-holder">Iva 10</label>
                                                <% if (com.getIva10_Det() != 0) {%> 
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="iva10txt" class="form-control" aria-label="Card Holder" placeholder="Ej: 2" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="19000" id="precio" value="<%= com.getIva10_Det()%>">
                                                <%  } else {%>
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="iva10txt" class="form-control" aria-label="Card Holder" placeholder="Ej: 2" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="19000" id="precio" value="">
                                                <% }%>
                                            </div>
                                        </div>
                                        <div class="form-group col-sm-7"> <%-- agregar espacio entre los labels &nbsp --%>
                                            <div class="input-group">
                                                &nbsp;&nbsp;&nbsp;<label for="card-holder">Exenta</label>
                                                <% if (com.getExenta_Det() != 0) {%> 
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="exentxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 2" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="0" id="precio" value="<%= com.getExenta_Det()%>">
                                                <%  } else {%>
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="exentxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 2" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="0" id="precio" value="">
                                                <% }%>
                                                <label for="card-holder">Precio</label>
                                                <% if (com.getPrecio_Det() != null) {%> 
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="prectxt" class="form-control" aria-label="Card Holder" placeholder="Ej: Scanner" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="1000000" id="precio" value="<%= com.getPrecio_Det()%>">
                                                <%  } else {%>
                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="prectxt" class="form-control" aria-label="Card Holder" placeholder="Ej: Scanner" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="1000000" id="precio" value="">
                                                <% }%>                                               
                                            </div>
                                        </div>
                                        <%--BUSCADOR DEL ORDEN DE COMPRA--%>
                                        <div class="form-group col-sm-7">
                                            <label for="card-holder">Orden de Compra</label>
                                            <select id="drop_orden" name="drop_orden" class="form-control" onChange="update()" >
                                                <%
                                                    Ordencompra orden_c = new Ordencompra();
                                                    HashMap<String, String> droporden = orden_c.seleccionarOrdencompra();
                                                    for (String i : droporden.keySet()) {
                                                        if (com.getDescrip_orden() != null) {
                                                            if (droporden.get(i).toString().equals(com.getDescrip_orden().toString())) {
                                                                out.println("<option value='" + i + "' selected>" + droporden.get(i) + "</option>");
                                                            } else {
                                                                out.println("<option value='" + i + "'>" + droporden.get(i) + "</option>");
                                                            }
                                                        } else {
                                                            out.println("<option value='" + i + "'>" + droporden.get(i) + "</option>");
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>

                                        <div class="container-fluid margin">
                                            <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Ingresar">
                                        </div>
                                        <table class="table table-striped custab">
                                            <thead>
                                                <tr>
                                                    <th class="text-center">Cantidad:</th>
                                                    <th class="text-center">Descripción:</th>
                                                    <th class="text-center">Iva5:</th>
                                                    <th class="text-center">Iva10:</th>
                                                    <th class="text-center">Exenta:</th>
                                                    <th class="text-center">Precio:</th>
                                                    <th class="text-center">N° Orden de Compra:</th>
                                                </tr>
                                            </thead>
                                            <%
                                                if (compraDetalle != null) {
                                            %> 
                                            <%
                                                for (Compra comdet : compraDetalle) {
                                            %>                                            
                                            <tr>
                                                <%--CANTIDAD--%>
                                                <td class="text-center"> 
                                                    <%= comdet.getCantidad_Det()%>
                                                </td>
                                                <%--DESCRIPCION--%>
                                                <td class="text-center"> 
                                                    <%= comdet.getDescripcion_Det()%>
                                                </td>
                                                <%--PRODUCTO--%>
                                                <td class="text-center"> 
                                                    <%= comdet.getIva5_Det()%>
                                                </td>
                                                <td class="text-center"> 
                                                    <%= comdet.getIva10_Det()%>
                                                </td>
                                                <td class="text-center"> 
                                                    <%= comdet.getExenta_Det()%>
                                                </td>
                                                <td class="text-center"> 
                                                    <%= comdet.getPrecio_Det()%>
                                                </td>
                                                <td class="text-center"> 
                                                    <%= comdet.getId_orden_compra()%>
                                                </td>
                                                <td>
                                                    <input type="hidden" value="<%= comdet.getCantidad_Det()%>"> 
                                                    <input type="hidden" value="<%= comdet.getDescripcion_Det()%>">
                                                    <input type="hidden"  value="<%= comdet.getIva5_Det()%>">                                                   
                                                    <input type="hidden"  value="<%= comdet.getIva10_Det()%>">                                                   
                                                    <input type="hidden"  value="<%= comdet.getExenta_Det()%>">                                                   
                                                    <input type="hidden"  value="<%= comdet.getPrecio_Det()%>">                                                   
                                                    <input type="hidden"  value="<%= comdet.getId_orden_compra()%>">                                                   
                                                </td>
                                            </tr>
                                            <% } %>
                                            <% } %>
                                            <% compraDetalle.size();%>
                                        </table>
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
</body>
</html>
