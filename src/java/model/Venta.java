/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.swing.WindowConstants;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JRExporter;
//import net.sf.jasperreports.engine.JRExporterParameter;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.export.JRPdfExporter;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Francisca Gómez
 */
public class Venta implements ValidarVenta {
    //CONSTRUCTORES - SET - GET

    //CABECERA
    int id_venta, id_clie, id_usu, id_contr, id_mon, id_timb, id_tipo_pago, total_pagar_venta, liq5_iva_venta, liq10_iva_venta, liqtotal_iva_venta, id_estado, subtotal_exenta, subtotal_5, subtotal_10, nro_cuota;
    String nro_factura_venta, ruc_venta, nombre_razon_venta, condicion_venta, fecha_registrada_venta, fecha_facturada_venta, estado_venta, nom_usu_mod, fecha_mod, nro_timbrado_venta, descrip_clie, descrip_usu, descrip_contrato, descrip_moneda;
    //DETALLE
    int id_vd, id_servicio_vd, id_producto_vd, cantidad_vd, precio_uni_vd, exenta_vd, iva5_vd, iva10_vd, total_exenta_vd, total_iva5_vd, total_iva10_vd;
    String descrip_vd, letras;

    //CONSTRUCTOR CABECERA
    public Venta(int id_venta, int id_clie, int id_usu, int id_contr, int id_mon, int id_timb, int id_tipo_pago, int total_pagar_venta, int liq5_iva_venta, int liq10_iva_venta, int liqtotal_iva_venta, int id_estado, String nro_factura_venta, String ruc_venta, String nombre_razon_venta, String condicion_venta, String fecha_registrada_venta, String fecha_facturada_venta, String estado_venta, String nom_usu_mod, String fecha_mod) {
        this.id_venta = id_venta;
        this.id_clie = id_clie;
        this.id_usu = id_usu;
        this.id_contr = id_contr;
        this.id_mon = id_mon;
        this.id_timb = id_timb;
        this.id_tipo_pago = id_tipo_pago;
        this.total_pagar_venta = total_pagar_venta;
        this.liq5_iva_venta = liq5_iva_venta;
        this.liq10_iva_venta = liq10_iva_venta;
        this.liqtotal_iva_venta = liqtotal_iva_venta;
        this.id_estado = id_estado;
        this.nro_factura_venta = nro_factura_venta;
        this.ruc_venta = ruc_venta;
        this.nombre_razon_venta = nombre_razon_venta;
        this.condicion_venta = condicion_venta;
        this.fecha_registrada_venta = fecha_registrada_venta;
        this.fecha_facturada_venta = fecha_facturada_venta;
        this.estado_venta = estado_venta;
        this.nom_usu_mod = nom_usu_mod;
        this.fecha_mod = fecha_mod;
    }

    //CONSTRUCTOR DETALLE
    public Venta(int id_vd, int id_servicio_vd, int id_producto_vd, int cantidad_vd, int precio_uni_vd, int exenta_vd, int iva5_vd, int iva10_vd, int total_exenta_vd, int total_iva5_vd, int total_iva10_vd, String descrip_vd) {
        this.id_vd = id_vd;
        this.id_servicio_vd = id_servicio_vd;
        this.id_producto_vd = id_producto_vd;
        this.cantidad_vd = cantidad_vd;
        this.precio_uni_vd = precio_uni_vd;
        this.exenta_vd = exenta_vd;
        this.iva5_vd = iva5_vd;
        this.iva10_vd = iva10_vd;
        this.total_exenta_vd = total_exenta_vd;
        this.total_iva5_vd = total_iva5_vd;
        this.total_iva10_vd = total_iva10_vd;
        this.descrip_vd = descrip_vd;
    }

    //CONSTRUCTOR VACIO
    public Venta() {
    }

    //CONSTRUCTOR ARRAYLIST PRINCIPAL
    public Venta(int id_venta, int total_pagar_venta, int liq5_iva_venta, int liq10_iva_venta, int liqtotal_iva_venta, String nro_factura_venta, String ruc_venta, String nombre_razon_venta, String condicion_venta, String fecha_registrada_venta, String estado_venta, String nro_timbrado_venta, String descrip_contrato, String descrip_moneda) {
        this.id_venta = id_venta;
        this.total_pagar_venta = total_pagar_venta;
        this.liq5_iva_venta = liq5_iva_venta;
        this.liq10_iva_venta = liq10_iva_venta;
        this.liqtotal_iva_venta = liqtotal_iva_venta;
        this.nro_factura_venta = nro_factura_venta;
        this.ruc_venta = ruc_venta;
        this.nombre_razon_venta = nombre_razon_venta;
        this.condicion_venta = condicion_venta;
        this.fecha_registrada_venta = fecha_registrada_venta;
        this.estado_venta = estado_venta;
        this.nro_timbrado_venta = nro_timbrado_venta;
        this.descrip_contrato = descrip_contrato;
        this.descrip_moneda = descrip_moneda;
    }

    //CONSTRUCTOR ARRAYLIST PRINCIPAL
    public Venta(int id_venta, int id_vd, int cantidad_vd, int precio_uni_vd, int exenta_vd, int iva5_vd, int iva10_vd, String descrip_vd) {
        this.id_venta = id_venta;
        this.id_vd = id_vd;
        this.cantidad_vd = cantidad_vd;
        this.precio_uni_vd = precio_uni_vd;
        this.exenta_vd = exenta_vd;
        this.iva5_vd = iva5_vd;
        this.iva10_vd = iva10_vd;
        this.descrip_vd = descrip_vd;
    }

    //CONSTRUCTOR PARA COBRO
    public Venta(int id_venta, int total_pagar_venta, String nro_factura_venta, String ruc_venta, String nombre_razon_venta, String condicion_venta, String fecha_facturada_venta, String estado_venta, String descrip_contrato) {
        this.id_venta = id_venta;
        this.total_pagar_venta = total_pagar_venta;
        this.nro_factura_venta = nro_factura_venta;
        this.ruc_venta = ruc_venta;
        this.nombre_razon_venta = nombre_razon_venta;
        this.condicion_venta = condicion_venta;
        this.fecha_facturada_venta = fecha_facturada_venta;
        this.estado_venta = estado_venta;
        this.descrip_contrato = descrip_contrato;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    public int getNro_cuota() {
        return nro_cuota;
    }

    public void setNro_cuota(int nro_cuota) {
        this.nro_cuota = nro_cuota;
    }

    public int getSubtotal_exenta() {
        return subtotal_exenta;
    }

    public void setSubtotal_exenta(int subtotal_exenta) {
        this.subtotal_exenta = subtotal_exenta;
    }

    public int getSubtotal_5() {
        return subtotal_5;
    }

    public void setSubtotal_5(int subtotal_5) {
        this.subtotal_5 = subtotal_5;
    }

    public int getSubtotal_10() {
        return subtotal_10;
    }

    public void setSubtotal_10(int subtotal_10) {
        this.subtotal_10 = subtotal_10;
    }

    public String getDescrip_clie() {
        return descrip_clie;
    }

    public void setDescrip_clie(String descrip_clie) {
        this.descrip_clie = descrip_clie;
    }

    public String getDescrip_usu() {
        return descrip_usu;
    }

    public void setDescrip_usu(String descrip_usu) {
        this.descrip_usu = descrip_usu;
    }

    public String getDescrip_contrato() {
        return descrip_contrato;
    }

    public void setDescrip_contrato(String descrip_contrato) {
        this.descrip_contrato = descrip_contrato;
    }

    public String getDescrip_moneda() {
        return descrip_moneda;
    }

    public void setDescrip_moneda(String descrip_moneda) {
        this.descrip_moneda = descrip_moneda;
    }

    public String getNro_timbrado_venta() {
        return nro_timbrado_venta;
    }

    public void setNro_timbrado_venta(String nro_timbrado_venta) {
        this.nro_timbrado_venta = nro_timbrado_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_clie() {
        return id_clie;
    }

    public void setId_clie(int id_clie) {
        this.id_clie = id_clie;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public int getId_contr() {
        return id_contr;
    }

    public void setId_contr(int id_contr) {
        this.id_contr = id_contr;
    }

    public int getId_mon() {
        return id_mon;
    }

    public void setId_mon(int id_mon) {
        this.id_mon = id_mon;
    }

    public int getId_timb() {
        return id_timb;
    }

    public void setId_timb(int id_timb) {
        this.id_timb = id_timb;
    }

    public int getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(int id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public int getTotal_pagar_venta() {
        return total_pagar_venta;
    }

    public void setTotal_pagar_venta(int total_pagar_venta) {
        this.total_pagar_venta = total_pagar_venta;
    }

    public int getLiq5_iva_venta() {
        return liq5_iva_venta;
    }

    public void setLiq5_iva_venta(int liq5_iva_venta) {
        this.liq5_iva_venta = liq5_iva_venta;
    }

    public int getLiq10_iva_venta() {
        return liq10_iva_venta;
    }

    public void setLiq10_iva_venta(int liq10_iva_venta) {
        this.liq10_iva_venta = liq10_iva_venta;
    }

    public int getLiqtotal_iva_venta() {
        return liqtotal_iva_venta;
    }

    public void setLiqtotal_iva_venta(int liqtotal_iva_venta) {
        this.liqtotal_iva_venta = liqtotal_iva_venta;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNro_factura_venta() {
        return nro_factura_venta;
    }

    public void setNro_factura_venta(String nro_factura_venta) {
        this.nro_factura_venta = nro_factura_venta;
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

    public String getFecha_facturada_venta() {
        return fecha_facturada_venta;
    }

    public void setFecha_facturada_venta(String fecha_facturada_venta) {
        this.fecha_facturada_venta = fecha_facturada_venta;
    }

    public String getEstado_venta() {
        return estado_venta;
    }

    public void setEstado_venta(String estado_venta) {
        this.estado_venta = estado_venta;
    }

    public String getNom_usu_mod() {
        return nom_usu_mod;
    }

    public void setNom_usu_mod(String nom_usu_mod) {
        this.nom_usu_mod = nom_usu_mod;
    }

    public String getFecha_mod() {
        return fecha_mod;
    }

    public void setFecha_mod(String fecha_mod) {
        this.fecha_mod = fecha_mod;
    }

    public int getId_vd() {
        return id_vd;
    }

    public void setId_vd(int id_vd) {
        this.id_vd = id_vd;
    }

    public int getId_servicio_vd() {
        return id_servicio_vd;
    }

    public void setId_servicio_vd(int id_servicio_vd) {
        this.id_servicio_vd = id_servicio_vd;
    }

    public int getId_producto_vd() {
        return id_producto_vd;
    }

    public void setId_producto_vd(int id_producto_vd) {
        this.id_producto_vd = id_producto_vd;
    }

    public int getCantidad_vd() {
        return cantidad_vd;
    }

    public void setCantidad_vd(int cantidad_vd) {
        this.cantidad_vd = cantidad_vd;
    }

    public int getPrecio_uni_vd() {
        return precio_uni_vd;
    }

    public void setPrecio_uni_vd(int precio_uni_vd) {
        this.precio_uni_vd = precio_uni_vd;
    }

    public int getExenta_vd() {
        return exenta_vd;
    }

    public void setExenta_vd(int exenta_vd) {
        this.exenta_vd = exenta_vd;
    }

    public int getIva5_vd() {
        return iva5_vd;
    }

    public void setIva5_vd(int iva5_vd) {
        this.iva5_vd = iva5_vd;
    }

    public int getIva10_vd() {
        return iva10_vd;
    }

    public void setIva10_vd(int iva10_vd) {
        this.iva10_vd = iva10_vd;
    }

    public int getTotal_exenta_vd() {
        return total_exenta_vd;
    }

    public void setTotal_exenta_vd(int total_exenta_vd) {
        this.total_exenta_vd = total_exenta_vd;
    }

    public int getTotal_iva5_vd() {
        return total_iva5_vd;
    }

    public void setTotal_iva5_vd(int total_iva5_vd) {
        this.total_iva5_vd = total_iva5_vd;
    }

    public int getTotal_iva10_vd() {
        return total_iva10_vd;
    }

    public void setTotal_iva10_vd(int total_iva10_vd) {
        this.total_iva10_vd = total_iva10_vd;
    }

    public String getDescrip_vd() {
        return descrip_vd;
    }

    public void setDescrip_vd(String descrip_vd) {
        this.descrip_vd = descrip_vd;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    PreparedStatement ps2;
    PreparedStatement ps3;
    ResultSet rs;
    private Statement stm;
    private Venta ventaHallado;

//    @Override
//    public int registrarVenta(Venta ven) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public int registrarVenta(Venta ven) {
        try {
            con = cn.getConnection();
            String sql = "INSERT INTO public.venta( \n"
                    + " nro_factura_venta, condicion_venta, fecha_registrada_venta, fecha_factura_venta, total_pagar_venta, liq5_total_iva_venta, estado_venta, \n"
                    + " nombre_usuario_modificacion, fecha_modificacion, id_cliente, id_usuario, id_contrato, id_moneda, id_condicion, id_timbrado,  \n"
                    + " ruc_venta, nombre_razon_venta, liq10_total_iva_venta, liq_total_iva_venta,iva5_subtotal, iva10_subtotal, excenta_subtotal, letras) \n"
                    + " VALUES (?, ?, (SELECT current_date), (SELECT current_date), ?, ?, 'pendiente', ?, (SELECT current_date), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, ven.getNro_factura_venta());
            ps.setString(2, ven.getCondicion_venta());
            ps.setDouble(3, ven.getTotal_pagar_venta());
            ps.setDouble(4, ven.getLiq5_iva_venta());
            ps.setString(5, ven.getNom_usu_mod());
            ps.setInt(6, ven.getId_clie());
            ps.setInt(7, ven.getId_usu());
            ps.setInt(8, ven.getId_contr());
            ps.setInt(9, ven.getId_mon());
            ps.setInt(10, ven.getId_tipo_pago());
            ps.setInt(11, ven.getId_timb());
            ps.setString(12, ven.getRuc_venta());
            ps.setString(13, ven.getNombre_razon_venta());
            ps.setDouble(14, ven.getLiq10_iva_venta());
            ps.setDouble(15, ven.getLiqtotal_iva_venta());
            ps.setDouble(16, ven.getSubtotal_5());
            ps.setDouble(17, ven.getSubtotal_10());
            ps.setDouble(18, ven.getSubtotal_exenta());
            ps.setString(19, ven.getLetras());
            ps.executeUpdate();

            // insert detalle
            String sql1 = "INSERT INTO public.venta_detalle( \n"
                    + " cant_venta_detalle, descripcion_venta_detalle, precio_uni_venta_detalle, \n"
                    + " excenta_venta_detalle, iva5_venta_detalle, iva10_venta_detalle, id_venta, id_producto) \n"
                    + " VALUES (?, ?, ?, ?, ?, ?, (select MAX(id_venta) from venta), ?);";

            for (Venta ventadet : Variables.ventaDet1) {
                ps2 = con.prepareStatement(sql1);

                ps2.setInt(1, ventadet.getCantidad_vd());
                ps2.setString(2, ventadet.getDescrip_vd());
                ps2.setDouble(3, ventadet.getPrecio_uni_vd());
                ps2.setDouble(4, ventadet.getExenta_vd());
                ps2.setDouble(5, ventadet.getIva5_vd());
                ps2.setDouble(6, ventadet.getIva10_vd());
                ps2.setInt(7, ventadet.getId_producto_vd());
                ps2.executeUpdate();

               String sql5 = "UPDATE public.producto\n"
                            + "SET cantidad=cantidad-?\n"
                            + "WHERE id_producto=?";
                    con = cn.getConnection();
                    ps3 = con.prepareStatement(sql5);
                    ps3.setInt(1, ventadet.getCantidad_vd());
                    ps3.setInt(2, ventadet.getId_producto_vd());
                    ps3.executeUpdate();

                
            }
            Variables.ventaDet1.clear();

            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error en insercion registrarVenta ");
            return 0;
        }
    }

    public HashMap seleccionarVenta() {
        HashMap<String, String> dropcompra_det = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT com.id_compra as id_com,comet.descripcion\n"
                    + "FROM compra com\n"
                    + "INNER JOIN compra_detalle comet\n"
                    + "ON comet.id_compra = com.id_compra\n"
                    + "WHERE estado_compra = 'activo'";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                dropcompra_det.put(rs.getString("id_com"), rs.getString("comet.descripcion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ConectaBD.cerrar();
        return dropcompra_det;
    }

    public Venta buscarVenta(String buscartxt) {
        int r = 0;
        Venta ven = new Venta();
        String sql = "SELECT ven.id_venta, ven.nro_factura_venta, ven.ruc_venta, ven.nombre_razon_venta, tp.descripcion_tipo_pago, ven.fecha_registrada_venta, ven.fecha_factura_venta,\n"
                + "ven.total_pagar_venta, ven.liq5_total_iva_venta, ven.liq10_total_iva_venta, ven.liq_total_iva_venta, est.descrip_estado, ven.nombre_usuario_modificacion, \n"
                + "ven.fecha_modificacion, clie.descripcion_cliente, usu.nombre_usuario, cont.codigo_contrato, mon.descripcion_moneda,\n"
                + "tim.nro_timbrado\n"
                + "FROM venta ven\n"
                + "INNER JOIN timbrado tim\n"
                + "ON ven.id_timbrado = tim.id_timbrado\n"
                + "INNER JOIN tipo_pago tp\n"
                + "ON ven.id_tipo_pago= tp.id_tipo_pago \n"
                + "INNER JOIN estado est\n"
                + "USING(id_estado)\n"
                + "INNER JOIN cliente clie\n"
                + "ON ven.id_cliente = clie.id_cliente\n"
                + "INNER JOIN usuario usu\n"
                + "ON ven.id_usuario = usu.id_usuario\n"
                + "INNER JOIN contrato cont\n"
                + "ON ven.id_contrato = cont.id_contrato\n"
                + "INNER JOIN moneda mon\n"
                + "ON ven.id_moneda = mon.id_moneda\n"
                + "WHERE  ven.id_venta= ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(buscartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                ven.setId_venta(rs.getInt("id_venta"));
                ven.setNro_factura_venta(rs.getString("nro_factura_venta"));
                ven.setRuc_venta(rs.getString("ruc_venta"));
                ven.setNombre_razon_venta(rs.getString("nombre_razon_venta"));
                ven.setCondicion_venta(rs.getString("descripcion_tipo_pago"));
                ven.setFecha_registrada_venta(rs.getString("fecha_registrada_venta"));
                ven.setFecha_facturada_venta(rs.getString("fecha_factura_venta"));
                ven.setTotal_pagar_venta(rs.getInt("total_pagar_venta"));
                ven.setLiq5_iva_venta(rs.getInt("liq5_total_iva_venta"));
                ven.setLiq10_iva_venta(rs.getInt("liq10_total_iva_venta"));
                ven.setLiqtotal_iva_venta(rs.getInt("liq_total_iva_venta"));
                ven.setEstado_venta(rs.getString("descrip_estado"));
                ven.setFecha_mod(rs.getString("fecha_modificacion"));
                ven.setDescrip_clie(rs.getString("descripcion_cliente"));
                ven.setDescrip_usu(rs.getString("nombre_usuario"));
                ven.setDescrip_contrato(rs.getString("codigo_contrato"));
                ven.setDescrip_moneda(rs.getString("descripcion_moneda"));
                ven.setNro_timbrado_venta(rs.getString("nro_timbrado"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            ConectaBD.cerrar();
            return ven;
        }
    }

    public ArrayList<Venta> leerVenta() {
        ArrayList<Venta> ventaDet = new ArrayList<>();
        return ventaDet;
    }

    public ArrayList<Venta> leerDetalle(String cod) {
        ArrayList<Venta> venta = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_venta_detalle, cant_venta_detalle, descripcion_venta_detalle, precio_uni_venta_detalle, excenta_venta_detalle, iva5_venta_detalle, iva10_venta_detalle, id_venta, id_impuesto \n"
                    + "	FROM public.venta_detalle \n"
                    + "WHERE id_venta_detalle = " + cod + "");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_vd = rs.getInt("id_venta_detalle");
                    cantidad_vd = rs.getInt("cant_venta_detalle");
                    descrip_vd = rs.getString("descripcion_venta_detalle");
                    precio_uni_vd = rs.getInt("precio_uni_venta_detalle");
                    exenta_vd = rs.getInt("excenta_venta_detalle");
                    iva5_vd = rs.getInt("iva5_venta_detalle");
                    iva10_vd = rs.getInt("iva10_venta_detalle");
                    id_venta = rs.getInt("id_venta");
                    id_producto_vd = rs.getInt("id_impuesto");
                    ventaHallado = new Venta(id_venta, id_vd, cantidad_vd, precio_uni_vd, exenta_vd, iva5_vd, iva10_vd, descrip_vd);
                    venta.add(ventaHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return venta;
            }

        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            return null;
        }
    }

    public Venta leerUnDetalle(String cod) {

        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_venta_detalle, cant_venta_detalle, descripcion_venta_detalle, precio_uni_venta_detalle, excenta_venta_detalle, iva5_venta_detalle, iva10_venta_detalle, id_venta, id_impuesto \n"
                    + "	FROM public.venta_detalle \n"
                    + "  FROM public.venta_detalle\n"
                    + " WHERE id_venta_detalle = " + cod + "");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_vd = rs.getInt("id_venta_detalle");
                    cantidad_vd = rs.getInt("cant_venta_detalle");
                    descrip_vd = rs.getString("descripcion_venta_detalle");
                    precio_uni_vd = rs.getInt("precio_uni_venta_detalle");
                    exenta_vd = rs.getInt("excenta_venta_detalle");
                    iva5_vd = rs.getInt("iva5_venta_detalle");
                    iva10_vd = rs.getInt("iva10_venta_detalle");
                    id_venta = rs.getInt("id_venta");
                    id_producto_vd = rs.getInt("id_impuesto");
                    ventaHallado = new Venta(id_venta, id_vd, cantidad_vd, precio_uni_vd, exenta_vd, iva5_vd, iva10_vd, descrip_vd);
                } while (rs.next());
                ConectaBD.cerrar();
                return ventaHallado;
            }

        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            return null;
        }
    }
    //////////////////////////// Desde aca ////////////////////////////////

    public ArrayList<Venta> leerVentaRe() {
        ArrayList<Venta> venta = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT ven.id_venta, ven.nro_factura_venta, ven.ruc_venta, ven.condicion_venta,\n"
                    + "ven.fecha_registrada_venta, ven.total_pagar_venta, ven.liq5_total_iva_venta,\n"
                    + "ven.liq10_total_iva_venta, ven.liq_total_iva_venta, ven.estado_venta, clie.descripcion_cliente,\n"
                    + "usu.nombre_usuario, cont.codigo_contrato, mon.descripcion_moneda, tim.nro_timbrado\n"
                    + "FROM venta ven \n"
                    + "INNER JOIN timbrado tim \n"
                    + "ON ven.id_timbrado = tim.id_timbrado \n"
                    + "INNER JOIN cliente clie \n"
                    + "ON ven.id_cliente = clie.id_cliente \n"
                    + "INNER JOIN usuario usu \n"
                    + "ON ven.id_usuario = usu.id_usuario \n"
                    + "INNER JOIN contrato cont \n"
                    + "ON ven.id_contrato = cont.id_contrato \n"
                    + "INNER JOIN moneda mon \n"
                    + "ON ven.id_moneda = mon.id_moneda \n"
                    + "WHERE  estado_venta = 'pendiente' \n" ///////agregado para filtrar
                    + "ORDER BY id_venta");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return venta;
            } else {
                do {
                    Variables.id_venta = rs.getInt("id_venta");
                    Variables.nro_factura = rs.getString("nro_factura_venta");
                    ruc_venta = rs.getString("ruc_venta");
                    nombre_razon_venta = rs.getString("descripcion_cliente");
                    condicion_venta = rs.getString("condicion_venta");
                    fecha_registrada_venta = rs.getString("fecha_registrada_venta");
                    total_pagar_venta = rs.getInt("total_pagar_venta");
                    liq5_iva_venta = rs.getInt("liq5_total_iva_venta");
                    liq10_iva_venta = rs.getInt("liq10_total_iva_venta");
                    liqtotal_iva_venta = rs.getInt("liq_total_iva_venta");
                    estado_venta = rs.getString("estado_venta");
                    descrip_contrato = rs.getString("codigo_contrato");
                    descrip_moneda = rs.getString("descripcion_moneda");
                    nro_timbrado_venta = rs.getString("nro_timbrado");
                    ventaHallado = new Venta(Variables.id_venta, total_pagar_venta, liq5_iva_venta, liq10_iva_venta, liqtotal_iva_venta, Variables.nro_factura, ruc_venta, nombre_razon_venta, condicion_venta, fecha_registrada_venta, estado_venta, nro_timbrado_venta, descrip_contrato, descrip_moneda);
                    venta.add(ventaHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return venta;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int anularVentaEstado(Venta ven) {
        int r = 0;
        try {
            con = cn.getConnection();
            String sql = "UPDATE public.venta\n"
                    + "SET estado_venta='anulado', nombre_usuario_modificacion=?, fecha_modificacion=(SELECT CURRENT_DATE)\n"
                    + "WHERE id_venta=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ven.getNom_usu_mod());
            ps.setInt(2, ven.getId_venta());
            ps.executeUpdate();
            ConectaBD.cerrar();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            return 0;
        }
    }

    public Venta actualizarCantidadProducto(int buscartxt) {
        int r = 0;
        Venta ven = new Venta();
        String sql = "SELECT id_venta_detalle, cant_venta_detalle, id_producto\n"
                + "	FROM public.venta_detalle\n"
                + "WHERE id_venta=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, buscartxt);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                int cantidad = rs.getInt("cant_venta_detalle");
                int codigo = rs.getInt("id_producto");

                String sql1 = "UPDATE public.producto\n"
                        + "SET cantidad=cantidad+?\n"
                        + "WHERE id_producto=?";
                con = cn.getConnection();
                ps2 = con.prepareStatement(sql1);
                ps2.setInt(1, cantidad);
                ps2.setInt(2, codigo);
                ps2.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            ConectaBD.cerrar();
            return ven;
        }
    }

//    
////////////////////////IMPRESION DE FACTURA ////////////////////////////
//
//    public Venta getReporte(String ruta, Integer buscar) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//        Connection conexion;
//        Class.forName("org.postgresql.Driver").newInstance();
//        conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TESIS", "postgres", "12345");
//
//        //Se definen los parametros que el reporte necesita
//        Map parameter = new HashMap();
//        parameter.put("id_venta", buscar);
//
//        try {
//            File file = new File(ruta);
//
//            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//
//            httpServletResponse.setContentType("application/pdf");
//            httpServletResponse.addHeader("Content-Type", "application/pdf");
//
//            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());
//
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);
//
//            JRExporter jrExporter = null;
//            jrExporter = new JRPdfExporter();
//            jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//            jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
//
//            if (jrExporter != null) {
//                try {
//                    jrExporter.exportReport();
//                } catch (JRException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (conexion != null) {
//                try {
//                    conexion.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return null;
//    }
    public Venta buscarTimbrado() {
        int r = 0;
        Venta ven = new Venta();
        String sql = "SELECT id_timbrado, nro_timbrado, ini_vigen_timbrado, fin_vigen_timbrado, ultimo_num_timbrado\n"
                + "FROM public.timbrado\n"
                + "WHERE fin_vigen_timbrado<=fin_vigen_timbrado";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                Variables.id_timbrado = rs.getInt("id_timbrado");
                Variables.nro_timbrado = rs.getString("nro_timbrado");
                Variables.fecha_ini_tim = rs.getString("ini_vigen_timbrado");
                Variables.fecha_fin_tim = rs.getString("fin_vigen_timbrado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            return ven;
        }
    }

    public ArrayList<Venta> busquedaPorCliente(String busqueda) {
        ArrayList<Venta> venta = new ArrayList<>();
        String sql = ("SELECT ven.id_venta, ven.nro_factura_venta, ven.ruc_venta, clie.descripcion_cliente, ven.estado_venta,\n"
                + "ven.condicion_venta, ven.fecha_registrada_venta, ven.total_pagar_venta,\n"
                + "ven.liq5_total_iva_venta, ven.liq10_total_iva_venta, ven.liq_total_iva_venta,\n"
                + "usu.nombre_usuario, cont.codigo_contrato, mon.descripcion_moneda, tim.nro_timbrado\n"
                + "FROM venta ven\n"
                + "INNER JOIN timbrado tim\n"
                + "ON ven.id_timbrado = tim.id_timbrado\n"
                + "INNER JOIN cliente clie\n"
                + "ON ven.id_cliente = clie.id_cliente\n"
                + "INNER JOIN usuario usu\n"
                + "ON ven.id_usuario = usu.id_usuario\n"
                + "INNER JOIN contrato cont\n"
                + "ON ven.id_contrato = cont.id_contrato\n"
                + "INNER JOIN moneda mon\n"
                + "ON ven.id_moneda = mon.id_moneda\n"
                + "WHERE clie.descripcion_cliente ILIKE ? \n"
                + "ORDER BY id_venta;");
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + busqueda + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    Variables.id_venta = rs.getInt("id_venta");
                    Variables.nro_factura = rs.getString("nro_factura_venta");
                    ruc_venta = rs.getString("ruc_venta");
                    nombre_razon_venta = rs.getString("descripcion_cliente");
                    condicion_venta = rs.getString("condicion_venta");
                    fecha_registrada_venta = rs.getString("fecha_registrada_venta");
                    total_pagar_venta = rs.getInt("total_pagar_venta");
                    liq5_iva_venta = rs.getInt("liq5_total_iva_venta");
                    liq10_iva_venta = rs.getInt("liq10_total_iva_venta");
                    liqtotal_iva_venta = rs.getInt("liq_total_iva_venta");
                    estado_venta = rs.getString("estado_venta");
                    descrip_contrato = rs.getString("codigo_contrato");
                    descrip_moneda = rs.getString("descripcion_moneda");
                    nro_timbrado_venta = rs.getString("nro_timbrado");
                    ventaHallado = new Venta(Variables.id_venta, total_pagar_venta, liq5_iva_venta, liq10_iva_venta, liqtotal_iva_venta, Variables.nro_factura, ruc_venta, nombre_razon_venta, condicion_venta, fecha_registrada_venta, estado_venta, nro_timbrado_venta, descrip_contrato, descrip_moneda);
                    venta.add(ventaHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return venta;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Venta> busquedaPorNroFactura(String busqueda) {
        ArrayList<Venta> venta = new ArrayList<>();
        String sql = ("SELECT ven.id_venta, ven.nro_factura_venta, ven.ruc_venta, clie.descripcion_cliente, ven.estado_venta,\n"
                + "ven.condicion_venta, ven.fecha_registrada_venta, ven.total_pagar_venta,\n"
                + "ven.liq5_total_iva_venta, ven.liq10_total_iva_venta, ven.liq_total_iva_venta,\n"
                + "usu.nombre_usuario, cont.codigo_contrato, mon.descripcion_moneda, tim.nro_timbrado\n"
                + "FROM venta ven\n"
                + "INNER JOIN timbrado tim\n"
                + "ON ven.id_timbrado = tim.id_timbrado\n"
                + "INNER JOIN cliente clie\n"
                + "ON ven.id_cliente = clie.id_cliente\n"
                + "INNER JOIN usuario usu\n"
                + "ON ven.id_usuario = usu.id_usuario\n"
                + "INNER JOIN contrato cont\n"
                + "ON ven.id_contrato = cont.id_contrato\n"
                + "INNER JOIN moneda mon\n"
                + "ON ven.id_moneda = mon.id_moneda\n"
                + "WHERE ven.nro_factura_venta ILIKE ? \n"
                + "ORDER BY id_venta;");
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + busqueda + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    Variables.id_venta = rs.getInt("id_venta");
                    Variables.nro_factura = rs.getString("nro_factura_venta");
                    ruc_venta = rs.getString("ruc_venta");
                    nombre_razon_venta = rs.getString("descripcion_cliente");
                    condicion_venta = rs.getString("condicion_venta");
                    fecha_registrada_venta = rs.getString("fecha_registrada_venta");
                    total_pagar_venta = rs.getInt("total_pagar_venta");
                    liq5_iva_venta = rs.getInt("liq5_total_iva_venta");
                    liq10_iva_venta = rs.getInt("liq10_total_iva_venta");
                    liqtotal_iva_venta = rs.getInt("liq_total_iva_venta");
                    estado_venta = rs.getString("estado_venta");
                    descrip_contrato = rs.getString("codigo_contrato");
                    descrip_moneda = rs.getString("descripcion_moneda");
                    nro_timbrado_venta = rs.getString("nro_timbrado");
                    ventaHallado = new Venta(Variables.id_venta, total_pagar_venta, liq5_iva_venta, liq10_iva_venta, liqtotal_iva_venta, Variables.nro_factura, ruc_venta, nombre_razon_venta, condicion_venta, fecha_registrada_venta, estado_venta, nro_timbrado_venta, descrip_contrato, descrip_moneda);
                    venta.add(ventaHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return venta;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Venta> busquedaPorFecha(String fecha, String fecha2) {
        ArrayList<Venta> venta = new ArrayList<>();
        String sql = ("SELECT ven.id_venta, ven.nro_factura_venta, ven.ruc_venta, clie.descripcion_cliente, ven.estado_venta, \n"
                + "ven.condicion_venta, ven.fecha_registrada_venta, ven.total_pagar_venta, \n"
                + "ven.liq5_total_iva_venta, ven.liq10_total_iva_venta, ven.liq_total_iva_venta, \n"
                + "usu.nombre_usuario, cont.codigo_contrato, mon.descripcion_moneda, tim.nro_timbrado \n"
                + "FROM venta ven \n"
                + "INNER JOIN timbrado tim \n"
                + "ON ven.id_timbrado = tim.id_timbrado \n"
                + "INNER JOIN cliente clie \n"
                + "ON ven.id_cliente = clie.id_cliente \n"
                + "INNER JOIN usuario usu \n"
                + "ON ven.id_usuario = usu.id_usuario \n"
                + "INNER JOIN contrato cont \n"
                + "ON ven.id_contrato = cont.id_contrato \n"
                + "INNER JOIN moneda mon \n"
                + "ON ven.id_moneda = mon.id_moneda \n"
                + "WHERE ven.fecha_registrada_venta between ? and ? \n"
                + "ORDER BY id_venta;");
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            ps.setString(2, fecha2);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    Variables.id_venta = rs.getInt("id_venta");
                    Variables.nro_factura = rs.getString("nro_factura_venta");
                    ruc_venta = rs.getString("ruc_venta");
                    nombre_razon_venta = rs.getString("descripcion_cliente");
                    condicion_venta = rs.getString("condicion_venta");
                    fecha_registrada_venta = rs.getString("fecha_registrada_venta");
                    total_pagar_venta = rs.getInt("total_pagar_venta");
                    liq5_iva_venta = rs.getInt("liq5_total_iva_venta");
                    liq10_iva_venta = rs.getInt("liq10_total_iva_venta");
                    liqtotal_iva_venta = rs.getInt("liq_total_iva_venta");
                    estado_venta = rs.getString("estado_venta");
                    descrip_contrato = rs.getString("codigo_contrato");
                    descrip_moneda = rs.getString("descripcion_moneda");
                    nro_timbrado_venta = rs.getString("nro_timbrado");
                    ventaHallado = new Venta(Variables.id_venta, total_pagar_venta, liq5_iva_venta, liq10_iva_venta, liqtotal_iva_venta, Variables.nro_factura, ruc_venta, nombre_razon_venta, condicion_venta, fecha_registrada_venta, estado_venta, nro_timbrado_venta, descrip_contrato, descrip_moneda);
                    venta.add(ventaHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return venta;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    //////////////////////// COBRO /////////////////////////////////////////////
    public ArrayList<Venta> leerVentaCobro() {
        ArrayList<Venta> venta = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT ven.id_venta, ven.nro_factura_venta, ven.ruc_venta, ven.nombre_razon_venta, ven.condicion_venta, ven.fecha_factura_venta,\n"
                    + "ven.total_pagar_venta, ven.estado_venta, cont.codigo_contrato\n"
                    + "FROM public.venta ven\n"
                    + "INNER JOIN contrato cont\n"
                    + "ON ven.id_contrato = cont.id_contrato\n"
                    + "WHERE estado_venta = 'pendiente'\n"
                    + "ORDER BY ven.id_venta");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return venta;
            } else {
                do {
                    Variables.id_venta = rs.getInt("id_venta");
                    nro_factura_venta = rs.getString("nro_factura_venta");
                    ruc_venta = rs.getString("ruc_venta");
                    nombre_razon_venta = rs.getString("nombre_razon_venta");
                    condicion_venta = rs.getString("condicion_venta");
                    fecha_facturada_venta = rs.getString("fecha_factura_venta");
                    total_pagar_venta = rs.getInt("total_pagar_venta");
                    estado_venta = rs.getString("estado_venta");
                    descrip_contrato = rs.getString("codigo_contrato");
                    ventaHallado = new Venta(Variables.id_venta, total_pagar_venta, nro_factura_venta, ruc_venta, nombre_razon_venta, condicion_venta, fecha_facturada_venta, estado_venta, descrip_contrato);
                    venta.add(ventaHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return venta;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    //////////////////////////////////////////// LEER CLIENTE ///////////////////////////////////////////
//    public ArrayList<Cliente> leerClienteAc() {
//        ArrayList<Cliente> cliente = new ArrayList<>();
//        try {
//            con = ConectaBD.abrir();
//            stm = con.createStatement();
//            rs = stm.executeQuery("SELECT clie.id_cliente, clie.descripcion_cliente, clie.nro_documento_cliente, clie.telefono_cliente, \n"
//                    + "clie.email_cliente, clie.estado_cliente, clie.nombre_usuario_modificacion, bar.descripcion_barrio, clie.direccion_cliente \n"
//                    + "FROM cliente clie \n"
//                    + "INNER JOIN barrio bar \n"
//                    + "ON clie.id_barrio = bar.id_barrio \n"
//                    + "WHERE clie.estado_cliente = 'activo' \n"
//                    + "ORDER BY id_cliente");
//            if (!rs.next()) {
//                System.out.println("No se encontro el registro");
//                ConectaBD.cerrar();
//                return cliente;
//            } else {
//                do {
//                    id_clie = rs.getInt("id_cliente");
//                    desc_clie = rs.getString("descripcion_cliente");
//                    nro_doc_clie = rs.getString("nro_documento_cliente");
//                    tel_clie = rs.getString("telefono_cliente");
//                    email_clie = rs.getString("email_cliente");
//                    estado_clie = rs.getString("estado_cliente");
//                    desc_bar = rs.getString("descripcion_barrio");
//                    dir_clie = rs.getString("direccion_cliente");
//                    clienteHallado = new Cliente(id_clie, desc_clie, nro_doc_clie, tel_clie, email_clie, dir_clie, estado_clie, desc_bar);
//                    cliente.add(clienteHallado);
//                } while (rs.next());
//                ConectaBD.cerrar();
//                return cliente;
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error en la base de datos");
//            e.printStackTrace();
//            return null;
//        }
//    }
}
