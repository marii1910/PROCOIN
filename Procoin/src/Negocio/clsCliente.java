package Negocio;

import Datos.Conectar;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

public class clsCliente {
    //Variables de conexión  a la Base de Datos
    Conectar con;
    CallableStatement cst;
    PreparedStatement ps;
    ResultSet rs;
    
    //Función que permite el registro de la dirección
    public int Insertar_Direccion(String str_Pais, String str_Ciudad, String str_Calle, String str_CodigoPostal)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call direccion_insertar(?,?,?,?)}");
            cst.setString(1, str_Pais);
            cst.setString(2, str_Ciudad);
            cst.setString(3, str_Calle);
            cst.setString(4, str_CodigoPostal);    
                
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
       return res;     
    }
    
    
    //Función que permite el registro de un cliente
    public int Insertar_Cliente(String str_Codigo, Integer int_Direccion, String str_Cedula, String str_Nombre, String str_Telefono, 
            String str_NombreContacto, String str_CargoContacto, String str_CorreoContacto, String str_SitioWeb, String str_TipoMoneda,
            String str_TipoPago, double dbl_LimiteCredito, Integer int_PlazoCredito, String str_Estado, String str_Usuario, 
            String date_FechaCrear, String date_FechaModificar)
    {
        int res = 0;
        try {
            con = new Conectar();      
            cst = con.getConnection().prepareCall("{call cliente_insertar(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cst.setString(1, str_Codigo);
            cst.setInt(2, int_Direccion);
            cst.setString(3, str_Cedula);
            cst.setString(4, str_Nombre);
            cst.setString(5, str_Telefono);    
            cst.setString(6, str_NombreContacto);
            cst.setString(7, str_CargoContacto);
            cst.setString(8, str_CorreoContacto);
            cst.setString(9, str_SitioWeb);
            cst.setString(10, str_TipoMoneda);
            cst.setString(11, str_TipoPago);
            cst.setDouble(12, dbl_LimiteCredito);
            cst.setInt(13, int_PlazoCredito);
            cst.setString(14, str_Estado);
            cst.setString(15, str_Usuario);
            cst.setString(16, date_FechaCrear);
            cst.setString(17, date_FechaModificar);

            res = cst.executeUpdate();
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
       return res;     
    }
    //Función para consultar cliente
    public ResultSet Buscar_Cliente(String str_Codigo)
    {
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call cliente_consultar(?)}");
            cst.setString(1, str_Codigo);
            rs = cst.executeQuery();
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return rs;
    }
    
    //Función para consultar dirección
    public ResultSet Buscar_Direccion(Integer int_Direccion)
    {
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call direccion_consultar(?)}");
            cst.setInt(1, int_Direccion);
            rs = cst.executeQuery();
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return rs;
    }
    
    //Función para obtener el ultimo registro de dirección
    public ResultSet Obtener_id_Direccion()
    {
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("SELECT * from address ORDER BY address_id DESC LIMIT 1");
            rs = ps.executeQuery();
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return rs;
    }  
    
    
    //Función para editar dirección
    public int Editar_Direccion(String str_Pais, String str_Ciudad, String str_Calle, String str_CodigoPostal, Integer int_Codigo)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call direccion_modificar(?,?,?,?,?)}");
                
            cst.setString(1, str_Pais);
            cst.setString(2, str_Ciudad);
            cst.setString(3, str_Calle);
            cst.setString(4, str_CodigoPostal);   
            cst.setInt(5, int_Codigo);
            
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }
    
    //Función para editar cliente
    public int Editar_Cliente(Integer int_Direccion, String str_Cedula, String str_Nombre, String str_Telefono, String str_NombreContacto, 
            String str_CargoContacto, String str_CorreoContacto, String str_SitioWeb, String str_TipoMoneda, String str_TipoPago, double dbl_LimiteCredito,
            Integer int_PlazoCredito, String str_Estado, String str_Usuario, String date_FechaCrear, String date_FechaModificar, String str_Codigo)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call cliente_modificar(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                
                cst.setInt(1, int_Direccion);
                cst.setString(2, str_Cedula);
                cst.setString(3, str_Nombre);
                cst.setString(4, str_Telefono);    
                cst.setString(5, str_NombreContacto);
                cst.setString(6, str_CargoContacto);
                cst.setString(7, str_CorreoContacto);
                cst.setString(8, str_SitioWeb);
                cst.setString(9, str_TipoMoneda);
                cst.setString(10, str_TipoPago);
                cst.setDouble(11, dbl_LimiteCredito);
                cst.setInt(12, int_PlazoCredito);
                cst.setString(13, str_Estado);
                cst.setString(14, str_Usuario);
                cst.setString(15, date_FechaCrear);
                cst.setString(16, date_FechaModificar);
                cst.setString(17, str_Codigo);
            
            
                res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }
    
    //Función para eliminar dirección
    public int Borrar_Direccion (Integer int_Direccion)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call direccion_eliminar(?)}");
            cst.setInt(1, int_Direccion);
            
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }
    
    //Función para eliminar cliente
    public int Borrar_Cliente (String str_Codigo)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call cliente_eliminar(?)}");
            cst.setString(1, str_Codigo);
            
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }
    
}
