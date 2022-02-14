//VALIDAR SOLO TEXTO
function validartexto(parametro) {
    var patron = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]*$/;
    if (parametro.search(patron)) {
        return false;
    } else {
        return true;
    }
}
//VALIDAR SOLO NUMEROS
function validarnumero(parametro) {
    if (!/^([0-9])*$/.test(parametro)) {
        return false;
    } else {
        return true;
    }
}
//VALIDAR CORREO
function validarcorreo(parametro) {
    var patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (patron.test(parametro)) {
        return false;
    } else {
        return true;
    }
}
//VALIDAR ESPACIOS BLANCOS
function validarespacio(parametro) {
    var patron = /^\s+$/;
    if (patron.test(parametro)) {
        return false;
    } else {
        return true;
    }
}
//VALIDAR NUMERO DE CARACTERES
function validarlongitudConAnt(parametro) {
    if (parametro.length < 3 || parametro.length > 3) {
        return false;
    } else {
        return true;
    }
}
function validarlongitudConAct(parametro) {
    if (parametro.length < 3 || parametro.length > 12) {
        return false;
    } else {
        return true;
    }
}
function validarFormulario1() {
    var formulario1 = document.addForm;
    //FUNCION PARA DESVANERCER EL ALERTA
    $(document).ready(function () {
        window.setTimeout(function () {
            $(".alert").fadeTo(1000, 0).slideUp(1000, function () {
                $(this).remove();
            });
        }, 2000);
    });
    //VALIDAR CAMPOS VACIOS
    if (formulario1.usuario.value === "" || validarespacio(formulario1.usuario.value) === false) {
        document.getElementById("alerta1").innerHTML = '<div class="alert alert-warning">Favor ingrese su usuario</div>';
        setTimeout(function () {
            usuario.value = '';
            usuario.focus();
        }, 1);
        return false;
    } else if (validartexto(formulario1.usuario.value) === false) {
        document.getElementById("alerta1").innerHTML = '<div class="alert alert-warning">Solo se permite texto</div>';
        setTimeout(function () {
            usuario.value = '';
            usuario.focus();
        }, 1);
        return false;
    } else {
        document.getElementById("alerta1").innerHTML = '';
    }

    if (formulario1.password.value === "") {
        document.getElementById("alerta1").innerHTML = '<div class="alert alert-warning">Favor ingrese su contraseña</div>';
        setTimeout(function () {
            password.value = '';
            password.focus();
        }, 1);
        return false;
    } else {
        document.getElementById("alerta1").innerHTML = '';
    }

//ENVIAR AL CONTROLADOR
    formulario1.submit();
}
function validarFormulario2() {
    var formulario = document.addForm1;
    //FUNCION PARA DESVANERCER EL ALERTA
    $(document).ready(function () {
        window.setTimeout(function () {
            $(".alert").fadeTo(1000, 0).slideUp(1000, function () {
                $(this).remove();
            });
        }, 2000);
    });
    //VALIDAR CAMPOS VACIOS
    if (formulario.contrasena.value === "" || validarespacio(formulario.contrasena.value) === false) {
        document.getElementById("alerta1").innerHTML = '<div class="alert alert-danger">Favor ingrese su contraseña anterior</div>';
        setTimeout(function () {
            contrasena.value = '';
            contrasena.focus();
        }, 1);
        return false;
    } else if (validarlongitudConAnt(formulario.contrasena.value) === false) {
        document.getElementById("alerta1").innerHTML = '<div class="alert alert-danger">Favor vuelva a ingresar su contraseña anterior</div>';
        setTimeout(function () {
            contrasena.value = '';
            contrasena.focus();
        }, 1);
        return false;
    } else if (validarnumero(formulario.contrasena.value) === false) {
        document.getElementById("alerta1").innerHTML = '<div class="alert alert-danger">Solo se permite números</div>';
        setTimeout(function () {
            contrasena.value = '';
            contrasena.focus();
        }, 1);
        return false;
    } else {
        document.getElementById("alerta1").innerHTML = '';
    }

    if (formulario.nuevopass.value === "" || validarespacio(formulario.nuevopass.value) === false) {
        document.getElementById("alerta1").innerHTML = '<div class="alert alert-danger">Favor ingrese su nueva contraseña</div>';
        setTimeout(function () {
            nuevopass.value = '';
            nuevopass.focus();
        }, 1);
        return false;
    } else if (validarlongitudConAct(formulario.nuevopass.value) === false) {
        document.getElementById("alerta1").innerHTML = '<div class="alert alert-warning">La contraseña no puede ser superior a 12 dígitos </div>';
        setTimeout(function () {
            nuevopass.value = '';
            confnuevopass.value = '';
            nuevopass.focus();
        }, 1);
        return false;
    } else {
        document.getElementById("alerta1").innerHTML = '';
    }

    if (formulario.confnuevopass.value === "" || validarespacio(formulario.confnuevopass.value) === false) {
        document.getElementById("alerta1").innerHTML = '<div class="alert alert-danger">Favor ingrese su contraseña nuevamente</div>';
        setTimeout(function () {
            nuevopass.value = '';
            confnuevopass.value = '';
            confnuevopass.focus();
        }, 1);
        return false;
    } else if (validarlongitudConAct(formulario.confnuevopass.value) === false) {
        document.getElementById("alerta1").innerHTML = '<div class="alert alert-warning">La contraseña no puede ser superior a 12 dígitos </div>';
        setTimeout(function () {
            confnuevopass.focus();
        }, 1);
        return false;
    } else {
        document.getElementById("alerta1").innerHTML = '';
    }

//VALIDACION DE CONTRASEÑAS
    if (formulario.nuevopass.value !== formulario.confnuevopass.value) {
        document.getElementById("alerta1").innerHTML = '<div class="alert alert-warning">Las contraseñas no coinciden</div>';
        nuevopass.value = '';
        confnuevopass.value = '';
        setTimeout(function () {
            nuevopass.focus();
        }, 1);
        return false;
    } else {
        document.getElementById("alerta1").innerHTML = '';
    }
//ENVIAR AL CONTROLADOR
    formulario.submit();
}


