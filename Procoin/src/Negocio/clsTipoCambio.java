package Negocio;

import Datos.Conectar;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

public class clsTipoCambio {
    //Variables de conexión  a la Base de Datos
    Conectar con;
    CallableStatement cst;
    PreparedStatement ps;
    ResultSet rs;
    
    //Declarar variables
    String str_TipoCambio = null, str_IndicadorEcnonomico = null, str_FechaInicio = null, str_FechaFinal = null, str_Nombre = null, str_SubNivel;
    
    public String TipoCambio(String str_Fecha)
    {
        str_IndicadorEcnonomico = "317";
        str_FechaInicio = str_Fecha;
        str_FechaFinal = str_Fecha;
        str_Nombre = "PROCOIN";
        str_SubNivel = "N";
        String str_Cambio = String.valueOf(obtenerIndicadoresEconomicosXML(str_IndicadorEcnonomico, str_FechaInicio, str_FechaFinal, str_Nombre, str_SubNivel));
        str_TipoCambio = str_Cambio.substring(196, 202).toString();
        return str_TipoCambio;
    }
    
    
    //Función para obtener Tipo de Cambio

    private static String obtenerIndicadoresEconomicosXML(java.lang.String tcIndicador, java.lang.String tcFechaInicio, java.lang.String tcFechaFinal, java.lang.String tcNombre, java.lang.String tnSubNiveles) {
        TipoCambio.WsIndicadoresEconomicos service = new TipoCambio.WsIndicadoresEconomicos();
        TipoCambio.WsIndicadoresEconomicosSoap port = service.getWsIndicadoresEconomicosSoap();
        return port.obtenerIndicadoresEconomicosXML(tcIndicador, tcFechaInicio, tcFechaFinal, tcNombre, tnSubNiveles);
    }
    
    public int Insertar_TipoCambio(Double dbl_TipoCambio, String date_Fecha)
    {
        int res = 0;
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call tipocambio_insertar(?,?)}");
            cst.setDouble(1, dbl_TipoCambio);
            cst.setString(2, date_Fecha);
                
            res = cst.executeUpdate();
            
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
       return res;     
    }
    
    //Función para consultar marca
    public ResultSet Buscar_TipoCambio(Integer int_Codigo)
    {
        try {
            con = new Conectar();
            cst = con.getConnection().prepareCall("{call tipocambio_consultar(?)}");
            cst.setInt(1, int_Codigo);
            rs = cst.executeQuery();
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }        
        return rs;
    }
    
    //Función para obtener el id del ultimo registro de tipo de cambio
    public ResultSet Obtener_id_TipoCambio()
    {
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("SELECT * from exchange_rate ORDER BY exchange_rate_id DESC LIMIT 1");
            rs = ps.executeQuery();
            con.Desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return rs;
    }          
    
}
