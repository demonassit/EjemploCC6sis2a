/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author demon
 */

import java.sql.*;
import java.util.*;

public class Producto {
    
    private int producto_Codigo, producto_Stock;
    private String producto_Nombre;
    private Double producto_Precio;
    
    public Producto(){
    
    }
    
    //que metodos se van a programar del producto
    //son los que se encargan de la automatizacion del proceso
    
    //de obtener toda la lista de productos
    
    public Vector<Producto> listaProductos(){
        
        //una instancia del vecto
        Vector<Producto> lp = new Vector<Producto>();
        
        //inicializamos los objetos
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            con = Conexion.getConnection();
            String q = "select * from producto";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            //buscar dentro de la tabla producto
            while(rs.next()){
                //instancia del producto
                Producto prod = new Producto();
                prod.setProducto_Codigo(rs.getInt("producto_Codigo"));
                prod.setProducto_Nombre(rs.getString("producto_Nombre"));
                prod.setProducto_Precio(rs.getDouble("producto_Precio"));
                prod.setProducto_Stock(rs.getInt("producto_Stock"));
                lp.add(prod);
            }
        
        }catch (SQLException e){
            System.out.println("Error al conectar con la tabla producto");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            lp = null;
        
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(SQLException e){
                System.out.println(e.getStackTrace());
            }
        }
        return lp;
    }
    
    
    
    //buscar el producto por codigo
    
    public Producto buscarProducto(int codigoProducto){
        
        //instancia del producto
        Producto prod = new Producto();
        //inicializamos los objetos
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            con = Conexion.getConnection();
            String q = "select * from producto where producto_Codigo = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1, codigoProducto);
            rs = ps.executeQuery();
            //buscar dentro de la tabla producto
            while(rs.next()){
                
                prod.setProducto_Codigo(rs.getInt("producto_Codigo"));
                prod.setProducto_Nombre(rs.getString("producto_Nombre"));
                prod.setProducto_Precio(rs.getDouble("producto_Precio"));
                prod.setProducto_Stock(rs.getInt("producto_Stock"));
                
            }
        
        }catch (SQLException e){
            System.out.println("Error al conectar con la tabla producto");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            prod = null;
        
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(SQLException e){
                System.out.println(e.getStackTrace());
            }
        }
        return prod;
    }
    
    
    //actualizar el stock al momento de la compra
    //confirmar la venta a traves de un si o un no
    
    public boolean actualizarStock(Vector<Producto> vp){
        boolean actualizo = false;
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            
            con = Conexion.getConnection();
            //primero tengo que recorrer de la lista de productos cuales son los que 
            //tuvieron movimiento por parte de la venta
            for(Producto prod : vp){
                String q = "update producto set producto_Stock = ? where producto_Codigo = ?";
                ps = con.prepareStatement(q);
                //pasar los parametros
                ps.setInt(1, prod.getProducto_Stock());
                ps.setInt(2, prod.getProducto_Codigo());
                if(ps.executeUpdate()== 1){
                    actualizo = true;
                }else{
                    actualizo = false;
                    break;
                }
            }
        
        }catch(SQLException e){
            System.out.println("Error no se actualizo el stock");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }finally{
            try{
                ps.close();
                con.close();
                actualizo = false;
            
            }catch(SQLException e){
                System.out.println(e.getStackTrace());
            
            }
        }
        return actualizo;
    }

    public int getProducto_Codigo() {
        return producto_Codigo;
    }

    public void setProducto_Codigo(int producto_Codigo) {
        this.producto_Codigo = producto_Codigo;
    }

    public int getProducto_Stock() {
        return producto_Stock;
    }

    public void setProducto_Stock(int producto_Stock) {
        this.producto_Stock = producto_Stock;
    }

    public String getProducto_Nombre() {
        return producto_Nombre;
    }

    public void setProducto_Nombre(String producto_Nombre) {
        this.producto_Nombre = producto_Nombre;
    }

    public Double getProducto_Precio() {
        return producto_Precio;
    }

    public void setProducto_Precio(Double producto_Precio) {
        this.producto_Precio = producto_Precio;
    }
    
    
    
}
