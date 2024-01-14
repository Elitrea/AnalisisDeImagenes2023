/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package morfologicas;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author etrej
 */
public class ListenerAgregarFigura implements ActionListener{

    JFrameMorfo frame;
    public ListenerAgregarFigura(JFrameMorfo frame) {
        this.frame = frame;
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
       BufferedImage bi = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
       //frame.actualizarLienzo(herramientas.HerramientasImagen.toImage(bi));
    }
}
