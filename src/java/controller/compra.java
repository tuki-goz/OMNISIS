/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Compra;
import model.Variables;
import model.UsuarioDAO;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "compra", urlPatterns = {"/compra"})
public class compra extends HttpServlet {

    Compra com = new Compra();
    Compra combd = new Compra();
    int r;
    boolean x;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Compra> compraDetalle = new ArrayList<Compra>();
        ArrayList<Compra> compra = new ArrayList<Compra>();
        Compra leer = new Compra();
        if (accion.equals("Buscar")) {

            String buscar = request.getParameter("buscartxt");
            int cod = Integer.valueOf(request.getParameter("buscartxt"));
//            com = com.buscarCompra(buscar);
//            compraDetalle = leer.leerDetalle(buscar);
//            request.setAttribute("Compra", com);
            request.setAttribute("CompraDet", compraDetalle);
            request.getRequestDispatcher("registrarcompra.jsp").forward(request, response);

        }
      
        if (accion.equals("Compra")) {            
            compra = leer.leerCompraRe();           
            request.setAttribute("CompraL", compra);
            request.setAttribute("Compra", com);         
            request.getRequestDispatcher("compraRealizada.jsp").forward(request, response);
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
