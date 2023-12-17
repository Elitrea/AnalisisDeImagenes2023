package espacial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class InterfazConvolucion extends JFrame {
    private BufferedImage imagenOriginal;
    private BufferedImage imagenResultante;
    private JTextField[][] matrizTextField;
    private JTextField divTextField;
    private JTextField offsetTextField;
    private JLabel labelImagenOriginal;
    private JLabel labelImagenResultante;
    private Convolucion5x5 convolucionador; // Mantener la instancia de Convolucion5x5

    public InterfazConvolucion() {
        setTitle("Convolución 5x5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Crear instancia de Convolucion5x5
        convolucionador = new Convolucion5x5(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        // Panel izquierdo: imagen original
        JPanel panelImagenOriginal = new JPanel(new BorderLayout());
        labelImagenOriginal = new JLabel("Imagen Original");
        panelImagenOriginal.add(labelImagenOriginal, BorderLayout.NORTH);
        panel.add(panelImagenOriginal);

        // Panel derecho: imagen resultante
        JPanel panelImagenResultante = new JPanel(new BorderLayout());
        labelImagenResultante = new JLabel("Imagen Resultante");
        panelImagenResultante.add(labelImagenResultante, BorderLayout.NORTH);
        panel.add(panelImagenResultante);

        // Panel inferior: matriz de convolución, valor de div, valor de offset y botón de convolución
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());

        matrizTextField = new JTextField[5][5];
        JPanel panelMatriz = new JPanel(new GridLayout(5, 5));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrizTextField[i][j] = new JTextField();
                panelMatriz.add(matrizTextField[i][j]);
            }
        }

        divTextField = new JTextField();
        divTextField.setPreferredSize(new Dimension(50, divTextField.getPreferredSize().height));
        divTextField.setText("1");

        offsetTextField = new JTextField();
        offsetTextField.setPreferredSize(new Dimension(50, offsetTextField.getPreferredSize().height));
        offsetTextField.setText("0");
        
        JButton botonConvolucion = new JButton("Realizar Convolución");
        botonConvolucion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarConvolucion();
            }
        });

        JPanel panelDivOffset = new JPanel();
        panelDivOffset.add(new JLabel("Valor de div: "));
        panelDivOffset.add(divTextField);
        panelDivOffset.add(new JLabel("Valor de offset: "));
        panelDivOffset.add(offsetTextField);

        panelInferior.add(panelMatriz, BorderLayout.CENTER);
        panelInferior.add(panelDivOffset, BorderLayout.WEST);
        panelInferior.add(botonConvolucion, BorderLayout.EAST);

        add(panel, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Cargar la imagen original
        cargarImagenOriginal();
    }

    private void realizarConvolucion() {
        try {
            // Obtener valores de la matriz de convolución, valor de div y valor de offset desde la interfaz
            int[] mascara = new int[25];
            int k = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    String valor = matrizTextField[i][j].getText();
                    int valorNumerico = valor.isEmpty() ? (i == 2 && j == 2 ? 1 : 0) : Integer.parseInt(valor);
                    mascara[k++] = valorNumerico;
                }
            }

            int div = Integer.parseInt(divTextField.getText());
            int offset = Integer.parseInt(offsetTextField.getText());

            // Realizar convolución y obtener la imagen resultante
            imagenResultante = herramientas.HerramientasImagen.toBufferedImage(convolucionador.convolucionar(mascara, div, offset));

            // Mostrar imágenes en la interfaz
            actualizarImagen(imagenOriginal, labelImagenOriginal);
            actualizarImagen(imagenResultante, labelImagenResultante);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    private void cargarImagenOriginal() {
        try {
            // Cargar la imagen original
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                imagenOriginal = herramientas.HerramientasImagen.toBufferedImage(OperacionesBasicas.escalaDeGrises(ImageIO.read(selectedFile)));
                //imagenOriginal = ImageIO.read(selectedFile);

                // Actualizar la instancia de Convolucion5x5 con la nueva imagen
                convolucionador = new Convolucion5x5(imagenOriginal);

                // Mostrar la imagen original en la interfaz
                actualizarImagen(imagenOriginal, labelImagenOriginal);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void actualizarImagen(BufferedImage imagen, JLabel etiqueta) {
        ImageIcon icono = new ImageIcon(imagen.getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        etiqueta.setIcon(icono);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfazConvolucion interfaz = new InterfazConvolucion();
                interfaz.setVisible(true);
            }
        });
    }
}
