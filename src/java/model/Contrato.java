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
public class Contrato implements ValidarContrato {

    int id_contrato, id_cliente, id_tipo_contrato, id_fiscal;
    String cliente_contrato, fiscal_contrato, codigo_contrato, validez_contrato, fecha_inicio, fecha_fin, tipo_contrato, estado_contrato, nom_usu, descripcion_cliente;

    public Contrato() {
    }

    public Contrato(int id_contrato, int id_cliente, String cliente_contrato, String fiscal_contrato, String codigo_contrato, String validez_contrato, String fecha_inicio, String fecha_fin, String tipo_contrato, String estado_contrato, String nom_usu, String descripcion_cliente) {
        this.id_contrato = id_contrato;
        this.id_cliente = id_cliente;
        this.cliente_contrato = cliente_contrato;
        this.fiscal_contrato = fiscal_contrato;
        this.codigo_contrato = codigo_contrato;
        this.validez_contrato = validez_contrato;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tipo_contrato = tipo_contrato;
        this.estado_contrato = estado_contrato;
        this.nom_usu = nom_usu;
        this.descripcion_cliente = descripcion_cliente;
    }

    /////// ARRAY BUSCAR ///////////////////////////
    public Contrato(int id_contrato, String cliente_contrato, String fiscal_contrato, String codigo_contrato, String validez_contrato, String fecha_inicio, String fecha_fin, String tipo_contrato, String estado_contrato, String descripcion_cliente) {
        this.id_contrato = id_contrato;
        this.cliente_contrato = cliente_contrato;
        this.fiscal_contrato = fiscal_contrato;
        this.codigo_contrato = codigo_contrato;
        this.validez_contrato = validez_contrato;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tipo_contrato = tipo_contrato;
        this.estado_contrato = estado_contrato;
        this.descripcion_cliente = descripcion_cliente;
    }

    public Contrato(int id_contrato, String cliente_contrato, String codigo_contrato) {
        this.id_contrato = id_contrato;
        this.cliente_contrato = cliente_contrato;
        this.codigo_contrato = codigo_contrato;
    }

    public Contrato(int id_contrato, String codigo_contrato) {
        this.id_contrato = id_contrato;
        this.codigo_contrato = codigo_contrato;
    }

    public int getId_tipo_contrato() {
        return id_tipo_contrato;
    }

    public void setId_tipo_contrato(int id_tipo_contrato) {
        this.id_tipo_contrato = id_tipo_contrato;
    }

    public int getId_fiscal() {
        return id_fiscal;
    }

    public void setId_fiscal(int id_fiscal) {
        this.id_fiscal = id_fiscal;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCliente_contrato() {
        return cliente_contrato;
    }

    public void setCliente_contrato(String cliente_contrato) {
        this.cliente_contrato = cliente_contrato;
    }

    public String getFiscal_contrato() {
        return fiscal_contrato;
    }

    public void setFiscal_contrato(String fiscal_contrato) {
        this.fiscal_contrato = fiscal_contrato;
    }

    public String getCodigo_contrato() {
        return codigo_contrato;
    }

    public void setCodigo_contrato(String codigo_contrato) {
        this.codigo_contrato = codigo_contrato;
    }

    public String getValidez_contrato() {
        return validez_contrato;
    }

    public void setValidez_contrato(String validez_contrato) {
        this.validez_contrato = validez_contrato;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public String getEstado_contrato() {
        return estado_contrato;
    }

    public void setEstado_contrato(String estado_contrato) {
        this.estado_contrato = estado_contrato;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getDescripcion_cliente() {
        return descripcion_cliente;
    }

    public void setDescripcion_cliente(String descripcion_cliente) {
        this.descripcion_cliente = descripcion_cliente;
    }

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Contrato contratoHallado;

    @Override
    public int registrarContrato(Contrato cont) {
        int r = 0;
        String sql = "INSERT INTO public.contrato(\n"
                + "cliente_contrato, fiscal_contrato, codigo_contrato, validez_contrato, fecha_inicio_contrato, fecha_final_contrato, \n"
                + "tipo_contrato, estado_contrato, nombre_usuario_modificacion, fecha_modificacion, id_cliente, id_tipo_contrato, id_fiscal)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, (SELECT current_date), ?, ?, ?);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cont.getCliente_contrato());
            ps.setString(2, cont.getFiscal_contrato());
            ps.setString(3, cont.getCodigo_contrato());
            ps.setString(4, cont.getValidez_contrato());
            ps.setString(5, cont.getFecha_inicio());
            ps.setString(6, cont.getFecha_fin());
            ps.setString(7, cont.getTipo_contrato());
            ps.setString(8, cont.getEstado_contrato());
            ps.setString(9, cont.getNom_usu());
            ps.setInt(10, cont.getId_cliente());
            ps.setInt(11, cont.getId_tipo_contrato());
            ps.setInt(12, cont.getId_fiscal());

            ps.executeUpdate();
            return 1;

//            rs = ps.executeQuery();
//            while (rs.next()) {
//                r = r + 1;
//                //Variables.id = Integer.parseInt(rs.getString("id_usuario"));
//                cont.setCliente_contrato(rs.getString("cliente_contrato"));
//                cont.setFiscal_contrato(rs.getString("fiscal_contrato"));
//                cont.setCodigo_contrato(rs.getString("codigo_contrato"));
//                cont.setValidez_contrato(rs.getString("validez_contrato"));
//                cont.setFecha_inicio(rs.getString("fecha_inicio_contrato"));
//                cont.setFecha_fin(rs.getString("fecha_final_contrato"));
//                cont.setTipo_contrato(rs.getString("tipo_contrato"));
//                cont.setEstado_contrato(rs.getString("estado_contrato"));
//                cont.setNom_usu(rs.getString("nombre_usuario_modificacion"));
//                cont.setId_cliente(rs.getInt("id_cliente"));
//                cont.setId_tipo_contrato(rs.getInt("id_tipo_contrato"));
//                cont.setId_fiscal(rs.getInt("id_fiscal"));
//            }
//            if (r == 1) {
//                
//                return 1;
//            } else {
//                return 0;
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en insercion registrarContrato");
            ConectaBD.cerrar();
            return 0;
        }
    }

    public HashMap seleccionarContrato() {
        HashMap<String, String> drop_cont = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_contrato as id_cont,codigo_contrato\n"
                    + "                    FROM public.contrato\n" //agregar \n" a todos los que no funciona el WHERE
                    + "                    WHERE estado_contrato = 'activo';";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                drop_cont.put(Variables.id_contrato = rs.getString("id_cont"), rs.getString("codigo_contrato"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ConectaBD.cerrar();
        return drop_cont;
    }

    public ArrayList<Contrato> buscarContrato(String buscartxt) {
        int r = 0;
        Contrato cont = new Contrato();
        ArrayList<Contrato> contrato = new ArrayList<>();

        String sql = "SELECT  cont.id_contrato, cont.cliente_contrato, fis.descripcion, cont.codigo_contrato, cont.validez_contrato, cont.fecha_inicio_contrato, cont.fecha_final_contrato,\n"
                + "tc.descripcion, cont.estado_contrato, cont.nombre_usuario_modificacion, cont.fecha_modificacion, clie.descripcion_cliente, cont.id_tipo_contrato, cont.id_fiscal \n"
                + "FROM contrato cont \n"
                + "INNER JOIN cliente clie ON cont.id_cliente = clie.id_cliente \n"
                + "INNER JOIN fiscal fis ON cont.id_fiscal = fis.id_fiscal \n"
                + "INNER JOIN tipo_contrato tc ON tc.id_tipo_contrato = cont.id_tipo_contrato \n"
                + "WHERE cont.cliente_contrato  ilike  ? ";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_contrato = rs.getInt("id_contrato");
                    cliente_contrato = rs.getString("cliente_contrato");
                    fiscal_contrato = rs.getString("fis.descripcion");
                    codigo_contrato = rs.getString("codigo_contrato");
                    validez_contrato = rs.getString("validez_contrato");
                    fecha_inicio = rs.getString("fecha_inicio_contrato");
                    fecha_fin = rs.getString("fecha_final_contrato");
                    tipo_contrato = rs.getString("tc.descripcion");
                    estado_contrato = rs.getString("estado_contrato");
                    descripcion_cliente = rs.getString("descripcion_cliente");

                    contratoHallado = new Contrato(id_contrato, cliente_contrato, fiscal_contrato, codigo_contrato, validez_contrato, fecha_inicio, fecha_fin, tipo_contrato, estado_contrato, descripcion_cliente);

                    contrato.add(contratoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return contrato;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Contrato> leerContratoAc() {
        ArrayList<Contrato> contrato = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT  cont.id_contrato, cont.cliente_contrato, cont.fiscal_contrato, cont.codigo_contrato, cont.validez_contrato, cont.fecha_inicio_contrato, cont.fecha_final_contrato,\n"
                    + "  cont.tipo_contrato, cont.estado_contrato, clie.descripcion_cliente, fis.descripcion_fis, tc.descripcion \n"
                    + "  FROM contrato cont \n"
                    + "  INNER JOIN cliente clie \n"
                    + "  ON cont.id_cliente = clie.id_cliente \n"
                    + "  INNER JOIN fiscal fis \n"
                    + "  ON cont.id_fiscal = fis.id_fiscal \n"
                    + "  INNER JOIN tipo_contrato tc \n"
                    + "  ON cont.id_tipo_contrato = tc.id_tipo_contrato \n"
                    + "  WHERE estado_contrato = 'activo' \n"
                    + "  ORDER BY id_contrato");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return contrato;
            } else {
                do {
                    id_contrato = rs.getInt("id_contrato");
                    cliente_contrato = rs.getString("cliente_contrato");
                    fiscal_contrato = rs.getString("descripcion_fis");
                    codigo_contrato = rs.getString("codigo_contrato");
                    validez_contrato = rs.getString("validez_contrato");
                    fecha_inicio = rs.getString("fecha_inicio_contrato");
                    fecha_fin = rs.getString("fecha_final_contrato");
                    tipo_contrato = rs.getString("descripcion");
                    estado_contrato = rs.getString("estado_contrato");
                    descripcion_cliente = rs.getString("descripcion_cliente");

                    contratoHallado = new Contrato(id_contrato, cliente_contrato, fiscal_contrato, codigo_contrato, validez_contrato, fecha_inicio, fecha_fin, tipo_contrato, estado_contrato, descripcion_cliente);

                    contrato.add(contratoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return contrato;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            ConectaBD.cerrar();
            return null;
        }
    }

    public ArrayList<Contrato> leerContratoIna() {
        ArrayList<Contrato> contrato = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT  cont.id_contrato, cont.cliente_contrato, cont.fiscal_contrato, cont.codigo_contrato, cont.validez_contrato, cont.fecha_inicio_contrato, cont.fecha_final_contrato,\n"
                    + "  cont.tipo_contrato, cont.estado_contrato, clie.descripcion_cliente \n"
                    + "  FROM contrato cont \n"
                    + "  INNER JOIN cliente clie \n"
                    + "  ON cont.id_cliente = clie.id_cliente \n"
                    + "  WHERE estado_contrato = 'inactivo' \n"
                    + "  ORDER BY id_contrato");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return contrato;
            } else {
                do {
                    id_contrato = rs.getInt("id_contrato");
                    cliente_contrato = rs.getString("cliente_contrato");
                    fiscal_contrato = rs.getString("fiscal_contrato");
                    codigo_contrato = rs.getString("codigo_contrato");
                    validez_contrato = rs.getString("validez_contrato");
                    fecha_inicio = rs.getString("fecha_inicio_contrato");
                    fecha_fin = rs.getString("fecha_final_contrato");
                    tipo_contrato = rs.getString("tipo_contrato");
                    estado_contrato = rs.getString("estado_contrato");
                    descripcion_cliente = rs.getString("descripcion_cliente");
                    contratoHallado = new Contrato(id_contrato, cliente_contrato, fiscal_contrato, codigo_contrato, validez_contrato, fecha_inicio, fecha_fin, tipo_contrato, estado_contrato, descripcion_cliente);
                    contrato.add(contratoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return contrato;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Contrato> leerContratoTo() {
        ArrayList<Contrato> contrato = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_contrato, cliente_contrato, codigo_contrato, estado_contrato\n"
                    + "  FROM public.contrato \n"
                    + "ORDER BY id_contrato");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_contrato = rs.getInt("id_contrato");
                    cliente_contrato = rs.getString("cliente_contrato");
                    codigo_contrato = rs.getString("codigo_contrato");
                    estado_contrato = rs.getString("estado_contrato");
                    contratoHallado = new Contrato(id_contrato, id_cliente, cliente_contrato, fiscal_contrato, codigo_contrato, validez_contrato, fecha_inicio, fecha_fin, tipo_contrato, estado_contrato, nom_usu, descripcion_cliente);
                    contrato.add(contratoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return contrato;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            ConectaBD.cerrar();
            return null;
        }
    }

    public int cambiarActivo(Contrato c) {
        int r = 0;
        String sql = "UPDATE public.contrato\n"
                + "	SET  estado_contrato='activo'\n"
                + "	WHERE id_contrato=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId_contrato());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;

                c.setEstado_contrato(rs.getString("estado_contrato"));
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

    public int cambiarInactivo(Contrato c) {
        int r = 0;
        String sql = "UPDATE public.contrato\n"
                + "	SET  estado_contrato='inactivo'\n"
                + "	WHERE id_contrato=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId_contrato());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;

                c.setEstado_contrato(rs.getString("estado_contrato"));
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

    public int modificarContrato(Contrato cont) {
        int r = 0;
        String sql = "UPDATE public.contrato \n"
                + "SET  cliente_contrato=?, codigo_contrato=?, validez_contrato=?, \n"
                + "fecha_inicio_contrato=?, fecha_final_contrato=?,  estado_contrato=?, \n"
                + "nombre_usuario_modificacion=?, id_cliente=?, id_tipo_contrato=?, id_fiscal=? \n"
                + "WHERE id_contrato = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cont.getCliente_contrato());
//            ps.setString(2, cont.getFiscal_contrato());
            ps.setString(2, cont.getCodigo_contrato());
            ps.setString(3, cont.getValidez_contrato());
            ps.setString(4, cont.getFecha_inicio());
            ps.setString(5, cont.getFecha_fin());
//            ps.setString(7, cont.getTipo_contrato());
            ps.setString(6, cont.getEstado_contrato());
            ps.setString(7, cont.getNom_usu());
            ps.setInt(8, cont.getId_cliente());
            ps.setInt(9, cont.getId_tipo_contrato());
            ps.setInt(10, cont.getId_fiscal());
            
            ps.setInt(11, cont.getId_contrato());
             ps.executeUpdate();
//            while (rs.next()) {
//                r = r + 1;
//                //Variables.id = Integer.parseInt(rs.getString("id_usuario"));
//                cont.setCliente_contrato(rs.getString("cliente_contrato"));
//                cont.setFiscal_contrato(rs.getString("fiscal_contrato"));
//                cont.setCodigo_contrato(rs.getString("codigo_contrato"));
//                cont.setValidez_contrato(rs.getString("validez_contrato"));
//                cont.setFecha_inicio(rs.getString("fecha_inicio_contrato"));
//                cont.setFecha_fin(rs.getString("fecha_final_contrato"));
//                cont.setTipo_contrato(rs.getString("tipo_contrato"));
//                cont.setEstado_contrato(rs.getString("estado_contrato"));
//                cont.setNom_usu(rs.getString("nombre_usuario_modificacion"));
//                cont.setId_cliente(rs.getInt("id_cliente"));
//
//            }
           
                return 1;
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta Modificar Contrato");
            return 0;
        }
    }

    public Contrato editarContrato(String editartxt) {
        int r = 0;
        Contrato cont = new Contrato();
        String sql = "SELECT clie.id_cliente, clie.descripcion_cliente,cont.id_contrato,cont.cliente_contrato,cont.fiscal_contrato,cont.codigo_contrato, \n"
                + " cont.validez_contrato, cont.fecha_inicio_contrato, cont.fecha_final_contrato, \n"
                + " cont.tipo_contrato, cont.estado_contrato, tc.descripcion, fis.descripcion_fis \n"
                + " FROM contrato cont \n"
                + " INNER JOIN cliente clie \n"
                + " ON cont.id_cliente = clie.id_cliente \n"
                + " INNER JOIN fiscal fis \n"
                + " ON cont.id_fiscal = fis.id_fiscal \n"
                + " INNER JOIN tipo_contrato tc \n"
                + " ON cont.id_tipo_contrato = tc.id_tipo_contrato \n"
                + " WHERE cont.id_contrato = ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));

            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                cont.setDescripcion_cliente(rs.getString("descripcion_cliente"));
                cont.setId_cliente(rs.getInt("id_cliente"));
                cont.setId_contrato(rs.getInt("id_contrato"));
                cont.setCliente_contrato(rs.getString("cliente_contrato"));
                cont.setFiscal_contrato(rs.getString("descripcion_fis"));
                cont.setCodigo_contrato(rs.getString("codigo_contrato"));
                cont.setValidez_contrato(rs.getString("validez_contrato"));
                cont.setFecha_inicio(rs.getString("fecha_inicio_contrato"));
                cont.setFecha_fin(rs.getString("fecha_final_contrato"));
                cont.setTipo_contrato(rs.getString("descripcion"));
                cont.setEstado_contrato(rs.getString("estado_contrato"));
                cont.setId_tipo_contrato(rs.getInt("id_tipo_contrato"));
                cont.setId_fiscal(rs.getInt("id_fiscal"));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en consulta editar contrato");

        } finally {
            return cont;
        }
    }
////////////////////////////////////////////////////////////////////////////////

    public ArrayList<Contrato> leerContrato(String buscartxt) {
        ArrayList<Contrato> contrato = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_contrato, cliente_contrato, codigo_contrato \n"
                    + "FROM public.contrato \n"
                    + "WHERE id_cliente = " + buscartxt + ";");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_contrato = (rs.getInt("id_contrato"));
                    cliente_contrato = (rs.getString("cliente_contrato"));
                    codigo_contrato = (rs.getString("codigo_contrato"));
                    contratoHallado = new Contrato(id_contrato, cliente_contrato, codigo_contrato);
//                    Variables.id_cont = (rs.getInt("id_contrato"));
//                    Variables.cliente_cont = (rs.getString("cliente_contrato"));
//                    Variables.codigo_cont = (rs.getString("codigo_contrato"));
//                    contratoHallado = new Contrato(Variables.id_cont, Variables.cliente_cont, Variables.codigo_cont);
                    contrato.add(contratoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return contrato;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Contrato> leerContrato1(String buscartxt) {
        ArrayList<Contrato> contrato = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_contrato, cliente_contrato, codigo_contrato \n"
                    + "FROM public.contrato\n"
                    + "WHERE id_contrato = " + buscartxt + ";");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    Variables.id_cont = (rs.getInt("id_contrato"));
                    Variables.cliente_cont = (rs.getString("cliente_contrato"));
                    Variables.codigo_cont = (rs.getString("codigo_contrato"));
                    contratoHallado = new Contrato(Variables.id_cont, Variables.cliente_cont, Variables.codigo_cont);
                    contrato.add(contratoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return contrato;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Contrato> buscarContratoCodigo(String buscartxt) {
        int r = 0;
        Contrato cont = new Contrato();
        ArrayList<Contrato> contrato = new ArrayList<>();

        String sql = "SELECT  cont.id_contrato, cont.cliente_contrato, cont.fiscal_contrato, cont.codigo_contrato, cont.validez_contrato, cont.fecha_inicio_contrato, cont.fecha_final_contrato,\n"
                + "cont.tipo_contrato, cont.estado_contrato, cont.nombre_usuario_modificacion, cont.fecha_modificacion, clie.descripcion_cliente \n"
                + "FROM contrato cont \n"
                + "INNER JOIN cliente clie \n"
                + "ON cont.id_cliente = clie.id_cliente \n"
                + "WHERE cont.codigo_contrato  ilike  ? ";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_contrato = rs.getInt("id_contrato");
                    cliente_contrato = rs.getString("cliente_contrato");
                    fiscal_contrato = rs.getString("fiscal_contrato");
                    codigo_contrato = rs.getString("codigo_contrato");
                    validez_contrato = rs.getString("validez_contrato");
                    fecha_inicio = rs.getString("fecha_inicio_contrato");
                    fecha_fin = rs.getString("fecha_final_contrato");
                    tipo_contrato = rs.getString("tipo_contrato");
                    estado_contrato = rs.getString("estado_contrato");
                    descripcion_cliente = rs.getString("descripcion_cliente");

                    contratoHallado = new Contrato(id_contrato, cliente_contrato, fiscal_contrato, codigo_contrato, validez_contrato, fecha_inicio, fecha_fin, tipo_contrato, estado_contrato, descripcion_cliente);

                    contrato.add(contratoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return contrato;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
////////////////////////////////////////////////////////////////////////////////
}
