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
public class InformePagos {

    int id_pag, total_pag, id_impor, id_cta_pag, id_caja, id_prov, id_aper;
    String nro_pag, descrip_pag, fecha_pag, nom_usu_mod, fecha_mod;
    //DETALLE
    int id_pagd, monto_pagd, cuota_pagd, id_tp;
    String descrip_pagd;

    //CONSTRUCTOR CABECERA
    public InformePagos(int id_pag, int total_pag, int id_impor, int id_cta_pag, int id_caja, String nro_pag, String descrip_pag, String fecha_pag, String nom_usu_mod, String fecha_mod) {
        this.id_pag = id_pag;
        this.total_pag = total_pag;
        this.id_impor = id_impor;
        this.id_cta_pag = id_cta_pag;
        this.id_caja = id_caja;
        this.nro_pag = nro_pag;
        this.descrip_pag = descrip_pag;
        this.fecha_pag = fecha_pag;
        this.nom_usu_mod = nom_usu_mod;
        this.fecha_mod = fecha_mod;
    }

    //CONSTRUCTOR DETALLE
    public InformePagos(int id_pagd, int monto_pagd, int cuota_pagd, int id_tp, String descrip_pagd) {
        this.id_pagd = id_pagd;
        this.monto_pagd = monto_pagd;
        this.cuota_pagd = cuota_pagd;
        this.id_tp = id_tp;
        this.descrip_pagd = descrip_pagd;
    }

    public InformePagos(int id_pag, int total_pag, int id_cta_pag, int id_prov, int id_aper, String nro_pag, String descrip_pag, String fecha_pag, String nom_usu_mod) {
        this.id_pag = id_pag;
        this.total_pag = total_pag;
        this.id_cta_pag = id_cta_pag;
        this.id_prov = id_prov;
        this.id_aper = id_aper;
        this.nro_pag = nro_pag;
        this.descrip_pag = descrip_pag;
        this.fecha_pag = fecha_pag;
        this.nom_usu_mod = nom_usu_mod;
    }
    
    

    //CONSTRUCTOR VACIO
    public InformePagos() {
    }

    //GET Y SET

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public int getId_aper() {
        return id_aper;
    }

    public void setId_aper(int id_aper) {
        this.id_aper = id_aper;
    }
        
    public int getId_pag() {
        return id_pag;
    }

    public void setId_pag(int id_pag) {
        this.id_pag = id_pag;
    }

    public int getTotal_pag() {
        return total_pag;
    }

    public void setTotal_pag(int total_pag) {
        this.total_pag = total_pag;
    }

    public int getId_impor() {
        return id_impor;
    }

    public void setId_impor(int id_impor) {
        this.id_impor = id_impor;
    }

    public int getId_cta_pag() {
        return id_cta_pag;
    }

    public void setId_cta_pag(int id_cta_pag) {
        this.id_cta_pag = id_cta_pag;
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }

    public String getNro_pag() {
        return nro_pag;
    }

    public void setNro_pag(String nro_pag) {
        this.nro_pag = nro_pag;
    }

    public String getDescrip_pag() {
        return descrip_pag;
    }

    public void setDescrip_pag(String descrip_pag) {
        this.descrip_pag = descrip_pag;
    }

    public String getFecha_pag() {
        return fecha_pag;
    }

    public void setFecha_pag(String fecha_pag) {
        this.fecha_pag = fecha_pag;
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

    public int getId_pagd() {
        return id_pagd;
    }

    public void setId_pagd(int id_pagd) {
        this.id_pagd = id_pagd;
    }

    public int getMonto_pagd() {
        return monto_pagd;
    }

    public void setMonto_pagd(int monto_pagd) {
        this.monto_pagd = monto_pagd;
    }

    public int getCuota_pagd() {
        return cuota_pagd;
    }

    public void setCuota_pagd(int cuota_pagd) {
        this.cuota_pagd = cuota_pagd;
    }

    public int getId_tp() {
        return id_tp;
    }

    public void setId_tp(int id_tp) {
        this.id_tp = id_tp;
    }

    public String getDescrip_pagd() {
        return descrip_pagd;
    }

    public void setDescrip_pagd(String descrip_pagd) {
        this.descrip_pagd = descrip_pagd;
    }

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private InformePagos informePagosHallado;

    public ArrayList<InformePagos> leerInformePagosAc() {
        ArrayList<InformePagos> informePagos = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_pago, numero_pago, descripcion_pago, fecha_pago, total_pago, nombre_usuario_modificacion, fecha_modificacion,  id_cuenta_pagar, id_apertura_cierre_caja, id_proveedor \n"
                    + "	FROM public.pago; \n"                    
                    + "  ORDER BY id_pago");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informePagos;
            } else {
                do {
                    id_pag = rs.getInt("id_producto");
                    nro_pag = rs.getString("descripcion_producto");
                    descrip_pag = rs.getString("estado_producto");
                    fecha_pag = rs.getString("cifra");
                    total_pag = rs.getInt("precio_unitario");
                    nom_usu_mod = rs.getString("precio_unitario");
                    fecha_mod = rs.getString("precio_unitario");
                    id_cta_pag = rs.getInt("cantidad");
                    id_aper = rs.getInt("cantidad");
                    id_prov = rs.getInt("cantidad");
                    informePagosHallado = new InformePagos( id_pag,  total_pag,  id_cta_pag,  id_prov,  id_aper,  nro_pag,  descrip_pag,  fecha_pag,  nom_usu_mod);
                    informePagos.add(informePagosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informePagos;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformePagos> leerInformePagosIna() {
        ArrayList<InformePagos> informePagos = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_pago, numero_pago, descripcion_pago, fecha_pago, total_pago, nombre_usuario_modificacion, fecha_modificacion,  id_cuenta_pagar, id_apertura_cierre_caja, id_proveedor \n"
                    + "	FROM public.pago; \n"                    
                    + "  ORDER BY id_pago");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informePagos;
            } else {
                do {
                    id_pag = rs.getInt("id_producto");
                    nro_pag = rs.getString("descripcion_producto");
                    descrip_pag = rs.getString("estado_producto");
                    fecha_pag = rs.getString("cifra");
                    total_pag = rs.getInt("precio_unitario");
                    nom_usu_mod = rs.getString("precio_unitario");
                    fecha_mod = rs.getString("precio_unitario");
                    id_cta_pag = rs.getInt("cantidad");
                    id_aper = rs.getInt("cantidad");
                    id_prov = rs.getInt("cantidad");
                    informePagosHallado = new InformePagos( id_pag,  total_pag,  id_cta_pag,  id_prov,  id_aper,  nro_pag,  descrip_pag,  fecha_pag,  nom_usu_mod);
                    informePagos.add(informePagosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informePagos;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
