package herramientas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.Color;

public class Graficador {
    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String ejeX, ejeY, titulo;

    public Graficador(String ejeX, String ejeY, String titulo) {
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.titulo = titulo;
    }

    public void agregarSerie(String nombre, double[] datos, Color color) {
        XYSeries serie = new XYSeries(nombre);
        // Agregar cada uno de los datos en la serie
        for (int x = 0; x < datos.length; x++) {
            serie.add(x, datos[x]);
        }
        // Agregar la serie que se generó con el color especificado
        this.series.addSeries(serie);
        int serieIndex = this.series.indexOf(serie);
        if (serieIndex >= 0) {
            XYPlot plot = (XYPlot) this.grafica.getPlot();
            plot.getRenderer().setSeriesPaint(serieIndex, color);
        }
    }

    public void crearGrafica() {
        this.grafica = ChartFactory.createXYAreaChart(titulo, ejeX, ejeY, series);
    }

    public void muestraGrafica() {
        ChartFrame frame = new ChartFrame("Histograma de color", grafica);
        frame.setVisible(true);
        frame.setSize(500, 370);
    }
}
