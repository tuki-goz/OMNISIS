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
public class Fiscal implements ValidarFiscal {

    //CONSTRUCTORES - SET - GET
    int id_fis;
    String descrip_fis;

    public Fiscal() {
    }

    public Fiscal(int id_fis, String descrip_fis) {
        this.id_fis = id_fis;
        this.descrip_fis = descrip_fis;
    }

    public int getId_fis() {
        return id_fis;
    }

    public void setId_fis(int id_fis) {
        this.id_fis = id_fis;
    }

    public String getDescrip_fis() {
        return descrip_fis;
    }

    public void setDescrip_fis(String descrip_fis) {
        this.descrip_fis = descrip_fis;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Fiscal fiscalHallado;

    @Override
    public int registrarFiscal(Fiscal fis) {
        String sql = "INSERT INTO public.fiscal (descripcion_fis)\n"
                + "	VALUES (?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fis.getDescrip_fis());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            ConectaBD.cerrar();
            Variables.existe = 1;
            return 0;
        }
    }

    public HashMap seleccionarFiscal() {
        HashMap<String, String> drop_fiscal = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_fiscal as id_fis, descripcion_fis \n"
                    + "FROM public.fiscal\n"
                    + "ORDER BY id_fiscal";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_fiscal.put(rs.getString("id_fis"), rs.getString("descripcion_fis"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ConectaBD.cerrar();
        }
        return drop_fiscal;
    }

    public ArrayList<Fiscal> buscarFiscal(String buscartxt) {
        ArrayList<Fiscal> fiscal = new ArrayList<>();
        String sql = "SELECT id_fiscal, descripcion_fis\n"
                + "FROM public.fiscal\n"
                + "WHERE descripcion ILIKE ?";
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
                    id_fis = rs.getInt("id_fiscal");
                    descrip_fis = rs.getString("descripcion_fis");
                    fiscalHallado = new Fiscal(id_fis, descrip_fis);
                    fiscal.add(fiscalHallado);
                } while (rs.next());
                Variables.mensajeError = 0;
                ConectaBD.cerrar();
                return fiscal;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Fiscal editarFiscal(String editartxt) {
        int r = 0;
        Fiscal fis = new Fiscal();
        String sql = "SELECT id_fiscal, descripcion_fis \n"
                + "FROM fiscal \n"
                + "WHERE id_fiscal = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                fis.setId_fis(rs.getInt("id_fiscal"));
                fis.setDescrip_fis(rs.getString("descripcion_fis"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");
        } finally {
            ConectaBD.cerrar();
            return fis;
        }
    }

    public int modificarFiscal(Fiscal fis) {
        String sql = "UPDATE public.fiscal\n"
                + "	SET  descripcion_fis=?\n"
                + "	WHERE id_fiscal=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fis.getDescrip_fis());
            ps.setInt(2, fis.getId_fis());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            ConectaBD.cerrar();
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Fiscal> leerFiscal() {
        ArrayList<Fiscal> fiscal = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_fiscal, descripcion_fis\n"
                    + "  FROM public.fiscal\n"
                    + "  ORDER BY id_fiscal");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return fiscal;
            } else {
                do {
                    id_fis = rs.getInt("id_fiscal");
                    descrip_fis = rs.getString("descripcion_fis");
                    fiscalHallado = new Fiscal(id_fis, descrip_fis);
                    fiscal.add(fiscalHallado);
                    Variables.nohayRegistro = 1;
                } while (rs.next());
                ConectaBD.cerrar();
                return fiscal;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

}
