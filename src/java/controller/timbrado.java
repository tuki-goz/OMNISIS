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
import model.Timbrado;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "timbrado", urlPatterns = {"/timbrado"})
public class timbrado extends HttpServlet {

    Timbrado tim = new Timbrado();
    Timbrado timbd = new Timbrado();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Timbrado> timbrado = new ArrayList();
        Timbrado leer = new Timbrado();

        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String nro_tim = request.getParameter("nrotxt");
            String ini_tim = request.getParameter("fechainitxt");
            String fin_tim = request.getParameter("fechafintxt");
            String ultimo_tim = request.getParameter("ultxt");
            String estado = request.getParameter("customRadio");
            int length = nro_tim.length();
            int length1 = ultimo_tim.length();
            if (length == 0 || length1 == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Timbrado", tim);
                request.getRequestDispatcher("timbrado.jsp").forward(request, response);
            } else {
                tim.setNro_tim(nro_tim);
                tim.setIni_vigen_tim(ini_tim);
                tim.setFin_vigen_tim(fin_tim);
                tim.setUltimo_nro_tim(ultimo_tim);
                tim.setEstado_tim(estado);
                r = timbd.registrarTimbrado(tim);
                if (r == 1) {
                    timbrado = leer.leerTimbradoAc();
                    request.setAttribute("TimbradoL", timbrado);
                    request.setAttribute("Timbrado", tim);
                    request.getRequestDispatcher("timbradoActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Timbrado", tim);
                    request.getRequestDispatcher("timbrado.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            Variables.gua = 1;
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            timbrado = tim.buscarTimbrado(buscar);
            request.setAttribute("TimbradoL", timbrado);
            request.setAttribute("Timbrado", tim);
            request.getRequestDispatcher("timbradoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Timbrado")) {
            limpiarVariables();
            limpiarcampos();
            timbrado = leer.leerTimbradoAc();
            request.setAttribute("TimbradoL", timbrado);
            request.setAttribute("Timbrado", tim);
            request.getRequestDispatcher("timbradoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String nro_tim = request.getParameter("nrotxt");
            String ini_tim = request.getParameter("fechainitxt");
            String fin_tim = request.getParameter("fechafintxt");
            String ultimo_tim = request.getParameter("ultxt");
            String estado = request.getParameter("customRadio");
            int id_t = Integer.valueOf(request.getParameter("idtxt"));
            int length = nro_tim.length();
            int length1 = ultimo_tim.length();
            if (length == 0 || length1 == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Timbrado", tim);
                request.getRequestDispatcher("timbrado.jsp").forward(request, response);
            } else {
                tim.setNro_tim(nro_tim);
                tim.setIni_vigen_tim(ini_tim);
                tim.setFin_vigen_tim(fin_tim);
                tim.setUltimo_nro_tim(ultimo_tim);
                tim.setEstado_tim(estado);
                tim.setId_tim(id_t);
                r = timbd.modificarTimbrado(tim);
                if (r == 1) {
                    timbrado = leer.leerTimbradoAc();
                    request.setAttribute("TimbradoL", timbrado);
                    request.setAttribute("Timbrado", tim);
                    request.getRequestDispatcher("timbradoActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Timbrado", tim);
                    request.getRequestDispatcher("timbrado.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Timbrado", tim);
            request.getRequestDispatcher("timbrado.jsp").forward(request, response);
        }

        if (accion.equals("Volver")) {
            limpiarVariables();
            timbrado = leer.leerTimbradoAc();
            request.setAttribute("TimbradoL", timbrado);
            request.setAttribute("Timbrado", tim);
            request.getRequestDispatcher("timbradoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            tim = tim.editarTimbrado(editartxt);
            request.setAttribute("Timbrado", tim);
            request.getRequestDispatcher("timbrado.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Inactivo")) {
            Variables.mensajeRegistrado = 4;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            tim.setId_tim(codigo);
            r = timbd.cambiarInactivo(tim);
            timbrado = leer.leerTimbradoIna();
            request.setAttribute("TimbradoL", timbrado);
            request.setAttribute("Timbrado", tim);
            request.getRequestDispatcher("timbradoInactivo.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Activo")) {
            Variables.mensajeRegistrado = 3;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            tim.setId_tim(codigo);
            r = timbd.cambiarActivo(tim);
            timbrado = leer.leerTimbradoAc();
            request.setAttribute("TimbradoL", timbrado);
            request.setAttribute("Timbrado", tim);
            request.getRequestDispatcher("timbradoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            timbrado = leer.leerTimbradoIna();
            request.setAttribute("TimbradoL", timbrado);
            request.setAttribute("Timbrado", tim);
            request.getRequestDispatcher("timbradoInactivo.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        tim.setNro_tim(variable);
        tim.setEstado_tim(variable);
        tim.setIni_vigen_tim(variable);
        tim.setFin_vigen_tim(variable);
        tim.setUltimo_nro_tim(variable);
        tim.setId_tim(id);
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
