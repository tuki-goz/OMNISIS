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
public class Ordencompra implements ValidarOrdenCompra {

    public Ordencompra() {
    }

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    PreparedStatement ps2;
    PreparedStatement ps3;
    PreparedStatement ps4;
    ResultSet rs;
    ResultSet rs2;
    private String sSQL = "";
    private String sSQL2 = "";



    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////NUEVA LOGICA///////////////////////////////////////
    //CABECERA
    int id_orden_com, id_prov, id_st, id_usu, id_cond, id_cont,
            total_pagar_orden_com, liq5_total_orden_com, liq10_total_orden_com, liq_total_orden_com,
            exenta_sub_orden_com, iva5_sub_orden_com, iva10_sub_orden_com;
    String nro_orden_com, condicion_orden_com, fecha_pedido_orden_com,
            estado_orden_com, nom_usu_mod, fecha_mod, nombre_prov, numero_st, codigo_cont;
    //DETALLE
    int id_orden_comd, cant_orden_comd, id_pr, precio_orden_comd, exenta_orden_comd, iva5_orden_comd, iva10_orden_comd;
    String descrip_orden_comd;

    public Ordencompra(int id_orden_com, int id_prov, int id_st, int id_usu, int id_cond, int id_cont, int total_pagar_orden_com, int liq5_total_orden_com, int liq10_total_orden_com, int exenta_sub_orden_com, int iva5_sub_orden_com, int iva10_sub_orden_com, String nro_orden_com, String condicion_orden_com, String fecha_pedido_orden_com, String estado_orden_com, String nom_usu_mod, String fecha_mod) {
        this.id_orden_com = id_orden_com;
        this.id_prov = id_prov;
        this.id_st = id_st;
        this.id_usu = id_usu;
        this.id_cond = id_cond;
        this.id_cont = id_cont;
        this.total_pagar_orden_com = total_pagar_orden_com;
        this.liq5_total_orden_com = liq5_total_orden_com;
        this.liq10_total_orden_com = liq10_total_orden_com;
        this.exenta_sub_orden_com = exenta_sub_orden_com;
        this.iva5_sub_orden_com = iva5_sub_orden_com;
        this.iva10_sub_orden_com = iva10_sub_orden_com;
        this.nro_orden_com = nro_orden_com;
        this.condicion_orden_com = condicion_orden_com;
        this.fecha_pedido_orden_com = fecha_pedido_orden_com;
        this.estado_orden_com = estado_orden_com;
        this.nom_usu_mod = nom_usu_mod;
        this.fecha_mod = fecha_mod;
    }

    public String getCondicion_orden_com() {
        return condicion_orden_com;
    }

    public void setCondicion_orden_com(String condicion_orden_com) {
        this.condicion_orden_com = condicion_orden_com;
    }

    public int getLiq_total_orden_com() {
        return liq_total_orden_com;
    }

    public void setLiq_total_orden_com(int liq_total_orden_com) {
        this.liq_total_orden_com = liq_total_orden_com;
    }

    public int getId_orden_comd() {
        return id_orden_comd;
    }

    public void setId_orden_comd(int id_orden_comd) {
        this.id_orden_comd = id_orden_comd;
    }

    public int getCant_orden_comd() {
        return cant_orden_comd;
    }

    public void setCant_orden_comd(int cant_orden_comd) {
        this.cant_orden_comd = cant_orden_comd;
    }

    public int getId_pr() {
        return id_pr;
    }

    public void setId_pr(int id_pr) {
        this.id_pr = id_pr;
    }

    public int getPrecio_orden_comd() {
        return precio_orden_comd;
    }

    public void setPrecio_orden_comd(int precio_orden_comd) {
        this.precio_orden_comd = precio_orden_comd;
    }

    public int getExenta_orden_comd() {
        return exenta_orden_comd;
    }

    public void setExenta_orden_comd(int exenta_orden_comd) {
        this.exenta_orden_comd = exenta_orden_comd;
    }

    public int getIva5_orden_comd() {
        return iva5_orden_comd;
    }

    public void setIva5_orden_comd(int iva5_orden_comd) {
        this.iva5_orden_comd = iva5_orden_comd;
    }

    public int getIva10_orden_comd() {
        return iva10_orden_comd;
    }

    public void setIva10_orden_comd(int iva10_orden_comd) {
        this.iva10_orden_comd = iva10_orden_comd;
    }

    public String getDescrip_orden_comd() {
        return descrip_orden_comd;
    }

    public void setDescrip_orden_comd(String descrip_orden_comd) {
        this.descrip_orden_comd = descrip_orden_comd;
    }

    public int getId_orden_com() {
        return id_orden_com;
    }

    public void setId_orden_com(int id_orden_com) {
        this.id_orden_com = id_orden_com;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public int getId_st() {
        return id_st;
    }

    public void setId_st(int id_st) {
        this.id_st = id_st;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public int getId_cond() {
        return id_cond;
    }

    public void setId_cond(int id_cond) {
        this.id_cond = id_cond;
    }

    public int getId_cont() {
        return id_cont;
    }

    public void setId_cont(int id_cont) {
        this.id_cont = id_cont;
    }

    public int getTotal_pagar_orden_com() {
        return total_pagar_orden_com;
    }

    public void setTotal_pagar_orden_com(int total_pagar_orden_com) {
        this.total_pagar_orden_com = total_pagar_orden_com;
    }

    public int getLiq5_total_orden_com() {
        return liq5_total_orden_com;
    }

    public void setLiq5_total_orden_com(int liq5_total_orden_com) {
        this.liq5_total_orden_com = liq5_total_orden_com;
    }

    public int getLiq10_total_orden_com() {
        return liq10_total_orden_com;
    }

    public void setLiq10_total_orden_com(int liq10_total_orden_com) {
        this.liq10_total_orden_com = liq10_total_orden_com;
    }

    public int getExenta_sub_orden_com() {
        return exenta_sub_orden_com;
    }

    public void setExenta_sub_orden_com(int exenta_sub_orden_com) {
        this.exenta_sub_orden_com = exenta_sub_orden_com;
    }

    public int getIva5_sub_orden_com() {
        return iva5_sub_orden_com;
    }

    public void setIva5_sub_orden_com(int iva5_sub_orden_com) {
        this.iva5_sub_orden_com = iva5_sub_orden_com;
    }

    public int getIva10_sub_orden_com() {
        return iva10_sub_orden_com;
    }

    public void setIva10_sub_orden_com(int iva10_sub_orden_com) {
        this.iva10_sub_orden_com = iva10_sub_orden_com;
    }

    public String getNro_orden_com() {
        return nro_orden_com;
    }

    public void setNro_orden_com(String nro_orden_com) {
        this.nro_orden_com = nro_orden_com;
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

    public String getNombre_prov() {
        return nombre_prov;
    }

    public void setNombre_prov(String nombre_prov) {
        this.nombre_prov = nombre_prov;
    }

    public String getNumero_st() {
        return numero_st;
    }

    public void setNumero_st(String numero_st) {
        this.numero_st = numero_st;
    }

    public String getCodigo_cont() {
        return codigo_cont;
    }

    public void setCodigo_cont(String codigo_cont) {
        this.codigo_cont = codigo_cont;
    }

    public Ordencompra(int id_orden_comd, int cant_orden_comd, int id_pr, int precio_orden_comd, int exenta_orden_comd, int iva5_orden_comd, int iva10_orden_comd, String descrip_orden_comd) {
        this.id_orden_comd = id_orden_comd;
        this.cant_orden_comd = cant_orden_comd;
        this.id_pr = id_pr;
        this.precio_orden_comd = precio_orden_comd;
        this.exenta_orden_comd = exenta_orden_comd;
        this.iva5_orden_comd = iva5_orden_comd;
        this.iva10_orden_comd = iva10_orden_comd;
        this.descrip_orden_comd = descrip_orden_comd;
    }

    public Ordencompra(int id_orden_com, int total_pagar_orden_com, String nro_orden_com, String fecha_pedido_orden_com, String estado_orden_com, String nombre_prov, String numero_st, String codigo_cont) {
        this.id_orden_com = id_orden_com;
        this.total_pagar_orden_com = total_pagar_orden_com;
        this.nro_orden_com = nro_orden_com;
        this.fecha_pedido_orden_com = fecha_pedido_orden_com;
        this.estado_orden_com = estado_orden_com;
        this.nombre_prov = nombre_prov;
        this.numero_st = numero_st;
        this.codigo_cont = codigo_cont;
    }

    public String getFecha_pedido_orden_com() {
        return fecha_pedido_orden_com;
    }

    public void setFecha_pedido_orden_com(String fecha_pedido_orden_com) {
        this.fecha_pedido_orden_com = fecha_pedido_orden_com;
    }

    public String getEstado_orden_com() {
        return estado_orden_com;
    }

    public void setEstado_orden_com(String estado_orden_com) {
        this.estado_orden_com = estado_orden_com;
    }

    private Statement stm;
    private Ordencompra ordenHallada;

    public ArrayList<Ordencompra> leerOrden() {
        ArrayList<Ordencompra> orden_compra = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT orden_com.id_orden_compra, orden_com.nro_orden_compra, orden_com.fecha_pedido_orden_compra, \n"
                    + "orden_com.estado_orden_compra, orden_com.total_pagar_orden_compra, prov.nombre_proveedor, st.numero_servicio_tecnico \n"
//                    + "(select cont.codigo_contrato from servicio_tecnico st left join contrato cont on st.id_contrato = cont.id_contrato) \n"
                    + "FROM public.orden_compra orden_com \n"
                    + "INNER JOIN proveedor prov \n"
                    + "ON orden_com.id_proveedor = prov.id_proveedor \n"
                    + "INNER JOIN servicio_tecnico st \n"
                    + "ON orden_com.id_servicio_tecnico = st.id_servicio_tecnico \n"
                    + "WHERE estado_orden_compra='pendiente' \n"
                    + "ORDER BY orden_com.id_orden_compra;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return orden_compra;
            } else {
                do {
                    id_orden_com = rs.getInt("id_orden_compra");
                    Variables.nro_orden = rs.getString("nro_orden_compra");
                    total_pagar_orden_com = rs.getInt("total_pagar_orden_compra");
                    fecha_pedido_orden_com = rs.getString("fecha_pedido_orden_compra");
                    estado_orden_com = rs.getString("estado_orden_compra");
                    nombre_prov = rs.getString("nombre_proveedor");
                    numero_st = rs.getString("numero_servicio_tecnico");
                    codigo_cont = rs.getString("nombre_proveedor");
                    ordenHallada = new Ordencompra(id_orden_com, total_pagar_orden_com, Variables.nro_orden, fecha_pedido_orden_com, estado_orden_com, nombre_prov, numero_st, codigo_cont);
                    orden_compra.add(ordenHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return orden_compra;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta leerOrden");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Ordencompra> buscarOrden(String buscartxt) {
        ArrayList<Ordencompra> orden_compra = new ArrayList<>();
        String sql = "SELECT orden_com.id_orden_compra, orden_com.nro_orden_compra, orden_com.fecha_pedido_orden_compra, \n"
                + "orden_com.estado_orden_compra, orden_com.total_pagar_orden_compra, prov.nombre_proveedor, st.numero_servicio_tecnico,\n"
                + "(select cont.codigo_contrato from servicio_tecnico st left join contrato cont on st.id_contrato = cont.id_contrato)\n"
                + "FROM public.orden_compra orden_com\n"
                + "INNER JOIN proveedor prov\n"
                + "ON orden_com.id_proveedor = prov.id_proveedor\n"
                + "INNER JOIN servicio_tecnico st\n"
                + "ON orden_com.id_servicio_tecnico = st.id_servicio_tecnico\n"
                + "WHERE orden_com.nro_orden_compra ILIKE ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return orden_compra;
            } else {
                do {
                    id_orden_com = rs.getInt("id_orden_compra");
                    nro_orden_com = rs.getString("nro_orden_compra");
                    total_pagar_orden_com = rs.getInt("total_pagar_orden_compra");
                    fecha_pedido_orden_com = rs.getString("fecha_pedido_orden_compra");
                    estado_orden_com = rs.getString("estado_orden_compra");
                    nombre_prov = rs.getString("nombre_proveedor");
                    numero_st = rs.getString("numero_servicio_tecnico");
                    codigo_cont = rs.getString("codigo_contrato");
                    ordenHallada = new Ordencompra(id_orden_com, total_pagar_orden_com, nro_orden_com, fecha_pedido_orden_com, estado_orden_com, nombre_prov, numero_st, codigo_cont);
                    orden_compra.add(ordenHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                return orden_compra;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Ordencompra editarOrdenCom(String editartxt) {
        int r = 0;
        Ordencompra orden_com = new Ordencompra();
        String sql = "SELECT orden_com.id_orden_compra, orden_com.nro_orden_compra, orden_com.fecha_pedido_orden_compra, \n"
                + "orden_com.direccion_entrega_orden_compra, prov.nombre_proveedor, prov.ruc_proveedor, \n"
                + "prov.telefono_proveedor, prov.ciudad_proveedor,st.descripcion_servicio_tecnico \n"
                + "FROM public.orden_compra orden_com \n"
                + "INNER JOIN orden_compra_detalle orden_comd \n"
                + "ON orden_com.id_orden_compra = orden_comd.id_orden_compra \n"
                + "INNER JOIN proveedor prov \n"
                + "ON orden_com.id_proveedor = prov.id_proveedor \n"
                + "INNER JOIN servicio_tecnico st\n"
                + "ON orden_com.id_servicio_tecnico = st.id_servicio_tecnico \n"
                + "WHERE orden_com.id_orden_compra = ?;";
        //FALTA EL DETALLE
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                orden_com.setId_orden_com(rs.getInt("id_orden_compra"));
                orden_com.setNro_orden_com(rs.getString("nro_orden_compra"));
                orden_com.setFecha_pedido_orden_com(rs.getString("fecha_pedido_orden_compra"));
                //FALTA DIRECCION, NOMBRE DEL PROVEEDOR, RUC, TELEFONO Y CIUDAD
                orden_com.setNumero_st(rs.getString("descripcion_servicio_tecnico"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");

        } finally {

            ConectaBD.cerrar();
            return orden_com;

        }
    }

    public int cancelarOrden(Ordencompra orden_com) {
        String sql = "UPDATE public.orden_compra\n"
                + "SET  estado_orden_compra='cancelado'\n"
                + "WHERE id_orden_compra=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, orden_com.getId_orden_com());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int aprobarOrden(Ordencompra orden_com) {
        String sql = "UPDATE public.orden_compra\n"
                + "SET  estado_orden_compra='aprobado'\n"
                + "WHERE id_orden_compra=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, orden_com.getId_orden_com());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Ordencompra> leerOrdenAprobados() {
        ArrayList<Ordencompra> orden_compra = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT orden_com.id_orden_compra, orden_com.nro_orden_compra, orden_com.fecha_pedido_orden_compra, \n"
                    + "orden_com.estado_orden_compra, orden_com.total_pagar_orden_compra, prov.nombre_proveedor, st.numero_servicio_tecnico,\n"
                    + "(select cont.codigo_contrato from servicio_tecnico st left join contrato cont on st.id_contrato = cont.id_contrato)\n"
                    + "FROM public.orden_compra orden_com\n"
                    + "INNER JOIN proveedor prov\n"
                    + "ON orden_com.id_proveedor = prov.id_proveedor\n"
                    + "INNER JOIN servicio_tecnico st\n"
                    + "ON orden_com.id_servicio_tecnico = st.id_servicio_tecnico\n"
                    + "WHERE estado_orden_compra='aprobado'\n"
                    + "ORDER BY orden_com.id_orden_compra;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return orden_compra;
            } else {
                do {
                    id_orden_com = rs.getInt("id_orden_compra");
                    Variables.nro_orden = rs.getString("nro_orden_compra");
                    total_pagar_orden_com = rs.getInt("total_pagar_orden_compra");
                    fecha_pedido_orden_com = rs.getString("fecha_pedido_orden_compra");
                    estado_orden_com = rs.getString("estado_orden_compra");
                    nombre_prov = rs.getString("nombre_proveedor");
                    numero_st = rs.getString("numero_servicio_tecnico");
                    codigo_cont = rs.getString("codigo_contrato");
                    ordenHallada = new Ordencompra(id_orden_com, total_pagar_orden_com, Variables.nro_orden, fecha_pedido_orden_com, estado_orden_com, nombre_prov, numero_st, codigo_cont);
                    orden_compra.add(ordenHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return orden_compra;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta leerOrden");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Ordencompra> leerOrdenCancelados() {
        ArrayList<Ordencompra> orden_compra = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT orden_com.id_orden_compra, orden_com.nro_orden_compra, orden_com.fecha_pedido_orden_compra, \n"
                    + "orden_com.estado_orden_compra, orden_com.total_pagar_orden_compra, prov.nombre_proveedor, st.numero_servicio_tecnico,\n"
                    + "(select cont.codigo_contrato from servicio_tecnico st left join contrato cont on st.id_contrato = cont.id_contrato)\n"
                    + "FROM public.orden_compra orden_com\n"
                    + "INNER JOIN proveedor prov\n"
                    + "ON orden_com.id_proveedor = prov.id_proveedor\n"
                    + "INNER JOIN servicio_tecnico st\n"
                    + "ON orden_com.id_servicio_tecnico = st.id_servicio_tecnico\n"
                    + "WHERE estado_orden_compra='cancelado'\n"
                    + "ORDER BY orden_com.id_orden_compra;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return orden_compra;
            } else {
                do {
                    id_orden_com = rs.getInt("id_orden_compra");
                    Variables.nro_orden = rs.getString("nro_orden_compra");
                    total_pagar_orden_com = rs.getInt("total_pagar_orden_compra");
                    fecha_pedido_orden_com = rs.getString("fecha_pedido_orden_compra");
                    estado_orden_com = rs.getString("estado_orden_compra");
                    nombre_prov = rs.getString("nombre_proveedor");
                    numero_st = rs.getString("numero_servicio_tecnico");
                    codigo_cont = rs.getString("codigo_contrato");
                    ordenHallada = new Ordencompra(id_orden_com, total_pagar_orden_com, Variables.nro_orden, fecha_pedido_orden_com, estado_orden_com, nombre_prov, numero_st, codigo_cont);
                    orden_compra.add(ordenHallada);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return orden_compra;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta leerOrden");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int registrarOrdencompra(Ordencompra orden_com) {
        int r = 0;
        int q1 = 0;
        try {
            con = cn.getConnection();
            String sql = "INSERT INTO public.orden_compra(\n"
                    + "	 nro_orden_compra, fecha_pedido_orden_compra, estado_orden_compra, \n"
                    + "	nombre_usuario_modificacion, fecha_modificacion, id_proveedor, \n"
                    + "	id_servicio_tecnico, total_pagar_orden_compra, condicion_orden_compra, \n"
                    + "	liq5_total_iva_orden_compra, liq10_total_iva_orden_compra, liq_total_iva_orden_compra,\n"
                    + "	exenta_subtotal, iva5_subtotal, iva10_subtotal, id_usuario, id_condicion)\n"
                    + "	VALUES (?, ?, 'pendiente', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            ps = con.prepareStatement(sql);

            ps.setString(1, orden_com.getNro_orden_com());
            ps.setString(2, orden_com.getFecha_pedido_orden_com());
            ps.setString(3, orden_com.getNom_usu_mod());
            ps.setString(4, orden_com.getFecha_pedido_orden_com());
            ps.setInt(5, orden_com.getId_prov());
            ps.setInt(6, orden_com.getId_st());
            ps.setInt(7, orden_com.getTotal_pagar_orden_com());
            ps.setString(8, orden_com.getCondicion_orden_com());
            ps.setInt(9, orden_com.getLiq5_total_orden_com());
            ps.setInt(10, orden_com.getLiq10_total_orden_com());
            ps.setInt(11, orden_com.getLiq_total_orden_com());
            ps.setInt(12, orden_com.getExenta_sub_orden_com());
            ps.setInt(13, orden_com.getIva5_sub_orden_com());
            ps.setInt(14, orden_com.getIva10_sub_orden_com());
            ps.setInt(15, orden_com.getId_usu());
            ps.setInt(16, orden_com.getId_cond());
            ps.executeUpdate();

            String sql1 = "INSERT INTO public.orden_compra_detalle(\n"
                    + "	cantidad_orden_compra_detalle, descripcion_orden_compra_detalle, precio_unit_orden_compra_detalle, exenta_orden_compra_detalle, iva5_orden_compra_detalle, iva10_orden_compra_detalle, id_producto, id_orden_compra)\n"
                    + "	VALUES (?, ?, ?, ?, ?, ?, ?, (select MAX(id_orden_compra) from orden_compra));";

            for (Ordencompra ordencompradet : Variables.ordenDet1) {
                ps2 = con.prepareStatement(sql1);

                ps2.setInt(1, ordencompradet.getCant_orden_comd());
                ps2.setString(2, ordencompradet.getDescrip_orden_comd());
                ps2.setInt(3, ordencompradet.getPrecio_orden_comd());
                ps2.setInt(4, ordencompradet.getExenta_orden_comd());
                ps2.setInt(5, ordencompradet.getIva5_orden_comd());
                ps2.setInt(6, ordencompradet.getIva10_orden_comd());
                ps2.setInt(7, ordencompradet.getId_pr());
                ps2.executeUpdate();
            }
            Variables.ordenDet1.clear();

            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
