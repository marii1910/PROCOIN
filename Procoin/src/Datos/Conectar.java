package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

public class Conectar {
    //Variables de conexión  a la BD
    private static Connection conn;
    public static final String URL = "jdbc:mysql://localhost:3306/procoin?useSSL=false";
    public static final String UserName = "root";
    public static final String Password = "12345";
    public static final String Driver = "com.mysql.jdbc.Driver";
    
    //Permite la conexion a la Base de Datos
    public Conectar()
    {
        conn = null;
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(URL,UserName,Password);
            if (conn != null)
            {
                System.out.println("Conexion establecida...");
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar " + e);
        }
    }
    
    //Establece la conexion a la Base de Datos
    public Connection getConnection()
    {
        return conn;
    }
    
    //Desconectar a la Base de Datos
    public void Desconectar()
    {
        conn = null;
        if (conn == null)
        {
            System.out.println("Conexion terminada...");
        }
    }
}
