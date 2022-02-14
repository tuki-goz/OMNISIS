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
import model.Variables;
import model.Servicio;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "servicio", urlPatterns = {"/servicio"})
public class servicio extends HttpServlet {

    Servicio ser = new Servicio();
    Servicio serbd = new Servicio();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        ArrayList<Servicio> servicio = new ArrayList();
        Servicio leer = new Servicio();
        servicio = leer.leerServicioAc();
        servicio = leer.leerServicioIna();
        Variables.mod = 0;
        Variables.gua = 0;

        if (accion.equals("Registrar")) {

            String numero_ser = request.getParameter("numerotxt");
            String descrip_ser = request.getParameter("descriptxt");
           // int tipo_ser = 1;
            Double precio_ser = Double.parseDouble(request.getParameter("preciotxt"));
        //    String iva_ser = request.getParameter("ivatxt");
            String fecha_ser = request.getParameter("fechasertxt");
            String estado_ser = request.getParameter("customRadio");
            int id_usu_ser = Variables.usuarioConectado.getId_usuario();
            String usu = Variables.usuarioConectado.getNombre_usuario();
            int id_contrato = Integer.valueOf(request.getParameter("drop_cont"));
        //    int id_impuesto = 1;
            String usu_carga = Variables.usuarioConectado.getNumero_usuario();
            String notas = request.getParameter("notastxt");
         //   int id_clie = Integer.parseInt(request.getParameter("drop_clie"));

            int length = numero_ser.length();
            int length2 = descrip_ser.length();

            int length4 = fecha_ser.length();
            int length5 = estado_ser.length();
            if (length == 0 || length2 == 0 || length4 == 0 || length5 == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {

                ser.setNumero_servicio_tecnico(numero_ser);
                ser.setDescripcion_servicio_tecnico(descrip_ser);
                //   ser.setId_tipo_servicio_tecnico(tipo_ser);
                ser.setPrecio_servicio_tecnico(precio_ser);
                //  ser.setIva_servicio_tecnico(iva_ser);
                ser.setFecha_servicio_tecnnico(fecha_ser);
                ser.setEstado_servicio_tecnico(estado_ser);
                ser.setId_usuario(id_usu_ser);
                ser.setNombre_usuario_modificacion(usu);
                ser.setId_contrato(id_contrato);
                //  ser.setId_impuesto(id_impuesto);
                ser.setUsuario_carga(usu_carga);
                ser.setNotas(notas);
                //    ser.setCliente_cont(clie_cont);

                r = serbd.registrarServicio(ser);
                if (r == 1) {
                    request.getRequestDispatcher("registradoServicios.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }
//        if (accion.equals("Buscar")) {
//            String buscar = request.getParameter("buscartxt");
//            int length = buscar.length();
//            ser = ser.buscarServicio(buscar);
//            request.setAttribute("Servicio", ser);
//            request.getRequestDispatcher("registrarservicio.jsp").forward(request, response);
//
//        }

//if (accion.equals("Servicio")) {
//            String buscar = request.getParameter("buscartxt");
//            int length = buscar.length();
//            ser = ser.buscarServicio(buscar);
//            request.setAttribute("Servicio", ser);
//            request.getRequestDispatcher("registrarservicio.jsp").forward(request, response);
//
//        }
        if (accion.equals("Buscar por descripcion")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            servicio = ser.buscarServicioDescrip(buscar);
            request.setAttribute("ServicioL", servicio);
            request.setAttribute("Servicio", ser);
            request.getRequestDispatcher("servicioActivo.jsp").forward(request, response);

        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            servicio = ser.buscarServicioCliente(buscar);
            request.setAttribute("ServicioL", servicio);
            request.setAttribute("Servicio", ser);
            request.getRequestDispatcher("servicioActivo.jsp").forward(request, response);

        }

        if (accion.equals("Servicio")) {
            servicio = leer.leerServicioAc();
            request.setAttribute("ServicioL", servicio);
            request.setAttribute("Servicio", ser);
            request.getRequestDispatcher("servicioActivo.jsp").forward(request, response);

        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            String editartxt = request.getParameter("codigo2");
            int length2 = editartxt.length();
            ser = ser.editarServicio(editartxt);
            request.setAttribute("Servicio", ser);
            request.getRequestDispatcher("registrarservicio.jsp").forward(request, response);
        }

        if (accion.equals("Nuevo")) {
            ser.setNumero_servicio_tecnico("");
            ser.setDescripcion_servicio_tecnico("");
            ser.setId_tipo_servicio_tecnico(1);
            ser.setPrecio_servicio_tecnico(15000);

            ser.setId_usuario(1);

            ser.setId_contrato(1);
            ser.setId_impuesto(1);
//                ser.setUsuario_carga(usu_carga);
            ser.setNotas("");
            ser.setCliente_cont("");
            ser.setId_servicio_tecnico(1);
            Variables.mod = 1;
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            servicio = new ArrayList();
            request.setAttribute("ServicioL", servicio);
            request.setAttribute("Servicio", ser);
            request.getRequestDispatcher("registrarservicio.jsp").forward(request, response);

        }

        if (accion.equals("Activo")) {
            servicio = leer.leerServicioAc();
            request.setAttribute("ServicioL", servicio);
            request.setAttribute("Servicio", ser);
            request.getRequestDispatcher("servicioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            servicio = leer.leerServicioIna();
            request.setAttribute("ServicioL", servicio);
            request.setAttribute("Servicio", ser);
            request.getRequestDispatcher("servicioInactivo.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Activo")) {
            int id_p1 = Integer.valueOf(request.getParameter("codigo"));
            ser.setId_servicio_tecnico(id_p1);
            r = serbd.cambiarActivo(ser);
            servicio = leer.leerServicioIna();
            request.setAttribute("ServicioL", servicio);
            request.setAttribute("Servicio", ser);
            request.getRequestDispatcher("servicioInactivo.jsp").forward(request, response);
        }
        if (accion.equals("Cambiar Inactivo")) {
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            ser.setId_servicio_tecnico(codigo);
            r = serbd.cambiarInactivo(ser);
            servicio = leer.leerServicioAc();
            request.setAttribute("ServicioL", servicio);
            request.setAttribute("Servicio", ser);
            request.getRequestDispatcher("servicioActivo.jsp").forward(request, response);
        }
        if (accion.equals("Atras")) {
            request.setAttribute("Servicio", ser);
            request.getRequestDispatcher("servicioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Volver")) {
            request.setAttribute("Servicio", ser);
            request.getRequestDispatcher("servicioActivo.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            String fecha_ser = request.getParameter("fechasertxt");
            String numero_ser = request.getParameter("numerotxt");
            String descrip_ser = request.getParameter("descriptxt");
            Double precio_ser = Double.parseDouble(request.getParameter("preciotxt"));
            String estado_ser = request.getParameter("customRadio");
            String usu = Variables.usuarioConectado.getNombre_usuario();
            String usu_carga = Variables.usuarioConectado.getNumero_usuario();
            int id_contrato = Integer.valueOf(request.getParameter("drop_cont"));
            int id_impuesto = 1;
//            String usu_carga = Variables.usuario1;
            String notas = request.getParameter("notastxt");
            String clie_cont = request.getParameter("drop_clie");
            int id_servicio = Integer.valueOf(request.getParameter("idtxt"));
//            int length = numero_ser.length();
//            int length2 = descrip_ser.length();
//            int length3 = iva_ser.length();
//            int length5 = estado_ser.length();
//            if (length == 0 || length2 == 0 || length3 == 0 || length5 == 0) {
//                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
//            } else {
            ser.setNumero_servicio_tecnico(numero_ser);
            ser.setDescripcion_servicio_tecnico(descrip_ser);
            ser.setPrecio_servicio_tecnico(precio_ser);
            ser.setEstado_servicio_tecnico(estado_ser);
            ser.setFecha_servicio_tecnnico(fecha_ser);
        //    ser.setId_usuario(id_usu_ser);
            ser.setNombre_usuario_modificacion(usu);
            ser.setId_contrato(id_contrato);
            ser.setUsuario_carga(usu_carga);
            ser.setNotas(notas);
            ser.setId_servicio_tecnico(id_servicio);
            r = serbd.modificarServicio(ser);
            if (r == 1) {
                request.getRequestDispatcher("registrarserviciomodificado.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
            }
//            }
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
