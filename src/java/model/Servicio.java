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
public class Servicio implements ValidarServicio {

    int id_servicio_tecnico, id_tipo_servicio_tecnico, id_usuario, id_contrato, id_impuesto;
    String numero_servicio_tecnico, descripcion_servicio_tecnico, iva_servicio_tecnico, fecha_servicio_tecnnico, estado_servicio_tecnico,
            nombre_usuario_modificacion, fecha_modificacion, usuario_carga, notas, cliente_cont, descr_impuesto, cod_contrado, descr_tipo_ser, desc_cliente;
    double precio_servicio_tecnico;

    public Servicio() {
    }

    public Servicio(int id_servicio_tecnico, int id_tipo_servicio_tecnico, int id_usuario, int id_contrato, int id_impuesto, String numero_servicio_tecnico, String descripcion_servicio_tecnico, String iva_servicio_tecnico, String fecha_servicio_tecnnico, String estado_servicio_tecnico, String nombre_usuario_modificacion, String fecha_modificacion, String usuario_carga, String notas, String cliente_cont, String descr_impuesto, String cod_contrado, String descr_tipo_ser, String desc_cliente, double precio_servicio_tecnico) {
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

    public Servicio(int id_servicio_tecnico, int id_usuario, int id_contrato, String numero_servicio_tecnico, String descripcion_servicio_tecnico, String fecha_servicio_tecnnico, String estado_servicio_tecnico, String usuario_carga, String notas, String cliente_cont, String desc_cliente, double precio_servicio_tecnico) {
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
    private Servicio servicioHallado;

    @Override
    public int registrarServicio(Servicio ser) {
        int r = 0;
        String sql = "INSERT INTO public.servicio_tecnico(\n"
                + "numero_servicio_tecnico, descripcion_servicio_tecnico, precio_servicio_tecnico, \n"
                + "fecha_servicio_tecnico, estado_servicio_tecnico, nombre_usuario_modificacion, fecha_modificacion,  id_usuario, id_contrato, usuario_carga, notas)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, (SELECT current_date), ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ser.getNumero_servicio_tecnico());
            ps.setString(2, ser.getDescripcion_servicio_tecnico());
            ps.setDouble(3, ser.getPrecio_servicio_tecnico());
            ps.setString(4, ser.getFecha_servicio_tecnnico());
            ps.setString(5, ser.getEstado_servicio_tecnico());
            ps.setString(6, ser.getNombre_usuario_modificacion());
            ps.setInt(7, ser.getId_usuario());
            ps.setInt(8, ser.getId_contrato());
            ps.setString(9, ser.getUsuario_carga());
            ps.setString(10, ser.getNotas());
            ps.executeUpdate();

            return 1;

//            rs = ps.executeQuery();
//            while (rs.next()) {
//                r = r + 1;
//                ser.setNumero_servicio_tecnico(rs.getString("numero_servicio_tecnico"));
//                ser.setDescripcion_servicio_tecnico(rs.getString("descripcion_servicio_tecnico"));
//                ser.setPrecio_servicio_tecnico(rs.getDouble("precio_servicio_tecnico"));
//                ser.setIva_servicio_tecnico(rs.getString("iva_servicio_tecnico"));
//                ser.setFecha_servicio_tecnnico(rs.getString("fecha_servicio_tecnico"));
//                ser.setEstado_servicio_tecnico(rs.getString("estado_servicio_tecnico"));
//                ser.setNombre_usuario_modificacion(rs.getString("nombre_usuario_modificacion"));
//                ser.setId_tipo_servicio_tecnico(rs.getInt("id_tipo_servicio_tecnico"));
//                ser.setId_usuario(rs.getInt("id_usuario"));
//                ser.setId_contrato(rs.getInt("id_contrato"));
//                ser.setId_impuesto(rs.getInt("id_impuesto"));
//                ser.setUsuario_carga(rs.getString("usuario_carga"));
//                ser.setNotas(rs.getString("notas"));
//                ser.setCliente_cont(rs.getString("cliente_contrato"));
//            }
//            if (r == 1) {
//                return 1;
//            } else {
//                return 0;
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta registrarServicio");
            return 0;

        }

    }

    public HashMap seleccionarServicio() {
        HashMap<String, String> drop_ser = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_servicio_tecnico as id_ser,descripcion_servicio_tecnico\n"
                    + "FROM public.servicio_tecnico\n"
                    + "WHERE estado_servicio_tecnico ='activo'\n"
                    + "ORDER BY id_servicio_tecnico";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_ser.put(rs.getString("id_ser"), rs.getString("descripcion_servicio_tecnico"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta seleccionarServicio");
        }
        return drop_ser;
    }

//    public Servicio buscarServicio(String buscartxt) {
//        int r = 0;
//        Servicio ser = new Servicio();
//        String sql = "SELECT ser.id_servicio_tecnico, ser.numero_servicio_tecnico, ser.descripcion_servicio_tecnico, ser.precio_servicio_tecnico, ser.iva_servicio_tecnico, ser.fecha_servicio_tecnico, ser.estado_servicio_tecnico,\n"
//                + "ser.usuario_carga, ts.descripcion_tipo_servicio_tecnico, cont.codigo_contrato,imp.descripcion_impuesto, ser.notas, clie.descripcion_cliente\n"
//                + "FROM servicio_tecnico ser\n"
//                + "INNER JOIN tipo_servicio_tecnico ts on ser.id_tipo_servicio_tecnico = ts.id_tipo_servicio_tecnico\n"
//                + "INNER JOIN usuario usu  on ser.id_usuario = usu.id_usuario\n"
//                + "INNER JOIN contrato cont on ser.id_contrato = cont.id_contrato\n"
//                + "INNER JOIN cliente clie on cont.id_cliente = clie.id_cliente\n"
//                + "INNER JOIN impuesto imp on ser.id_impuesto = imp.id_impuesto\n"
//                + "WHERE ser.numero_servicio_tecnico ILIKE ?";
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, buscartxt);
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                r = r + 1;
//
//                ser.setNumero_servicio_tecnico(rs.getString("numero_servicio_tecnico"));
//                ser.setDescripcion_servicio_tecnico(rs.getString("descripcion_servicio_tecnico"));
//                ser.setPrecio_servicio_tecnico(rs.getDouble("precio_servicio_tecnico"));
//                ser.setIva_servicio_tecnico(rs.getString("iva_servicio_tecnico"));
//                ser.setFecha_servicio_tecnnico(rs.getString("fecha_servicio_tecnico"));
//                ser.setEstado_servicio_tecnico(rs.getString("estado_servicio_tecnico"));
//                ser.setNombre_usuario_modificacion(rs.getString("usuario_carga"));
//                ser.setDescr_tipo_ser(rs.getString("descripcion_tipo_servicio_tecnico"));
//                ser.setCod_contrado(rs.getString("codigo_contrato"));
//                ser.setDescr_impuesto(rs.getString("descripcion_impuesto"));
//                ser.setNotas(rs.getString("notas"));
//                ser.setCliente_contrato(rs.getString("descripcion_cliente"));
//                ser.setId_servicio_tecnico(rs.getInt("id_servicio_tecnico"));
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//            return ser;
//        }
//    }
    public ArrayList<Servicio> buscarServicioDescrip(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;

        ArrayList<Servicio> servicio = new ArrayList<>();

        String sql = "SELECT ser.id_servicio_tecnico, ser.numero_servicio_tecnico, ser.descripcion_servicio_tecnico, ser.precio_servicio_tecnico, \n"
                + "                 ser.fecha_servicio_tecnico, ser.estado_servicio_tecnico, ser.id_usuario, ser.id_contrato, ser.usuario_carga, ser.notas, \n"
                + "                 cont.cliente_contrato, clie.descripcion_cliente \n"
                + "                 FROM public.servicio_tecnico ser \n"
                + "		    INNER JOIN contrato cont ON ser.id_contrato = cont.id_contrato \n"
                + "                 INNER JOIN cliente clie ON  cont.id_cliente = clie.id_cliente \n"
                + "                 WHERE ser.estado_servicio_tecnico = 'activo' \n"
                + "                 and ser.descripcion_servicio_tecnico  ILIKE ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return servicio;
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
                    servicioHallado = new Servicio(id_servicio_tecnico, id_usuario, id_contrato, numero_servicio_tecnico, descripcion_servicio_tecnico, fecha_servicio_tecnnico, estado_servicio_tecnico, usuario_carga, notas, cliente_cont, desc_cliente, precio_servicio_tecnico);
                    servicio.add(servicioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return servicio;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta buscarServicioDescrip");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Servicio> buscarServicioCliente(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Servicio ser = new Servicio();
        ArrayList<Servicio> servicio = new ArrayList<>();

        String sql = "SELECT ser.id_servicio_tecnico, ser.numero_servicio_tecnico, ser.descripcion_servicio_tecnico, ser.precio_servicio_tecnico, \n"
                + "ser.fecha_servicio_tecnico, ser.estado_servicio_tecnico, ser.id_usuario, ser.id_contrato, ser.usuario_carga, ser.notas,\n"
                + "cont.cliente_contrato, clie.descripcion_cliente \n"
                + "FROM public.servicio_tecnico ser \n"
                + "INNER JOIN contrato cont ON ser.id_contrato = cont.id_contrato\n"
                + "INNER JOIN cliente clie ON  cont.id_cliente = clie.id_cliente \n"
                + "WHERE ser.estado_servicio_tecnico = 'activo'\n"
                + "and clie.descripcion_cliente  ILIKE ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return servicio;
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
                    servicioHallado = new Servicio(id_servicio_tecnico, id_usuario, id_contrato, numero_servicio_tecnico, descripcion_servicio_tecnico, fecha_servicio_tecnnico, estado_servicio_tecnico, usuario_carga, notas, cliente_cont, desc_cliente, precio_servicio_tecnico);
                    servicio.add(servicioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return servicio;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta buscarServicioCliente");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Servicio> leerServicioAc() {
        ArrayList<Servicio> servicio = new ArrayList<>();
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
                return servicio;
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
                    servicioHallado = new Servicio(id_servicio_tecnico, id_usuario, id_contrato, numero_servicio_tecnico, descripcion_servicio_tecnico, fecha_servicio_tecnnico, estado_servicio_tecnico, usuario_carga, notas, cliente_cont, desc_cliente, precio_servicio_tecnico);
                    servicio.add(servicioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return servicio;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta leerServicioAc");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Servicio> leerServicioIna() {
        ArrayList<Servicio> servicio = new ArrayList<>();
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
                return servicio;
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
                    servicioHallado = new Servicio(id_servicio_tecnico, id_usuario, id_contrato, numero_servicio_tecnico, descripcion_servicio_tecnico, fecha_servicio_tecnnico, estado_servicio_tecnico, usuario_carga, notas, cliente_cont, desc_cliente, precio_servicio_tecnico);
                    servicio.add(servicioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return servicio;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta leerServicioIna");
            e.printStackTrace();
            return null;
        }
    }

    public int cambiarActivo(Servicio ser) {
        int r = 0;
        String sql = "UPDATE public.servicio_tecnico \n"
                + "SET  estado_servicio_tecnico = 'activo' \n"
                + "WHERE id_servicio_tecnico = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ser.getId_servicio_tecnico());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                ser.setDescripcion_servicio_tecnico(rs.getString("descripcion_servicio_tecnico"));
                ser.setEstado_servicio_tecnico(rs.getString("estado_servicio_tecnico"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta cambiarActivo");
            return 0;
        }
    }

    public int cambiarInactivo(Servicio ser) {
        int r = 0;
        String sql = "UPDATE public.servicio_tecnico \n"
                + "SET  estado_servicio_tecnico = 'inactivo' \n"
                + "WHERE id_servicio_tecnico = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ser.getId_servicio_tecnico());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                ser.setDescripcion_servicio_tecnico(rs.getString("descripcion_servicio_tecnico"));
                ser.setEstado_servicio_tecnico(rs.getString("estado_servicio_tecnico"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta cambiarInactivo");
            return 0;
        }
    }

    public int modificarServicio(Servicio ser) {
        int r = 0;
        String sql = "UPDATE public.servicio_tecnico\n"
                + "	SET numero_servicio_tecnico=?, descripcion_servicio_tecnico=?, precio_servicio_tecnico=?, \n"
                + "	fecha_servicio_tecnico=?, estado_servicio_tecnico=?, nombre_usuario_modificacion=?, fecha_modificacion=(SELECT current_date), \n"
                + "	  id_contrato=?, usuario_carga = ?, notas=?\n"
                + "	WHERE id_servicio_tecnico=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ser.getNumero_servicio_tecnico());
            ps.setString(2, ser.getDescripcion_servicio_tecnico());
            ps.setDouble(3, ser.getPrecio_servicio_tecnico());
            ps.setString(4, ser.getFecha_servicio_tecnnico());
            ps.setString(5, ser.getEstado_servicio_tecnico());
            ps.setString(6, ser.getNombre_usuario_modificacion());
//            ps.setInt(7, ser.getId_usuario());
            ps.setInt(7, ser.getId_contrato());
            ps.setString(8, ser.getUsuario_carga());
            ps.setString(9, ser.getNotas());
            ps.setInt(10, ser.getId_servicio_tecnico());
            ps.executeUpdate();
            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta modificarServicio");
            return 0;
        }
    }

    public Servicio editarServicio(String editartxt) {
        int r = 0;
        Servicio ser = new Servicio();
        String sql = "SELECT ser.id_servicio_tecnico, ser.numero_servicio_tecnico, ser.descripcion_servicio_tecnico, ser.precio_servicio_tecnico, \n"
                + "  ser.fecha_servicio_tecnico, ser.estado_servicio_tecnico, ser.id_usuario, ser.id_contrato, cont.codigo_contrato, ser.usuario_carga, ser.notas, \n"
                + "  ser.cliente_contrato, clie.descripcion_cliente \n"
                + "  FROM public.servicio_tecnico ser \n"
                + "  INNER JOIN contrato cont ON ser.id_contrato = cont.id_contrato \n"
                + "  INNER JOIN cliente clie ON  cont.id_cliente = clie.id_cliente \n"
                + "  WHERE ser.id_servicio_tecnico = ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(editartxt));

            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                ser.setId_servicio_tecnico(rs.getInt("id_servicio_tecnico"));
                ser.setNumero_servicio_tecnico(rs.getString("numero_servicio_tecnico"));
                ser.setDescripcion_servicio_tecnico(rs.getString("descripcion_servicio_tecnico"));
                ser.setPrecio_servicio_tecnico(rs.getDouble("precio_servicio_tecnico"));
                ser.setFecha_servicio_tecnnico(rs.getString("fecha_servicio_tecnico"));
                ser.setEstado_servicio_tecnico(rs.getString("estado_servicio_tecnico"));
                ser.setId_usuario(rs.getInt("id_usuario"));
                ser.setId_contrato(rs.getInt("id_contrato"));
                ser.setCod_contrado(rs.getString("codigo_contrato"));
                ser.setUsuario_carga(rs.getString("usuario_carga"));
                ser.setNotas(rs.getString("notas"));
                ser.setCliente_cont(rs.getString("cliente_contrato"));
                ser.setDesc_cliente(rs.getString("descripcion_cliente"));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta editarServicio");

        } finally {
            return ser;

        }
    }
}
