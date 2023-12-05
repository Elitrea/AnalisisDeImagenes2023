/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espacial;

import gui.Imagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import org.jfree.data.statistics.HistogramBin;

/**
 *
 * @author etrej
 */
public class Expansion {

    double histograma [][];
    public Expansion(double histogramaOr[][]) {
        histograma = histogramaOr;
    }

    public static Image generaExpansionLinealGrises(int r1, int r2, Image grises){
    BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(grises);
    for(int x=0; x<bufferedImage.getWidth();x++){
        for(int y=0; y<bufferedImage.getHeight();y++){
            //Realizar el promedio de los colores RGB
            Color color = new Color(bufferedImage.getRGB(x, y));
            int base = validar((color.getBlue()-r1)*(255/(r2-r1)));
            color = new Color(base, base, base);
            bufferedImage.setRGB(x, y, color.getRGB());
        }
    }
    Image img = herramientas.HerramientasImagen.toImage(bufferedImage);
    return img;
    }

    //R[0,3]
    //G[1,4]
    //B[2,5]
    public static Image generaExpansionLinealColor(Image grises, double histograma [][]){
    int rs[] = obtenerRS(histograma);
    BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(grises);
    for(int x=0; x<bufferedImage.getWidth();x++){
        for(int y=0; y<bufferedImage.getHeight();y++){
            //Realizar el promedio de los colores RGB
            Color color = new Color(bufferedImage.getRGB(x, y));
            int r = validar((color.getRed()-rs[0])*(255/(rs[3]-rs[0])));
            int g = validar((color.getGreen()-rs[1])*(255/(rs[4]-rs[1])));
            int b = validar((color.getBlue()-rs[2])*(255/(rs[5]-rs[2])));
            color = new Color(r, g, b);
            bufferedImage.setRGB(x, y, color.getRGB());
        }
    }
    Image img = herramientas.HerramientasImagen.toImage(bufferedImage);
    return img;
    }
    
    
    public static Image generaExpansionLinealColorDada(Image grises, double histograma [][], int rs []){
    BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(grises);
    for(int x=0; x<bufferedImage.getWidth();x++){
        for(int y=0; y<bufferedImage.getHeight();y++){
            //Realizar el promedio de los colores RGB
            Color color = new Color(bufferedImage.getRGB(x, y));
            int r = validar((color.getRed()-rs[0])*(255/(rs[3]-rs[0])));
            int g = validar((color.getGreen()-rs[1])*(255/(rs[4]-rs[1])));
            int b = validar((color.getBlue()-rs[2])*(255/(rs[5]-rs[2])));
            color = new Color(r, g, b);
            bufferedImage.setRGB(x, y, color.getRGB());
        }
    }
    Image img = herramientas.HerramientasImagen.toImage(bufferedImage);
    return img;
    }
    
    public static Image generaExpansionLogaritmica(Image imagen){
    BufferedImage bufferedImage = herramientas.HerramientasImagen.toBufferedImage(imagen);
    for(int x=0; x<bufferedImage.getWidth();x++){
        for(int y=0; y<bufferedImage.getHeight();y++){
            //Realizar el promedio de los colores RGB
            Color color = new Color(bufferedImage.getRGB(x, y));
            int r = validar((int)((255*Math.log(1+color.getRed()))/(Math.log(1+255))));
            int g = validar((int)((255*Math.log(1+color.getGreen()))/(Math.log(1+255))));
            int b = validar((int)((255*Math.log(1+color.getBlue()))/(Math.log(1+255))));
            color = new Color(r, g, b);
            bufferedImage.setRGB(x, y, color.getRGB());
        }
    }
    Image img = herramientas.HerramientasImagen.toImage(bufferedImage);
    return img;
    }
        
    public static int[] obtenerRS(double[][] histograma){
        int[] rs = new int[6];
        rs[0] = obtenerMinimo(histograma[0]);
        rs[3] = obtenerMaximo(histograma[0]);
        rs[1] = obtenerMinimo(histograma[1]);
        rs[4] = obtenerMaximo(histograma[1]);       
        rs[2] = obtenerMinimo(histograma[2]);
        rs[5] = obtenerMaximo(histograma[2]);
        return rs;
    }
    //Para obtener valores de máximos y mínimos 
    public static int obtenerMinimo(double [] histograma){
        for(int x=0; x<histograma.length;x++){
            if(histograma[x]!=0) return x;
        }
        return -1;
    }
    public static int obtenerMaximo(double [] histograma){
        for(int x=histograma.length-1;x>=0;x--){
            if(histograma[x]!=0) return x;
        }
        return -1;
    }
    
    private static int validar(int i) {
    if(i>255)return 255;
    if(i<0)return 0;
    else return i;
}
    
}
