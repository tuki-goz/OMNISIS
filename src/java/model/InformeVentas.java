/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alvaro
 */
public class InformeVentas implements ValidarInformeVentas {

    int id_venta, id_venta_detalle, id_cliente, id_usuario, id_contrato, id_moneda, id_tipo_pago, id_timbrado, id_estado;
    Double total_pagar_venta, liq5_total_iva_venta, liq10_total_iva_venta, liq_total_iva_venta, iva5_subtotal, iva10_subtotal, exenta_subtotal, precio_unitario;
    String descripcion, cantidad, nro_factura_venta, condicion_venta, fecha_registrada_venta, fecha_factura_venta, estado_venta, nombre_usuario_modificacion, ruc_venta, nombre_razon_venta;

    public InformeVentas() {
    }

    public InformeVentas(int id_venta, Double total_pagar_venta, Double liq_total_iva_venta, String nro_factura_venta, String condicion_venta, String fecha_factura_venta, String estado_venta, String ruc_venta, String nombre_razon_venta) {
        this.id_venta = id_venta;
        this.total_pagar_venta = total_pagar_venta;
        this.liq_total_iva_venta = liq_total_iva_venta;
        this.nro_factura_venta = nro_factura_venta;
        this.condicion_venta = condicion_venta;
        this.fecha_factura_venta = fecha_factura_venta;
        this.estado_venta = estado_venta;
        this.ruc_venta = ruc_venta;
        this.nombre_razon_venta = nombre_razon_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_venta_detalle() {
        return id_venta_detalle;
    }

    public void setId_venta_detalle(int id_venta_detalle) {
        this.id_venta_detalle = id_venta_detalle;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_moneda() {
        return id_moneda;
    }

    public void setId_moneda(int id_moneda) {
        this.id_moneda = id_moneda;
    }

    public int getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(int id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public int getId_timbrado() {
        return id_timbrado;
    }

    public void setId_timbrado(int id_timbrado) {
        this.id_timbrado = id_timbrado;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public Double getTotal_pagar_venta() {
        return total_pagar_venta;
    }

    public void setTotal_pagar_venta(Double total_pagar_venta) {
        this.total_pagar_venta = total_pagar_venta;
    }

    public Double getLiq5_total_iva_venta() {
        return liq5_total_iva_venta;
    }

    public void setLiq5_total_iva_venta(Double liq5_total_iva_venta) {
        this.liq5_total_iva_venta = liq5_total_iva_venta;
    }

    public Double getLiq10_total_iva_venta() {
        return liq10_total_iva_venta;
    }

    public void setLiq10_total_iva_venta(Double liq10_total_iva_venta) {
        this.liq10_total_iva_venta = liq10_total_iva_venta;
    }

    public Double getLiq_total_iva_venta() {
        return liq_total_iva_venta;
    }

    public void setLiq_total_iva_venta(Double liq_total_iva_venta) {
        this.liq_total_iva_venta = liq_total_iva_venta;
    }

    public Double getIva5_subtotal() {
        return iva5_subtotal;
    }

    public void setIva5_subtotal(Double iva5_subtotal) {
        this.iva5_subtotal = iva5_subtotal;
    }

    public Double getIva10_subtotal() {
        return iva10_subtotal;
    }

    public void setIva10_subtotal(Double iva10_subtotal) {
        this.iva10_subtotal = iva10_subtotal;
    }

    public Double getExenta_subtotal() {
        return exenta_subtotal;
    }

    public void setExenta_subtotal(Double exenta_subtotal) {
        this.exenta_subtotal = exenta_subtotal;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNro_factura_venta() {
        return nro_factura_venta;
    }

    public void setNro_factura_venta(String nro_factura_venta) {
        this.nro_factura_venta = nro_factura_venta;
    }

    public String getCondicion_venta() {
        return condicion_venta;
    }

    public void setCondicion_venta(String condicion_venta) {
        this.condicion_venta = condicion_venta;
    }

    public String getFecha_registrada_venta() {
        return fecha_registrada_venta;
    }

    public void setFecha_registrada_venta(String fecha_registrada_venta) {
        this.fecha_registrada_venta = fecha_registrada_venta;
    }

    public String getFecha_factura_venta() {
        return fecha_factura_venta;
    }

    public void setFecha_factura_venta(String fecha_factura_venta) {
        this.fecha_factura_venta = fecha_factura_venta;
    }

    public String getEstado_venta() {
        return estado_venta;
    }

    public void setEstado_venta(String estado_venta) {
        this.estado_venta = estado_venta;
    }

    public String getNombre_usuario_modificacion() {
        return nombre_usuario_modificacion;
    }

    public void setNombre_usuario_modificacion(String nombre_usuario_modificacion) {
        this.nombre_usuario_modificacion = nombre_usuario_modificacion;
    }

    public String getRuc_venta() {
        return ruc_venta;
    }

    public void setRuc_venta(String ruc_venta) {
        this.ruc_venta = ruc_venta;
    }

    public String getNombre_razon_venta() {
        return nombre_razon_venta;
    }

    public void setNombre_razon_venta(String nombre_razon_venta) {
        this.nombre_razon_venta = nombre_razon_venta;
    }

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    PreparedStatement ps2;
    PreparedStatement ps3;
    PreparedStatement ps4;
    ResultSet rs;
    ResultSet rs2;
    private Statement stm;
    private InformeVentas informeVentasHallado;

    public ArrayList<InformeVentas> buscarInformeVentasClienteyFecha(String buscartxt, String fechainitxt, String fechafintxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Variables.sumarventa = 0.0;
        InformeVentas inf = new InformeVentas();
        ArrayList<InformeVentas> informeVentas = new ArrayList<>();
        String sql = "SELECT ven.id_venta, ven.nro_factura_venta, ven.fecha_factura_venta, ven.nombre_razon_venta, ven.ruc_venta, ven.condicion_venta, ven.estado_venta, ven.total_pagar_venta, ven.liq_total_iva_venta \n"
                + "     FROM public.venta ven \n"
                + "     WHERE ven.estado_venta = 'pendiente' \n"
                + "	and ven.nombre_razon_venta ilike ? \n"
                + "	and ven.fecha_registrada_venta  between ? and ? \n"
                + "     ORDER BY ven.id_venta";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            ps.setString(2, fechainitxt);
            ps.setString(3, fechafintxt);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeVentas;
            } else {
                do {
                    id_venta = rs.getInt("id_venta");
                    total_pagar_venta = rs.getDouble("total_pagar_venta");
                    liq_total_iva_venta = rs.getDouble("liq_total_iva_venta");
                    nro_factura_venta = rs.getString("nro_factura_venta");
                    condicion_venta = rs.getString("condicion_venta");
                    fecha_factura_venta = rs.getString("fecha_factura_venta");
                    estado_venta = rs.getString("estado_venta");
                    ruc_venta = rs.getString("ruc_venta");
                    nombre_razon_venta = rs.getString("nombre_razon_venta");
                    Variables.sumarventa = Variables.sumarventa + total_pagar_venta;  ////suma la venta
                    informeVentasHallado = new InformeVentas(id_venta, total_pagar_venta, liq_total_iva_venta, nro_factura_venta, condicion_venta, fecha_factura_venta, estado_venta, ruc_venta, nombre_razon_venta);
                    informeVentas.add(informeVentasHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeVentas;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeVentas> buscarInformeVentasCliente(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Variables.sumarventa = 0.0;
        InformeVentas inf = new InformeVentas();
        ArrayList<InformeVentas> informeVentas = new ArrayList<>();
        String sql = "SELECT ven.id_venta, ven.nro_factura_venta, ven.fecha_factura_venta, ven.nombre_razon_venta, ven.ruc_venta, ven.condicion_venta, ven.estado_venta, ven.total_pagar_venta, ven.liq_total_iva_venta \n"
                + "     FROM public.venta ven \n"
                + "     WHERE ven.estado_venta = 'pendiente' \n"
                + "	and ven.nombre_razon_venta ilike ? \n"
                + "     ORDER BY ven.id_venta";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeVentas;
            } else {
                do {
                    id_venta = rs.getInt("id_venta");
                    total_pagar_venta = rs.getDouble("total_pagar_venta");
                    liq_total_iva_venta = rs.getDouble("liq_total_iva_venta");
                    nro_factura_venta = rs.getString("nro_factura_venta");
                    condicion_venta = rs.getString("condicion_venta");
                    fecha_factura_venta = rs.getString("fecha_factura_venta");
                    estado_venta = rs.getString("estado_venta");
                    ruc_venta = rs.getString("ruc_venta");
                    nombre_razon_venta = rs.getString("nombre_razon_venta");
                    Variables.sumarventa = Variables.sumarventa + total_pagar_venta;
                    informeVentasHallado = new InformeVentas(id_venta, total_pagar_venta, liq_total_iva_venta, nro_factura_venta, condicion_venta, fecha_factura_venta, estado_venta, ruc_venta, nombre_razon_venta);
                    informeVentas.add(informeVentasHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeVentas;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeVentas> buscarInformeVentasFecha(String fechainitxt, String fechafintxt) {
        int r = 0;
        Variables.sumarventa = 0.0;
        InformeVentas inf = new InformeVentas();
        ArrayList<InformeVentas> informeVentas = new ArrayList<>();
        String sql = "SELECT ven.id_venta, ven.nro_factura_venta, ven.fecha_factura_venta, ven.nombre_razon_venta,\n"
                + "ven.ruc_venta, ven.condicion_venta, ven.estado_venta, ven.total_pagar_venta, ven.liq_total_iva_venta \n"
                + "FROM public.venta ven\n"
                + "WHERE ven.estado_venta = 'pendiente' \n"
                + "and ven.fecha_registrada_venta  between ? and ?\n"
                + "ORDER BY ven.id_venta;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fechainitxt);
            ps.setString(2, fechafintxt);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeVentas;
            } else {
                do {
                    id_venta = rs.getInt("id_venta");
                    total_pagar_venta = rs.getDouble("total_pagar_venta");
                    liq_total_iva_venta = rs.getDouble("liq_total_iva_venta");
                    nro_factura_venta = rs.getString("nro_factura_venta");
                    condicion_venta = rs.getString("condicion_venta");
                    fecha_factura_venta = rs.getString("fecha_factura_venta");
                    estado_venta = rs.getString("estado_venta");
                    ruc_venta = rs.getString("ruc_venta");
                    nombre_razon_venta = rs.getString("nombre_razon_venta");
                    Variables.sumarventa = Variables.sumarventa + total_pagar_venta;
                    informeVentasHallado = new InformeVentas(id_venta, total_pagar_venta, liq_total_iva_venta, nro_factura_venta, condicion_venta, fecha_factura_venta, estado_venta, ruc_venta, nombre_razon_venta);
                    informeVentas.add(informeVentasHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeVentas;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeVentas> buscarInformeVentasGeneral() {
        int r = 0;
        Variables.sumarventa = 0.0;
        InformeVentas inf = new InformeVentas();
        ArrayList<InformeVentas> informeVentas = new ArrayList<>();
        String sql = "SELECT ven.id_venta, ven.nro_factura_venta, ven.fecha_factura_venta, ven.nombre_razon_venta,\n"
                + "ven.ruc_venta, ven.condicion_venta, ven.estado_venta, ven.total_pagar_venta, ven.liq_total_iva_venta \n"
                + "FROM public.venta ven\n"
                + "WHERE ven.estado_venta = 'pendiente'             \n"
                + "ORDER BY ven.id_venta;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeVentas;
            } else {
                do {
                    id_venta = rs.getInt("id_venta");
                    total_pagar_venta = rs.getDouble("total_pagar_venta");
                    liq_total_iva_venta = rs.getDouble("liq_total_iva_venta");
                    nro_factura_venta = rs.getString("nro_factura_venta");
                    condicion_venta = rs.getString("condicion_venta");
                    fecha_factura_venta = rs.getString("fecha_factura_venta");
                    estado_venta = rs.getString("estado_venta");
                    ruc_venta = rs.getString("ruc_venta");
                    nombre_razon_venta = rs.getString("nombre_razon_venta");
                    Variables.sumarventa = Variables.sumarventa + total_pagar_venta;
                    informeVentasHallado = new InformeVentas(id_venta, total_pagar_venta, liq_total_iva_venta, nro_factura_venta, condicion_venta, fecha_factura_venta, estado_venta, ruc_venta, nombre_razon_venta);
                    informeVentas.add(informeVentasHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeVentas;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeVentas> leerInformeVentasAc() {
        ArrayList<InformeVentas> informeVentas = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT ven.id_venta, ven.nro_factura_venta, ven.fecha_factura_venta, ven.nombre_razon_venta, ven.ruc_venta, ven.condicion_venta, ven.estado_venta, ven.total_pagar_venta, ven.liq_total_iva_venta \n"
                    + "     FROM public.venta ven \n"
                    + "     WHERE ven.estado_venta = 'pendiente' \n"
                    + "     ORDER BY ven.id_venta");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeVentas;
            } else {
                do {
                    id_venta = rs.getInt("id_venta");
                    total_pagar_venta = rs.getDouble("total_pagar_venta");
                    liq_total_iva_venta = rs.getDouble("liq_total_iva_venta");
                    nro_factura_venta = rs.getString("nro_factura_venta");
                    condicion_venta = rs.getString("condicion_venta");
                    fecha_factura_venta = rs.getString("fecha_factura_venta");
                    estado_venta = rs.getString("estado_venta");
                    ruc_venta = rs.getString("ruc_venta");
                    nombre_razon_venta = rs.getString("nombre_razon_venta");

                    informeVentasHallado = new InformeVentas(id_venta, total_pagar_venta, liq_total_iva_venta, nro_factura_venta, condicion_venta, fecha_factura_venta, estado_venta, ruc_venta, nombre_razon_venta);
                    informeVentas.add(informeVentasHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeVentas;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeVentas> leerInformeVentasIna() {
        ArrayList<InformeVentas> informeVentas = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT ven.id_venta, ven.nro_factura_venta, ven.fecha_factura_venta, ven.nombre_razon_venta, ven.ruc_venta, ven.condicion_venta, ven.estado_venta, ven.total_pagar_venta, ven.liq_total_iva_venta \n"
                    + "     FROM public.venta ven \n"
                    + "     WHERE ven.estado_venta = 'pendiente' \n"
                    + "  WHERE ven.estado_venta = 'pagado' \n"
                    + "  ORDER BY com.id_compra");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeVentas;
            } else {
                do {
                    id_venta = rs.getInt("id_venta");
                    total_pagar_venta = rs.getDouble("total_pagar_venta");
                    liq_total_iva_venta = rs.getDouble("liq_total_iva_venta");
                    nro_factura_venta = rs.getString("nro_factura_venta");
                    condicion_venta = rs.getString("condicion_venta");
                    fecha_factura_venta = rs.getString("fecha_factura_venta");
                    estado_venta = rs.getString("estado_venta");
                    ruc_venta = rs.getString("ruc_venta");
                    nombre_razon_venta = rs.getString("nombre_razon_venta");
                    Variables.sumarventa = Variables.sumarventa + total_pagar_venta;
                    informeVentasHallado = new InformeVentas(id_venta, total_pagar_venta, liq_total_iva_venta, nro_factura_venta, condicion_venta, fecha_factura_venta, estado_venta, ruc_venta, nombre_razon_venta);
                    informeVentas.add(informeVentasHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeVentas;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

}
