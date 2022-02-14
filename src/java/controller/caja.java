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
import model.Caja;
import model.Apertura_Cierra;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "caja", urlPatterns = {"/caja"})
public class caja extends HttpServlet {

    Caja caja = new Caja();
    Caja cajabd = new Caja();
    int r;
    Apertura_Cierra aper_cie = new Apertura_Cierra();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Caja> cajaA = new ArrayList();
        Caja leer = new Caja();
        if (accion.equals("Caja")) {//prueba
            limpiarVariables();
            limpiarcampos();
            cajaA = leer.leerCajaRe();
            request.setAttribute("CajaL", cajaA);
            request.setAttribute("Caja", caja);
            request.getRequestDispatcher("cajaRealizada.jsp").forward(request, response);
        }

        if (accion.equals("Buscar")) {
            Variables.gua = 1;
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            cajaA = caja.buscarCaja(buscar);
            request.setAttribute("CajaL", cajaA);
            request.setAttribute("Caja", caja);
            request.getRequestDispatcher("cajaRealizada.jsp").forward(request, response);
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Caja", caja);
            request.getRequestDispatcher("caja.jsp").forward(request, response);
        }

        if (accion.equals("Volver")) {
            limpiarVariables();
            cajaA = leer.leerCajaRe();
            request.setAttribute("CajaL", cajaA);
            request.setAttribute("Caja", caja);
            request.getRequestDispatcher("cajaRealizada.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            caja = caja.editarCaja(editartxt);
            request.setAttribute("Caja", caja);
            request.getRequestDispatcher("caja.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            cajaA = leer.leerCajaRe();
            request.setAttribute("CajaL", cajaA);
            request.setAttribute("Caja", caja);
            request.getRequestDispatcher("cajaRealizada.jsp").forward(request, response);
        }

        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String descrip = request.getParameter("descriptxt");
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Caja", caja);
                request.getRequestDispatcher("caja.jsp").forward(request, response);
            } else {
                caja.setDesc_caja(descrip);
                caja.setEstado_caja(estado);
                r = cajabd.registrarCaja(caja);
                if (r == 1) {
                    cajaA = leer.leerCajaRe();
                    request.setAttribute("CajaL", cajaA);
                    request.setAttribute("Caja", caja);
                    request.getRequestDispatcher("cajaRealizada.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Caja", caja);
                    request.getRequestDispatcher("caja.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String descrip = request.getParameter("descriptxt");
            String estado = request.getParameter("customRadio");
            int id_c = Integer.valueOf(request.getParameter("idtxt"));
            int length1 = descrip.length();
            if (length1 == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Caja", caja);
                request.getRequestDispatcher("caja.jsp").forward(request, response);
            } else {
                caja.setDesc_caja(descrip);
                caja.setEstado_caja(estado);
                caja.setId_caja(id_c);
                r = cajabd.modificarCaja(caja);
                if (r == 1) {
                    cajaA = leer.leerCajaRe();
                    request.setAttribute("CajaL", cajaA);
                    request.setAttribute("Caja", caja);
                    request.getRequestDispatcher("cajaRealizada.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Caja", caja);
                    request.getRequestDispatcher("caja.jsp").forward(request, response);
                }
            }
        }
////////////////////////////////////////////////////////////////////////////////
        if (accion.equals("Administrar Caja")) {
            Variables.arq = 0;
            cajaA = leer.leerCajaRe();
            request.setAttribute("Caja", caja);
            request.setAttribute("CajaL", cajaA);
            request.getRequestDispatcher("cajaRegistrada.jsp").forward(request, response);

        }

        if (accion.equals("Apertura")) {
            String buscar = request.getParameter("codigo");
            String descripcion = request.getParameter("descriptxt");
            int buscar01 = Integer.parseInt(request.getParameter("codigo"));
            Variables.id_caja = buscar01;
            Variables.nom_caja_abierta = descripcion;
            int length = buscar.length();
            aper_cie = aper_cie.buscarApertura(buscar);
            request.setAttribute("Apertura_Cierre", aper_cie);
            request.getRequestDispatcher("apertura.jsp").forward(request, response);
        }

        if (accion.equals("Cierre")) {
            if (Variables.ban == 1) {
                String estado = request.getParameter("estadotxt");
                Variables.estado_caja_abierta = estado;
            }
            String buscar = request.getParameter("codigo2");
            aper_cie = aper_cie.buscarApertura(buscar);
            request.setAttribute("Apertura_Cierre", aper_cie);
            request.getRequestDispatcher("cierre.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        caja.setDesc_caja(variable);
        caja.setEstado_caja(variable);
        caja.setId_caja(id);
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
