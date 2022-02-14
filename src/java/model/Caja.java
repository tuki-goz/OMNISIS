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
public class Caja implements ValidarCaja {

    //CONSTRUCTORES - SET - GET
    int id_caja;
    String desc_caja, estado_caja;

    public Caja(int id_caja, String desc_caja, String estado_caja) {
        this.id_caja = id_caja;
        this.desc_caja = desc_caja;
        this.estado_caja = estado_caja;
    }

    public Caja() {
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }

    public String getDesc_caja() {
        return desc_caja;
    }

    public void setDesc_caja(String desc_caja) {
        this.desc_caja = desc_caja;
    }

    public String getEstado_caja() {
        return estado_caja;
    }

    public void setEstado_caja(String estado_caja) {
        this.estado_caja = estado_caja;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Caja cajaHallada;

    @Override
    public int registrarCaja(Caja caja) {
        int r = 0;
        String sql = "INSERT INTO public.caja(\n"
                + "descripcion_cajero, estado_caja)\n"
                + "VALUES (?, ?);;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, caja.getDesc_caja());
            ps.setString(2, caja.getEstado_caja());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public HashMap seleccionarCaja() {
        HashMap<String, String> drop_caja = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_caja as id_ca,descripcion_cajero\n"
                    + "FROM public.caja;";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_caja.put(rs.getString("id_ca"), rs.getString("descripcion_cajero"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_caja;
    }

    public int modificarCaja(Caja caja) {
        int r = 0;
        String sql = "UPDATE public.caja\n"
                + "SET descripcion_cajero=?, estado_caja=?\n"
                + "WHERE id_caja=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, caja.getDesc_caja());
            ps.setString(2, caja.getEstado_caja());
            ps.setInt(3, caja.getId_caja());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Caja> leerCajaRe() {
        ArrayList<Caja> caja = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_caja, descripcion_cajero, estado_caja\n"
                    + "	FROM public.caja\n"
                    + "	ORDER BY id_caja");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return caja;
            } else {
                do {
                    id_caja = rs.getInt("id_caja");
                    desc_caja = rs.getString("descripcion_cajero");
                    estado_caja = rs.getString("estado_caja");
                    cajaHallada = new Caja(id_caja, desc_caja, estado_caja);
                    caja.add(cajaHallada);
                    Variables.nohayRegistro = 1;
                } while (rs.next());
                ConectaBD.cerrar();
                return caja;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Caja> buscarCaja(String buscartxt) {
        ArrayList<Caja> caja = new ArrayList<>();
        String sql = "SELECT id_caja, descripcion_cajero, estado_caja\n"
                + "FROM public.caja\n"
                + "WHERE descripcion_cajero ILIKE ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return caja;
            } else {
                do {
                    id_caja = rs.getInt("id_caja");
                    desc_caja = rs.getString("descripcion_cajero");
                    estado_caja = rs.getString("estado_caja");
                    cajaHallada = new Caja(id_caja, desc_caja, estado_caja);
                    caja.add(cajaHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                return caja;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Caja editarCaja(String editartxt) {
        int r = 0;
        Caja caja = new Caja();
        String sql = "SELECT id_caja, descripcion_cajero, estado_caja\n"
                + "FROM public.caja\n"
                + "WHERE id_caja = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                caja.setId_caja(rs.getInt("id_caja"));
                caja.setDesc_caja(rs.getString("descripcion_cajero"));
                caja.setEstado_caja(rs.getString("estado_caja"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");
        } finally {
            ConectaBD.cerrar();
            return caja;
        }
    }

}
