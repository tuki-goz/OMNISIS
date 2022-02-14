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
import model.InformeContratos;
import model.Variables;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "informeContratos", urlPatterns = {"/informeContratos"})
public class informeContratos extends HttpServlet {

    InformeContratos infc = new InformeContratos();
    InformeContratos infcbd = new InformeContratos();
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
        ArrayList<InformeContratos> informeContratos = new ArrayList();
        InformeContratos leer = new InformeContratos();
        informeContratos = leer.leerInformeContratosAc();
        informeContratos = leer.leerInformeContratosIna();

        if (accion.equals("Buscar Solo Cliente")) { 
            Variables.gua = 1;
            String buscar = request.getParameter("buscartxt");
            String cliente = request.getParameter("txtparametro");
            int length = buscar.length();
            informeContratos = infc.buscarContrato(cliente);
            request.setAttribute("InformeContratosL", informeContratos);
            request.setAttribute("InformeContratos", infc);
            request.getRequestDispatcher("informeContratosCliente.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar Solo Fecha")) { 
            Variables.gua = 1;
            String buscar = request.getParameter("buscartxt");
            String cliente = request.getParameter("txtparametro");
            int length = buscar.length();
            informeContratos = infc.buscarContrato(cliente);
            request.setAttribute("InformeContratosL", informeContratos);
            request.setAttribute("InformeContratos", infc);
            request.getRequestDispatcher("informeContratosFecha.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar Cliente y Fecha")) { 
            Variables.gua = 1;
            String buscar = request.getParameter("buscartxt");
            String cliente = request.getParameter("txtparametro");
            String inifecha = request.getParameter("fechainitxt");
            String finfecha = request.getParameter("fechafintxt");
            int length = buscar.length();
            informeContratos = infc.buscarContratoClienteFecha(cliente, inifecha, finfecha);
            request.setAttribute("InformeContratosL", informeContratos);
            request.setAttribute("InformeContratos", infc);
            request.getRequestDispatcher("informeContratosClienteFecha.jsp").forward(request, response);

        }
        
        if (accion.equals("Buscar General")) {           
            informeContratos = leer.leerInformeContratosAc();
            request.setAttribute("InformeContratosL", informeContratos);
            request.setAttribute("InformeContratos", infc);
            request.getRequestDispatcher("informeContratos.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            request.setAttribute("InformeContratos", infc);
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
