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
public class TipoContrato implements ValidarTipoContrato {

    int id_tipo_contrato;
    String descrip, estado_tipo;

    public TipoContrato() {
    }

    public TipoContrato(int id_tipo_contrato, String descrip, String estado_tipo) {
        this.id_tipo_contrato = id_tipo_contrato;
        this.descrip = descrip;
        this.estado_tipo = estado_tipo;
    }

    public int getId_tipo_contrato() {
        return id_tipo_contrato;
    }

    public void setId_tipo_contrato(int id_tipo_contrato) {
        this.id_tipo_contrato = id_tipo_contrato;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getEstado_tipo() {
        return estado_tipo;
    }

    public void setEstado_tipo(String estado_tipo) {
        this.estado_tipo = estado_tipo;
    }

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private TipoContrato tipocontratoHallado;

    @Override
    public int registrarTipoContrato(TipoContrato tc) {
        int r = 0;
        String sql = "INSERT INTO public.tipo_contrato(descripcion, estado_tipo_cont) \n"
                + "	VALUES (?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tc.getDescrip());
            ps.setString(2, tc.getEstado_tipo());
            ps.executeUpdate();

            return 1;

//            rs = ps.executeQuery();
//            while (rs.next()) {
//                r = r + 1;
//                tc.setDescrip(rs.getString("descripcion"));
//               tc.setEstado_tipo(rs.getString("estado_tipo_cont"));
//            }
//            if (r == 1) {
//                return 1;
//            } else {
//                return 0;
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Variables.existe = 1;
            return 0;
        }
    }

    public HashMap seleccionarTipoContrato() {
        HashMap<String, String> droptc_tc = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_tipo_contrato as id_tc, descripcion, estado_tipo_cont \n"
                    + "	FROM public.tipo_contrato \n"
                    + " WHERE estado_tipo_cont = 'activo';";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                droptc_tc.put(rs.getString("id_tc"), rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("No anda tu cagada");
        }
        return droptc_tc;
    }

//    public TipoContrato buscarTipoContrato(String buscartxt) {
//        int r = 0;
//        TipoContrato tc = new TipoContrato();
//        String sql = "SELECT id_tipo_contrato, descripcion \n"
//                + "FROM tipo_contrato \n"
//                + "WHERE descripcion = ? \n"
//                + "AND estado_tipo_cont = 'activo';";
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, buscartxt);
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                r = r + 1;
//                tc.setDescrip(rs.getString("descripcion"));
//                tc.setId_tipo_contrato(rs.getInt("id_tipo_contrato"));
//            }
//        } catch (Exception e) {
//            System.out.println("hola");
//        } finally {
//            return tc;
//        }
//    }
    public int modificarTipoContrato(TipoContrato tc) {
        int r = 0;
        String sql = "UPDATE public.tipo_contrato \n"
                + "SET descripcion=?, estado_tipo_cont=? \n"
                + "WHERE id_tipo_contrato = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tc.getDescrip());
            ps.setString(2, tc.getEstado_tipo());
            ps.setInt(3, tc.getId_tipo_contrato());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            ConectaBD.cerrar();
            System.out.println(e.getMessage());
            return 0;
        }

    }

    public ArrayList<TipoContrato> buscarTipoContrato(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;

        ArrayList<TipoContrato> tipocontrato = new ArrayList<>();
        String sql = "SELECT id_tipo_contrato, descripcion, estado_tipo_cont \n"
                + "FROM tipo_contrato \n"
                + "WHERE descripcion = ? \n"
                + "AND estado_tipo_cont = 'activo';";
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
                    id_tipo_contrato = rs.getInt("id_tipo_contrato");
                    descrip = rs.getString("descripcion");
                    estado_tipo = rs.getString("estado_tipo_cont");
                    tipocontratoHallado = new TipoContrato(id_tipo_contrato, descrip, estado_tipo);
                    tipocontrato.add(tipocontratoHallado);
                } while (rs.next());
                Variables.mensajeError = 0;
                ConectaBD.cerrar();
                return tipocontrato;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<TipoContrato> buscarTipoContratoIna(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;

        ArrayList<TipoContrato> tipocontrato = new ArrayList<>();
        String sql = "SELECT id_tipo_contrato, descripcion, estado_tipo_cont \n"
                + "FROM tipo_contrato \n"
                + "WHERE descripcion = ? \n"
                + "AND estado_tipo_cont = 'inactivo';";
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
                    id_tipo_contrato = rs.getInt("id_tipo_contrato");
                    descrip = rs.getString("descripcion");
                    estado_tipo = rs.getString("estado_tipo_cont");
                    tipocontratoHallado = new TipoContrato(id_tipo_contrato, descrip, estado_tipo);
                    tipocontrato.add(tipocontratoHallado);
                } while (rs.next());
                Variables.mensajeError = 0;
                ConectaBD.cerrar();
                return tipocontrato;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public TipoContrato editarTipoContrato(String editartxt) {
        int r = 0;
        TipoContrato tc = new TipoContrato();
        String sql = "SELECT id_tipo_contrato, descripcion, estado_tipo_cont \n"
                + "FROM tipo_contrato \n"
                + "WHERE id_tipo_contrato = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                tc.setId_tipo_contrato(rs.getInt("id_tipo_contrato"));
                tc.setDescrip(rs.getString("descripcion"));
                tc.setEstado_tipo(rs.getString("estado_tipo_cont"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");
        } finally {
            ConectaBD.cerrar();
            return tc;
        }
    }

    public ArrayList<TipoContrato> leerTipoContratoAc() {
        ArrayList<TipoContrato> tipocontrato = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_tipo_contrato, descripcion, estado_tipo_cont \n"
                    + "  FROM public.tipo_contrato \n"
                    + "  WHERE estado_tipo_cont = 'activo' \n"
                    + "  ORDER BY id_tipo_contrato");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return tipocontrato;
            } else {
                do {
                    id_tipo_contrato = rs.getInt("id_tipo_contrato");
                    descrip = rs.getString("descripcion");
                    estado_tipo = rs.getString("estado_tipo_cont");
                    tipocontratoHallado = new TipoContrato(id_tipo_contrato, descrip, estado_tipo);
                    tipocontrato.add(tipocontratoHallado);
                    Variables.nohayRegistro = 1;
                } while (rs.next());
                ConectaBD.cerrar();
                return tipocontrato;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<TipoContrato> leerTipoContratoIna() {
        ArrayList<TipoContrato> tipocontrato = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_tipo_contrato, descripcion, estado_tipo_cont \n"
                    + "  FROM public.tipo_contrato \n"
                    + "  WHERE estado_tipo_cont = 'inactivo' \n"
                    + "  ORDER BY id_tipo_contrato");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return tipocontrato;
            } else {
                do {
                    id_tipo_contrato = rs.getInt("id_tipo_contrato");
                    descrip = rs.getString("descripcion");
                    estado_tipo = rs.getString("estado_tipo_cont");
                    tipocontratoHallado = new TipoContrato(id_tipo_contrato, descrip, estado_tipo);
                    tipocontrato.add(tipocontratoHallado);
                    Variables.nohayRegistro = 1;
                } while (rs.next());
                ConectaBD.cerrar();
                return tipocontrato;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int cambiarActivo(TipoContrato tc) {
        int r = 0;
        String sql = "UPDATE public.tipo_contrato \n"
                + "	SET  estado_tipo_contrato='activo' \n"
                + "	WHERE id_tipo_contrato=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, tc.getId_tipo_contrato());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                tc.setDescrip(rs.getString("descripcion"));
                tc.setEstado_tipo(rs.getString("estado_tipo_cont"));
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

    public int cambiarInactivo(TipoContrato tc) {
        int r = 0;
        String sql = "UPDATE public.tipo_contrato \n"
                + "	SET  estado_tipo_contrato = 'inactivo' \n"
                + "	WHERE id_tipo_contrato = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, tc.getId_tipo_contrato());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                tc.setDescrip(rs.getString("descripcion"));
                tc.setEstado_tipo(rs.getString("estado_tipo_cont"));
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

}
