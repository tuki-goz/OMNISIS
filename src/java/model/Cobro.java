/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Francisca Gómez
 */
public class Cobro implements ValidarCobro {

    //CONSTRUCTORES - SET - GET
    int id_cobro, total_cobro, id_cta_cobrar, id_venta, id_caja, id_cobrod, monto_cobrod, id_fc, id_banco, monto_cheque, id_tp; 
    String descrip_cobro, fecha_cobro, estado_cobro, nom_usu_mod, fecha_mod, descrip_cobrod, nro_cta_cobrar, nro_factura, descrip_caja, descrip_fc, desc_banco, nombre_razon, nro_cobro, ruc, nro_cheque;

    public Cobro() {
    }

    //CABECERA
    public Cobro(int id_cobro, int total_cobro, int id_cta_cobrar, int id_venta, int id_caja, String descrip_cobro, String fecha_cobro, String estado_cobro, String nom_usu_mod, String fecha_mod, String nro_cobro) {
        this.id_cobro = id_cobro;
        this.total_cobro = total_cobro;
        this.id_cta_cobrar = id_cta_cobrar;
        this.id_venta = id_venta;
        this.id_caja = id_caja;
        this.descrip_cobro = descrip_cobro;
        this.fecha_cobro = fecha_cobro;
        this.estado_cobro = estado_cobro;
        this.nom_usu_mod = nom_usu_mod;
        this.fecha_mod = fecha_mod;
        this.nro_cobro = nro_cobro;
    }

    //DETALLE
    public Cobro(int id_cobro, int id_cobrod, int monto_cobrod, int id_fc, String descrip_cobrod) {
        this.id_cobro = id_cobro;
        this.id_cobrod = id_cobrod;
        this.monto_cobrod = monto_cobrod;
        this.id_fc = id_fc;
        this.descrip_cobrod = descrip_cobrod;
    }

    public int getId_tp() {
        return id_tp;
    }

    public void setId_tp(int id_tp) {
        this.id_tp = id_tp;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public int getMonto_cheque() {
        return monto_cheque;
    }

    public void setMonto_cheque(int monto_cheque) {
        this.monto_cheque = monto_cheque;
    }

    public String getNro_cheque() {
        return nro_cheque;
    }

    public void setNro_cheque(String nro_cheque) {
        this.nro_cheque = nro_cheque;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public String getDesc_banco() {
        return desc_banco;
    }

    public void setDesc_banco(String desc_banco) {
        this.desc_banco = desc_banco;
    }

    public String getNro_cobro() {
        return nro_cobro;
    }

    public void setNro_cobro(String nro_cobro) {
        this.nro_cobro = nro_cobro;
    }

    public String getNro_cta_cobrar() {
        return nro_cta_cobrar;
    }

    public void setNro_cta_cobrar(String nro_cta_cobrar) {
        this.nro_cta_cobrar = nro_cta_cobrar;
    }

    public String getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(String nro_factura) {
        this.nro_factura = nro_factura;
    }

    public String getDescrip_caja() {
        return descrip_caja;
    }

    public void setDescrip_caja(String descrip_caja) {
        this.descrip_caja = descrip_caja;
    }

    public String getDescrip_fc() {
        return descrip_fc;
    }

    public void setDescrip_fc(String descrip_fc) {
        this.descrip_fc = descrip_fc;
    }

    public String getNombre_razon() {
        return nombre_razon;
    }

    public void setNombre_razon(String nombre_razon) {
        this.nombre_razon = nombre_razon;
    }

    public int getId_cobro() {
        return id_cobro;
    }

    public void setId_cobro(int id_cobro) {
        this.id_cobro = id_cobro;
    }

    public int getTotal_cobro() {
        return total_cobro;
    }

    public void setTotal_cobro(int total_cobro) {
        this.total_cobro = total_cobro;
    }

    public int getId_cta_cobrar() {
        return id_cta_cobrar;
    }

    public void setId_cta_cobrar(int id_cta_cobrar) {
        this.id_cta_cobrar = id_cta_cobrar;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }

    public int getId_cobrod() {
        return id_cobrod;
    }

    public void setId_cobrod(int id_cobrod) {
        this.id_cobrod = id_cobrod;
    }

    public int getMonto_cobrod() {
        return monto_cobrod;
    }

    public void setMonto_cobrod(int monto_cobrod) {
        this.monto_cobrod = monto_cobrod;
    }

    public int getId_fc() {
        return id_fc;
    }

    public void setId_fc(int id_fc) {
        this.id_fc = id_fc;
    }

    public String getDescrip_cobro() {
        return descrip_cobro;
    }

    public void setDescrip_cobro(String descrip_cobro) {
        this.descrip_cobro = descrip_cobro;
    }

    public String getFecha_cobro() {
        return fecha_cobro;
    }

    public void setFecha_cobro(String fecha_cobro) {
        this.fecha_cobro = fecha_cobro;
    }

    public String getEstado_cobro() {
        return estado_cobro;
    }

    public void setEstado_cobro(String estado_cobro) {
        this.estado_cobro = estado_cobro;
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

    public String getDescrip_cobrod() {
        return descrip_cobrod;
    }

    public void setDescrip_cobrod(String descrip_cobrod) {
        this.descrip_cobrod = descrip_cobrod;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    PreparedStatement ps2;
    PreparedStatement ps3;
    PreparedStatement ps4;
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    ResultSet rs4;
    private Statement stm;
    private Venta cobroHallado;

    @Override
    public int registrarCobro(Cobro cob) {
        try {
            con = cn.getConnection();
            String sql = "INSERT INTO public.cobro( \n"
                    + "	numero_cobro, descripcion_cobro, fecha_cobro, total_cobro, estado_cobro, nombre_usuario_modificacion, fecha_modificacion, id_cuenta_cobrar, id_caja, monto_cheque_cobro, nro_cheque_cobro, fecha_cheque_cobro, id_banco, id_tipo_pago) \n"
                    + "	VALUES (?, ?, ?, ?, ?, ?, (SELECT current_date), ?, ?, ?,?,(SELECT current_date),?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, cob.getNro_cobro());
            ps.setString(2, cob.getDescrip_cobro());
            ps.setString(3, cob.getFecha_cobro());
            ps.setDouble(4, cob.getTotal_cobro());
            ps.setString(5, ("pagado"));
            ps.setString(6, cob.getNom_usu_mod());
            ps.setInt(7, cob.getId_cta_cobrar());
          //  ps.setInt(8, cob.getId_venta());
            ps.setInt(8, cob.getId_caja());
            ps.setInt(9, cob.getMonto_cheque());
            ps.setString(10, cob.getNro_cheque());
            ps.setInt(11, cob.getId_banco());
            ps.setInt(12, cob.getId_tp());

            ps.executeUpdate();

//            // insert detalle
//            String sql1 = "INSERT INTO public.cobro_detalle( \n"
//                    + "	descripcion_cobro_detalle, monto_cobro_d, id_forma_cobro, id_cobro) \n"
//                    + "	VALUES (?, ?, ?, (select MAX(id_cobro) from cobro))";
//
//            ps2 = con.prepareStatement(sql1);
//
//            ps2.setString(1, cob.getDescrip_cobro());
//            ps2.setDouble(2, cob.getTotal_cobro());
//            ps2.setInt(3, 1);
//
//            ps2.executeUpdate();

//            Variables.cobroDet1.clear();

            ///////////////////////////////   ACTUALIZA VENTA ESTADO ///////////////////////////////////////
            String sql2 = "UPDATE public.venta \n"
                    + "	SET  estado_venta= 'pagado' \n"
                    + " WHERE id_venta = ?";

            ps3 = con.prepareStatement(sql2);
//            ps3.setString(1, ("pagado"));
            ps3.setInt(1, cob.getId_venta());

            ps3.executeUpdate();

            ///////////////////////////////   ACTUALIZA CC ESTADO ///////////////////////////////////////          
            String sql3 = "UPDATE public.cuenta_cobrar \n"
                    + "	SET estado_cuenta_cobrar = ? \n"
                    + " WHERE id_cuenta_cobrar = ?";

            ps4 = con.prepareStatement(sql3);
            ps4.setString(1, ("pagado"));
            ps4.setInt(2, cob.getId_cta_cobrar());

            ps4.executeUpdate();
            ///////////////////////////////   ACTUALIZA  ///////////////////////////////////////    
            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    

    public Cobro buscarDatos(int buscartxt) {
        int r = 0;
        Cobro cob = new Cobro();
        String sql = "SELECT cc.numero_cuenta_cobrar, cc.id_cuenta_cobrar, ven.id_venta, ven.nro_factura_venta, ven.nombre_razon_venta, ven.ruc_venta, ven.total_pagar_venta \n"
                + "   FROM public.cuenta_cobrar cc \n"
                + "   INNER JOIN venta ven \n"
                + "   on ven.id_venta = cc.id_venta \n"
                + "   WHERE ven.id_venta = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, buscartxt);
            rs = ps.executeQuery();

            while (rs.next()) {
                r = r + 1;
                cob.setNro_cta_cobrar(rs.getString("numero_cuenta_cobrar"));     ///////////////////// CARGAR TODAS LAS VARIABLES GLOBALES PARA USAR EN COBRO
                cob.setId_cta_cobrar(rs.getInt("id_cuenta_cobrar"));
                cob.setId_venta(rs.getInt("id_venta"));
                cob.setNro_factura(rs.getString("nro_factura_venta"));
                cob.setNombre_razon(rs.getString("nombre_razon_venta"));     ///////////////////// CARGAR TODAS LAS VARIABLES GLOBALES PARA USAR EN COBRO
                cob.setRuc(rs.getString("ruc_venta"));
                cob.setTotal_cobro(rs.getInt("total_pagar_venta"));     ///////////////////// CARGAR TODAS LAS VARIABLES GLOBALES PARA USAR EN COBRO

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return cob;
        }
    }

}
