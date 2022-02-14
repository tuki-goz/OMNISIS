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
public class InformeServicios {
    
    int id_servicio_tecnico, id_tipo_servicio_tecnico, id_usuario, id_contrato, id_impuesto;
    String numero_servicio_tecnico, descripcion_servicio_tecnico, iva_servicio_tecnico, fecha_servicio_tecnnico, estado_servicio_tecnico,
            nombre_usuario_modificacion, fecha_modificacion, usuario_carga, notas, cliente_cont, descr_impuesto, cod_contrado, descr_tipo_ser, desc_cliente;
    double precio_servicio_tecnico;

    public InformeServicios() {
    }

    public InformeServicios(int id_servicio_tecnico, int id_tipo_servicio_tecnico, int id_usuario, int id_contrato, int id_impuesto, String numero_servicio_tecnico, String descripcion_servicio_tecnico, String iva_servicio_tecnico, String fecha_servicio_tecnnico, String estado_servicio_tecnico, String nombre_usuario_modificacion, String fecha_modificacion, String usuario_carga, String notas, String cliente_cont, String descr_impuesto, String cod_contrado, String descr_tipo_ser, String desc_cliente, double precio_servicio_tecnico) {
        this.id_servicio_tecnico = id_servicio_tecnico;
        this.id_tipo_servicio_tecnico = id_tipo_servicio_tecnico;
        this.id_usuario = id_usuario;
        this.id_contrato = id_contrato;
        this.id_impuesto = id_impuesto;
        this.numero_servicio_tecnico = numero_servicio_tecnico;
        this.descripcion_servicio_tecnico = descripcion_servicio_tecnico;
        this.iva_servicio_tecnico = iva_servicio_tecnico;
        this.fecha_servicio_tecnnico = fecha_servicio_tecnnico;
        this.estado_servicio_tecnico = estado_servicio_tecnico;
        this.nombre_usuario_modificacion = nombre_usuario_modificacion;
        this.fecha_modificacion = fecha_modificacion;
        this.usuario_carga = usuario_carga;
        this.notas = notas;
        this.cliente_cont = cliente_cont;
        this.descr_impuesto = descr_impuesto;
        this.cod_contrado = cod_contrado;
        this.descr_tipo_ser = descr_tipo_ser;
        this.desc_cliente = desc_cliente;
        this.precio_servicio_tecnico = precio_servicio_tecnico;
    }

    public InformeServicios(int id_servicio_tecnico, int id_usuario, int id_contrato, String numero_servicio_tecnico, String descripcion_servicio_tecnico, String fecha_servicio_tecnnico, String estado_servicio_tecnico, String usuario_carga, String notas, String cliente_cont, String desc_cliente, double precio_servicio_tecnico) {
        this.id_servicio_tecnico = id_servicio_tecnico;
        this.id_usuario = id_usuario;
        this.id_contrato = id_contrato;
        this.numero_servicio_tecnico = numero_servicio_tecnico;
        this.descripcion_servicio_tecnico = descripcion_servicio_tecnico;
        this.fecha_servicio_tecnnico = fecha_servicio_tecnnico;
        this.estado_servicio_tecnico = estado_servicio_tecnico;
        this.usuario_carga = usuario_carga;
        this.notas = notas;
        this.cliente_cont = cliente_cont;
        this.desc_cliente = desc_cliente;
        this.precio_servicio_tecnico = precio_servicio_tecnico;
    }

    public int getId_servicio_tecnico() {
        return id_servicio_tecnico;
    }

    public void setId_servicio_tecnico(int id_servicio_tecnico) {
        this.id_servicio_tecnico = id_servicio_tecnico;
    }

    public int getId_tipo_servicio_tecnico() {
        return id_tipo_servicio_tecnico;
    }

    public void setId_tipo_servicio_tecnico(int id_tipo_servicio_tecnico) {
        this.id_tipo_servicio_tecnico = id_tipo_servicio_tecnico;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_impuesto() {
        return id_impuesto;
    }

    public void setId_impuesto(int id_impuesto) {
        this.id_impuesto = id_impuesto;
    }

    public String getNumero_servicio_tecnico() {
        return numero_servicio_tecnico;
    }

    public void setNumero_servicio_tecnico(String numero_servicio_tecnico) {
        this.numero_servicio_tecnico = numero_servicio_tecnico;
    }

    public String getDescripcion_servicio_tecnico() {
        return descripcion_servicio_tecnico;
    }

    public void setDescripcion_servicio_tecnico(String descripcion_servicio_tecnico) {
        this.descripcion_servicio_tecnico = descripcion_servicio_tecnico;
    }

    public String getIva_servicio_tecnico() {
        return iva_servicio_tecnico;
    }

    public void setIva_servicio_tecnico(String iva_servicio_tecnico) {
        this.iva_servicio_tecnico = iva_servicio_tecnico;
    }

    public String getFecha_servicio_tecnnico() {
        return fecha_servicio_tecnnico;
    }

    public void setFecha_servicio_tecnnico(String fecha_servicio_tecnnico) {
        this.fecha_servicio_tecnnico = fecha_servicio_tecnnico;
    }

    public String getEstado_servicio_tecnico() {
        return estado_servicio_tecnico;
    }

    public void setEstado_servicio_tecnico(String estado_servicio_tecnico) {
        this.estado_servicio_tecnico = estado_servicio_tecnico;
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

    public String getUsuario_carga() {
        return usuario_carga;
    }

    public void setUsuario_carga(String usuario_carga) {
        this.usuario_carga = usuario_carga;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getCliente_cont() {
        return cliente_cont;
    }

    public void setCliente_cont(String cliente_cont) {
        this.cliente_cont = cliente_cont;
    }

    public String getDescr_impuesto() {
        return descr_impuesto;
    }

    public void setDescr_impuesto(String descr_impuesto) {
        this.descr_impuesto = descr_impuesto;
    }

    public String getCod_contrado() {
        return cod_contrado;
    }

    public void setCod_contrado(String cod_contrado) {
        this.cod_contrado = cod_contrado;
    }

    public String getDescr_tipo_ser() {
        return descr_tipo_ser;
    }

    public void setDescr_tipo_ser(String descr_tipo_ser) {
        this.descr_tipo_ser = descr_tipo_ser;
    }

    public String getDesc_cliente() {
        return desc_cliente;
    }

    public void setDesc_cliente(String desc_cliente) {
        this.desc_cliente = desc_cliente;
    }

    public double getPrecio_servicio_tecnico() {
        return precio_servicio_tecnico;
    }

    public void setPrecio_servicio_tecnico(double precio_servicio_tecnico) {
        this.precio_servicio_tecnico = precio_servicio_tecnico;
    }

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    private Statement stm;
    private InformeServicios informeServiciosHallado;
    
     public ArrayList<InformeServicios> leerInformeServiciosAc() {
        ArrayList<InformeServicios> informeServicios = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT ser.id_servicio_tecnico, ser.numero_servicio_tecnico, ser.descripcion_servicio_tecnico, ser.precio_servicio_tecnico, \n"
                    + "                 ser.fecha_servicio_tecnico, ser.estado_servicio_tecnico, ser.id_usuario, ser.id_contrato, ser.usuario_carga, ser.notas, \n"
                    + "                 cont.cliente_contrato, clie.descripcion_cliente \n"
                    + "                 FROM public.servicio_tecnico ser \n"
                    + "		        INNER JOIN contrato cont ON ser.id_contrato = cont.id_contrato \n"
                    + "                 INNER JOIN cliente clie ON  cont.id_cliente = clie.id_cliente \n"
                    + "                 WHERE ser.estado_servicio_tecnico = 'activo' \n"
                    + "                 ORDER BY id_servicio_tecnico ");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeServicios;
            } else {
                do {
                    id_servicio_tecnico = rs.getInt("id_servicio_tecnico");
                    numero_servicio_tecnico = rs.getString("numero_servicio_tecnico");
                    descripcion_servicio_tecnico = rs.getString("descripcion_servicio_tecnico");
                    precio_servicio_tecnico = rs.getDouble("precio_servicio_tecnico");
                    fecha_servicio_tecnnico = rs.getString("fecha_servicio_tecnico");
                    estado_servicio_tecnico = rs.getString("estado_servicio_tecnico");
                    id_usuario = rs.getInt("id_usuario");
                    id_contrato = rs.getInt("id_contrato");
                    usuario_carga = rs.getString("usuario_carga");
                    notas = rs.getString("notas");
                    cliente_cont = rs.getString("cliente_contrato");
                    desc_cliente = rs.getString("descripcion_cliente");
                    informeServiciosHallado = new InformeServicios(id_servicio_tecnico, id_usuario, id_contrato, numero_servicio_tecnico, descripcion_servicio_tecnico, fecha_servicio_tecnnico, estado_servicio_tecnico, usuario_carga, notas, cliente_cont, desc_cliente, precio_servicio_tecnico);
                    informeServicios.add(informeServiciosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeServicios;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta leerInformeServiciosAc");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeServicios> leerInformeServiciosIna() {
        ArrayList<InformeServicios> informeServicios = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT ser.id_servicio_tecnico, ser.numero_servicio_tecnico, ser.descripcion_servicio_tecnico, ser.precio_servicio_tecnico, \n"
                    + "                 ser.fecha_servicio_tecnico, ser.estado_servicio_tecnico, ser.id_usuario, ser.id_contrato, ser.usuario_carga, ser.notas, \n"
                    + "                 cont.cliente_contrato, clie.descripcion_cliente \n"
                    + "                 FROM public.servicio_tecnico ser \n"
                    + "		        INNER JOIN contrato cont ON ser.id_contrato = cont.id_contrato \n"
                    + "                 INNER JOIN cliente clie ON  cont.id_cliente = clie.id_cliente \n"
                    + "                 WHERE ser.estado_servicio_tecnico = 'inactivo' \n"
                    + "                 ORDER BY id_servicio_tecnico");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return informeServicios;
            } else {
                do {
                    id_servicio_tecnico = rs.getInt("id_servicio_tecnico");
                    numero_servicio_tecnico = rs.getString("numero_servicio_tecnico");
                    descripcion_servicio_tecnico = rs.getString("descripcion_servicio_tecnico");
                    precio_servicio_tecnico = rs.getDouble("precio_servicio_tecnico");
                    fecha_servicio_tecnnico = rs.getString("fecha_servicio_tecnico");
                    estado_servicio_tecnico = rs.getString("estado_servicio_tecnico");
                    id_usuario = rs.getInt("id_usuario");
                    id_contrato = rs.getInt("id_contrato");
                    usuario_carga = rs.getString("usuario_carga");
                    notas = rs.getString("notas");
                    cliente_cont = rs.getString("cliente_contrato");
                    desc_cliente = rs.getString("descripcion_cliente");
                    informeServiciosHallado = new InformeServicios(id_servicio_tecnico, id_usuario, id_contrato, numero_servicio_tecnico, descripcion_servicio_tecnico, fecha_servicio_tecnnico, estado_servicio_tecnico, usuario_carga, notas, cliente_cont, desc_cliente, precio_servicio_tecnico);
                    informeServicios.add(informeServiciosHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return informeServicios;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta leerInformeServiciosIna");
            e.printStackTrace();
            return null;
        }
    }
}
