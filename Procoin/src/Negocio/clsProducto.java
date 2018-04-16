package Negocio;

import Datos.Conectar;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

public class clsProducto {
    //Variables de conexión  a la Base de Datos
    Conectar con;
    CallableStatement cst;
    PreparedStatement ps;
    ResultSet rs;
    
    //Función que permite el registro de marca
    public int Insertar_Marca(String str_Nombre, String str_Descripcion, String str_Usuario, String date_FechaCrear, String date_FechaModificar)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call marca_insertar(?,?,?,?,?)}");
            cst.setString(1, str_Nombre);
            cst.setString(2, str_Descripcion);
            cst.setString(3, str_Usuario);
            cst.setString(4, date_FechaCrear);
            cst.setString(5, date_FechaModificar);
                
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
       return res;     
    }
    
    //Función para consultar marca
    public ResultSet Buscar_Marca(Integer int_Codigo)
    {
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call marca_consultar(?)}");
            cst.setInt(1, int_Codigo);
            rs = cst.executeQuery();
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return rs;
    }
    
    //Función para consultar marca
    public int Buscar_Nombre_Marca(String str_Marca)
    {
        int int_Marca = 0;
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("SELECT * FROM product_brand WHERE prod_brand_name = (?)");
            ps.setString(1, str_Marca);
            rs = ps.executeQuery();
            while(rs.next())
            {
                int_Marca = rs.getInt("prod_brand_id");
            }
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return int_Marca;
    }
    
    //Función para editar marca
    public int Editar_Marca(String str_Nombre, String str_Descripcion, String str_Usuario, String date_FechaCrear, String date_FechaModificar, Integer int_Codigo)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call marca_modificar(?,?,?,?,?,?)}");
                
            cst.setString(1, str_Nombre);
            cst.setString(2, str_Descripcion);
            cst.setString(3, str_Usuario);
            cst.setString(4, date_FechaCrear);   
            cst.setString(5, date_FechaModificar);
            cst.setInt(6, int_Codigo);
            
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }
    
    //Función para eliminar marca
    public int Borrar_Marca(Integer int_Codigo)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call marca_eliminar(?)}");
            cst.setInt(1, int_Codigo);
            
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }
    
    //Función que permite el ingreso de familia
    public int Insertar_Familia(String str_Nombre, String str_Descripcion, String str_Usuario, String date_FechaCrear, String date_FechaModificar)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call familia_insertar(?,?,?,?,?)}");
            cst.setString(1, str_Nombre);
            cst.setString(2, str_Descripcion);
            cst.setString(3, str_Usuario);
            cst.setString(4, date_FechaCrear);
            cst.setString(5, date_FechaModificar);
                
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
       return res;     
    }
    
    //Función para consultar familia
    public ResultSet Buscar_Familia(Integer int_Codigo)
    {
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call familia_consultar(?)}");
            cst.setInt(1, int_Codigo);
            rs = cst.executeQuery();
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return rs;
    }
    
    //Función para consultar familia
    public int Buscar_Nombre_Familia(String str_Familia)
    {
        int int_Familia = 0;
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("SELECT * FROM product_family WHERE prod_fam_name = (?)");
            ps.setString(1, str_Familia);
            rs = ps.executeQuery();
            while(rs.next())
            {
                int_Familia = rs.getInt("prod_fam_id");
            }
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return int_Familia;
    }
    
    //Función para editar familia
    public int Editar_Familia(String str_Nombre, String str_Descripcion, String str_Usuario, String date_FechaCrear, String date_FechaModificar, Integer int_Codigo)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call familia_modificar(?,?,?,?,?,?)}");
                
            cst.setString(1, str_Nombre);
            cst.setString(2, str_Descripcion);
            cst.setString(3, str_Usuario);
            cst.setString(4, date_FechaCrear);   
            cst.setString(5, date_FechaModificar);
            cst.setInt(6, int_Codigo);
            
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }
    
    //Función para eliminar familia
    public int Borrar_Familia(Integer int_Codigo)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call familia_eliminar(?)}");
            cst.setInt(1, int_Codigo);
            
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }
    
    //Función para llenar ComboBox de familia 
    public ArrayList<String> Llenar_familia()
    {
        ArrayList<String> arr_Lista = new ArrayList<String>();
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("SELECT * FROM product_family ORDER BY prod_fam_name");
            rs = ps.executeQuery();
            while(rs.next())
            {
                arr_Lista.add(rs.getString("prod_fam_name"));
            }
            
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        
        return arr_Lista;
    }
    
    //Función para llenar ComnoBox de marca
    public ArrayList<String> Llenar_marca()
    {
        ArrayList<String> arr_Lista = new ArrayList<String>();
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("SELECT * FROM product_brand ORDER BY prod_brand_name");
            rs = ps.executeQuery();
            
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        try {
            while(rs.next())
            {
                arr_Lista.add(rs.getString("prod_brand_name"));
            }
        } catch (Exception e) {
        }
        
        return arr_Lista;
    }
    
    //Función que permite el registro de un producto
    public int Insertar_Producto(String str_Codigo,String str_Nombre, String str_Descripcion, Integer int_Familia, Integer int_Marca, 
            String str_UnidadMedida, String str_Usuario, String date_FechaCrear, String date_FechaModificar)
    {
        int res = 0;
        try {
            con = new Conectar();      
            cst = con.getConnection().prepareCall("{call producto_insertar(?,?,?,?,?,?,?,?,?)}");
            cst.setString(1, str_Codigo);
            cst.setString(2, str_Nombre);
            cst.setString(3, str_Descripcion);
            cst.setInt(4, int_Familia);
            cst.setInt(5, int_Marca);
            cst.setString(6, str_UnidadMedida);    
            cst.setString(7, str_Usuario);
            cst.setString(8, date_FechaCrear);
            cst.setString(9, date_FechaModificar);

            res = cst.executeUpdate();
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
       return res;     
    }
    
    //Función para consultar producto
    public ResultSet Buscar_Producto(String str_Codigo)
    {
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call producto_consultar(?)}");
            cst.setString(1, str_Codigo);
            rs = cst.executeQuery();
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return rs;
    }
    
    //Función para editar producto
    public int Editar_Producto(String str_Nombre, String str_Descripcion, Integer int_Familia, Integer int_Marca, 
            String str_UnidadMedida, String str_Usuario, String date_FechaCrear, String date_FechaModificar, String str_Codigo)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call producto_modificar(?,?,?,?,?,?,?,?,?)}");
                
                cst.setString(1, str_Nombre);
                cst.setString(2, str_Descripcion);
                cst.setInt(3, int_Familia);
                cst.setInt(4, int_Marca);    
                cst.setString(5, str_UnidadMedida);
                cst.setString(6, str_Usuario);
                cst.setString(7, date_FechaCrear);
                cst.setString(8, date_FechaModificar);
                cst.setString(9, str_Codigo);
            
                res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }
    
    //Función para eliminar producto
    public int Borrar_Producto (String str_Codigo)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call producto_eliminar(?)}");
            cst.setString(1, str_Codigo);
            
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }

}
    
