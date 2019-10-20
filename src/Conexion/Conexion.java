/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angue
 */
public class Conexion {
    private String db = "punto_de_ventas";
    private String user = "root";
    private String password = "admin";
    private String urlMysql = "jdbc:mysql://localhost/" + db + "?SslMode=none";
    private String urlSql = "jdbc:sqlserver://localhost:1433;databaseName=" + db 
            + ";integratedSecurity=true;";//conexion para sqlserver
    private Connection conn = null;
    
    public Conexion(){
         try {
             //obtenemos el driver de para mysql
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(this.urlMysql, this.user, this.password);
            
            //Conexion a SQL Server
            //obtenemos el driver de para SQL Server
            /*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn =DriverManager.getConnection(urlSql);*/
             if (conn != null) {
                System.out.println("Conexión a la base de datos " + this.db + "...... Listo ");
            }
         } catch (ClassNotFoundException | SQLException ex) {
             System.out.println("Error : " + ex);
         }
    }

    public Connection getConn() {//retornar la conexion
        return conn;
    }
    
}
