package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JFrameImg extends JFrame {
    private JLabel lbImagen;

    public JFrameImg(Image imagen) {
        inicializarComponentes(imagen);
    }

    private void inicializarComponentes(Image imagen) {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        this.lbImagen = new JLabel();
        add(this.lbImagen);
        this.lbImagen.setIcon(new ImageIcon(imagen));

        // Crear un botón
        JButton botonGuardar = new JButton("Guardar como PNG");
        add(botonGuardar);
        
        // Configurar el ActionListener para el botón
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarComoPNG();
            }
        });

        // Establecer el diseño del JFrame
        setLayout(new java.awt.FlowLayout());
        setSize(imagen.getWidth(this), imagen.getHeight(this));
        setVisible(true);
    }

    // Método para guardar la imagen como PNG
    private void guardarComoPNG() {
        try {
            // Obtener la imagen del JLabel
            Image imagen = ((ImageIcon) lbImagen.getIcon()).getImage();

            // Crear un BufferedImage a partir de la imagen
            BufferedImage bufferedImage = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            bufferedImage.getGraphics().drawImage(imagen, 0, 0, null);

            // Mostrar un diálogo para seleccionar la ubicación de guardado
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar como PNG");
            int seleccion = fileChooser.showSaveDialog(this);

            // Si se selecciona una ubicación, guardar la imagen
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filePath = file.getAbsolutePath();

                // Agregar la extensión .png si no está presente
                if (!filePath.toLowerCase().endsWith(".png")) {
                    filePath += ".png";
                }

                // Guardar la imagen como archivo PNG
                File outputFile = new File(filePath);
                ImageIO.write(bufferedImage, "png", outputFile);
                JOptionPane.showMessageDialog(this, "Imagen guardada exitosamente.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
