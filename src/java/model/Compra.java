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
public class Compra implements ValidarCompra {

    //CONSTRUCTORES - SET - GET
    //CABECERA
    int id_com, id_prov, id_con, id_mon, id_usu, id_cond, total_com, liq5_total_com, liq10_total_com, liq_total_com, subtotal_iva5_com, subtotal_iva10_com, subtotal_exenta_com, id_st;
    String nro_fac, proveedor, fecha_com, estado_com, nom_usu_mod, fecha_mod, cont_clie;

    //DETALLE
    int id_com_d, id_pr, cant_com_d, precio_com_d, exentas_com_d, iva5_com_d, iva10_com_d;
    String descrip_com_d;

    public Compra() {
    }

    //CABECERA
    public Compra(int id_com, int id_prov, int id_con, int id_mon, int id_usu, int id_cond, String nro_fac, String proveedor, String fecha_com, String estado_com, String nom_usu_mod, String fecha_mod, int total_com, int liq5_total_com, int liq10_total_com, int liq_total_com, int subtotal_iva5_com, int subtotal_iva10_com, int subtotal_exenta_com) {
        this.id_com = id_com;
        this.id_prov = id_prov;
        this.id_con = id_con;
        this.id_mon = id_mon;
        this.id_usu = id_usu;
        this.id_cond = id_cond;
        this.nro_fac = nro_fac;
        this.proveedor = proveedor;
        this.fecha_com = fecha_com;
        this.estado_com = estado_com;
        this.nom_usu_mod = nom_usu_mod;
        this.fecha_mod = fecha_mod;
        this.total_com = total_com;
        this.liq5_total_com = liq5_total_com;
        this.liq10_total_com = liq10_total_com;
        this.liq_total_com = liq_total_com;
        this.subtotal_iva5_com = subtotal_iva5_com;
        this.subtotal_iva10_com = subtotal_iva10_com;
        this.subtotal_exenta_com = subtotal_exenta_com;
    }

    //DETALLE
    public Compra(int id_com_d, int id_pr, int cant_com_d, String descrip_com_d, int precio_com_d, int exentas_com_d, int iva5_com_d, int iva10_com_d) {
        this.id_com_d = id_com_d;
        this.id_pr = id_pr;
        this.cant_com_d = cant_com_d;
        this.descrip_com_d = descrip_com_d;
        this.precio_com_d = precio_com_d;
        this.exentas_com_d = exentas_com_d;
        this.iva5_com_d = iva5_com_d;
        this.iva10_com_d = iva10_com_d;
    }

    public Compra(int id_com, int total_com, String nro_fac, String proveedor, String fecha_com, String estado_com, String cont_clie) {
        this.id_com = id_com;
        this.total_com = total_com;
        this.nro_fac = nro_fac;
        this.proveedor = proveedor;
        this.fecha_com = fecha_com;
        this.estado_com = estado_com;
        this.cont_clie = cont_clie;
    }

    public int getId_st() {
        return id_st;
    }

    public void setId_st(int id_st) {
        this.id_st = id_st;
    }

    public String getCont_clie() {
        return cont_clie;
    }

    public void setCont_clie(String cont_clie) {
        this.cont_clie = cont_clie;
    }

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public int getId_con() {
        return id_con;
    }

    public void setId_con(int id_con) {
        this.id_con = id_con;
    }

    public int getId_mon() {
        return id_mon;
    }

    public void setId_mon(int id_mon) {
        this.id_mon = id_mon;
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

    public String getNro_fac() {
        return nro_fac;
    }

    public void setNro_fac(String nro_fac) {
        this.nro_fac = nro_fac;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFecha_com() {
        return fecha_com;
    }

    public void setFecha_com(String fecha_com) {
        this.fecha_com = fecha_com;
    }

    public String getEstado_com() {
        return estado_com;
    }

    public void setEstado_com(String estado_com) {
        this.estado_com = estado_com;
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

    public int getTotal_com() {
        return total_com;
    }

    public void setTotal_com(int total_com) {
        this.total_com = total_com;
    }

    public int getLiq5_total_com() {
        return liq5_total_com;
    }

    public void setLiq5_total_com(int liq5_total_com) {
        this.liq5_total_com = liq5_total_com;
    }

    public int getLiq10_total_com() {
        return liq10_total_com;
    }

    public void setLiq10_total_com(int liq10_total_com) {
        this.liq10_total_com = liq10_total_com;
    }

    public int getLiq_total_com() {
        return liq_total_com;
    }

    public void setLiq_total_com(int liq_total_com) {
        this.liq_total_com = liq_total_com;
    }

    public int getSubtotal_iva5_com() {
        return subtotal_iva5_com;
    }

    public void setSubtotal_iva5_com(int subtotal_iva5_com) {
        this.subtotal_iva5_com = subtotal_iva5_com;
    }

    public int getSubtotal_iva10_com() {
        return subtotal_iva10_com;
    }

    public void setSubtotal_iva10_com(int subtotal_iva10_com) {
        this.subtotal_iva10_com = subtotal_iva10_com;
    }

    public int getSubtotal_exenta_com() {
        return subtotal_exenta_com;
    }

    public void setSubtotal_exenta_com(int subtotal_exenta_com) {
        this.subtotal_exenta_com = subtotal_exenta_com;
    }

    public int getId_com_d() {
        return id_com_d;
    }

    public void setId_com_d(int id_com_d) {
        this.id_com_d = id_com_d;
    }

    public int getId_pr() {
        return id_pr;
    }

    public void setId_pr(int id_pr) {
        this.id_pr = id_pr;
    }

    public int getCant_com_d() {
        return cant_com_d;
    }

    public void setCant_com_d(int cant_com_d) {
        this.cant_com_d = cant_com_d;
    }

    public String getDescrip_com_d() {
        return descrip_com_d;
    }

    public void setDescrip_com_d(String descrip_com_d) {
        this.descrip_com_d = descrip_com_d;
    }

    public int getPrecio_com_d() {
        return precio_com_d;
    }

    public void setPrecio_com_d(int precio_com_d) {
        this.precio_com_d = precio_com_d;
    }

    public int getExentas_com_d() {
        return exentas_com_d;
    }

    public void setExentas_com_d(int exentas_com_d) {
        this.exentas_com_d = exentas_com_d;
    }

    public int getIva5_com_d() {
        return iva5_com_d;
    }

    public void setIva5_com_d(int iva5_com_d) {
        this.iva5_com_d = iva5_com_d;
    }

    public int getIva10_com_d() {
        return iva10_com_d;
    }

    public void setIva10_com_d(int iva10_com_d) {
        this.iva10_com_d = iva10_com_d;
    }

//FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    //CAMBSOAS
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    PreparedStatement ps2;
    PreparedStatement ps3;
    PreparedStatement ps4;
    PreparedStatement ps5;
    ResultSet rs;
    ResultSet rs2;
    private Statement stm;
    private Compra compraHallado;

    @Override
    public int registrarCompra(Compra com) {
        try {
            con = cn.getConnection();
            String sql = "INSERT INTO public.compra(\n"
                    + "proveedor,  fecha_compra, total_compra, estado_compra, \n"
                    + "nombre_usuario_modificacion, fecha_modificacion, id_proveedor, id_contrato, \n"
                    + "id_moneda, id_usuario, liq5_total_iva_compra, liq10_total_iva_compra, \n"
                    + "liq_total_iva_compra, subtotal_iva5_compra, subtotal_iva10_compra,\n"
                    + "subtotal_exenta_compra, id_condicion)\n"
                    + "VALUES (?, (select current_date), ?, 'pendiente', ?, (select current_date), ?, (select st.id_contrato from servicio_tecnico st inner join contrato cont on st.id_contrato = cont.id_contrato where st.id_servicio_tecnico = ?), ?,\n"
                    + " ?, ?, ?, ?, ?, ?, ?, ?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, com.getProveedor());
            ps.setDouble(2, com.getTotal_com());
            ps.setString(3, com.getNom_usu_mod());
            ps.setInt(4, com.getId_prov());
            ps.setInt(5, com.getId_st());
            ps.setInt(6, com.getId_mon());
            ps.setInt(7, com.getId_usu());
            ps.setInt(8, com.getLiq5_total_com());
            ps.setInt(9, com.getLiq10_total_com());
            ps.setInt(10, com.getLiq_total_com());
            ps.setInt(11, com.getSubtotal_iva5_com());
            ps.setInt(12, com.getSubtotal_iva10_com());
            ps.setInt(13, com.getSubtotal_exenta_com());
            ps.setInt(14, com.getId_cond());
            ps.executeUpdate();

            // insert detalle
            String sql1 = "INSERT INTO public.compra_detalle(\n"
                    + "cantidad_compra_d, descripcion, precio_uni_compra_d, excentas_compra_d, iva5_compra_d,\n"
                    + "iva10_compra_d, id_compra, id_producto)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, (select MAX(id_compra) from compra), ?)";

            for (Compra compradet : Variables.compraDet1) {
                ps2 = con.prepareStatement(sql1);

                ps2.setInt(1, compradet.getCant_com_d());
                ps2.setString(2, compradet.getDescrip_com_d());
                ps2.setInt(3, compradet.getPrecio_com_d());
                ps2.setInt(4, compradet.getExentas_com_d());
                ps2.setInt(5, compradet.getIva5_com_d());
                ps2.setInt(6, compradet.getIva10_com_d());
                ps2.setInt(7, compradet.getId_pr());
                ps2.executeUpdate();
                
                 String sql5 = "UPDATE public.producto\n"
                            + "SET cantidad=cantidad+?\n"
                            + "WHERE id_producto=?";
                    con = cn.getConnection();
                    ps5 = con.prepareStatement(sql5);
                    ps5.setInt(1, compradet.getCant_com_d());
                    ps5.setInt(2, compradet.getId_pr());
                    ps5.executeUpdate();
            }
            Variables.compraDet1.clear();
            return 1;

        } catch (Exception e) {
            System.out.println("Error en la consulta registrarCompra");
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public HashMap seleccionarCompra() {
        HashMap<String, String> dropcompra_det = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT com.id_compra as id_com,comet.descripcion\n"
                    + "FROM compra com\n"
                    + "INNER JOIN compra_detalle comet\n"
                    + "ON comet.id_compra = com.id_compra\n"
                    + "WHERE estado_compra = 'activo'";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                dropcompra_det.put(rs.getString("id_com"), rs.getString("comet.descripcion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dropcompra_det;
    }

    public ArrayList<Compra> leerCompraRe() {
        ArrayList<Compra> compra = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT com.id_compra, com.nro_factura_compra, com.proveedor, com.fecha_compra, com.total_compra, \n"
                    + "com.estado_compra, cont.cliente_contrato\n"
                    + "FROM public.compra com\n"
                    + "INNER JOIN contrato cont ON com.id_contrato = cont.id_contrato \n"
                    + "WHERE com.estado_compra = 'pagado'\n"
                    + "ORDER BY id_compra");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return compra;
            } else {
                do {
                    id_com = rs.getInt("id_compra");
                    nro_fac = rs.getString("nro_factura_compra");
                    proveedor = rs.getString("proveedor");
                    fecha_com = rs.getString("fecha_compra");
                    total_com = rs.getInt("total_compra");
                    estado_com = rs.getString("estado_compra");
                    cont_clie = rs.getString("cliente_contrato");
                    compraHallado = new Compra(id_com, total_com, nro_fac, proveedor, fecha_com, estado_com, cont_clie);
                    compra.add(compraHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return compra;
            }

        } catch (Exception e) {
            System.out.println("Error en la consulta leerCompraRe");
            e.printStackTrace();
            return null;
        }
    }

    public int actualizarCompra(Compra com) {
        int r = 0;
        String sql = "UPDATE public.compra\n"
                + "	SET nro_factura_compra=?, fecha_compra=?, estado_compra='pagado', nombre_usuario_modificacion=?, fecha_modificacion=(SELECT CURRENT_DATE)\n"
                + "	WHERE id_compra=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, com.getNro_fac());
            ps.setString(2, com.getFecha_com());
            ps.setString(3, com.getNom_usu_mod());
            ps.setInt(4, com.getId_com());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
