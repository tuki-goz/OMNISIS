/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Compra;
import model.Cta_Pagar;
import model.Pago;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "pago", urlPatterns = {"/pago"})
public class pago extends HttpServlet {

    Pago pag = new Pago();
    Pago pagbd = new Pago();
    int r, s, t;
    Cta_Pagar cta_pag = new Cta_Pagar();
    Compra com = new Compra();
    Compra combd = new Compra();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Cta_Pagar> cuenta_pagar = new ArrayList();
        ArrayList<Pago> pago = new ArrayList();
        Cta_Pagar leer = new Cta_Pagar();
        Pago leer1 = new Pago();

        if (accion.equals("Pago")) {
            limpiarVariables();
            cuenta_pagar = leer.leerCta_PagarRe();
            request.setAttribute("Cta_PagarL", cuenta_pagar);
            request.setAttribute("Cta_Pagar", cta_pag);
            request.getRequestDispatcher("pagoPendiente.jsp").forward(request, response);
        }
        
        if (accion.equals("Pagos Realizados")) {
            limpiarVariables();
            pago = leer1.leerPagoRe();
            request.setAttribute("PagoL", pago);
            request.setAttribute("Pago", pag);
            request.getRequestDispatcher("pagoRealizado.jsp").forward(request, response);
        }

        if (accion.equals("Pagar")) {
            String editartxt = request.getParameter("codigo2");
            cta_pag = cta_pag.buscarPagar(editartxt);
            request.setAttribute("Pago", pag);
            request.setAttribute("Cta_Pagar", cta_pag);
            request.getRequestDispatcher("pago.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            cuenta_pagar = leer.leerCta_PagarRe();
            request.setAttribute("Cta_PagarL", cuenta_pagar);
            request.setAttribute("Cta_Pagar", cta_pag);
            request.getRequestDispatcher("pagoPendiente.jsp").forward(request, response);
        }

        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String num = request.getParameter("idctapagtxt");
            int idcta = Integer.parseInt(request.getParameter("idctapagtxt"));
            String descripcion = request.getParameter("descriptxt");
            String fecha = request.getParameter("fechapagtxt");
            int total = Integer.parseInt(request.getParameter("montotxt"));
            String usu = Variables.usuarioConectado.getNombre_usuario();
            int idcaja = Integer.valueOf(request.getParameter("idcajatxt"));
            int idcomp = Integer.valueOf(request.getParameter("idcomtxt"));
            int id_tipo = Variables.id_tipo_pago;
            String nroFac = request.getParameter("nrofacttxt");
            Variables.venta_diaria = Variables.venta_diaria + total;
            int length = nroFac.length();
            int length1 = descripcion.length();
            if (length == 0 || length1 == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Pago", pag);
                request.setAttribute("Cta_Pagar", cta_pag);
                request.getRequestDispatcher("pago.jsp").forward(request, response);
            } else {
                pag.setNro_pag(num);
                pag.setDescrip_pag(descripcion);
                pag.setFecha_pag(fecha);
                pag.setTotal_pago(total);
                pag.setNom_usu_mod(usu);
                pag.setId_cta_pag(idcta);
                pag.setId_caja(idcaja);
                pag.setId_tp(id_tipo);

                com.setId_com(idcomp);
                com.setNro_fac(nroFac);
                com.setFecha_com(fecha);
                com.setNom_usu_mod(usu);
                
                r = pagbd.registrarPago(pag);
                s = combd.actualizarCompra(com);
                if (r == 1 && s == 1) {
                    cuenta_pagar = leer.leerCta_PagarRe();
                    request.setAttribute("Cta_PagarL", cuenta_pagar);
                    request.setAttribute("Cta_Pagar", cta_pag);
                    request.getRequestDispatcher("pagoPendiente.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    cuenta_pagar = leer.leerCta_PagarRe();
                    request.setAttribute("Cta_PagarL", cuenta_pagar);
                    request.setAttribute("Cta_Pagar", cta_pag);
                    request.getRequestDispatcher("pagoPendiente.jsp").forward(request, response);
                }
            }
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        //  cta_pag.setDescripcion_cuenta_pagar(variable);
        cta_pag.setId_compra(0);
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
