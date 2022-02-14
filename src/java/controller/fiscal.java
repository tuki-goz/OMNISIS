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
import model.Fiscal;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "fiscal", urlPatterns = {"/fiscal"})
public class fiscal extends HttpServlet {

    Fiscal fis = new Fiscal();
    Fiscal fisbd = new Fiscal();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Fiscal> fiscal = new ArrayList();
        Fiscal leer = new Fiscal();
        if (accion.equals("Fiscal")) {
            limpiarVariables();
            limpiarcampos();
            fiscal = leer.leerFiscal();
            request.setAttribute("FiscalL", fiscal);
            request.setAttribute("Fiscal", fis);
            request.getRequestDispatcher("fiscalRegistrado.jsp").forward(request, response);
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            if (length == 0) {
                Variables.mensajeCampoVacio = 1;
                fiscal = leer.leerFiscal();
                request.setAttribute("FiscalL", fiscal);
                request.setAttribute("Fiscal", fis);
                request.getRequestDispatcher("fiscalRegistrado.jsp").forward(request, response);
            } else {
                Variables.mensajeCampoVacio = 0;
                fiscal = fis.buscarFiscal(buscar);
                if (fiscal == null) {
                    limpiarcampos();
                    fiscal = leer.leerFiscal();
                }
                request.setAttribute("FiscalL", fiscal);
                request.setAttribute("Fiscal", fis);
                request.getRequestDispatcher("fiscalRegistrado.jsp").forward(request, response);
                limpiarVariables();
            }
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Fiscal", fis);
            request.getRequestDispatcher("fiscal.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            fis = fis.editarFiscal(editartxt);
            request.setAttribute("Fiscal", fis);
            request.getRequestDispatcher("fiscal.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            fiscal = leer.leerFiscal();
            request.setAttribute("FiscalL", fiscal);
            request.setAttribute("Fiscal", fis);
            request.getRequestDispatcher("fiscalRegistrado.jsp").forward(request, response);
        }

        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String descrip = request.getParameter("descriptxt");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Fiscal", fis);
                request.getRequestDispatcher("fiscal.jsp").forward(request, response);
            } else {
                fis.setDescrip_fis(descrip);
                r = fisbd.registrarFiscal(fis);
                if (Variables.existe == 1) {
                    Variables.mod = 1;
                    request.setAttribute("Fiscal", fis);
                    request.getRequestDispatcher("fiscal.jsp").forward(request, response);
                }
                if (r == 1) {
                    fiscal = leer.leerFiscal();
                    request.setAttribute("FiscalL", fiscal);
                    request.setAttribute("Fiscal", fis);
                    request.getRequestDispatcher("fiscalRegistrado.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Fiscal", fis);
                    request.getRequestDispatcher("fiscal.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String descrip = request.getParameter("descriptxt");
            int id_fis = Integer.valueOf(request.getParameter("idtxt"));
            int length1 = descrip.length();
            if (length1 == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Fiscal", fis);
                request.getRequestDispatcher("fiscal.jsp").forward(request, response);
            } else {
                fis.setDescrip_fis(descrip);
                fis.setId_fis(id_fis);
                r = fisbd.modificarFiscal(fis);
                if (r == 1) {
                    fiscal = leer.leerFiscal();
                    request.setAttribute("FiscalL", fiscal);
                    request.setAttribute("Fiscal", fis);
                    request.getRequestDispatcher("fiscalRegistrado.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Fiscal", fiscal);
                    request.getRequestDispatcher("fiscal.jsp").forward(request, response);
                }
            }
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        fis.setDescrip_fis(variable);
        fis.setId_fis(id);
    }

    private void limpiarVariables() {
        Variables.mod = 0;
        Variables.mensajeRegistrado = 0;
        Variables.gua = 0;
        Variables.mensajeCampoVacio = 0;
        Variables.mensajeError = 0;
        Variables.existe = 0;
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
