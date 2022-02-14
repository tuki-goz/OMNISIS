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
import model.Contrato;
import model.InformeImportaciones;
import model.Variables;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "informeImportaciones", urlPatterns = {"/informeImportaciones"})
public class informeImportaciones extends HttpServlet {

    InformeImportaciones infr = new InformeImportaciones();
    InformeImportaciones infrbd = new InformeImportaciones();
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
        ArrayList<InformeImportaciones> informeImportaciones = new ArrayList();
        InformeImportaciones leer = new InformeImportaciones();
        informeImportaciones = leer.leerInformeImportacionesAc();
        informeImportaciones = leer.leerInformeImportacionesIna();
        ArrayList<Contrato> contrato = new ArrayList();
        Contrato leer2 = new Contrato();

        Variables.mod = 0;
        Variables.gua = 0;

        if (accion.equals("Buscar Proveedor y Fecha")) {
            informeImportaciones = leer.leerInformeImportacionesAc();
            request.setAttribute("InformeImportacionesL", informeImportaciones);
            request.setAttribute("InformeImportaciones", infr);
            request.getRequestDispatcher("informeImportacionProveedorFecha.jsp").forward(request, response);
        }

        if (accion.equals("Buscar Proveedor")) {
            informeImportaciones = leer.leerInformeImportacionesAc();
            request.setAttribute("InformeImportacionesL", informeImportaciones);
            request.setAttribute("InformeImportaciones", infr);
            request.getRequestDispatcher("informeImportacionProveedor.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar Cliente y Fecha")) {
            informeImportaciones = leer.leerInformeImportacionesAc();
            request.setAttribute("InformeImportacionesL", informeImportaciones);
            request.setAttribute("InformeImportaciones", infr);
            request.getRequestDispatcher("informeImportacionClienteFecha.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar Cliente")) {
            informeImportaciones = leer.leerInformeImportacionesAc();
            request.setAttribute("InformeImportacionesL", informeImportaciones);
            request.setAttribute("InformeImportaciones", infr);
            request.getRequestDispatcher("informeImportacionCliente.jsp").forward(request, response);
        }       
        
        if (accion.equals("Buscar Solo Fecha")) {
            informeImportaciones = leer.leerInformeImportacionesAc();
            request.setAttribute("InformeImportacionesL", informeImportaciones);
            request.setAttribute("InformeImportaciones", infr);
            request.getRequestDispatcher("informeImportacionFecha.jsp").forward(request, response);
        }       
        
        if (accion.equals("Buscar General")) {
            informeImportaciones = leer.leerInformeImportacionesAc();
            request.setAttribute("InformeImportacionesL", informeImportaciones);
            request.setAttribute("InformeImportaciones", infr);
            request.getRequestDispatcher("informeImportacion.jsp").forward(request, response);
        }       

        if (accion.equals("Atras")) {
            request.setAttribute("InformeImportaciones", infr);
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
