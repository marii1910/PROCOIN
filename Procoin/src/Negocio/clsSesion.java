package Negocio;

import Datos.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

public class clsSesion {
    //Variables de conexión  a la Base de Datos
    Conectar con;
    PreparedStatement ps;
    ResultSet rs;
    CallableStatement cst;
    
    //Función para consultar un registro
    public ResultSet Login(String str_Usuario)
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
    
}
