/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author angue
 */
public class Uploadimage extends javax.swing.JFrame {//heredar de la clase jframe

    private File archivo;  //tipo archivo
    private JFileChooser abrirArchivo;//permitira elegir el archivo en el directorio del pc
    
    private static String urlOrigen = null;
    private static byte[] imageByte = null;//array de tipo byte -> usado para la bd
    
    //Getter para obtener la imagen como arreglo de byte
    public static byte[] getImageByte() {
        return imageByte;
    }

    
    public void CargarImagen(JLabel label) {
        abrirArchivo = new JFileChooser();//intanciar el objeto
        //setFileFilter->Filtrar archivos --- nameextensios formatos de imagen
        abrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivos de Imagen", "jpg", "png", "gif"));
        int respuesta = abrirArchivo.showOpenDialog(this);//abrir ventana- this->tomar objeto de jFrame
        
        if (respuesta == JFileChooser.APPROVE_OPTION) {//si la ventana se desplego
            archivo = abrirArchivo.getSelectedFile();//seleccionar el archivo
            urlOrigen = archivo.getAbsolutePath();//direccion del archivo en la pc
            
            Image foto = getToolkit().getImage(urlOrigen);//Objeto de tipo Image -> asignar la imagen por mesio del url
            foto = foto.getScaledInstance(140, 140, 1);//Escalar la imagen(ancho, alto)
            
            label.setIcon(new ImageIcon(foto));//proporcionar un icono al label-> el icono será la imagen seleccionada por el usuario
            imageByte = new byte[(int) archivo.length()];//convertir archivo en arreglo byte
        }
    }
    
    public byte[] getTransFoto(JLabel label){//retorna arreglo de byte
        ByteArrayOutputStream baos = null;
        try{
            Icon ico = label.getIcon();
            //Crear buffer de imagen
            BufferedImage bufferedImage = new BufferedImage(ico.getIconWidth(), ico.getIconHeight(), 
                    BufferedImage.TYPE_INT_RGB);
            baos = new ByteArrayOutputStream();//instanciar arreglo de byte
            //Escribir Imagen de tipo png
            ImageIO.write(bufferedImage, "png", baos);
            
        }catch(IOException e){
            
        }
        return baos.toByteArray();
    }
}
