/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alvaro
 */
public class ConectaBD {
    
     public static Connection con;
    private static String bd= "OMNISIS_BD";
    private static String usuario= "postgres";
    private static String passw= "12345";
    private static String url= "jdbc:postgresql://localhost:5433/"+bd;
    
    public static Connection abrir(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,usuario,passw);
        } catch (Exception e) {
            System.out.println("Error en la conexión :/");
            e.printStackTrace();
        }
        return con;
    }
    public static void cerrar(){
        try {
            if(con !=null)
                con.close();
        } catch (Exception e) {
            System.out.println("Error: No se logró cerrar conexión:\n"+e);
        }
    }
}
