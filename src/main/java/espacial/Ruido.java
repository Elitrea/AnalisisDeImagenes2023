/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author etrej
 */
public class Ruido {
    public static Image agregarRuidoAditivo(Image original, double porcentaje){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(original);
        int cp = (int)((porcentaje/100)*(bi.getHeight()*bi.getWidth()));
        Color aditivo = new Color(255, 255, 255);
        Random ran = new Random();
        int x,y;
        for(int i=0; i<cp;i++){
            //posición aleatoria dentro de la imagen 
            x=ran.nextInt(bi.getWidth());
            y=ran.nextInt(bi.getHeight());
            bi.setRGB(x, y, aditivo.getRGB());
        }
        
        System.out.println("");
        return herramientas.HerramientasImagen.toImage(bi);
        
    }
    
        public static Image agregarRuidoSustractivo(Image original, double porcentaje){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(original);
        int cp = (int)((porcentaje/100)*(bi.getHeight()*bi.getWidth()));
        Color sustractivo = new Color(0, 0, 0);
        Random ran = new Random();
        int x,y;
        for(int i=0; i<cp;i++){
            //posición aleatoria dentro de la imagen 
            x=ran.nextInt(bi.getWidth());
            y=ran.nextInt(bi.getHeight());
            bi.setRGB(x, y, sustractivo.getRGB());
        }
        
        System.out.println("");
        return herramientas.HerramientasImagen.toImage(bi);
        
    }
        public static Image agregarRuidoMezclado(Image original, double pSus, double pAdt){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(original);
        int cpSus = (int)((pSus/100)*(bi.getHeight()*bi.getWidth()));
        int cpAdt = (int)((pAdt/100)*(bi.getHeight()*bi.getWidth()));
        Color aditivo = new Color(255, 255, 255);
        Color sustractivo = new Color(0, 0, 0);
        Random ran = new Random();
        int x,y;
        for(int i=0; i<cpSus;i++){
            //posición aleatoria dentro de la imagen 
            x=ran.nextInt(bi.getWidth());
            y=ran.nextInt(bi.getHeight());
            bi.setRGB(x, y, sustractivo.getRGB());
        }
        
        for(int i=0; i<cpAdt;i++){
            //posición aleatoria dentro de la imagen 
            x=ran.nextInt(bi.getWidth());
            y=ran.nextInt(bi.getHeight());
            bi.setRGB(x, y, aditivo.getRGB());
        }
        
        System.out.println("");
        return herramientas.HerramientasImagen.toImage(bi);
        
    }        
}
