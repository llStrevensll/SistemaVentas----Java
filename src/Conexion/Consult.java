/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Models.TClientes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author angue
 */
public class Consult extends Conexion{
    private QueryRunner QR = new QueryRunner();//libreria de apache-consultas
    
    public List<TClientes> clientes(){//Retorna lista de ObjetoClientes-> tabla clientes
        List<TClientes> cliente = new ArrayList();
        try {
        //castear a lista de objetos clientes. query->crea query de consulta(conexion, query, instancia para obtener informacion de la bd)
        cliente = (List<TClientes>) QR.query(getConn(), "SELECT * FROM tclientes", new BeanListHandler(TClientes.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
        return cliente;
    }
            
}
