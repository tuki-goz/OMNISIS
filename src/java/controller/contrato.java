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
 * @author Alvaro
 */
@WebServlet(name = "contrato", urlPatterns = {"/contrato"})
public class contrato extends HttpServlet {

    Contrato cont = new Contrato();
    Contrato contbd = new Contrato();
    int r;
    Cliente clie = new Cliente();
    Venta ven = new Venta();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Contrato> contrato = new ArrayList();
        Contrato leer = new Contrato();
        contrato = leer.leerContratoAc();
        contrato = leer.leerContratoIna();
        ArrayList<Venta> venta = new ArrayList();
        ArrayList<Cliente> cliente = new ArrayList();
        Cliente leer1 = new Cliente();
        Variables.mod = 0;
        Variables.gua = 0;

        if (accion.equals("Registrar")) {

            String cliente_cont = request.getParameter("clientetxt");
            String fiscal_cont = ("fiscal");
            String codigo_cont = request.getParameter("codigocontratotxt");
            String validez_cont = request.getParameter("valideztxt");
            String fecha_inicio = request.getParameter("fechainiciotxt");
            String fecha_fin = request.getParameter("fechafin");
            String tipo_cont = ("tipocontrato");
            String estado_cont = request.getParameter("customRadio");
            String usu = Variables.usuarioConectado.getNombre_usuario();
            int clienteid = Integer.valueOf(request.getParameter("drop_clie"));
            int idtipocont = Integer.parseInt(request.getParameter("droptc_tc"));
            int idfiscal = Integer.parseInt(request.getParameter("drop_fiscal"));
            

            int length = cliente_cont.length();
//            int length2 = fiscal_cont.length();
            int length3 = codigo_cont.length();
            int length4 = validez_cont.length();
            int length5 = fecha_inicio.length();
            if (length == 0 ||  length3 == 0 || length4 == 0 || length5 == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {

                cont.setCliente_contrato(cliente_cont);
                cont.setFiscal_contrato(fiscal_cont);
                cont.setCodigo_contrato(codigo_cont);
                cont.setValidez_contrato(validez_cont);
                cont.setFecha_inicio(fecha_inicio);
                cont.setFecha_fin(fecha_fin);
                cont.setTipo_contrato(tipo_cont);
                cont.setEstado_contrato(estado_cont);
                cont.setNom_usu(usu);
                cont.setId_cliente(clienteid);
                cont.setId_tipo_contrato(idtipocont);
                cont.setId_fiscal(idfiscal);

                r = contbd.registrarContrato(cont);
                if (r == 1) {
                    request.getRequestDispatcher("registradoContrato.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }
        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            contrato = cont.buscarContrato(buscar);
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("Contrato", cont);
            request.getRequestDispatcher("contratoActivo.jsp").forward(request, response);

        }

        if (accion.equals("Contrato")) {
            contrato = leer.leerContratoAc();
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("Contrato", cont);
            request.getRequestDispatcher("contratoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            String editar = request.getParameter("codigo2");
            int length2 = editar.length();
            cont = cont.editarContrato(editar);
            request.setAttribute("Contrato", cont);
            request.getRequestDispatcher("contrato.jsp").forward(request, response);
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();

            contrato = new ArrayList();
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("Contrato", cont);
            request.getRequestDispatcher("contrato.jsp").forward(request, response);

        }

        if (accion.equals("Activo")) {
            contrato = leer.leerContratoAc();
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("Contrato", cont);
            request.getRequestDispatcher("contratoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            contrato = leer.leerContratoIna();
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("Contrato", cont);
            request.getRequestDispatcher("contratoInactivo.jsp").forward(request, response);
        }
        if (accion.equals("Todos")) {
            contrato = leer.leerContratoTo();
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("Contrato", cont);
            request.getRequestDispatcher("contratoTodo.jsp").forward(request, response);
        }
        if (accion.equals("Cambiar Activo")) {
            int id_c1 = Integer.valueOf(request.getParameter("idtxt2"));
            cont.setId_contrato(id_c1);
            r = contbd.cambiarActivo(cont);
            contrato = leer.leerContratoIna();
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("Contrato", cont);
            request.getRequestDispatcher("contratoInactivo.jsp").forward(request, response);
        }
        if (accion.equals("Cambiar Inactivo")) {
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            cont.setId_contrato(codigo);
            r = contbd.cambiarInactivo(cont);
            contrato = leer.leerContratoAc();
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("Contrato", cont);
            request.getRequestDispatcher("contratoActivo.jsp").forward(request, response);
        }
        if (accion.equals("Atras")) {
            contrato = leer.leerContratoAc();
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("Contrato", cont);
            request.getRequestDispatcher("contratoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            String cliente_cont = request.getParameter("clientetxt");
            String fiscal_cont = request.getParameter("fiscaltxt");
            String codigo_cont = request.getParameter("codigocontratotxt");
            String validez_cont = request.getParameter("valideztxt");
            String fecha_inicio = request.getParameter("fechainiciotxt");
            String fecha_fin = request.getParameter("fechafin");
            String tipo_cont = request.getParameter("tipocontratotxt");
            String estado_cont = request.getParameter("customRadio");
            String usu = Variables.usuarioConectado.getNombre_usuario();
            int clienteid = Integer.valueOf(request.getParameter("drop_clie"));
            int idtipocont = Integer.parseInt(request.getParameter("droptc_tc"));
            int idfiscal = Integer.parseInt(request.getParameter("drop_fiscal"));
            int id_cont = Integer.parseInt(request.getParameter("idtxt"));

            int length = cliente_cont.length();
//            int length2 = fiscal_cont.length();
            int length3 = codigo_cont.length();
            int length4 = validez_cont.length();
            int length5 = fecha_inicio.length();
            if (length == 0 ||  length3 == 0 || length4 == 0 || length5 == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {

                cont.setCliente_contrato(cliente_cont);
                cont.setFiscal_contrato(fiscal_cont);
                cont.setCodigo_contrato(codigo_cont);
                cont.setValidez_contrato(validez_cont);
                cont.setFecha_inicio(fecha_inicio);
                cont.setFecha_fin(fecha_fin);
                cont.setTipo_contrato(tipo_cont);
                cont.setEstado_contrato(estado_cont);
                cont.setNom_usu(usu);
                cont.setId_cliente(clienteid);
                cont.setId_tipo_contrato(idtipocont);
                cont.setId_fiscal(idfiscal);
                cont.setId_contrato(id_cont);
               

                r = contbd.modificarContrato(cont);
                if (r == 1) {
                    request.getRequestDispatcher("registradoContrato.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }

            }
        }
////////////////////////////////////////////////////////////////////////////////
        if (accion.equals("Agregar")) {
            String agregarbuscar = request.getParameter("codigo");
            contrato = leer.leerContrato1(agregarbuscar);
            //CAPTURAMOS LOS DATOS DEL CLIENTE CON EL METODO AÑADIR CLIENTE RESPECTO AL ID DEL CLIENTE
            clie = clie.añadirCliente(String.valueOf(Variables.id_cliente));
            request.setAttribute("Cliente", clie);
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("VentaL", Variables.getVentas());
            request.setAttribute("Venta", ven);
            request.getRequestDispatcher("nuevaVenta.jsp").forward(request, response);
        }

        if (accion.equals("Buscar Codigo")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            contrato = cont.buscarContratoCodigo(buscar);
            request.setAttribute("ContratoL", contrato);
            request.setAttribute("Contrato", cont);
            request.getRequestDispatcher("registrarVentaContrato.jsp").forward(request, response);
        }
        if (accion.equals("Volver")) {
            cliente = leer1.leerClienteAc();
            request.setAttribute("Cliente", clie);
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Venta", ven);
            request.getRequestDispatcher("registrarVentaCliente.jsp").forward(request, response);
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
