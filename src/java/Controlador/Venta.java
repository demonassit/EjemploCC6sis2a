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

import java.util.*;
import java.sql.*;

public class Venta {
    
    private int venta_Codigo, usuario_Codigo;
    private String venta_Fecha;
    private double venta_TotalPagar;
    
    public Venta(){
    
    }
    
    //debe haber un metodo para que automaticamente obtenga la ultima venta generada
    private int ultimoCodigoInserto(Connection con){
        
        int codigo = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            String q = "select MAX(venta_Codigo) as Codigo from Venta";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            //buscar en la tabla
            while(rs.next()){
                codigo = rs.getInt("Codigo");
                break;
            }
            
        
        }catch(SQLException e){
            System.out.println("Error al buscar en la venta");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            codigo = 0;
        
        }finally{
            try{
                
                rs.close();
                ps.close();
            
            }catch(SQLException e){
                System.out.println(e.getStackTrace());
            }
        }
        return codigo;
    }
    
    
    //debe haber un metodo para registrar la venta  (usuario)
    public boolean registrarVenta(Venta v, Vector<DetalleVenta> ldv){
        
        boolean registro = false;
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            
            con = Conexion.getConnection();
            String q = "insert into Venta(venta_Fecha, usuario_Codigo, venta_TotalPagar) values (?, ?, ?)";
            ps = con.prepareStatement(q);
            ps.setString(1, v.getVenta_Fecha());
            ps.setInt(2, v.getUsuario_Codigo());
            ps.setDouble(3, v.getVenta_TotalPagar());
            //se ejecuta el registro de la venta
            if(ps.executeUpdate() == 1){
                int codigo = this.ultimoCodigoInserto(con);
                registro = this.registrarDetalleVenta(codigo, ldv, con);
            }else{
                registro = false;
            }
        
        }catch(SQLException e){
            System.out.println("Error al registrar la venta");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            registro = false;
        
        }finally{
            try{
                ps.close();
                con.close();
            
            }catch(SQLException e){
                System.out.println(e.getStackTrace());
            
            }
        }
        return registro;
    }
    
    //debe haver un metodo que automaticamente registre a partir de la venta en el detalle de la venta
    //para saber que productos se compraron al momento de pagar (programa)
    private boolean registrarDetalleVenta(int codigo, Vector<DetalleVenta> ldv, Connection con){
        
        boolean registro = false;
        PreparedStatement ps = null;
        
        try{
            for(DetalleVenta dv : ldv){
                String q = "insert into detalleventa values (?, ?, ?, ?, ?)";
                ps = con.prepareStatement(q);
                ps.setInt(1, codigo);
                ps.setInt(2, dv.getDetVenta_Item());
                ps.setInt(3, dv.getProducto_Codigo());
                ps.setInt(4, dv.getDetVenta_Cantidad());
                ps.setDouble(5, dv.getDetVenta_Subtotal());
                if(ps.executeUpdate() == 1){
                    registro = true;
                }else{
                    registro = false;
                    break;
                }
            }
        
        }catch(SQLException e){
            System.out.println("Error al registrar el detalle de la venta");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            registro = false;
        
        }finally{
            try{
                ps.close();
                
            
            }catch(SQLException e){
                System.out.println(e.getStackTrace());
            
            }
        }
        return registro;
    }
    
    //creo los getter y setter

    public int getVenta_Codigo() {
        return venta_Codigo;
    }

    public void setVenta_Codigo(int venta_Codigo) {
        this.venta_Codigo = venta_Codigo;
    }

    public int getUsuario_Codigo() {
        return usuario_Codigo;
    }

    public void setUsuario_Codigo(int usuario_Codigo) {
        this.usuario_Codigo = usuario_Codigo;
    }

    public String getVenta_Fecha() {
        return venta_Fecha;
    }

    public void setVenta_Fecha(String venta_Fecha) {
        this.venta_Fecha = venta_Fecha;
    }

    public double getVenta_TotalPagar() {
        return venta_TotalPagar;
    }

    public void setVenta_TotalPagar(double venta_TotalPagar) {
        this.venta_TotalPagar = venta_TotalPagar;
    }
    
    
}
