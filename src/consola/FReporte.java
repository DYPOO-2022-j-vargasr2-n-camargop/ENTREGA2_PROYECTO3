package consola;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import logica.Reporte;

@SuppressWarnings("serial")
public class FReporte extends JFrame {

	private PlienzoReporte pL ;
	private JScrollPane sp;
	
	
	public FReporte(Ventana1 V, String nombre) {
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(width-200, height-200);	
	      setLocationRelativeTo(V);		
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		sp = new JScrollPane();
		sp.setBounds(5, 10, this.getWidth(), this.getHeight());
		
		pL = new PlienzoReporte(V.getProyecto(),nombre);
		pL.setPreferredSize(new Dimension(this.getWidth()+500, this.getHeight()));
		
		sp.setViewportView(pL);
		this.add(sp,BorderLayout.CENTER);
				
		
	}
		
}
