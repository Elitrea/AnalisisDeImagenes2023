/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package morfologicas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageEditor extends JFrame {

    private BufferedImage originalImage;
    private BufferedImage transformedImage;
    private JLabel imageLabel;
    private JTextField translateXField, translateYField, rotateField, scaleXField, scaleYField;

    public ImageEditor() {
        setTitle("Image Editor");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar el fondo negro
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.BLACK);

        // Crear un panel para contener los controles
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // Usar FlowLayout para centrar los controles
        JButton openButton = new JButton("Abrir Imagen");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openImage();
            }
        });
        panel.add(openButton);

        translateXField = new JTextField("50", 3);
        translateYField = new JTextField("50", 3);
        rotateField = new JTextField("45", 3);
        scaleXField = new JTextField("1.5", 3);
        scaleYField = new JTextField("1.5", 3);

        JButton translateButton = new JButton("Trasladar");
        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(translateXField.getText());
                int y = Integer.parseInt(translateYField.getText());
                translateImage(x, y);
            }
        });
        panel.add(new JLabel("Traslación X:"));
        panel.add(translateXField);
        panel.add(new JLabel("Traslación Y:"));
        panel.add(translateYField);
        panel.add(translateButton);

        JButton rotateButton = new JButton("Rotar");
        rotateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double degrees = Double.parseDouble(rotateField.getText());
                rotateImage(degrees);
            }
        });
        panel.add(new JLabel("Rotación (grados):"));
        panel.add(rotateField);
        panel.add(rotateButton);

        JButton scaleButton = new JButton("Escalar");
        scaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double scaleX = Double.parseDouble(scaleXField.getText());
                double scaleY = Double.parseDouble(scaleYField.getText());
                scaleImage(scaleX, scaleY);
            }
        });
        panel.add(new JLabel("Escalamiento X:"));
        panel.add(scaleXField);
        panel.add(new JLabel("Escalamiento Y:"));
        panel.add(scaleYField);
        panel.add(scaleButton);

        // Etiqueta para mostrar la imagen
        imageLabel = new JLabel();
        contentPane.add(panel, BorderLayout.SOUTH);
        contentPane.add(imageLabel, BorderLayout.CENTER);

        // Establecer el contenido principal del JFrame
        setContentPane(contentPane);
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                originalImage = ImageIO.read(selectedFile);
                transformedImage = new BufferedImage(100, 100, originalImage.getType());
                Graphics2D g2d = transformedImage.createGraphics();
                g2d.drawImage(originalImage, 0, 0, 100, 100, null);
                g2d.dispose();
                displayImage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void translateImage(int x, int y) {
        AffineTransform tx = new AffineTransform();
        tx.translate(x, y);
        applyTransform(tx);
    }

    private void rotateImage(double degrees) {
        AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians(degrees),
                transformedImage.getWidth() / 2.0, transformedImage.getHeight() / 2.0);
        applyTransform(tx);
    }

    private void scaleImage(double scaleX, double scaleY) {
        AffineTransform tx = AffineTransform.getScaleInstance(scaleX, scaleY);
        applyTransform(tx);
    }

    private void applyTransform(AffineTransform tx) {
        BufferedImage tempImage = new BufferedImage(100, 100, originalImage.getType());
        Graphics2D g2d = tempImage.createGraphics();
        g2d.drawImage(transformedImage, 0, 0, null);
        g2d.dispose();

        transformedImage = new BufferedImage(100, 100, originalImage.getType());
        g2d = transformedImage.createGraphics();
        g2d.setTransform(tx);
        g2d.drawImage(tempImage, 0, 0, null);
        g2d.dispose();

        displayImage();
    }

    private void displayImage() {
        ImageIcon icon = new ImageIcon(transformedImage);
        imageLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageEditor().setVisible(true);
            }
        });
    }
}
