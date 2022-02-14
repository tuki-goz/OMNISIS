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

import model.Perfil;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "perfil", urlPatterns = {"/perfil"})
public class perfil extends HttpServlet {

    Perfil per = new Perfil();
    Perfil perbd = new Perfil();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Perfil> perfil = new ArrayList();
        Perfil leer = new Perfil();

        if (accion.equals("Registrar")) {
            String descrip = request.getParameter("descriptxt");
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {
                per.setDescrip_perfil(descrip);
                per.setEstado_perfil(estado);
                
                r = perbd.registrarPerfil(per);
                if (r == 0) {
                    request.getRequestDispatcher("perfilguardado.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            Variables.gua = 1;
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            perfil = per.buscarPerfil(buscar);
            request.setAttribute("PerfilL", perfil);
            request.setAttribute("Perfil", per);
            request.getRequestDispatcher("perfilActivo.jsp").forward(request, response);
        }

        if (accion.equals("Perfil")) {
            limpiarVariables();
            limpiarcampos();
            perfil = leer.leerPerfilAc();
            request.setAttribute("PerfilL", perfil);
            request.setAttribute("Perfil", per);
            request.getRequestDispatcher("perfilActivo.jsp").forward(request, response);
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Perfil", per);
            request.getRequestDispatcher("perfil.jsp").forward(request, response);
        }

        if (accion.equals("Volver")) {
            limpiarVariables();
            perfil = leer.leerPerfilAc();
            request.setAttribute("PerfilL", perfil);
            request.setAttribute("Perfil", per);
            request.getRequestDispatcher("perfilActivo.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            per = per.editarPerfil(editartxt);
            request.setAttribute("Perfil", per);
            request.getRequestDispatcher("perfil.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mod = 1;
            Variables.mensajeCampoVacio = 1;
            Variables.gua = 0;
            String descrip = request.getParameter("descriptxt");
            String estado = request.getParameter("customRadio");            
            
            int id_per = Integer.valueOf(request.getParameter("idtxt"));
            int length = descrip.length();
            if (length == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {
                per.setDescrip_perfil(descrip);
                per.setEstado_perfil(estado);                
                per.setId_perfil(id_per);
                r = perbd.modificarPerfil(per);
                if (r == 0) {
                    request.getRequestDispatcher("perfilmodificado.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Cambiar Inactivo")) {
            Variables.mensajeRegistrado = 4;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            per.setId_perfil(codigo);
            r = perbd.cambiarInactivo(per);
            perfil = leer.leerPerfilIna();
            request.setAttribute("PerfilL", perfil);
            request.setAttribute("Perfil", per);
            request.getRequestDispatcher("perfilInactivo.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Activo")) {
            Variables.mensajeRegistrado = 3;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            per.setId_perfil(codigo);
            r = perbd.cambiarActivo(per);
            perfil = leer.leerPerfilAc();
            request.setAttribute("PerfilL", perfil);
            request.setAttribute("Perfil", per);
            request.getRequestDispatcher("perfilActivo.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            perfil = leer.leerPerfilIna();
            request.setAttribute("PerfilL", perfil);
            request.setAttribute("Perfil", per);
            request.getRequestDispatcher("perfilInactivo.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        per.setDescrip_perfil(variable);
        per.setEstado_perfil(variable);
        per.setId_perfil(id);
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
