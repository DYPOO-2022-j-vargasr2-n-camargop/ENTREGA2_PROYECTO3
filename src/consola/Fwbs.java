package consola;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;

import logica.Actividad;
import logica.Proyecto;

public class Fwbs extends JFrame {

	public Fwbs(Ventana1 V) {
		
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int height = pantalla.height;
		int width = pantalla.width;
		setSize(width-400, height-400);	
		setLocationRelativeTo(V);		
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		Proyecto P = V.getProyecto();
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(P.getNombre()); 
		
		HashMap<String, ArrayList<Actividad>> info = P.infowbs();
		
		for (String tarea : info.keySet()) {
			DefaultMutableTreeNode tareaNodo = new DefaultMutableTreeNode(tarea);
			raiz.add(tareaNodo);
			
			for (Actividad Acti : info.get(tarea)) {
				DefaultMutableTreeNode ActiNodo = new DefaultMutableTreeNode(Acti.getTitulo());
				tareaNodo.add(ActiNodo);
			}
		}
		
		
	}
	
	
	
	
}
