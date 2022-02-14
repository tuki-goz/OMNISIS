/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alvaro
 */
public class Usuario {

    int id_usuario;
    String numero_usuario;
    String nombre_usuario;
    String email_usuario;
    String clave_usuario;
    String estado_usuario;
    String nombre_usuario_modificacion;
    String fecha_modificacion;
    int id_perfil;
    int id_funcionario;

    public Usuario() {
    }

    public Usuario(int id_usuario, String numero_usuario, String nombre_usuario, String email_usuario, String clave_usuario, String estado_usuario, String nombre_usuario_modificacion, String fecha_modificacion, int id_perfil, int id_funcionario) {
        this.id_usuario = id_usuario;
        this.numero_usuario = numero_usuario;
        this.nombre_usuario = nombre_usuario;
        this.email_usuario = email_usuario;
        this.clave_usuario = clave_usuario;
        this.estado_usuario = estado_usuario;
        this.nombre_usuario_modificacion = nombre_usuario_modificacion;
        this.fecha_modificacion = fecha_modificacion;
        this.id_perfil = id_perfil;
        this.id_funcionario = id_funcionario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNumero_usuario() {
        return numero_usuario;
    }

    public void setNumero_usuario(String numero_usuario) {
        this.numero_usuario = numero_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getClave_usuario() {
        return clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(String estado_usuario) {
        this.estado_usuario = estado_usuario;
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

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    

}
