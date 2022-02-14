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
public class Tiposervicio implements ValidarTipoServicio {
    //CONSTRUCTORES - SET - GET

    int id_tipo_servicio_tecnico;
    String descripcion_tipo_servicio_tecnico, estado_tipo_servicio;

    public Tiposervicio() {
    }

    public Tiposervicio(int id_tipo_servicio_tecnico, String descripcion_tipo_servicio_tecnico, String estado_tipo_servicio) {
        this.id_tipo_servicio_tecnico = id_tipo_servicio_tecnico;
        this.descripcion_tipo_servicio_tecnico = descripcion_tipo_servicio_tecnico;
        this.estado_tipo_servicio = estado_tipo_servicio;
    }

    public int getId_tipo_servicio_tecnico() {
        return id_tipo_servicio_tecnico;
    }

    public void setId_tipo_servicio_tecnico(int id_tipo_servicio_tecnico) {
        this.id_tipo_servicio_tecnico = id_tipo_servicio_tecnico;
    }

    public String getDescripcion_tipo_servicio_tecnico() {
        return descripcion_tipo_servicio_tecnico;
    }

    public void setDescripcion_tipo_servicio_tecnico(String descripcion_tipo_servicio_tecnico) {
        this.descripcion_tipo_servicio_tecnico = descripcion_tipo_servicio_tecnico;
    }

    public String getEstado_tipo_servicio() {
        return estado_tipo_servicio;
    }

    public void setEstado_tipo_servicio(String estado_tipo_servicio) {
        this.estado_tipo_servicio = estado_tipo_servicio;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO 
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Tiposervicio tipo_servicioHallado;

    @Override
    public int registrarTiposervicio(Tiposervicio ts) {
        int r = 0;
        String sql = "INSERT INTO public.tipo_servicio_tecnico(descripcion_tipo_servicio_tecnico, estado_tipo_servicio)\n"
                + "	VALUES (?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ts.getDescripcion_tipo_servicio_tecnico());
            ps.setString(2, ts.getEstado_tipo_servicio());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public HashMap seleccionarTiposervicio() {
        HashMap<String, String> dropts_ts = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_tipo_servicio_tecnico as id_ts,descripcion_tipo_servicio_tecnico\n"
                    + "	FROM public.tipo_servicio_tecnico\n"
                    + " WHERE estado_tipo_servicio = 'activo';";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                dropts_ts.put(rs.getString("id_ts"), rs.getString("descripcion_tipo_servicio_tecnico"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("No anda tu cagda");
        }
        return dropts_ts;
    }

    public ArrayList<Tiposervicio> buscarTipoServicio(String buscartxt) {
        ArrayList<Tiposervicio> tipo_servicio = new ArrayList<>();
        String sql = "SELECT id_tipo_servicio_tecnico, descripcion_tipo_servicio_tecnico, estado_tipo_servicio\n"
                + "FROM public.tipo_servicio_tecnico\n"
                + "WHERE estado_tipo_servicio='activo'\n"
                + "AND descripcion_tipo_servicio_tecnico ILIKE ?\n"
                + "ORDER BY id_tipo_servicio_tecnico;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return tipo_servicio;
            } else {
                do {
                    id_tipo_servicio_tecnico = rs.getInt("id_tipo_servicio_tecnico");
                    descripcion_tipo_servicio_tecnico = rs.getString("descripcion_tipo_servicio_tecnico");
                    estado_tipo_servicio = rs.getString("estado_tipo_servicio");
                    tipo_servicioHallado = new Tiposervicio(id_tipo_servicio_tecnico, descripcion_tipo_servicio_tecnico, estado_tipo_servicio);
                    tipo_servicio.add(tipo_servicioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return tipo_servicio;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int modificarTipoServicio(Tiposervicio ts) {
        int r = 0;
        String sql = "UPDATE public.tipo_servicio_tecnico\n"
                + "SET descripcion_tipo_servicio_tecnico=?, estado_tipo_servicio=?\n"
                + "WHERE id_tipo_servicio_tecnico=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ts.getDescripcion_tipo_servicio_tecnico());
            ps.setString(2, ts.getEstado_tipo_servicio());
            ps.setInt(3, ts.getId_tipo_servicio_tecnico());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Tiposervicio> leerTipoServicioAc() {
        ArrayList<Tiposervicio> tipo_servicio = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_tipo_servicio_tecnico, descripcion_tipo_servicio_tecnico, estado_tipo_servicio\n"
                    + "FROM public.tipo_servicio_tecnico\n"
                    + "WHERE estado_tipo_servicio='activo'\n"
                    + "ORDER BY id_tipo_servicio_tecnico;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return tipo_servicio;
            } else {
                do {
                    id_tipo_servicio_tecnico = rs.getInt("id_tipo_servicio_tecnico");
                    descripcion_tipo_servicio_tecnico = rs.getString("descripcion_tipo_servicio_tecnico");
                    estado_tipo_servicio = rs.getString("estado_tipo_servicio");
                    tipo_servicioHallado = new Tiposervicio(id_tipo_servicio_tecnico, descripcion_tipo_servicio_tecnico, estado_tipo_servicio);
                    tipo_servicio.add(tipo_servicioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return tipo_servicio;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Tiposervicio editarTipoServicio(String editartxt) {
        int r = 0;
        Tiposervicio ts = new Tiposervicio();
        String sql = "SELECT id_tipo_servicio_tecnico, descripcion_tipo_servicio_tecnico, estado_tipo_servicio\n"
                + "FROM public.tipo_servicio_tecnico\n"
                + "WHERE id_tipo_servicio_tecnico= ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                ts.setId_tipo_servicio_tecnico(rs.getInt("id_tipo_servicio_tecnico"));
                ts.setDescripcion_tipo_servicio_tecnico(rs.getString("descripcion_tipo_servicio_tecnico"));
                ts.setEstado_tipo_servicio(rs.getString("estado_tipo_servicio"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");
        } finally {
            ConectaBD.cerrar();
            return ts;
        }
    }

    public int cambiarInactivo(Tiposervicio ts) {
        int r = 0;
        String sql = "UPDATE tipo_servicio_tecnico\n"
                + "SET estado_tipo_servicio='inactivo'\n"
                + "WHERE id_tipo_servicio_tecnico = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ts.getId_tipo_servicio_tecnico());
            rs = ps.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
