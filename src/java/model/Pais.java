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
public class Pais implements ValidarPais {

    //CONSTRUCTORES - SET - GET
    int id_pais;
    String descripcion_pais, estado_pais;

    public Pais() {
    }

    public Pais(int id_pais, String descripcion_pais, String estado_pais) {
        this.id_pais = id_pais;
        this.descripcion_pais = descripcion_pais;
        this.estado_pais = estado_pais;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getDescripcion_pais() {
        return descripcion_pais;
    }

    public void setDescripcion_pais(String descripcion_pais) {
        this.descripcion_pais = descripcion_pais;
    }

    public String getEstado_pais() {
        return estado_pais;
    }

    public void setEstado_pais(String estado_pais) {
        this.estado_pais = estado_pais;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Pais paisHallado;

    @Override
    public int registrarPais(Pais p) {
        int r = 0;
        String sql = "INSERT INTO public.pais (descripcion_pais, estado_pais)\n"
                + "	VALUES (?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getDescripcion_pais());
            ps.setString(2, p.getEstado_pais());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            ConectaBD.cerrar();
            return 0;
        }
    }

    public HashMap seleccionarPais() {
        HashMap<String, String> drop_pais = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_pais as id_p,descripcion_pais\n"
                    + "FROM public.pais\n"
                    + "WHERE estado_pais = 'activo'\n"
                    + "ORDER BY id_pais";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_pais.put(rs.getString("id_p"), rs.getString("descripcion_pais"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ConectaBD.cerrar();
        }
        return drop_pais;
    }

    public ArrayList<Pais> buscarPais(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Pais p = new Pais();
        ArrayList<Pais> pais = new ArrayList<>();
        String sql = "SELECT id_pais, descripcion_pais, estado_pais \n"
                + "  FROM pais \n"
                + "  WHERE estado_pais='activo' \n"
                + "  and  descripcion_pais ILIKE ? \n"
                + "  ORDER BY id_pais";
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
                    id_pais = rs.getInt("id_pais");
                    descripcion_pais = rs.getString("descripcion_pais");
                    estado_pais = rs.getString("estado_pais");
                    paisHallado = new Pais(id_pais, descripcion_pais, estado_pais);
                    pais.add(paisHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return pais;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Pais editarPais(String editartxt) {
        int r = 0;
        Pais p = new Pais();
        String sql = "SELECT id_pais, descripcion_pais, estado_pais\n"
                + "FROM pais\n"
                + "WHERE id_pais = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                p.setId_pais(rs.getInt("id_pais"));
                p.setDescripcion_pais(rs.getString("descripcion_pais"));
                p.setEstado_pais(rs.getString("estado_pais"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");
        } finally {
            ConectaBD.cerrar();
            return p;
        }
    }

    public int modificarPais(Pais p) {
        int r = 0;
        String sql = "UPDATE public.pais\n"
                + "	SET  descripcion_pais=?, estado_pais=?\n"
                + "	WHERE id_pais=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getDescripcion_pais());
            ps.setString(2, p.getEstado_pais());
            ps.setInt(3, p.getId_pais());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            ConectaBD.cerrar();
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Pais> leerPaisAc() {
        ArrayList<Pais> pais = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_pais, descripcion_pais, estado_pais\n"
                    + "  FROM public.pais\n"
                    + "  WHERE estado_pais='activo'\n"
                    + "  ORDER BY id_pais");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return pais;
            } else {
                do {
                    id_pais = rs.getInt("id_pais");
                    descripcion_pais = rs.getString("descripcion_pais");
                    estado_pais = rs.getString("estado_pais");
                    paisHallado = new Pais(id_pais, descripcion_pais, estado_pais);
                    pais.add(paisHallado);
                    Variables.nohayRegistro = 1;
                } while (rs.next());
                ConectaBD.cerrar();
                return pais;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Pais> leerPaisIna() {
        ArrayList<Pais> pais = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_pais, descripcion_pais, estado_pais\n"
                    + "FROM public.pais\n"
                    + "WHERE estado_pais='inactivo'\n"
                    + "ORDER BY id_pais");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return pais;
            } else {
                do {
                    id_pais = rs.getInt("id_pais");
                    descripcion_pais = rs.getString("descripcion_pais");
                    estado_pais = rs.getString("estado_pais");
                    paisHallado = new Pais(id_pais, descripcion_pais, estado_pais);
                    pais.add(paisHallado);
                    Variables.nohayRegistro = 1;
                } while (rs.next());
                ConectaBD.cerrar();
                return pais;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int cambiarActivo(Pais p) {
        int r = 0;
        String sql = "UPDATE public.pais\n"
                + "	SET  estado_pais='activo'\n"
                + "	WHERE id_pais=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId_pais());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                p.setDescripcion_pais(rs.getString("descripcion_pais"));
                p.setEstado_pais(rs.getString("estado_pais"));
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

    public int cambiarInactivo(Pais p) {
        int r = 0;
        String sql = "UPDATE public.pais\n"
                + "	SET  estado_pais='inactivo'\n"
                + "	WHERE id_pais=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId_pais());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                p.setDescripcion_pais(rs.getString("descripcion_pais"));
                p.setEstado_pais(rs.getString("estado_pais"));
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
