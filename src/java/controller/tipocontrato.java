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

import model.TipoContrato;
import model.Variables;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "tipocontrato", urlPatterns = {"/tipocontrato"})
public class tipocontrato extends HttpServlet {

    TipoContrato tc = new TipoContrato();
    TipoContrato tcbd = new TipoContrato();
    int r;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ArrayList<TipoContrato> tipocontrato = new ArrayList();
        TipoContrato leer = new TipoContrato();

        String accion = request.getParameter("accion");

        if (accion.equals("Registrar")) {
            String descrip = request.getParameter("descriptxt");
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("TipoContrato", tc);
                request.getRequestDispatcher("tipoContrato.jsp").forward(request, response);
            } else {
                tc.setDescrip(descrip);
                tc.setEstado_tipo(estado);
                r = tcbd.registrarTipoContrato(tc);
                if (Variables.existe == 1) {
                    Variables.mod = 1;
                    request.setAttribute("TipoContrato", tc);
                    request.getRequestDispatcher("tipoContrato.jsp").forward(request, response);
                }
                if (r == 1) {
                    tipocontrato = leer.leerTipoContratoAc();
                    request.setAttribute("TipoContratoL", tipocontrato);
                    request.setAttribute("TipoContrato", tc);
                    request.getRequestDispatcher("tipoContratoActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("TipoContrato", tc);
                    request.getRequestDispatcher("tipoContrato.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            if (length == 0) {
                Variables.mensajeCampoVacio = 1;
                tipocontrato = leer.leerTipoContratoAc();
                request.setAttribute("TipoContratoL", tipocontrato);
                request.setAttribute("TipoContrato", tc);
                request.getRequestDispatcher("tipoContratoActivo.jsp").forward(request, response);
            } else {
                Variables.mensajeCampoVacio = 0;
                tipocontrato = tc.buscarTipoContrato(buscar);
                if (tipocontrato == null) {
                    limpiarcampos();
                    tipocontrato = leer.leerTipoContratoAc();
                }
                request.setAttribute("TipoContratoL", tipocontrato);
                request.setAttribute("TipoContrato", tc);
                request.getRequestDispatcher("tipoContratoActivo.jsp").forward(request, response);
                limpiarVariables();
            }
        }
        
        if (accion.equals("Buscar ")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            if (length == 0) {
                Variables.mensajeCampoVacio = 1;
                tipocontrato = leer.leerTipoContratoIna();
                request.setAttribute("TipoContratoL", tipocontrato);
                request.setAttribute("TipoContrato", tc);
                request.getRequestDispatcher("tipoContratoInactivo.jsp").forward(request, response);
            } else {
                Variables.mensajeCampoVacio = 0;
                tipocontrato = tc.buscarTipoContratoIna(buscar);
                if (tipocontrato == null) {
                    limpiarcampos();
                    tipocontrato = leer.leerTipoContratoIna();
                }
                request.setAttribute("TipoContratoL", tipocontrato);
                request.setAttribute("TipoContrato", tc);
                request.getRequestDispatcher("tipoContratoInactivo.jsp").forward(request, response);
                limpiarVariables();
            }
        }

        if (accion.equals("Tipo Contrato")) {
            limpiarVariables();
            limpiarcampos();
            tipocontrato = leer.leerTipoContratoAc();
            request.setAttribute("TipoContratoL", tipocontrato);
            request.setAttribute("TipoContrato", tc);
            request.getRequestDispatcher("tipoContratoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("TipoContrato", tc);
            request.getRequestDispatcher("tipoContrato.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            tipocontrato = leer.leerTipoContratoAc();
            request.setAttribute("TipoContratoL", tipocontrato);
            request.setAttribute("TipoContrato", tc);
            request.getRequestDispatcher("tipoContratoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            tc = tc.editarTipoContrato(editartxt);
            request.setAttribute("TipoContrato", tc);
            request.getRequestDispatcher("tipoContrato.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String descrip = request.getParameter("descriptxt");
            String estado = request.getParameter("customRadio");
            int id_tc = Integer.valueOf(request.getParameter("idtxt"));
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("TipoContrato", tc);
                request.getRequestDispatcher("tipoContrato.jsp").forward(request, response);
            } else {
                tc.setDescrip(descrip);
                tc.setEstado_tipo(estado);
                tc.setId_tipo_contrato(id_tc);
                r = tcbd.modificarTipoContrato(tc);
                if (r == 1) {
                    tipocontrato = leer.leerTipoContratoAc();
                    request.setAttribute("TipoContratoL", tipocontrato);
                    request.setAttribute("TipoContrato", tc);
                    request.getRequestDispatcher("tipoContratoActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("TipoContrato", tc);
                    request.getRequestDispatcher("tipoContrato.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Cambiar Inactivo")) {
            Variables.mensajeRegistrado = 4;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            tc.setId_tipo_contrato(codigo);
            r = tcbd.cambiarInactivo(tc);
            tipocontrato = leer.leerTipoContratoIna();
            request.setAttribute("TipoContratoL", tipocontrato);
            request.setAttribute("TipoContrato", tc);
            request.getRequestDispatcher("tipoContratoInactivo.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Activo")) {
            Variables.mensajeRegistrado = 3;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            tc.setId_tipo_contrato(codigo);
            r = tcbd.cambiarActivo(tc);
            tipocontrato = leer.leerTipoContratoAc();
            request.setAttribute("TipoContratoL", tipocontrato);
            request.setAttribute("TipoContrato", tc);
            request.getRequestDispatcher("tipoContratoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            tipocontrato = leer.leerTipoContratoIna();
            request.setAttribute("TipoContratoL", tipocontrato);
            request.setAttribute("TipoContrato", tc);
            request.getRequestDispatcher("tipoContratoInactivo.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        tc.setDescrip(variable);
        tc.setEstado_tipo(variable);
        tc.setId_tipo_contrato(id);
    }

    private void limpiarVariables() {
        Variables.mod = 0;
        Variables.mensajeRegistrado = 0;
        Variables.gua = 0;
        Variables.mensajeCampoVacio = 0;
        Variables.mensajeError = 0;
    }

// <editor-fold defaultctate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
