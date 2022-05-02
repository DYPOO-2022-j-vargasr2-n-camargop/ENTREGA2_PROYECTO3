package consola;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import logica.Actividad;
import logica.Participante;
import logica.Proyecto;

public class PmatrizAct extends JPanel implements Observer {

	private Proyecto proyecto;
	
	public PmatrizAct(Proyecto p) {
		this.proyecto = p;
		
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(0,0 , 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(0, 0, 255));
		
		if (proyecto != null ) {
			
			for (Participante par : proyecto.getParticipantes().values()) {
				
				for (ArrayList<Actividad> LisActi : par.getActividades().values()) {
					
					for (Actividad Acti : LisActi) {
						
						
					}
				}
			}
			
		}else{
			
		}
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		this.repaint();
	}

}
