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
public class Ciudad implements ValidarCiudad {

    //CONSTRUCTORES - SET - GET
    int id_ciu, id_dep;
    String descripcion_ciu, desc_dep, estado_ciu;

    public Ciudad() {
    }

    public Ciudad(int id_ciu, int id_dep, String descripcion_ciu) {
        this.id_ciu = id_ciu;
        this.id_dep = id_dep;
        this.descripcion_ciu = descripcion_ciu;
    }

    public Ciudad(int id_ciu, String descripcion_ciu, String desc_dep, String estado_ciu) {
        this.id_ciu = id_ciu;
        this.descripcion_ciu = descripcion_ciu;
        this.desc_dep = desc_dep;
        this.estado_ciu = estado_ciu;
    }

    public String getEstado_ciu() {
        return estado_ciu;
    }

    public void setEstado_ciu(String estado_ciu) {
        this.estado_ciu = estado_ciu;
    }

    public String getDesc_dep() {
        return desc_dep;
    }

    public void setDesc_dep(String desc_dep) {
        this.desc_dep = desc_dep;
    }

    public int getId_ciu() {
        return id_ciu;
    }

    public void setId_ciu(int id_ciu) {
        this.id_ciu = id_ciu;
    }

    public int getId_dep() {
        return id_dep;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }

    public String getDescripcion_ciu() {
        return descripcion_ciu;
    }

    public void setDescripcion_ciu(String descripcion_ciu) {
        this.descripcion_ciu = descripcion_ciu;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Ciudad ciudadHallada;

    @Override
    public int registrarCiudad(Ciudad ciu) {
        int r = 0;
        String sql = "INSERT INTO public.ciudad(\n"
                + "	descripcion_ciudad, id_departamento, estado_ciudad)\n"
                + "	VALUES (?, ?, ?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ciu.getDescripcion_ciu());
            ps.setInt(2, ciu.getId_dep());
            ps.setString(3, ciu.getEstado_ciu());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public HashMap seleccionarCiudad() {
        HashMap<String, String> drop_ciu = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_ciudad as id_c,descripcion_ciudad\n"
                    + "	FROM public.ciudad;";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_ciu.put(rs.getString("id_c"), rs.getString("descripcion_ciudad"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_ciu;
    }

    public int modificarCiudad(Ciudad ciu) {
        int r = 0;
        String sql = "UPDATE public.ciudad\n"
                + "SET descripcion_ciudad=?, estado_ciudad=?, id_departamento=?\n"
                + "WHERE id_ciudad=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ciu.getDescripcion_ciu());
            ps.setString(2, ciu.getEstado_ciu());
            ps.setInt(3, ciu.getId_dep());
            ps.setInt(4, ciu.getId_ciu());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Ciudad> leerCiudadAc() {
        ArrayList<Ciudad> ciudad = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT ciu.id_ciudad, ciu.descripcion_ciudad, ciu.estado_ciudad, dep.descripcion_departamento\n"
                    + "FROM public.ciudad ciu\n"
                    + "INNER JOIN departamento dep\n"
                    + "ON ciu.id_departamento = dep.id_departamento\n"
                    + "WHERE estado_ciudad='activo'\n"
                    + "ORDER BY id_ciudad");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return ciudad;
            } else {
                do {
                    id_ciu = rs.getInt("id_ciudad");
                    descripcion_ciu = rs.getString("descripcion_ciudad");
                    estado_ciu = rs.getString("estado_ciudad");
                    desc_dep = rs.getString("descripcion_departamento");
                    ciudadHallada = new Ciudad(id_ciu, descripcion_ciu, desc_dep, estado_ciu);
                    ciudad.add(ciudadHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return ciudad;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Ciudad> buscarCiudad(String buscartxt) {
        ArrayList<Ciudad> ciudad = new ArrayList<>();
        String sql = "SELECT ciu.id_ciudad, ciu.descripcion_ciudad, ciu.estado_ciudad, dep.descripcion_departamento\n"
                + "FROM public.ciudad ciu\n"
                + "INNER JOIN departamento dep\n"
                + "ON ciu.id_departamento = dep.id_departamento\n"
                + "WHERE estado_ciudad='activo'\n"
                + "AND descripcion_ciudad ILIKE ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return ciudad;
            } else {
                do {
                    id_ciu = rs.getInt("id_ciudad");
                    descripcion_ciu = rs.getString("descripcion_ciudad");
                    estado_ciu = rs.getString("estado_ciudad");
                    desc_dep = rs.getString("descripcion_departamento");
                    ciudadHallada = new Ciudad(id_ciu, descripcion_ciu, desc_dep, estado_ciu);
                    ciudad.add(ciudadHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                return ciudad;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Ciudad editarCiudad(String editartxt) {
        int r = 0;
        Ciudad ciu = new Ciudad();
        String sql = "SELECT ciu.id_ciudad, ciu.descripcion_ciudad, ciu.estado_ciudad, dep.descripcion_departamento\n"
                + "FROM public.ciudad ciu\n"
                + "INNER JOIN departamento dep\n"
                + "ON ciu.id_departamento = dep.id_departamento\n"
                + "WHERE id_ciudad = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                ciu.setId_ciu(rs.getInt("id_ciudad"));
                ciu.setDescripcion_ciu(rs.getString("descripcion_ciudad"));
                ciu.setEstado_ciu(rs.getString("estado_ciudad"));
                ciu.setDesc_dep(rs.getString("descripcion_departamento"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");

        } finally {

            ConectaBD.cerrar();
            return ciu;

        }
    }

    public int cambiarInactivo(Ciudad ciu) {
        int r = 0;
        String sql = "UPDATE public.ciudad\n"
                + "SET  estado_ciudad='inactivo'\n"
                + "WHERE id_ciudad=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ciu.getId_ciu());
            rs = ps.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int cambiarActivo(Ciudad ciu) {
        int r = 0;
        String sql = "UPDATE public.ciudad\n"
                + "SET  estado_ciudad='activo'\n"
                + "WHERE id_ciudad=?;";
        try {
             con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ciu.getId_ciu());
            rs = ps.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Ciudad> leerCiudadIna() {
        ArrayList<Ciudad> ciudad = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT ciu.id_ciudad, ciu.descripcion_ciudad, ciu.estado_ciudad, dep.descripcion_departamento\n"
                    + "FROM public.ciudad ciu\n"
                    + "INNER JOIN departamento dep\n"
                    + "ON ciu.id_departamento = dep.id_departamento\n"
                    + "WHERE estado_ciudad='inactivo'\n"
                    + "ORDER BY id_ciudad");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return ciudad;
            } else {
                do {
                    id_ciu = rs.getInt("id_ciudad");
                    descripcion_ciu = rs.getString("descripcion_ciudad");
                    estado_ciu = rs.getString("estado_ciudad");
                    desc_dep = rs.getString("descripcion_departamento");
                    ciudadHallada = new Ciudad(id_ciu, descripcion_ciu, desc_dep, estado_ciu);
                    ciudad.add(ciudadHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return ciudad;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
