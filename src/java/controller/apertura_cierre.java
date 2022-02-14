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
import model.Apertura_Cierra;
import model.Caja;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "apertura_cierre", urlPatterns = {"/apertura_cierre"})
public class apertura_cierre extends HttpServlet {

    Apertura_Cierra aper_cie = new Apertura_Cierra();
    Apertura_Cierra aper_ciebd = new Apertura_Cierra();
    int r;

    Caja caja = new Caja();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Caja> cajaA = new ArrayList();
        Caja leer = new Caja();
        Variables.arq = 0;
        
        
        
        if (accion.equals("Grabar")) {
            Variables.caja_abierta = 1;
            Variables.ban=1;
            Variables.abierto = 1;
            Variables.arq = 0;
            int monto_ini = Integer.parseInt(request.getParameter("montoinitxt"));
            Variables.montoapertura = monto_ini;
            aper_cie.setMonto_apertura_aper_cie(monto_ini);
            aper_cie.setNom_usu_mod(Variables.usuarioConectado.getNombre_usuario());
            aper_cie.setId_usu(Variables.usuarioConectado.getId_usuario());
            aper_cie.setId_caja(Variables.id_caja);
            r = aper_ciebd.registrarApertura(aper_cie);
            if (r == 1) {
                cajaA = leer.leerCajaRe();
                request.setAttribute("Caja", caja);
                request.setAttribute("CajaL", cajaA);
                request.getRequestDispatcher("cajaRegistrada.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
            }
        }
        if (accion.equals("Atras")) {
            cajaA = leer.leerCajaRe();
            request.setAttribute("Caja", caja);
            request.setAttribute("CajaL", cajaA);
            request.getRequestDispatcher("cajaRegistrada.jsp").forward(request, response);
        }
        
        
        if (accion.equals("Grabar ")) {
            Variables.caja_abierta = 0;
            Variables.abierto = 0;
            Variables.arq = 3;
            
            int monto_cie = Integer.parseInt(request.getParameter("montocietxt"));
            Double monto_trans = Double.valueOf(request.getParameter("montocietxt"));  /////// AGREGADO PARA EL DETALLE DEL ARQUEO
            Double monto_tar = 0.0;
            Double monto_cheque = 0.0;
            aper_cie.setMonto_cierre_aper_cie(monto_cie);
            aper_cie.setMonto_trans(monto_trans);      /////// AGREGADO PARA EL DETALLE DEL ARQUEO
            aper_cie.setMonto_tar(monto_tar);          /////// AGREGADO PARA EL DETALLE DEL ARQUEO
            aper_cie.setMonto_cheq(monto_cheque);      /////// AGREGADO PARA EL DETALLE DEL ARQUEO          
            aper_cie.setId_caja(Variables.id_caja);
            r = aper_ciebd.registrarCierre(aper_cie);
            if (r == 1) {
                cajaA = leer.leerCajaRe();
                request.setAttribute("Caja", caja);
                request.setAttribute("CajaL", cajaA);
                request.getRequestDispatcher("cajaRegistrada.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
            }
        }
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
