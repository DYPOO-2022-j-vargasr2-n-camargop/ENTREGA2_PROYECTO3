package consola;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import logica.Proyecto;
import logica.Reporte;

@SuppressWarnings("serial")
public class PlienzoReporte extends JPanel {

	
	private Proyecto proyecto;
	private String nombre;
	private Reporte rep;
	
	public PlienzoReporte(Proyecto p,String nombre) {
		this.proyecto = p ;
		this.nombre = nombre;
	}
	
	@Override
	public void paint(Graphics g) {

		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(255, 0, 0));
		
		if (this.proyecto != null) {
			
			rep = this.proyecto.realizar_reporte_participante(nombre);
			g.drawString("REPORTE" , this.getWidth()/2-40, this.getHeight()/2-130);
			g.setColor(new Color(0, 0, 0));
			g.drawString("Nombre del Participante: ["+nombre+"] (Tiempo en minutos)" , this.getWidth()/2-140, this.getHeight()/2-80);
			g.drawString("Tiempo Invertido: "+ rep.getTiempo_invertido(), this.getWidth()/2-100, this.getHeight()/2-60);
			g.drawString("Tiempo promedio por tipo de Actividad: "+rep.getTiempo_invertido_tipo() , this.getWidth()/2-300, this.getHeight()/2-30);
			g.drawString("Tiempo Invertido por dia: " + rep.getTiempo_invertido_dia(), this.getWidth()/2-300, this.getHeight()/2-10);
			
	
			
			
			
			
			
		}else {
			
			g.drawString("NO HAY PROYECTO", this.getWidth()/2-100, this.getHeight()/2);
		}
		
		
	}


}
