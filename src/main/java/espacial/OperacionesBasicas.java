/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author etrej
 */
public class OperacionesBasicas {

    public static Image escalaDeGrises(Image original){
        // to buffer
        BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(original);
        for(int x=0; x<bufferedImage.getWidth();x++){
            for(int y=0; y<bufferedImage.getHeight();y++){
                //Realizar el promedio de los colores RGB
                Color color = new Color(bufferedImage.getRGB(x, y));
                int colorGrises = ((color.getRed()+ color.getGreen() + color.getBlue())/3);
                Color colorByN = new Color(colorGrises, colorGrises, colorGrises);
                bufferedImage.setRGB(x, y, colorByN.getRGB());
            }
        }
        Image bynImage = herramientas.HerramientasImagen.toImage(bufferedImage);
        return bynImage;
    }
    
    public static Image modificarIluminacion(Image original, int m){
        // Con m = índice de modificación +agregarIlumicacion -quitarIluminacion
        BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(original);
        for(int x=0; x<bufferedImage.getWidth();x++){
            for(int y=0; y<bufferedImage.getHeight();y++){
                //Realizar el promedio de los colores RGB
                Color color = new Color(bufferedImage.getRGB(x, y));
                color = new Color(validar(color.getRed()+m), validar(color.getGreen()+m), validar(color.getBlue()+m));
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
        Image img = herramientas.HerramientasImagen.toImage(bufferedImage);
        return img;
    }
    
    public static Image modificarTemperaturaMasCalida(Image original, int j){
        // Con m = índice de modificación +agregarIlumicacion -quitarIluminacion
        BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(original);
        for(int x=0; x<bufferedImage.getWidth();x++){
            for(int y=0; y<bufferedImage.getHeight();y++){
                //Realizar el promedio de los colores RGB
                Color color = new Color(bufferedImage.getRGB(x, y));
                color = new Color(validar(color.getRed()+j), validar(color.getGreen()), validar(color.getBlue()-j));
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
        Image img = herramientas.HerramientasImagen.toImage(bufferedImage);
        return img;
    }
    
    public static Image modificarTemperaturaMasFria(Image original, int f){
        // Con m = índice de modificación +agregarIlumicacion -quitarIluminacion
        BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(original);
        for(int x=0; x<bufferedImage.getWidth();x++){
            for(int y=0; y<bufferedImage.getHeight();y++){
                //Realizar el promedio de los colores RGB
                Color color = new Color(bufferedImage.getRGB(x, y));
                color = new Color(validar(color.getRed()-f), validar(color.getGreen()), validar(color.getBlue()+f));
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
        Image img = herramientas.HerramientasImagen.toImage(bufferedImage);
        return img;
    }

    public static Image negativoImagen(Image original){
        // Con m = índice de modificación +agregarIlumicacion -quitarIluminacion
        BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(original);
        for(int x=0; x<bufferedImage.getWidth();x++){
            for(int y=0; y<bufferedImage.getHeight();y++){
                //Realizar el promedio de los colores RGB
                Color color = new Color(bufferedImage.getRGB(x, y));
                color = new Color(255-validar(color.getRed()), validar(255-color.getGreen()), validar(255-color.getBlue()));
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
        Image img = herramientas.HerramientasImagen.toImage(bufferedImage);
        return img;
    }
    private static int validar(int i) {
        if(i>255)return 255;
        if(i<0)return 0;
        else return i;
    }
}
