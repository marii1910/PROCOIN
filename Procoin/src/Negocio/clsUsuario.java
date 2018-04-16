package Negocio;

import Datos.Conectar;
import java.sql.ResultSet;
import java.sql.CallableStatement;

/**
 * @author Anthony Sánchez
 * @author José Cedeño
 * @author Mariana Bermúdez
 * @author María Fernanda Niño
 */

public class clsUsuario {
    //Variables de conexión  a la Base de Datos
    Conectar con;
    ResultSet rs;
    CallableStatement cst;
    
    //Función que permite el registro de usuario
    public int Insertar(String str_Usuario, String str_Password, String str_TipoUsuario, String str_Estado, String str_FechaCrear, String str_FechaModificar)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call usuario_insertar(?,?,?,?,?,?)}");
            cst.setString(1, str_Usuario);
            cst.setString(2, str_Password);
            cst.setString(3, str_TipoUsuario);
            cst.setString(4, str_Estado);
            cst.setString(5, str_FechaCrear);
            cst.setString(6, str_FechaModificar);
            
            res = cst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
       return res;     
    }
    //Función para consultar usuario
    public ResultSet Buscar(String str_Usuario)
    {
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call usuario_consultar(?)}");
            cst.setString(1, str_Usuario);
            rs = cst.executeQuery();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return rs;
    }
    
    //Función para editar usuario
    public int Editar(String str_Password, String str_TipoUsuario, String str_Estado, String str_FechaCrear, String str_FechaModificar, String str_Usuario)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call usuario_modificar(?,?,?,?,?,?)}");
            cst.setString(1, str_Password);
            cst.setString(2, str_TipoUsuario);
            cst.setString(3, str_Estado);
            cst.setString(4, str_FechaCrear);
            cst.setString(5, str_FechaModificar);
            cst.setString(6, str_Usuario);
            
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }
    
    //Función para eliminar usuario
    public int Borrar(String str_Usuario)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call usuario_eliminar(?)}");
            cst.setString(1, str_Usuario);
            
            res = cst.executeUpdate();

            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return res;
    }
    
}
