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
public class Importacion implements ValidarImportacion {

    int id_importacion, id_pais, id_proveedor, id_cliente;
    String llamado, fecha_imp, guia_imp, estado_imp, nom_usu, fecha_mod, nom_prov, descrip_pais, descrip_clie;
    Double monto_fob, monto_flete, monto_despacho, monto_total;

    public Importacion() {
    }

    public Importacion(int id_importacion, int id_pais, int id_proveedor, int id_cliente, String llamado, String fecha_imp, String guia_imp, String estado_imp, String nom_usu, String fecha_mod, String nom_prov, String descrip_pais, String descrip_clie, Double monto_fob, Double monto_flete, Double monto_despacho, Double monto_total) {
        this.id_importacion = id_importacion;
        this.id_pais = id_pais;
        this.id_proveedor = id_proveedor;
        this.id_cliente = id_cliente;
        this.llamado = llamado;
        this.fecha_imp = fecha_imp;
        this.guia_imp = guia_imp;
        this.estado_imp = estado_imp;
        this.nom_usu = nom_usu;
        this.fecha_mod = fecha_mod;
        this.nom_prov = nom_prov;
        this.descrip_pais = descrip_pais;
        this.descrip_clie = descrip_clie;
        this.monto_fob = monto_fob;
        this.monto_flete = monto_flete;
        this.monto_despacho = monto_despacho;
        this.monto_total = monto_total;
    }

    public Importacion(int id_importacion, int id_pais, int id_proveedor, int id_cliente, String llamado, String fecha_imp, String guia_imp, String estado_imp, String nom_prov, String descrip_pais, String descrip_clie, Double monto_fob, Double monto_flete, Double monto_despacho, Double monto_total) {
        this.id_importacion = id_importacion;
        this.id_pais = id_pais;
        this.id_proveedor = id_proveedor;
        this.id_cliente = id_cliente;
        this.llamado = llamado;
        this.fecha_imp = fecha_imp;
        this.guia_imp = guia_imp;
        this.estado_imp = estado_imp;
        this.nom_prov = nom_prov;
        this.descrip_pais = descrip_pais;
        this.descrip_clie = descrip_clie;
        this.monto_fob = monto_fob;
        this.monto_flete = monto_flete;
        this.monto_despacho = monto_despacho;
        this.monto_total = monto_total;
    }

    public int getId_importacion() {
        return id_importacion;
    }

    public void setId_importacion(int id_importacion) {
        this.id_importacion = id_importacion;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getLlamado() {
        return llamado;
    }

    public void setLlamado(String llamado) {
        this.llamado = llamado;
    }

    public String getFecha_imp() {
        return fecha_imp;
    }

    public void setFecha_imp(String fecha_imp) {
        this.fecha_imp = fecha_imp;
    }

    public String getGuia_imp() {
        return guia_imp;
    }

    public void setGuia_imp(String guia_imp) {
        this.guia_imp = guia_imp;
    }

    public String getEstado_imp() {
        return estado_imp;
    }

    public void setEstado_imp(String estado_imp) {
        this.estado_imp = estado_imp;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getFecha_mod() {
        return fecha_mod;
    }

    public void setFecha_mod(String fecha_mod) {
        this.fecha_mod = fecha_mod;
    }

    public String getNom_prov() {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }

    public String getDescrip_pais() {
        return descrip_pais;
    }

    public void setDescrip_pais(String descrip_pais) {
        this.descrip_pais = descrip_pais;
    }

    public String getDescrip_clie() {
        return descrip_clie;
    }

    public void setDescrip_clie(String descrip_clie) {
        this.descrip_clie = descrip_clie;
    }

    public Double getMonto_fob() {
        return monto_fob;
    }

    public void setMonto_fob(Double monto_fob) {
        this.monto_fob = monto_fob;
    }

    public Double getMonto_flete() {
        return monto_flete;
    }

    public void setMonto_flete(Double monto_flete) {
        this.monto_flete = monto_flete;
    }

    public Double getMonto_despacho() {
        return monto_despacho;
    }

    public void setMonto_despacho(Double monto_despacho) {
        this.monto_despacho = monto_despacho;
    }

    public Double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Double monto_total) {
        this.monto_total = monto_total;
    }

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    private Statement stm;
    private Importacion importacionHallado;

    @Override
    public int registrarImportacion(Importacion imp) {

        int r = 0;
        String sql = "INSERT INTO public.importacion( \n"
                + " llamado_id, fecha_importacion, monto_fob, monto_flete, monto_despacho, monto_total_importacion, guia_importacion, \n"
                + " estado_importacion, nombre_usuario_modificacion, fecha_modificacion, id_proveedor, id_pais, id_cliente) \n"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, (SELECT current_date), ?, ?, ?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, imp.getLlamado());
            ps.setString(2, imp.getFecha_imp());
            ps.setDouble(3, imp.getMonto_fob());
            ps.setDouble(4, imp.getMonto_flete());
            ps.setDouble(5, imp.getMonto_despacho());
            ps.setDouble(6, imp.getMonto_total());
            ps.setString(7, imp.getGuia_imp());
            ps.setString(8, imp.getEstado_imp());
            ps.setString(9, imp.getNom_usu());
            ps.setInt(10, imp.getId_proveedor());
            ps.setInt(11, imp.getId_pais());
            ps.setInt(12, imp.getId_cliente());

            ps.executeUpdate();
            return 1;
            
            
//            while (rs.next()) {
//                r = r + 1;
//                imp.setLlamado(rs.getString("llamado_id"));
//                imp.setFecha_imp(rs.getString("fecha_importacion"));
//                imp.setMonto_fob(rs.getDouble("monto_fob"));
//                imp.setMonto_flete(rs.getDouble("monto_flete"));
//                imp.setMonto_despacho(rs.getDouble("monto_despacho"));
//                imp.setMonto_total(rs.getDouble("monto_total_importacion"));
//                imp.setGuia_imp(rs.getString("guia_importacion"));
//                imp.setEstado_imp(rs.getString("estado_importacion"));
//                imp.setNom_usu(rs.getString("nombre_usuario_modificacion"));
//                imp.setId_proveedor(rs.getInt("id_proveedor"));
//                imp.setId_pais(rs.getInt("id_pais"));
//                imp.setId_cliente(rs.getInt("id_Cliente"));
//            }
//            if (r == 1) {
//                return 1;
//            } else {
//                return 0;
//            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en insercion RegistrarImportacion");
            return 0;

        }

    }

    public HashMap seleccionarImportacion() {
        HashMap<String, String> drop_impor = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_importacion as id_imp, llamado_id\n"
                    + "FROM public.importacion \n"
                    + "WHERE estado_importacion = 'activo' \n"
                    + "ORDER BY id_importacion ";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_impor.put(rs.getString("id_imp"), rs.getString("llamado_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_impor;
    }

    public ArrayList<Importacion> buscarImportacionDescrip(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;

        ArrayList<Importacion> importacion = new ArrayList<>();

        String sql = "SELECT imp.id_importacion, imp.llamado_id, imp.fecha_importacion, imp.monto_fob, imp.monto_flete, imp.monto_despacho, imp.monto_total_importacion, imp.guia_importacion, imp.estado_importacion, \n"
                + " imp.id_proveedor, prov.nombre_proveedor, imp.id_pais, p.descripcion_pais, imp.id_Cliente, clie.descripcion_cliente \n"
                + " FROM public.importacion imp \n"
                + " INNER JOIN proveedor prov ON  imp.id_proveedor = prov.id_proveedor \n"
                + " INNER JOIN pais p ON  imp.id_pais = p.id_pais \n"
                + " INNER JOIN cliente clie ON imp.id_cliente = clie.id_cliente \n"
                + " WHERE imp.estado_importacion = 'activo' \n"
                + " and imp.llamado_id  ILIKE ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return importacion;
            } else {
                do {
                    id_importacion = rs.getInt("id_importacion");
                    llamado = rs.getString("llamado_id");
                    fecha_imp = rs.getString("fecha_importacion");
                    monto_fob = rs.getDouble("monto_fob");
                    monto_flete = rs.getDouble("monto_flete");
                    monto_despacho = rs.getDouble("monto_despacho");
                    monto_total = rs.getDouble("monto_total_importacion");
                    guia_imp = rs.getString("guia_importacion");
                    estado_imp = rs.getString("estado_importacion");
                    id_proveedor = rs.getInt("id_proveedor");
                    nom_prov = rs.getString("nombre_proveedor");
                    id_pais = rs.getInt("id_pais");
                    descrip_pais = rs.getString("descripcion_pais");
                    id_cliente = rs.getInt("id_Cliente");
                    descrip_clie = rs.getString("descripcion_cliente");
                    importacionHallado = new Importacion(id_importacion, id_pais, id_proveedor, id_cliente, llamado, fecha_imp, guia_imp, estado_imp, nom_prov, descrip_pais, descrip_clie, monto_fob, monto_flete, monto_despacho, monto_total);
                    importacion.add(importacionHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return importacion;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta buscarImportacionDescrip");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Importacion> buscarImportacionCliente(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Importacion imp = new Importacion();
        ArrayList<Importacion> importacion = new ArrayList<>();

        String sql = "SELECT imp.id_importacion, imp.llamado_id, imp.fecha_importacion, imp.monto_fob, imp.monto_flete, imp.monto_despacho, imp.monto_total_importacion, imp.guia_importacion, imp.estado_importacion, \n"
                + " imp.id_proveedor, prov.nombre_proveedor, imp.id_pais, p.descripcion_pais, imp.id_Cliente, clie.descripcion_cliente \n"
                + " FROM public.importacion imp \n"
                + " INNER JOIN proveedor prov ON  imp.id_proveedor = prov.id_proveedor \n"
                + " INNER JOIN pais p ON  imp.id_pais = p.id_pais \n"
                + " INNER JOIN cliente clie ON imp.id_cliente = clie.id_cliente \n"
                + " WHERE imp.estado_importacion = 'activo' \n"
                + " and clie.descripcion_cliente  ILIKE ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return importacion;
            } else {
                do {
                    id_importacion = rs.getInt("id_importacion");
                    llamado = rs.getString("llamado_id");
                    fecha_imp = rs.getString("fecha_importacion");
                    monto_fob = rs.getDouble("monto_fob");
                    monto_flete = rs.getDouble("monto_flete");
                    monto_despacho = rs.getDouble("monto_despacho");
                    monto_total = rs.getDouble("monto_total_importacion");
                    guia_imp = rs.getString("guia_importacion");
                    estado_imp = rs.getString("estado_importacion");
                    id_proveedor = rs.getInt("id_proveedor");
                    nom_prov = rs.getString("nombre_proveedor");
                    id_pais = rs.getInt("id_pais");
                    descrip_pais = rs.getString("descripcion_pais");
                    id_cliente = rs.getInt("id_Cliente");
                    descrip_clie = rs.getString("descripcion_cliente");
                    importacionHallado = new Importacion(id_importacion, id_pais, id_proveedor, id_cliente, llamado, fecha_imp, guia_imp, estado_imp, nom_prov, descrip_pais, descrip_clie, monto_fob, monto_flete, monto_despacho, monto_total);
                    importacion.add(importacionHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return importacion;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta buscarImportacionCliente");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Importacion> leerImportacionAc() {
        ArrayList<Importacion> importacion = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT imp.id_importacion, imp.llamado_id, imp.fecha_importacion, imp.monto_fob, imp.monto_flete, imp.monto_despacho, imp.monto_total_importacion, imp.guia_importacion, imp.estado_importacion, \n"
                    + " imp.id_proveedor, prov.nombre_proveedor, imp.id_pais, p.descripcion_pais, imp.id_Cliente, clie.descripcion_cliente \n"
                    + " FROM public.importacion imp \n"
                    + " INNER JOIN proveedor prov ON  imp.id_proveedor = prov.id_proveedor \n"
                    + " INNER JOIN pais p ON  imp.id_pais = p.id_pais \n"
                    + " INNER JOIN cliente clie ON imp.id_cliente = clie.id_cliente \n"
//                    + " WHERE imp.estado_importacion = 'activo' \n"
                    + " ORDER BY id_importacion ");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return importacion;
            } else {
                do {
                    id_importacion = rs.getInt("id_importacion");
                    llamado = rs.getString("llamado_id");
                    fecha_imp = rs.getString("fecha_importacion");
                    monto_fob = rs.getDouble("monto_fob");
                    monto_flete = rs.getDouble("monto_flete");
                    monto_despacho = rs.getDouble("monto_despacho");
                    monto_total = rs.getDouble("monto_total_importacion");
                    guia_imp = rs.getString("guia_importacion");
                    estado_imp = rs.getString("estado_importacion");
                    id_proveedor = rs.getInt("id_proveedor");
                    nom_prov = rs.getString("nombre_proveedor");
                    id_pais = rs.getInt("id_pais");
                    descrip_pais = rs.getString("descripcion_pais");
                    id_cliente = rs.getInt("id_Cliente");
                    descrip_clie = rs.getString("descripcion_cliente");
                    importacionHallado = new Importacion(id_importacion, id_pais, id_proveedor, id_cliente, llamado, fecha_imp, guia_imp, estado_imp, nom_prov, descrip_pais, descrip_clie, monto_fob, monto_flete, monto_despacho, monto_total);
                    importacion.add(importacionHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return importacion;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta leerImportacionAc");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Importacion> leerImportacionIna() {
        ArrayList<Importacion> importacion = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT imp.id_importacion, imp.llamado_id, imp.fecha_importacion, imp.monto_fob, imp.monto_flete, imp.monto_despacho, imp.monto_total_importacion, imp.guia_importacion, imp.estado_importacion, \n"
                    + " imp.id_proveedor, prov.nombre_proveedor, imp.id_pais, p.descripcion_pais, imp.id_Cliente, clie.descripcion_cliente \n"
                    + " FROM public.importacion imp \n"
                    + " INNER JOIN proveedor prov ON  imp.id_proveedor = prov.id_proveedor \n"
                    + " INNER JOIN pais p ON  imp.id_pais = p.id_pais \n"
                    + " INNER JOIN cliente clie ON imp.id_cliente = clie.id_cliente \n"
                    + " WHERE imp.estado_importacion = 'inactivo' \n"
                    + " ORDER BY id_importacion ");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return importacion;
            } else {
                do {
                    id_importacion = rs.getInt("id_importacion");
                    llamado = rs.getString("llamado_id");
                    fecha_imp = rs.getString("fecha_importacion");
                    monto_fob = rs.getDouble("monto_fob");
                    monto_flete = rs.getDouble("monto_flete");
                    monto_despacho = rs.getDouble("monto_despacho");
                    monto_total = rs.getDouble("monto_total_importacion");
                    guia_imp = rs.getString("guia_importacion");
                    estado_imp = rs.getString("estado_importacion");
                    id_proveedor = rs.getInt("id_proveedor");
                    nom_prov = rs.getString("nombre_proveedor");
                    id_pais = rs.getInt("id_pais");
                    descrip_pais = rs.getString("descripcion_pais");
                    id_cliente = rs.getInt("id_Cliente");
                    descrip_clie = rs.getString("descripcion_cliente");
                    importacionHallado = new Importacion(id_importacion, id_pais, id_proveedor, id_cliente, llamado, fecha_imp, guia_imp, estado_imp, nom_prov, descrip_pais, descrip_clie, monto_fob, monto_flete, monto_despacho, monto_total);
                    importacion.add(importacionHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return importacion;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta leerImportacionIna");
            e.printStackTrace();
            return null;
        }
    }

    public int cambiarActivo(Importacion imp) {
        int r = 0;
        String sql = "UPDATE public.importacion \n"
                + "SET  estado_importacion = 'activo' \n"
                + "WHERE id_importacion = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, imp.getId_importacion());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;

                imp.setEstado_imp(rs.getString("estado_importacion"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta cambiarActivo");
            return 0;
        }
    }

    public int cambiarInactivo(Importacion imp) {
        int r = 0;
        String sql = "UPDATE public.importacion \n"
                + "SET  estado_importacion = 'inactivo' \n"
                + "WHERE id_importacion = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, imp.getId_importacion());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;

                imp.setEstado_imp(rs.getString("estado_importacion"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta cambiarInactivo");
            return 0;
        }
    }

    public int modificarImportacion(Importacion imp) {
        int r = 0;
        String sql = "UPDATE public.importacion \n"
                + " SET llamado_id=?, fecha_importacion=?, monto_fob=?, monto_flete=?, monto_despacho=?, monto_total_importacion=?, guia_importacion=?, \n"
                + " estado_importacion=?, nombre_usuario_modificacion=?, fecha_modificacion=?, id_proveedor=?, id_pais=?, id_Cliente=? \n"
                + "WHERE id_importacion=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, imp.getLlamado());
            ps.setString(2, imp.getFecha_imp());
            ps.setDouble(3, imp.getMonto_fob());
            ps.setDouble(4, imp.getMonto_flete());
            ps.setDouble(5, imp.getMonto_despacho());
            ps.setDouble(6, imp.getMonto_total());
            ps.setString(7, imp.getGuia_imp());
            ps.setString(8, imp.getEstado_imp());
            ps.setString(9, imp.getNom_usu());
            ps.setInt(10, imp.getId_proveedor());
            ps.setInt(11, imp.getId_pais());
            ps.setInt(12, imp.getId_cliente());
            ps.executeUpdate();
            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public Importacion editarImportacion(String editartxt) {
        int r = 0;
        Importacion imp = new Importacion();
        String sql = "SELECT imp.id_importacion, imp.llamado_id, imp.fecha_importacion, imp.monto_fob, imp.monto_flete, imp.monto_despacho, imp.monto_total_importacion, imp.guia_importacion, imp.estado_importacion, \n"
                + " imp.id_proveedor, prov.nombre_proveedor, imp.id_pais, p.descripcion_pais, imp.id_Cliente, clie.descripcion_cliente \n"
                + " FROM public.importacion imp \n"
                + " INNER JOIN proveedor prov ON  imp.id_proveedor = prov.id_proveedor \n"
                + " INNER JOIN pais p ON  imp.id_pais = p.id_pais \n"
                + " INNER JOIN cliente clie ON imp.id_cliente = clie.id_cliente \n"
                + " WHERE imp.id_importacion = ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(editartxt));

            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                imp.setLlamado(rs.getString("llamado_id"));
                imp.setFecha_imp(rs.getString("fecha_importacion"));
                imp.setMonto_fob(rs.getDouble("monto_fob"));
                imp.setMonto_flete(rs.getDouble("monto_flete"));
                imp.setMonto_despacho(rs.getDouble("monto_despacho"));
                imp.setMonto_total(rs.getDouble("monto_total_importacion"));
                imp.setGuia_imp(rs.getString("guia_importacion"));
                imp.setEstado_imp(rs.getString("estado_importacion"));
                imp.setNom_usu(rs.getString("nombre_usuario_modificacion"));
                imp.setId_proveedor(rs.getInt("id_proveedor"));
                imp.setNom_prov(rs.getString("nombre_proveedor"));
                imp.setId_pais(rs.getInt("id_pais"));
                imp.setDescrip_pais(rs.getString("descripcion_pais"));
                imp.setId_cliente(rs.getInt("id_Cliente"));
                imp.setDescrip_clie(rs.getString("descripcion_cliente"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta editarImportacion");

        } finally {
            return imp;

        }
    }
}
