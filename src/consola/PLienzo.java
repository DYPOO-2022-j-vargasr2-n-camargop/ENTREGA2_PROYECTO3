package consola;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.Proyecto;

@SuppressWarnings("serial")
public class PLienzo extends JPanel {
	
	private Proyecto proyecto;
	
	public PLienzo(Proyecto p) {
		this.proyecto = p;
	}

	public void paint(Graphics g) {
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(0, 0, 255));
		
		if (this.proyecto != null) {
			
			g.drawString("Nombre Proyecto: "+ this.proyecto.getNombre(), ALLBITS, ABORT);
			
			
		}else {

			g.drawString("NO HAY PROYECTO", ALLBITS, ABORT);
		}
		
	}

	
}
