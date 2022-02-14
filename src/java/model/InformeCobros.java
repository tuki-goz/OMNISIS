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
public class InformeCobros {

    int id_cobro, total_cobro, id_cta_cobrar, id_venta, id_caja, id_cobrod, monto_cobrod, id_fc, id_banco, monto_cheque;
    String descrip_cobro, fecha_cobro, estado_cobro, nom_usu_mod, fecha_mod, descrip_cobrod, nro_cta_cobrar, nro_factura, descrip_caja, descrip_fc, desc_banco, nombre_razon, nro_cobro, ruc, nro_cheque;

    public InformeCobros() {
    }

    //CABECERA
    public InformeCobros(int id_cobro, int total_cobro, int id_cta_cobrar, int id_venta, int id_caja, String descrip_cobro, String fecha_cobro, String estado_cobro, String nom_usu_mod, String fecha_mod, String nro_cobro) {
        this.id_cobro = id_cobro;
        this.total_cobro = total_cobro;
        this.id_cta_cobrar = id_cta_cobrar;
        this.id_venta = id_venta;
        this.id_caja = id_caja;
        this.descrip_cobro = descrip_cobro;
        this.fecha_cobro = fecha_cobro;
        this.estado_cobro = estado_cobro;
        this.nom_usu_mod = nom_usu_mod;
        this.fecha_mod = fecha_mod;
        this.nro_cobro = nro_cobro;
    }

    //DETALLE
    public InformeCobros(int id_cobro, int id_cobrod, int monto_cobrod, int id_fc, String descrip_cobrod) {
        this.id_cobro = id_cobro;
        this.id_cobrod = id_cobrod;
        this.monto_cobrod = monto_cobrod;
        this.id_fc = id_fc;
        this.descrip_cobrod = descrip_cobrod;
    }

    public InformeCobros(int id_cobro, int total_cobro, int id_cta_cobrar, int id_venta, int id_caja, int monto_cobrod, int id_banco, int monto_cheque, String descrip_cobro, String fecha_cobro, String estado_cobro, String nom_usu_mod) {
        this.id_cobro = id_cobro;
        this.total_cobro = total_cobro;
        this.id_cta_cobrar = id_cta_cobrar;
        this.id_venta = id_venta;
        this.id_caja = id_caja;
        this.monto_cobrod = monto_cobrod;
        this.id_banco = id_banco;
        this.monto_cheque = monto_cheque;
        this.descrip_cobro = descrip_cobro;
        this.fecha_cobro = fecha_cobro;
        this.estado_cobro = estado_cobro;
        this.nom_usu_mod = nom_usu_mod;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public int getMonto_cheque() {
        return monto_cheque;
    }

    public void setMonto_cheque(int monto_cheque) {
        this.monto_cheque = monto_cheque;
    }

    public String getNro_cheque() {
        return nro_cheque;
    }

    public void setNro_cheque(String nro_cheque) {
        this.nro_cheque = nro_cheque;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public String getDesc_banco() {
        return desc_banco;
    }

    public void setDesc_banco(String desc_banco) {
        this.desc_banco = desc_banco;
    }

    public String getNro_cobro() {
        return nro_cobro;
    }

    public void setNro_cobro(String nro_cobro) {
        this.nro_cobro = nro_cobro;
    }

    public String getNro_cta_cobrar() {
        return nro_cta_cobrar;
    }

    public void setNro_cta_cobrar(String nro_cta_cobrar) {
        this.nro_cta_cobrar = nro_cta_cobrar;
    }

    public String getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(String nro_factura) {
        this.nro_factura = nro_factura;
    }

    public String getDescrip_caja() {
        return descrip_caja;
    }

    public void setDescrip_caja(String descrip_caja) {
        this.descrip_caja = descrip_caja;
    }

    public String getDescrip_fc() {
        return descrip_fc;
    }

    public void setDescrip_fc(String descrip_fc) {
        this.descrip_fc = descrip_fc;
    }

    public String getNombre_razon() {
        return nombre_razon;
    }

    public void setNombre_razon(String nombre_razon) {
        this.nombre_razon = nombre_razon;
    }

    public int getId_cobro() {
        return id_cobro;
    }

    public void setId_cobro(int id_cobro) {
        this.id_cobro = id_cobro;
    }

    public int getTotal_cobro() {
        return total_cobro;
    }

    public void setTotal_cobro(int total_cobro) {
        this.total_cobro = total_cobro;
    }

    public int getId_cta_cobrar() {
        return id_cta_cobrar;
    }

    public void setId_cta_cobrar(int id_cta_cobrar) {
        this.id_cta_cobrar = id_cta_cobrar;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }

    public int getId_cobrod() {
        return id_cobrod;
    }

    public void setId_cobrod(int id_cobrod) {
        this.id_cobrod = id_cobrod;
    }

    public int getMonto_cobrod() {
        return monto_cobrod;
    }

    public void setMonto_cobrod(int monto_cobrod) {
        this.monto_cobrod = monto_cobrod;
    }

    public int getId_fc() {
        return id_fc;
    }

    public void setId_fc(int id_fc) {
        this.id_fc = id_fc;
    }

    public String getDescrip_cobro() {
        return descrip_cobro;
    }

    public void setDescrip_cobro(String descrip_cobro) {
        this.descrip_cobro = descrip_cobro;
    }

    public String getFecha_cobro() {
        return fecha_cobro;
    }

    public void setFecha_cobro(String fecha_cobro) {
        this.fecha_cobro = fecha_cobro;
    }

    public String getEstado_cobro() {
        return estado_cobro;
    }

    public void setEstado_cobro(String estado_cobro) {
        this.estado_cobro = estado_cobro;
    }

    public String getNom_usu_mod() {
        return nom_usu_mod;
    }

    public void setNom_usu_mod(String nom_usu_mod) {
        this.nom_usu_mod = nom_usu_mod;
    }

    public String getFecha_mod() {
        return fecha_mod;
    }

    public void setFecha_mod(String fecha_mod) {
        this.fecha_mod = fecha_mod;
    }

    public String getDescrip_cobrod() {
        return descrip_cobrod;
    }

    public void setDescrip_cobrod(String descrip_cobrod) {
        this.descrip_cobrod = descrip_cobrod;
    }

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private InformeCobros informeCobrosHallado;

    public ArrayList<InformeCobros> leerInformeCobrosAc() {
        ArrayList<InformeCobros> informeCobros = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_cobro, numero_cobro, descripcion_cobro, fecha_cobro, total_cobro, estado_cobro, nombre_usuario_modificacion, \n"
                    + "id_cuenta_cobrar, id_caja, id_banco, monto_cheque_cobro, nro_cheque_cobro  \n"
                    + "	FROM public.cobro \n"
                    + " ORDER BY id_cobro");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeCobros;
            } else {
                do {
                    id_cobro = rs.getInt("id_cobro");
                    nro_cobro = rs.getString("numero_cobro");
                    descrip_cobro = rs.getString("descripcion_cobro");
                    fecha_cobro = rs.getString("fecha_cobro");
                    total_cobro = rs.getInt("total_cobro");
                    estado_cobro = rs.getString("estado_cobro");
                    nom_usu_mod = rs.getString("nombre_usuario_modificacion");
                    id_cta_cobrar = rs.getInt("id_cuenta_cobrar");
                    id_venta = rs.getInt("id_venta");
                    id_caja = rs.getInt("id_caja");
                    monto_cheque = rs.getInt("monto_cheque_cobro");
                    nro_cheque = rs.getString("nro_cheque_cobro");
                    id_banco = rs.getInt("id_banco");
                    informeCobrosHallado = new InformeCobros(id_cobro, total_cobro, id_cta_cobrar, id_venta, id_caja, monto_cobrod, id_banco, monto_cheque, descrip_cobro, fecha_cobro, estado_cobro, nom_usu_mod);
                    informeCobros.add(informeCobrosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeCobros;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeCobros> leerInformeCobrosIna() {
        ArrayList<InformeCobros> informeCobros = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_cobro, numero_cobro, descripcion_cobro, fecha_cobro, total_cobro, estado_cobro, nombre_usuario_modificacion, \n"
                    + " id_cuenta_cobrar, id_caja, monto_cheque_cobro, nro_cheque_cobro, id_banco\n"
                    + "	FROM public.cobro \n"
                    + " ORDER BY id_cobro");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeCobros;
            } else {
                do {
                    id_cobro = rs.getInt("id_cobro");
                    nro_cobro = rs.getString("numero_cobro");
                    descrip_cobro = rs.getString("descripcion_cobro");
                    fecha_cobro = rs.getString("fecha_cobro");
                    total_cobro = rs.getInt("total_cobro");
                    estado_cobro = rs.getString("estado_cobro");
                    nom_usu_mod = rs.getString("nombre_usuario_modificacion");
                    id_cta_cobrar = rs.getInt("id_cuenta_cobrar");
                    id_venta = rs.getInt("id_venta");
                    id_caja = rs.getInt("id_caja");
                    monto_cheque = rs.getInt("monto_cheque_cobro");
                    nro_cheque = rs.getString("nro_cheque_cobro");
                    id_banco = rs.getInt("id_banco");
                    informeCobrosHallado = new InformeCobros(id_cobro, total_cobro, id_cta_cobrar, id_venta, id_caja, monto_cobrod, id_banco, monto_cheque, descrip_cobro, fecha_cobro, estado_cobro, nom_usu_mod);
                    informeCobros.add(informeCobrosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeCobros;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeCobros> buscarInformeCobrosClienteyFecha(String buscartxt, String fechainitxt, String fechafintxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Variables.sumarventa = 0.0;
        InformeCobros inf = new InformeCobros();
        ArrayList<InformeCobros> informeCobros = new ArrayList<>();
        String sql = "SELECT cob.id_cobro, cob.numero_cobro, cob.descripcion_cobro, cob.fecha_cobro, cob.total_cobro, cob.estado_cobro, cob.nombre_usuario_modificacion, \n"
                + "     cob.id_cuenta_cobrar, cob.id_caja, cob.monto_cheque_cobro, cob.nro_cheque_cobro, cob.id_banco, clie.descripcion_cliente \n"
                + "	FROM public.cobro cob \n"
                + "	INNER JOIN cuenta_cobrar cue ON cob.id_cuenta_cobrar = cue.id_cuenta_cobrar \n"
                + "	INNER JOIN venta ven  ON cue.id_venta = ven.id_venta \n"
                + "	INNER JOIN cliente clie ON ven.id_cliente = clie.id_cliente \n"
                + "     WHERE cob.estado_cobro = 'pendiente' \n"
                + "	and clie.descripcion_cliente ilike ? \n"
                + "	and cob.fecha_cobro  between ? and ? \n"
                + "     ORDER BY cob.id_cobro";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            ps.setString(2, fechainitxt);
            ps.setString(3, fechafintxt);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeCobros;
            } else {
                do {
                    id_cobro = rs.getInt("id_cobro");
                    nro_cobro = rs.getString("numero_cobro");
                    descrip_cobro = rs.getString("descripcion_cobro");
                    fecha_cobro = rs.getString("fecha_cobro");
                    total_cobro = rs.getInt("total_cobro");
                    estado_cobro = rs.getString("estado_cobro");
                    nom_usu_mod = rs.getString("nombre_usuario_modificacion");
                    id_cta_cobrar = rs.getInt("id_cuenta_cobrar");
//                    id_venta = rs.getInt("id_venta");
                    id_caja = rs.getInt("id_caja");
                    monto_cheque = rs.getInt("monto_cheque");
                    nro_cheque = rs.getString("nro_cheque");
                    id_banco = rs.getInt("id_banco");
                    informeCobrosHallado = new InformeCobros(id_cobro, total_cobro, id_cta_cobrar, id_venta, id_caja, monto_cobrod, id_banco, monto_cheque, descrip_cobro, fecha_cobro, estado_cobro, nom_usu_mod);
                    informeCobros.add(informeCobrosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeCobros;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeCobros> buscarInformeCobrosCliente(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Variables.sumarventa = 0.0;
        InformeCobros inf = new InformeCobros();
        ArrayList<InformeCobros> informeCobros = new ArrayList<>();
        String sql = "SELECT cob.id_cobro, cob.numero_cobro, cob.descripcion_cobro, cob.fecha_cobro, cob.total_cobro, cob.estado_cobro, cob.nombre_usuario_modificacion, \n"
                + "     cob.id_cuenta_cobrar, cob.id_caja, cob.monto_cheque_cobro, cob.nro_cheque_cobro, cob.id_banco, clie.descripcion_cliente \n"
                + "	FROM public.cobro cob \n"
                + "	INNER JOIN cuenta_cobrar cue ON cob.id_cuenta_cobrar = cue.id_cuenta_cobrar \n"
                + "	INNER JOIN venta ven  ON cue.id_venta = ven.id_venta \n"
                + "	INNER JOIN cliente clie ON ven.id_cliente = clie.id_cliente \n"
                + "     WHERE cob.estado_cobro = 'pendiente' \n"
                + "	and clie.descripcion_cliente ilike ? \n"
                + "	and cob.fecha_cobro  between ? and ? \n"
                + "     ORDER BY cob.id_cobro";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeCobros;
            } else {
                do {
                    id_cobro = rs.getInt("id_cobro");
                    nro_cobro = rs.getString("numero_cobro");
                    descrip_cobro = rs.getString("descripcion_cobro");
                    fecha_cobro = rs.getString("fecha_cobro");
                    total_cobro = rs.getInt("total_cobro");
                    estado_cobro = rs.getString("estado_cobro");
                    nom_usu_mod = rs.getString("nombre_usuario_modificacion");
                    id_cta_cobrar = rs.getInt("id_cuenta_cobrar");
                    id_venta = rs.getInt("id_venta");
                    id_caja = rs.getInt("id_caja");
                    monto_cheque = rs.getInt("monto_cheque");
                    nro_cheque = rs.getString("nro_cheque");
                    id_banco = rs.getInt("id_banco");
                    informeCobrosHallado = new InformeCobros(id_cobro, total_cobro, id_cta_cobrar, id_venta, id_caja, monto_cobrod, id_banco, monto_cheque, descrip_cobro, fecha_cobro, estado_cobro, nom_usu_mod);
                    informeCobros.add(informeCobrosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeCobros;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeCobros> buscarInformeCobrosFecha(String fechainitxt, String fechafintxt) {
        int r = 0;
        Variables.sumarventa = 0.0;
        InformeCobros inf = new InformeCobros();
        ArrayList<InformeCobros> informeCobros = new ArrayList<>();
        String sql = "SELECT cob.id_cobro, cob.numero_cobro, cob.descripcion_cobro, cob.fecha_cobro, cob.total_cobro, cob.estado_cobro, cob.nombre_usuario_modificacion, \n"
                + "     cob.id_cuenta_cobrar, cob.id_caja, cob.monto_cheque_cobro, cob.nro_cheque_cobro, cob.id_banco, clie.descripcion_cliente \n"
                + "	FROM public.cobro cob \n"
                + "	INNER JOIN cuenta_cobrar cue ON cob.id_cuenta_cobrar = cue.id_cuenta_cobrar \n"
                + "	INNER JOIN venta ven  ON cue.id_venta = ven.id_venta \n"
                + "	INNER JOIN cliente clie ON ven.id_cliente = clie.id_cliente \n"
                + "     WHERE cob.estado_cobro = 'pendiente' \n"
                + "	and cob.fecha_cobro  between ? and ? \n"
                + "     ORDER BY cob.id_cobro";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fechainitxt);
            ps.setString(2, fechafintxt);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeCobros;
            } else {
                do {
                    id_cobro = rs.getInt("id_cobro");
                    nro_cobro = rs.getString("numero_cobro");
                    descrip_cobro = rs.getString("descripcion_cobro");
                    fecha_cobro = rs.getString("fecha_cobro");
                    total_cobro = rs.getInt("total_cobro");
                    estado_cobro = rs.getString("estado_cobro");
                    nom_usu_mod = rs.getString("nombre_usuario_modificacion");
                    id_cta_cobrar = rs.getInt("id_cuenta_cobrar");
                    id_venta = rs.getInt("id_venta");
                    id_caja = rs.getInt("id_caja");
                    monto_cheque = rs.getInt("monto_cheque");
                    nro_cheque = rs.getString("nro_cheque");
                    id_banco = rs.getInt("id_banco");
                    informeCobrosHallado = new InformeCobros(id_cobro, total_cobro, id_cta_cobrar, id_venta, id_caja, monto_cobrod, id_banco, monto_cheque, descrip_cobro, fecha_cobro, estado_cobro, nom_usu_mod);
                    informeCobros.add(informeCobrosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeCobros;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeCobros> buscarInformeCobrosGeneral() {
        int r = 0;
        Variables.sumarventa = 0.0;
        InformeCobros inf = new InformeCobros();
        ArrayList<InformeCobros> informeCobros = new ArrayList<>();
        String sql = "SELECT cob.id_cobro, cob.numero_cobro, cob.descripcion_cobro, cob.fecha_cobro, cob.total_cobro, cob.estado_cobro, cob.nombre_usuario_modificacion, \n"
                + "     cob.id_cuenta_cobrar, cob.id_caja, cob.monto_cheque_cobro, cob.nro_cheque_cobro, cob.id_banco, clie.descripcion_cliente \n"
                + "	FROM public.cobro cob \n"
                + "	INNER JOIN cuenta_cobrar cue ON cob.id_cuenta_cobrar = cue.id_cuenta_cobrar \n"
                + "	INNER JOIN venta ven  ON cue.id_venta = ven.id_venta \n"
                + "	INNER JOIN cliente clie ON ven.id_cliente = clie.id_cliente \n"
                + "     WHERE cob.estado_cobro = 'pendiente' \n"
                + "     ORDER BY cob.id_cobro";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeCobros;
            } else {
                do {
                    id_cobro = rs.getInt("id_cobro");
                    nro_cobro = rs.getString("numero_cobro");
                    descrip_cobro = rs.getString("descripcion_cobro");
                    fecha_cobro = rs.getString("fecha_cobro");
                    total_cobro = rs.getInt("total_cobro");
                    estado_cobro = rs.getString("estado_cobro");
                    nom_usu_mod = rs.getString("nombre_usuario_modificacion");
                    id_cta_cobrar = rs.getInt("id_cuenta_cobrar");
                    id_venta = rs.getInt("id_venta");
                    id_caja = rs.getInt("id_caja");
                    monto_cheque = rs.getInt("monto_cheque");
                    nro_cheque = rs.getString("nro_cheque");
                    id_banco = rs.getInt("id_banco");
                    informeCobrosHallado = new InformeCobros(id_cobro, total_cobro, id_cta_cobrar, id_venta, id_caja, monto_cobrod, id_banco, monto_cheque, descrip_cobro, fecha_cobro, estado_cobro, nom_usu_mod);
                    informeCobros.add(informeCobrosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeCobros;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
