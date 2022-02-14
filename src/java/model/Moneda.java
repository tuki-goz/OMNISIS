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
import java.util.HashMap;

/**
 *
 * @author Francisca Gómez
 */
public class Moneda implements ValidarMoneda {

    //CONSTRUCTORES - SET - GET
    int id_moneda, coti_compra_actual_moneda, coti_venta_actual_moneda;
    String desc_moneda, estado_moneda, nom_usu_mod, fecha_mon;

    public Moneda() {
    }

    public Moneda(int id_moneda, int coti_compra_actual_moneda, int coti_venta_actual_moneda, String desc_moneda, String estado_moneda, String nom_usu_mod) {
        this.id_moneda = id_moneda;
        this.coti_compra_actual_moneda = coti_compra_actual_moneda;
        this.coti_venta_actual_moneda = coti_venta_actual_moneda;
        this.desc_moneda = desc_moneda;
        this.estado_moneda = estado_moneda;
        this.nom_usu_mod = nom_usu_mod;
    }

    public Moneda(int id_moneda, String fecha_mon, int coti_compra_actual_moneda, int coti_venta_actual_moneda, String desc_moneda, String estado_moneda) {
        this.id_moneda = id_moneda;
        this.fecha_mon = fecha_mon;
        this.coti_compra_actual_moneda = coti_compra_actual_moneda;
        this.coti_venta_actual_moneda = coti_venta_actual_moneda;
        this.desc_moneda = desc_moneda;
        this.estado_moneda = estado_moneda;
    }

    public String getFecha_mon() {
        return fecha_mon;
    }

    public void setFecha_mon(String fecha_mon) {
        this.fecha_mon = fecha_mon;
    }

    public int getId_moneda() {
        return id_moneda;
    }

    public void setId_moneda(int id_moneda) {
        this.id_moneda = id_moneda;
    }

    public int getCoti_compra_actual_moneda() {
        return coti_compra_actual_moneda;
    }

    public void setCoti_compra_actual_moneda(int coti_compra_actual_moneda) {
        this.coti_compra_actual_moneda = coti_compra_actual_moneda;
    }

    public int getCoti_venta_actual_moneda() {
        return coti_venta_actual_moneda;
    }

    public void setCoti_venta_actual_moneda(int coti_venta_actual_moneda) {
        this.coti_venta_actual_moneda = coti_venta_actual_moneda;
    }

    public String getDesc_moneda() {
        return desc_moneda;
    }

    public void setDesc_moneda(String desc_moneda) {
        this.desc_moneda = desc_moneda;
    }

    public String getEstado_moneda() {
        return estado_moneda;
    }

    public void setEstado_moneda(String estado_moneda) {
        this.estado_moneda = estado_moneda;
    }

    public String getNom_usu_mod() {
        return nom_usu_mod;
    }

    public void setNom_usu_mod(String nom_usu_mod) {
        this.nom_usu_mod = nom_usu_mod;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Moneda monedaHallada;

    @Override
    public int registrarMoneda(Moneda mon) {
        int r = 0;
        String sql = "INSERT INTO public.moneda(\n"
                + "descripcion_moneda, fecha, cotizacion_compra_actual_moneda, \n"
                + "cotizacion_venta_actual_moneda, estado_moneda, nombre_usuario_modificacion, fecha_modificacion)\n"
                + "VALUES (?, (SELECT current_date), ?, ?, ?, ?, (SELECT current_date));";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, mon.getDesc_moneda());
            ps.setInt(2, mon.getCoti_compra_actual_moneda());
            ps.setInt(3, mon.getCoti_venta_actual_moneda());
            ps.setString(4, mon.getEstado_moneda());
            ps.setString(5, mon.getNom_usu_mod());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public HashMap seleccionarMoneda() {
        HashMap<String, String> dropmon_mon = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_moneda as id_mon,descripcion_moneda\n"
                    + "FROM public.moneda;";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                dropmon_mon.put(Variables.id_moneda = rs.getString("id_mon"), rs.getString("descripcion_moneda"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dropmon_mon;
    }

    public ArrayList<Moneda> buscarMoneda(String buscartxt) {
        ArrayList<Moneda> moneda = new ArrayList<>();
        String sql = "SELECT id_moneda, descripcion_moneda, fecha, cotizacion_compra_actual_moneda, cotizacion_venta_actual_moneda, \n"
                + "estado_moneda\n"
                + "FROM public.moneda\n"
                + "WHERE estado_moneda='activo'\n"
                + "AND descripcion_moneda ILIKE ?\n"
                + "ORDER BY id_moneda;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return moneda;
            } else {
                do {
                    id_moneda = rs.getInt("id_moneda");
                    fecha_mon = rs.getString("fecha");
                    coti_compra_actual_moneda = rs.getInt("cotizacion_compra_actual_moneda");
                    coti_venta_actual_moneda = rs.getInt("cotizacion_venta_actual_moneda");
                    desc_moneda = rs.getString("descripcion_moneda");
                    estado_moneda = rs.getString("estado_moneda");
                    monedaHallada = new Moneda(id_moneda, fecha_mon, coti_compra_actual_moneda, coti_venta_actual_moneda, desc_moneda, estado_moneda);
                    moneda.add(monedaHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                return moneda;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int modificarMoneda(Moneda mon) {
        int r = 0;
        String sql = "UPDATE public.moneda\n"
                + "SET  descripcion_moneda=?, cotizacion_compra_actual_moneda=?, cotizacion_venta_actual_moneda=?, \n"
                + "estado_moneda=?, nombre_usuario_modificacion=?, fecha_modificacion=(SELECT current_date)\n"
                + "WHERE id_moneda=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, mon.getDesc_moneda());
            ps.setInt(2, mon.getCoti_compra_actual_moneda());
            ps.setInt(3, mon.getCoti_venta_actual_moneda());
            ps.setString(4, mon.getEstado_moneda());
            ps.setString(5, mon.getNom_usu_mod());
            ps.setInt(6, mon.getId_moneda());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Moneda> leerMonedaAc() {
        ArrayList<Moneda> moneda = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_moneda, descripcion_moneda, fecha, cotizacion_compra_actual_moneda, cotizacion_venta_actual_moneda, \n"
                    + "estado_moneda\n"
                    + "FROM public.moneda\n"
                    + "WHERE estado_moneda='activo'\n"
                    + "ORDER BY id_moneda;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return moneda;
            } else {
                do {
                    id_moneda = rs.getInt("id_moneda");
                    fecha_mon = rs.getString("fecha");
                    coti_compra_actual_moneda = rs.getInt("cotizacion_compra_actual_moneda");
                    coti_venta_actual_moneda = rs.getInt("cotizacion_venta_actual_moneda");
                    desc_moneda = rs.getString("descripcion_moneda");
                    estado_moneda = rs.getString("estado_moneda");
                    monedaHallada = new Moneda(id_moneda, fecha_mon, coti_compra_actual_moneda, coti_venta_actual_moneda, desc_moneda, estado_moneda);
                    moneda.add(monedaHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                return moneda;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Moneda editarMoneda(String editartxt) {
        int r = 0;
        Moneda mon = new Moneda();
        String sql = "SELECT id_moneda, descripcion_moneda, fecha, cotizacion_compra_actual_moneda, cotizacion_venta_actual_moneda, \n"
                + "estado_moneda\n"
                + "FROM public.moneda\n"
                + "WHERE id_moneda = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                mon.setId_moneda(rs.getInt("id_moneda"));
                mon.setDesc_moneda(rs.getString("descripcion_moneda"));
                mon.setFecha_mon(rs.getString("fecha"));
                mon.setCoti_compra_actual_moneda(rs.getInt("cotizacion_compra_actual_moneda"));
                mon.setCoti_venta_actual_moneda(rs.getInt("cotizacion_venta_actual_moneda"));
                mon.setEstado_moneda(rs.getString("estado_moneda"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");
        } finally {
            ConectaBD.cerrar();
            return mon;
        }
    }

    public int cambiarInactivo(Moneda mon) {
        String sql = "UPDATE moneda\n"
                + "SET estado_moneda='inactivo'\n"
                + "WHERE id_moneda = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, mon.getId_moneda());
            rs = ps.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
