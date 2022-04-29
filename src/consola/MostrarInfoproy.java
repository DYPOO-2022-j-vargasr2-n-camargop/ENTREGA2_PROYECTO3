package consola;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MostrarInfoproy extends JFrame{

	private PLienzo pLienzo;
	
	public MostrarInfoproy(Ventana1 V) {
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(width/2, height/2);	
	      setLocationRelativeTo(V);		
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		pLienzo = new PLienzo(V.getProyecto());
		this.add(pLienzo,BorderLayout.CENTER);
			
	}
	
}
