/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import encriptar.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
public class Usuario01 implements ValidarUsuario {

//CONSTRUCTORES - SET - GET
    int id_usua, id_per, id_fun;
    String nom_usu, email_usu, clave_usu, estado_usu, nom_usu_mod, descr_per, descr_fun;

    public Usuario01() {
    }

    public Usuario01(int id_usua, int id_per, int id_fun, String nom_usu, String email_usu, String clave_usu, String estado_usu, String nom_usu_mod) {
        this.id_usua = id_usua;
        this.id_per = id_per;
        this.id_fun = id_fun;
        this.nom_usu = nom_usu;
        this.email_usu = email_usu;
        this.clave_usu = clave_usu;
        this.estado_usu = estado_usu;
        this.nom_usu_mod = nom_usu_mod;
    }

// constructor para buscar exclusivo
    public Usuario01(int id_usua, String nom_usu, String email_usu, String clave_usu, String estado_usu, String descr_per, String descr_fun) {
        this.id_usua = id_usua;
        this.nom_usu = nom_usu;
        this.email_usu = email_usu;
        this.clave_usu = clave_usu;
        this.estado_usu = estado_usu;
        this.descr_per = descr_per;
        this.descr_fun = descr_fun;
    }

    public Usuario01(int id_usua, String nom_usu, String estado_usu) {
        this.id_usua = id_usua;
        this.nom_usu = nom_usu;
        this.estado_usu = estado_usu;
    }

    public int getId_usua() {
        return id_usua;
    }

    public void setId_usua(int id_usua) {
        this.id_usua = id_usua;
    }

    public int getId_per() {
        return id_per;
    }

    public void setId_per(int id_per) {
        this.id_per = id_per;
    }

    public int getId_fun() {
        return id_fun;
    }

    public void setId_fun(int id_fun) {
        this.id_fun = id_fun;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getEmail_usu() {
        return email_usu;
    }

    public void setEmail_usu(String email_usu) {
        this.email_usu = email_usu;
    }

    public String getClave_usu() {
        return clave_usu;
    }

    public void setClave_usu(String clave_usu) {
        this.clave_usu = clave_usu;
    }

    public String getEstado_usu() {
        return estado_usu;
    }

    public void setEstado_usu(String estado_usu) {
        this.estado_usu = estado_usu;
    }

    public String getNom_usu_mod() {
        return nom_usu_mod;
    }

    public void setNom_usu_mod(String nom_usu_mod) {
        this.nom_usu_mod = nom_usu_mod;
    }

    public String getDescr_per() {
        return descr_per;
    }

    public void setDescr_per(String descr_per) {
        this.descr_per = descr_per;
    }

    public String getDescr_fun() {
        return descr_fun;
    }

    public void setDescr_fun(String descr_fun) {
        this.descr_fun = descr_fun;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Usuario01 usuarioHallado;

    @Override
    public int registrarUsuario(Usuario01 usu) {
        int r = 0;
        Variables.existe = 0;
        String sql = "INSERT INTO public.usuario(\n"
                + "numero_usuario, nombre_usuario, email_usuario, clave_usuario, estado_usuario, \n"
                + "nombre_usuario_modificacion, fecha_modificacion, id_perfil, id_funcionario, intentos_fallidos)\n"
                + "VALUES ((select MAX(id_usuario + 1) from usuario),?, ?, ?, ?, ?, (SELECT current_date), ?, ?, 0);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNom_usu());
            ps.setString(2, usu.getEmail_usu());
            ps.setString(3, BCrypt.hashpw(usu.getClave_usu(), BCrypt.gensalt(10)));
            ps.setString(4, usu.getEstado_usu());
            ps.setString(5, usu.getNom_usu_mod());
            ps.setInt(6, usu.getId_per());
            ps.setInt(7, usu.getId_fun());
//            ps.setString(8, usu.getNom_usu());
            ps.executeUpdate();
//            while (rs.next()) {
//                r = r + 1;
//                usu.setNom_usu(rs.getString("nombre_usuario"));
//                usu.setEmail_usu(rs.getString("email_usuario"));
//                usu.setClave_usu(rs.getString("clave_usuario"));
//                usu.setEstado_usu(rs.getString("estado_usuario"));
//                usu.setNom_usu_mod(rs.getString("nombre_usuario_modificacion"));
//                usu.setId_per(rs.getInt("id_perfil"));
//                usu.setId_fun(rs.getInt("id_funcionario"));
//                usu.setNom_usu(rs.getString("nombre_completo"));
//            }
//            if (r == 1) {
//                return 1;
//            } else {
//                return 0;
//            }
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Variables.existe = 1;
            return 0;

        }
    }

    public HashMap seleccionarUsuario() {
        HashMap<String, String> drop_usu = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT usu.id_usuario as id_usu, CONCAT(nombre_funcionario,' ',apellido_funcionario) AS nombre_compl\n"
                    + "FROM usuario usu\n"
                    + "INNER JOIN funcionario fun\n"
                    + "ON fun.id_funcionario = usu.id_funcionario\n"
                    + "WHERE estado_usuario = 'activo'";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_usu.put(rs.getString("id_usu"), rs.getString("nombre_compl"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_usu;
    }

    public ArrayList<Usuario01> buscarUsuario01(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Usuario01 usu = new Usuario01();
        ArrayList<Usuario01> usuario01 = new ArrayList<>();

        String sql = "SELECT usu.id_usuario, usu.nombre_usuario, usu.email_usuario, usu.clave_usuario, \n"
                + "usu.estado_usuario, per.descripcion_perfil, fun.nombre_funcionario\n"
                + "FROM usuario usu \n"
                + "INNER JOIN perfil per\n"
                + "ON usu.id_perfil = per.id_perfil \n"
                + "INNER JOIN funcionario fun\n"
                + "ON usu.id_funcionario = fun.id_funcionario\n"
                + "WHERE usu.estado_usuario = 'activo'\n"
                + "and usu.nombre_usuario ilike ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                Variables.mensajeError = 1;
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_usua = rs.getInt("id_usuario");
                    nom_usu = rs.getString("nombre_usuario");
                    email_usu = rs.getString("email_usuario");
                    clave_usu = rs.getString("clave_usuario");
                    estado_usu = rs.getString("estado_usuario");
                    descr_per = rs.getString("descripcion_perfil");
                    descr_fun = rs.getString("nombre_funcionario");
                    usuarioHallado = new Usuario01(id_usua, nom_usu, email_usu, clave_usu, estado_usu, descr_per, descr_fun);
                    usuario01.add(usuarioHallado);
                } while (rs.next());
                Variables.mensajeError = 0;
                ConectaBD.cerrar();
                return usuario01;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Usuario01> buscarUsuario02(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Usuario01 usu = new Usuario01();
        ArrayList<Usuario01> usuario01 = new ArrayList<>();

        String sql = "SELECT usu.id_usuario, usu.nombre_usuario, usu.email_usuario, usu.clave_usuario, \n"
                + "usu.estado_usuario, per.descripcion_perfil, fun.nombre_funcionario \n"
                + "FROM usuario usu \n"
                + "INNER JOIN perfil per \n"
                + "ON usu.id_perfil = per.id_perfil \n"
                + "INNER JOIN funcionario fun \n"
                + "ON usu.id_funcionario = fun.id_funcionario \n"
                + "WHERE usu.estado_usuario = 'inactivo' \n"
                + "and usu.nombre_usuario ilike ? \n"
                //                + "or fun.nombre_funcionario ilike ? \n"
                + "ORDER BY id_usuario";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                Variables.mensajeError = 1;
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_usua = rs.getInt("id_usuario");
                    nom_usu = rs.getString("nombre_usuario");
                    email_usu = rs.getString("email_usuario");
                    clave_usu = rs.getString("clave_usuario");
                    estado_usu = rs.getString("estado_usuario");
                    descr_per = rs.getString("descripcion_perfil");
                    descr_fun = rs.getString("nombre_funcionario");
                    usuarioHallado = new Usuario01(id_usua, nom_usu, email_usu, clave_usu, estado_usu, descr_per, descr_fun);
                    usuario01.add(usuarioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return usuario01;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

//     public Usuario01 buscarUsuario(String buscartxt) {      /////////////////               ORIGNAL
//        int r = 0;
//        Usuario01 usu = new Usuario01();
//        String sql = "SELECT usu.id_usuario, usu.nombre_usuario, usu.email_usuario, usu.clave_usuario,\n"
//                + "usu.estado_usuario, per.descripcion_perfil, fun.nombre_funcionario\n"
//                + "FROM usuario usu\n"
//                + "INNER JOIN perfil per\n"
//                + "ON usu.id_perfil = per.id_perfil\n"
//                + "INNER JOIN funcionario fun\n"
//                + "ON usu.id_funcionario = fun.id_funcionario\n"
//                + "WHERE usu.nombre_usuario =?;";
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, buscartxt);
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                r = r + 1;
//                usu.setId_usua(rs.getInt("id_usuario"));
//                usu.setNom_usu(rs.getString("nombre_usuario"));
//                usu.setEmail_usu(rs.getString("email_usuario"));
//                usu.setClave_usu(rs.getString("clave_usuario"));
//                usu.setDescr_per(rs.getString("descripcion_perfil"));
//                usu.setDescr_fun(rs.getString("nombre_funcionario"));
//                usu.setEstado_usu(rs.getString("estado_usuario"));
//            }
//
//        } catch (Exception e) {
//            System.out.println("hola");
//
//        } finally {
//            return usu;
//        }
//    }
    public int modificarUsuario(Usuario01 usu) {
        int r = 0;
        String sql = "UPDATE public.usuario\n"
                + "SET nombre_usuario=?, email_usuario=?, clave_usuario=?, estado_usuario=?, \n"
                + "nombre_usuario_modificacion=?, fecha_modificacion=(SELECT current_date), id_perfil=?, id_funcionario=?\n"
                + "WHERE id_usuario = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNom_usu());
            ps.setString(2, usu.getEmail_usu());
            ps.setString(3, usu.getClave_usu());
            ps.setString(4, usu.getEstado_usu());
            ps.setString(5, usu.getNom_usu_mod());
            ps.setInt(6, usu.getId_per());
            ps.setInt(7, usu.getId_fun());

            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                usu.setNom_usu(rs.getString("nombre_usuario"));
                usu.setEmail_usu(rs.getString("email_usuario"));
                usu.setClave_usu(rs.getString("clave_usuario"));
                usu.setEstado_usu(rs.getString("estado_usuario"));
                usu.setNom_usu_mod(rs.getString("nombre_usuario_modificacion"));
                usu.setDescr_per(rs.getString("descripcion_perfil"));
                usu.setDescr_fun(rs.getString("nombre_funcionario"));

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

    public Usuario01 editarUsuario01(String editartxt) {
        int r = 0;
        Usuario01 usu = new Usuario01();
        String sql = "SELECT usu.id_usuario, usu.nombre_usuario, usu.email_usuario, usu.clave_usuario,\n"
                + "usu.estado_usuario, per.descripcion_perfil, fun.nombre_funcionario\n"
                + "FROM usuario usu\n"
                + "INNER JOIN perfil per\n"
                + "ON usu.id_perfil = per.id_perfil\n"
                + "INNER JOIN funcionario fun\n"
                + "ON usu.id_funcionario = fun.id_funcionario\n"
                + "WHERE usu.id_usuario =?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));

            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                usu.setId_usua(rs.getInt("id_usuario"));
                usu.setNom_usu(rs.getString("nombre_usuario"));
                usu.setEmail_usu(rs.getString("email_usuario"));
                usu.setClave_usu(rs.getString("clave_usuario"));
                usu.setEstado_usu(rs.getString("estado_usuario"));
                usu.setDescr_per(rs.getString("descripcion_perfil"));
                usu.setDescr_fun(rs.getString("nombre_funcionario"));

            }

        } catch (Exception e) {
            System.out.println("hola");

        } finally {
            return usu;

        }
    }

    public int restablecerUsuario(Usuario01 usu) {
        String sql = "Update usuario \n"
                + "set intentos_fallidos = 0, clave_usuario = '123', estado_usuario = 'activo'\n"
                + "where nombre_usuario = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNom_usu());
            ps.executeUpdate();

            return 1;

        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Usuario01> leerUsuarioAc() {
        ArrayList<Usuario01> usuario = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT usu.id_usuario, usu.nombre_usuario, usu.email_usuario, usu.clave_usuario, \n"
                    + "usu.estado_usuario, per.descripcion_perfil, fun.nombre_funcionario \n"
                    + "FROM usuario usu \n"
                    + "INNER JOIN perfil per \n"
                    + "ON usu.id_perfil = per.id_perfil \n"
                    + "INNER JOIN funcionario fun \n"
                    + "ON usu.id_funcionario = fun.id_funcionario \n"
                    + "WHERE usu.estado_usuario = 'activo' \n"
                    + "ORDER BY id_usuario");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return usuario;
            } else {
                do {
                    id_usua = rs.getInt("id_usuario");
                    nom_usu = rs.getString("nombre_usuario");
                    email_usu = rs.getString("email_usuario");
                    clave_usu = rs.getString("clave_usuario");
                    estado_usu = rs.getString("estado_usuario");
                    descr_per = rs.getString("descripcion_perfil");
                    descr_fun = rs.getString("nombre_funcionario");
                    usuarioHallado = new Usuario01(id_usua, nom_usu, email_usu, clave_usu, estado_usu, descr_per, descr_fun);
                    usuario.add(usuarioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return usuario;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Usuario01> leerUsuarioIna() {
        ArrayList<Usuario01> usuario = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT usu.id_usuario, usu.nombre_usuario, usu.email_usuario, usu.clave_usuario, \n"
                    + "usu.estado_usuario, per.descripcion_perfil, fun.nombre_funcionario \n"
                    + "FROM usuario usu \n"
                    + "INNER JOIN perfil per \n"
                    + "ON usu.id_perfil = per.id_perfil \n"
                    + "INNER JOIN funcionario fun \n"
                    + "ON usu.id_funcionario = fun.id_funcionario \n"
                    + "WHERE usu.estado_usuario = 'inactivo' \n"
                    + "ORDER BY id_usuario");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return usuario;
            } else {
                do {
                    id_usua = rs.getInt("id_usuario");
                    nom_usu = rs.getString("nombre_usuario");
                    email_usu = rs.getString("email_usuario");
                    clave_usu = rs.getString("clave_usuario");
                    estado_usu = rs.getString("estado_usuario");
                    descr_per = rs.getString("descripcion_perfil");
                    descr_fun = rs.getString("nombre_funcionario");
                    usuarioHallado = new Usuario01(id_usua, nom_usu, email_usu, clave_usu, estado_usu, descr_per, descr_fun);
                    usuario.add(usuarioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return usuario;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Usuario01> leerUsuarioTo() {
        ArrayList<Usuario01> usuario = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT usu.id_usuario, usu.nombre_usuario, usu.email_usuario, usu.clave_usuario, \n"
                    + "usu.estado_usuario, per.descripcion_perfil, fun.nombre_funcionario \n"
                    + "FROM usuario usu \n"
                    + "INNER JOIN perfil per \n"
                    + "ON usu.id_perfil = per.id_perfil \n"
                    + "INNER JOIN funcionario fun \n"
                    + "ON usu.id_funcionario = fun.id_funcionario \n"
                    + "ORDER BY id_usuario");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return usuario;
            } else {
                do {
                    id_usua = rs.getInt("id_usuario");
                    nom_usu = rs.getString("nombre_usuario");
                    email_usu = rs.getString("email_usuario");
                    clave_usu = rs.getString("clave_usuario");
                    estado_usu = rs.getString("estado_usuario");
                    descr_per = rs.getString("descripcion_perfil");
                    descr_fun = rs.getString("nombre_funcionario");
                    usuarioHallado = new Usuario01(id_usua, nom_usu, email_usu, clave_usu, estado_usu, descr_per, descr_fun);
                    usuario.add(usuarioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return usuario;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int cambiarActivo(Usuario01 u) {
        int r = 0;
        String sql = "UPDATE public.usuario\n"
                + "SET  estado_usuario='activo'\n"
                + "WHERE id_usuario=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId_usua());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                u.setNom_usu(rs.getString("nombre_usuario"));
                u.setEstado_usu(rs.getString("estado_usuario"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            return 0;
        }
    }

    public int cambiarInactivo(Usuario01 u) {
        int r = 0;
        String sql = "UPDATE public.usuario\n"
                + "SET  estado_usuario='inactivo'\n"
                + "WHERE id_usuario=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId_usua());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                u.setNom_usu(rs.getString("nombre_usuario"));
                u.setEstado_usu(rs.getString("estado_usuario"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            return 0;
        }
    }
}
