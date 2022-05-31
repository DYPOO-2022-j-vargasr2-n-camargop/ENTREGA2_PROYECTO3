package consola;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import logica.Actividad;
import logica.Proyecto;

public class Fwbs extends JFrame {

	public Fwbs(Ventana1 V) {
		
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int height = pantalla.height;
		int width = pantalla.width;
		setSize(width-750, height-400);	
		setLocationRelativeTo(V);		
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		Proyecto P = V.getProyecto();
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(P.getNombre()); 
		
		DefaultMutableTreeNode infor = new DefaultMutableTreeNode("Informacion");
		raiz.add(infor);
		
		DefaultMutableTreeNode des = new DefaultMutableTreeNode("Descripcion: "+P.getDescripcion());
		infor.add(des);
		
		DefaultMutableTreeNode fi = new DefaultMutableTreeNode("Fecha Inicio: "+P.getFecha_inicio());
		infor.add(fi);
		
		DefaultMutableTreeNode ff = new DefaultMutableTreeNode("Fecha Final: "+P.getFecha_final());
		infor.add(ff);
		
		String Parti = ""; 
		for (String Name : P.getParticipantes().keySet()) {
			Parti = Parti+Name+"|";
		}
		DefaultMutableTreeNode Part = new DefaultMutableTreeNode("Participantes: |"+Parti);
		infor.add(Part);
		
		DefaultMutableTreeNode tareas = new DefaultMutableTreeNode("TAREAS");
		raiz.add(tareas);
		
		HashMap<String, ArrayList<Actividad>> info = P.infowbs();
		
		for (String tarea : info.keySet()) {
			DefaultMutableTreeNode tareaNodo = new DefaultMutableTreeNode(tarea);
			tareas.add(tareaNodo);
			
			DefaultMutableTreeNode infotarea = new DefaultMutableTreeNode("Informacion");
			tareaNodo.add(infotarea);
			
			DefaultMutableTreeNode Actividades = new DefaultMutableTreeNode("Actividades");
			tareaNodo.add(Actividades);
			
			double timeT = 0;
			String respon = "|";
			
			for (Actividad Acti : info.get(tarea)) {
				DefaultMutableTreeNode ActiNodo = new DefaultMutableTreeNode(Acti.getTitulo());
				Actividades.add(ActiNodo);
				
				DefaultMutableTreeNode infoAutor = new DefaultMutableTreeNode("Autor: "+Acti.getAutor());
				ActiNodo.add(infoAutor);
				
				DefaultMutableTreeNode infoDes = new DefaultMutableTreeNode("Descripción: "+Acti.getDescripcion());
				ActiNodo.add(infoDes);
				
				DefaultMutableTreeNode infoTime = new DefaultMutableTreeNode("Tiempo Invertido: "+Acti.getTiempo_invertido()+" min");
				ActiNodo.add(infoTime);
				
				DefaultMutableTreeNode infoDate = new DefaultMutableTreeNode("Fecha: "+Acti.getFecha());
				ActiNodo.add(infoDate);
				
				timeT += Acti.getTiempo_invertido();
				respon = respon+Acti.getAutor()+"|";
			}
			
			DefaultMutableTreeNode Responsables = new DefaultMutableTreeNode("Responsables: "+respon);
			infotarea.add(Responsables);
			DefaultMutableTreeNode TimeTarea = new DefaultMutableTreeNode("Tiempo Invertido: "+timeT+"min");
			infotarea.add(TimeTarea);
			
		}	
		
		
		JTree wbs = new JTree(raiz);
		
		Container laminaWbs = getContentPane();
		laminaWbs.add(new JScrollPane(wbs));
			
	}
	
}


	
