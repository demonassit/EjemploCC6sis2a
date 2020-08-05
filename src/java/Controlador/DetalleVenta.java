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
public class DetalleVenta {
    
    //venta_codigo es FK 
    //producto_Codigo FK
    
    private int venta_Codigo, detVenta_Item, producto_Codigo, detVenta_Cantidad;
    private double detVenta_Subtotal;
    
    public DetalleVenta(){
    
    }

    public int getVenta_Codigo() {
        return venta_Codigo;
    }

    public void setVenta_Codigo(int venta_Codigo) {
        this.venta_Codigo = venta_Codigo;
    }

    public int getDetVenta_Item() {
        return detVenta_Item;
    }

    public void setDetVenta_Item(int detVenta_Item) {
        this.detVenta_Item = detVenta_Item;
    }

    public int getProducto_Codigo() {
        return producto_Codigo;
    }

    public void setProducto_Codigo(int producto_Codigo) {
        this.producto_Codigo = producto_Codigo;
    }

    public int getDetVenta_Cantidad() {
        return detVenta_Cantidad;
    }

    public void setDetVenta_Cantidad(int detVenta_Cantidad) {
        this.detVenta_Cantidad = detVenta_Cantidad;
    }

    public double getDetVenta_Subtotal() {
        return detVenta_Subtotal;
    }

    public void setDetVenta_Subtotal(double detVenta_Subtotal) {
        this.detVenta_Subtotal = detVenta_Subtotal;
    }
    
    
    
}
