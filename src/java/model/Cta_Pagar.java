/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Francisca Gómez
 */
public class Cta_Pagar implements ValidarCta_pagar {

    int id_cuenta_pagar, id_compra, total_cuenta_pagar;
    String codigo_cuenta_pagar, descripcion_cuenta_pagar, condicion_cuenta_pagar, fecha_vencimiento_cuenta_pagar, estado_cuenta_pagar, nombre_usuario_modificacion, fecha_modificacion;

    public Cta_Pagar() {
    }

    public Cta_Pagar(int id_cuenta_pagar, int id_compra, String codigo_cuenta_pagar, String descripcion_cuenta_pagar, String condicion_cuenta_pagar, String fecha_vencimiento_cuenta_pagar, String estado_cuenta_pagar, String nombre_usuario_modificacion, String fecha_modificacion, int total_cuenta_pagar) {
        this.id_cuenta_pagar = id_cuenta_pagar;
        this.id_compra = id_compra;
        this.codigo_cuenta_pagar = codigo_cuenta_pagar;
        this.descripcion_cuenta_pagar = descripcion_cuenta_pagar;
        this.condicion_cuenta_pagar = condicion_cuenta_pagar;
        this.fecha_vencimiento_cuenta_pagar = fecha_vencimiento_cuenta_pagar;
        this.estado_cuenta_pagar = estado_cuenta_pagar;
        this.nombre_usuario_modificacion = nombre_usuario_modificacion;
        this.fecha_modificacion = fecha_modificacion;
        this.total_cuenta_pagar = total_cuenta_pagar;
    }

    public Cta_Pagar(int id_cuenta_pagar, int id_compra, String codigo_cuenta_pagar, String descripcion_cuenta_pagar, String condicion_cuenta_pagar, String fecha_vencimiento_cuenta_pagar, String estado_cuenta_pagar, int total_cuenta_pagar) {
        this.id_cuenta_pagar = id_cuenta_pagar;
        this.id_compra = id_compra;
        this.codigo_cuenta_pagar = codigo_cuenta_pagar;
        this.descripcion_cuenta_pagar = descripcion_cuenta_pagar;
        this.condicion_cuenta_pagar = condicion_cuenta_pagar;
        this.fecha_vencimiento_cuenta_pagar = fecha_vencimiento_cuenta_pagar;
        this.estado_cuenta_pagar = estado_cuenta_pagar;
        this.total_cuenta_pagar = total_cuenta_pagar;
    }

    public int getId_cuenta_pagar() {
        return id_cuenta_pagar;
    }

    public void setId_cuenta_pagar(int id_cuenta_pagar) {
        this.id_cuenta_pagar = id_cuenta_pagar;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public String getCodigo_cuenta_pagar() {
        return codigo_cuenta_pagar;
    }

    public void setCodigo_cuenta_pagar(String codigo_cuenta_pagar) {
        this.codigo_cuenta_pagar = codigo_cuenta_pagar;
    }

    public String getDescripcion_cuenta_pagar() {
        return descripcion_cuenta_pagar;
    }

    public void setDescripcion_cuenta_pagar(String descripcion_cuenta_pagar) {
        this.descripcion_cuenta_pagar = descripcion_cuenta_pagar;
    }

    public String getCondicion_cuenta_pagar() {
        return condicion_cuenta_pagar;
    }

    public void setCondicion_cuenta_pagar(String condicion_cuenta_pagar) {
        this.condicion_cuenta_pagar = condicion_cuenta_pagar;
    }

    public String getFecha_vencimiento_cuenta_pagar() {
        return fecha_vencimiento_cuenta_pagar;
    }

    public void setFecha_vencimiento_cuenta_pagar(String fecha_vencimiento_cuenta_pagar) {
        this.fecha_vencimiento_cuenta_pagar = fecha_vencimiento_cuenta_pagar;
    }

    public String getEstado_cuenta_pagar() {
        return estado_cuenta_pagar;
    }

    public void setEstado_cuenta_pagar(String estado_cuenta_pagar) {
        this.estado_cuenta_pagar = estado_cuenta_pagar;
    }

    public String getNombre_usuario_modificacion() {
        return nombre_usuario_modificacion;
    }

    public void setNombre_usuario_modificacion(String nombre_usuario_modificacion) {
        this.nombre_usuario_modificacion = nombre_usuario_modificacion;
    }

    public String getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public int getTotal_cuenta_pagar() {
        return total_cuenta_pagar;
    }

    public void setTotal_cuenta_pagar(int total_cuenta_pagar) {
        this.total_cuenta_pagar = total_cuenta_pagar;
    }

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    PreparedStatement ps1;
    ResultSet rs;
    private Statement stm;
    private Cta_Pagar cta_PagarHallado;

    @Override
    public int registrarCta_Pagar(Cta_Pagar ctp) {
        String sql = "INSERT INTO public.cuenta_pagar(\n"
                + "	codigo_cuenta_pagar, descripcion_cuenta_pagar, condicion_cuenta_pagar, \n"
                + "	fecha_vencimiento_cuenta_pagar, saldo_cuenta_pagar, estado_cuenta_pagar, id_compra)\n"
                + "	VALUES (?, ?, 'contado', (select current_date), ?, 'pendiente', (select MAX(id_compra) from compra));";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ctp.getCodigo_cuenta_pagar());
            ps.setString(2, ctp.getDescripcion_cuenta_pagar());
            ps.setInt(3, ctp.getTotal_cuenta_pagar());

            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en insercion registrarCta_Pagar ");
            return 0;
        }
    }

    public ArrayList<Cta_Pagar> leerCta_PagarRe() {
        ArrayList<Cta_Pagar> cta_pagar = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT cp.id_cuenta_pagar, cp.codigo_cuenta_pagar,  cp.descripcion_cuenta_pagar, cp.condicion_cuenta_pagar, \n"
                    + "cp.fecha_vencimiento_cuenta_pagar, cp.saldo_cuenta_pagar, cp.estado_cuenta_pagar, cp.id_compra \n"
                    + "FROM public.cuenta_pagar cp \n"
                    + "WHERE  cp.estado_cuenta_pagar = 'pendiente'\n"
                    + "ORDER BY cp.id_cuenta_pagar;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return cta_pagar;
            } else {
                do {
                    Variables.id_cta_pag = rs.getInt("id_cuenta_pagar");
                    codigo_cuenta_pagar = rs.getString("codigo_cuenta_pagar");
                    descripcion_cuenta_pagar = rs.getString("descripcion_cuenta_pagar");
                    condicion_cuenta_pagar = rs.getString("condicion_cuenta_pagar");
                    fecha_vencimiento_cuenta_pagar = rs.getString("fecha_vencimiento_cuenta_pagar");
                    total_cuenta_pagar = rs.getInt("saldo_cuenta_pagar");
                    estado_cuenta_pagar = rs.getString("estado_cuenta_pagar");
                    id_compra = rs.getInt("id_compra");
                    cta_PagarHallado = new Cta_Pagar(Variables.id_cta_pag, id_compra, codigo_cuenta_pagar, descripcion_cuenta_pagar, condicion_cuenta_pagar, fecha_vencimiento_cuenta_pagar, estado_cuenta_pagar, total_cuenta_pagar);
                    cta_pagar.add(cta_PagarHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return cta_pagar;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta leerCta_PagarRe");
            e.printStackTrace();
            return null;
        }
    }
    
    public Cta_Pagar buscarPagar(String editartxt) {
        int r = 0;
        Cta_Pagar cta_pag = new Cta_Pagar();
        String sql = "SELECT id_cuenta_pagar, descripcion_cuenta_pagar, saldo_cuenta_pagar, id_compra\n"
                + "FROM public.cuenta_pagar\n"
                + "WHERE id_cuenta_pagar = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                cta_pag.setId_cuenta_pagar(rs.getInt("id_cuenta_pagar"));
                cta_pag.setDescripcion_cuenta_pagar(rs.getString("descripcion_cuenta_pagar"));
                cta_pag.setTotal_cuenta_pagar(rs.getInt("saldo_cuenta_pagar"));
                cta_pag.setId_compra(rs.getInt("id_compra"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");
        } finally {
            ConectaBD.cerrar();
            return cta_pag;
        }
    }
}
