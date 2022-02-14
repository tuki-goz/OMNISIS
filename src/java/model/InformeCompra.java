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
 * @author Alvaro
 */
public class InformeCompra implements ValidarInformeCompra {

    int id_compra, id_proveedor, id_contrato, id_moneda, id_usuario, id_compra_Det, cantidad_Det, id_orden_compra, cod;
    String codigo, proveedor, fecha_compra, estado_compra, nom_usu_mod, fecha_mod, descripcion_Det, descrip_prov, cod_contrato, descrip_moneda, descrip_orden, nombre_usuario;
    Double total_compra, iva5_Det, iva10_Det, exenta_Det, precio_Det;

    public InformeCompra() {
    }

    //CONSTRUCTOR PARA INFORME
    public InformeCompra(int id_compra, String codigo, String fecha_compra, String estado_compra, String descrip_prov, String cod_contrato, Double total_compra) {
        this.id_compra = id_compra;
        this.codigo = codigo;
        this.fecha_compra = fecha_compra;
        this.estado_compra = estado_compra;
        this.descrip_prov = descrip_prov;
        this.cod_contrato = cod_contrato;
        this.total_compra = total_compra;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_moneda() {
        return id_moneda;
    }

    public void setId_moneda(int id_moneda) {
        this.id_moneda = id_moneda;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_compra_Det() {
        return id_compra_Det;
    }

    public void setId_compra_Det(int id_compra_Det) {
        this.id_compra_Det = id_compra_Det;
    }

    public int getCantidad_Det() {
        return cantidad_Det;
    }

    public void setCantidad_Det(int cantidad_Det) {
        this.cantidad_Det = cantidad_Det;
    }

    public int getId_orden_compra() {
        return id_orden_compra;
    }

    public void setId_orden_compra(int id_orden_compra) {
        this.id_orden_compra = id_orden_compra;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getEstado_compra() {
        return estado_compra;
    }

    public void setEstado_compra(String estado_compra) {
        this.estado_compra = estado_compra;
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

    public String getDescripcion_Det() {
        return descripcion_Det;
    }

    public void setDescripcion_Det(String descripcion_Det) {
        this.descripcion_Det = descripcion_Det;
    }

    public String getDescrip_prov() {
        return descrip_prov;
    }

    public void setDescrip_prov(String descrip_prov) {
        this.descrip_prov = descrip_prov;
    }

    public String getCod_contrato() {
        return cod_contrato;
    }

    public void setCod_contrato(String cod_contrato) {
        this.cod_contrato = cod_contrato;
    }

    public String getDescrip_moneda() {
        return descrip_moneda;
    }

    public void setDescrip_moneda(String descrip_moneda) {
        this.descrip_moneda = descrip_moneda;
    }

    public String getDescrip_orden() {
        return descrip_orden;
    }

    public void setDescrip_orden(String descrip_orden) {
        this.descrip_orden = descrip_orden;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public Double getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(Double total_compra) {
        this.total_compra = total_compra;
    }

    public Double getIva5_Det() {
        return iva5_Det;
    }

    public void setIva5_Det(Double iva5_Det) {
        this.iva5_Det = iva5_Det;
    }

    public Double getIva10_Det() {
        return iva10_Det;
    }

    public void setIva10_Det(Double iva10_Det) {
        this.iva10_Det = iva10_Det;
    }

    public Double getExenta_Det() {
        return exenta_Det;
    }

    public void setExenta_Det(Double exenta_Det) {
        this.exenta_Det = exenta_Det;
    }

    public Double getPrecio_Det() {
        return precio_Det;
    }

    public void setPrecio_Det(Double precio_Det) {
        this.precio_Det = precio_Det;
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
    private InformeCompra informeCompraHallado;
    

//    public InformeCompra buscarInformeCompra(String fechainitxt, String fechafintxt, String buscartxt) {      // ENCENDER ESTA FUNCION PARA VOLVER A VERSION 1
//        int r = 0;
//        InformeCompra inf = new InformeCompra();
//        String sql = "SELECT com.id_compra, com.codigo_compra, com.fecha_compra, com.total_compra, com.estado_compra, prov.nombre_proveedor, cont.cliente_contrato \n"
//                + "	FROM public.compra com \n"
//                + "	inner join proveedor prov \n"
//                + "	on com.id_proveedor = prov.id_proveedor \n"
//                + "	inner join contrato cont \n"
//                + "	on com.id_contrato = cont.id_contrato \n"
//                + "	 WHERE fecha_compra  between ? and ? \n"
//                + "	 and cont.cliente_contrato ilike ?";
//
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, fechainitxt);
//            ps.setString(2, fechafintxt);
//            ps.setString(3, buscartxt);
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                r = r + 1;
//                inf.setId_compra(rs.getInt("id_compra"));
//                inf.setCodigo(rs.getString("codigo_compra"));
//                inf.setFecha_compra(rs.getString("fecha_compra"));
//                inf.setTotal_compra(rs.getDouble("total_compra"));
//                inf.setEstado_compra(rs.getString("estado_compra"));
//                inf.setDescrip_prov(rs.getString("nombre_proveedor"));
//                inf.setCod_contrato(rs.getString("cliente_contrato"));
//
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("");
//
//        } finally {
//            return inf;
//        }
//
//    }
    public ArrayList<InformeCompra> buscarInformeCompraClienteyFecha(String buscartxt, String fechainitxt, String fechafintxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Variables.sumarcompra = 0.0;
        InformeCompra inf = new InformeCompra();
        ArrayList<InformeCompra> informeCompra = new ArrayList<>();
        String sql = "SELECT com.id_compra, com.codigo_compra, com.fecha_compra, com.total_compra, com.estado_compra, prov.nombre_proveedor, cont.cliente_contrato \n"
                + "	FROM public.compra com \n"
                + "	inner join proveedor prov \n"
                + "	on com.id_proveedor = prov.id_proveedor \n"
                + "	inner join contrato cont \n"
                + "	on com.id_contrato = cont.id_contrato \n"
                + "     WHERE com.estado_compra = 'activo' \n"
                + "	and cont.cliente_contrato ilike ? \n"
                + "	and fecha_compra  between ? and ? \n"                
                + "     ORDER BY com.id_compra";
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
                return null;
            } else {
                do {
                    id_compra = rs.getInt("id_compra");
                    codigo = rs.getString("codigo_compra");
                    fecha_compra = rs.getString("fecha_compra");
                    total_compra = rs.getDouble("total_compra");
                    estado_compra = rs.getString("estado_compra");
                    descrip_prov = rs.getString("nombre_proveedor");
                    cod_contrato = rs.getString("cliente_contrato");
                    Variables.sumarcompra = Variables.sumarcompra + total_compra;
                    informeCompraHallado = new InformeCompra(id_compra, codigo, fecha_compra, estado_compra, descrip_prov, cod_contrato, total_compra);
                    informeCompra.add(informeCompraHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeCompra;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeCompra> leerInformeCompraAc() {
        ArrayList<InformeCompra> informeCompra = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT com.id_compra, com.codigo_compra, com.fecha_compra, com.total_compra, com.estado_compra, prov.nombre_proveedor, cont.cliente_contrato \n"
                    + "	FROM public.compra com \n"
                    + "	inner join proveedor prov \n"
                    + "	on com.id_proveedor = prov.id_proveedor \n"
                    + "	inner join contrato cont \n"
                    + "	on com.id_contrato = cont.id_contrato \n"
                    + "  WHERE com.estado_compra = 'activo' \n"
                    + "  ORDER BY com.id_compra");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeCompra;
            } else {
                do {
                    id_compra = rs.getInt("id_compra");
                    codigo = rs.getString("codigo_compra");
                    fecha_compra = rs.getString("fecha_compra");
                    total_compra = rs.getDouble("total_compra");
                    estado_compra = rs.getString("estado_compra");
                    descrip_prov = rs.getString("nombre_proveedor");
                    cod_contrato = rs.getString("cliente_contrato");

                    informeCompraHallado = new InformeCompra(id_compra, codigo, fecha_compra, estado_compra, descrip_prov, cod_contrato, total_compra);
                    informeCompra.add(informeCompraHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeCompra;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<InformeCompra> leerInformeCompraIna() {
        ArrayList<InformeCompra> informeCompra = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT com.id_compra, com.codigo_compra, com.fecha_compra, com.total_compra, com.estado_compra, prov.nombre_proveedor, cont.cliente_contrato \n"
                    + "	FROM public.compra com \n"
                    + "	inner join proveedor prov \n"
                    + "	on com.id_proveedor = prov.id_proveedor \n"
                    + "	inner join contrato cont \n"
                    + "	on com.id_contrato = cont.id_contrato \n"
                    + "  WHERE com.estado_compra = 'inactivo' \n"
                    + "  ORDER BY com.id_compra");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeCompra;
            } else {
                do {
                    id_compra = rs.getInt("id_compra");
                    codigo = rs.getString("codigo_compra");
                    fecha_compra = rs.getString("fecha_compra");
                    total_compra = rs.getDouble("total_compra");
                    estado_compra = rs.getString("estado_compra");
                    descrip_prov = rs.getString("nombre_proveedor");
                    cod_contrato = rs.getString("cliente_contrato");

                    informeCompraHallado = new InformeCompra(id_compra, codigo, fecha_compra, estado_compra, descrip_prov, cod_contrato, total_compra);
                    informeCompra.add(informeCompraHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeCompra;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

//    public ArrayList<InformeCompra> leerInforme(String cod) {
//        ArrayList<InformeCompra> informeCompra = new ArrayList<>();
//        try {
//            con = ConectaBD.abrir();
//            stm = con.createStatement();
//            rs = stm.executeQuery("SELECT com.id_compra, com.codigo_compra, com.fecha_compra, com.total_compra, com.estado_compra, prov.nombre_proveedor, cont.cliente_contrato \n"
//                    + "	FROM public.compra com \n"
//                    + "	inner join proveedor prov \n"
//                    + "	on com.id_proveedor = prov.id_proveedor \n"
//                    + "	inner join contrato cont \n"
//                    + "	on com.id_contrato = cont.id_contrato \n"
//                    + "	 WHERE fecha_compra  between '2021-09-04' and '2021-09-08' \n"
//                    + "	 and cont.cliente_contrato ilike ?" );
//
////            ("SELECT id_compra_detalle, cantidad_compra_d, descripcion, iva5_compra_d, iva10_compra_d, excentas_compra_d, \n"
////                    + "precio_compra_d, id_compra, id_orden_compra\n"
////                    + "FROM public.compra_detalle\n"
////                    + "WHERE id_compra = " + cod + "");
//            if (!rs.next()) {
//                System.out.println("No se encontro el registro");
//                ConectaBD.cerrar();
//                return null;
//            } else {
//                do {
//                    id_compra = rs.getInt("id_compra");
//                    codigo = rs.getString("codigo_compra");
//                    fecha_compra = rs.getString("fecha_compra");                    
//                    estado_compra = rs.getString("estado_compra");
//                    descrip_prov = rs.getString("nombre_proveedor");
//                    cod_contrato = rs.getString("cliente_contrato");
//                    total_compra = rs.getDouble("total_compra");
//                    
//                    informeCompraHallado = new InformeCompra(id_compra, codigo, fecha_compra, estado_compra, descrip_prov, cod_contrato, total_compra);
//                    informeCompra.add(informeCompraHallado);
//                } while (rs.next());
//                ConectaBD.cerrar();
//                return informeCompra;
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error en la base de datos");
//            e.printStackTrace();
//            return null;
//        }
//    }
}
