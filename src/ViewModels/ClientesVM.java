/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

//import Conexion.Conexion;
import Conexion.Consult;
import Library.Objectos;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author angue
 */
public class ClientesVM extends Consult{//Herada de Consult-> la cual a su vez hereda de conexion

    private String _accion = "insert";
    private final ArrayList<JLabel> _label;
    private final ArrayList<JTextField> _textField;

    public ClientesVM(Object[] objects, ArrayList<JLabel> label, ArrayList<JTextField> textField) {
        //Inicializar
        _label = label;
        _textField = textField;
        //new Conexion();//Ejecutar el constructor de conexion
    }

    public void RegistrarCliente() {
        if (_textField.get(0).getText().equals("")) {//toma la posicion cero-> si nid esta vacio
            _label.get(0).setText("Ingrese el nid");
            _label.get(0).setForeground(Color.RED);
            _textField.get(0).requestFocus();
        } else {
            if (_textField.get(1).getText().equals("")) {
                _label.get(1).setText("Ingrese el nombre");
                _label.get(1).setForeground(Color.RED);
                _textField.get(1).requestFocus();
            } else {
                if (_textField.get(2).getText().equals("")) {
                    _label.get(2).setText("Ingrese el apellido");
                    _label.get(2).setForeground(Color.RED);
                    _textField.get(2).requestFocus();
                } else {
                    if (_textField.get(3).getText().equals("")) {
                        _label.get(3).setText("Ingrese el email");
                        _label.get(3).setForeground(Color.RED);
                        _textField.get(3).requestFocus();
                    } else {
                        if (!Objectos.eventos.isEmail(_textField.get(3).getText())) {
                            _label.get(3).setText("Ingrese un email valido");
                            _label.get(3).setForeground(Color.RED);
                            _textField.get(3).requestFocus();
                        } else {
                            if (_textField.get(4).getText().equals("")) {
                                _label.get(4).setText("Ingrese el telefono");
                                _label.get(4).setForeground(Color.RED);
                                _textField.get(4).requestFocus();
                            }else{
                                if (_textField.get(5).getText().equals("")) {
                                    _label.get(5).setText("Ingrese la direccion");
                                    _label.get(5).setForeground(Color.RED);
                                    _textField.get(5).requestFocus();
                                }else{
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
