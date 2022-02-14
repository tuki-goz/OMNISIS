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
import model.Condicion;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "forma_cobro", urlPatterns = {"/forma_cobro"})
public class forma_cobro extends HttpServlet {

    Condicion fc = new Condicion();
    Condicion fcbd = new Condicion();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Condicion> condicion = new ArrayList();
        Condicion leer = new Condicion();
        
        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String descrip = request.getParameter("descriptxt");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Condicion", fc);
                request.getRequestDispatcher("condicion.jsp").forward(request, response);
            } else {
                fc.setDescrip_condicion(descrip);
                r = fcbd.registrarCondicion(fc);
                if (r == 1) {
                    condicion = leer.leerCondicion();
                    request.setAttribute("CondicionL", condicion);
                    request.setAttribute("Condicion", fc);
                    request.getRequestDispatcher("condicionRealizados.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Condicion", fc);
                    request.getRequestDispatcher("condicion.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            condicion = fc.buscarCondicion(buscar);
            request.setAttribute("CondicionL", condicion);
            request.setAttribute("Condicion", fc);
            request.getRequestDispatcher("condicionRealizados.jsp").forward(request, response);
        }

        if (accion.equals("Condicion de Pago")) {
            limpiarVariables();
            condicion = leer.leerCondicion();
            request.setAttribute("CondicionL", condicion);
            request.setAttribute("Condicion", fc);
            request.getRequestDispatcher("condicionRealizados.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String descrip = request.getParameter("descriptxt");
            int id_fc = Integer.valueOf(request.getParameter("idtxt"));
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Condicion", fc);
                request.getRequestDispatcher("condicion.jsp").forward(request, response);
            } else {
                fc.setDescrip_condicion(descrip);
                fc.setId_condicion(id_fc);
                r = fcbd.modificarCondicion(fc);
                if (r == 1) {
                    condicion = leer.leerCondicion();
                    request.setAttribute("CondicionL", condicion);
                    request.setAttribute("Condicion", fc);
                    request.getRequestDispatcher("condicionRealizados.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Condicion", fc);
                    request.getRequestDispatcher("condicion.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Condicion", fc);
            request.getRequestDispatcher("condicion.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            condicion = leer.leerCondicion();
            request.setAttribute("CondicionL", condicion);
            request.setAttribute("Condicion", fc);
            request.getRequestDispatcher("condicionRealizados.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            fc = fc.editarCondicion(editartxt);
            request.setAttribute("Condicion", fc);
            request.getRequestDispatcher("condicion.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        fc.setDescrip_condicion(variable);
        fc.setId_condicion(id);
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
