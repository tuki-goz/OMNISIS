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
public class Impuesto implements ValidarImpuesto {

    //CONSTRUCTORES - SET - GET
    int id_impuesto;
    String descripcion_impuesto;
    double cifra;
    String nombre_usuario_modificacion, estado_im;

    public Impuesto() {
    }

    public int getId_impuesto() {
        return id_impuesto;
    }

    public void setId_impuesto(int id_impuesto) {
        this.id_impuesto = id_impuesto;
    }

    public String getDescripcion_impuesto() {
        return descripcion_impuesto;
    }

    public void setDescripcion_impuesto(String descripcion_impuesto) {
        this.descripcion_impuesto = descripcion_impuesto;
    }

    public double getCifra() {
        return cifra;
    }

    public void setCifra(double cifra) {
        this.cifra = cifra;
    }

    public String getNombre_usuario_modificacion() {
        return nombre_usuario_modificacion;
    }

    public void setNombre_usuario_modificacion(String nombre_usuario_modificacion) {
        this.nombre_usuario_modificacion = nombre_usuario_modificacion;
    }

    public Impuesto(int id_impuesto, String descripcion_impuesto, double cifra, String estado_im) {
        this.id_impuesto = id_impuesto;
        this.descripcion_impuesto = descripcion_impuesto;
        this.cifra = cifra;
        this.estado_im = estado_im;
    }

    public String getEstado_im() {
        return estado_im;
    }

    public void setEstado_im(String estado_im) {
        this.estado_im = estado_im;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Impuesto impuestoHallado;

    @Override
    public int registrarImpuesto(Impuesto im) {
        int r = 0;
        String sql = "INSERT INTO public.impuesto(descripcion_impuesto, cifra, nombre_usuario_modificacion, fecha_modificacion, estado_impuesto)\n"
                + "	VALUES (?,?,?,(SELECT current_date), ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, im.getDescripcion_impuesto());
            ps.setDouble(2, im.getCifra());
            ps.setString(3, im.getNombre_usuario_modificacion());
            ps.setString(4, im.getEstado_im());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public HashMap seleccionarImpuesto() {
        HashMap<String, String> drop_imp = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_impuesto as id_i,descripcion_impuesto\n"
                    + "	FROM public.impuesto;";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_imp.put(rs.getString("id_i"), rs.getString("descripcion_impuesto"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_imp;
    }

    public ArrayList<Impuesto> buscarImpuesto(String buscartxt) {
        ArrayList<Impuesto> impuesto = new ArrayList<>();
        String sql = "SELECT id_impuesto, descripcion_impuesto, cifra, estado_impuesto\n"
                + "FROM public.impuesto\n"
                + "WHERE estado_impuesto='activo'\n"
                + "AND descripcion_impuesto ILIKE ?\n"
                + "ORDER BY id_impuesto;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return impuesto;
            } else {
                do {
                    id_impuesto = rs.getInt("id_impuesto");
                    descripcion_impuesto = rs.getString("descripcion_impuesto");
                    cifra = rs.getDouble("cifra");
                    estado_im = rs.getString("estado_impuesto");
                    impuestoHallado = new Impuesto(id_impuesto, descripcion_impuesto, cifra, estado_im);
                    impuesto.add(impuestoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return impuesto;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int modificarImpuesto(Impuesto im) {
        int r = 0;
        String sql = "UPDATE public.impuesto\n"
                + "SET descripcion_impuesto=?, cifra=?, nombre_usuario_modificacion=?, fecha_modificacion=(SELECT current_date), estado_impuesto=?\n"
                + "WHERE id_impuesto=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, im.getDescripcion_impuesto());
            ps.setDouble(2, im.getCifra());
            ps.setString(3, im.getNombre_usuario_modificacion());
            ps.setString(4, im.getEstado_im());
            ps.setInt(5, im.getId_impuesto());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Impuesto> leerImpuestoAc() {
        ArrayList<Impuesto> impuesto = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_impuesto, descripcion_impuesto, cifra, estado_impuesto\n"
                    + "FROM public.impuesto\n"
                    + "WHERE estado_impuesto='activo'\n"
                    + "ORDER BY id_impuesto;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return impuesto;
            } else {
                do {
                    id_impuesto = rs.getInt("id_impuesto");
                    descripcion_impuesto = rs.getString("descripcion_impuesto");
                    cifra = rs.getDouble("cifra");
                    estado_im = rs.getString("estado_impuesto");
                    impuestoHallado = new Impuesto(id_impuesto, descripcion_impuesto, cifra, estado_im);
                    impuesto.add(impuestoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return impuesto;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Impuesto editarImpuesto(String editartxt) {
        int r = 0;
        Impuesto im = new Impuesto();
        String sql = "SELECT id_impuesto, descripcion_impuesto, cifra, estado_impuesto\n"
                + "FROM public.impuesto\n"
                + "WHERE id_impuesto = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                im.setId_impuesto(rs.getInt("id_impuesto"));
                im.setDescripcion_impuesto(rs.getString("descripcion_impuesto"));
                im.setCifra(rs.getDouble("cifra"));
                im.setEstado_im(rs.getString("estado_impuesto"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");
        } finally {
            ConectaBD.cerrar();
            return im;
        }
    }

    public int cambiarInactivo(Impuesto im) {
        String sql = "UPDATE impuesto\n"
                + "SET estado_impuesto='inactivo'\n"
                + "WHERE id_impuesto = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, im.getId_impuesto());
            rs = ps.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
