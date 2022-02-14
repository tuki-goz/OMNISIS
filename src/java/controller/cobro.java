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
import model.Cobro;
import model.Variables;
import model.Venta;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "cobro", urlPatterns = {"/cobro"})
public class cobro extends HttpServlet {

    Cobro cob = new Cobro();
    Cobro cobbd = new Cobro();
    int r;
    Venta ven = new Venta();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        ArrayList<Venta> venta = new ArrayList();
        ArrayList<Cobro> cobro = new ArrayList();
        Venta leer = new Venta();
        
        if (accion.equals("Registrar")) {
            Variables.mensajeRegistradoCheque = 1;
            Variables.monto_cheque = Integer.parseInt(request.getParameter("montochequetxt"));
            Variables.num_cheque = request.getParameter("nrochequetxt");
            Variables.id_banco = Integer.valueOf(request.getParameter("drop_ban"));
            int buscar = (Variables.venta);
            cob = cob.buscarDatos(buscar);
            cobro = new ArrayList();
            request.setAttribute("CobroL", cobro);
            request.setAttribute("Cobro", cob);
            request.getRequestDispatcher("cobroRegistrar.jsp").forward(request, response);
        }
        
        if (accion.equals("Guardar")) {
            String fecha = request.getParameter("fechafactxt");
            String nrocob = ("1");
            String ctacob = request.getParameter("ctatxt");
            String nrofact = request.getParameter("nrofacttxt");
            String caja = request.getParameter("cajatxt");
//            int vent = Integer.valueOf(request.getParameter("idventxt"));
            int cta = Integer.valueOf(request.getParameter("idctacobtxt"));
            int fromac = Variables.fc;
            String usu = Variables.usuarioConectado.getNombre_usuario();
            String concept = request.getParameter("conceptxt");
            int monto = Integer.valueOf(request.getParameter("montotxt"));
            Variables.venta_diaria = Variables.venta_diaria + monto;
            int caja1 = 1;
            int tp = 1;

            int banco = 1;
            int monto_cheque = Variables.monto_cheque;
            String num_cheque = Variables.num_cheque;
            int length = fecha.length();
            int length2 = nrocob.length();
            int length3 = ctacob.length();
            int length4 = nrofact.length();

            if (length == 0 || length2 == 0 || length3 == 0 || length4 == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {
                cob.setFecha_cobro(fecha);
                cob.setNro_cobro(nrocob);
                cob.setNro_cta_cobrar(ctacob);
                cob.setNro_factura(nrofact);
                cob.setId_caja(caja1);
                cob.setId_fc(fromac);
                cob.setNom_usu_mod(usu);
                cob.setDescrip_cobro(concept);
                cob.setTotal_cobro(monto);
                // cob.setId_venta(vent);
                cob.setId_cta_cobrar(cta);
                cob.setId_banco(banco);
                cob.setMonto_cheque(monto_cheque);
                cob.setNro_cheque(num_cheque);
                cob.setId_tp(tp);

                r = cobbd.registrarCobro(cob);
                if (r == 1) {
                    request.getRequestDispatcher("registradoReferenciales.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int buscar1 = Integer.parseInt(buscar);
            int length = buscar.length();
            //    cobro = cob.buscarDatos(buscar);
            request.setAttribute("CobroL", cobro);
            request.setAttribute("Cobro", cob);
            request.getRequestDispatcher("cobroActivo.jsp").forward(request, response);

        }

        if (accion.equals("Cobro")) {
            limpiarCheque();
            limpiarVariables();
            venta = leer.leerVentaCobro();
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            request.getRequestDispatcher("cobroPendiente.jsp").forward(request, response);
        }

        if (accion.equals("Cobros Realizados")) {
            cobro = new ArrayList();
            request.setAttribute("CobroL", cobro);
            request.setAttribute("Cobro", cob);
            request.getRequestDispatcher("cobroRealizados.jsp").forward(request, response);
        }

        if (accion.equals("Nuevo")) {
            limpiarCheque();
            limpiarVariables();
            venta = leer.leerVentaCobro();
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            request.getRequestDispatcher("cobroPendiente.jsp").forward(request, response);
        }
        if (accion.equals("Cheque")) {
            int buscar = (Variables.venta);
            cob = cob.buscarDatos(buscar);
            request.setAttribute("CobroL", cobro);
            request.setAttribute("Cobro", cob);
            request.getRequestDispatcher("cheque.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            cob.setId_venta(Variables.venta);
            Variables.nro_cobro1 = Integer.parseInt(Variables.nro_cobro);
            //CUANDO SEA GUARDAR DEBE SUMARLE +1
            Variables.nro_cobro1 = Variables.nro_cobro1 + 1;
            int buscar = (Variables.venta);
            cob = cob.buscarDatos(buscar);
            cobro = new ArrayList();
            request.setAttribute("CobroL", cobro);
            request.setAttribute("Cobro", cob);
            request.getRequestDispatcher("cobroRegistrar.jsp").forward(request, response);
        }

        if (accion.equals("Volver")) {
            limpiarCheque();
            limpiarVariables();
            venta = leer.leerVentaCobro();
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            request.getRequestDispatcher("cobroPendiente.jsp").forward(request, response);
        }

    }

    private void limpiarCheque() {
        Variables.monto_cheque = 0;
        Variables.num_cheque = "";
        // Variables.id_banco = 0;
        Variables.mensajeRegistradoCheque = 0;
        Variables.fc = 0;
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
