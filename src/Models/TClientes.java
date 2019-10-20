/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author angue
 */
public class TClientes {
    private int IdClientes;
    private String Nid;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Email;
    private String Telefono;

    public TClientes() {
    }
    
    public int getIdClientes() {
        return IdClientes;
    }

    public String getNid() {
        return Nid;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getEmail() {
        return Email;
    }

    public String getTelefono() {
        return Telefono;
    }
    
    
}
