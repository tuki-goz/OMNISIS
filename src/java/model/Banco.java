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
public class Banco implements ValidarBanco {

    //CONSTRUCTORES - SET - GET
    int id_ban;
    String desc_ban, dir_ban, email_ban, tel_ban, estado_ban;

    public Banco() {
    }

    public Banco(int id_ban, String desc_ban, String dir_ban, String email_ban, String tel_ban, String estado_ban) {
        this.id_ban = id_ban;
        this.desc_ban = desc_ban;
        this.dir_ban = dir_ban;
        this.email_ban = email_ban;
        this.tel_ban = tel_ban;
        this.estado_ban = estado_ban;
    }

    public int getId_ban() {
        return id_ban;
    }

    public void setId_ban(int id_ban) {
        this.id_ban = id_ban;
    }

    public String getDesc_ban() {
        return desc_ban;
    }

    public void setDesc_ban(String desc_ban) {
        this.desc_ban = desc_ban;
    }

    public String getDir_ban() {
        return dir_ban;
    }

    public void setDir_ban(String dir_ban) {
        this.dir_ban = dir_ban;
    }

    public String getEmail_ban() {
        return email_ban;
    }

    public void setEmail_ban(String email_ban) {
        this.email_ban = email_ban;
    }

    public String getTel_ban() {
        return tel_ban;
    }

    public void setTel_ban(String tel_ban) {
        this.tel_ban = tel_ban;
    }

    public String getEstado_ban() {
        return estado_ban;
    }

    public void setEstado_ban(String estado_ban) {
        this.estado_ban = estado_ban;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Banco bancoHallado;

    @Override
    public int registrarBanco(Banco ban) {
        String sql = "INSERT INTO public.banco(\n"
                + "	descripcion_banco, direccion_banco, email_banco, telefono_banco, estado_banco)\n"
                + "	VALUES (?, ?, ?, ?, ?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ban.getDesc_ban());
            ps.setString(2, ban.getDir_ban());
            ps.setString(3, ban.getEmail_ban());
            ps.setString(4, ban.getTel_ban());
            ps.setString(5, ban.getEstado_ban());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public HashMap seleccionarBanco() {
        HashMap<String, String> drop_ban = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_banco as id_ban,descripcion_banco\n"
                    + "FROM public.banco;";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_ban.put(rs.getString("id_ban"), rs.getString("descripcion_banco"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_ban;
    }

    public int modificarBanco(Banco ban) {
        String sql = "UPDATE public.banco \n"
                + "SET descripcion_banco=?, direccion_banco=?, email_banco=?, telefono_banco=?, estado_banco=? \n"
                + "where id_banco = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ban.getDesc_ban());
            ps.setString(2, ban.getDir_ban());
            ps.setString(3, ban.getEmail_ban());
            ps.setString(4, ban.getTel_ban());
            ps.setString(5, ban.getEstado_ban());
            ps.setInt(6, ban.getId_ban());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Banco> leerBancoAc() {
        ArrayList<Banco> banco = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_banco, descripcion_banco, direccion_banco, email_banco, telefono_banco, estado_banco\n"
                    + "FROM public.banco\n"
                    + "WHERE estado_banco='activo'\n"
                    + "ORDER BY id_banco");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return banco;
            } else {
                do {
                    id_ban = rs.getInt("id_banco");
                    desc_ban = rs.getString("descripcion_banco");
                    dir_ban = rs.getString("direccion_banco");
                    email_ban = rs.getString("email_banco");
                    tel_ban = rs.getString("telefono_banco");
                    estado_ban = rs.getString("estado_banco");
                    bancoHallado = new Banco(id_ban, desc_ban, dir_ban, email_ban, tel_ban, estado_ban);
                    banco.add(bancoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return banco;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Banco> buscarBanco(String buscartxt) {
        ArrayList<Banco> banco = new ArrayList<>();
        String sql = "SELECT id_banco, descripcion_banco, direccion_banco, email_banco, telefono_banco, estado_banco\n"
                + "FROM public.banco\n"
//                + "WHERE estado_banco='activo'\n"
                + "ORDER BY id_banco\n"
                + "AND descripcion_banco ILIKE ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return banco;
            } else {
                do {
                    id_ban = rs.getInt("id_banco");
                    desc_ban = rs.getString("descripcion_banco");
                    dir_ban = rs.getString("direccion_banco");
                    email_ban = rs.getString("email_banco");
                    tel_ban = rs.getString("telefono_banco");
                    estado_ban = rs.getString("estado_banco");
                    bancoHallado = new Banco(id_ban, desc_ban, dir_ban, email_ban, tel_ban, estado_ban);
                    banco.add(bancoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return banco;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Banco editarBanco(String editartxt) {
        int r = 0;
        Banco ban = new Banco();
        String sql = "SELECT id_banco, descripcion_banco, direccion_banco, email_banco, telefono_banco, estado_banco\n"
                + "FROM public.banco\n"
                + "WHERE id_banco = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                ban.setId_ban(rs.getInt("id_banco"));
                ban.setDesc_ban(rs.getString("descripcion_banco"));
                ban.setDir_ban(rs.getString("direccion_banco"));
                ban.setEmail_ban(rs.getString("email_banco"));
                ban.setTel_ban(rs.getString("telefono_banco"));
                ban.setEstado_ban(rs.getString("estado_banco"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");
        } finally {
            ConectaBD.cerrar();
            return ban;
        }
    }

    public int cambiarInactivo(Banco ban) {
        int r = 0;
        String sql = "UPDATE public.banco\n"
                + "SET  estado_banco='inactivo'\n"
                + "WHERE id_banco=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ban.getId_ban());
            rs = ps.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int cambiarActivo(Banco ban) {
        int r = 0;
        String sql = "UPDATE public.banco\n"
                + "SET  estado_banco='activo'\n"
                + "WHERE id_banco=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ban.getId_ban());
            rs = ps.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Banco> leerBancoIna() {
        ArrayList<Banco> banco = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_banco, descripcion_banco, direccion_banco, email_banco, telefono_banco, estado_banco\n"
                    + "FROM public.banco\n"
                    + "WHERE estado_banco='inactivo'\n"
                    + "ORDER BY id_banco");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return banco;
            } else {
                do {
                    id_ban = rs.getInt("id_banco");
                    desc_ban = rs.getString("descripcion_banco");
                    dir_ban = rs.getString("direccion_banco");
                    email_ban = rs.getString("email_banco");
                    tel_ban = rs.getString("telefono_banco");
                    estado_ban = rs.getString("estado_banco");
                    bancoHallado = new Banco(id_ban, desc_ban, dir_ban, email_ban, tel_ban, estado_ban);
                    banco.add(bancoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return banco;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
