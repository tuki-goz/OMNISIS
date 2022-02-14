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
public class Conexion {
    Connection con;
    public Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5433/OMNISIS_BD","postgres","12345");
            System.out.println("Driver conectado!!!");
        } catch (Exception e) {
            System.out.println("Error en la conexión :/");
        }
        return con;
    }
    
    
}
