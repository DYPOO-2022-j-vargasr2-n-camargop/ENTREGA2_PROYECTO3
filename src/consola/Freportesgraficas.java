package consola;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import logica.Proyecto;

@SuppressWarnings("serial")
public class Freportesgraficas extends JFrame{

	
	

	public Freportesgraficas(Ventana1 V) {
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(width-200, height-200);	 
	      setLocationRelativeTo(V);		
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		CategoryDataset dataset1 = datasetGrafica1(V.getProyecto());
		
		JFreeChart chart1 = ChartFactory.createBarChart("Tiempo Invertido por Participante del Proyecto",
				"Participantes",
				"Tiempo en min",
				dataset1,
				PlotOrientation.VERTICAL,
				true,true,true);
		
		ChartPanel grafica1 = new ChartPanel(chart1);
		grafica1.setMouseWheelEnabled(true);
		grafica1.setPreferredSize(new Dimension((width-500)/2, height-200));
		
		///////////////
		
		PieDataset dataset2 = datasetGrafica2(V.getProyecto());
		
		JFreeChart chart2 = ChartFactory.createPieChart("Tiempo Invertido por Tarea", 
				dataset2,
				true,true,false);
		
		ChartPanel grafica2 = new ChartPanel(chart2);
		grafica2.setMouseWheelEnabled(true);
		grafica2.setPreferredSize(new Dimension((width+90)/2, height-200));
		
		
		this.add(grafica1,BorderLayout.WEST);
		this.add(grafica2,BorderLayout.EAST);
		
	}
	
	
////////////////////////////////////////////////////////////////
	
	public CategoryDataset datasetGrafica1(Proyecto P) {
	
		DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
		HashMap<String,Double> info = P.infografica1();
		int x = 1;
		for (String Parti : info.keySet()) {
			
			dataset.addValue(info.get(Parti), "Participante " + x , Parti);
			x += 1;
		}
		
		return dataset;	
	}
	
	public PieDataset datasetGrafica2(Proyecto P) {
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		HashMap<String,Double> info = P.infografica2();
		for (String Tarea : info.keySet()) {
			
			dataset.setValue(Tarea, info.get(Tarea));
		}
		
		return dataset;	
	}
	
	
	
////////////////////////////////////////////////////////////////
}

