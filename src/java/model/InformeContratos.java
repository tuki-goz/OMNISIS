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
 * @author Alvaro
 */
public class InformeContratos {

    int id_Contrato, id_cliente, id_tipo_contrato, id_fiscal;
    String cliente_cont, fiscal_cont, codigo_cont, validez, fecha_ini, fecha_fin, tipo_cont, estado_Cont, nom_usu;

    public InformeContratos() {
    }

    public InformeContratos(int id_Contrato, int id_cliente, int id_tipo_contrato, int id_fiscal, String cliente_cont, String fiscal_cont, String codigo_cont, String validez, String fecha_ini, String fecha_fin, String tipo_cont, String estado_Cont, String nom_usu) {
        this.id_Contrato = id_Contrato;
        this.id_cliente = id_cliente;
        this.id_tipo_contrato = id_tipo_contrato;
        this.id_fiscal = id_fiscal;
        this.cliente_cont = cliente_cont;
        this.fiscal_cont = fiscal_cont;
        this.codigo_cont = codigo_cont;
        this.validez = validez;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.tipo_cont = tipo_cont;
        this.estado_Cont = estado_Cont;
        this.nom_usu = nom_usu;
    }

    public int getId_Contrato() {
        return id_Contrato;
    }

    public void setId_Contrato(int id_Contrato) {
        this.id_Contrato = id_Contrato;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_tipo_contrato() {
        return id_tipo_contrato;
    }

    public void setId_tipo_contrato(int id_tipo_contrato) {
        this.id_tipo_contrato = id_tipo_contrato;
    }

    public int getId_fiscal() {
        return id_fiscal;
    }

    public void setId_fiscal(int id_fiscal) {
        this.id_fiscal = id_fiscal;
    }

    public String getCliente_cont() {
        return cliente_cont;
    }

    public void setCliente_cont(String cliente_cont) {
        this.cliente_cont = cliente_cont;
    }

    public String getFiscal_cont() {
        return fiscal_cont;
    }

    public void setFiscal_cont(String fiscal_cont) {
        this.fiscal_cont = fiscal_cont;
    }

    public String getCodigo_cont() {
        return codigo_cont;
    }

    public void setCodigo_cont(String codigo_cont) {
        this.codigo_cont = codigo_cont;
    }

    public String getValidez() {
        return validez;
    }

    public void setValidez(String validez) {
        this.validez = validez;
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

    public String getTipo_cont() {
        return tipo_cont;
    }

    public void setTipo_cont(String tipo_cont) {
        this.tipo_cont = tipo_cont;
    }

    public String getEstado_Cont() {
        return estado_Cont;
    }

    public void setEstado_Cont(String estado_Cont) {
        this.estado_Cont = estado_Cont;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    PreparedStatement ps2;
    PreparedStatement ps3;
    PreparedStatement ps4;
    ResultSet rs;
    ResultSet rs2;
    private Statement stm;
    private InformeContratos informeContratosHallado;

    public ArrayList<InformeContratos> buscarContrato(String buscartxt) {
        int r = 0;
        Contrato cont = new Contrato();
        ArrayList<InformeContratos> informeContratos = new ArrayList<>();

        String sql = "SELECT  cont.id_contrato, cont.cliente_contrato, cont.fiscal_contrato, cont.codigo_contrato, cont.validez_contrato,\n"
                + "cont.fecha_inicio_contrato, cont.fecha_final_contrato,\n"
                + "cont.tipo_contrato, cont.estado_contrato, cont.nombre_usuario_modificacion, cont.fecha_modificacion, clie.descripcion_cliente \n"
                + "FROM contrato cont\n"
                + "INNER JOIN cliente clie\n"
                + "ON cont.id_cliente = clie.id_cliente\n"
                + "WHERE cont.cliente_contrato  ilike ?;";

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
                    id_Contrato = rs.getInt("id_venta");
                    cliente_cont = rs.getString("total_pagar_venta");
                    fiscal_cont = rs.getString("liq_total_iva_venta");
                    codigo_cont = rs.getString("nro_factura_venta");
                    validez = rs.getString("condicion_venta");
                    fecha_ini = rs.getString("fecha_factura_venta");
                    fecha_fin = rs.getString("estado_venta");
                    tipo_cont = rs.getString("ruc_venta");
                    estado_Cont = rs.getString("nombre_razon_venta");
                    nom_usu = rs.getString("nombre_razon_venta");
                    id_cliente = rs.getInt("nombre_razon_venta");
                    id_tipo_contrato = rs.getInt("nombre_razon_venta");
                    id_fiscal = rs.getInt("nombre_razon_venta");
                    informeContratosHallado = new InformeContratos(id_Contrato, id_cliente, id_tipo_contrato, id_fiscal, cliente_cont, fiscal_cont, codigo_cont, validez, fecha_ini, fecha_fin, tipo_cont, estado_Cont, nom_usu);
                    informeContratos.add(informeContratosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeContratos;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeContratos> buscarContratoClienteFecha(String buscartxt, String buscartxt1, String buscartxt2) {
        int r = 0;
        Contrato cont = new Contrato();
        ArrayList<InformeContratos> informeContratos = new ArrayList<>();

        String sql = "SELECT cont.id_contrato, cont.cliente_contrato, cont.fiscal_contrato, cont.codigo_contrato, cont.validez_contrato,\n"
                + "cont.fecha_inicio_contrato, cont.fecha_final_contrato,\n"
                + "cont.tipo_contrato, cont.estado_contrato, cont.nombre_usuario_modificacion, cont.fecha_modificacion, clie.descripcion_cliente\n"
                + "FROM contrato cont\n"
                + "INNER JOIN cliente clie\n"
                + "ON cont.id_cliente = clie.id_cliente\n"
                + "WHERE cont.cliente_contrato  ilike ?\n"
                + "AND cont.estado_contrato = 'activo'\n"
                + "AND cont.fecha_inicio_contrato BETWEEN ? AND ?;";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            ps.setString(2, "%" + buscartxt1 + "%");
            ps.setString(3, "%" + buscartxt2 + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_Contrato = rs.getInt("id_venta");
                    cliente_cont = rs.getString("total_pagar_venta");
                    fiscal_cont = rs.getString("liq_total_iva_venta");
                    codigo_cont = rs.getString("nro_factura_venta");
                    validez = rs.getString("condicion_venta");
                    fecha_ini = rs.getString("fecha_factura_venta");
                    fecha_fin = rs.getString("estado_venta");
                    tipo_cont = rs.getString("ruc_venta");
                    estado_Cont = rs.getString("nombre_razon_venta");
                    nom_usu = rs.getString("nombre_razon_venta");
                    id_cliente = rs.getInt("nombre_razon_venta");
                    id_tipo_contrato = rs.getInt("nombre_razon_venta");
                    id_fiscal = rs.getInt("nombre_razon_venta");
                    informeContratosHallado = new InformeContratos(id_Contrato, id_cliente, id_tipo_contrato, id_fiscal, cliente_cont, fiscal_cont, codigo_cont, validez, fecha_ini, fecha_fin, tipo_cont, estado_Cont, nom_usu);
                    informeContratos.add(informeContratosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeContratos;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeContratos> leerInformeContratosAc() {
        ArrayList<InformeContratos> informeContratos = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_contrato, cliente_contrato, fiscal_contrato, codigo_contrato, validez_contrato, fecha_inicio_contrato, fecha_final_contrato, tipo_contrato, estado_contrato, \n"
                    + " nombre_usuario_modificacion, id_cliente, id_tipo_contrato, id_fiscal \n"
                    + "	FROM public.contrato \n"
                    + "     WHERE estado_Contrato  = 'activo' \n"
                    + "     ORDER BY id_Contrato");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeContratos;
            } else {
                do {
                    id_Contrato = rs.getInt("id_contrato");
                    cliente_cont = rs.getString("cliente_contrato");
                    fiscal_cont = rs.getString("fiscal_contrato");
                    codigo_cont = rs.getString("codigo_contrato");
                    validez = rs.getString("validez_contrato");
                    fecha_ini = rs.getString("fecha_inicio_contrato");
                    fecha_fin = rs.getString("fecha_final_contrato");
                    tipo_cont = rs.getString("tipo_contrato");
                    estado_Cont = rs.getString("estado_contrato");
                    nom_usu = rs.getString("nombre_usuario_modificacion");
                    id_cliente = rs.getInt("id_cliente");
                    id_tipo_contrato = rs.getInt("id_tipo_contrato");
                    id_fiscal = rs.getInt("id_fiscal");
                    informeContratosHallado = new InformeContratos(id_Contrato, id_cliente, id_tipo_contrato, id_fiscal, cliente_cont, fiscal_cont, codigo_cont, validez, fecha_ini, fecha_fin, tipo_cont, estado_Cont, nom_usu);
                    informeContratos.add(informeContratosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeContratos;
            }

        } catch (Exception e) {

            System.out.println("Error en la consulta leerInformeContratosAc");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeContratos> leerInformeContratosIna() {
        ArrayList<InformeContratos> informeContratos = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_contrato, cliente_contrato, fiscal_contrato, codigo_contrato, validez_contrato, fecha_inicio_contrato, fecha_final_contrato, tipo_contrato, estado_contrato, \n"
                    + " nombre_usuario_modificacion, fecha_modificacion, id_cliente, id_tipo_contrato, id_fiscal \n"
                    + "	FROM public.contrato \n"
                    + "     WHERE estado_Contrato  = 'inactivo' \n"
                    + "     ORDER BY id_Contrato");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeContratos;
            } else {
                do {
                    id_Contrato = rs.getInt("id_venta");
                    cliente_cont = rs.getString("total_pagar_venta");
                    fiscal_cont = rs.getString("liq_total_iva_venta");
                    codigo_cont = rs.getString("nro_factura_venta");
                    validez = rs.getString("condicion_venta");
                    fecha_ini = rs.getString("fecha_factura_venta");
                    fecha_fin = rs.getString("estado_venta");
                    tipo_cont = rs.getString("ruc_venta");
                    estado_Cont = rs.getString("nombre_razon_venta");
                    nom_usu = rs.getString("nombre_razon_venta");
                    id_cliente = rs.getInt("nombre_razon_venta");
                    id_tipo_contrato = rs.getInt("nombre_razon_venta");
                    id_fiscal = rs.getInt("nombre_razon_venta");
                    informeContratosHallado = new InformeContratos(id_Contrato, id_cliente, id_tipo_contrato, id_fiscal, cliente_cont, fiscal_cont, codigo_cont, validez, fecha_ini, fecha_fin, tipo_cont, estado_Cont, nom_usu);
                    informeContratos.add(informeContratosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeContratos;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
