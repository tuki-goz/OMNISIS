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
public class Condicion {

    //CONSTRUCTORES - SET - GET
    int id_condicion;
    String descrip_condicion;

    public Condicion() {
    }

    public Condicion(int id_condicion, String descrip_condicion) {
        this.id_condicion = id_condicion;
        this.descrip_condicion = descrip_condicion;
    }

    public int getId_condicion() {
        return id_condicion;
    }

    public void setId_condicion(int id_condicion) {
        this.id_condicion = id_condicion;
    }

    public String getDescrip_condicion() {
        return descrip_condicion;
    }

    public void setDescrip_condicion(String descrip_condicion) {
        this.descrip_condicion = descrip_condicion;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Condicion condicionHallada;

    
    public int registrarCondicion(Condicion fc) {
        int r = 0;
        String sql = "INSERT INTO public.condicion(\n"
                + "descripcion_condicion)\n"
                + "VALUES (?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fc.getDescrip_condicion());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public HashMap seleccionarCondicion() {
        HashMap<String, String> drop_fc = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_condicion as id_fc,descripcion_condicion\n"
                    + "FROM public.condicion;";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_fc.put(rs.getString("id_fc"), rs.getString("descripcion_condicion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_fc;
    }

    public ArrayList<Condicion> buscarCondicion(String buscartxt) {
        ArrayList<Condicion> condicion = new ArrayList<>();
        String sql = "SELECT id_condicion, descripcion_condicion \n"
                + " FROM public.condicion \n"
                + " WHERE descripcion_condicion ILIKE ? \n"
                + " ORDER BY id_condicion;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return condicion;
            } else {
                do {
                    id_condicion = rs.getInt("id_condicion");
                    descrip_condicion = rs.getString("descripcion_condicion");
                    condicionHallada = new Condicion(id_condicion, descrip_condicion);
                    condicion.add(condicionHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                return condicion;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int modificarCondicion(Condicion fc) {
        int r = 0;
        String sql = "UPDATE public.condicion \n"
                + "SET descripcion_condicion = ? \n"
                + "WHERE id_condicion = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fc.getDescrip_condicion());
            ps.setInt(2, fc.getId_condicion());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Condicion> leerCondicion() {
        ArrayList<Condicion> condicion = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_condicion, descripcion_condicion\n"
                    + "FROM public.condicion\n"
                    + "ORDER BY id_condicion;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return condicion;
            } else {
                do {
                    id_condicion = rs.getInt("id_condicion");
                    descrip_condicion = rs.getString("descripcion_condicion");
                    condicionHallada = new Condicion(id_condicion, descrip_condicion);
                    condicion.add(condicionHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                return condicion;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Condicion editarCondicion(String editartxt) {
        int r = 0;
        Condicion fc = new Condicion();
        String sql = "SELECT id_condicion, descripcion_condicion\n"
                + "FROM public.condicion\n"
                + "WHERE id_condicion = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                fc.setId_condicion(rs.getInt("id_condicion"));
                fc.setDescrip_condicion(rs.getString("descripcion_condicion"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");

        } finally {

            ConectaBD.cerrar();
            return fc;

        }
    }
}
