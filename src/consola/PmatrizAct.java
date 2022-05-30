package consola;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logica.Actividad;
import logica.Participante;
import logica.Proyecto;

public class PmatrizAct extends JScrollPane implements Observer {

	private ArrayList<Actividad> actividades;
	
	public PmatrizAct() {
		this.actividades = new ArrayList<Actividad>();
		
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(0, 0, 255));
		g.drawString("MATRIZ ACTIVIDADES", (this.getWidth()/2)-70, 15);
		g.drawString("N°: "+this.actividades.size(), (this.getWidth()/2)+200, 15);
		g.setColor(new Color(0, 0, 0));
		g.drawLine(0, 20, this.getWidth(), 20);
		
		if (this.actividades.size() != 0) {
			
			int n = 2;
			for (Actividad acti : actividades) {
				int ren = 20*n;
				
				g.drawString("Titulo: ", 10, ren-5);g.drawString(acti.getTitulo(), 50, ren-5);
				g.drawString("Autor: ", 200, ren-5);g.drawString(acti.getAutor(), 240, ren-5);
				g.drawString("Tipo: ", 400, ren-5);g.drawString(acti.getTipo(), 440, ren-5);
				g.drawString(acti.getFecha().toString(), 635, ren-5);
				g.drawLine(0, ren, this.getWidth(), ren);
				
				n++;
			}
				
			
			
		}else {
			
			g.setColor(new Color(255, 0, 0));
			g.drawString("NO HAY ACTIVIDADES", (this.getWidth()/2)-70, (this.getHeight()/2)-200);
			
		}
			
		
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.actividades.add((Actividad) arg);
		this.repaint();
		System.out.print("end");
	}

}
