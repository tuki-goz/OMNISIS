/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import encriptar.BCrypt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Conexion;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "controladorActual", urlPatterns = {"/controladorActual"})
public class controladorActual extends HttpServlet {

    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps3 = null;
    int contfalloblo = 0;
    int r = 0;

    protected int processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("txtusuario");
        String password = request.getParameter("txtcontrasena");
        Variables.usuario1 = usuario;
        try {
            //CONECTAR CON LA BASE DE DATOS 
            Connection con;
            Conexion cn = new Conexion();
            con = cn.getConnection();
//            String sql = "SELECT * FROM usuario\n"
//                    + "WHERE nombre_usuario = ? and estado_usuario = 'activo';";
            String sql = "SELECT usu.id_usuario, usu.id_perfil, usu.nombre_usuario, usu.estado_usuario, usu.clave_usuario,\n"
                    + "CONCAT(fun.nombre_funcionario,' ',fun.apellido_funcionario) AS nom\n"
                    + "FROM usuario usu\n"
                    + "INNER JOIN funcionario fun\n"
                    + "ON usu.id_funcionario = fun.id_funcionario\n"
                    + "WHERE nombre_usuario = ? and estado_usuario = 'activo';";

            //EJECUCION
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Variables.usuarioConectado.setNumero_usuario(rs.getString("nom"));
                Variables.usuarioConectado.setId_usuario(rs.getInt("id_usuario"));
                Variables.usuarioConectado.setId_perfil(rs.getInt("id_perfil"));
                Variables.usuarioConectado.setNombre_usuario(rs.getString("nombre_usuario"));
                Variables.usuarioConectado.setEstado_usuario(rs.getString("estado_usuario"));
//                if (password.equalsIgnoreCase("123")) {
//                    request.getSession().setAttribute("usuar", usuario);
//                    request.getRequestDispatcher("cambioContra.jsp").forward(request, response);
//                } else {
                if (BCrypt.checkpw(password, rs.getString("clave_usuario"))) {
                    r = r + 1;
                    if (r == 1) {
                        String sql1 = "Update usuario \n"
                                + "set intentos_fallidos = 0 \n"
                                + "where nombre_usuario = ?";

                        ps3 = con.prepareStatement(sql1);
                        ps3.setString(1, usuario);
                        ps3.executeUpdate();
                        contfalloblo = 0;
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("usuario", usuario);
                        response.sendRedirect("Principal.jsp");
                        r = 0;
                    } else if (password.equalsIgnoreCase("123")) {
                        request.getSession().setAttribute("usuar", usuario);
                        request.getRequestDispatcher("cambioContra.jsp").forward(request, response);
                    }
                } else {
                    Variables.mensajeError = 1;
                    contfalloblo = contfalloblo + 1;
                    if (contfalloblo <= 3) {
                        String sql2 = "Update usuario \n"
                                + "set intentos_fallidos = intentos_fallidos + 1 \n"
                                + "where nombre_usuario = ?";
                        ps2 = con.prepareStatement(sql2);
                        ps2.setString(1, usuario);
                        ps2.executeUpdate();
                        response.sendRedirect("index.htm");
                    }
                    if (contfalloblo == 3) {
                        Variables.mensajeError = 2;
                        contfalloblo = 0;
                        String sql3 = "Update usuario \n"
                                + "set estado_usuario = 'inactivo' \n"
                                + "where nombre_usuario = ? and intentos_fallidos >= 3";
                        ps1 = con.prepareStatement(sql3);
                        ps1.setString(1, usuario);
                        ps1.executeUpdate();
                    }
                }
            } else {
                Variables.mensajeError = 3;
                response.sendRedirect("index.htm");
                System.out.println("Hello World in Console!");
            }
        } catch (IOException | SQLException e) {
            PrintWriter out = response.getWriter();
            out.println("Error : " + e);
        }
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
