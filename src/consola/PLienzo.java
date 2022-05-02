package consola;

import java.awt.Color;

import java.awt.Graphics;
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
			
			
			g.drawString("INFORMACION PROYECTO", (this.getWidth()/2)-100, (this.getHeight()/2)-110);
			g.setColor(new Color(0, 0, 0));
			g.drawString("Nombre Proyecto: "+this.proyecto.getNombre(), (this.getWidth()/2)-95, (this.getHeight()/2)-70);
			g.drawString("Descripcion: "+this.proyecto.getDescripcion(), (this.getWidth()/2)-95, (this.getHeight()/2)-50);
			g.drawString("Fecha Inicio: "+this.proyecto.getFecha_inicio(), (this.getWidth()/2)-95, (this.getHeight()/2)-30);
			g.drawString("Fecha Final: "+this.proyecto.getFecha_final(), (this.getWidth()/2)-95, (this.getHeight()/2)-10);
			g.drawString("Numero Participantes: "+this.proyecto.getParticipantes().size(), (this.getWidth()/2)-95, (this.getHeight()/2)+10);
			g.drawString("Participantes: " + this.proyecto.getParticipantes().keySet(), (this.getWidth()/2)-250, (this.getHeight()/2)+30);
			
			
				
			
		}else {

			g.drawString("NO HAY PROYECTO",(this.getWidth()/2)-70, this.getHeight()/2);
		}
		
	}

	
}
