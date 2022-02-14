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
import model.InformeCompra;
import model.Variables;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "informeCompra", urlPatterns = {"/informeCompra"})
public class informeCompra extends HttpServlet {

    InformeCompra inf = new InformeCompra();
    InformeCompra infbd = new InformeCompra();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<InformeCompra> informeCompra = new ArrayList();
        InformeCompra leer = new InformeCompra();
        informeCompra = leer.leerInformeCompraAc();
        informeCompra = leer.leerInformeCompraIna();
        
        
        // ORIGINAL 
//         if (accion.equals("Buscar")) {      // ENCENDER ESTA FUNCION PARA VOLVER A VERSION 1
//            String buscar = request.getParameter("buscartxt");
//            String fechaini = request.getParameter("fechainitxt");
//            String fechafin = request.getParameter("fechafintxt");            
//            int length = buscar.length();
//            inf = inf.buscarInformeCompra(fechaini, buscar, fechafin);
//            request.setAttribute("InformeCompra", inf);
//            request.getRequestDispatcher("informeCompra.jsp").forward(request, response);
//
//        }
        if (accion.equals("Buscar")) {    // APAGAR ESTA FUNCION PARA VOLVER A VERSION 1          
                       
            Variables.gua = 1;
            String buscar = request.getParameter("buscartxt");
            String fechaini = request.getParameter("fechainitxt");
            String fechafin = request.getParameter("fechafintxt");
            int length = buscar.length();
            informeCompra = inf.buscarInformeCompraClienteyFecha(buscar, fechaini, fechafin);
            request.setAttribute("InformeCompraL", informeCompra);
            request.setAttribute("InformeCompra", inf);
            request.getRequestDispatcher("informeCompra.jsp").forward(request, response);

        }

        if (accion.equals("Compra")) {
            informeCompra = leer.leerInformeCompraAc();
            request.setAttribute("InformeCompraL", informeCompra);
            request.setAttribute("InformeCompra", inf);
            request.getRequestDispatcher("informeCompra.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar Proveedor y Fecha")) {
            String buscar = request.getParameter("buscartxt");
            String fechaini = request.getParameter("fechainitxt");
            String fechafin = request.getParameter("fechafintxt");
            int length = buscar.length();
            informeCompra = inf.buscarInformeCompraClienteyFecha(buscar, fechaini, fechafin);
            request.setAttribute("InformeCompraL", informeCompra);
            request.setAttribute("InformeCompra", inf);
            request.getRequestDispatcher("informeCompraProveedorFecha.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar Solo Fecha")) {
            String buscar = request.getParameter("buscartxt");
            String fechaini = request.getParameter("fechainitxt");
            String fechafin = request.getParameter("fechafintxt");
            int length = buscar.length();
            informeCompra = inf.buscarInformeCompraClienteyFecha(buscar, fechaini, fechafin);
            request.setAttribute("InformeCompraL", informeCompra);
            request.setAttribute("InformeCompra", inf);
            request.getRequestDispatcher("informeCompraFecha.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar General")) {
            String buscar = request.getParameter("buscartxt");
            String fechaini = request.getParameter("fechainitxt");
            String fechafin = request.getParameter("fechafintxt");
            int length = buscar.length();
            informeCompra = inf.buscarInformeCompraClienteyFecha(buscar, fechaini, fechafin);
            request.setAttribute("InformeCompraL", informeCompra);
            request.setAttribute("InformeCompra", inf);
            request.getRequestDispatcher("informeCompra.jsp").forward(request, response);
        }
        
        if (accion.equals("Buscar Solo Proveedor")) {
            String buscar = request.getParameter("buscartxt");
            String fechaini = request.getParameter("fechainitxt");
            String fechafin = request.getParameter("fechafintxt");
            int length = buscar.length();
            informeCompra = inf.buscarInformeCompraClienteyFecha(buscar, fechaini, fechafin);
            request.setAttribute("InformeCompraL", informeCompra);
            request.setAttribute("InformeCompra", inf);
            request.getRequestDispatcher("informeCompraProveedor.jsp").forward(request, response);
        }               

        if (accion.equals("Atras")) {
            request.setAttribute("InformeCompra", inf);
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
