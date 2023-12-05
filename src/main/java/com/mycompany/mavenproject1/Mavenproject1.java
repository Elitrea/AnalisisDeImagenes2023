/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import espacial.Binarizacion;
import espacial.Convolucion;
import espacial.Expansion;
import espacial.OperacionesBasicas;
import espacial.UmbralAutomatico;
import gui.JFrameImg;
import herramientas.Graficador;
import herramientas.HerramientasImagen;
import java.awt.Color;
import java.awt.Image;
import espacial.Iluminacion;
import espacial.Ruido;
import gui.Imagen;
import javax.swing.Icon;

/**
 *
 * @author etrej
 */
public class Mavenproject1 {

    public static void main (String [ ] args) {
//    Image imagen = herramientas.HerramientasImagen.abrirImagen();
//    JFrameImg frame = new JFrameImg(imagen);
    //double arreglo[] = new double[]{3.4,4.5,8.6,12.1,32};
//HerramientasImagen n = new HerramientasImagen();
//Image imagen = n.abrirImagen();
//double[][] arreglo = n.calcularHistograma(imagen);
//JFrameImg frame = new JFrameImg(imagen);
//Graficador g = new Graficador("ejex", "ejey", "Grafica");
//g.agregarSerie("serie1", arreglo[0]); // Serie 1 en rojo
//g.crearGrafica(Color.RED);
//g.muestraGrafica();
//
//Graficador g2 = new Graficador("ejex", "ejey", "Grafica");
//g2.agregarSerie("serie2", arreglo[1]); // Serie 2 en azul
//g2.crearGrafica(Color.GREEN);
//g2.muestraGrafica();
//
//Graficador g3 = new Graficador("ejex", "ejey", "Grafica");
//g3.agregarSerie("serie3", arreglo[2]); // Serie 3 en verde
//g3.crearGrafica(Color.BLUE);
//g3.muestraGrafica();

    
//HerramientasImagen n = new HerramientasImagen();
//Image imagen = n.abrirImagen();
//double[][] arreglo = n.calcularHistograma(imagen);
//JFrameImg fr = new JFrameImg(imagen);
//Image imagen2 = OperacionesBasicas.escalaDeGrises(imagen);
//double[][] arregloGrises = n.calcularHistograma(imagen2);
//JFrameImg frame = new JFrameImg(imagen2);
//
//Graficador colores = new Graficador("eje x", "eje y", "Histograma de RGB");
//colores.crearGrafica();
//colores.agregarSerie("rojo", arreglo[0],Color.red);
//colores.agregarSerie("verde", arreglo[1], Color.green);
//colores.agregarSerie("azul", arreglo[2],Color.blue);
//colores.muestraGrafica();
//
//Graficador grises = new Graficador("eje x", "eje y", "Histograma de grises");
//grises.crearGrafica();
//grises.agregarSerie("grises", arregloGrises[0],Color.red);
//grises.agregarSerie("grises2", arregloGrises[1], Color.green);
//grises.agregarSerie("grises3", arregloGrises[2],Color.blue);
//grises.muestraGrafica();


////PARA MODIFICAR ILUMINCACIÓN ACTIVE
//HerramientasImagen n = new HerramientasImagen();
//Image imagen = n.abrirImagen();
//JFrameImg fr = new JFrameImg(imagen);
//Image imagen2 = OperacionesBasicas.modificarIluminacion(imagen,255 );
//JFrameImg fr2 = new JFrameImg(imagen2);

//
//Graficador colores = new Graficador("tono", "frecuencia", "Histograma de original");
//colores.crearGrafica();
//double[][] arreglo = n.calcularHistograma(imagen);
//colores.agregarSerie("grises", arreglo[0],Color.red);
//colores.agregarSerie("grises2", arreglo[1], Color.green);
//colores.agregarSerie("grises3", arreglo[2],Color.blue);
//colores.muestraGrafica();
//
//Graficador ilum = new Graficador("tono", "frecuencia", "Histograma de Iluminacion");
//ilum.crearGrafica();
//double[][] arregloIlum = n.calcularHistograma(imagen2);
//ilum.agregarSerie("ilum1", arregloIlum[0],Color.red);
//ilum.agregarSerie("ilum2", arregloIlum[1], Color.green);
//ilum.agregarSerie("ilum3", arregloIlum[2],Color.blue);
//ilum.muestraGrafica();




////PARA MODIFICAR TEMPERATURA ACTIVE
//HerramientasImagen n = new HerramientasImagen();
//Image imagen = n.abrirImagen();
//JFrameImg fr = new JFrameImg(imagen);
//Image imagen2 = OperacionesBasicas.modificarTemperaturaMasFria(imagen,50 );
//JFrameImg fr2 = new JFrameImg(imagen2);
//
//
//Graficador colores = new Graficador("tono", "frecuencia", "Histograma de original");
//colores.crearGrafica();
//double[][] arreglo = n.calcularHistograma(imagen);
//colores.agregarSerie("grises", arreglo[0],Color.red);
//colores.agregarSerie("grises2", arreglo[1], Color.green);
//colores.agregarSerie("grises3", arreglo[2],Color.blue);
//colores.muestraGrafica();
//
//Graficador ilum = new Graficador("tono", "frecuencia", "Histograma cambio de Temperatura");
//ilum.crearGrafica();
//double[][] arregloIlum = n.calcularHistograma(imagen2);
//ilum.agregarSerie("ilum1", arregloIlum[0],Color.red);
//ilum.agregarSerie("ilum2", arregloIlum[1], Color.green);
//ilum.agregarSerie("ilum3", arregloIlum[2],Color.blue);
//ilum.muestraGrafica();


        
    
////PARA NEGARLA
//HerramientasImagen n = new HerramientasImagen();
//Image imagen = n.abrirImagen();
//double[][] arreglo = n.calcularHistograma(imagen);
//JFrameImg fr = new JFrameImg(imagen);
//Image imagen2 = OperacionesBasicas.negativoImagen(imagen);
//double[][] arregloGrises = n.calcularHistograma(imagen2);
//JFrameImg frame = new JFrameImg(imagen2);
//
//Graficador colores = new Graficador("eje x", "eje y", "Histograma de RGB");
//colores.crearGrafica();
//colores.agregarSerie("rojo", arreglo[0],Color.red);
//colores.agregarSerie("verde", arreglo[1], Color.green);
//colores.agregarSerie("azul", arreglo[2],Color.blue);
//colores.muestraGrafica();
//
//Graficador grises = new Graficador("eje x", "eje y", "Histograma de grises");
//grises.crearGrafica();
//grises.agregarSerie("grises", arregloGrises[0],Color.red);
//grises.agregarSerie("grises2", arregloGrises[1], Color.green);
//grises.agregarSerie("grises3", arregloGrises[2],Color.blue);
//grises.muestraGrafica();
    
////BINARIZACIÓN DOBLE
//HerramientasImagen n = new HerramientasImagen();
//Image imagen = n.abrirImagen();
//Image imagenG = OperacionesBasicas.escalaDeGrises(imagen);
//double[][] arreglo = n.calcularHistograma(imagenG);
//JFrameImg fr = new JFrameImg(imagen);
//int jtry = UmbralAutomatico.metodoIterativo(arreglo[0]);
//Image imagen2 = Binarizacion.binarizarImagen(imagen,jtry);
//double[][] arregloGrises = n.calcularHistograma(imagen2);
//JFrameImg frame = new JFrameImg(imagen2);
//
//Graficador colores = new Graficador("eje x", "eje y", "Histograma de RGB");
//colores.crearGrafica();
//colores.agregarSerie("rojo", arreglo[0],Color.red);
//colores.agregarSerie("verde", arreglo[1], Color.green);
//colores.agregarSerie("azul", arreglo[2],Color.blue);
//colores.muestraGrafica();
//
//Graficador grises = new Graficador("eje x", "eje y", "Histograma de grises");
//grises.crearGrafica();
//grises.agregarSerie("grises", arregloGrises[0],Color.red);
//grises.agregarSerie("grises2", arregloGrises[1], Color.green);
//grises.agregarSerie("grises3", arregloGrises[2],Color.blue);
//grises.muestraGrafica();

////ILUMINACIÓN
//HerramientasImagen n = new HerramientasImagen();
//Image imagen = n.abrirImagen();
//Image imagenG = OperacionesBasicas.escalaDeGrises(imagen);
//double[][] arreglo = n.calcularHistograma(imagenG);
//JFrameImg fr = new JFrameImg(imagenG);
//int jtry = UmbralAutomatico.metodoIterativo(arreglo[0]);
//Image imagen2 = Iluminacion.iluminarImagen(imagenG, jtry, 30);
//double[][] arregloGrises = n.calcularHistograma(imagen2);
//JFrameImg frame = new JFrameImg(imagen2);
//
//Graficador colores = new Graficador("eje x", "eje y", "Histograma de Original en Grises");
//colores.crearGrafica();
//colores.agregarSerie("gris", arreglo[0],Color.BLUE);
//colores.muestraGrafica();
//
//Graficador grises = new Graficador("eje x", "eje y", "Histograma de iluminado");
//grises.crearGrafica();
//grises.agregarSerie("gris", arregloGrises[0],Color.BLUE);
//grises.muestraGrafica();

////EXPANSIÓN 1
//HerramientasImagen n = new HerramientasImagen();
//Image imagen = n.abrirImagen();
//Image imagenG = OperacionesBasicas.escalaDeGrises(imagen);
//double[][] arreglo = n.calcularHistograma(imagenG);
//JFrameImg fr = new JFrameImg(imagenG);
//int r2 = Expansion.obtenerMaximo(arreglo[0]);
//int r1 = Expansion.obtenerMinimo(arreglo[0]);
//Image imagen2 = Expansion.generaExpansionLinealGrises(r1, r2, imagen);
//double[][] arregloGrises = n.calcularHistograma(imagen2);
//JFrameImg frame = new JFrameImg(imagen2);
//
//Graficador colores = new Graficador("eje x", "eje y", "Histograma de Original en Grises");
//colores.crearGrafica();
//colores.agregarSerie("gris", arreglo[0],Color.BLUE);
//colores.muestraGrafica();
//
//Graficador grises = new Graficador("eje x", "eje y", "Histograma de iluminado");
//grises.crearGrafica();
//grises.agregarSerie("gris", arregloGrises[0],Color.BLUE);
//grises.muestraGrafica();

////EXPANSIÓN 2
//HerramientasImagen n = new HerramientasImagen();
//Image imagen = n.abrirImagen();
//double[][] arreglo = n.calcularHistograma(imagen);
//JFrameImg fr = new JFrameImg(imagen);
//Image imagen2 = Expansion.generaExpansionLogaritmica(imagen);
//double[][] arregloGrises = n.calcularHistograma(imagen2);
//JFrameImg frame = new JFrameImg(imagen2);
//
//Graficador colores = new Graficador("eje x", "eje y", "Histograma de Original en Grises");
//colores.crearGrafica();
//colores.agregarSerie("gris", arreglo[0],Color.red);
//colores.agregarSerie("gris2", arreglo[1],Color.green);
//colores.agregarSerie("gris3", arreglo[2],Color.blue);
//colores.muestraGrafica();
//
//Graficador grises = new Graficador("eje x", "eje y", "Histograma de iluminado");
//grises.crearGrafica();
//grises.agregarSerie("rojo", arregloGrises[0],Color.red);
//grises.agregarSerie("verde", arregloGrises[1],Color.green);
//grises.agregarSerie("azul", arregloGrises[2],Color.blue);
//grises.muestraGrafica();


////EXPANSIÓN CON IMAGEN DE COLOR
//HerramientasImagen n = new HerramientasImagen();
//Image imagen = n.abrirImagen();
//double[][] arreglo = n.calcularHistograma(imagen);
////JFrameImg fr = new JFrameImg(imagen);
//Image imagen2 = Expansion.generaExpansionLinealColor(imagen, arreglo);
//double[][] arregloGrises = n.calcularHistograma(imagen2);
//JFrameImg frame = new JFrameImg(imagen2);
//img.setIconJlabel((Icon) imagen);
//System.out.println("");
//Graficador colores = new Graficador("eje x", "eje y", "Histograma de Original en Grises");
//colores.crearGrafica();
//colores.agregarSerie("gris", arreglo[0],Color.red);
//colores.agregarSerie("gris2", arreglo[1],Color.green);
//colores.agregarSerie("gris3", arreglo[2],Color.blue);
//colores.muestraGrafica();
//
//Graficador grises = new Graficador("eje x", "eje y", "Histograma de iluminado");
//grises.crearGrafica();
//grises.agregarSerie("rojo", arregloGrises[0],Color.red);
//grises.agregarSerie("verde", arregloGrises[1],Color.green);
//grises.agregarSerie("azul", arregloGrises[2],Color.blue);
//grises.muestraGrafica();

//Image imagenO = HerramientasImagen.abrirImagen();
//Convolucion c = new Convolucion(herramientas.HerramientasImagen.toBufferedImage(imagenO));
//Image nueva = c.convolucionar(new int[]{1,0,1,
//                                        2,0,2,
//                                        1,0,1}, 6);
//JFrameImg frame = new JFrameImg(nueva);

Image original = HerramientasImagen.abrirImagen();
Image ruido = Ruido.agregarRuidoMezclado(original, 1,1);
Convolucion c = new Convolucion(herramientas.HerramientasImagen.toBufferedImage(ruido));
Image nueva = c.convolucionar(new int[]{1,1,1,
                                        1,0,1,
                                        1,1,1}, 8);
JFrameImg frame = new JFrameImg(ruido);
JFrameImg frame2 = new JFrameImg(nueva);
    }
}
