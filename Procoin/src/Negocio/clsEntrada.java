package Negocio;

import Datos.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

public class clsEntrada {
    //Variables de conexión  a la Base de Datos
    Conectar con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    //Función traer el consecutivo
    public int Traer_Llave()
    {
        Integer int_Llave = null;
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("SELECT MAX(inventory_input_id)+1 FROM inventory_input");
            rs = ps.executeQuery();
            if(rs.next())
            {
                int_Llave = rs.getInt("inventory_input_id");
            }
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
            int_Llave = 1;
        }        
        return int_Llave;
    }
    
    //Función para traer el proveedor
    public ResultSet Buscar_Proveedor(String str_Codigo)
    {
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("SELECT * FROM supplier WHERE supplier_id = (?)");
            ps.setString(1, str_Codigo);
            rs = ps.executeQuery();
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return rs;
    }
}
