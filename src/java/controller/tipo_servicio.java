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
import model.Tiposervicio;
import model.Variables;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "tipo_servicio", urlPatterns = {"/tipo_servicio"})
public class tipo_servicio extends HttpServlet {

    Tiposervicio ts = new Tiposervicio();
    Tiposervicio tsbd = new Tiposervicio();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Tiposervicio> tipo_servicio = new ArrayList();
        Tiposervicio leer = new Tiposervicio();
        
        
        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String descrip = request.getParameter("descriptxt");
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Tipo de Servicio", ts);
                request.getRequestDispatcher("tipo_de_servicio.jsp").forward(request, response);
            } else {
                ts.setDescripcion_tipo_servicio_tecnico(descrip);
                ts.setEstado_tipo_servicio(estado);
                r = tsbd.registrarTiposervicio(ts);
                if (r == 1) {
                    tipo_servicio = leer.leerTipoServicioAc();
                    request.setAttribute("TipoServicioL", tipo_servicio);
                    request.setAttribute("Tipo de Servicio", ts);
                    request.getRequestDispatcher("tipo_de_servicioActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Tipo de Servicio", ts);
                    request.getRequestDispatcher("tipo_de_servicio.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            tipo_servicio = ts.buscarTipoServicio(buscar);
            request.setAttribute("TipoServicioL", tipo_servicio);
            request.setAttribute("Tipo de Servicio", ts);
            request.getRequestDispatcher("tipo_de_servicioActivo.jsp").forward(request, response);
        }
        if (accion.equals("Tipo de Servicio")) {
            limpiarVariables();
            tipo_servicio = leer.leerTipoServicioAc();
            request.setAttribute("TipoServicioL", tipo_servicio);
            request.setAttribute("Tipo de Servicio", ts);
            request.getRequestDispatcher("tipo_de_servicioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String descrip = request.getParameter("descriptxt");
            String estado = request.getParameter("customRadio");
            int id_ts = Integer.valueOf(request.getParameter("idtxt"));
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Tipo de Servicio", ts);
                request.getRequestDispatcher("tipo_de_servicio.jsp").forward(request, response);
            } else {
                ts.setDescripcion_tipo_servicio_tecnico(descrip);
                ts.setEstado_tipo_servicio(estado);
                ts.setId_tipo_servicio_tecnico(id_ts);
                r = tsbd.modificarTipoServicio(ts);
                if (r == 1) {
                    tipo_servicio = leer.leerTipoServicioAc();
                    request.setAttribute("TipoServicioL", tipo_servicio);
                    request.setAttribute("Tipo de Servicio", ts);
                    request.getRequestDispatcher("tipo_de_servicioActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Tipo de Servicio", ts);
                    request.getRequestDispatcher("tipo_de_servicio.jsp").forward(request, response);
                }
            }
        }
        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Tipo de Servicio", ts);
            request.getRequestDispatcher("tipo_de_servicio.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            tipo_servicio = leer.leerTipoServicioAc();
            request.setAttribute("TipoServicioL", tipo_servicio);
            request.setAttribute("Tipo de Servicio", ts);
            request.getRequestDispatcher("tipo_de_servicioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            ts = ts.editarTipoServicio(editartxt);
            request.setAttribute("Tipo de Servicio", ts);
            request.getRequestDispatcher("tipo_de_servicio.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Inactivo")) {
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            ts.setId_tipo_servicio_tecnico(codigo);
            r = tsbd.cambiarInactivo(ts);
            tipo_servicio = leer.leerTipoServicioAc();
            request.setAttribute("TipoServicioL", tipo_servicio);
            request.setAttribute("Tipo de Servicio", ts);
            request.getRequestDispatcher("tipo_de_servicioActivo.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        ts.setDescripcion_tipo_servicio_tecnico(variable);
        ts.setEstado_tipo_servicio(variable);
        ts.setId_tipo_servicio_tecnico(id);
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
