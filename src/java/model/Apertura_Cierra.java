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

/**
 *
 * @author Francisca Gómez
 */
public class Apertura_Cierra implements ValidarApertura_Cierre {

    //CONSTRUCTORES - SET - GET
    int id_aper_cie, monto_apertura_aper_cie, monto_cierre_aper_cie, id_usu, id_caja;
    String fecha_aper_cie, estado_aper_cie, nom_usu_mod, fecha_mod, nombre_usuario;
    Double monto_trans, monto_tar, monto_cheq;

    public Apertura_Cierra() {
    }

    public Apertura_Cierra(int id_aper_cie, int monto_apertura_aper_cie, int monto_cierre_aper_cie, int id_usu, int id_caja, String fecha_aper_cie, String estado_aper_cie, String nom_usu_mod, String fecha_mod) {
        this.id_aper_cie = id_aper_cie;
        this.monto_apertura_aper_cie = monto_apertura_aper_cie;
        this.monto_cierre_aper_cie = monto_cierre_aper_cie;
        this.id_usu = id_usu;
        this.id_caja = id_caja;
        this.fecha_aper_cie = fecha_aper_cie;
        this.estado_aper_cie = estado_aper_cie;
        this.nom_usu_mod = nom_usu_mod;
        this.fecha_mod = fecha_mod;
    }

    public Double getMonto_trans() {
        return monto_trans;
    }

    public void setMonto_trans(Double monto_trans) {
        this.monto_trans = monto_trans;
    }

    public Double getMonto_tar() {
        return monto_tar;
    }

    public void setMonto_tar(Double monto_tar) {
        this.monto_tar = monto_tar;
    }

    public Double getMonto_cheq() {
        return monto_cheq;
    }

    public void setMonto_cheq(Double monto_cheq) {
        this.monto_cheq = monto_cheq;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public int getId_aper_cie() {
        return id_aper_cie;
    }

    public void setId_aper_cie(int id_aper_cie) {
        this.id_aper_cie = id_aper_cie;
    }

    public int getMonto_apertura_aper_cie() {
        return monto_apertura_aper_cie;
    }

    public void setMonto_apertura_aper_cie(int monto_apertura_aper_cie) {
        this.monto_apertura_aper_cie = monto_apertura_aper_cie;
    }

    public int getMonto_cierre_aper_cie() {
        return monto_cierre_aper_cie;
    }

    public void setMonto_cierre_aper_cie(int monto_cierre_aper_cie) {
        this.monto_cierre_aper_cie = monto_cierre_aper_cie;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }

    public String getFecha_aper_cie() {
        return fecha_aper_cie;
    }

    public void setFecha_aper_cie(String fecha_aper_cie) {
        this.fecha_aper_cie = fecha_aper_cie;
    }

    public String getEstado_aper_cie() {
        return estado_aper_cie;
    }

    public void setEstado_aper_cie(String estado_aper_cie) {
        this.estado_aper_cie = estado_aper_cie;
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

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    PreparedStatement ps1;
    ResultSet rs;
    private Statement stm;
    private Caja cajaHallada;

    @Override
    public int registrarApertura(Apertura_Cierra aper_cie) {
        int r = 0;
        String sql = "INSERT INTO public.apertura_cierre_caja(\n"
                + "	hora_apertura, fecha, monto_apertura, estado_apertura_cierre_caja, nombre_usuario_modificacion, fecha_modificacion, id_usuario, id_caja) \n"
                + "	VALUES ( (select current_time), (select current_date),?, 'activo', ?, (select current_date), ?, ?);";
        
        String sql1 = ("UPDATE public.caja \n"
                + "	SET estado_caja = 'activo' \n"
                + "	WHERE id_caja = ? ");

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, aper_cie.getMonto_apertura_aper_cie());
            ps.setString(2, aper_cie.getNom_usu_mod());
            ps.setInt(3, aper_cie.getId_usu());
            ps.setInt(4, aper_cie.getId_caja());
            ps.executeUpdate();

            ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, aper_cie.getId_caja());
            ps1.executeUpdate();
            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            ConectaBD.cerrar();
            return 0;
        }

    }

    public Apertura_Cierra buscarApertura(String buscartxt) {
        int r = 0;
        Apertura_Cierra apertura = new Apertura_Cierra();
        String sql = "SELECT  hora_apertura,  fecha,  monto_apertura, nombre_usuario_modificacion, estado_apertura_cierre_caja\n"
                + "FROM apertura_cierre_caja\n"
                + "WHERE id_caja = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, buscartxt);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                apertura.setEstado_aper_cie(rs.getString("estado_apertura_cierre_caja"));
                apertura.setMonto_apertura_aper_cie(rs.getInt("monto_apertura"));
                apertura.setId_caja(rs.getInt("id_caja"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return apertura;
        }
    }

    public int registrarCierre(Apertura_Cierra aper_cie) {
        int r = 0;
        String sql = "UPDATE public.apertura_cierre_caja\n"
                + "SET hora_cierre=(select current_time),monto_cierre = ?, monto_trans = ?, monto_tarjeta = ?, monto_cheque = ?, estado_apertura_cierre_caja = 'inactivo' \n"
                + "WHERE id_caja = ? \n"
                + "AND TO_DATE(fecha, 'YYYY MM DD') = (select current_date)";
        String sql1 = ("UPDATE public.caja\n"
                + "	SET estado_caja='inactivo'\n"
                + "	WHERE id_caja=?");
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, aper_cie.getMonto_cierre_aper_cie());
            ps.setDouble(2, aper_cie.getMonto_cierre_aper_cie());     /////// AGREGADO PARA EL DETALLE DEL ARQUEO
            ps.setDouble(3, aper_cie.getMonto_tar());     /////// AGREGADO PARA EL DETALLE DEL ARQUEO
            ps.setDouble(4, aper_cie.getMonto_cheq());     /////// AGREGADO PARA EL DETALLE DEL ARQUEO
            ps.setInt(5, aper_cie.getId_caja());
            ps.executeUpdate();

            ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, aper_cie.getId_caja());
            ps1.executeUpdate();
            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            ConectaBD.cerrar();
            return 0;
        }

    }
}
