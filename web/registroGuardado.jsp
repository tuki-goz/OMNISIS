<%-- 
    Document   : registroGuardado
    Created on : 27/07/2020, 02:36:43 PM
    Author     : Alvaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Registro Guardado</title>
        <STYLE TYPE="text/css" MEDIA=screen>
            <!-- 
            html,body{
                background-image: url('https://cdn.hipwallpaper.com/m/92/92/QObTSr.png');
                background-size: cover;
                background-repeat: no-repeat;
                height: 100%;
                font-family: 'Numans', sans-serif;
                color: white;



                --></style>
        </head>
        <body>
            <%@page import="controller.verTodos"%>
            <div class="container">
                <div class="row text-center">
                    <div class="col-sm-6 col-sm-offset-3">
                        <br><br> <h2 style="color:#0fad00">Pago realizado correctamente</h2>
                            <img src="http://files.softicons.com/download/web-icons/pretty-office-viii-icons-by-custom-icon-design/png/256x256/Accept.png">

                            <p style="font-size:20px;color:#5C5C5C;">Registro Guardado Correctamente :)</p>


                   
                           <form action="verTodos" method="POST">
                                <input type="submit" class="btn btn-success" value="Regresar">
                            </form>


                            
                        <br><br>
                    </div>

                </div>
            </div>            
            
        </body>
    </html>
