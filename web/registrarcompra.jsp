<%-- 
    Document   : compras
    Created on : 17/06/2021, 04:43:21 PM
    Author     : Alvaro
--%>

<%@page import="model.Ordencompra"%>
<%@page import="model.Moneda"%>
<%@page import="model.Contrato"%>
<%@page import="model.Proveedor"%>
<%@page import="model.Usuario01"%>
<%@page import="model.Compra"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Compra com;
    com = (Compra) request.getAttribute("Compra");
    String b = "";
    if (com != null) {
        b = com.getNombre_usuario();
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Compra</title>
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

        [type="date"] {
            background:#fff url(https://cdn1.iconfinder.com/data/icons/cc_mono_icon_set/blacks/16x16/calendar_2.png)  97% 50% no-repeat ;
        }
        [type="date"]::-webkit-inner-spin-button {
            display: none;
        }
        [type="date"]::-webkit-calendar-picker-indicator {
            opacity: 0;
        }

        /* custom styles */
        body {
            padding: 4em;
            background: #e5e5e5;
            font: 13px/1.4 Geneva, 'Lucida Sans', 'Lucida Grande', 'Lucida Sans Unicode', Verdana, sans-serif;
        }
        label {
            display: block;
        }
        input {
            border: 1px solid #c4c4c4;
            border-radius: 5px;
            background-color: #fff;
            padding: 3px 5px;
            box-shadow: inset 0 3px 6px rgba(0,0,0,0.1);
            width: 190px;
        }
    </style>
    <script>
        var input = document.getElementById('numero');
        input.oninvalid = function (event) {
            event.target.setCustomValidity('Username should only contain lowercase letters. e.g. john');
        }
        var input = document.getElementById('fecha');
        input.oninvalid = function (event) {
            event.target.setCustomValidity('Username should only contain lowercase letters. e.g. john');
        }
        var input = document.getElementById('descri');
        input.oninvalid = function (event) {
            event.target.setCustomValidity('Username should only contain lowercase letters. e.g. john');
        }
        var input = document.getElementById('cantidad');
        input.oninvalid = function (event) {
            event.target.setCustomValidity('Username should only contain lowercase letters. e.g. john');
        }
        var input = document.getElementById('precio');
        input.oninvalid = function (event) {
            event.target.setCustomValidity('Username should only contain lowercase letters. e.g. john');
        }
    </script>
    <body>
        <%@ page import="model.Compra, java.util.ArrayList"  %>
        <%@ page import="controller.compra"  %>

        <%            ArrayList<Compra> compraDetalle = null;
            compraDetalle = (ArrayList<Compra>) request.getAttribute("CompraDet");
        %>   
        <%    Compra comp;
            comp = (Compra) request.getAttribute("Comp");
            int v_id_compra = 0;
            int v_id_compra_Det = 0;
            int v_cantidad_Det = 0;
            int v_id_orden_compra = 0;
            String v_descripcion_Det = "";
            Double v_iva5_Det = 0.0;
            Double v_iva10_Det = 0.0;
            Double v_exenta_Det = 0.0;
            Double v_precio_Det = 0.0;
            if (comp != null) {
                int a = comp.getCantidad_Det();
                v_id_compra = comp.getId_compra();
                v_id_compra_Det = comp.getId_compra_Det();
                v_cantidad_Det = comp.getCantidad_Det();
                v_id_orden_compra = comp.getCantidad_Det();
                v_descripcion_Det = comp.getDescripcion_Det();
                v_iva5_Det = comp.getIva5_Det();
                v_iva10_Det = comp.getIva10_Det();
                v_exenta_Det = comp.getExenta_Det();
                v_precio_Det = comp.getPrecio_Det();
                System.out.println(a);

            }

        %>

        <main class="page payment-page">
            <section class="payment-form dark">
                <div class="container">
                    <div class="block-heading">
                        <h2>Compra</h2>
                        <p>Por favor, complete los campos</p>
                    </div>
                    <form action="compra" method="POST" name="compra">
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
                                        <label for="card-holder">Código de compra</label>
                                        <% if (com.getCodigo() != null) {%> 
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="codtxt" class="form-control" aria-label="Card Holder" placeholder="Ej: Nro factura" aria-describedby="basic-addon1"  title="01" id="numero" value="<%= com.getCodigo()%>">                                        
                                        <%  } else {%>
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="codtxt" class="form-control" aria-label="Card Holder" placeholder="Ej: Nro factura" aria-describedby="basic-addon1"  title="01" id="numero" value="">                                        
                                        <% }%>
                                        <input id="card-holder" type="hidden" name="idtxt" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" value="<%= com.getId_compra()%>">  
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
                                <%-- -----------------------Scripts de calculos ----------------------------------- --%>
                                <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
                                <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.22/angular.min.js"></script>
                                <%-- -----------------------Scripts de calculos ----------------------------------- --%>





                                <div class="form-group col-sm-12"> <%-- agregar espacio entre los labels &nbsp --%>
                                    <div class="input-group">
                                        <label for="dateofbirth">Fecha compra</label>&nbsp;&nbsp;&nbsp;
                                        <% if (com.getFecha_compra() != null) {%> 
                                        <input type="date" name="fechacompra" id="dateofbirth" value="<%= com.getFecha_compra()%>">
                                        <%  } else {%>
                                        <input type="date" name="fechacompra" id="dateofbirth">
                                        <% }%>
                                        
                                        <%--
                                        <label for="card-holder">   Total de la Compra</label>
                                        <% if (com.getTotal_compra() != null) {%> 
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="totaltxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 1500000" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="14000000" id="precio" value="<%= com.getTotal_compra()%>">                                       
                                        <%  } else {%>
                                        &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="totaltxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01-12-2020" aria-describedby="basic-addon1" pattern="[0-9-.]{1,}" title="14000000" id="precio" value="">                                       
                                        <% }%>
                                        --%>
                                        
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
                                        </div><br><br>
                                        
                                        <div class="form-group col-sm-7">
                                            <label for="card-holder">Usuario</label>
                                            <select id="drop_usu" name="drop_usu" class="form-control" onChange="update()" >
                                                <%
                                                    Usuario01 usu = new Usuario01();
                                                    HashMap<String, String> drop = usu.seleccionarUsuario();
                                                    for (String i : drop.keySet()) {
                                                        if (com.getNombre_usuario() != null) {
                                                            if (drop.get(i).toString().equals(com.getNombre_usuario().toString())) {
                                                                //if (drop.get(i).toString()== b) {
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
                                            <select id="dropmon_mon" name="dropmon_mon" class="form-control" onChange="update()" >
                                                <%
                                                    Moneda mon = new Moneda();
                                                    HashMap<String, String> dropmon_mon = mon.seleccionarMoneda();
                                                    for (String i : dropmon_mon.keySet()) {
                                                        if (com.getDescrip_moneda() != null) {
                                                            if (dropmon_mon.get(i).toString().equals(com.getDescrip_moneda().toString())) {
                                                                out.println("<option value='" + i + "' selected>" + dropmon_mon.get(i) + "</option>");
                                                            } else {
                                                                out.println("<option value='" + i + "'>" + dropmon_mon.get(i) + "</option>");
                                                            }
                                                        } else {
                                                            out.println("<option value='" + i + "'>" + dropmon_mon.get(i) + "</option>");
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>   <br><br> <br><br>                                    

                                        <div class="form-group col-sm-12"> <%-- agregar espacio entre los labels &nbsp --%>
                                            <div class="input-group">

                                                <label for="card-holder">Cantidad</label>

                                                &nbsp;&nbsp;&nbsp;<input id="cantidad" type="text" name="cantidadtxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 01" aria-describedby="basic-addon1" pattern="[0-9]{1,}" title="1"  value="<%= v_cantidad_Det%>">


                                                &nbsp;&nbsp;&nbsp;<label for="card-holder">Descripcion</label>

                                                &nbsp;&nbsp;&nbsp;<input id="card-holder" type="text" name="descriptxt" class="form-control" aria-label="Card Holder" placeholder="Ej: Itemiser" aria-describedby="basic-addon1" pattern="[[A-Z]{1,}[a-z]{2}{1,}" title="XXXX" id="descri" value="<%= v_descripcion_Det%>">

                                            </div>
                                        </div>

                                        <%--BOTONES--%>
                                        <div>
                                            <div>
                                                <div class="form-form-group col-sm-12">
                                                    <label for="card-holder"> Total Compra</label>
                                                        <% if (com.getTotal_compra() != null) {%> 
                                                        &nbsp;&nbsp;&nbsp<input id="total" type="text" name="total2txt" class="form-control" aria-label="Card Holder"  aria-describedby="basic-addon1" value="<%= com.getTotal_compra()%>"/><br>
                                                        <%  } else {%>
                                                        &nbsp;&nbsp;&nbsp<input id="total" type="Number" name="total2txt" class="form-control" aria-label="Card Holder"  aria-describedby="basic-addon1"/><br>
                                                        <% }%>                                                    
                                                </div>
                                                
                                                <div class="form-form-group col-sm-12">
                                                    <label  for="selectbasic">Impuesto</label>
                                                    <div class="col-md-4">
                                                        <select id="selectbasic" name="selectbasic" class="form-control">
                                                            <option value="11">IVA10</option>
                                                            <option value="21">IVA5</option>
                                                            <option value="a">Excentas</option>
                                                        </select>
                                                    </div>
                                                </div><br><br>
                                                <%-- ----------------------------------------------- Aca empieza el calulo del impuestos, script mas funcion mas inputs  ----------------------------------------------- --%>
                                                <div>
                                                    <div class="form-form-group col-sm-7">                                                        
                                                        <label for="card-holder"> Total artículo</label>
                                                        <% if (com.getTotal_compra() != null) {%> 
                                                        <input id="a" type="Number" name="totaltxt" class="form-control" aria-label="Card Holder"  aria-describedby="basic-addon1" /><br>
                                                        <%  } else {%>
                                                        <input id="a" type="Number" name="totaltxt" class="form-control" aria-label="Card Holder"  aria-describedby="basic-addon1"/><br>
                                                        <% }%>                                                      
                                                        
                                                        <input id="selectbasic" type="hidden" disabled="true" />
                                                        <label for="card-holder"> Total impuesto</label>
                                                        <input id="r" type="text" readonly="readonly" name="tesultadotxt" class="form-control" aria-label="Card Holder"  aria-describedby="basic-addon1"/><br>
                                                        <input type="button" value="Calcular" onclick="Calcular()"/><br>
                                                    </div>
                                                        <%-- ----------------------------------------------- Aca empieza el calulo del impuestos, script mas funcion mas inputs  ----------------------------------------------- --%>
                                                </div>
                                                <script src="https://code.jquery.com/jquery-3.2.1.min.js" type="text/javascript"></script>
                                                <script>
                                                    function Calcular() {
                                                        var numero1 = Number($("#a").val());
                                                        var numero2 = Number($("#selectbasic").val());
                                                        var numero3 = Number($("#cantidad").val());
                                                        var sumar = numero1 / numero2;
                                                        var unita = numero1 / numero3;
                                                        if (numero2 == 11){
                                                            var resultado = $("#r").val(Math.round(sumar));
                                                            var resultado = $("#precio10").val(Math.round(sumar));
                                                            var resultado3 = $("#precioun").val(Math.round(unita));
                                                            document.getElementById("precio5").value = 0.0;
                                                            document.getElementById("precioex").value = 0.0;
                                                            document.getElementById('precio10').innerHTML = resultado;
                                                            document.getElementById('precioun').innerHTML = resultado3;
                                                        } else {
                                                            if (numero2 == 21){
                                                                var resultado = $("#r").val(Math.round(sumar));
                                                                var resultado = $("#precio5").val(Math.round(sumar));
                                                                var resultado3 = $("#precioun").val(Math.round(unita));
                                                                document.getElementById("precio10").value = 0.0;
                                                                document.getElementById("precioex").value = 0.0;                                                               
                                                                document.getElementById('precio5').innerHTML = resultado;
                                                                document.getElementById('precioun').innerHTML = resultado3;
                                                            }else{
                                                               var resultado = $("#r").val(Math.round(sumar));
                                                               var resultado = $("#precioex").val(Math.round(sumar));
                                                               var resultado3 = $("#precioun").val(Math.round(unita));
                                                               document.getElementById("precio5").value = 0.0;
                                                               document.getElementById("precio10").value = 0.0;
                                                               document.getElementById('precioex').innerHTML = resultado;
                                                               document.getElementById('precioun').innerHTML = resultado3;
                                                            }
                                                        }
                                                
                                                        document.getElementById('r').innerHTML = resultado;
                                                    }
                                                </script>
                                            </div><br><br>
                                            

                                            <div class="form-group col-sm-12"> <%-- agregar espacio entre los labels &nbsp --%>
                                                <div class="input-group">
                                                    <label for="card-holder">Iva 5</label> 
                                                    &nbsp;&nbsp;&nbsp;<input  id="precio5" type="text" name="iva5txt" class="form-control" aria-label="Card Holder" placeholder="Ej: 5" aria-describedby="basic-addon1"  readonly="true" title="19000"   value=" <%= v_iva5_Det%>">

                                                    &nbsp;&nbsp;&nbsp;<label for="card-holder">Iva 10</label>
                                                    &nbsp;&nbsp;&nbsp;<input  id="precio10" type="text" name="iva10txt" class="form-control" aria-label="Card Holder" placeholder="Ej: 2" aria-describedby="basic-addon1" readonly="true" pattern="[0-9-.]{1,}" title="19000"  value="<%= v_iva10_Det%>">

                                                </div>
                                            </div>
                                            <div class="form-group col-sm-12"> <%-- agregar espacio entre los labels &nbsp --%>
                                                <div class="input-group">
                                                    &nbsp;&nbsp;&nbsp;<label for="card-holder">Exenta</label>
                                                    &nbsp;&nbsp;&nbsp;<input  id="precioex" type="text" name="exentxt" class="form-control" aria-label="Card Holder" placeholder="Ej: 2" aria-describedby="basic-addon1" readonly="true" pattern="[0-9-.]{1,}" title="0"  value="<%= v_exenta_Det%>">

                                                    <label for="card-holder">Precio unitario</label>
                                                    &nbsp;&nbsp;&nbsp;<input  id="precioun" type="text" name="prectxt" class="form-control" aria-label="Card Holder" placeholder="Ej: Scanner" aria-describedby="basic-addon1" readonly="true" pattern="[0-9-.]{1,}" title="1000000"  value="<%= v_precio_Det%>">
                                                </div>
                                            </div>
                                        </div>
                                        <%--BUSCADOR DEL ORDEN DE COMPRA--%>
                                        <div class="form-group col-sm-12"> 

                                            <label for="card-holder">Orden de Compra</label>
                                            <select id="dropord_ord" name="dropord_ord" class="form-control" onChange="update()" >
                                                <%
                                                    Ordencompra orden_c = new Ordencompra();
                                                    HashMap<String, String> dropord_ord = orden_c.seleccionarOrdencompra();
                                                    for (String i : dropord_ord.keySet()) {
                                                        if (comp != null) {
                                                            if (dropord_ord.get(i).toString().equals(comp.getDescrip_orden().toString())) {
                                                                out.println("<option value='" + i + "' selected>" + dropord_ord.get(i) + "</option>");
                                                            } else {
                                                                out.println("<option value='" + i + "'>" + dropord_ord.get(i) + "</option>");
                                                            }
                                                        } else {
                                                            out.println("<option value='" + i + "'>" + dropord_ord.get(i) + "</option>");
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>

                                        <div class="container-fluid margin">

                                            <input type="hidden" name="detallecompra" value="<%=v_id_compra_Det%> ">


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


                                                    <input type="hidden" name="txt1" value="<%= comdet.getCantidad_Det()%>"> 
                                                    <input type="hidden" name="txt2" value="<%= comdet.getDescripcion_Det()%>">
                                                    <input type="hidden" name="txt3" value="<%= comdet.getIva5_Det()%>">                                                   
                                                    <input type="hidden" name="txt4" value="<%= comdet.getIva10_Det()%>">                                                   
                                                    <input type="hidden" name="txt5" value="<%= comdet.getExenta_Det()%>">                                                   
                                                    <input type="hidden" name="txt6" value="<%= comdet.getPrecio_Det()%>">                                                   
                                                    <input type="hidden" name="txt7" value="<%= comdet.getId_orden_compra()%>">    
                                                    <input type="hidden" name="idCompra" value="<%= comdet.getId_compra()%>">    
                                                    <input type="hidden" name="idCompraDet" value="<%= comdet.getId_compra_Det()%>"> 


                                                    <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Cambiar">                                                   


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

                            </div>
                        </div>


                    </form>
                </div>
            </section>
        </main>
    </body>


</html>