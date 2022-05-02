package consola;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import logica.Reporte;

@SuppressWarnings("serial")
public class FReporte extends JFrame {

	private PlienzoReporte pL ;
	
	public FReporte(Ventana1 V, String nombre) {
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(width/2, height/2);	
	      setLocationRelativeTo(V);		
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		pL = new PlienzoReporte(V.getProyecto(),nombre);
		this.add(pL,BorderLayout.CENTER);
		
	}
		
}
