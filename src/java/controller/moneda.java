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
import model.Moneda;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "moneda", urlPatterns = {"/moneda"})
public class moneda extends HttpServlet {

    Moneda mon = new Moneda();
    Moneda monbd = new Moneda();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Moneda> moneda = new ArrayList();
        Moneda leer = new Moneda();
        
        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String descrip = request.getParameter("descriptxt");
            int cotiCompra = Integer.valueOf(request.getParameter("cotiCompratxt"));
            int cotiVenta = Integer.valueOf(request.getParameter("cotiVentatxt"));
            String estado = request.getParameter("customRadio");
            String usu = Variables.usuario1;
            int length = descrip.length();
            if (length == 0 || cotiCompra == 0 || cotiVenta == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Moneda", mon);
                request.getRequestDispatcher("moneda.jsp").forward(request, response);
            } else {
                mon.setDesc_moneda(descrip);
                mon.setCoti_compra_actual_moneda(cotiCompra);
                mon.setCoti_venta_actual_moneda(cotiVenta);
                mon.setEstado_moneda(estado);
                mon.setNom_usu_mod(usu);
                r = monbd.registrarMoneda(mon);
                if (r == 1) {
                    moneda = leer.leerMonedaAc();
                    request.setAttribute("MonedaL", moneda);
                    request.setAttribute("Moneda", mon);
                    request.getRequestDispatcher("monedaActiva.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Moneda", mon);
                    request.getRequestDispatcher("moneda.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            moneda = mon.buscarMoneda(buscar);
            request.setAttribute("MonedaL", moneda);
            request.setAttribute("Moneda", mon);
            request.getRequestDispatcher("monedaActiva.jsp").forward(request, response);
        }

        if (accion.equals("Moneda")) {
            limpiarVariables();
            moneda = leer.leerMonedaAc();
            request.setAttribute("MonedaL", moneda);
            request.setAttribute("Moneda", mon);
            request.getRequestDispatcher("monedaActiva.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String descrip = request.getParameter("descriptxt");
            int cotiCompra = Integer.valueOf(request.getParameter("cotiCompratxt"));
            int cotiVenta = Integer.valueOf(request.getParameter("cotiVentatxt"));
            String estado = request.getParameter("customRadio");
            String usu = Variables.usuario1;
            int id_mon = Integer.valueOf(request.getParameter("idtxt"));
            int length = descrip.length();
            if (length == 0 || cotiCompra == 0 || cotiVenta == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Moneda", mon);
                request.getRequestDispatcher("moneda.jsp").forward(request, response);
            } else {
                mon.setDesc_moneda(descrip);
                mon.setCoti_compra_actual_moneda(cotiCompra);
                mon.setCoti_venta_actual_moneda(cotiVenta);
                mon.setEstado_moneda(estado);
                mon.setNom_usu_mod(usu);
                mon.setId_moneda(id_mon);
                r = monbd.modificarMoneda(mon);
                if (r == 1) {
                    moneda = leer.leerMonedaAc();
                    request.setAttribute("MonedaL", moneda);
                    request.setAttribute("Moneda", mon);
                    request.getRequestDispatcher("monedaActiva.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Moneda", mon);
                    request.getRequestDispatcher("moneda.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Moneda", mon);
            request.getRequestDispatcher("moneda.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            moneda = leer.leerMonedaAc();
            request.setAttribute("MonedaL", moneda);
            request.setAttribute("Moneda", mon);
            request.getRequestDispatcher("monedaActiva.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            mon = mon.editarMoneda(editartxt);
            request.setAttribute("Moneda", mon);
            request.getRequestDispatcher("moneda.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Inactivo")) {
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            mon.setId_moneda(codigo);
            r = monbd.cambiarInactivo(mon);
            moneda = leer.leerMonedaAc();
            request.setAttribute("MonedaL", moneda);
            request.setAttribute("Moneda", mon);
            request.getRequestDispatcher("monedaActiva.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        mon.setDesc_moneda(variable);
        mon.setEstado_moneda(variable);
        mon.setId_moneda(id);
        mon.setCoti_compra_actual_moneda(id);
        mon.setCoti_venta_actual_moneda(id);
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
