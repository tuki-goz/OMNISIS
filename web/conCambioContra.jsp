<%-- 
    Document   : cambioContra
    Created on : 04/08/2021, 11:41:28 AM
    Author     : Alvaro
--%>

<%@page import="encriptar.BCrypt"%>
<%@page import="model.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<%
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        //CONECTAR CON LA BASE DE DATOS 
        String db = "jdbc:postgresql://localhost:5433/TESIS";
        String user = "postgres";
        String pw = "12345";
        conn = DriverManager.getConnection(db, user, pw);

        //TRAER LOS DATOS INTRODUCIDOS
        request.setCharacterEncoding("utf-8");
        String contra = request.getParameter("confnuevopass");
        String nombre = Variables.usuarioConectado.getNombre_usuario();

        //INSTRUCCION DE SQL
        String sql = "UPDATE usuario\n"
                + "    SET clave_usuario = ?, nombre_usuario_modificacion = ?, fecha_modificacion = (select current_date) \n"
                + "    WHERE nombre_usuario=?";

        //EJECUCION
        ps = conn.prepareStatement(sql);
        ps.setString(1, BCrypt.hashpw(contra, BCrypt.gensalt(10)));
        ps.setString(2, nombre);
        ps.setString(3, nombre);

        ps.executeUpdate();
    } finally {
        if (ps != null)
            try {
            ps.close();
        } catch (SQLException ex) {
        }
        try {
            conn.close();
        } catch (SQLException ex) {
        }
    }
    Variables.mensajeRegistrado = 1; 
    response.sendRedirect("index.htm");
%>
