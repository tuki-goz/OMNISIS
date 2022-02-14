<%-- 
    Document   : mensaje
    Created on : 04/08/2021, 02:40:46 PM
    Author     : Alvaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Vacios</title>
        <STYLE TYPE="text/css" MEDIA=screen>
            <!-- 
            body{
                background: #fff;
            }
            .error-container {
                height: 100vh !important;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                font-family: montserrat, sans-serif;

            }

            .big-text {
                font-size: 200px;
                font-weight: 900;
                font-family: sans-serif;
                background: url(https://cdn.pixabay.com/photo/2018/05/30/15/39/thunderstorm-3441687_960_720.jpg) no-repeat;
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                background-size: cover;
                background-position: center;
            }

            .small-text {
                font-family: montserrat, sans-serif;
                color: rgb(0, 0, 0);
                font-size: 24px;
                font-weight: 700;
                text-transform: uppercase;
            }




            /* Style the search field */
            /*form.example input[type=text] {
      padding: 10px;
      font-size: 17px;
      border: 1px solid grey;
      float: left;
      width: 80%;
      background: #f1f1f1;
    }
            */

            .form-group {
                display: flex;
                /* border: 1px #53a0e4 solid;
                border-radius:30px;
                overflow: hidden;*/
            }

            /*	
            .form-group:focus-within{
               border: 1px green solid;
            }
            */

            /*	input:focus + .control-label
            */
            .form-control {
                overflow: hidden;
                background: #fff;
                border: 1px #53a0e4 solid;
                border-right: none;
                border-radius: 25px 0px 0px 25px;
                font-size: 1rem;
            }

            .form-control:focus {
                border-color: #61b045;
                box-shadow: none;
            }


            /* Style the submit button */
            form .search-btn {
                all: unset;
                width: 15%;
                padding: 10px;
                background: #1e50e2;
                color: white;
                font-size: 17px;
                border: 1px #1e50e2 solid;
                border-left: none;
                /* Prevent double borders */
                border: 1px #53a0e4 solid;
                border-radius: 0px 25px 25px 0px;
                cursor: pointer;
            }

            form .search-btn:hover {
                background: #0b7dda;
            }

            .button {
                color:	#fff;
                padding: 12px 36px;
                font-weight: 600;
                border: none;
                position: relative;
                font-family: 'Raleway', sans-serif;
                display: inline-block;
                text-transform: uppercase;
                -webkit-border-radius: 90px;
                -moz-border-radius: 90px;
                border-radius: 90px;
                margin: 2px;
                margin-top: 2px;
                background-image: linear-gradient(to right, #09b3ef 0%, #1e50e2 51%,#09b3ef 100%);
                background-size: 200% auto;
                flex: 1 1 auto;
                text-decoration: none;

            }


            .button:hover,
            .button:focus {
                color:	#ffffff;
                background-position: right center;
                -webkit-box-shadow: 0px 5px 15px 0px rgba(0, 0, 0, 0.1);
                -moz-box-shadow: 0px 5px 15px 0px rgba(0, 0, 0, 0.1);
                box-shadow: 0px 5px 15px 0px rgba(0, 0, 0, 0.1);
                text-decoration: none;
            }
            --></style>
    </head>

<body>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

        <div class="container error-container">
            <div class="row  d-flex align-items-center justify-content-center">
                <div class="col-md-12 text-center">
                    <h1 class="big-text">Oops!</h1>
                    <h2 class="small-text">VUELVA A INTENTARLO</h2>

                </div>
                <div class="col-md-6  text-center">
                    <p>Ingrese usuario o contraseña</p>
                    


                    
                    <h2 class="small-text">Por favor</h2>

                    <a href="index.htm" class="button button-dark-blue iq-mt-15 text-center">INTENTAR DE NUEVO</a>

                </div>

            </div>


        </div>

</body>
</html>
