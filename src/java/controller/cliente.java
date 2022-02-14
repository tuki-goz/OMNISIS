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
import model.Cliente;
import model.Contrato;
import model.Variables;
import model.Venta;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "cliente", urlPatterns = {"/cliente"})
public class cliente extends HttpServlet {

    Cliente clie = new Cliente();
    Cliente cliebd = new Cliente();
    int r;
    Venta ven = new Venta();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Cliente> cliente = new ArrayList();
        Cliente leer = new Cliente();
        cliente = leer.leerClienteAc();
        cliente = leer.leerClienteIna();
        ArrayList<Contrato> contrato = new ArrayList();
        Contrato leer2 = new Contrato();

        Variables.mod = 0;
        Variables.gua = 0;

        ArrayList<Venta> venta = new ArrayList();

        if (accion.equals("Registrar")) {
            String desc = request.getParameter("descriptxt");
            String nroDoc = request.getParameter("nroDoctxt");
            String tel = request.getParameter("teltxt");
            String email = request.getParameter("emailtxt");
            String dir = request.getParameter("dirtxt");
            String estado = request.getParameter("customRadio");
            String usu = Variables.usuarioConectado.getNombre_usuario();
            int barrio = Integer.valueOf(request.getParameter("drop_bar"));
            int length = desc.length();
            int length2 = nroDoc.length();
            int length3 = email.length();
            int length4 = tel.length();
            int length5 = dir.length();

            if (length == 0 || length2 == 0 || length3 == 0 || length4 == 0 || length5 == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {
                clie.setDesc_clie(desc);
                clie.setNro_doc_clie(nroDoc);
                clie.setTel_clie(tel);
                clie.setEmail_clie(email);
                clie.setDir_clie(dir);
                clie.setEstado_clie(estado);
                clie.setNom_usu_mod(usu);
                clie.setId_bar(barrio);
                clie.setDir_clie(dir);
                r = cliebd.registrarCliente(clie);
                if (r == 1) {
                    request.getRequestDispatcher("registradoReferenciales.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }

//        if (accion.equals("Buscar")) {     //usar para version 1
//            String buscar = request.getParameter("buscartxt");
//            int length = buscar.length();
//            clie = clie.buscarCliente(buscar);
//            request.setAttribute("Cliente", clie);
//            request.getRequestDispatcher("cliente.jsp").forward(request, response);
//        }
        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            cliente = clie.buscarCliente(buscar);
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("clienteActivo.jsp").forward(request, response);

        }

        if (accion.equals("Cliente")) {
            cliente = leer.leerClienteAc();
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("clienteActivo.jsp").forward(request, response);

        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            String editartxt = request.getParameter("codigo2");
            int length2 = editartxt.length();
            clie = clie.editarCliente(editartxt);
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }

//        if (accion.equals("Cliente")) {    ///version 1
//            String buscar = request.getParameter("buscartxt");
//            int length = buscar.length();
//            clie = clie.buscarCliente(buscar);
//            request.setAttribute("Cliente", clie);
//            request.getRequestDispatcher("cliente.jsp").forward(request, response);
//        }
        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            //cliente = p.buscarCliente(buscar);
            // p = new Cliente(int id_cliente, String descripcion_cliente, String estado_cliente);
            cliente = new ArrayList();
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("cliente.jsp").forward(request, response);

        }

        if (accion.equals("Activo")) {
            cliente = leer.leerClienteAc();
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("clienteActivo.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            cliente = leer.leerClienteIna();
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("clienteInactivo.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Activo")) {
            int id_p1 = Integer.valueOf(request.getParameter("codigo"));
            clie.setId_clie(id_p1);
            r = cliebd.cambiarActivo(clie);
            cliente = leer.leerClienteIna();
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("clienteInactivo.jsp").forward(request, response);
        }
        if (accion.equals("Cambiar Inactivo")) {
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            clie.setId_clie(codigo);
            r = cliebd.cambiarInactivo(clie);
            cliente = leer.leerClienteAc();
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("clienteActivo.jsp").forward(request, response);
        }
        if (accion.equals("Atras")) {
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("clienteActivo.jsp").forward(request, response);
        }

        if (accion.equals("Volver")) {
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("clienteActivo.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            String desc = request.getParameter("descriptxt");
            String nroDoc = request.getParameter("nroDoctxt");
            String tel = request.getParameter("teltxt");
            String email = request.getParameter("emailtxt");
            String dir = request.getParameter("dirtxt");
            String estado = request.getParameter("customRadio");
            String usu = Variables.usuarioConectado.getNombre_usuario();
            int barrio = Integer.valueOf(request.getParameter("drop_bar"));
            int id_clie = Integer.valueOf(request.getParameter("idtxt"));
            int length = desc.length();
            int length2 = nroDoc.length();
            int length3 = email.length();
            int length4 = tel.length();
            int length5 = dir.length();
            if (length == 0 || length2 == 0 || length3 == 0 || length4 == 0 || length5 == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {
                clie.setDesc_clie(desc);
                clie.setNro_doc_clie(nroDoc);
                clie.setTel_clie(tel);
                clie.setEmail_clie(email);
                clie.setDir_clie(dir);
                clie.setEstado_clie(estado);
                clie.setNom_usu_mod(usu);
                clie.setId_bar(barrio);
                clie.setId_clie(id_clie);
                r = cliebd.modificarCliente(clie);
                if (r == 0) {
                    request.getRequestDispatcher("registradoReferenciales.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }
        //////////////////////////////// VENTA /////////////////////////////////
        if (accion.equals("Agregar")) {
            String agregarbuscar = request.getParameter("codigo2");
            int moneda = Integer.parseInt(request.getParameter("moneda"));
            int condicion = Integer.parseInt(request.getParameter("tp"));
            ven = new Venta();
            ven.setId_mon(moneda);
            ven.setId_tipo_pago(condicion);
            clie = clie.añadirCliente(agregarbuscar);
            request.setAttribute("Cliente", clie);
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            request.getRequestDispatcher("nuevaVenta.jsp").forward(request, response);
        }

        if (accion.equals("Buscar cliente")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            cliente = clie.buscarClienteVenta(buscar);
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            request.setAttribute("Venta", ven);
            request.getRequestDispatcher("registrarVentaCliente.jsp").forward(request, response);

        }
        if (accion.equals("Ver Contrato")) {
            String agregarbuscar = request.getParameter("codigo2");
            clie = clie.añadirCliente(agregarbuscar);
            contrato = leer2.leerContrato(agregarbuscar);
            request.setAttribute("Cliente", clie);
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            request.getRequestDispatcher("registrarVentaContrato.jsp").forward(request, response);
        }
        if (accion.equals("Volver ")) {
            ven = ven.buscarTimbrado();
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("nuevaVenta.jsp").forward(request, response);
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
