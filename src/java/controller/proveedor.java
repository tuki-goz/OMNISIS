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
import model.Ordencompra;
import model.Proveedor;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "proveedor", urlPatterns = {"/proveedor"})
public class proveedor extends HttpServlet {

    Proveedor prov = new Proveedor();
    Proveedor provbd = new Proveedor();
    int r;
    Ordencompra orden_com = new Ordencompra();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        ArrayList<Proveedor> proveedor = new ArrayList();
        ArrayList<Ordencompra> orden_compra = new ArrayList();
        Proveedor leer = new Proveedor();
        Variables.mod = 0;
        Variables.gua = 0;

        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String nom = request.getParameter("nombretxt");
            String proc = request.getParameter("proctxt");
            String ruc = request.getParameter("ructxt");
            String tel = request.getParameter("teltxt");
            String dir = request.getParameter("dirtxt");
            String estado = request.getParameter("customRadio");
            String usu = Variables.usuario1;
            int ciu = Integer.valueOf(request.getParameter("drop_ciu"));
            int length = nom.length();
            int length3 = ruc.length();
            int length4 = tel.length();
            int length5 = dir.length();
            if (length == 0 || length3 == 0 || length4 == 0 || length5 == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Proveedor", prov);
                request.getRequestDispatcher("proveedor.jsp").forward(request, response);
            } else {
                prov.setNom_prov(nom);
                prov.setProc_prov(proc);
                prov.setRuc_prov(ruc);
                prov.setTel_prov(tel);
                prov.setDir_prov(dir);
                prov.setEstado_prov(estado);
                prov.setNom_usu_mod(usu);
                prov.setId_ciu(ciu);
                r = provbd.registrarProveedor(prov);
                if (r == 1) {
                    proveedor = leer.leerProveedorAc();
                    request.setAttribute("ProveedorL", proveedor);
                    request.setAttribute("Proveedor", prov);
                    request.getRequestDispatcher("proveedorActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Proveedor", prov);
                    request.getRequestDispatcher("proveedor.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            if (length == 0) {
                Variables.mensajeCampoVacio = 1;
                proveedor = leer.leerProveedorAc();
                request.setAttribute("ProveedorL", proveedor);
                request.setAttribute("Proveedor", prov);
                request.getRequestDispatcher("proveedorActivo.jsp").forward(request, response);
            } else {
                Variables.mensajeCampoVacio = 0;
                proveedor = prov.buscarProveedor(buscar);
                if (proveedor == null) {
                    limpiarcampos();
                    proveedor = leer.leerProveedorAc();
                }
                request.setAttribute("ProveedorL", proveedor);
                request.setAttribute("Proveedor", prov);
                request.getRequestDispatcher("proveedorActivo.jsp").forward(request, response);
            }
        }
        if (accion.equals("Buscar ")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            if (length == 0) {
                Variables.mensajeCampoVacio = 1;
                proveedor = leer.leerProveedorIna();
                request.setAttribute("ProveedorL", proveedor);
                request.setAttribute("Proveedor", prov);
                request.getRequestDispatcher("proveedorInactivo.jsp").forward(request, response);
            } else {
                Variables.mensajeCampoVacio = 0;
                proveedor = prov.buscarProveedor(buscar);
                if (proveedor == null) {
                    limpiarcampos();
                    proveedor = leer.leerProveedorAc();
                }
                request.setAttribute("ProveedorL", proveedor);
                request.setAttribute("Proveedor", prov);
                request.getRequestDispatcher("proveedorActivo.jsp").forward(request, response);
            }
        }

        if (accion.equals("Proveedor")) {
            limpiarVariables();
            limpiarcampos();
            proveedor = leer.leerProveedorAc();
            request.setAttribute("ProveedorL", proveedor);
            request.setAttribute("Proveedor", prov);
            request.getRequestDispatcher("proveedorActivo.jsp").forward(request, response);

        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            prov = prov.editarProveedor(editartxt);
            request.setAttribute("Proveedor", prov);
            request.getRequestDispatcher("proveedor.jsp").forward(request, response);
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Proveedor", prov);
            request.getRequestDispatcher("proveedor.jsp").forward(request, response);

        }

        if (accion.equals("Inactivo")) {
            proveedor = leer.leerProveedorIna();
            request.setAttribute("ProveedorL", proveedor);
            request.setAttribute("Proveedor", prov);
            request.getRequestDispatcher("proveedorInactivo.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Activo")) {
            Variables.mensajeRegistrado = 3;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            prov.setId_prov(codigo);
            r = provbd.cambiarActivo(prov);
            proveedor = leer.leerProveedorAc();
            request.setAttribute("ProveedorL", proveedor);
            request.setAttribute("Proveedor", prov);
            request.getRequestDispatcher("proveedorActivo.jsp").forward(request, response);
        }
        if (accion.equals("Cambiar Inactivo")) {
            Variables.mensajeRegistrado = 4;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            prov.setId_prov(codigo);
            r = provbd.cambiarInactivo(prov);
            proveedor = leer.leerProveedorIna();
            request.setAttribute("ProveedorL", proveedor);
            request.setAttribute("Proveedor", prov);
            request.getRequestDispatcher("proveedorInactivo.jsp").forward(request, response);
        }
        if (accion.equals("Atras")) {
            limpiarVariables();
            limpiarcampos();
            proveedor = leer.leerProveedorAc();
            request.setAttribute("ProveedorL", proveedor);
            request.setAttribute("Proveedor", prov);
            request.getRequestDispatcher("proveedorActivo.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String nom = request.getParameter("nombretxt");
            String proc = request.getParameter("proctxt");
            String ruc = request.getParameter("ructxt");
            String tel = request.getParameter("teltxt");
            String dir = request.getParameter("dirtxt");
            String estado = request.getParameter("customRadio");
            String usu = Variables.usuarioConectado.getNombre_usuario();
            int id_ciu = Integer.valueOf(request.getParameter("drop_ciu"));
            int id_prov = Integer.valueOf(request.getParameter("idtxt"));
            int length = nom.length();
            int length2 = proc.length();
            int length3 = ruc.length();
            int length4 = tel.length();
            int length5 = dir.length();
            if (length == 0 || length2 == 0 || length3 == 0 || length4 == 0 || length5 == 0) {
                Variables.mod = 0;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 1;
                request.setAttribute("Proveedor", prov);
                request.getRequestDispatcher("proveedor.jsp").forward(request, response);
            } else {
                prov.setNom_prov(nom);
                prov.setProc_prov(proc);
                prov.setRuc_prov(ruc);
                prov.setTel_prov(tel);
                prov.setDir_prov(dir);
                prov.setEstado_prov(estado);
                prov.setNom_usu_mod(usu);
                prov.setId_ciu(id_ciu);
                prov.setId_prov(id_prov);
                r = provbd.modificarProveedor(prov);
                if (r == 1) {
                    proveedor = leer.leerProveedorAc();
                    request.setAttribute("ProveedorL", proveedor);
                    request.setAttribute("Proveedor", prov);
                    request.getRequestDispatcher("proveedorActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 0;
                    Variables.mensajeError = 1;
                    Variables.gua = 1;
                    request.setAttribute("Proveedor", prov);
                    request.getRequestDispatcher("proveedor.jsp").forward(request, response);
                }
            }
        }

        //************************ORDEN COMPRA************************************//
        if (accion.equals("ListaProv")) {
            int condicion = (Integer.valueOf(request.getParameter("checkbox")));
            Variables.id_tipo_pago = condicion;
            orden_com = new Ordencompra();
            orden_com.setId_cond(condicion);
            proveedor = leer.leerProveedorAc();
            request.setAttribute("ProveedorL", proveedor);
            request.setAttribute("Proveedor", prov);
            //request.setAttribute("ProductoL", producto);
            //request.setAttribute("Producto", pr);
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompraProveedor.jsp").forward(request, response);
        }

        if (accion.equals("Agregar")) {
            String agregarbuscar = request.getParameter("codigo2");
            prov = prov.añadirProveedor(agregarbuscar);
            request.setAttribute("Proveedor", prov);
            request.setAttribute("OrdenCompraL", Variables.getOrdencompras());
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompra.jsp").forward(request, response);
        }

        if (accion.equals("Atras2")) {
            request.setAttribute("OrdenCompraL", orden_compra);
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompra.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        prov.setNom_prov(variable);
        prov.setProc_prov(variable);
        prov.setRuc_prov(variable);
        prov.setTel_prov(variable);
        prov.setDir_prov(variable);
        prov.setEstado_prov(variable);
        prov.setId_ciu(id);
        prov.setId_prov(id);
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
