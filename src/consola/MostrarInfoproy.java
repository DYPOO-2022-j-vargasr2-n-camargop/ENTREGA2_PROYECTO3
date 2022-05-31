package consola;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class MostrarInfoproy extends JFrame{

	private PLienzo pLienzo;
	private JScrollPane sp;
	
	public MostrarInfoproy(Ventana1 V) {
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(width/2, height/2);	
	      setLocationRelativeTo(V);		
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		sp = new JScrollPane();
		sp.setBounds(5, 10, this.getWidth(), this.getHeight());
		
		pLienzo = new PLienzo(V.getProyecto());
		pLienzo.setPreferredSize(new Dimension(this.getWidth()+600, this.getHeight()));
		
		sp.setViewportView(pLienzo);
		
		
		this.add(sp,BorderLayout.CENTER);
			
	}
	
}
