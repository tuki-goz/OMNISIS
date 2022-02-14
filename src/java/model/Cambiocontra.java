/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alvaro
 */
public class Cambiocontra implements Validar {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public int validar(Usuario u) {
        int r = 0;

        String sql = "UPDATE public.usuario\n"
                + "	SET  clave_usuario=?\n"
                + "	WHERE nombre_usuario=?";

        String sql2 = "UPDATE usuario\n"
                + "    SET clave_usuario = crypt(?,gen_salt('bf'))\n"
                + "    WHERE nombre_usuario=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getClave_usuario());
            ps.setString(2, u.getNombre_usuario());
            //  ps.setString(3, u.getEstado());

            ps.executeUpdate();

                return 1;
            

        } catch (Exception e) {
            return 0;
        }

    }

}
