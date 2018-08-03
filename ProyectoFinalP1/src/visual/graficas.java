package visual;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import logico.Empresa;

public class graficas extends JFrame{
		JPanel panel;
	    public graficas(){
	        setTitle("Ventas");
	        setSize(697,460);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setVisible(true);
	        init();
	    }
	 
	    private void init() {
	        panel = new JPanel();
	        getContentPane().add(panel);
	        // Fuente de Datos
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.setValue(11490, "Total Ventas","Total Ventas");
	        dataset.setValue(12560, "Total Facturado","Total Facturado");
	        
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createBarChart3D
	        ("Cantidad de ventas","", "Total", 
	        dataset, PlotOrientation.VERTICAL, true,true, false);
	        chart.setBackgroundPaint(Color.GRAY);
	        chart.getTitle().setPaint(Color.white); 
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(Color.blue); 
	        // Mostrar Grafico
	        ChartPanel chartPanel = new ChartPanel(chart);
	        panel.add(chartPanel);
	    }
	    
	    public static void main(String args[]){
	        new graficas().setVisible(true);
	    }
}
