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
 * @author Francisca Gómez
 */
public class Proveedor implements ValidarProveedor {

    //CONSTRUCTORES - SET - GET
    int id_prov, id_pais, id_ciu;
    String nom_prov, proc_prov, ruc_prov, tel_prov, dir_prov, estado_prov, nom_usu_mod, desc_pais, ciu_prov;

    public Proveedor() {
    }

    public Proveedor(int id_prov, int id_pais, int id_ciu, String nom_prov, String proc_prov, String ruc_prov, String tel_prov, String dir_prov, String estado_prov, String nom_usu_mod, String desc_pais, String ciu_prov) {
        this.id_prov = id_prov;
        this.id_pais = id_pais;
        this.id_ciu = id_ciu;
        this.nom_prov = nom_prov;
        this.proc_prov = proc_prov;
        this.ruc_prov = ruc_prov;
        this.tel_prov = tel_prov;
        this.dir_prov = dir_prov;
        this.estado_prov = estado_prov;
        this.nom_usu_mod = nom_usu_mod;
        this.desc_pais = desc_pais;
        this.ciu_prov = ciu_prov;
    }

    public Proveedor(int id_prov, String nom_prov, String proc_prov, String ruc_prov, String tel_prov, String dir_prov, String ciu_prov) {
        this.id_prov = id_prov;
        this.nom_prov = nom_prov;
        this.proc_prov = proc_prov;
        this.ruc_prov = ruc_prov;
        this.tel_prov = tel_prov;
        this.dir_prov = dir_prov;
        this.ciu_prov = ciu_prov;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public int getId_ciu() {
        return id_ciu;
    }

    public void setId_ciu(int id_ciu) {
        this.id_ciu = id_ciu;
    }

    public String getNom_prov() {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }

    public String getProc_prov() {
        return proc_prov;
    }

    public void setProc_prov(String proc_prov) {
        this.proc_prov = proc_prov;
    }

    public String getRuc_prov() {
        return ruc_prov;
    }

    public void setRuc_prov(String ruc_prov) {
        this.ruc_prov = ruc_prov;
    }

    public String getTel_prov() {
        return tel_prov;
    }

    public void setTel_prov(String tel_prov) {
        this.tel_prov = tel_prov;
    }

    public String getDir_prov() {
        return dir_prov;
    }

    public void setDir_prov(String dir_prov) {
        this.dir_prov = dir_prov;
    }

    public String getEstado_prov() {
        return estado_prov;
    }

    public void setEstado_prov(String estado_prov) {
        this.estado_prov = estado_prov;
    }

    public String getNom_usu_mod() {
        return nom_usu_mod;
    }

    public void setNom_usu_mod(String nom_usu_mod) {
        this.nom_usu_mod = nom_usu_mod;
    }

    public String getDesc_pais() {
        return desc_pais;
    }

    public void setDesc_pais(String desc_pais) {
        this.desc_pais = desc_pais;
    }

    public String getCiu_prov() {
        return ciu_prov;
    }

    public void setCiu_prov(String ciu_prov) {
        this.ciu_prov = ciu_prov;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Proveedor proveedorHallado;

    @Override
    public int registrarProveedor(Proveedor prov) {
        int r = 0;
        String sql = "INSERT INTO public.proveedor(\n"
                + "nombre_proveedor, pais_proveedor, ruc_proveedor, telefono_proveedor,\n"
                + "direccion_proveedor, estado_proveedor, nombre_usuario_modificacion, fecha_modificacion, id_ciudad)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, (SELECT current_date), ?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getNom_prov());
            ps.setString(2, prov.getProc_prov());
            ps.setString(3, prov.getRuc_prov());
            ps.setString(4, prov.getTel_prov());
            ps.setString(5, prov.getDir_prov());
            ps.setString(6, prov.getEstado_prov());
            ps.setString(7, prov.getNom_usu_mod());
            ps.setInt(8, prov.getId_ciu());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ConectaBD.cerrar();
            return 0;
        }
    }

    public HashMap seleccionarProveedor() {
        HashMap<String, String> drop_prov = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_proveedor as id_prov,nombre_proveedor\n"
                    + "	FROM public.proveedor"
                    + " WHERE estado_proveedor = 'activo';";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_prov.put(rs.getString("id_prov"), rs.getString("nombre_proveedor"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
            ConectaBD.cerrar();
        }
        return drop_prov;
    }

    public ArrayList<Proveedor> buscarProveedor(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        ArrayList<Proveedor> proveedor = new ArrayList<>();
        String sql = "SELECT prov.id_proveedor, prov.nombre_proveedor, prov.pais_proveedor, prov.ruc_proveedor, prov.telefono_proveedor, \n"
                + " prov.direccion_proveedor, ciu.descripcion_ciudad \n"
                + " FROM public.proveedor prov \n"
                + " INNER JOIN ciudad ciu ON prov.id_ciudad = ciu.id_ciudad  \n"
                + " WHERE prov.nombre_proveedor ILIKE ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                Variables.mensajeError = 1;
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_prov = rs.getInt("id_proveedor");
                    nom_prov = rs.getString("nombre_proveedor");
                    proc_prov = rs.getString("pais_proveedor");
                    ruc_prov = rs.getString("ruc_proveedor");
                    tel_prov = rs.getString("telefono_proveedor");
                    dir_prov = rs.getString("direccion_proveedor");
                    ciu_prov = rs.getString("descripcion_ciudad");
                    proveedorHallado = new Proveedor(id_prov, nom_prov, proc_prov, ruc_prov, tel_prov, dir_prov, ciu_prov);
                    proveedor.add(proveedorHallado);
                } while (rs.next());
                Variables.mensajeError = 0;
                ConectaBD.cerrar();
                return proveedor;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta buscar");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Proveedor> buscarProveedorIn(String buscartxt) {
        ArrayList<Proveedor> proveedor = new ArrayList<>();
        String sql = "SELECT prov.id_proveedor, prov.nombre_proveedor, prov.pais_proveedor, prov.ruc_proveedor, \n"
                + "prov.telefono_proveedor, prov.direccion_proveedor, ciu.descripcion_ciudad\n"
                + "FROM public.proveedor prov\n"
                + "INNER JOIN ciudad ciu ON prov.id_ciudad = ciu.id_ciudad\n"
                + "WHERE prov.nombre_proveedor ILIKE ?\n"
                + "AND prov.estado_proveedor = 'inactivo'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                Variables.mensajeError = 1;
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_prov = rs.getInt("id_proveedor");
                    nom_prov = rs.getString("nombre_proveedor");
                    proc_prov = rs.getString("pais_proveedor");
                    ruc_prov = rs.getString("ruc_proveedor");
                    tel_prov = rs.getString("telefono_proveedor");
                    dir_prov = rs.getString("direccion_proveedor");
                    ciu_prov = rs.getString("descripcion_ciudad");
                    proveedorHallado = new Proveedor(id_prov, nom_prov, proc_prov, ruc_prov, tel_prov, dir_prov, ciu_prov);
                    proveedor.add(proveedorHallado);
                } while (rs.next());
                Variables.mensajeError = 0;
                ConectaBD.cerrar();
                return proveedor;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta buscar");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Proveedor> leerProveedorAc() {
        ArrayList<Proveedor> proveedor = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT prov.id_proveedor, prov.nombre_proveedor, prov.pais_proveedor, prov.ruc_proveedor, prov.telefono_proveedor, \n"
                    + " prov.direccion_proveedor, ciu.descripcion_ciudad \n"
                    + " FROM public.proveedor prov \n"
                    + " INNER JOIN ciudad ciu ON prov.id_ciudad = ciu.id_ciudad \n"
                    + " WHERE prov.estado_proveedor = 'activo' \n"
                    + " ORDER BY id_proveedor");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return proveedor;
            } else {
                do {
                    id_prov = rs.getInt("id_proveedor");
                    nom_prov = rs.getString("nombre_proveedor");
                    proc_prov = rs.getString("pais_proveedor");
                    ruc_prov = rs.getString("ruc_proveedor");
                    tel_prov = rs.getString("telefono_proveedor");
                    dir_prov = rs.getString("direccion_proveedor");
                    ciu_prov = rs.getString("descripcion_ciudad");

                    proveedorHallado = new Proveedor(id_prov, nom_prov, proc_prov, ruc_prov, tel_prov, dir_prov, ciu_prov);
                    proveedor.add(proveedorHallado);

                } while (rs.next());
                ConectaBD.cerrar();
                return proveedor;
            }

        } catch (Exception e) {
            System.out.println("Error al leer activos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Proveedor> leerProveedorIna() {
        ArrayList<Proveedor> proveedor = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT prov.id_proveedor, prov.nombre_proveedor, prov.pais_proveedor, prov.ruc_proveedor, prov.telefono_proveedor, \n"
                    + " prov.direccion_proveedor, ciu.descripcion_ciudad \n"
                    + " FROM public.proveedor prov \n"
                    + " INNER JOIN ciudad ciu ON prov.id_ciudad = ciu.id_ciudad  \n"
                    + " WHERE prov.estado_proveedor = 'inactivo' \n"
                    + " ORDER BY id_proveedor");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return proveedor;
            } else {
                do {
                    id_prov = rs.getInt("id_proveedor");
                    nom_prov = rs.getString("nombre_proveedor");
                    proc_prov = rs.getString("pais_proveedor");
                    ruc_prov = rs.getString("ruc_proveedor");
                    tel_prov = rs.getString("telefono_proveedor");
                    dir_prov = rs.getString("direccion_proveedor");
                    ciu_prov = rs.getString("descripcion_ciudad");

                    proveedorHallado = new Proveedor(id_prov, nom_prov, proc_prov, ruc_prov, tel_prov, dir_prov, ciu_prov);
                    proveedor.add(proveedorHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return proveedor;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al leer inactivos");
            e.printStackTrace();
            return null;
        }
    }

    public int cambiarActivo(Proveedor prov) {
        int r = 0;
        String sql = "UPDATE public.proveedor \n"
                + "SET  estado_proveedor = 'activo' \n"
                + "WHERE id_proveedor = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, prov.getId_prov());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;

                prov.setEstado_prov(rs.getString("estado_proveedor"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int cambiarInactivo(Proveedor prov) {
        int r = 0;
        String sql = "UPDATE public.proveedor \n"
                + "SET  estado_proveedor = 'inactivo' \n"
                + "WHERE id_proveedor = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, prov.getId_prov());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;

                prov.setEstado_prov(rs.getString("estado_proveedor"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public Proveedor editarProveedor(String editartxt) {
        int r = 0;
        Proveedor prov = new Proveedor();
        String sql = "SELECT prov.id_proveedor, prov.nombre_proveedor, prov.pais_proveedor, prov.ruc_proveedor, prov.telefono_proveedor, \n"
                + " prov.direccion_proveedor, ciu.descripcion_ciudad \n"
                + " FROM public.proveedor prov \n"
                + " INNER JOIN ciudad ciu ON prov.id_ciudad = ciu.id_ciudad  \n"
                + " WHERE prov.id_proveedor = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));

            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                prov.setId_prov(rs.getInt("id_proveedor"));
                prov.setNom_prov(rs.getString("nombre_proveedor"));
                prov.setProc_prov(rs.getString("pais_proveedor"));
                prov.setRuc_prov(rs.getString("ruc_proveedor"));
                prov.setTel_prov(rs.getString("telefono_proveedor"));
                prov.setDir_prov(rs.getString("direccion_proveedor"));
                prov.setCiu_prov(rs.getString("descripcion_ciudad"));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta Editar");

        } finally {
            return prov;

        }
    }

    public int modificarProveedor(Proveedor prov) {
        String sql = "UPDATE public.proveedor\n"
                + "SET nombre_proveedor=?, pais_proveedor=?, ruc_proveedor=?, telefono_proveedor=?, direccion_proveedor=?, \n"
                + "estado_proveedor=?, nombre_usuario_modificacion=?, fecha_modificacion=(SELECT current_date), id_ciudad=? \n"
                + "WHERE id_proveedor = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getNom_prov());
            ps.setString(2, prov.getProc_prov());
            ps.setString(3, prov.getRuc_prov());
            ps.setString(4, prov.getTel_prov());
            ps.setString(5, prov.getDir_prov());
            ps.setString(6, prov.getEstado_prov());
            ps.setString(7, prov.getNom_usu_mod());
            ps.setInt(8, prov.getId_ciu());
            ps.setInt(9, prov.getId_prov());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("");
            ConectaBD.cerrar();
            return 0;
        }
    }

    /////////////////////////////ORDEN DE COMPRA////////////////////////////////
    public Proveedor añadirProveedor(String buscartxt) {
        int r = 0;
        Proveedor prov = new Proveedor();
        String sql = "SELECT prov.id_proveedor, prov.nombre_proveedor, prov.ruc_proveedor, prov.telefono_proveedor, \n"
                + "prov.direccion_proveedor, ciu.descripcion_ciudad \n"
                + "FROM public.proveedor prov \n"
                + "INNER JOIN ciudad ciu ON prov.id_ciudad = ciu.id_ciudad \n"
                + "WHERE prov.id_proveedor = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(buscartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                Variables.id_prov_orden = (rs.getInt("id_proveedor"));
                Variables.nombre_prov_orden = (rs.getString("nombre_proveedor"));
                Variables.direccion_prov_orden = (rs.getString("direccion_proveedor"));
                Variables.ruc_prov_orden = (rs.getString("ruc_proveedor"));
                Variables.ciudad_prov_orden = (rs.getString("descripcion_ciudad"));
                Variables.tel_prov_orden = (rs.getString("telefono_proveedor"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return prov;
        }
    }
}
