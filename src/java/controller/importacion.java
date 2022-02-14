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
import model.Importacion;
import model.Importacion;
import model.Variables;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "importacion", urlPatterns = {"/importacion"})
public class importacion extends HttpServlet {

    Importacion imp = new Importacion();
    Importacion impbd = new Importacion();
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

        ArrayList<Importacion> importacion = new ArrayList();
        Importacion leer = new Importacion();
        importacion = leer.leerImportacionAc();
        importacion = leer.leerImportacionIna();
        
        Variables.mod = 0;
        Variables.gua = 0;

        if (accion.equals("Registrar")) {

            String llamado = request.getParameter("llamadotxt");
            String fecha_imp = request.getParameter("fechatxt");
            Double fob = Double.parseDouble(request.getParameter("fobtxt"));
            Double flete = Double.parseDouble(request.getParameter("fletetxt"));
            Double despacho = Double.parseDouble(request.getParameter("despachotxt"));
            Double total = Double.parseDouble(request.getParameter("totaltxt"));
            String estado = request.getParameter("customRadio");
            String usu = Variables.usuarioConectado.getNombre_usuario();
            int id_prov = Integer.valueOf(request.getParameter("drop_prov"));
            int id_pais = Integer.valueOf(request.getParameter("drop_pais"));
            int id_cliente = Integer.valueOf(request.getParameter("drop_clie"));
            int id_importacion = Integer.valueOf(request.getParameter("idtxt"));

            int length = llamado.length();
            int length2 = fecha_imp.length();
            int length4 = estado.length();
            int length5 = usu.length();
            if (length == 0 || length2 == 0 || length4 == 0 || length5 == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {

                imp.setLlamado(llamado);
                imp.setFecha_imp(fecha_imp);
                imp.setMonto_fob(fob);
                imp.setMonto_flete(flete);
                imp.setMonto_despacho(despacho);
                imp.setMonto_total(total);
                imp.setGuia_imp(llamado);
                imp.setEstado_imp(estado);
                imp.setNom_usu(usu);
                imp.setId_proveedor(id_prov);
                imp.setId_pais(id_pais);
                imp.setId_cliente(id_cliente);

                r = impbd.registrarImportacion(imp);
                if (r == 1) {
                    request.getRequestDispatcher("registradoImportacions.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar por descripcion")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            importacion = imp.buscarImportacionDescrip(buscar);
            request.setAttribute("ImportacionL", importacion);
            request.setAttribute("Importacion", imp);
            request.getRequestDispatcher("importacionActivo.jsp").forward(request, response);

        }

        if (accion.equals("Buscar por Cliente")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            importacion = imp.buscarImportacionCliente(buscar);
            request.setAttribute("ImportacionL", importacion);
            request.setAttribute("Importacion", imp);
            request.getRequestDispatcher("importacionActivo.jsp").forward(request, response);

        }

        if (accion.equals("Importacion")) {
            limpiarcampos();
            importacion = leer.leerImportacionAc();
            request.setAttribute("ImportacionL", importacion);
            request.setAttribute("Importacion", imp);
            request.getRequestDispatcher("importacionActiva.jsp").forward(request, response);

        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            String editartxt = request.getParameter("codigo2");
            int length2 = editartxt.length();
            imp = imp.editarImportacion(editartxt);
            request.setAttribute("Importacion", imp);
            request.getRequestDispatcher("registrarimportacion.jsp").forward(request, response);
        }

        if (accion.equals("Nuevo")) {
            limpiarcampos();
            Variables.mod = 1;
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            importacion = new ArrayList();
            request.setAttribute("ImportacionL", importacion);
            request.setAttribute("Importacion", imp);
            request.getRequestDispatcher("importacion.jsp").forward(request, response);

        }

        if (accion.equals("Activo")) {
            importacion = leer.leerImportacionAc();
            request.setAttribute("ImportacionL", importacion);
            request.setAttribute("Importacion", imp);
            request.getRequestDispatcher("importacionActiva.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            importacion = leer.leerImportacionIna();
            request.setAttribute("ImportacionL", importacion);
            request.setAttribute("Importacion", imp);
            request.getRequestDispatcher("importacionInactiva.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Activo")) {
            int id_p1 = Integer.valueOf(request.getParameter("codigo"));
            imp.setId_importacion(id_p1);
            r = impbd.cambiarActivo(imp);
            importacion = leer.leerImportacionIna();
            request.setAttribute("ImportacionL", importacion);
            request.setAttribute("Importacion", imp);
            request.getRequestDispatcher("importacionInactiva.jsp").forward(request, response);
        }
        if (accion.equals("Cambiar Inactivo")) {
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            imp.setId_importacion(codigo);
            r = impbd.cambiarInactivo(imp);
            importacion = leer.leerImportacionAc();
            request.setAttribute("ImportacionL", importacion);
            request.setAttribute("Importacion", imp);
            request.getRequestDispatcher("importacionActiva.jsp").forward(request, response);
        }
        if (accion.equals("Atras")) {
            request.setAttribute("Importacion", imp);
            request.getRequestDispatcher("importacionActiva.jsp").forward(request, response);
        }

        if (accion.equals("Volver")) {
            limpiarcampos();
            importacion = leer.leerImportacionAc();
            request.setAttribute("ImportacionL", importacion);
            request.setAttribute("Importacion", imp);
            request.getRequestDispatcher("importacionActiva.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.gua = 1;
            String llamado = request.getParameter("numerotxt");
            String fecha_imp = request.getParameter("descriptxt");
            Double fob = Double.parseDouble(request.getParameter("preciotxt"));
            Double flete = Double.parseDouble(request.getParameter("preciotxt"));
            Double despacho = Double.parseDouble(request.getParameter("preciotxt"));
            Double total = Double.parseDouble(request.getParameter("preciotxt"));
            String estado = request.getParameter("numerotxt");
            String usu = Variables.usuarioConectado.getNombre_usuario();
            int id_prov = Integer.valueOf(request.getParameter("drop_prov"));
            int id_pais = Integer.valueOf(request.getParameter("drop_pais"));
            int id_cliente = Integer.valueOf(request.getParameter("drop_clie"));
            int id_importacion = Integer.valueOf(request.getParameter("drop_pais"));

            imp.setLlamado(llamado);
            imp.setFecha_imp(fecha_imp);
            imp.setMonto_fob(fob);
            imp.setMonto_flete(flete);
            imp.setMonto_despacho(despacho);
            imp.setMonto_total(total);
            imp.setEstado_imp(estado);
            imp.setNom_usu(usu);
            imp.setId_proveedor(id_prov);
            imp.setId_pais(id_pais);
            imp.setId_cliente(id_importacion);

            r = impbd.modificarImportacion(imp);
            if (r == 1) {
                request.getRequestDispatcher("registrarimportacionmodificado.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
            }

        }
    }

    private void limpiarcampos() {
        imp.setLlamado("");
        imp.setFecha_imp("");
        imp.setMonto_fob(0.0);
        imp.setMonto_flete(0.0);
        imp.setMonto_despacho(0.0);
        imp.setMonto_total(0.0);
        imp.setGuia_imp("");
        imp.setId_proveedor(0);
        imp.setNom_prov("");
        imp.setId_pais(0);
        imp.setDescrip_pais("");
        imp.setId_cliente(0);
        imp.setDescrip_clie("");

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
