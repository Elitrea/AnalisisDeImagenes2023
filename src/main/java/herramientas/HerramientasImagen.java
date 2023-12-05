package herramientas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author EDTA
 */
public class HerramientasImagen {
    
    
    public static Image abrirImagen (){
    
          try {
            // definir los filtros para lectura
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Imagenes","jpg","jpeg","png","bmp");
            // crear un selector de archivos
            JFileChooser selector = new JFileChooser();
            // agregar el filtro al selector
            selector.addChoosableFileFilter(filtro);
            // especificar que solo se puedan abrir archivos
            selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            //ejecutar el selector de imagenes
            
            int res = selector.showOpenDialog(null);
            
            if (res == 1 ){
                
                return null;
                
            }
            
            File archivo = selector.getSelectedFile();
            
            BufferedImage bi = ImageIO.read(archivo);
            
            return toImage(bi);
        } catch (IOException ex) {
            Logger.getLogger(HerramientasImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }  
    
    public static Image toImage (BufferedImage bi){
        return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
    
    public static BufferedImage toBufferedImage (Image imagen){
         // imagen es un objeto de tipo BufferedImage
        BufferedImage bi = 
                new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
        
        Graphics2D nueva = bi.createGraphics();
        nueva.drawImage(imagen, 0, 0,null);
        nueva.dispose();
        
        return bi;
    }
    
    public static Image copiarImagen(Image i){
        BufferedImage bi = toBufferedImage(i);
        return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
    
    public double[][] calcularHistograma(Image imagen){
        // Dimension de los contadores 256
        double [][] fin = new double[3][256];
        double [] contR = new double[256];
        double [] contG = new double[256];
        double [] contB = new double[256];
        
        //Definir dimensiones
        int w = imagen.getWidth(null);
        int h = imagen.getHeight(null);
        
        // Recorrer los pixeles de la imagen
        BufferedImage bi = toBufferedImage(imagen);
        
        for(int x=0; x<w;x++){
            for(int y=0; y<h;y++){
                Color color = new Color(bi.getRGB(x, y));
                contR[color.getRed()] = contR[color.getRed()]+1;
                contG[color.getGreen()] = contG[color.getGreen()]+1;
                contB[color.getBlue()] = contB[color.getBlue()]+1;
            }
        }     
        fin[0] = contR;
        fin[1] = contG;
        fin[2] = contB;
        
        return fin;
    }
}
