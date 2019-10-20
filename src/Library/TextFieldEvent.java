/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author angue
 */
public class TextFieldEvent {
    //Validar campo de texto, que solo sean caracteres alfabeticos
    public void textKeyPress(KeyEvent evt){
         //DecltextKeyPressaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();//obtener caracter de la tecla que se presiona
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') &&
                (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)){//permitir espacios
            evt.consume();
        }
    }
    //Validar campos numericos
    public void numberKeyPres(KeyEvent evt){
         //Declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {//No permitir espacios
            evt.consume();
        }
    }
    
    //Validar cuando sea email
    public boolean isEmail(String correo){
        //usar expresion regular
        Pattern pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        Matcher mat = pat.matcher(correo);//verificar si el correo es valido-retirna boolean
        return mat.find();
    }
}
