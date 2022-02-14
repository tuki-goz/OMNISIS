/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Francisca Gómez
 */
public class Cta_Cobrar implements ValidarCtaCobrar {

    //CONSTRUCTORES - SET - GET
    int id_cta_cob, id_clie, id_venta;
    String nro_cta_cob, fecha_ini, fecha_fin, estado;

    public Cta_Cobrar() {
    }

    public Cta_Cobrar(int id_cta_cob, int id_clie, int id_venta, String nro_cta_cob, String fecha_ini, String fecha_fin, String estado) {
        this.id_cta_cob = id_cta_cob;
        this.id_clie = id_clie;
        this.id_venta = id_venta;
        this.nro_cta_cob = nro_cta_cob;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
    }

    public int getId_cta_cob() {
        return id_cta_cob;
    }

    public void setId_cta_cob(int id_cta_cob) {
        this.id_cta_cob = id_cta_cob;
    }

    public int getId_clie() {
        return id_clie;
    }

    public void setId_clie(int id_clie) {
        this.id_clie = id_clie;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getNro_cta_cob() {
        return nro_cta_cob;
    }

    public void setNro_cta_cob(String nro_cta_cob) {
        this.nro_cta_cob = nro_cta_cob;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    PreparedStatement ps1;
    ResultSet rs;

    @Override
    public int registrarCtaCobrar(Cta_Cobrar cta_cob) {

        String sql = "INSERT INTO public.cuenta_cobrar( \n"
                + "numero_cuenta_cobrar, fecha_inicio_cuenta_cobrar, estado_cuenta_cobrar, id_venta) \n"
                + "VALUES ( ?, (select current_date), 'pendiente', (select MAX(id_venta) from venta));";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cta_cob.getNro_cta_cob());
   //         ps.setInt(2, cta_cob.getId_clie());
            ps.executeUpdate();

            String sql2 = "UPDATE public.cuenta_cobrar\n"
                    + "	SET fecha_fin_cuenta_cobrar=(select TO_DATE(fecha_inicio_cuenta_cobrar, 'YYYY MM DD') + interval '30 day')\n"
                    + "	WHERE  id_cuenta_cobrar=(select MAX(id_cuenta_cobrar) from cuenta_cobrar);";
            con = cn.getConnection();
            ps1 = con.prepareStatement(sql2);
            ps1.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en insercion registrarCtaCobrar ");
            return 0;
        }
    }

    public int registrarCtaCobrarContado(Cta_Cobrar cta_cob) {
        int r = 0;
        String sql = "INSERT INTO public.cuenta_cobrar(\n"
                + "	numero_cuenta_cobrar, fecha_inicio_cuenta_cobrar, fecha_fin_cuenta_cobrar, estado_cuenta_cobrar, id_venta)\n"
                + "	VALUES ( ?, (select current_date), (select current_date), 'pendiente', (select MAX(id_venta) from venta));";
        try {
            con = cn.getConnection();
            ps1 = con.prepareStatement(sql);
            ps1.setString(1, cta_cob.getNro_cta_cob());
         //   ps1.setInt(2, cta_cob.getId_clie());
            ps1.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en insercion registrarCtaCobrarContado ");
            return 0;
        }
    }

}
