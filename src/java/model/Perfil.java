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
public class Perfil implements ValidarPerfil {

    //CONSTRUCTORES - SET - GET
    int id_perfil;
    String descrip_perfil, estado_perfil;

    public Perfil(int id_perfil, String descrip_perfil, String estado_perfil) {
        this.id_perfil = id_perfil;
        this.descrip_perfil = descrip_perfil;
        this.estado_perfil = estado_perfil;
    }

    public Perfil() {
    }

    public String getEstado_perfil() {
        return estado_perfil;
    }

    public void setEstado_perfil(String estado_perfil) {
        this.estado_perfil = estado_perfil;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getDescrip_perfil() {
        return descrip_perfil;
    }

    public void setDescrip_perfil(String descrip_perfil) {
        this.descrip_perfil = descrip_perfil;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Perfil perfilHallado;

    @Override
    public int registrarPerfil(Perfil per) {
        int r = 0;
        String sql = "INSERT INTO public.perfil( \n"
                + "descripcion_perfil, estado_perfil) \n"
                + "VALUES (?, ?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getDescrip_perfil());
            ps.setString(2, per.getEstado_perfil());
            ps.executeUpdate();

            return 1;

//            rs = ps.executeQuery();
//            
//            while (rs.next()) {
//                r = r + 1;
//                per.setDescrip_perfil(rs.getString("descripcion_perfil"));
//                per.setEstado_perfil(rs.getString("estado_perfil"));
//            }
//            if (r == 1) {
//                return 1;
//            } else {
//                return 0;
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public HashMap seleccionarPerfil() {
        HashMap<String, String> drop_per = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_perfil as id_per,descripcion_perfil\n"
                    + "FROM public.perfil\n"
                    + "ORDER BY id_perfil";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_per.put(rs.getString("id_per"), rs.getString("descripcion_perfil"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_per;
    }

//    public Perfil buscarPerfil(String buscartxt) {
//        int r = 0;
//        Perfil per = new Perfil();
//        String sql = "SELECT id_perfil, descripcion_perfil\n"
//                + "FROM perfil\n"
//                + "WHERE descripcion_perfil ILIKE ?";
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, buscartxt);
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                r = r + 1;
//                per.setDescrip_perfil(rs.getString("descripcion_perfil"));
//                per.setId_perfil(rs.getInt("id_perfil"));
//            }
//        } catch (Exception e) {
//        } finally {
//            return per;
//        }
//    }
    public int modificarPerfil(Perfil per) {
        int r = 0;
        String sql = "UPDATE public.perfil\n"
                + "SET descripcion_perfil=?\n"
                + "WHERE id_perfil=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getDescrip_perfil());
            ps.setInt(2, per.getId_perfil());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                per.setDescrip_perfil(rs.getString("descripcion_perfil"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Perfil> buscarPerfil(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Perfil p = new Perfil();
        ArrayList<Perfil> perfil = new ArrayList<>();
        String sql = "SELECT id_perfil, descripcion_perfil\n"
                + "FROM perfil \n"
                + "WHERE descripcion_perfil ILIKE ? \n"
                + "  ORDER BY id_perfil";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_perfil = rs.getInt("id_perfil");
                    descrip_perfil = rs.getString("descripcion_perfil");
                    estado_perfil = rs.getString("estado_perfil");
                    perfilHallado = new Perfil(id_perfil, descrip_perfil, estado_perfil);
                    perfil.add(perfilHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return perfil;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Perfil editarPerfil(String editartxt) {
        int r = 0;
        Perfil per = new Perfil();
        String sql = "SELECT id_perfil, descripcion_perfil, estado_perfil\n"
                + "FROM perfil \n"
                + "WHERE id_perfil = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                per.setId_perfil(rs.getInt("id_perfil"));
                per.setDescrip_perfil(rs.getString("descripcion_perfil"));
                per.setEstado_perfil(rs.getString("estado_perfil"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");
        } finally {
            ConectaBD.cerrar();
            return per;
        }
    }

    public ArrayList<Perfil> leerPerfilAc() {
        ArrayList<Perfil> perfil = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_perfil, descripcion_perfil, estado_perfil \n"
                    + "  FROM public.perfil \n"
                    + "  WHERE estado_perfil = 'activo' \n"
                    + "  ORDER BY id_perfil");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return perfil;
            } else {
                do {
                    id_perfil = rs.getInt("id_perfil");
                    descrip_perfil = rs.getString("descripcion_perfil");
                    estado_perfil = rs.getString("estado_perfil");
                    perfilHallado = new Perfil(id_perfil, descrip_perfil, estado_perfil);
                    perfil.add(perfilHallado);
                    Variables.nohayRegistro = 1;
                } while (rs.next());
                ConectaBD.cerrar();
                return perfil;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Perfil> leerPerfilIna() {
        ArrayList<Perfil> perfil = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_perfil, descripcion_perfil, estado_perfil \n"
                    + "FROM public.perfil \n"
                    + "WHERE estado_perfil='inactivo' \n"
                    + "ORDER BY id_perfil");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return perfil;
            } else {
                do {
                    id_perfil = rs.getInt("id_perfil");
                    descrip_perfil = rs.getString("descripcion_perfil");
                    estado_perfil = rs.getString("estado_perfil");
                    perfilHallado = new Perfil(id_perfil, descrip_perfil, estado_perfil);
                    perfil.add(perfilHallado);
                    Variables.nohayRegistro = 1;
                } while (rs.next());
                ConectaBD.cerrar();
                return perfil;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int cambiarActivo(Perfil per) {
        int r = 0;
        String sql = "UPDATE public.perfil \n"
                + "	SET  estado_perfil='activo' \n"
                + "	WHERE id_perfil=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, per.getId_perfil());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                per.setDescrip_perfil(rs.getString("descripcion_perfil"));
                per.setEstado_perfil(rs.getString("estado_perfil"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int cambiarInactivo(Perfil per) {
        int r = 0;
        String sql = "UPDATE public.perfil\n"
                + "	SET  estado_perfil='inactivo'\n"
                + "	WHERE id_perfil=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, per.getId_perfil());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                per.setDescrip_perfil(rs.getString("descripcion_perfil"));
                per.setEstado_perfil(rs.getString("estado_perfil"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
