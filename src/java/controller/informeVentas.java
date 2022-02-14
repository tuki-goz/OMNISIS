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
import model.InformeVentas;
import model.Variables;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "informeVentas", urlPatterns = {"/informeVentas"})
public class informeVentas extends HttpServlet {

    InformeVentas infv = new InformeVentas();
    InformeVentas infvbd = new InformeVentas();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        ArrayList<InformeVentas> informeVentas = new ArrayList();
        InformeVentas leer = new InformeVentas();
        informeVentas = leer.leerInformeVentasAc();
        informeVentas = leer.leerInformeVentasIna();

        if (accion.equals("Buscar Cliente y Fecha")) {    // APAGAR ESTA FUNCION PARA VOLVER A VERSION 1         
            Variables.gua = 1;
            String buscar = request.getParameter("buscartxt");
            String cliente = request.getParameter("txtparametro");
            String fechaini = request.getParameter("fechainitxt");
            String fechafin = request.getParameter("fechafintxt");
            int length = buscar.length();
            informeVentas = infv.buscarInformeVentasClienteyFecha(fechaini, fechafin, cliente);
            request.setAttribute("InformeVentasL", informeVentas);
            request.setAttribute("InformeVentas", infv);
            request.getRequestDispatcher("informeVentasClienteFecha.jsp").forward(request, response);

        }
        
         if (accion.equals("Buscar Solo Cliente")) {    // APAGAR ESTA FUNCION PARA VOLVER A VERSION 1         
            Variables.gua = 1;
            String buscar = request.getParameter("buscartxt");          
            String clie = request.getParameter("txtparametro");          
            int length = buscar.length();
            informeVentas = infv.buscarInformeVentasCliente(clie);
            request.setAttribute("InformeVentasL", informeVentas);
            request.setAttribute("InformeVentas", infv);
            request.getRequestDispatcher("informeVentasCliente.jsp").forward(request, response);

        }
         if (accion.equals("Buscar Solo Fecha")) {    // APAGAR ESTA FUNCION PARA VOLVER A VERSION 1         
            Variables.gua = 1;
            String buscar = request.getParameter("buscartxt");          
           
            String fechaini = request.getParameter("fechainitxt");
            String fechafin = request.getParameter("fechafintxt");         
            int length = buscar.length();
            informeVentas = infv.buscarInformeVentasFecha(fechaini, fechafin);
            request.setAttribute("InformeVentasL", informeVentas);
            request.setAttribute("InformeVentas", infv);
            request.getRequestDispatcher("informeVentasFecha.jsp").forward(request, response);

        }
         if (accion.equals("Buscar General")) {
            Variables.gua = 1;
            String buscar = request.getParameter("buscartxt");

            informeVentas = infv.buscarInformeVentasGeneral();
            request.setAttribute("InformeVentasL", informeVentas);
            request.setAttribute("InformeVentas", infv);
            request.getRequestDispatcher("informeVentas.jsp").forward(request, response);

        }

        if (accion.equals("Venta")) {
            Variables.sumarventa = 0.0;
            informeVentas = leer.leerInformeVentasAc();
            request.setAttribute("InformeVentasL", informeVentas);
            request.setAttribute("InformeVentas", infv);
            request.getRequestDispatcher("informeVentas.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            request.setAttribute("InformeVentas", infv);
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
