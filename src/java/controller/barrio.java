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
import model.Barrio;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "barrio", urlPatterns = {"/barrio"})
public class barrio extends HttpServlet {

    Barrio bar = new Barrio();
    Barrio barbd = new Barrio();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Barrio> barrio = new ArrayList();
        Barrio leer = new Barrio();
        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String descrip = request.getParameter("descriptxt");
            int ciudad = Integer.valueOf(request.getParameter("drop_ciu"));
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Barrio", bar);
                request.getRequestDispatcher("barrio.jsp").forward(request, response);
            } else {
                bar.setDescripcion_barrio(descrip);
                bar.setId_ciudad(ciudad);
                bar.setEstado_bar(estado);
                r = barbd.registrarBarrio(bar);
                if (r == 1) {
                    barrio = leer.leerBarrioAc();
                    request.setAttribute("BarrioL", barrio);
                    request.setAttribute("Barrio", bar);
                    request.getRequestDispatcher("barrioActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Barrio", bar);
                    request.getRequestDispatcher("barrio.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            barrio = bar.buscarBarrio(buscar);
            request.setAttribute("BarrioL", barrio);
            request.setAttribute("Barrio", bar);
            request.getRequestDispatcher("barrioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Barrio")) {
            limpiarVariables();
            barrio = leer.leerBarrioAc();
            request.setAttribute("BarrioL", barrio);
            request.setAttribute("Barrio", bar);
            request.getRequestDispatcher("barrioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String descrip = request.getParameter("descriptxt");
            int ciudad = Integer.valueOf(request.getParameter("drop_ciu"));
            int id_bar = Integer.valueOf(request.getParameter("idtxt"));
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Barrio", bar);
                request.getRequestDispatcher("barrio.jsp").forward(request, response);
            } else {
                bar.setDescripcion_barrio(descrip);
                bar.setId_ciudad(ciudad);
                bar.setEstado_bar(estado);
                bar.setId_barrio(id_bar);
                r = barbd.modificarBarrio(bar);
                if (r == 1) {
                    barrio = leer.leerBarrioAc();
                    request.setAttribute("BarrioL", barrio);
                    request.setAttribute("Barrio", bar);
                    request.getRequestDispatcher("barrioActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Barrio", bar);
                    request.getRequestDispatcher("barrio.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Barrio", bar);
            request.getRequestDispatcher("barrio.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            barrio = leer.leerBarrioAc();
            request.setAttribute("BarrioL", barrio);
            request.setAttribute("Barrio", bar);
            request.getRequestDispatcher("barrioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            bar = bar.editarBarrio(editartxt);
            request.setAttribute("Barrio", bar);
            request.getRequestDispatcher("barrio.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Inactivo")) {
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            bar.setId_barrio(codigo);
            r = barbd.cambiarInactivo(bar);
            barrio = leer.leerBarrioIna();
            request.setAttribute("BarrioL", barrio);
            request.setAttribute("Barrio", bar);
            request.getRequestDispatcher("barrioInactivo.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Activo")) {
            Variables.mensajeRegistrado = 3;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            bar.setId_barrio(codigo);
            r = barbd.cambiarInactivo(bar);
            barrio = leer.leerBarrioAc();
            request.setAttribute("BarrioL", barrio);
            request.setAttribute("Barrio", bar);
            request.getRequestDispatcher("barrioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            barrio = leer.leerBarrioIna();
            request.setAttribute("BarrioL", barrio);
            request.setAttribute("Barrio", bar);
            request.getRequestDispatcher("barrioInactivo.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        bar.setDescripcion_barrio(variable);
        bar.setDescripcion_ciudad(variable);
        bar.setEstado_bar(variable);
        bar.setId_barrio(id);
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
