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
public class Barrio implements ValidarBarrio {

    //CONSTRUCTORES - SET - GET
    int id_barrio, id_ciudad;
    String descripcion_barrio, descripcion_ciudad, estado_bar;

    public Barrio() {
    }

    public Barrio(int id_barrio, String descripcion_barrio, String descripcion_ciudad, String estado_bar) {
        this.id_barrio = id_barrio;
        this.descripcion_barrio = descripcion_barrio;
        this.descripcion_ciudad = descripcion_ciudad;
        this.estado_bar = estado_bar;
    }

    public int getId_barrio() {
        return id_barrio;
    }

    public void setId_barrio(int id_barrio) {
        this.id_barrio = id_barrio;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getDescripcion_barrio() {
        return descripcion_barrio;
    }

    public void setDescripcion_barrio(String descripcion_barrio) {
        this.descripcion_barrio = descripcion_barrio;
    }

    public String getDescripcion_ciudad() {
        return descripcion_ciudad;
    }

    public void setDescripcion_ciudad(String descripcion_ciudad) {
        this.descripcion_ciudad = descripcion_ciudad;
    }

    public String getEstado_bar() {
        return estado_bar;
    }

    public void setEstado_bar(String estado_bar) {
        this.estado_bar = estado_bar;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Barrio barrioHallado;

    @Override
    public int registrarBarrio(Barrio bar) {
        int r = 0;
        String sql = "INSERT INTO public.barrio(\n"
                + "	descripcion_barrio, id_ciudad, estado_barrio)\n"
                + "	VALUES (?, ?, ?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, bar.getDescripcion_barrio());
            ps.setInt(2, bar.getId_ciudad());
            ps.setString(3, bar.getEstado_bar());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public HashMap seleccionarBarrio() {
        HashMap<String, String> drop_bar = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_barrio as id_b,descripcion_barrio\n"
                    + "	FROM public.barrio;";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_bar.put(rs.getString("id_b"), rs.getString("descripcion_barrio"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_bar;
    }

    public ArrayList<Barrio> buscarBarrio(String buscartxt) {
        ArrayList<Barrio> barrio = new ArrayList<>();
        String sql = "SELECT  bar.id_barrio, bar.descripcion_barrio, bar.estado_barrio, ciu.descripcion_ciudad\n"
                + "FROM public.barrio bar\n"
                + "INNER JOIN ciudad ciu\n"
                + "ON bar.id_ciudad = ciu.id_ciudad\n"
                + "WHERE estado_barrio='activo'\n"
                + "AND descripcion_barrio ILIKE ?\n"
                + "ORDER BY id_barrio;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return barrio;
            } else {
                do {
                    id_barrio = rs.getInt("id_barrio");
                    descripcion_barrio = rs.getString("descripcion_barrio");
                    descripcion_ciudad = rs.getString("descripcion_ciudad");
                    estado_bar = rs.getString("estado_barrio");
                    barrioHallado = new Barrio(id_barrio, descripcion_barrio, descripcion_ciudad, estado_bar);
                    barrio.add(barrioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return barrio;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int modificarBarrio(Barrio bar) {
        int r = 0;
        String sql = "UPDATE public.barrio\n"
                + "SET descripcion_barrio=?, id_ciudad=?, estado_barrio=?\n"
                + "WHERE id_barrio=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, bar.getDescripcion_barrio());
            ps.setInt(2, bar.getId_ciudad());
            ps.setString(3, bar.getEstado_bar());
            ps.setInt(4, bar.getId_barrio());
            rs = ps.executeQuery();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Barrio> leerBarrioAc() {
        ArrayList<Barrio> barrio = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT  bar.id_barrio, bar.descripcion_barrio, bar.estado_barrio, ciu.descripcion_ciudad\n"
                    + "FROM public.barrio bar\n"
                    + "INNER JOIN ciudad ciu\n"
                    + "ON bar.id_ciudad = ciu.id_ciudad\n"
                    + "WHERE estado_barrio='activo'\n"
                    + "ORDER BY id_barrio;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return barrio;
            } else {
                do {
                    id_barrio = rs.getInt("id_barrio");
                    descripcion_barrio = rs.getString("descripcion_barrio");
                    descripcion_ciudad = rs.getString("descripcion_ciudad");
                    estado_bar = rs.getString("estado_barrio");
                    barrioHallado = new Barrio(id_barrio, descripcion_barrio, descripcion_ciudad, estado_bar);
                    barrio.add(barrioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return barrio;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Barrio editarBarrio(String editartxt) {
        int r = 0;
        Barrio bar = new Barrio();
        String sql = "SELECT bar.id_barrio, bar.descripcion_barrio, bar.estado_barrio, ciu.descripcion_ciudad\n"
                + "FROM public.barrio bar\n"
                + "INNER JOIN ciudad ciu\n"
                + "ON bar.id_ciudad = ciu.id_ciudad\n"
                + "WHERE id_barrio = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                bar.setId_barrio(rs.getInt("id_barrio"));
                bar.setDescripcion_barrio(rs.getString("descripcion_barrio"));
                bar.setEstado_bar(rs.getString("estado_barrio"));
                bar.setDescripcion_ciudad(rs.getString("descripcion_ciudad"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");

        } finally {

            ConectaBD.cerrar();
            return bar;

        }
    }

    public int cambiarInactivo(Barrio bar) {
        int r = 0;
        String sql = "UPDATE  public.barrio\n"
                + "SET estado_barrio='inactivo'\n"
                + "WHERE id_barrio = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, bar.getId_barrio());
            rs = ps.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int cambiarActivo(Barrio bar) {
        int r = 0;
        String sql = "UPDATE  public.barrio\n"
                + "SET estado_barrio='activo'\n"
                + "WHERE id_barrio = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, bar.getId_barrio());
            rs = ps.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Barrio> leerBarrioIna() {
        ArrayList<Barrio> barrio = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT  bar.id_barrio, bar.descripcion_barrio, bar.estado_barrio, ciu.descripcion_ciudad\n"
                    + "FROM public.barrio bar\n"
                    + "INNER JOIN ciudad ciu\n"
                    + "ON bar.id_ciudad = ciu.id_ciudad\n"
                    + "WHERE estado_barrio='inactivo'\n"
                    + "ORDER BY id_barrio;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return barrio;
            } else {
                do {
                   id_barrio = rs.getInt("id_barrio");
                    descripcion_barrio = rs.getString("descripcion_barrio");
                    descripcion_ciudad = rs.getString("descripcion_ciudad");
                    estado_bar = rs.getString("estado_barrio");
                    barrioHallado = new Barrio(id_barrio, descripcion_barrio, descripcion_ciudad, estado_bar);
                    barrio.add(barrioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return barrio;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
