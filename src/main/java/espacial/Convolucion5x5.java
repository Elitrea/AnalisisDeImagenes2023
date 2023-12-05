package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartColor;

/**
 * Clase para realizar convoluciones 5x5 en imágenes.
 * TODO: Tenemos que determinar el divisor
 * Offset: es un valor que se añade al resultado
 */
public class Convolucion5x5 {
    // Máscaras de detección de bordes
    private BufferedImage imagenOriginal;

    public Convolucion5x5(BufferedImage imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
    }

    /**
     * Realiza la convolución de la imagen con la máscara dada y el divisor especificado.
     *
     * @param mascara Máscara de convolución
     * @param div     Divisor
     * @param offset  Valor que se añade al resultado
     * @return Imagen resultante después de la convolución
     */
    public Image convolucionar(int[] mascara, int div, int offset) {
        Color nuevo;
        BufferedImage aux2 = new BufferedImage(this.imagenOriginal.getWidth(), this.imagenOriginal.getHeight(), BufferedImage.TYPE_INT_RGB);

        // El proceso de convolución se realiza para todos los píxeles
        for (int x = 0; x < this.imagenOriginal.getWidth(); x++) {
            for (int y = 0; y < this.imagenOriginal.getHeight(); y++) {
                // Tenemos un nuevo tono
                int rgb = convolucionar(x, y, mascara, div, offset);
                nuevo = new Color(rgb);
                aux2.setRGB(x, y, nuevo.getRGB());
            }
        }
        return herramientas.HerramientasImagen.toImage(aux2);
    }

    private int convolucionar(int x, int y, int[] mascara, int div, int offset) {
        Color aux;
        int aR = 0, aG = 0, aB = 0;
        aux = new Color(this.imagenOriginal.getRGB(x, y));

        for (int j = 0; j < mascara.length; j++) {
            // Canales
            int rgb = obtenerRGB(x, y, j);
            if (rgb != 0) {
                aux = new Color(rgb);
                aR += aux.getRed() * mascara[j];
                aG += aux.getGreen() * mascara[j];
                aB += aux.getBlue() * mascara[j];
            }
        }

        // Evaluar la división y añadir el offset
        aR = validar(aR / div + offset);
        aG = validar(aG / div + offset);
        aB = validar(aB / div + offset);

        aux = new Color(aR, aG, aB);
        return aux.getRGB();
    }

    private int obtenerRGB(int x, int y, int j) {
        int rgb = 0;
        try {
            switch (j) {
                case 0: {
                    if ((x - 2 < 0) || (y - 2 < 0)) return 0;
                    if ((x - 2 >= this.imagenOriginal.getWidth()) || (y - 2 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x - 2, y - 2);
                    break;
                }
                case 1: {
                    if ((x - 2 < 0) || (y - 1 < 0)) return 0;
                    if ((x - 2 >= this.imagenOriginal.getWidth()) || (y - 1 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x - 2, y - 1);
                    break;
                }
                case 2: {
                    if ((x - 2 < 0) || (y < 0)) return 0;
                    if ((x - 2 >= this.imagenOriginal.getWidth()) || (y >= this.imagenOriginal.getHeight())) return 0;
                    rgb = this.imagenOriginal.getRGB(x - 2, y);
                    break;
                }
                case 3: {
                    if ((x - 2 < 0) || (y + 1 < 0)) return 0;
                    if ((x - 2 >= this.imagenOriginal.getWidth()) || (y + 1 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x - 2, y + 1);
                    break;
                }
                case 4: {
                    if ((x - 2 < 0) || (y + 2 < 0)) return 0;
                    if ((x - 2 >= this.imagenOriginal.getWidth()) || (y + 2 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x - 2, y + 2);
                    break;
                }
                case 5: {
                    if ((x - 1 < 0) || (y - 2 < 0)) return 0;
                    if ((x - 1 >= this.imagenOriginal.getWidth()) || (y - 2 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x - 1, y - 2);
                    break;
                }
                case 6: {
                    if ((x - 1 < 0) || (y - 1 < 0)) return 0;
                    if ((x - 1 >= this.imagenOriginal.getWidth()) || (y - 1 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x - 1, y - 1);
                    break;
                }
                case 7: {
                    if ((x - 1 < 0) || (y < 0)) return 0;
                    if ((x - 1 >= this.imagenOriginal.getWidth()) || (y >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x - 1, y);
                    break;
                }
                case 8: {
                    if ((x - 1 < 0) || (y + 1 < 0)) return 0;
                    if ((x - 1 >= this.imagenOriginal.getWidth()) || (y + 1 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x - 1, y + 1);
                    break;
                }
                case 9: {
                    if ((x - 1 < 0) || (y + 2 < 0)) return 0;
                    if ((x - 1 >= this.imagenOriginal.getWidth()) || (y + 2 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x - 1, y + 2);
                    break;
                }
                case 10: {
                    if ((x < 0) || (y - 2 < 0)) return 0;
                    if ((x >= this.imagenOriginal.getWidth()) || (y - 2 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x, y - 2);
                    break;
                }
                case 11: {
                    if ((x < 0) || (y - 1 < 0)) return 0;
                    if ((x >= this.imagenOriginal.getWidth()) || (y - 1 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x, y - 1);
                    break;
                }
                case 12: {
                    if ((x < 0) || (y < 0)) return 0;
                    if ((x >= this.imagenOriginal.getWidth()) || (y >= this.imagenOriginal.getHeight())) return 0;
                    rgb = this.imagenOriginal.getRGB(x, y);
                    break;
                }
                case 13: {
                    if ((x < 0) || (y + 1 < 0)) return 0;
                    if ((x >= this.imagenOriginal.getWidth()) || (y + 1 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x, y + 1);
                    break;
                }
                case 14: {
                    if ((x < 0) || (y + 2 < 0)) return 0;
                    if ((x >= this.imagenOriginal.getWidth()) || (y + 2 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x, y + 2);
                    break;
                }
                case 15: {
                    if ((x + 1 < 0) || (y - 2 < 0)) return 0;
                    if ((x + 1 >= this.imagenOriginal.getWidth()) || (y - 2 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x + 1, y - 2);
                    break;
                }
                case 16: {
                    if ((x + 1 < 0) || (y - 1 < 0)) return 0;
                    if ((x + 1 >= this.imagenOriginal.getWidth()) || (y - 1 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x + 1, y - 1);
                    break;
                }
                case 17: {
                    if ((x + 1 < 0) || (y < 0)) return 0;
                    if ((x + 1 >= this.imagenOriginal.getWidth()) || (y >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x + 1, y);
                    break;
                }
                case 18: {
                    if ((x + 1 < 0) || (y + 1 < 0)) return 0;
                    if ((x + 1 >= this.imagenOriginal.getWidth()) || (y + 1 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x + 1, y + 1);
                    break;
                }
                case 19: {
                    if ((x + 1 < 0) || (y + 2 < 0)) return 0;
                    if ((x + 1 >= this.imagenOriginal.getWidth()) || (y + 2 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x + 1, y + 2);
                    break;
                }
                case 20: {
                    if ((x + 2 < 0) || (y - 2 < 0)) return 0;
                    if ((x + 2 >= this.imagenOriginal.getWidth()) || (y - 2 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x + 2, y - 2);
                    break;
                }
                case 21: {
                    if ((x + 2 < 0) || (y - 1 < 0)) return 0;
                    if ((x + 2 >= this.imagenOriginal.getWidth()) || (y - 1 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x + 2, y - 1);
                    break;
                }
                case 22: {
                    if ((x + 2 < 0) || (y < 0)) return 0;
                    if ((x + 2 >= this.imagenOriginal.getWidth()) || (y >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x + 2, y);
                    break;
                }
                case 23: {
                    if ((x + 2 < 0) || (y + 1 < 0)) return 0;
                    if ((x + 2 >= this.imagenOriginal.getWidth()) || (y + 1 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x + 2, y + 1);
                    break;
                }
                case 24: {
                    if ((x + 2 < 0) || (y + 2 < 0)) return 0;
                    if ((x + 2 >= this.imagenOriginal.getWidth()) || (y + 2 >= this.imagenOriginal.getHeight()))
                        return 0;
                    rgb = this.imagenOriginal.getRGB(x + 2, y + 2);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println();
        }

        return rgb;
    }

    private static int validar(int i) {
        if (i > 255) return 255;
        if (i < 0) return 0;
        else return i;
    }
}