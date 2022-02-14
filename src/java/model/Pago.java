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
public class Pago implements ValidarPago {

    //CABECERA
    int id_pag, id_tp, id_cta_pag, id_caja, total_pago;
    String nro_pag, descrip_pag, fecha_pag, nom_usu_mod, fecha_mod, razon_prov, descrip_cta_pag, descrip_tp;

    //CONSTRUCTOR CABECERA
    public Pago(int id_pag, int id_tp, int id_cta_pag, int id_caja, String nro_pag, String descrip_pag, String fecha_pag, String nom_usu_mod, String fecha_mod) {
        this.id_pag = id_pag;
        this.id_tp = id_tp;
        this.id_cta_pag = id_cta_pag;
        this.id_caja = id_caja;
        this.nro_pag = nro_pag;
        this.descrip_pag = descrip_pag;
        this.fecha_pag = fecha_pag;
        this.nom_usu_mod = nom_usu_mod;
        this.fecha_mod = fecha_mod;
    }
    public String getDescrip_cta_pag() {
        return descrip_cta_pag;
    }

    public void setDescrip_cta_pag(String descrip_cta_pag) {    
        this.descrip_cta_pag = descrip_cta_pag;
    }

    public String getDescrip_tp() {
        return descrip_tp;
    }

    public void setDescrip_tp(String descrip_tp) {
        this.descrip_tp = descrip_tp;
    }

    public Pago(int id_pag, int total_pago, String nro_pag, String descrip_pag, String fecha_pag, String descrip_cta_pag, String descrip_tp) {
        this.id_pag = id_pag;
        this.total_pago = total_pago;
        this.nro_pag = nro_pag;
        this.descrip_pag = descrip_pag;
        this.fecha_pag = fecha_pag;
        this.descrip_cta_pag = descrip_cta_pag;
        this.descrip_tp = descrip_tp;
    }

    
    //CONSTRUCTOR VACIO
    public Pago() {
    }

    //GET Y SET
    
    public int getId_pag() {
        return id_pag;
    }

    public void setId_pag(int id_pag) {
        this.id_pag = id_pag;
    }

    public int getTotal_pago() {
        return total_pago;
    }

    public void setTotal_pago(int total_pago) {
        this.total_pago = total_pago;
    }

    public int getId_tp() {
        return id_tp;
    }

    public void setId_tp(int id_tp) {
        this.id_tp = id_tp;
    }

    public int getId_cta_pag() {
        return id_cta_pag;
    }

    public void setId_cta_pag(int id_cta_pag) {
        this.id_cta_pag = id_cta_pag;
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }

    public String getNro_pag() {
        return nro_pag;
    }

    public void setNro_pag(String nro_pag) {
        this.nro_pag = nro_pag;
    }

    public String getDescrip_pag() {
        return descrip_pag;
    }

    public void setDescrip_pag(String descrip_pag) {
        this.descrip_pag = descrip_pag;
    }

    public String getFecha_pag() {
        return fecha_pag;
    }

    public void setFecha_pag(String fecha_pag) {
        this.fecha_pag = fecha_pag;
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

    public String getRazon_prov() {
        return razon_prov;
    }

    public void setRazon_prov(String razon_prov) {
        this.razon_prov = razon_prov;
    }

    //FUNCIONES REGISTRAR - BUSCAR
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
    private Pago pagoHallado;

    @Override
    public int registrarPago(Pago pag) {
        try {
            con = cn.getConnection();
            String sql = "INSERT INTO public.pago(\n"
                    + "	numero_pago, descripcion_pago, fecha_pago, total_pago, nombre_usuario_modificacion, fecha_modificacion, id_cuenta_pagar, id_caja, id_tipo_pago)\n"
                    + "	VALUES ( ?, ?, ?, ?, ?, (SELECT current_date), ?, ?, ?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, pag.getNro_pag());
            ps.setString(2, pag.getDescrip_pag());
            ps.setString(3, pag.getFecha_pag());
            ps.setInt(4, pag.getTotal_pago());
            ps.setString(5, pag.getNom_usu_mod());
            ps.setInt(6, pag.getId_cta_pag());
            ps.setInt(7, pag.getId_caja());
            ps.setInt(8, pag.getId_tp());
            ps.executeUpdate();

            String sql2 = "UPDATE public.cuenta_pagar\n"
                    + "	SET estado_cuenta_pagar='pagado'\n"
                    + "	WHERE id_cuenta_pagar=?";
            ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, pag.getId_cta_pag());
            ps2.executeUpdate();

            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    public ArrayList<Pago> leerPagoRe() {
        ArrayList<Pago> pago = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT pag.id_pago, pag.numero_pago, pag.descripcion_pago, pag.fecha_pago, pag.total_pago, cta_pag.descripcion_cuenta_pagar,\n"
                    + "tp.descripcion_tipo_pago\n"
                    + "FROM public.pago pag\n"
                    + "INNER JOIN cuenta_pagar cta_pag\n"
                    + "ON cta_pag.id_cuenta_pagar = pag.id_cuenta_pagar\n"
                    + "INNER JOIN tipo_pago tp\n"
                    + "ON tp.id_tipo_pago = pag.id_tipo_pago \n"
                    + "ORDER BY pag.id_pago");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return pago;
            } else {
                do {
                    id_pag = rs.getInt("id_pago");
                    total_pago = rs.getInt("total_pago");
                    nro_pag = rs.getString("numero_pago");
                    descrip_pag = rs.getString("descripcion_pago");
                    fecha_pag = rs.getString("fecha_pago");
                    descrip_cta_pag = rs.getString("descripcion_cuenta_pagar");
                    descrip_tp = rs.getString("descripcion_tipo_pago");
                    pagoHallado = new Pago(id_pag, total_pago, nro_pag, descrip_pag, fecha_pag, descrip_cta_pag, descrip_tp);
                    pago.add(pagoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return pago;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta leerCta_PagarRe");
            e.printStackTrace();
            return null;
        }
    }

}
