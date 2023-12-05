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
public class Iluminacion {
    public static Image iluminarImagen(Image grises, int j, int r){
    BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(grises);
    for(int x=0; x<bufferedImage.getWidth();x++){
        for(int y=0; y<bufferedImage.getHeight();y++){
            //Realizar el promedio de los colores RGB
            Color color = new Color(bufferedImage.getRGB(x, y));
            int base = color.getGreen();
            if(base>=j){
                //iluminar
                base=validar(color.getGreen()+r);
            }
            color = new Color(base, base, base);
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
