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
import model.InformePagos;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "informePagos", urlPatterns = {"/informePagos"})
public class informePagos extends HttpServlet {

    InformePagos infpag = new InformePagos();
    InformePagos infpagbd = new InformePagos();
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
        ArrayList<InformePagos> informePagos = new ArrayList();
        InformePagos leer = new InformePagos();
        informePagos = leer.leerInformePagosAc();
        informePagos = leer.leerInformePagosIna();
        
        if (accion.equals("Pagos")) {
           
            informePagos = leer.leerInformePagosAc();
            request.setAttribute("InformePagosL", informePagos);
            request.setAttribute("InformePagos", infpag);
            request.getRequestDispatcher("informePagos.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar General")) {  
            informePagos = leer.leerInformePagosAc();
            request.setAttribute("InformePagosL", informePagos);
            request.setAttribute("InformePagos", infpag);
            request.getRequestDispatcher("informePagos.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar Pago Pendiente")) {  
            informePagos = leer.leerInformePagosAc();
            request.setAttribute("InformePagosL", informePagos);
            request.setAttribute("InformePagos", infpag);
            request.getRequestDispatcher("informePagosProveedor.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar Solo Fecha")) {  
            informePagos = leer.leerInformePagosAc();
            request.setAttribute("InformePagosL", informePagos);
            request.setAttribute("InformePagos", infpag);
            request.getRequestDispatcher("informePagosFech.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            request.setAttribute("InformePagos", infpag);
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
