/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author demon
 * 
 * esta es la clase para realizar la conexion con bd
 */

import java.sql.*;

public class Conexion {
    
    public static Connection getConnection(){
        String url, user, pass;
        url = "jdbc:mysql://localhost:3306/ventas";
        user = "root";
        pass = "n0m3l0";
        try{
            
            return DriverManager.getConnection(url, user, pass);
        
        }catch(SQLException e){
            
            System.out.println("Error al conectar con la bd");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        
        return null;
    
    }
    
}
