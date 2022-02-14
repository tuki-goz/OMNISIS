/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario01;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "usuario", urlPatterns = {"/usuario"})
public class usuario extends HttpServlet {

    Usuario01 usu = new Usuario01();
    Usuario01 usubd = new Usuario01();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Usuario01> usuario01 = new ArrayList();
        Usuario01 leer = new Usuario01();
        usuario01 = leer.leerUsuarioAc();
        usuario01 = leer.leerUsuarioIna();
        usuario01 = leer.leerUsuarioTo();
        Variables.mod = 0;
        Variables.gua = 0;

        if (accion.equals("Registrar")) {
            String nom = request.getParameter("nombretxt");
            String email = request.getParameter("emailtxt");
            String clave = request.getParameter("clavetxt");
            String estado = request.getParameter("customRadio");
            String usuar = Variables.usuarioConectado.getNombre_usuario();
            int per = Integer.valueOf(request.getParameter("drop_per"));
            int fun = Integer.valueOf(request.getParameter("drop_fun"));
            int length = nom.length();
            int length2 = email.length();
            int length3 = clave.length();
            if (length == 0 || length2 == 0 || length3 == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {
                usu.setNom_usu(nom);
                usu.setEmail_usu(email);
                usu.setClave_usu(clave);
                usu.setEstado_usu(estado);
                usu.setNom_usu_mod(usuar);
                usu.setId_per(per);
                usu.setId_fun(fun);
                r = usubd.registrarUsuario(usu);

                if (Variables.existe == 1) {
                    Variables.mod = 1;
                    request.setAttribute("Usuario01", usu);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                } else {
                    if (r == 1) {
                        request.getRequestDispatcher("usuarioguardado.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);

                    }
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            if (length == 0) {
                Variables.mensajeCampoVacio = 1;
                request.setAttribute("Usuario01L", usuario01);
                request.setAttribute("Usuario01", usu);
                request.getRequestDispatcher("usuarioActivo.jsp").forward(request, response);
            } else {
                Variables.mensajeCampoVacio = 0;
                usuario01 = usu.buscarUsuario01(buscar);
                if (usuario01 == null) {
                    limpiarcampos();
                    usuario01 = leer.leerUsuarioAc();
                }
                request.setAttribute("Usuario01L", usuario01);
                request.setAttribute("Usuario01", usu);
                request.getRequestDispatcher("usuarioActivo.jsp").forward(request, response);
            }
        }

        if (accion.equals("Buscar ")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            if (length == 0) {
                Variables.mensajeCampoVacio = 1;
                request.setAttribute("Usuario01L", usuario01);
                request.setAttribute("Usuario01", usu);
                request.getRequestDispatcher("usuarioInactivo.jsp").forward(request, response);
            } else {
                usuario01 = usu.buscarUsuario02(buscar);
                if (usuario01 == null) {
                    limpiarcampos();
                    usuario01 = leer.leerUsuarioIna();
                }
                request.setAttribute("Usuario01L", usuario01);
                request.setAttribute("Usuario01", usu);
                request.getRequestDispatcher("usuarioInactivo.jsp").forward(request, response);
            }
        }

//        if (accion.equals("Usuarios2")) {
//            String buscar = request.getParameter("buscartxt");
//            int length = buscar.length();
//            usuario01 = usu.buscarUsuario01(buscar);
//            request.setAttribute("Usuario01", usu);
//            request.getRequestDispatcher("usuarioActivo.jsp").forward(request, response);
//        }
        if (accion.equals("Modificar")) {
            String nom = request.getParameter("nombretxt");
            String email = request.getParameter("emailtxt");
            String clave = request.getParameter("clavetxt");
            String estado = request.getParameter("customRadio");
            String usuar = Variables.usuarioConectado.getNombre_usuario();
            int per = Integer.valueOf(request.getParameter("drop_per"));
            int fun = Integer.valueOf(request.getParameter("drop_fun"));
            int usuario = Integer.valueOf(request.getParameter("idtxt"));
            int length = nom.length();
            int length2 = email.length();
            int length3 = clave.length();
            if (length == 0 || length2 == 0 || length3 == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {
                usu.setNom_usu(nom);
                usu.setEmail_usu(email);
                usu.setClave_usu(clave);
                usu.setEstado_usu(estado);
                usu.setNom_usu_mod(usuar);
                usu.setId_per(per);
                usu.setId_fun(fun);
                usu.setId_usua(usuario);
                r = usubd.modificarUsuario(usu);
                if (r == 0) {
                    request.getRequestDispatcher("usuariomodificado.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Restablecer")) {
            String nom = request.getParameter("nombretxt");
            int length = nom.length();
            if (length == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {
                usu.setNom_usu(nom);
                r = usubd.restablecerUsuario(usu);
                if (r == 1) {
                    limpiarcampos();
                    limpiarVariables();
                    Variables.mensajeRegistrado = 2;
                    usuario01 = leer.leerUsuarioAc();
                    request.setAttribute("Usuario01L", usuario01);
                    request.setAttribute("Usuario01", usu);
                    request.getRequestDispatcher("usuarioActivo.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            String editar = request.getParameter("codigo2");
            int length2 = editar.length();
            usu = usu.editarUsuario01(editar);
            request.setAttribute("Usuario01", usu);
            request.getRequestDispatcher("usuario.jsp").forward(request, response);
        }

        if (accion.equals("Nuevo")) {
            limpiarcampos();
            Variables.mod = 1;
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            //usuario = p.buscarUsuario(buscar);
            // p = new Usuario(int id_usuario, String descripcion_usuario, String estado_usuario);
            usuario01 = new ArrayList();
            request.setAttribute("Usuario01L", usuario01);
            request.setAttribute("Usuario01", usu);
            request.getRequestDispatcher("usuario.jsp").forward(request, response);

        }

        if (accion.equals("Limpiar")) {
            String buscar = ("$'-");
            Variables.gua = 0;
            request.setAttribute("Usuario01L", usuario01);
            request.setAttribute("Usuario01", usu);
            request.getRequestDispatcher("usuario.jsp").forward(request, response);  //modificado usuario.jsp a usuarioActivo.jsp
        }

        if (accion.equals("Activo")) {
            usuario01 = leer.leerUsuarioAc();
            request.setAttribute("Usuario01L", usuario01);
            request.setAttribute("Usuario01", usu);
            request.getRequestDispatcher("usuarioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Usuarios")) {
            limpiarcampos();
            limpiarVariables();
            usuario01 = leer.leerUsuarioAc();
            request.setAttribute("Usuario01L", usuario01);
            request.setAttribute("Usuario01", usu);
            request.getRequestDispatcher("usuarioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            usuario01 = leer.leerUsuarioIna();
            request.setAttribute("Usuario01L", usuario01);
            request.setAttribute("Usuario01", usu);
            request.getRequestDispatcher("usuarioInactivo.jsp").forward(request, response);
        }
        if (accion.equals("Todos")) {
            usuario01 = leer.leerUsuarioTo();
            request.setAttribute("Usuario01L", usuario01);
            request.setAttribute("Usuario01", usu);
            request.getRequestDispatcher("usuarioTodo.jsp").forward(request, response);
        }
        if (accion.equals("Cambiar Activo")) {
            int id_p1 = Integer.valueOf(request.getParameter("codigo"));
            usu.setId_usua(id_p1);
            r = usubd.cambiarActivo(usu);
            usuario01 = leer.leerUsuarioIna();
            request.setAttribute("Usuario01L", usuario01);
            request.setAttribute("Usuario01", usu);
            request.getRequestDispatcher("usuarioInactivo.jsp").forward(request, response);
        }
        if (accion.equals("Cambiar Inactivo")) {
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            usu.setId_usua(codigo);
            r = usubd.cambiarInactivo(usu);
            usuario01 = leer.leerUsuarioAc();
            request.setAttribute("Usuario01L", usuario01);
            request.setAttribute("Usuario01", usu);
            request.getRequestDispatcher("usuarioActivo.jsp").forward(request, response);
        }
        if (accion.equals("Atras")) {
            request.setAttribute("Usuario01", usu);
            request.getRequestDispatcher("usuarioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Volver")) {
            usuario01 = leer.leerUsuarioAc();
            request.setAttribute("Usuario01L", usuario01);
            request.setAttribute("Usuario01", usu);
            request.getRequestDispatcher("usuarioActivo.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        usu.setNom_usu(variable);
        usu.setClave_usu(variable);
        usu.setEmail_usu(variable);
        usu.setDescr_per(variable);
        usu.setDescr_fun(variable);
        usu.setId_usua(id);
    }

    private void limpiarVariables() {
        Variables.mod = 0;
        Variables.mensajeRegistrado = 0;
        Variables.gua = 0;
        Variables.mensajeCampoVacio = 0;
        Variables.mensajeError = 0;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
