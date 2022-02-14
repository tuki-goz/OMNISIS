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
public class Cliente implements ValidarCliente {

    //CONSTRUCTORES - SET - GET
    int id_clie, id_bar;
    String desc_clie, nro_doc_clie, tel_clie, email_clie, nom_usu_mod, dir_clie, estado_clie, desc_bar;

    public Cliente() {
    }

    public Cliente(int id_clie, int id_bar, String desc_clie, String nro_doc_clie, String tel_clie, String email_clie, String nom_usu_mod, String dir_clie) {
        this.id_clie = id_clie;
        this.id_bar = id_bar;
        this.desc_clie = desc_clie;
        this.nro_doc_clie = nro_doc_clie;
        this.tel_clie = tel_clie;
        this.email_clie = email_clie;
        this.nom_usu_mod = nom_usu_mod;
        this.dir_clie = dir_clie;
    }

    public Cliente(int id_clie, String desc_clie, String nro_doc_clie, String tel_clie, String email_clie, String dir_clie, String estado_clie, String desc_bar) {
        this.id_clie = id_clie;
        this.desc_clie = desc_clie;
        this.nro_doc_clie = nro_doc_clie;
        this.tel_clie = tel_clie;
        this.email_clie = email_clie;
        this.dir_clie = dir_clie;
        this.estado_clie = estado_clie;
        this.desc_bar = desc_bar;
    }

    ////////////////////////////////VENTA///////////////////////////////////////
    public Cliente(int id_clie, String desc_clie, String nro_doc_clie) {
        this.id_clie = id_clie;
        this.desc_clie = desc_clie;
        this.nro_doc_clie = nro_doc_clie;
    }

    public Cliente(int id_clie, String desc_clie, String nro_doc_clie, String tel_clie, String dir_clie, String desc_bar) {
        this.id_clie = id_clie;
        this.desc_clie = desc_clie;
        this.nro_doc_clie = nro_doc_clie;
        this.tel_clie = tel_clie;
        this.dir_clie = dir_clie;
        this.desc_bar = desc_bar;
    }
    

    public int getId_clie() {
        return id_clie;
    }

    public void setId_clie(int id_clie) {
        this.id_clie = id_clie;
    }

    public int getId_bar() {
        return id_bar;
    }

    public void setId_bar(int id_bar) {
        this.id_bar = id_bar;
    }

    public String getDesc_clie() {
        return desc_clie;
    }

    public void setDesc_clie(String desc_clie) {
        this.desc_clie = desc_clie;
    }

    public String getNro_doc_clie() {
        return nro_doc_clie;
    }

    public void setNro_doc_clie(String nro_doc_clie) {
        this.nro_doc_clie = nro_doc_clie;
    }

    public String getTel_clie() {
        return tel_clie;
    }

    public void setTel_clie(String tel_clie) {
        this.tel_clie = tel_clie;
    }

    public String getEmail_clie() {
        return email_clie;
    }

    public void setEmail_clie(String email_clie) {
        this.email_clie = email_clie;
    }

    public String getNom_usu_mod() {
        return nom_usu_mod;
    }

    public void setNom_usu_mod(String nom_usu_mod) {
        this.nom_usu_mod = nom_usu_mod;
    }

    public String getDir_clie() {
        return dir_clie;
    }

    public void setDir_clie(String dir_clie) {
        this.dir_clie = dir_clie;
    }

    public String getEstado_clie() {
        return estado_clie;
    }

    public void setEstado_clie(String estado_clie) {
        this.estado_clie = estado_clie;
    }

    public String getDesc_bar() {
        return desc_bar;
    }

    public void setDesc_bar(String desc_bar) {
        this.desc_bar = desc_bar;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Cliente clienteHallado;

    @Override
    public int registrarCliente(Cliente clie) {
        int r = 0;

        try {
            con = cn.getConnection();
            String sql = "INSERT INTO public.cliente(\n"
                    + "descripcion_cliente, nro_documento_cliente, telefono_cliente, email_cliente, estado_cliente, \n"
                    + "nombre_usuario_modificacion, fecha_modificacion, id_barrio, direccion_cliente)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, (SELECT current_date), ?, ?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, clie.getDesc_clie());
            ps.setString(2, clie.getNro_doc_clie());
            ps.setString(3, clie.getTel_clie());
            ps.setString(4, clie.getEmail_clie());
            ps.setString(5, clie.getEstado_clie());
            ps.setString(6, clie.getNom_usu_mod());
            ps.setInt(7, clie.getId_bar());
            ps.setString(8, clie.getDir_clie());
            ps.executeUpdate();

            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public HashMap seleccionarCliente() {
        HashMap<String, String> drop_clie = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_cliente as id_clie,descripcion_cliente\n"
                    + "FROM public.cliente";
            // + "WHERE estado_cliente = 'activo'";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_clie.put(rs.getString("id_clie"), rs.getString("descripcion_cliente"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_clie;
    }

//    public Cliente buscarCliente(String buscartxt) {         //version 1
//        int r = 0;
//        Cliente clie = new Cliente();
//        String sql = "SELECT clie.id_cliente, clie.descripcion_cliente, clie.nro_documento_cliente, clie.telefono_cliente,\n"
//                + "clie.email_cliente, clie.estado_cliente, clie.nombre_usuario_modificacion, bar.descripcion_barrio, clie.direccion_cliente\n"
//                + "FROM barrio bar\n"
//                + "INNER JOIN cliente clie\n"
//                + "ON bar.id_barrio = clie.id_barrio\n"
//                + "WHERE clie.descripcion_cliente ILIKE ?";
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, buscartxt);
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                r = r + 1;
//                clie.setId_clie(rs.getInt("id_cliente"));
//                clie.setDesc_clie(rs.getString("descripcion_cliente"));
//                clie.setNro_doc_clie(rs.getString("nro_documento_cliente"));
//                clie.setTel_clie(rs.getString("telefono_cliente"));
//                clie.setEmail_clie(rs.getString("email_cliente"));
//                clie.setEstado_clie(rs.getString("estado_cliente"));
//                clie.setNom_usu_mod(rs.getString("nombre_usuario_modificacion"));                
//                clie.setDesc_bar(rs.getString("descripcion_barrio"));
//                clie.setDir_clie(rs.getString("direccion_cliente"));
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            //    System.out.println("Error en la ");
//        } finally {
//            return clie;
//        }
//    }
    public ArrayList<Cliente> buscarCliente(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Cliente clie = new Cliente();
        ArrayList<Cliente> cliente = new ArrayList<>();

        String sql = "SELECT clie.id_cliente, clie.descripcion_cliente, clie.nro_documento_cliente, clie.telefono_cliente, \n"
                + "clie.email_cliente, clie.estado_cliente, clie.nombre_usuario_modificacion, bar.descripcion_barrio, clie.direccion_cliente \n"
                + "FROM cliente clie \n"
                + "INNER JOIN barrio bar \n"
                + "ON clie.id_barrio = bar.id_barrio \n"
                + "WHERE clie.descripcion_cliente ILIKE ?";
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
                    id_clie = rs.getInt("id_cliente");
                    desc_clie = rs.getString("descripcion_cliente");
                    nro_doc_clie = rs.getString("nro_documento_cliente");
                    tel_clie = rs.getString("telefono_cliente");
                    email_clie = rs.getString("email_cliente");
                    estado_clie = rs.getString("estado_cliente");
                    desc_bar = rs.getString("descripcion_barrio");
                    dir_clie = rs.getString("direccion_cliente");
                    clienteHallado = new Cliente(id_clie, desc_clie, nro_doc_clie, tel_clie, email_clie, dir_clie, estado_clie, desc_bar);
                    cliente.add(clienteHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return cliente;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Cliente> leerClienteAc() {
        ArrayList<Cliente> cliente = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT clie.id_cliente, clie.descripcion_cliente, clie.nro_documento_cliente, clie.telefono_cliente, \n"
                    + "clie.email_cliente, clie.estado_cliente, clie.nombre_usuario_modificacion, bar.descripcion_barrio, clie.direccion_cliente \n"
                    + "FROM cliente clie \n"
                    + "INNER JOIN barrio bar \n"
                    + "ON clie.id_barrio = bar.id_barrio \n"
                    + "WHERE clie.estado_cliente = 'activo' \n"
                    + "ORDER BY id_cliente");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return cliente;
            } else {
                do {
                    id_clie = rs.getInt("id_cliente");
                    desc_clie = rs.getString("descripcion_cliente");
                    nro_doc_clie = rs.getString("nro_documento_cliente");
                    tel_clie = rs.getString("telefono_cliente");
                    email_clie = rs.getString("email_cliente");
                    estado_clie = rs.getString("estado_cliente");
                    desc_bar = rs.getString("descripcion_barrio");
                    dir_clie = rs.getString("direccion_cliente");
                    clienteHallado = new Cliente(id_clie, desc_clie, nro_doc_clie, tel_clie, email_clie, dir_clie, estado_clie, desc_bar);
                    cliente.add(clienteHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return cliente;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Cliente> leerClienteIna() {
        ArrayList<Cliente> cliente = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT clie.id_cliente, clie.descripcion_cliente, clie.nro_documento_cliente, clie.telefono_cliente, \n"
                    + "clie.email_cliente, clie.estado_cliente, clie.nombre_usuario_modificacion, bar.descripcion_barrio, clie.direccion_cliente \n"
                    + "FROM cliente clie \n"
                    + "INNER JOIN barrio bar \n"
                    + "ON clie.id_barrio = bar.id_barrio \n"
                    + "WHERE clie.estado_cliente = 'inactivo' \n"
                    + "ORDER BY id_cliente");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return cliente;
            } else {
                do {
                    id_clie = rs.getInt("id_cliente");
                    desc_clie = rs.getString("descripcion_cliente");
                    nro_doc_clie = rs.getString("nro_documento_cliente");
                    tel_clie = rs.getString("telefono_cliente");
                    email_clie = rs.getString("email_cliente");
                    estado_clie = rs.getString("estado_cliente");
                    desc_bar = rs.getString("descripcion_barrio");
                    dir_clie = rs.getString("direccion_cliente");
                    clienteHallado = new Cliente(id_clie, desc_clie, nro_doc_clie, tel_clie, email_clie, dir_clie, estado_clie, desc_bar);
                    cliente.add(clienteHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return cliente;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int cambiarActivo(Cliente clie) {
        int r = 0;
        String sql = "UPDATE public.cliente\n"
                + "SET  estado_cliente='activo'\n"
                + "WHERE id_cliente=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, clie.getId_clie());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                clie.setDesc_clie(rs.getString("nombre_cliente"));
                clie.setEstado_clie(rs.getString("estado_cliente"));
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

    public int cambiarInactivo(Cliente clie) {
        int r = 0;
        String sql = "UPDATE public.cliente\n"
                + "SET  estado_cliente='inactivo'\n"
                + "WHERE id_cliente=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, clie.getId_clie());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                clie.setDesc_clie(rs.getString("nombre_cliente"));
                clie.setEstado_clie(rs.getString("estado_cliente"));
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

    public int modificarCliente(Cliente clie) {
        int r = 0;
        String sql = "UPDATE public.cliente \n"
                + "SET descripcion_cliente=?, nro_documento_cliente=?, telefono_cliente=?, \n"
                + "email_cliente=?, estado_cliente=?, nombre_usuario_modificacion=?, fecha_modificacion=(SELECT current_date), id_barrio=?, direccion_cliente=? \n"
                + "WHERE id_cliente=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, clie.getDesc_clie());
            ps.setString(2, clie.getNro_doc_clie());
            ps.setString(3, clie.getTel_clie());
            ps.setString(4, clie.getEmail_clie());
            ps.setString(5, clie.getEstado_clie());
            ps.setString(6, clie.getNom_usu_mod());
            ps.setInt(7, clie.getId_bar());
            ps.setString(8, clie.getDir_clie());
            ps.setInt(9, clie.getId_clie());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                clie.setDesc_clie(rs.getString("descripcion_cliente"));
                clie.setNro_doc_clie(rs.getString("nro_documento_cliente"));
                clie.setTel_clie(rs.getString("telefono_cliente"));
                clie.setEmail_clie(rs.getString("email_cliente"));
                clie.setEstado_clie(rs.getString("estado_cliente"));
                clie.setId_bar(rs.getInt("id_barrio"));
                clie.setDir_clie(rs.getString("direccion_cliente"));
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

    public Cliente editarCliente(String editartxt) {
        int r = 0;
        Cliente clie = new Cliente();
        String sql = "SELECT clie.id_cliente, clie.descripcion_cliente, clie.nro_documento_cliente, clie.telefono_cliente, \n"
                + "clie.email_cliente, clie.estado_cliente, clie.nombre_usuario_modificacion, bar.descripcion_barrio, clie.direccion_cliente \n"
                + "FROM cliente clie \n"
                + "INNER JOIN barrio bar \n"
                + "ON clie.id_barrio = bar.id_barrio \n"
                + "WHERE clie.id_cliente = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));

            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                clie.setId_clie(rs.getInt("id_cliente"));
                clie.setDesc_clie(rs.getString("descripcion_cliente"));
                clie.setNro_doc_clie(rs.getString("nro_documento_cliente"));
                clie.setTel_clie(rs.getString("telefono_cliente"));
                clie.setEmail_clie(rs.getString("email_cliente"));
                clie.setDir_clie(rs.getString("direccion_cliente"));
                clie.setEstado_clie(rs.getString("estado_cliente"));
                clie.setDesc_bar(rs.getString("descripcion_barrio"));

            }

        } catch (Exception e) {
            System.out.println("hola");

        } finally {
            return clie;

        }
    }

    public Cliente añadirCliente(String buscartxt) {
        int r = 0;
        Cliente clie = new Cliente();
        String sql = "SELECT clie.id_cliente, clie.descripcion_cliente, clie.nro_documento_cliente, clie.telefono_cliente, \n"
                + "bar.descripcion_barrio, clie.direccion_cliente \n"
                + "FROM cliente clie \n"
                + "INNER JOIN barrio bar \n"
                + "ON clie.id_barrio = bar.id_barrio \n"
                + "WHERE clie.id_cliente = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(buscartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                Variables.id_cliente = (rs.getInt("id_cliente"));
                Variables.nombre_clie = (rs.getString("descripcion_cliente"));
                Variables.ruc_clie = (rs.getString("nro_documento_cliente"));                
                Variables.direccion_clie = (rs.getString("direccion_cliente"));                
                Variables.barrio_clie = (rs.getString("descripcion_barrio"));                
                Variables.tel_clie = (rs.getString("telefono_cliente"));                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //    System.out.println("Error en la ");
        } finally {
            return clie;
        }
    }
    
    public ArrayList<Cliente> buscarClienteVenta(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Cliente clie = new Cliente();
        ArrayList<Cliente> cliente = new ArrayList<>();

        String sql = "SELECT clie.id_cliente, clie.descripcion_cliente, clie.nro_documento_cliente, clie.telefono_cliente, \n"
                + "bar.descripcion_barrio, clie.direccion_cliente \n"
                + "FROM cliente clie \n"
                + "INNER JOIN barrio bar \n"
                + "ON clie.id_barrio = bar.id_barrio \n"
                + "WHERE clie.descripcion_cliente ILIKE ?";
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
                    id_clie = rs.getInt("id_cliente");
                    desc_clie = rs.getString("descripcion_cliente");
                    nro_doc_clie = rs.getString("nro_documento_cliente");
                    tel_clie = rs.getString("telefono_cliente");
                    desc_bar = rs.getString("descripcion_barrio");
                    dir_clie = rs.getString("direccion_cliente");
                    clienteHallado = new Cliente(id_clie, desc_clie, nro_doc_clie, tel_clie, dir_clie, desc_bar);
                    cliente.add(clienteHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return cliente;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
