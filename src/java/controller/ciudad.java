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
import model.Ciudad;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "ciudad", urlPatterns = {"/ciudad"})
public class ciudad extends HttpServlet {

    Ciudad ciu = new Ciudad();
    Ciudad ciubd = new Ciudad();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Ciudad> ciudad = new ArrayList();
        Ciudad leer = new Ciudad();
        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String descrip = request.getParameter("descriptxt");
            int depar = Integer.valueOf(request.getParameter("drop_dep"));
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Ciudad", ciu);
                request.getRequestDispatcher("ciudad.jsp").forward(request, response);
            } else {
                ciu.setDescripcion_ciu(descrip);
                ciu.setEstado_ciu(estado);
                ciu.setId_dep(depar);
                r = ciubd.registrarCiudad(ciu);
                if (r == 1) {
                    ciudad = leer.leerCiudadAc();
                    request.setAttribute("CiudadL", ciudad);
                    request.setAttribute("Ciudad", ciu);
                    request.getRequestDispatcher("ciudadActiva.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Ciudad", ciu);
                    request.getRequestDispatcher("ciudad.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            ciudad = leer.leerCiudadAc();
            request.setAttribute("CiudadL", ciudad);
            request.setAttribute("Ciudad", ciu);
            request.getRequestDispatcher("ciudadActivo.jsp").forward(request, response);
        }

        if (accion.equals("Ciudad")) {
            limpiarVariables();
            limpiarcampos();
            ciudad = leer.leerCiudadAc();
            request.setAttribute("CiudadL", ciudad);
            request.setAttribute("Ciudad", ciu);
            request.getRequestDispatcher("ciudadActiva.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String descrip = request.getParameter("descriptxt");
            int depar = Integer.valueOf(request.getParameter("drop_dep"));
            int id_ciu = Integer.valueOf(request.getParameter("idtxt"));
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Ciudad", ciu);
                request.getRequestDispatcher("ciudad.jsp").forward(request, response);
            } else {
                ciu.setDescripcion_ciu(descrip);
                ciu.setEstado_ciu(estado);
                ciu.setId_dep(depar);
                ciu.setId_ciu(id_ciu);
                r = ciubd.modificarCiudad(ciu);
                if (r == 1) {
                    ciudad = leer.leerCiudadAc();
                    request.setAttribute("CiudadL", ciudad);
                    request.setAttribute("Ciudad", ciu);
                    request.getRequestDispatcher("ciudadActiva.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Ciudad", ciu);
                    request.getRequestDispatcher("ciudad.jsp").forward(request, response);
                }
            }
        }
        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Ciudad", ciu);
            request.getRequestDispatcher("ciudad.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            ciudad = leer.leerCiudadAc();
            request.setAttribute("CiudadL", ciudad);
            request.setAttribute("Ciudad", ciu);
            request.getRequestDispatcher("ciudadActiva.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            ciu = ciu.editarCiudad(editartxt);
            request.setAttribute("Ciudad", ciu);
            request.getRequestDispatcher("ciudad.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Inactivo")) {
            Variables.mensajeRegistrado = 4;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            ciu.setId_ciu(codigo);
            r = ciubd.cambiarInactivo(ciu);
            ciudad = leer.leerCiudadIna();
            request.setAttribute("CiudadL", ciudad);
            request.setAttribute("Ciudad", ciu);
            request.getRequestDispatcher("ciudadInactiva.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Activo")) {
            Variables.mensajeRegistrado = 3;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            ciu.setId_ciu(codigo);
            r = ciubd.cambiarInactivo(ciu);
            ciudad = leer.leerCiudadAc();
            request.setAttribute("CiudadL", ciudad);
            request.setAttribute("Ciudad", ciu);
            request.getRequestDispatcher("ciudadActiva.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            ciudad = leer.leerCiudadIna();
            request.setAttribute("CiudadL", ciudad);
            request.setAttribute("Ciudad", ciu);
            request.getRequestDispatcher("ciudadInactiva.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        ciu.setDescripcion_ciu(variable);
        ciu.setDesc_dep(variable);
        ciu.setEstado_ciu(variable);
        ciu.setId_ciu(id);
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
