package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alvaro
 */
public class UsuarioDAO implements Validar {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public int validar(Usuario u) {
        int r = 0;
        String sql = "Select * from usuario \n"  //seleccionamos todos los datos de la tabla, donde sean iguales a los que les pasamos y cumplan conla condicion
                + "where nombre_usuario=? and clave_usuario=? and estado_usuario = 'activo'";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getNombre_usuario());
            ps.setString(2, u.getClave_usuario());
            //ps.setInt(3, u.getId_perfil());

            rs = ps.executeQuery();

            while (rs.next()) {
                r = r + 1;


                Variables.usuarioConectado.setId_usuario(rs.getInt("id_usuario"));  ///todos los datos de usuario se guardan en esta seccion
                Variables.usuarioConectado.setId_perfil(rs.getInt("id_perfil"));
                Variables.usuarioConectado.setNombre_usuario(rs.getString("nombre_usuario"));
                Variables.usuarioConectado.setEstado_usuario(rs.getString("estado_usuario"));
//                Variables.usuarioConectado.set(rs.getInt("intentos_fallidos"));

            }
            if (r == 1) {
                String sql2 = "Update usuario \n"
                        + "set intentos_fallidos = 0 \n"
                        + "where nombre_usuario = ?";

                ps = con.prepareStatement(sql2);
                ps.setString(1, u.getNombre_usuario());
                ps.executeUpdate();

                return 1;
                
            } else {  //esta seccion inserta los intentos fallidos, ya seaan de usuario ocontraseña a la tabla usuarios, suma hasta 3 
                String sql2 = "Update usuario \n"
                        + "set intentos_fallidos = intentos_fallidos + 1 \n"
                        + "where nombre_usuario = ?";

                ps = con.prepareStatement(sql2);
                ps.setString(1, u.getNombre_usuario());
                ps.executeUpdate();

                String sql3 = "Update usuario \n" //esta seccion continua la anterior, cuando se tienen 3 intentos fallidos se hace update del estado y se inactiva el usuario
                        + "set estado_usuario = 'inactivo' \n"
                        + "where nombre_usuario = ? and intentos_fallidos >= 3";

                ps = con.prepareStatement(sql3);
                ps.setString(1, u.getNombre_usuario());
                ps.executeUpdate();
                return 0;

            }

        } catch (Exception e) {
            return 0;
        }

    }

}
