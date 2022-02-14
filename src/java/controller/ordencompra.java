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
import model.Compra;
import model.Ordencompra;
import model.Producto;
import model.Proveedor;
import model.Variables;
import model.Cta_Pagar;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "ordencompra", urlPatterns = {"/ordencompra"})
public class ordencompra extends HttpServlet {

    Ordencompra orden_com = new Ordencompra();
    Ordencompra orden_combd = new Ordencompra();
    int r;
    int s;
    int t;
    Proveedor prov = new Proveedor();
    Producto pr = new Producto();
    Producto prbd = new Producto();
    Cta_Pagar cta_pagar = new Cta_Pagar();
    Cta_Pagar cta_pagarbd = new Cta_Pagar();
    Compra com = new Compra();
    Compra combd = new Compra();
    int iva5;
    int iva10;
    int exenta;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Ordencompra> orden_compra = new ArrayList();
        Ordencompra leer = new Ordencompra();
        ArrayList<Proveedor> proveedor = new ArrayList();
        ArrayList<Producto> producto = new ArrayList();
        Proveedor leer1 = new Proveedor();
        Producto leer2 = new Producto();

///////////////////////////NUEVA LOGICA/////////////////////////////////////////
        if (accion.equals("Pedido de Compra")) {
            limpiarVariables();
            orden_compra = leer.leerOrden();
            request.setAttribute("OrdenCompraL", orden_compra);
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompraListado.jsp").forward(request, response);
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
             if (Variables.nro_orden == null) {
                Variables.nro_orden1 = 1;
            } else {
                Variables.nro_orden1 = Integer.parseInt(Variables.nro_orden);
                Variables.nro_orden1 = Variables.nro_orden1 + 1;
            }     
            request.setAttribute("OrdenCompraL", orden_compra);
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompra.jsp").forward(request, response);
        }

        if (accion.equals("Orden de Compra")) {
            // limpiarVariables();
            orden_compra = leer.leerOrden();
            request.setAttribute("OrdenCompraL", orden_compra);
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("ordencompra.jsp").forward(request, response);
        }

        if (accion.equals("Buscar2")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            proveedor = prov.buscarProveedor(buscar);
            request.setAttribute("ProveedorL", proveedor);
            request.setAttribute("Proveedor", prov);
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompraProveedor.jsp").forward(request, response);
        }

        if (accion.equals("ListaProv")) {
            int condicion = (Integer.valueOf(request.getParameter("checkbox")));
            Variables.id_tipo_pago = condicion;
            orden_com = new Ordencompra();
            orden_com.setId_cond(condicion);
            proveedor = leer1.leerProveedorAc();
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

        //AUN FALTA TERMINAR EL TEMA DE EDITAR
        if (accion.equals("Editar")) {
            Variables.gua = 1;
            String editar = request.getParameter("codigo3");
            int length2 = editar.length();
            orden_com = orden_com.editarOrdenCom(editar);
            request.setAttribute("Proveedor", prov);
            request.setAttribute("OrdenCompraL", Variables.getOrdencompras());
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompra.jsp").forward(request, response);
        }

        if (accion.equals("Ver")) {
            String agregarbuscar = request.getParameter("codigo2");
            prov = prov.añadirProveedor(agregarbuscar);
            request.setAttribute("Proveedor", prov);
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
            request.setAttribute("Proveedor", prov);
            request.getRequestDispatcher("pedidocompra.jsp").forward(request, response);

        }

        if (accion.equals("Atras2")) {
            request.setAttribute("OrdenCompraL", Variables.getOrdencompras());
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompra.jsp").forward(request, response);
        }

        if (accion.equals("Atras3")) {
            limpiarVariables();
            orden_compra = leer.leerOrden();
            request.setAttribute("OrdenCompraL", orden_compra);
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompraListado.jsp").forward(request, response);
        }

        if (accion.equals("Si")) {
            int idArray = (Integer.valueOf(request.getParameter("id")));
            int exentaOrden = (Integer.valueOf(request.getParameter("exentxt")));
            int cincoOrden = (Integer.valueOf(request.getParameter("cincotxt")));
            int diezOrden = (Integer.valueOf(request.getParameter("dieztxt")));
            int tamaño = (Integer.valueOf(request.getParameter("tamatxt")));

            if (cincoOrden > 0) {
                Variables.iva5_orden = cincoOrden;
                Variables.subtotal_5_orden = Variables.subtotal_5_orden - Variables.iva5_orden;
                int liq5 = 0;
                liq5 = ((liq5 + cincoOrden) / 21);
                Variables.total_liq5_orden = ((Variables.subtotal_5_orden) / 21);
                if (tamaño == 1) {
                    Variables.total_liq5_orden = 0;
                }
            }
            if (diezOrden > 0) {
                Variables.iva10_orden = diezOrden;
                Variables.subtotal_10_orden = (Variables.subtotal_10_orden - Variables.iva10_orden);
                int liq10 = 0;
                liq10 = ((liq10 + diezOrden) / 11);
                Variables.total_liq10_orden = ((Variables.subtotal_10_orden) / 11);
                if (tamaño == 1) {
                    Variables.total_liq10_orden = 0;
                }
            }
            if (exentaOrden > 0) {
                Variables.exenta_orden = exentaOrden;
                Variables.subtotal_exenta_orden = Variables.subtotal_exenta_orden - Variables.exenta_orden;
            }
            Variables.total_orden = (Variables.subtotal_exenta_orden + Variables.subtotal_5_orden + Variables.subtotal_10_orden);
            Variables.total_liqtotal_orden = (Variables.total_liq10_orden + Variables.total_liq5_orden);
            Variables.ordenDet1.remove(idArray);
            if (Variables.ordenDet1.indexOf(idArray) < 0) {
                Variables.chaumensaje = 0;
            } else {
            }
            request.setAttribute("OrdenCompraL", Variables.getOrdencompras());
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompra.jsp").forward(request, response);
        }

        if (accion.equals("Cancelar")) {
            Variables.mensajeRegistrado = 2;
            int codigo = Integer.valueOf(request.getParameter("codigo2"));
            orden_com.setId_orden_com(codigo);
            r = orden_combd.cancelarOrden(orden_com);
            orden_compra = leer.leerOrden();
            request.setAttribute("OrdenCompraL", orden_compra);
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("ordencompra.jsp").forward(request, response);
        }

        if (accion.equals("Aprobar")) {
            Variables.mensajeRegistrado = 1;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            String codigo2 = request.getParameter("codigo");
            String descrip = request.getParameter("descriProvtxt");
            int total = Integer.valueOf(request.getParameter("totaltxt"));
            orden_com.setId_orden_com(codigo);
            cta_pagar.setCodigo_cuenta_pagar(codigo2);
            cta_pagar.setDescripcion_cuenta_pagar(descrip);
            cta_pagar.setTotal_cuenta_pagar(total);
            r = orden_combd.aprobarOrden(orden_com);
            s = cta_pagarbd.registrarCta_Pagar(cta_pagar);
            if (r == 1 && s == 1) {
                orden_compra = leer.leerOrden();
                request.setAttribute("OrdenCompraL", orden_compra);
                request.setAttribute("OrdenCompra", orden_com);
                request.getRequestDispatcher("ordencompra.jsp").forward(request, response);
            }
        }

        if (accion.equals("Aprobados")) {
            orden_compra = leer.leerOrdenAprobados();
            request.setAttribute("OrdenCompraL", orden_compra);
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("ordencompraAprobado.jsp").forward(request, response);
        }

        if (accion.equals("Cancelados")) {
            orden_compra = leer.leerOrdenCancelados();
            request.setAttribute("OrdenCompraL", orden_compra);
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("ordencompraCancelado.jsp").forward(request, response);
        }

        if (accion.equals("Registrar")) {

            Variables.mensajeRegistrado = 1;
            String nro_orden = request.getParameter("nropedtxt");
            String fecha_pedido_orden = request.getParameter("fechapedtxt");
            String usu = Variables.usuario1;
            int id_proveedor = Variables.id_prov_orden;
            int id_servicio = Integer.valueOf(request.getParameter("drop_st"));
            int total = Variables.total_orden;
            
            String condicion = "contado";
            int liq5 = Variables.total_liq5_orden;
            int liq10 = Variables.total_liq10_orden;
            int liqTotal = Variables.total_liqtotal_orden;
            int sub5 = Variables.subtotal_5_orden;
            int sub10 = Variables.subtotal_10_orden;
            int subExenta = Variables.subtotal_exenta_orden;
            int id_usu = Variables.usuarioConectado.getId_usuario();
            int id_condicion = 1;

            orden_com.setNro_orden_com(nro_orden);
            orden_com.setFecha_pedido_orden_com(fecha_pedido_orden);
            orden_com.setNom_usu_mod(usu);
            orden_com.setId_prov(id_proveedor);
            orden_com.setId_st(id_servicio);
            orden_com.setTotal_pagar_orden_com(total);
            orden_com.setCondicion_orden_com(condicion);
            orden_com.setLiq5_total_orden_com(liq5);
            orden_com.setLiq10_total_orden_com(liq10);
            orden_com.setLiq_total_orden_com(liqTotal);
            orden_com.setIva5_sub_orden_com(sub5);
            orden_com.setIva10_sub_orden_com(sub10);
            orden_com.setExenta_sub_orden_com(subExenta);
            orden_com.setId_usu(id_usu);
            orden_com.setId_cond(id_condicion);
            //---------------------- COMPRA ------------------------------------
            com.setProveedor(Variables.nombre_prov_orden);
            com.setTotal_com(total);
            com.setNom_usu_mod(usu);
            com.setId_prov(id_proveedor);
            com.setId_st(id_servicio);
            com.setId_mon(2);
            com.setId_usu(id_usu);
            com.setLiq5_total_com(liq5);
            com.setLiq10_total_com(liq10);
            com.setLiq_total_com(liqTotal);
            com.setSubtotal_iva5_com(sub5);
            com.setSubtotal_iva10_com(sub10);
            com.setSubtotal_exenta_com(subExenta);
            com.setId_cond(id_condicion);

            r = orden_combd.registrarOrdencompra(orden_com);
            s = combd.registrarCompra(com);
            if (r == 1 && s == 1) {
                orden_compra = leer.leerOrden();
                request.setAttribute("OrdenCompraL", orden_compra);
                request.setAttribute("OrdenCompra", orden_com);
                request.getRequestDispatcher("pedidocompraListado.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
            }

        }

        if (accion.equals("Ver Producto2")) {
            Variables.ban = 0;
            producto = leer2.leerProductoVenta();
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.getRequestDispatcher("pedidocompraProducto.jsp").forward(request, response);
        }

        if (accion.equals("Atras2")) {
            request.setAttribute("OrdenCompraL", Variables.getOrdencompras());
            request.setAttribute("OrdenCompra", orden_com);
            request.getRequestDispatcher("pedidocompra.jsp").forward(request, response);
        }
    }

    private void limpiarVariables() {
        Variables.nombre_prov_orden = null;
        Variables.ciudad_prov_orden = null;
        Variables.tel_prov_orden = null;
        Variables.ruc_prov_orden = null;
        Variables.subtotal_exenta_orden = 0;
        Variables.subtotal_5_orden = 0;
        Variables.subtotal_10_orden = 0;
        Variables.total_orden = 0;
        Variables.total_liq5_orden = 0;
        Variables.total_liq10_orden = 0;
        Variables.total_liqtotal_orden = 0;
        Variables.mensajeRegistrado = 0;
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
