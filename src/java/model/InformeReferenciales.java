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
public class InformeReferenciales {
    
    int id_fun, id_barrio;
    String nom_fun, ape_fun, ci_fun, cargo_fun, email_fun, tel_fun, dir_fun, estado_fun, nom_usu_mod, desc_barrio;

    public InformeReferenciales() {
    }

    public InformeReferenciales(int id_fun, int id_barrio, String nom_fun, String ape_fun, String ci_fun, String cargo_fun, String email_fun, String tel_fun, String dir_fun, String estado_fun, String nom_usu_mod) {
        this.id_fun = id_fun;
        this.id_barrio = id_barrio;
        this.nom_fun = nom_fun;
        this.ape_fun = ape_fun;
        this.ci_fun = ci_fun;
        this.cargo_fun = cargo_fun;
        this.email_fun = email_fun;
        this.tel_fun = tel_fun;
        this.dir_fun = dir_fun;
        this.estado_fun = estado_fun;
        this.nom_usu_mod = nom_usu_mod;
    }

    public InformeReferenciales(int id_fun, String nom_fun, String ape_fun, String ci_fun, String cargo_fun, String email_fun, String tel_fun, String dir_fun, String estado_fun, String desc_barrio) {
        this.id_fun = id_fun;
        this.nom_fun = nom_fun;
        this.ape_fun = ape_fun;
        this.ci_fun = ci_fun;
        this.cargo_fun = cargo_fun;
        this.email_fun = email_fun;
        this.tel_fun = tel_fun;
        this.dir_fun = dir_fun;
        this.estado_fun = estado_fun;
        this.desc_barrio = desc_barrio;
    }

    public int getId_fun() {
        return id_fun;
    }

    public void setId_fun(int id_fun) {
        this.id_fun = id_fun;
    }

    public int getId_barrio() {
        return id_barrio;
    }

    public void setId_barrio(int id_barrio) {
        this.id_barrio = id_barrio;
    }

    public String getNom_fun() {
        return nom_fun;
    }

    public void setNom_fun(String nom_fun) {
        this.nom_fun = nom_fun;
    }

    public String getApe_fun() {
        return ape_fun;
    }

    public void setApe_fun(String ape_fun) {
        this.ape_fun = ape_fun;
    }

    public String getCi_fun() {
        return ci_fun;
    }

    public void setCi_fun(String ci_fun) {
        this.ci_fun = ci_fun;
    }

    public String getCargo_fun() {
        return cargo_fun;
    }

    public void setCargo_fun(String cargo_fun) {
        this.cargo_fun = cargo_fun;
    }

    public String getEmail_fun() {
        return email_fun;
    }

    public void setEmail_fun(String email_fun) {
        this.email_fun = email_fun;
    }

    public String getTel_fun() {
        return tel_fun;
    }

    public void setTel_fun(String tel_fun) {
        this.tel_fun = tel_fun;
    }

    public String getDir_fun() {
        return dir_fun;
    }

    public void setDir_fun(String dir_fun) {
        this.dir_fun = dir_fun;
    }

    public String getEstado_fun() {
        return estado_fun;
    }

    public void setEstado_fun(String estado_fun) {
        this.estado_fun = estado_fun;
    }

    public String getNom_usu_mod() {
        return nom_usu_mod;
    }

    public void setNom_usu_mod(String nom_usu_mod) {
        this.nom_usu_mod = nom_usu_mod;
    }

    public String getDesc_barrio() {
        return desc_barrio;
    }

    public void setDesc_barrio(String desc_barrio) {
        this.desc_barrio = desc_barrio;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private InformeReferenciales funcionarioHallado;
    
     public ArrayList<InformeReferenciales> leerInformeReferencialesAc() {
        ArrayList<InformeReferenciales> funcionario = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT fun.id_funcionario, fun.nombre_funcionario, fun.apellido_funcionario, fun.cedula_funcionario, fun.cargo_funcionario, fun.email_funcionario, fun.telefono_funcionario, \n"
                    + " fun.direccion_funcionario, fun.estado_funcionario, bar.descripcion_barrio \n"
                    + "	FROM public.funcionario fun\n"
                    + " INNER JOIN barrio bar ON fun.id_barrio = bar.id_barrio \n"
                    + " WHERE fun.estado_funcionario = 'activo' \n"
                    + " ORDER BY id_funcionario");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return funcionario;
            } else {
                do {
                    id_fun = rs.getInt("id_funcionario");
                    nom_fun = rs.getString("nombre_funcionario");
                    ape_fun = rs.getString("apellido_funcionario");
                    ci_fun = rs.getString("cedula_funcionario");
                    cargo_fun = rs.getString("cargo_funcionario");
                    email_fun = rs.getString("email_funcionario");
                    tel_fun = rs.getString("telefono_funcionario");
                    dir_fun = rs.getString("direccion_funcionario");
                    estado_fun = rs.getString("estado_funcionario");
                    desc_barrio = rs.getString("descripcion_barrio");
                    funcionarioHallado = new InformeReferenciales(id_fun, nom_fun, ape_fun, ci_fun, cargo_fun, email_fun, tel_fun, dir_fun, estado_fun, desc_barrio);
                    funcionario.add(funcionarioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return funcionario;
            }

        } catch (Exception e) {
            System.out.println("Error al leer activos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InformeReferenciales> leerInformeReferencialesIna() {
        ArrayList<InformeReferenciales> funcionario = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT fun.id_funcionario, fun.nombre_funcionario, fun.apellido_funcionario, fun.cedula_funcionario, fun.cargo_funcionario, fun.email_funcionario, fun.telefono_funcionario, \n"
                    + " fun.direccion_funcionario, fun.estado_funcionario, bar.descripcion_barrio \n"
                    + "	FROM public.funcionario fun\n"
                    + " INNER JOIN barrio bar ON fun.id_barrio = bar.id_barrio \n"
                    + " WHERE fun.estado_funcionario = 'inactivo' \n"
                    + " ORDER BY id_funcionario");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return funcionario;
            } else {
                do {
                    id_fun = rs.getInt("id_funcionario");
                    nom_fun = rs.getString("nombre_funcionario");
                    ape_fun = rs.getString("apellido_funcionario");
                    ci_fun = rs.getString("cedula_funcionario");
                    cargo_fun = rs.getString("cargo_funcionario");
                    email_fun = rs.getString("email_funcionario");
                    tel_fun = rs.getString("telefono_funcionario");
                    dir_fun = rs.getString("direccion_funcionario");
                    estado_fun = rs.getString("estado_funcionario");
                    desc_barrio = rs.getString("descripcion_barrio");
                    funcionarioHallado = new InformeReferenciales(id_fun, nom_fun, ape_fun, ci_fun, cargo_fun, email_fun, tel_fun, dir_fun, estado_fun, desc_barrio);
                    funcionario.add(funcionarioHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return funcionario;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al leer inactivos");
            e.printStackTrace();
            return null;
        }
    }
}
