/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Compra;
import model.Ordencompra;
import model.Producto;
import model.Variables;
import model.Venta;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "producto", urlPatterns = {"/producto"})
public class producto extends HttpServlet {

    Producto pr = new Producto();
    Producto prbd = new Producto();
    int r;
    int iva5;
    int iva10;
    int exenta;
    ///////////////////VENTA/////////////////////////
    Venta ven = new Venta();
    Cliente clie = new Cliente();
    ///////////////////ORDEN DE COMPRA/////////////////////////
    Ordencompra orden_com = new Ordencompra();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Producto> producto = new ArrayList();
        ArrayList<Ordencompra> orden_compra = new ArrayList();
        Producto leer = new Producto();
        Producto leer0 = new Producto();
        ArrayList<Venta> venta = new ArrayList();
        producto = leer.leerProductoAc();
        producto = leer.leerProductoIna();
        producto = leer.leerProductoTo();
        Variables.mod = 0;
        Variables.gua = 0;

        if (accion.equals("Registrar")) {
            String descrippr = request.getParameter("descriptxt");
            String estadopr = request.getParameter("customRadio");
            String usumod = Variables.usuarioConectado.getNombre_usuario();
            int precio_u = Integer.valueOf(request.getParameter("precioutxt"));
            int cantidad = 0;

            int impuesto = Integer.valueOf(request.getParameter("drop_imp"));
            int length = descrippr.length();
            if (length == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {
                pr.setDescripcion_producto(descrippr);
                pr.setEstado_producto(estadopr);
                pr.setNombre_usu_mod_producto(usumod);
                pr.setId_impuesto(impuesto);
                pr.setPrecio_u_producto(precio_u);
                pr.setCantidad(cantidad);

                r = prbd.registrarProducto(pr);
                if (r == 1) {
                    request.getRequestDispatcher("productoregistrado.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            producto = pr.buscarProducto(buscar);
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("productoActivo.jsp").forward(request, response);

        }

        if (accion.equals("Producto")) {
            producto = leer.leerProductoAc();
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("productoActivo.jsp").forward(request, response);

        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            String editar = request.getParameter("codigo2");
            int length2 = editar.length();
            pr = pr.editarProducto(editar);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("producto.jsp").forward(request, response);
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            //producto = p.buscarProducto(buscar);
            // p = new Producto(int id_producto, String descripcion_producto, String estado_producto);
            producto = new ArrayList();
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("producto.jsp").forward(request, response);

        }

        if (accion.equals("Activo")) {
            producto = leer.leerProductoAc();
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("productoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            producto = leer.leerProductoIna();
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("productoInactivo.jsp").forward(request, response);
        }
        if (accion.equals("Todos")) {
            producto = leer.leerProductoTo();
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("productoTodo.jsp").forward(request, response);
        }
        if (accion.equals("Cambiar Activo")) {
            int id_p1 = Integer.valueOf(request.getParameter("codigo"));
            pr.setId_producto(id_p1);
            r = prbd.cambiarActivo(pr);
            producto = leer.leerProductoIna();
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("productoInactivo.jsp").forward(request, response);
        }
        if (accion.equals("Cambiar Inactivo")) {
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            pr.setId_producto(codigo);
            r = prbd.cambiarInactivo(pr);
            producto = leer.leerProductoAc();
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("productoActivo.jsp").forward(request, response);
        }
        if (accion.equals("Atras")) {
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("productoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Volver")) {
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("productoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            String descrippr = request.getParameter("descriptxt");
            String estadopr = request.getParameter("customRadio");
            String usumod = Variables.usuarioConectado.getNombre_usuario();
            int impuesto = Integer.valueOf(request.getParameter("drop_imp"));
            int precio_u = Integer.valueOf(request.getParameter("precioutxt"));
//            int cantidad = 0;
            int id_pro = Integer.valueOf(request.getParameter("idtxt"));
            int length = descrippr.length();
            if (length == 0) {
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {
                pr.setDescripcion_producto(descrippr);
                pr.setEstado_producto(estadopr);
                pr.setNombre_usu_mod_producto(usumod);
                pr.setId_impuesto(impuesto);
                pr.setPrecio_u_producto(precio_u);
//                pr.setCantidad(cantidad);

                pr.setId_producto(id_pro);
                r = prbd.modificarProducto(pr);
                if (r == 1) {
                    producto = leer.leerProductoAc();
                    request.setAttribute("ProductoL", producto);
                    request.setAttribute("Producto", pr);
                    request.getRequestDispatcher("productoActivo.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
                }
            }
        }
        ///////////////////////////////////////////////////VENTA///////////////////////////////////
        if (accion.equals("Ver Producto")) {
            Variables.ban = 0;
            producto = leer0.leerProductoVenta();
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("registrarVentaProducto.jsp").forward(request, response);
        }
        if (accion.equals("Seleccionar")) {

            Variables.chaumensaje = 1;
            Variables.ban2 = 1;
            Variables.capi = 0;
            venta = new ArrayList();
            String id = request.getParameter("codigo2");
            Variables.id_producto_vd = Integer.parseInt(request.getParameter("codigo2"));
            producto = pr.seleccionarProductos(id);
            int Idcaptura = 0;
            ////contenido del array//////
            String descripcion = request.getParameter("descri");
            int impuesto = Integer.valueOf(request.getParameter("cifra"));
            int precio = Integer.valueOf(request.getParameter("precio"));
            int cantidad = Integer.valueOf(request.getParameter("cantidad"));
            int cantidad_anterior = Integer.valueOf(request.getParameter("cantxt"));
            int can_total = cantidad_anterior - cantidad;

            if (Idcaptura == 0) {
                if (impuesto == 5) {
                    Variables.iva5_venta = (precio * cantidad);
                    Variables.subtotal_5 = Variables.subtotal_5 + Variables.iva5_venta;
                    Variables.total_liq5_venta = ((Variables.total_liq5_venta + (Variables.iva5_venta / 21)));

                }
                if (impuesto == 10) {
                    Variables.iva10_venta = (precio * cantidad);
                    Variables.subtotal_10 = (Variables.subtotal_10 + Variables.iva10_venta);
                    Variables.total_liq10_venta = ((Variables.total_liq10_venta + (Variables.iva10_venta / 11)));

                }
                if (impuesto == 0) {
                    Variables.exenta_venta = (precio * cantidad);
                    Variables.subtotal_exenta = Variables.subtotal_exenta + Variables.exenta_venta;
                }
                Variables.total_venta = (Variables.subtotal_exenta + Variables.subtotal_5 + Variables.subtotal_10);
                Variables.total_liqtotal_venta = (Variables.total_liq10_venta + Variables.total_liq5_venta);

                Venta ven01 = new Venta();
                ven01.setCantidad_vd(cantidad);
                ven01.setDescrip_vd(descripcion);
                ven01.setPrecio_uni_vd(precio);
                ven01.setId_producto_vd(Variables.id_producto_vd);
                if (impuesto == 5) {
                    if (Variables.iva5_venta != 0) {
                        iva5 = (precio * cantidad);
                        ven01.setIva5_vd(iva5);
                    }
                }
                if (impuesto == 10) {
                    if (Variables.iva10_venta != 0) {
                        iva10 = (precio * cantidad);
                        ven01.setIva10_vd(iva10);
                    }
                }
                if (impuesto == 0) {
                    if (Variables.exenta_venta != 0) {
                        exenta = (precio * cantidad);
                        ven01.setExenta_vd(exenta);
                    }
                }
                ////////////////////////////////////////////////////////
                ven.setSubtotal_5(Variables.subtotal_5);
                ven.setSubtotal_10(Variables.subtotal_10);
                ven.setSubtotal_exenta(Variables.subtotal_exenta);
                ven.setTotal_pagar_venta(Variables.total_venta);
                ven.setLiq5_iva_venta(Variables.total_liq5_venta);
                ven.setLiq10_iva_venta(Variables.total_liq10_venta);
                ven.setLiqtotal_iva_venta(Variables.total_liqtotal_venta);

                ////////////////////////////////////////////////////////
                Variables.addVentas(ven01);
            } else {

            }
            request.setAttribute("VentaL", Variables.getVentas());
            request.setAttribute("Venta", ven);
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("nuevaVenta.jsp").forward(request, response);

        }
        if (accion.equals("Buscar Producto")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            producto = pr.buscarProductoVenta(buscar);
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("registrarVentaProducto.jsp").forward(request, response);
        }
        if (accion.equals("Volver ")) {
            ven = ven.buscarTimbrado();
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            request.setAttribute("Cliente", clie);
            request.getRequestDispatcher("nuevaVenta.jsp").forward(request, response);
        }
//*************************** PEDIDO DE COMPRA*********************************/
        if (accion.equals("Ver Producto2")) {
            Variables.ban = 0;
            producto = leer.leerProductoVenta();
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("pedidocompraProducto.jsp").forward(request, response);
        }

        if (accion.equals("Atras2")) {
            request.setAttribute("OrdenCompraL", Variables.getOrdencompras());
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompra.jsp").forward(request, response);
        }

        if (accion.equals("Seleccionar2")) {
            Variables.chaumensaje = 1;
            Variables.ban2 = 1;
            Variables.capi = 0;
            orden_compra = new ArrayList();
            String id = request.getParameter("codigo2");
            Variables.id_prod_orden = Integer.parseInt(request.getParameter("codigo2"));
            producto = pr.seleccionarProductos(id);
            int Idcaptura = 0;
            ////contenido del array//////
            String descripcion = request.getParameter("descri");
            int impuesto = Integer.valueOf(request.getParameter("cifra"));
            int precio = Integer.valueOf(request.getParameter("precio"));
            int cantidad = Integer.valueOf(request.getParameter("cantidad"));
            int cantidad_anterior = Integer.valueOf(request.getParameter("cantxt"));
            int can_total = cantidad_anterior + cantidad;

            if (Idcaptura == 0) {
                if (impuesto == 5) {
                    Variables.iva5_orden = (precio * cantidad);
                    Variables.subtotal_5_orden = Variables.subtotal_5_orden + Variables.iva5_orden;
                    Variables.total_liq5_orden = ((Variables.total_liq5_orden + (Variables.subtotal_5_orden)) / 21);
                }
                if (impuesto == 10) {
                    Variables.iva10_orden = (precio * cantidad);
                    Variables.subtotal_10_orden = (Variables.subtotal_10_orden + Variables.iva10_orden);
                    Variables.total_liq10_orden = (((Variables.iva10_orden)) / 11);
                }
                if (impuesto == 0) {
                    Variables.exenta_orden = (precio * cantidad);
                    Variables.subtotal_exenta_orden = Variables.subtotal_exenta_orden + Variables.exenta_orden;
                }
                Variables.total_orden = (Variables.subtotal_exenta_orden + Variables.subtotal_5_orden + Variables.subtotal_10_orden);
                Variables.total_liqtotal_orden = (Variables.total_liq10_orden + Variables.total_liq5_orden);

                Ordencompra orden01 = new Ordencompra();
                orden01.setCant_orden_comd(Math.round(cantidad));
                orden01.setDescrip_orden_comd(descripcion);
                orden01.setPrecio_orden_comd(precio);
                orden01.setId_pr(Variables.id_prod_orden);
                if (impuesto == 5) {
                    if (Variables.iva5_orden != 0) {
                        iva5 = (precio * cantidad);
                        orden01.setIva5_orden_comd(iva5);
                    }
                }
                if (impuesto == 10) {
                    if (Variables.iva10_orden != 0) {
                        iva10 = (precio * cantidad);
                        orden01.setIva10_orden_comd(iva10);
                    }
                }
                if (impuesto == 0) {
                    if (Variables.exenta_orden != 0) {
                        exenta = (precio * cantidad);
                        orden01.setExenta_orden_comd(exenta);
                    }
                }
                //-------------- COMPRA ----------------------------------------
                Compra compra01 = new Compra();
                compra01.setCant_com_d(Math.round(cantidad));
                compra01.setDescrip_com_d(descripcion);
                compra01.setPrecio_com_d(precio);
                compra01.setId_pr(Variables.id_prod_orden);
                if (impuesto == 5) {
                    if (Variables.iva5_orden != 0) {
                        iva5 = (precio * cantidad);
                        compra01.setIva5_com_d(iva5);
                    }
                }
                if (impuesto == 10) {
                    if (Variables.iva10_orden != 0) {
                        iva10 = (precio * cantidad);
                        compra01.setIva10_com_d(iva10);
                    }
                }
                if (impuesto == 0) {
                    if (Variables.exenta_orden != 0) {
                        exenta = (precio * cantidad);
                        compra01.setExentas_com_d(exenta);
                    }
                }
                ////////////////////////////////////////////////////////
                orden_com.setIva5_sub_orden_com(Variables.subtotal_5_orden);
                orden_com.setIva10_sub_orden_com(Variables.subtotal_10_orden);
                orden_com.setExenta_sub_orden_com(Variables.subtotal_exenta_orden);
                orden_com.setTotal_pagar_orden_com(Variables.total_orden);
                orden_com.setLiq5_total_orden_com(Variables.total_liq5_orden);
                orden_com.setLiq10_total_orden_com(Variables.total_liq10_orden);
                orden_com.setLiq_total_orden_com(Variables.total_liqtotal_orden);

                ////////////////////////////////////////////////////////
                Variables.addOrden(orden01);
                Variables.addCompras(compra01);
            } else {

            }
            request.setAttribute("OrdenCompraL", Variables.getOrdencompras());
            request.setAttribute("OrdenCompra", orden_com);
            // request.setAttribute("Proveedor", prov);
            request.getRequestDispatcher("pedidocompra.jsp").forward(request, response);
        }
//*************************** PEDIDO DE COMPRA FIN****************************//
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
