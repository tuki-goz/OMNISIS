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
public class Timbrado implements ValidarTimbrado {

    //CONSTRUCTORES - SET - GET
    int id_tim;
    String nro_tim, estado_tim, ini_vigen_tim, fin_vigen_tim, ultimo_nro_tim;

    public Timbrado() {
    }

    public Timbrado(int id_tim, String nro_tim, String estado_tim, String ini_vigen_tim, String fin_vigen_tim, String ultimo_nro_tim) {
        this.id_tim = id_tim;
        this.nro_tim = nro_tim;
        this.estado_tim = estado_tim;
        this.ini_vigen_tim = ini_vigen_tim;
        this.fin_vigen_tim = fin_vigen_tim;
        this.ultimo_nro_tim = ultimo_nro_tim;
    }

    public int getId_tim() {
        return id_tim;
    }

    public void setId_tim(int id_tim) {
        this.id_tim = id_tim;
    }

    public String getNro_tim() {
        return nro_tim;
    }

    public void setNro_tim(String nro_tim) {
        this.nro_tim = nro_tim;
    }

    public String getEstado_tim() {
        return estado_tim;
    }

    public void setEstado_tim(String estado_tim) {
        this.estado_tim = estado_tim;
    }

    public String getIni_vigen_tim() {
        return ini_vigen_tim;
    }

    public void setIni_vigen_tim(String ini_vigen_tim) {
        this.ini_vigen_tim = ini_vigen_tim;
    }

    public String getFin_vigen_tim() {
        return fin_vigen_tim;
    }

    public void setFin_vigen_tim(String fin_vigen_tim) {
        this.fin_vigen_tim = fin_vigen_tim;
    }

    public String getUltimo_nro_tim() {
        return ultimo_nro_tim;
    }

    public void setUltimo_nro_tim(String ultimo_nro_tim) {
        this.ultimo_nro_tim = ultimo_nro_tim;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Timbrado timbradoHallado;

    @Override
    public int registrarTimbrado(Timbrado tim) {
        String sql = "INSERT INTO public.timbrado(\n"
                + "	nro_timbrado, estado_timbrado, ini_vigen_timbrado, fin_vigen_timbrado, ultimo_num_timbrado)\n"
                + "	VALUES (?, ?, ?, ?, ?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tim.getNro_tim());
            ps.setString(2, tim.getEstado_tim());
            ps.setString(3, tim.getIni_vigen_tim());
            ps.setString(4, tim.getFin_vigen_tim());
            ps.setString(5, tim.getUltimo_nro_tim());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            ConectaBD.cerrar();
            return 0;
        }
    }

    public HashMap seleccionarTimbrado() {
        HashMap<String, String> drop_tim = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_timbrado as id_tim,nro_timbrado\n"
                    + "FROM public.banco;";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_tim.put(rs.getString("id_tim"), rs.getString("nro_timbrado"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drop_tim;
    }

    public int modificarTimbrado(Timbrado tim) {
        String sql = "UPDATE public.timbrado\n"
                + "SET nro_timbrado=?, estado_timbrado=?, ini_vigen_timbrado=?, fin_vigen_timbrado=?, ultimo_num_timbrado=?\n"
                + "WHERE id_timbrado=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tim.getNro_tim());
            ps.setString(2, tim.getEstado_tim());
            ps.setString(3, tim.getIni_vigen_tim());
            ps.setString(4, tim.getFin_vigen_tim());
            ps.setString(5, tim.getUltimo_nro_tim());
            ps.setInt(6, tim.getId_tim());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Timbrado> leerTimbradoAc() {
        ArrayList<Timbrado> timbrado = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_timbrado, nro_timbrado, estado_timbrado, ini_vigen_timbrado, fin_vigen_timbrado, ultimo_num_timbrado\n"
                    + "FROM public.timbrado\n"
                    + "WHERE estado_timbrado='activo'\n"
                    + "ORDER BY id_timbrado");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return timbrado;
            } else {
                do {
                    id_tim = rs.getInt("id_timbrado");
                    nro_tim = rs.getString("nro_timbrado");
                    ini_vigen_tim = rs.getString("ini_vigen_timbrado");
                    fin_vigen_tim = rs.getString("fin_vigen_timbrado");
                    ultimo_nro_tim = rs.getString("ultimo_num_timbrado");
                    estado_tim = rs.getString("estado_timbrado");
                    timbradoHallado = new Timbrado(id_tim, nro_tim, estado_tim, ini_vigen_tim, fin_vigen_tim, ultimo_nro_tim);
                    timbrado.add(timbradoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return timbrado;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Timbrado> buscarTimbrado(String buscartxt) {
        ArrayList<Timbrado> timbrado = new ArrayList<>();
        String sql = "SELECT id_timbrado, nro_timbrado, estado_timbrado, ini_vigen_timbrado, fin_vigen_timbrado, ultimo_num_timbrado\n"
                + "FROM public.timbrado\n"
                + "WHERE estado_timbrado='activo'\n"
                + "AND nro_timbrado ILIKE ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return timbrado;
            } else {
                do {
                    id_tim = rs.getInt("id_timbrado");
                    nro_tim = rs.getString("nro_timbrado");
                    ini_vigen_tim = rs.getString("ini_vigen_timbrado");
                    fin_vigen_tim = rs.getString("fin_vigen_timbrado");
                    estado_tim = rs.getString("estado_timbrado");
                    ultimo_nro_tim = rs.getString("ultimo_num_timbrado");
                    timbradoHallado = new Timbrado(id_tim, nro_tim, estado_tim, ini_vigen_tim, fin_vigen_tim, ultimo_nro_tim);
                    timbrado.add(timbradoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return timbrado;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Timbrado editarTimbrado(String editartxt) {
        int r = 0;
        Timbrado tim = new Timbrado();
        String sql = "SELECT id_timbrado, nro_timbrado, estado_timbrado, ini_vigen_timbrado, fin_vigen_timbrado, ultimo_num_timbrado\n"
                + "FROM public.timbrado\n"
                + "WHERE id_timbrado = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                tim.setId_tim(rs.getInt("id_timbrado"));
                tim.setNro_tim(rs.getString("nro_timbrado"));
                tim.setIni_vigen_tim(rs.getString("ini_vigen_timbrado"));
                tim.setFin_vigen_tim(rs.getString("fin_vigen_timbrado"));
                tim.setUltimo_nro_tim(rs.getString("ultimo_num_timbrado"));
                tim.setEstado_tim(rs.getString("estado_timbrado"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");
        } finally {
            ConectaBD.cerrar();
            return tim;
        }
    }

    public int cambiarInactivo(Timbrado tim) {
        String sql = "UPDATE public.timbrado\n"
                + "SET  estado_timbrado='inactivo'\n"
                + "WHERE id_timbrado=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, tim.getId_tim());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int cambiarActivo(Timbrado tim) {
        String sql = "UPDATE public.timbrado\n"
                + "SET  estado_timbrado='activo'\n"
                + "WHERE id_timbrado=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, tim.getId_tim());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Timbrado> leerTimbradoIna() {
        ArrayList<Timbrado> timbrado = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_timbrado, nro_timbrado, estado_timbrado, ini_vigen_timbrado, fin_vigen_timbrado, ultimo_num_timbrado\n"
                    + "FROM public.timbrado\n"
                    + "WHERE estado_timbrado='inactivo'\n"
                    + "ORDER BY id_timbrado");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                Variables.nohayRegistro = 0;
                return timbrado;
            } else {
                do {
                    id_tim = rs.getInt("id_timbrado");
                    nro_tim = rs.getString("nro_timbrado");
                    ini_vigen_tim = rs.getString("ini_vigen_timbrado");
                    fin_vigen_tim = rs.getString("fin_vigen_timbrado");
                    estado_tim = rs.getString("estado_timbrado");
                    ultimo_nro_tim = rs.getString("ultimo_num_timbrado");
                    timbradoHallado = new Timbrado(id_tim, nro_tim, estado_tim, ini_vigen_tim, fin_vigen_tim, ultimo_nro_tim);
                    timbrado.add(timbradoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                Variables.nohayRegistro = 1;
                return timbrado;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
