/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Anthony
 */
public class clsDetalle {
    
    //Declaración de variables
    String str_Codigo, str_Producto, str_UnidadMedida, str_Cantidad, str_ValorVenta, str_ImpuestoVenta, str_PrecioVenta;

    public clsDetalle(String str_Codigo, String str_Producto, String str_UnidadMedida, String str_Cantidad, String str_ValorVenta, String str_ImpuestoVenta, String str_PrecioVenta) {
        this.str_Codigo = str_Codigo;
        this.str_Producto = str_Producto;
        this.str_UnidadMedida = str_UnidadMedida;
        this.str_Cantidad = str_Cantidad;
        this.str_ValorVenta = str_ValorVenta;
        this.str_ImpuestoVenta = str_ImpuestoVenta;
        this.str_PrecioVenta = str_PrecioVenta;
    }
    
    public String getStr_Codigo() {
        return str_Codigo;
    }

    public void setStr_Codigo(String str_Codigo) {
        this.str_Codigo = str_Codigo;
    }

    public String getStr_Producto() {
        return str_Producto;
    }

    public void setStr_Producto(String str_Producto) {
        this.str_Producto = str_Producto;
    }

    public String getStr_UnidadMedida() {
        return str_UnidadMedida;
    }

    public void setStr_UnidadMedida(String str_UnidadMedida) {
        this.str_UnidadMedida = str_UnidadMedida;
    }

    public String getStr_Cantidad() {
        return str_Cantidad;
    }

    public void setStr_Cantidad(String str_Cantidad) {
        this.str_Cantidad = str_Cantidad;
    }

    public String getStr_ValorVenta() {
        return str_ValorVenta;
    }

    public void setStr_ValorVenta(String str_ValorVenta) {
        this.str_ValorVenta = str_ValorVenta;
    }

    public String getStr_ImpuestoVenta() {
        return str_ImpuestoVenta;
    }

    public void setStr_ImpuestoVenta(String str_ImpuestoVenta) {
        this.str_ImpuestoVenta = str_ImpuestoVenta;
    }

    public String getStr_PrecioVenta() {
        return str_PrecioVenta;
    }

    public void setStr_PrecioVenta(String str_PrecioVenta) {
        this.str_PrecioVenta = str_PrecioVenta;
    }
    
    
}
