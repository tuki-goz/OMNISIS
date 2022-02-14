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
import model.InformeServicios;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "informeServicios", urlPatterns = {"/informeServicios"})
public class informeServicios extends HttpServlet {

    InformeServicios infc = new InformeServicios();
    InformeServicios infcbd = new InformeServicios();
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

        String accion = request.getParameter("accion");
        ArrayList<InformeServicios> informeServicios = new ArrayList();
        InformeServicios leer = new InformeServicios();
        informeServicios = leer.leerInformeServiciosAc();
        informeServicios = leer.leerInformeServiciosIna();

        if (accion.equals("Buscar Contrato y Fecha")) {
            informeServicios = leer.leerInformeServiciosAc();
            request.setAttribute("InformeServiciosL", informeServicios);
            request.setAttribute("InformeServicios", infc);
            request.getRequestDispatcher("informeServiciosContratoFecha.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar Solo Contrato")) {
            informeServicios = leer.leerInformeServiciosAc();
            request.setAttribute("InformeServiciosL", informeServicios);
            request.setAttribute("InformeServicios", infc);
            request.getRequestDispatcher("informeServiciosContrato.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar Solo Fecha")) {
            informeServicios = leer.leerInformeServiciosAc();
            request.setAttribute("InformeServiciosL", informeServicios);
            request.setAttribute("InformeServicios", infc);
            request.getRequestDispatcher("informeServiciosFecha.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar General")) {
            informeServicios = leer.leerInformeServiciosAc();
            request.setAttribute("InformeServiciosL", informeServicios);
            request.setAttribute("InformeServicios", infc);
            request.getRequestDispatcher("informeServicios.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            request.setAttribute("InformeServicios", infc);
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
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
