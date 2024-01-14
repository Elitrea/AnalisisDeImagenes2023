package morfologicas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JFrameMorfo extends JFrame {
    JPanel lienzo;
    JLabel etiquetaImg;
    Image imagenActual;
    AffineTransform transformacion = new AffineTransform();

    public JFrameMorfo() {
        // Agregar directamente al lienzo
        inicializarCanvas();
    }

    private void inicializarCanvas() {
        setSize(800, 600);
        setLayout(new BorderLayout());

        // En la parte central, un panel
        this.lienzo = new JPanel();
        this.etiquetaImg = new JLabel();

        // Cargar una imagen predeterminada
        Image imagenInicial = seleccionarImagen();
        if (imagenInicial != null) {
            this.imagenActual = imagenInicial;
            actualizarLienzo();
        } else {
            // Mostrar un rectángulo si no se selecciona una imagen
            BufferedImage bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.getGraphics();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, bi.getWidth(), bi.getHeight());
            this.imagenActual = bi;
            actualizarLienzo();
        }

        // Agregar al lienzo
        this.lienzo.add(etiquetaImg);

        JPanel controles = new JPanel();
        controles.setLayout(new BorderLayout());

        // Panel de controles para trasladar, rotar y escalar
        JPanel panelControles = new JPanel();
        panelControles.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Configurar borde para el panel de controles
        Border bordeControles = BorderFactory.createTitledBorder("Operaciones");
        panelControles.setBorder(bordeControles);

        // 1. Caja de texto que pida el movimiento vertical
        JTextField txtMovimientoVertical = new JTextField(5);
        panelControles.add(new JLabel("Movimiento vertical:"));
        panelControles.add(txtMovimientoVertical);

        // 2. Caja de texto que pida el movimiento horizontal
        JTextField txtMovimientoHorizontal = new JTextField(5);
        panelControles.add(new JLabel("Movimiento horizontal:"));
        panelControles.add(txtMovimientoHorizontal);

        // Botón para aplicar traslación
        JButton btnTrasladar = new JButton("Trasladar");
        btnTrasladar.addActionListener(e -> {
            trasladarFigura(Integer.parseInt(txtMovimientoHorizontal.getText()), Integer.parseInt(txtMovimientoVertical.getText()));
        });
        panelControles.add(btnTrasladar);

        // 4. Caja de texto que pida el ángulo de rotación
        JTextField txtAnguloRotacion = new JTextField(5);
        panelControles.add(new JLabel("Ángulo de rotación:"));
        panelControles.add(txtAnguloRotacion);

        // Botón para aplicar rotación
        JButton btnRotar = new JButton("Rotar");
        btnRotar.addActionListener(e -> {
            rotarFigura(Double.parseDouble(txtAnguloRotacion.getText()));
        });
        panelControles.add(btnRotar);

        // 6. Caja de texto que pida el factor de escalado
        JTextField txtFactorEscalado = new JTextField(5);
        panelControles.add(new JLabel("Factor de escalado:"));
        panelControles.add(txtFactorEscalado);

        // Botón para aplicar escalado
        JButton btnEscalar = new JButton("Escalar");
        btnEscalar.addActionListener(e -> {
            escalarFigura(Double.parseDouble(txtFactorEscalado.getText()));
        });
        panelControles.add(btnEscalar);

        // Botón para seleccionar una nueva imagen desde un archivo
        JButton btnSeleccionarImagen = new JButton("Seleccionar Imagen");
        btnSeleccionarImagen.addActionListener(e -> {
            Image nuevaImagen = seleccionarImagen();
            if (nuevaImagen != null) {
                this.imagenActual = nuevaImagen;
                actualizarLienzo();
            }
        });
        panelControles.add(btnSeleccionarImagen);

        controles.add(panelControles, BorderLayout.NORTH);

        add(lienzo, BorderLayout.CENTER);
        add(controles, BorderLayout.SOUTH);
        setVisible(true);
    }

    private Image seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return new ImageIcon(selectedFile.getAbsolutePath()).getImage();
        }

        return null;
    }

    private void trasladarFigura(int dx, int dy) {
        transformacion.translate(dx, dy);
        actualizarLienzo();
    }

    private void rotarFigura(double angulo) {
        transformacion.rotate(Math.toRadians(angulo), imagenActual.getWidth(null) / 2, imagenActual.getHeight(null) / 2);
        actualizarLienzo();
    }

    private void escalarFigura(double factor) {
        transformacion.scale(factor, factor);
        actualizarLienzo();
    }

    private void actualizarLienzo() {
        BufferedImage bi = new BufferedImage(800, 500, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, bi.getWidth(), bi.getHeight());

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imagenActual, transformacion, null);

        this.etiquetaImg.setIcon(new ImageIcon(bi));
    }
}
