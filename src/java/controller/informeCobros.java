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
import model.InformeCobros;
import model.Variables;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "informeCobros", urlPatterns = {"/informeCobros"})
public class informeCobros extends HttpServlet {

    InformeCobros infcob = new InformeCobros();
    InformeCobros infcobbd = new InformeCobros();
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
        ArrayList<InformeCobros> informeCobros = new ArrayList();
        InformeCobros leer = new InformeCobros();
        informeCobros = leer.leerInformeCobrosAc();
        informeCobros = leer.leerInformeCobrosIna();

        if (accion.equals("Cobros")) {
            informeCobros = leer.leerInformeCobrosAc();
            request.setAttribute("InformeCobrosL", informeCobros);
            request.setAttribute("InformeCobros", infcob);
            request.getRequestDispatcher("informeCobros.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            request.setAttribute("InformeCobros", infcob);
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (accion.equals("Pendientes")) {    // APAGAR ESTA FUNCION PARA VOLVER A VERSION 1  
            informeCobros = leer.leerInformeCobrosAc();
            request.setAttribute("InformeCobrosL", informeCobros);
            request.setAttribute("InformeCobros", infcob);
//            Variables.gua = 1;
//            String buscar = request.getParameter("buscartxt");          
//            String clie = request.getParameter("txtparametro");          
//            int length = buscar.length();
//            informeCobros = infcob.buscarInformeCobrosCliente(clie);
//            request.setAttribute("InformeCobrosL", informeCobros);
//            request.setAttribute("InformeCobros", infcob);
            request.getRequestDispatcher("informeCobrosCliente.jsp").forward(request, response);

        }

        if (accion.equals("Cliente y Fecha")) {    // APAGAR ESTA FUNCION PARA VOLVER A VERSION 1    
            informeCobros = leer.leerInformeCobrosAc();
            request.setAttribute("InformeCobrosL", informeCobros);
            request.setAttribute("InformeCobros", infcob);
//            Variables.gua = 1;
//            String buscar = request.getParameter("buscartxt");
//            String cliente = request.getParameter("txtparametro");
//            String fechaini = request.getParameter("fechainitxt");
//            String fechafin = request.getParameter("fechafintxt");
//            int length = buscar.length();
//            informeCobros = infcob.buscarInformeCobrosClienteyFecha(fechaini, fechafin, cliente);
//            request.setAttribute("InformeCobrosL", informeCobros);
//            request.setAttribute("InformeCobros", infcob);
            request.getRequestDispatcher("informeCobrosClienteFecha.jsp").forward(request, response);

        }

        if (accion.equals("Fecha")) {    // APAGAR ESTA FUNCION PARA VOLVER A VERSION 1  
            informeCobros = leer.leerInformeCobrosAc();
            request.setAttribute("InformeCobrosL", informeCobros);
            request.setAttribute("InformeCobros", infcob);
//            Variables.gua = 1;
//            String buscar = request.getParameter("buscartxt");          
//           
//            String fechaini = request.getParameter("fechainitxt");
//            String fechafin = request.getParameter("fechafintxt");         
//            int length = buscar.length();
//            informeCobros = infcob.buscarInformeCobrosFecha(fechaini, fechafin);
//            request.setAttribute("InformeCobrosL", informeCobros);
//            request.setAttribute("InformeCobros", infcob);
            request.getRequestDispatcher("informeCobrosFecha.jsp").forward(request, response);

        }
        if (accion.equals("General")) {
            informeCobros = leer.leerInformeCobrosAc();
            request.setAttribute("InformeCobrosL", informeCobros);
            request.setAttribute("InformeCobros", infcob);
//            Variables.gua = 1;
//            String buscar = request.getParameter("buscartxt");
//
//            informeCobros = infcob.buscarInformeCobrosGeneral();
//            request.setAttribute("InformeCobrosL", informeCobros);
//            request.setAttribute("InformeCobros", infcob);
            request.getRequestDispatcher("informeCobrosGeneral.jsp").forward(request, response);

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
