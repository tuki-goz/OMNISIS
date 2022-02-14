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
import model.Tipo_pago;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "tipo_pago", urlPatterns = {"/tipo_pago"})
public class tipo_pago extends HttpServlet {

    Tipo_pago tp = new Tipo_pago();
    Tipo_pago tpbd = new Tipo_pago();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Tipo_pago> tipo_pago = new ArrayList();
        Tipo_pago leer = new Tipo_pago();
        
        
        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String descrip = request.getParameter("descriptxt");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Tipo de Pago", tp);
                request.getRequestDispatcher("tipo_de_pago.jsp").forward(request, response);
            } else {
                tp.setDescrip_tp(descrip);
                r = tpbd.registrarTipoPago(tp);
                if (r == 1) {
                    tipo_pago = leer.leerTipoPago();
                    request.setAttribute("TipoPagoL", tipo_pago);
                    request.setAttribute("Tipo de Pago", tp);
                    request.getRequestDispatcher("tipo_de_pagoRealizados.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Tipo de Pago", tp);
                    request.getRequestDispatcher("tipo_de_pago.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            tipo_pago = tp.buscarTipoPago(buscar);
            request.setAttribute("TipoPagoL", tipo_pago);
            request.setAttribute("Tipo de Pago", tp);
            request.getRequestDispatcher("tipo_de_pagoRealizados.jsp").forward(request, response);
        }

        if (accion.equals("Tipo de Pago")) {
            limpiarVariables();
            tipo_pago = leer.leerTipoPago();
            request.setAttribute("TipoPagoL", tipo_pago);
            request.setAttribute("Tipo de Pago", tp);
            request.getRequestDispatcher("tipo_de_pagoRealizados.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String descrip = request.getParameter("descriptxt");
            int id_tp = Integer.valueOf(request.getParameter("idtxt"));
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Tipo de Pago", tp);
                request.getRequestDispatcher("tipo_de_pago.jsp").forward(request, response);
            } else {
                tp.setDescrip_tp(descrip);
                tp.setId_tp(id_tp);
                r = tpbd.modificarTipoPago(tp);
                if (r == 1) {
                    tipo_pago = leer.leerTipoPago();
                    request.setAttribute("TipoPagoL", tipo_pago);
                    request.setAttribute("Tipo de Pago", tp);
                    request.getRequestDispatcher("tipo_de_pagoRealizados.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Tipo de Pago", tp);
                    request.getRequestDispatcher("tipo_de_pago.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Tipo de Pago", tp);
            request.getRequestDispatcher("tipo_de_pago.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            tipo_pago = leer.leerTipoPago();
            request.setAttribute("TipoPagoL", tipo_pago);
            request.setAttribute("Tipo de Pago", tp);
            request.getRequestDispatcher("tipo_de_pagoRealizados.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            tp = tp.editarTipoPago(editartxt);
            request.setAttribute("Tipo de Pago", tp);
            request.getRequestDispatcher("tipo_de_pago.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        tp.setDescrip_tp(variable);
        tp.setId_tp(id);
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
