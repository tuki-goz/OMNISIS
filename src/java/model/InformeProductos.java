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
public class InformeProductos {
    
    
    int id_producto;
    String descripcion_producto;
    String estado_producto;
    String nombre_usu_mod_producto;
    String descripcion_impuesto;
    int id_impuesto;
    int cifra_imp;
    int precio_u_producto;
    int cantidad;

    public InformeProductos() {
    }

    public InformeProductos(int id_producto, String descripcion_producto, String estado_producto, String nombre_usu_mod_producto, String descripcion_impuesto, int id_impuesto) {
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.estado_producto = estado_producto;
        this.nombre_usu_mod_producto = nombre_usu_mod_producto;
        this.descripcion_impuesto = descripcion_impuesto;
        this.id_impuesto = id_impuesto;
    }

    public InformeProductos(int id_producto, String descripcion_producto, String estado_producto, int id_impuesto) {
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.estado_producto = estado_producto;
        this.id_impuesto = id_impuesto;
    }

    public InformeProductos(int id_producto, String descripcion_producto, String estado_producto, int cifra_imp, int precio_u_producto, int cantidad) {
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.estado_producto = estado_producto;
        this.cifra_imp = cifra_imp;
        this.precio_u_producto = precio_u_producto;
        this.cantidad = cantidad;
    }

    public InformeProductos(int id_producto, String descripcion_producto, int cifra_imp, int precio_u_producto, int cantidad) {
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.cifra_imp = cifra_imp;
        this.precio_u_producto = precio_u_producto;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCifra_imp() {
        return cifra_imp;
    }

    public void setCifra_imp(int cifra_imp) {
        this.cifra_imp = cifra_imp;
    }

    public int getPrecio_u_producto() {
        return precio_u_producto;
    }

    public void setPrecio_u_producto(int precio_u_producto) {
        this.precio_u_producto = precio_u_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(String estado_producto) {
        this.estado_producto = estado_producto;
    }

    public String getNombre_usu_mod_producto() {
        return nombre_usu_mod_producto;
    }

    public void setNombre_usu_mod_producto(String nombre_usu_mod_producto) {
        this.nombre_usu_mod_producto = nombre_usu_mod_producto;
    }

    public String getDescripcion_impuesto() {
        return descripcion_impuesto;
    }

    public void setDescripcion_impuesto(String descripcion_impuesto) {
        this.descripcion_impuesto = descripcion_impuesto;
    }

    public int getId_impuesto() {
        return id_impuesto;
    }

    public void setId_impuesto(int id_impuesto) {
        this.id_impuesto = id_impuesto;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private InformeProductos informeProductosHallado;
    
     public ArrayList<InformeProductos> leerInformeProductosAc() {
        ArrayList<InformeProductos> informeProductos = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT pro.id_producto, pro.descripcion_producto, pro.estado_producto, imp.cifra, pro.precio_unitario, pro.cantidad \n"
                    + "  FROM public.producto pro \n"
                    + "  INNER JOIN impuesto imp \n"
                    + "  ON imp.id_impuesto = pro.id_impuesto \n"
                    + "  WHERE estado_producto='activo' \n"
                    + "  ORDER BY id_producto");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeProductos;
            } else {
                do {
                    id_producto = rs.getInt("id_producto");
                    descripcion_producto = rs.getString("descripcion_producto");
                    estado_producto = rs.getString("estado_producto");
                    cifra_imp = rs.getInt("cifra");
                    precio_u_producto = rs.getInt("precio_unitario");
                    cantidad = rs.getInt("cantidad");
                    informeProductosHallado = new InformeProductos(id_producto, descripcion_producto, estado_producto, cifra_imp, precio_u_producto, cantidad);
                    informeProductos.add(informeProductosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeProductos;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeProductos> leerInformeProductosIna() {
        ArrayList<InformeProductos> informeProductos = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_producto, descripcion_producto, estado_producto, id_impuesto, precio_unitario, cantidad \n"
                    + "FROM public.producto\n"
                    + "WHERE estado_producto='inactivo'\n"
                    + "ORDER BY id_producto");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeProductos;
            } else {
                do {
                    id_producto = rs.getInt("id_producto");
                    descripcion_producto = rs.getString("descripcion_producto");
                    estado_producto = rs.getString("estado_producto");
                    id_impuesto = rs.getInt("id_impuesto");
                    precio_u_producto = rs.getInt("precio_unitario");
                    cantidad = rs.getInt("cantidad");
                    informeProductosHallado = new InformeProductos(id_producto, descripcion_producto, estado_producto, id_impuesto, precio_u_producto, cantidad);
                    informeProductos.add(informeProductosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeProductos;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
