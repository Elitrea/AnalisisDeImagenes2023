/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author etrej
 */
public class JFrameExpansion extends javax.swing.JFrame {
    private JLabel lbImagen;

    public JFrameExpansion(Image imagen) {
        inicializarComponentes(imagen);
    }

    private void inicializarComponentes(Image imagen) {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.lbImagen = new JLabel();
        add(this.lbImagen);
        this.lbImagen.setIcon(new ImageIcon(imagen));
        setSize(imagen.getWidth(this), imagen.getHeight(this));
        setVisible(true);
    }
    
    
}
