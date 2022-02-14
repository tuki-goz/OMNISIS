<%-- 
    Document   : registrarcompramodificado
    Created on : 24/08/2021, 09:02:29 PM
    Author     : Francisca Gómez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Exitoso</title>            
        <link rel="icon" href="img/favicon.ico">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <STYLE TYPE="text/css" MEDIA=screen>
            <!--
            p, h1, h2, h3, h4, h5 {
                margin: 0;
            }

            body{
                margin: 0;
                padding: 0;
                font-family: 'Roboto', sans-serif;
                font-weight: 400;
                font-size: 12px;
                background: #f3f3f3;
            }

            .error-wrapper {
                position: absolute;
                left: 50%;
                top: 50%;
                transform: translate(-50%, -50%);
                text-align: center;
            }

            .error-wrapper .title {
                font-size: 32px;
                font-weight: 700;
                color: #000;
            }

            .error-wrapper .info {
                font-size: 14px;
            }

            .home-btn, 
            .home-btn:focus, 
            .home-btn:hover, 
            .home-btn:visited {
                text-decoration: none;
                font-size: 14px;
                color: #55aa29;
                padding: 17px 77px;
                border: 1px solid #55aa29;
                -webkit-border-radius: 3px;
                -moz-border-radius: 3px;
                -o-border-radius: 3px;
                border-radius: 3px;
                display: block;
                margin: 20px 0;
                width: max-content;
                background-color: transparent;
                outline: 0;
            }

            .man-icon {
                background: url('https://www.hotstar.com/assets/b5e748831c911ca02f9c07afc11f2ae5.svg') center center no-repeat;
                display: inline-block;
                height: 100px;
                width: 118px;
                margin-bottom: 16px;
            }
            -->
        </STYLE>
    </head>
    <body>
        <%@page import="controller.pais"%>
        <link href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900|Roboto:100,300,400,500,700,900" rel="stylesheet" />
        <div class="container">
            <div class="error-wrapper">
                <div class="man-icon"></div>
                <h3 class="title">GENIAL</h3>
                <p class="info">He modifcado correctamente los datos de la compra</p>
                <a button type="button" class="home-btn" href="Principal.jsp" >Volver</button></a> 
            </div>
        </div>
    </body>
</html>
