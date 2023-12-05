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
public class Binarizacion {

    public static Image binarizarImagen(Image original, int j){
    BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(original);
    for(int x=0; x<bufferedImage.getWidth();x++){
        for(int y=0; y<bufferedImage.getHeight();y++){
            //Realizar el promedio de los colores RGB
            Color color = new Color(bufferedImage.getRGB(x, y));
            int base = color.getGreen();
            if(base>=j) base = 255;
            if(base<j) base = 0;
            color = new Color(base, base, base);
            bufferedImage.setRGB(x, y, color.getRGB());
        }
    }
    Image img = herramientas.HerramientasImagen.toImage(bufferedImage);
    return img;
    }
    
    //BINARIZACIÓN CON 2 UMBRALES
    public static Image binarizarImagen(Image original, int j1, int j2){
    if(j2>j1){
        BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(original);
        for(int x=0; x<bufferedImage.getWidth();x++){
            for(int y=0; y<bufferedImage.getHeight();y++){
                //Realizar el promedio de los colores RGB
                Color color = new Color(bufferedImage.getRGB(x, y));
                int base = color.getGreen();
                if(base>=j2) base = 255;
                else if(base<j2) base = 0;
                else if(base>j1) base = 0;
                else base = 255;
                color = new Color(base, base, base);
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
        Image img = herramientas.HerramientasImagen.toImage(bufferedImage);
        return img;
        }
        System.err.println("Valor erróneo");
        return null;
    }
    
    public static Image binarizarImagenAuto(Image original){
    BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(original);
    int j = 150;
    int promedio1=150;
    int promedio2=150;
    do{
    //Hacer el reajuste de J?
    j=promedio1+promedio2/2;
    for(int x=0; x<bufferedImage.getWidth();x++){
        for(int y=0; y<bufferedImage.getHeight();y++){
            //Realizar el promedio de los colores RGB
            Color color = new Color(bufferedImage.getRGB(x, y));
            int base = color.getGreen();
            if(base>=j){ 
                base = 255;
                promedio1=promedio1++;
            }
            if(base<j){ 
                base = 0;
                promedio2=promedio2++;
            }
            color = new Color(base, base, base);
            bufferedImage.setRGB(x, y, color.getRGB());
        }
    }
    promedio1=promedio1/(promedio1+promedio2);
    promedio2=promedio2/(promedio1+promedio2);
    
    }while(promedio1 != promedio2);
    
    Image img = herramientas.HerramientasImagen.toImage(bufferedImage);
    return img;
    }
    
    
}
