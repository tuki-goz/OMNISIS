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
public class Tipo_pago implements ValidarTipoPago {

    //CONSTRUCTORES - SET - GET
    int id_tp;
    String descrip_tp;

    public Tipo_pago(int id_tp, String descrip_tp) {
        this.id_tp = id_tp;
        this.descrip_tp = descrip_tp;
    }

    public Tipo_pago() {
    }

    public int getId_tp() {
        return id_tp;
    }

    public void setId_tp(int id_tp) {
        this.id_tp = id_tp;
    }

    public String getDescrip_tp() {
        return descrip_tp;
    }

    public void setDescrip_tp(String descrip_tp) {
        this.descrip_tp = descrip_tp;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Tipo_pago tipo_pagoHallado;

    @Override
    public int registrarTipoPago(Tipo_pago tp) {
        int r = 0;
        String sql = "INSERT INTO public.tipo_pago(\n"
                + "descripcion_tipo_pago)\n"
                + "VALUES (?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tp.getDescrip_tp());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public HashMap seleccionarTipoPago() {
        HashMap<String, String> drop_tp = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_tipo_pago as id_tp,descripcion_tipo_pago\n"
                    + "FROM public.tipo_pago;";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_tp.put(Variables.id_tp = rs.getString("id_tp"), Variables.descrip_tp = rs.getString("descripcion_tipo_pago"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_tp;
    }

    public ArrayList<Tipo_pago> buscarTipoPago(String buscartxt) {
        ArrayList<Tipo_pago> tipo_pago = new ArrayList<>();
        String sql = "SELECT id_tipo_pago, descripcion_tipo_pago\n"
                + "FROM public.tipo_pago\n"
                + "WHERE descripcion_tipo_pago ILIKE ?\n"
                + "ORDER BY id_tipo_pago;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return tipo_pago;
            } else {
                do {
                    id_tp = rs.getInt("id_barrio");
                    descrip_tp = rs.getString("descripcion_barrio");
                    tipo_pagoHallado = new Tipo_pago(id_tp, descrip_tp);
                    tipo_pago.add(tipo_pagoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return tipo_pago;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int modificarTipoPago(Tipo_pago tp) {
        int r = 0;
        String sql = "UPDATE public.tipo_pago\n"
                + "SET descripcion_tipo_pago=?\n"
                + "WHERE id_tipo_pago=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tp.getDescrip_tp());
            ps.setInt(2, tp.getId_tp());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Tipo_pago> leerTipoPago() {
        ArrayList<Tipo_pago> tipo_pago = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_tipo_pago, descripcion_tipo_pago\n"
                    + "FROM public.tipo_pago\n"
                    + "ORDER BY id_tipo_pago;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return tipo_pago;
            } else {
                do {
                    id_tp = rs.getInt("id_tipo_pago");
                    descrip_tp = rs.getString("descripcion_tipo_pago");
                    tipo_pagoHallado = new Tipo_pago(id_tp, descrip_tp);
                    tipo_pago.add(tipo_pagoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return tipo_pago;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Tipo_pago editarTipoPago(String editartxt) {
        int r = 0;
        Tipo_pago tp = new Tipo_pago();
        String sql = "SELECT id_tipo_pago, descripcion_tipo_pago\n"
                + "FROM public.tipo_pago\n"
                + "WHERE id_tipo_pago = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                tp.setId_tp(rs.getInt("id_tipo_pago"));
                tp.setDescrip_tp(rs.getString("descripcion_tipo_pago"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");

        } finally {

            ConectaBD.cerrar();
            return tp;

        }
    }

}
