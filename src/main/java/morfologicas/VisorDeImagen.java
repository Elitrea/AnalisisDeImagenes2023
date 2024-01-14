/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package morfologicas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class VisorDeImagen extends JFrame {

    private JLabel etiquetaImagen;

    public VisorDeImagen() {
        super("Visor de Imagen");

        // Crear y configurar el JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Crear el botón para abrir el diálogo de selección de archivos
        JButton botonSeleccionar = new JButton("Seleccionar Imagen");
        botonSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resultado = fileChooser.showOpenDialog(VisorDeImagen.this);

                // Verificar si se seleccionó un archivo
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = fileChooser.getSelectedFile();

                    // Mostrar la imagen seleccionada
                    mostrarImagen(archivoSeleccionado);
                }
            }
        });

        // Configurar el diseño del JFrame
        etiquetaImagen = new JLabel();
        etiquetaImagen.setHorizontalAlignment(JLabel.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(botonSeleccionar, BorderLayout.NORTH);
        getContentPane().add(etiquetaImagen, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    private void mostrarImagen(File archivo) {
        ImageIcon imagenIcono = new ImageIcon(archivo.getAbsolutePath());
        Image imagen = imagenIcono.getImage();
        Image nuevaImagen = imagen.getScaledInstance(etiquetaImagen.getWidth(), etiquetaImagen.getHeight(), Image.SCALE_SMOOTH);
        etiquetaImagen.setIcon(new ImageIcon(nuevaImagen));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VisorDeImagen().setVisible(true);
            }
        });
    }
}
