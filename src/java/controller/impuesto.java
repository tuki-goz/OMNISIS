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
import model.Impuesto;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "impuesto", urlPatterns = {"/impuesto"})
public class impuesto extends HttpServlet {

    Impuesto im = new Impuesto();
    Impuesto imbd = new Impuesto();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Impuesto> impuesto = new ArrayList();
        Impuesto leer = new Impuesto();
        
        
        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            Double cifra1;
            String descrip = request.getParameter("descripimptxt");
            String cifra = request.getParameter("cifratxt");
            cifra1 = Double.parseDouble(cifra);
            String usumod = Variables.usuario1;
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Impuesto", im);
                request.getRequestDispatcher("impuesto.jsp").forward(request, response);
            } else {
                im.setDescripcion_impuesto(descrip);
                im.setCifra(cifra1);
                im.setNombre_usuario_modificacion(usumod);
                im.setEstado_im(estado);
                r = imbd.registrarImpuesto(im);
                if (r == 1) {
                    impuesto = leer.leerImpuestoAc();
                    request.setAttribute("ImpuestoL", impuesto);
                    request.setAttribute("Impuesto", im);
                    request.getRequestDispatcher("impuestoActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Impuesto", im);
                    request.getRequestDispatcher("impuesto.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            impuesto = im.buscarImpuesto(buscar);
            request.setAttribute("ImpuestoL", impuesto);
            request.setAttribute("Impuesto", im);
            request.getRequestDispatcher("impuestoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Impuesto")) {
            limpiarVariables();
            impuesto = leer.leerImpuestoAc();
            request.setAttribute("ImpuestoL", impuesto);
            request.setAttribute("Impuesto", im);
            request.getRequestDispatcher("impuestoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            Double cifra1;
            String descrip = request.getParameter("descripimptxt");
            String cifra = request.getParameter("cifratxt");
            cifra1 = Double.parseDouble(cifra);
            String usumod = Variables.usuario1;
            String estado = request.getParameter("customRadio");
            int id_im = Integer.valueOf(request.getParameter("idtxt"));
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Impuesto", im);
                request.getRequestDispatcher("impuesto.jsp").forward(request, response);
            } else {
                im.setDescripcion_impuesto(descrip);
                im.setCifra(cifra1);
                im.setNombre_usuario_modificacion(usumod);
                im.setId_impuesto(id_im);
                im.setEstado_im(estado);
                r = imbd.modificarImpuesto(im);
                if (r == 1) {
                    impuesto = leer.leerImpuestoAc();
                    request.setAttribute("ImpuestoL", impuesto);
                    request.setAttribute("Impuesto", im);
                    request.getRequestDispatcher("impuestoActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Impuesto", im);
                    request.getRequestDispatcher("impuesto.jsp").forward(request, response);
                }
            }
        }
        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Impuesto", im);
            request.getRequestDispatcher("impuesto.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            impuesto = leer.leerImpuestoAc();
            request.setAttribute("ImpuestoL", impuesto);
            request.setAttribute("Impuesto", im);
            request.getRequestDispatcher("impuestoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            im = im.editarImpuesto(editartxt); 
            request.setAttribute("Impuesto", im);
            request.getRequestDispatcher("impuesto.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Inactivo")) {
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            im.setId_impuesto(codigo);
            r = imbd.cambiarInactivo(im);
            impuesto = leer.leerImpuestoAc();
            request.setAttribute("ImpuestoL", impuesto);
            request.setAttribute("Impuesto", im);
            request.getRequestDispatcher("impuestoActivo.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        im.setDescripcion_impuesto(variable);
        im.setEstado_im(variable);
        im.setId_impuesto(id);
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
