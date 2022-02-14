<%-- 
    Document   : A
    Created on : 07/09/2021, 09:13:53 PM
    Author     : Alvaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.contrato"%>
<!DOCTYPE html>

<%@page import="model.Contrato"%>
<%@page import="model.Cliente"%>
<%@page import="controller.contrato"%>
<%@page import="java.util.HashMap"%>
<%
    Contrato cont;
    cont = (Contrato) request.getAttribute("Contrato");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
        <!-- fontawesome icon -->
        <link rel="stylesheet" href="assets/fonts/fontawesome/css/fontawesome-all.min.css">
        <!-- animation css -->
        <link rel="stylesheet" href="assets/plugins/animation/css/animate.min.css">
        <!-- vendor css -->
        <link rel="stylesheet" href="assets/css/style.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    </head>

    <body>
        <%--
        <!-- [ Pre-loader ] start -->
        <div class="loader-bg">
            <div class="loader-track">
                <div class="loader-fill"></div>
            </div>
        </div>
        <!-- [ Pre-loader ] End -->

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
                            <label>Ventas</label>
                        </li>

                        <li data-username="dashboard Default Ecommerce CRM Analytics Crypto Project" class="nav-item">


                            <a href="javascript:$('#contrato').submit();" class="nav-link "><span class="pcoded-micon"><i class="feather icon-home"></i></span><span class="pcoded-mtext">Registro de Contratos</span></a>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">

                                </div>
                            </div>
                        </li>
                        <form action="contrato" method="POST">
                            <input type="hidden" name="buscartxt" value=" "> 
                            <li class="dropdown">
                                <input type="submit" name="accion" target="_blank" class="btn btn-light action-button" value="Contrato">
                            </li>
                        </form>
                        <li data-username="Table bootstrap datatable footable" class="nav-item">
                            <a href="tbl_bootstrap.html" class="nav-link "><span class="pcoded-micon"><i class="feather icon-server"></i></span><span class="pcoded-mtext">Registro de Ventas</span></a>
                        </li>


                    </ul>
                </div>
            </div>
        </nav>
        --%>

        <script>
            function multi() {
                var total = 1;
                var change = false; //
                $(".monto").each(function () {
                    if (!isNaN(parseFloat($(this).val()))) {
                        change = true;
                        total /= parseFloat($(this).val());
                    }
                });
                // Si se modifico el valor , retornamos la multiplicación
                // caso contrario 0
                total = (change) ? total : 0;
                document.getElementById('Costo').innerHTML = total;


                var v1 = total;

                document.getElementById("test").value = v1;
            }
        </script>  


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


    <tr>
        <td>
            <label>
                <label for="card-holder">   Total de la Compra</label>
                <input type="text" name="Precio" id="Precio" value="" class="monto" onkeyup="multi();">
            </label>
        </td>
        <td>
            <label>
                <label for="card-holder">  Impuesto</label>
                <input type="text" name="Cantidad" id="Cantidad" class="monto" onkeyup="multi();">
            </label>
        </td>
        <td>
            <label id="Costo" style.visibilit y="hidden">
                <input type="hidden" name="Costo" disabled>
            </label>
        </td> 
    </tr>

    <input value="" name="test" id="test" title="1" >



    <div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasic">Impuesto</label>
            <div class="col-md-4">
                <select id="selectbasic" name="selectbasic" class="form-control">
                    <option value="11">IVA10</option>
                    <option value="21">IVA5</option>
                    <option value="a">Excentas</option>
                </select>
            </div>
        </div>

        Total compra <input id="a" type="Number"/><br>
        <input id="selectbasic" type="hidden" disabled="true" /><br>
        Resultado: <input id="r" type="text" readonly="readonly"/><br>

        <input type="button" value="Calcular" onclick="Calcular()"/><br>

        <script src="https://code.jquery.com/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script>



            function Calcular() {
                var numero1 = Number($("#a").val());
                var numero2 = Number($("#selectbasic").val());
                var sumar = numero1 / numero2;
                var resultado = $("#r").val(sumar);
                var resultado = $("#r2").val(sumar);
                document.getElementById('r').innerHTML = resultado;

            }

        </script>


    </div>

    <div>
        <form name="f">
            <p>Número 1: <input type="number" name="num1" value="0" onchange="cal()" onkeyup="cal()" /></p>
            <p>Número 2: <input type="number" name="num2" value="0" onchange="cal()" onkeyup="cal()" /></p>
            <p>Suma: <input type="number" name="sum" value="0" readonly="readonly" /></p>
        </form>

        <script>
            function cal() {
                try {
                    var a = parseInt(document.f.num1.value),
                            b = parseInt(document.f.num2.value);
                    document.f.sum.value = a / b;
                } catch (e) {
                }
            }

        </script>
    </div>


    <%--
    <div>
                                            
                                                <p>Número 1: <input type="number" name="num1" value="0" onchange="cal()" onkeyup="cal()" /></p>
                                                <p>Número 2: <input type="number" name="num2" value="0" onchange="cal()" onkeyup="cal()" /></p>
                                                <p>Suma: <input type="number" name="sum" value="0" readonly="readonly" /></p>
                                           

                                            <script>
                                                function cal() {
                                                    try {
                                                        var a = parseInt(document.num1.value),
                                                                b = parseInt(document.num2.value);
                                                        document.f.sum.value = a + b;
                                                    } catch (e) {
                                                    }
                                                }

                                            </script>
                                        </div>
    --%>
    <script src="assets/js/vendor-all.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/pcoded.min.js"></script>






    <link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 

    <div>
        <input type="text" name="fechafin" id="dateofbirth">
        <input type="text" name="fechafin" id="dateofbirth1">
        <script>
            $(document).ready(function () {
                $("#dateofbirth").datepicker({
                    dateFormat: 'dd/mm/yy',
                }).datepicker("setDate", new Date());
            });
        </script>

        <script>
            $(document).ready(function () {
                $("#dateofbirth1").datepicker({
                    dateFormat: 'dd/mm/yy',
                }).datepicker("setDate", new Date());
            });
        </script>
    </div>



    

    <div class="form-group "> <%-- agregar espacio entre los labels &nbsp --%>
        <div class="input-group">
            <label>Fecha de fin</label>&nbsp;&nbsp;&nbsp;                                                                    
             
            <input type="text" name="fechafin" id="dateofbirth5" > 
          
            <input type="text" name="fechafin" id="dateofbirth6">

            
            <script>
                $(document).ready(function () {
                    $("#dateofbirth5").datepicker({
                        dateFormat: 'dd/mm/yy',
                    }).datepicker("setDate", new Date());
                }
                );
            </script>
            <script>
                $(document).ready(function () {
                    $("#dateofbirth6").datepicker({
                        dateFormat: 'dd/mm/yy',
                    }).datepicker("setDate", new Date());
                }
                );
            </script>
        </div>
    </div>

        
        
        <H1>Using a Reset Button</H1>
        <FORM ACTION="formAction.jsp" METHOD="POST">
            Please enter your name:
            <INPUT TYPE="TEXT" NAME="text1">
            <BR>
            
            <INPUT TYPE="RESET" value="Reset">
        </FORM>

</body>


</html>
