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
public class Departamento implements ValidarDepartamento {

    //CONSTRUCTORES - SET - GET
    int id_dep, id_pais;
    String descripcion_dep, descripcion_pais, estado_dep;

    public Departamento() {
    }

    public Departamento(int id_dep, int id_pais, String descripcion_dep) {
        this.id_dep = id_dep;
        this.id_pais = id_pais;
        this.descripcion_dep = descripcion_dep;
    }

    public Departamento(int id_dep, String descripcion_dep, String descripcion_pais, String estado_dep) {
        this.id_dep = id_dep;
        this.descripcion_dep = descripcion_dep;
        this.descripcion_pais = descripcion_pais;
        this.estado_dep = estado_dep;
    }

    public int getId_dep() {
        return id_dep;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getDescripcion_dep() {
        return descripcion_dep;
    }

    public void setDescripcion_dep(String descripcion_dep) {
        this.descripcion_dep = descripcion_dep;
    }

    public String getDescripcion_pais() {
        return descripcion_pais;
    }

    public void setDescripcion_pais(String descripcion_pais) {
        this.descripcion_pais = descripcion_pais;
    }

    public String getEstado_dep() {
        return estado_dep;
    }

    public void setEstado_dep(String estado_dep) {
        this.estado_dep = estado_dep;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Departamento departamentoHallado;

    @Override
    public int registrarDepartamento(Departamento dep) {
        int r = 0;
        String sql = "INSERT INTO public.departamento(\n"
                + "	descripcion_departamento, id_pais, estado_departamento)\n"
                + "	VALUES (?, ?, ?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dep.getDescripcion_dep());
            ps.setInt(2, dep.getId_pais());
            ps.setString(3, dep.getEstado_dep());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public HashMap seleccionarDepartamento() {
        HashMap<String, String> drop_depar = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_departamento as id_d,descripcion_departamento\n"
                    + "FROM public.departamento\n"
                    + "ORDER BY id_departamento";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_depar.put(rs.getString("id_d"), rs.getString("descripcion_departamento"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_depar;
    }

    public int modificarDepartamento(Departamento dep) {
        int r = 0;
        String sql = "UPDATE public.departamento\n"
                + "SET descripcion_departamento=?, estado_departamento=?, id_pais=?\n"
                + "WHERE id_departamento=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dep.getDescripcion_dep());
            ps.setString(2, dep.getEstado_dep());
            ps.setInt(3, dep.getId_pais());
            ps.setInt(4, dep.getId_dep());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Departamento> leerDepartamentoAc() {
        ArrayList<Departamento> departamento = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT dep.id_departamento, dep.descripcion_departamento, dep.estado_departamento, pais.descripcion_pais\n"
                    + "FROM public.departamento dep\n"
                    + "INNER JOIN pais pais\n"
                    + "ON dep.id_pais = pais.id_pais\n"
                    + "WHERE estado_departamento='activo'\n"
                    + "ORDER BY id_departamento");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                Variables.nohayRegistro = 0;
                ConectaBD.cerrar();
                return departamento;
            } else {
                do {
                    id_dep = rs.getInt("id_departamento");
                    descripcion_dep = rs.getString("descripcion_departamento");
                    descripcion_pais = rs.getString("descripcion_pais");
                    estado_dep = rs.getString("estado_departamento");
                    departamentoHallado = new Departamento(id_dep, descripcion_dep, descripcion_pais, estado_dep);
                    departamento.add(departamentoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return departamento;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Departamento> buscarDepartamento(String buscartxt) {
        ArrayList<Departamento> departamento = new ArrayList<>();
        String sql = "SELECT  dep.id_departamento, dep.descripcion_departamento, dep.estado_departamento, pais.descripcion_pais\n"
                + "FROM public.departamento dep\n"
                + "INNER JOIN pais pais\n"
                + "ON dep.id_pais = pais.id_pais\n"
                + "WHERE estado_departamento='activo'\n"
                + "AND descripcion_departamento ILIKE ?\n"
                + "ORDER BY id_departamento;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return departamento;
            } else {
                do {
                    id_dep = rs.getInt("id_departamento");
                    descripcion_dep = rs.getString("descripcion_departamento");
                    descripcion_pais = rs.getString("descripcion_pais");
                    estado_dep = rs.getString("estado_departamento");
                    departamentoHallado = new Departamento(id_dep, descripcion_dep, descripcion_pais, estado_dep);
                    departamento.add(departamentoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return departamento;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Departamento editarDepartamento(String editartxt) {
        int r = 0;
        Departamento dep = new Departamento();
        String sql = "SELECT dep.id_departamento, dep.descripcion_departamento, dep.estado_departamento, pais.descripcion_pais\n"
                + "FROM public.departamento dep\n"
                + "INNER JOIN pais pais\n"
                + "ON dep.id_pais = pais.id_pais\n"
                + "WHERE id_departamento = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                dep.setId_dep(rs.getInt("id_departamento"));
                dep.setDescripcion_dep(rs.getString("descripcion_departamento"));
                dep.setEstado_dep(rs.getString("estado_departamento"));
                dep.setDescripcion_pais(rs.getString("descripcion_pais"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");

        } finally {

            ConectaBD.cerrar();
            return dep;

        }
    }

    public int cambiarInactivo(Departamento dep) {
        int r = 0;
        String sql = "UPDATE public.departamento\n"
                + "SET  estado_departamento='inactivo'\n"
                + "WHERE id_departamento=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dep.getId_dep());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int cambiarActivo(Departamento dep) {
        int r = 0;
        String sql = "UPDATE public.departamento\n"
                + "	SET  estado_departamento='activo'\n"
                + "	WHERE id_departamento=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dep.getId_dep());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Departamento> leerDepartamentoIna() {
        ArrayList<Departamento> departamento = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT dep.id_departamento, dep.descripcion_departamento, dep.estado_departamento, pais.descripcion_pais\n"
                    + "FROM public.departamento dep\n"
                    + "INNER JOIN pais pais\n"
                    + "ON dep.id_pais = pais.id_pais\n"
                    + "WHERE estado_departamento='inactivo'\n"
                    + "ORDER BY id_departamento");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return departamento;
            } else {
                do {
                    id_dep = rs.getInt("id_departamento");
                    descripcion_dep = rs.getString("descripcion_departamento");
                    descripcion_pais = rs.getString("descripcion_pais");
                    estado_dep = rs.getString("estado_departamento");
                    departamentoHallado = new Departamento(id_dep, descripcion_dep, descripcion_pais, estado_dep);
                    departamento.add(departamentoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return departamento;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
