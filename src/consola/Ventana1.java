package consola;

import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logica.Cronometro;
import logica.ManejadorArchivos;
import logica.Participante;
import logica.Proyecto;
import logica.Reporte;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.ScrollPane;

import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Ventana1 extends JFrame {
	
	//Variables Logic
	
	private Proyecto proyecto;
	private Cronometro cronometro;
	
	//Variables  

	private JPanel contentPane;
	private JTextField textField_nombreproyecto;
	private JTextField textField_descrip;
	private JTextField textField_fechaInicio;
	private JTextField textField_fechaFin;
	private JTextField textField_modFechaFin;
	private JTextField textField_nombreparticipante;
	private JTextField textField_correopart;
	private JTextField textField_nombreEliminarPart;
	private JTextField textField_autorActividad;
	private JTextField textField_tituloActividad;
	private JTextField textField_descripcion;
	private JTextField textField_tipoActividad;
	private JTextField textField_AddFechaActividad;
	private JTextField textField_AddHoraInicial;
	private JTextField textField_Addhorafinal;
	private JTextField textField_nombreReporte;
	private JTextField textField_autorCrono;
	private JTextField textField_tituloactCrono;
	private JTextField textField_descripcionCrono;
	private JTextField textField_tipoactCrono;
	private PmatrizAct panelMatrizActividades;
	private JScrollPane sp;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 frame = new Ventana1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	
	public Ventana1() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setAlwaysOnTop(true);
		setTitle("Proyecto 3 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panelCrear = new JPanel();
		scrollPane.setViewportView(panelCrear);
		
		
		JLabel lblCrearProy = new JLabel("Crear Proyecto");
		lblCrearProy.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNombreProy = new JLabel("Nombre del proyecto:");
		
		textField_nombreproyecto = new JTextField();
		textField_nombreproyecto.setColumns(10);
		
		JLabel lblDescripcionDelProyecto = new JLabel("Descripcion del proyecto:");
		
		textField_descrip = new JTextField();
		textField_descrip.setColumns(10);
		
		JLabel lblfechaProy = new JLabel("Fecha Inicio (yyyy-mm-dd):");
		
		textField_fechaInicio = new JTextField();
		textField_fechaInicio.setColumns(10);
		
		JLabel lblfechaFin = new JLabel("Fecha Final (yyyy-mm-dd):");
		
		textField_fechaFin = new JTextField();
		textField_fechaFin.setColumns(10);
		
/////////////////////////////////////
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crear_proyecto();
				
			}

			
		});
		btnCrear.setBackground(new Color(135, 206, 235));
		
		JPanel panelModFechaFin = new JPanel();
		
		JLabel lblModFechafin = new JLabel("Modificar fecha final del Proyecto");
		lblModFechafin.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblfechafinmod = new JLabel("Fecha Final (yyyy-mm-dd):");
		
		textField_modFechaFin = new JTextField();
		textField_modFechaFin.setColumns(10);
		
		JButton btnModifica = new JButton("Modificar");
		btnModifica.setBackground(new Color(135, 206, 250));
		GroupLayout gl_panelModFechaFin = new GroupLayout(panelModFechaFin);
		gl_panelModFechaFin.setHorizontalGroup(
			gl_panelModFechaFin.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelModFechaFin.createSequentialGroup()
					.addGroup(gl_panelModFechaFin.createParallelGroup(Alignment.LEADING)
						.addComponent(lblModFechafin, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelModFechaFin.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnModifica)
							.addGroup(gl_panelModFechaFin.createSequentialGroup()
								.addComponent(lblfechafinmod, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_modFechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(170, Short.MAX_VALUE))
		);
		gl_panelModFechaFin.setVerticalGroup(
			gl_panelModFechaFin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelModFechaFin.createSequentialGroup()
					.addComponent(lblModFechafin)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelModFechaFin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblfechafinmod)
						.addComponent(textField_modFechaFin, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addComponent(btnModifica))
		);
		panelModFechaFin.setLayout(gl_panelModFechaFin);
		
/////////////////////////////////////
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modificar_fecha();	
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator2 = new JSeparator();
		
		JPanel panelAgregarParticipante = new JPanel();
		
		JLabel lblAddparticipante = new JLabel("Agregar Participante");
		lblAddparticipante.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblnombreparticipante = new JLabel("Nombre del participante:");
		
		textField_nombreparticipante = new JTextField();
		textField_nombreparticipante.setColumns(10);
		
		JLabel lblcorreopart = new JLabel("Correo del participante:");
		
		textField_correopart = new JTextField();
		textField_correopart.setColumns(10);
		
		JButton btnAgregar1 = new JButton("Agregar");
		btnAgregar1.setBackground(new Color(135, 206, 250));
		GroupLayout gl_panelAgregarParticipante = new GroupLayout(panelAgregarParticipante);
		gl_panelAgregarParticipante.setHorizontalGroup(
			gl_panelAgregarParticipante.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAgregarParticipante.createSequentialGroup()
					.addGroup(gl_panelAgregarParticipante.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAgregarParticipante.createSequentialGroup()
							.addGroup(gl_panelAgregarParticipante.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblcorreopart, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblnombreparticipante, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelAgregarParticipante.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_correopart)
								.addComponent(textField_nombreparticipante, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
								.addComponent(btnAgregar1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblAddparticipante, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		gl_panelAgregarParticipante.setVerticalGroup(
			gl_panelAgregarParticipante.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAgregarParticipante.createSequentialGroup()
					.addComponent(lblAddparticipante)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAgregarParticipante.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblnombreparticipante)
						.addComponent(textField_nombreparticipante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAgregarParticipante.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblcorreopart)
						.addComponent(textField_correopart, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAgregar1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelAgregarParticipante.setLayout(gl_panelAgregarParticipante);
		
/////////////////////////////////////
		btnAgregar1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				agregar_participante();
				
			}
		});
		
		JSeparator separator3 = new JSeparator();
		
		JPanel panelEliminarParticipante = new JPanel();
		
		JLabel lblEliminarParticipante = new JLabel("Eliminar Participante");
		lblEliminarParticipante.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblnombreElimParticipante = new JLabel("Nombre del participante:");
		
		textField_nombreEliminarPart = new JTextField();
		textField_nombreEliminarPart.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(135, 206, 250));
		GroupLayout gl_panelEliminarParticipante = new GroupLayout(panelEliminarParticipante);
		gl_panelEliminarParticipante.setHorizontalGroup(
			gl_panelEliminarParticipante.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEliminarParticipante.createSequentialGroup()
					.addComponent(lblEliminarParticipante, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panelEliminarParticipante.createSequentialGroup()
					.addGroup(gl_panelEliminarParticipante.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelEliminarParticipante.createSequentialGroup()
							.addComponent(lblnombreElimParticipante)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_nombreEliminarPart, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
						.addGroup(gl_panelEliminarParticipante.createSequentialGroup()
							.addContainerGap(303, Short.MAX_VALUE)
							.addComponent(btnEliminar)))
					.addGap(24))
		);
		gl_panelEliminarParticipante.setVerticalGroup(
			gl_panelEliminarParticipante.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEliminarParticipante.createSequentialGroup()
					.addComponent(lblEliminarParticipante)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelEliminarParticipante.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblnombreElimParticipante)
						.addComponent(textField_nombreEliminarPart, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEliminar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelEliminarParticipante.setLayout(gl_panelEliminarParticipante);
		
/////////////////////////////////////
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminar_participante();
				
			}
		});
		
		JSeparator separator4 = new JSeparator();
		
		JPanel panelMostrarInfo = new JPanel();
		
/////////////////////////////////////		
		JButton btnMostrarInfo = new JButton("Mostrar Informacion del proyecto");
		btnMostrarInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostar_info();	
			}
		});
		
		JSeparator separator5 = new JSeparator();
		
		JPanel panelAgregarActividad = new JPanel();
		
		JSeparator separator6 = new JSeparator();
		
		JPanel panelReporte = new JPanel();
		
		JSeparator separator7 = new JSeparator();
		
		JPanel panelCronometro = new JPanel();
		
		JLabel lblcronometro = new JLabel("Cronometro");
		lblcronometro.setFont(new Font("Tahoma", Font.BOLD, 11));
		JLabel lblEstadoCrono = new JLabel("ESTADO");

		JLabel lblNombreautorCrono = new JLabel("Nombre del autor de la actividad:");
		
		textField_autorCrono = new JTextField();
		textField_autorCrono.setColumns(10);
		
		JLabel lblTitulocrono = new JLabel("Titulo de la actividad:");
		
		textField_tituloactCrono = new JTextField();
		textField_tituloactCrono.setColumns(10);
		
		JLabel lblDescripcionCrono = new JLabel("Descripcion:");
		
		textField_descripcionCrono = new JTextField();
		textField_descripcionCrono.setColumns(10);
		
		JLabel lblTipoActividadcrono = new JLabel("Tipo de actividad:");
		
		textField_tipoactCrono = new JTextField();
		textField_tipoactCrono.setColumns(10);
		
		JButton btnAgregar3 = new JButton("Agregar");
		btnAgregar3.setBackground(new Color(135, 206, 250));
		
/////////////////////////////////////////////////////////////////////////////
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {

@Override
		public void actionPerformed(ActionEvent e) {
			iniciar();
			lblEstadoCrono.setText("Iniciado");
			lblEstadoCrono.repaint();
		
		}
		});
	
		JButton btnPausar = new JButton("Pausar");
		btnPausar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			pausar();
			lblEstadoCrono.setText("Pausado");
			lblEstadoCrono.repaint();
			}
		});
	
	
		JButton btnReanudar = new JButton("Reanudar");
		btnReanudar.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			reanudar();
			lblEstadoCrono.setText("Reanudado");
			lblEstadoCrono.repaint();
			}
		});
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			terminar();
			double d = Ventana1.this.cronometro.getTiempo_invertido();
			lblEstadoCrono.setText("End:"+ Math.round(d*100.0)/100.0 +" min");
			lblEstadoCrono.repaint();
	
			}
		});
/////////////////////////////////////////////////////////////////////////////
		btnAgregar3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addcrono();
				
			}
		});
		
/////////////////////////////////////////////////////////////////////////////
		lblEstadoCrono.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panelCronometro = new GroupLayout(panelCronometro);
		gl_panelCronometro.setHorizontalGroup(
			gl_panelCronometro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCronometro.createSequentialGroup()
					.addGroup(gl_panelCronometro.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCronometro.createSequentialGroup()
							.addComponent(btnIniciar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPausar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReanudar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTerminar))
						.addGroup(gl_panelCronometro.createSequentialGroup()
							.addComponent(lblNombreautorCrono)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_autorCrono, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
						.addGroup(gl_panelCronometro.createSequentialGroup()
							.addComponent(lblTitulocrono)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_tituloactCrono, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
						.addGroup(gl_panelCronometro.createSequentialGroup()
							.addComponent(lblDescripcionCrono, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField_descripcionCrono, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCronometro.createSequentialGroup()
							.addComponent(lblTipoActividadcrono, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_tipoactCrono, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCronometro.createSequentialGroup()
							.addContainerGap(317, Short.MAX_VALUE)
							.addComponent(btnAgregar3))
						.addGroup(gl_panelCronometro.createSequentialGroup()
							.addComponent(lblcronometro, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(225)
							.addComponent(lblEstadoCrono, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelCronometro.setVerticalGroup(
			gl_panelCronometro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCronometro.createSequentialGroup()
					.addGroup(gl_panelCronometro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblcronometro)
						.addComponent(lblEstadoCrono))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCronometro.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIniciar)
						.addComponent(btnPausar)
						.addComponent(btnReanudar)
						.addComponent(btnTerminar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCronometro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreautorCrono)
						.addComponent(textField_autorCrono, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCronometro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitulocrono)
						.addComponent(textField_tituloactCrono, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCronometro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescripcionCrono)
						.addComponent(textField_descripcionCrono, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCronometro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoActividadcrono)
						.addComponent(textField_tipoactCrono, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAgregar3)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
//
		panelCronometro.setLayout(gl_panelCronometro);
		
		JSeparator separator7_1 = new JSeparator();
		
		JButton btnCargartodo = new JButton("Cargar");
		btnCargartodo.setBackground(new Color(135, 206, 250));
///////////////////////////////////////////////////////////////////////
		btnCargartodo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cargardatos();
			}
		});
	
		
		JButton btnGuardartodo = new JButton("Guardar");
		btnGuardartodo.setBackground(new Color(135, 206, 250));
		
		btnGuardartodo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guardardatos();
				
			}
		});
		
		JPanel panelWBS = new JPanel();
		panelWBS.setBorder(new LineBorder(new Color(0, 0, 0)));
		
///////////////////////////////////////////////////////////////////////

		
		GroupLayout gl_panelCrear = new GroupLayout(panelCrear);
		gl_panelCrear.setHorizontalGroup(
			gl_panelCrear.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrear.createSequentialGroup()
					.addGroup(gl_panelCrear.createParallelGroup(Alignment.LEADING)
						.addComponent(panelAgregarActividad, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_panelCrear.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panelEliminarParticipante, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(panelMostrarInfo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)))
					.addContainerGap(285, Short.MAX_VALUE))
				.addGroup(gl_panelCrear.createSequentialGroup()
					.addGroup(gl_panelCrear.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCrear.createSequentialGroup()
							.addContainerGap(345, Short.MAX_VALUE)
							.addComponent(btnCrear))
						.addGroup(gl_panelCrear.createSequentialGroup()
							.addComponent(lblDescripcionDelProyecto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_descrip, 279, 279, 279))
						.addGroup(gl_panelCrear.createSequentialGroup()
							.addComponent(lblNombreProy)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_nombreproyecto, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCrear.createSequentialGroup()
							.addGroup(gl_panelCrear.createParallelGroup(Alignment.LEADING)
								.addComponent(lblfechaFin, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblfechaProy))
							.addGap(18)
							.addGroup(gl_panelCrear.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_fechaFin, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
								.addComponent(textField_fechaInicio, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))))
					.addGap(273))
				.addGroup(gl_panelCrear.createSequentialGroup()
					.addComponent(panelReporte, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(285, Short.MAX_VALUE))
				.addGroup(gl_panelCrear.createSequentialGroup()
					.addComponent(lblCrearProy, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panelCrear.createSequentialGroup()
					.addComponent(panelCronometro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panelCrear.createSequentialGroup()
					.addComponent(separator7_1, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panelCrear.createSequentialGroup()
					.addGap(81)
					.addComponent(btnCargartodo, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnGuardartodo, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
				.addGroup(gl_panelCrear.createSequentialGroup()
					.addGroup(gl_panelCrear.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(separator4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator6, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator5, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator7, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
					.addContainerGap(174, Short.MAX_VALUE))
				.addGroup(gl_panelCrear.createSequentialGroup()
					.addGroup(gl_panelCrear.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panelCrear.createSequentialGroup()
							.addComponent(panelModFechaFin, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelWBS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(panelAgregarParticipante, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(separator2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
					.addContainerGap(272, Short.MAX_VALUE))
		);
		gl_panelCrear.setVerticalGroup(
			gl_panelCrear.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrear.createSequentialGroup()
					.addComponent(lblCrearProy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrear.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreProy)
						.addComponent(textField_nombreproyecto, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrear.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescripcionDelProyecto)
						.addComponent(textField_descrip, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrear.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_fechaInicio, 0, 0, Short.MAX_VALUE)
						.addComponent(lblfechaProy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(12)
					.addGroup(gl_panelCrear.createParallelGroup(Alignment.LEADING)
						.addComponent(lblfechaFin)
						.addComponent(textField_fechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addComponent(btnCrear)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrear.createParallelGroup(Alignment.LEADING)
						.addComponent(panelModFechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelWBS, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator2, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAgregarParticipante, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator3, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelEliminarParticipante, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator4, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelMostrarInfo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(separator6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAgregarActividad, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(separator5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelReporte, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator7, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCronometro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator7_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrear.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardartodo)
						.addComponent(btnCargartodo))
					.addContainerGap(230, Short.MAX_VALUE))
		);
		
		JButton btnWBS = new JButton("Generar WBS");
		btnWBS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnReporteGraficas = new JButton("Reporte Graficas");
		GroupLayout gl_panelWBS = new GroupLayout(panelWBS);
		gl_panelWBS.setHorizontalGroup(
			gl_panelWBS.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWBS.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_panelWBS.createParallelGroup(Alignment.LEADING)
						.addComponent(btnWBS)
						.addComponent(btnReporteGraficas))
					.addGap(55))
		);
		gl_panelWBS.setVerticalGroup(
			gl_panelWBS.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelWBS.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnReporteGraficas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnWBS)
					.addContainerGap())
		);
		panelWBS.setLayout(gl_panelWBS);

		JLabel lblRealizarReporte = new JLabel("Realizar Reporte");
		lblRealizarReporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblnombreReporte = new JLabel("Nombre del participante que quiere el reporte:");
		
		textField_nombreReporte = new JTextField();
		textField_nombreReporte.setColumns(10);
		
		JButton btnRealizar = new JButton("Realizar");
		btnRealizar.setBackground(new Color(135, 206, 250));
		btnRealizar.setEnabled(true);
		GroupLayout gl_panelReporte = new GroupLayout(panelReporte);
		gl_panelReporte.setHorizontalGroup(
			gl_panelReporte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReporte.createSequentialGroup()
					.addGroup(gl_panelReporte.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRealizarReporte, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelReporte.createSequentialGroup()
							.addComponent(lblnombreReporte)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_nombreReporte, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panelReporte.createSequentialGroup()
							.addContainerGap(297, Short.MAX_VALUE)
							.addComponent(btnRealizar)))
					.addContainerGap())
		);
		gl_panelReporte.setVerticalGroup(
			gl_panelReporte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReporte.createSequentialGroup()
					.addComponent(lblRealizarReporte)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelReporte.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblnombreReporte)
						.addComponent(textField_nombreReporte, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRealizar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelReporte.setLayout(gl_panelReporte);
		GroupLayout gl_panelMostrarInfo = new GroupLayout(panelMostrarInfo);
		gl_panelMostrarInfo.setHorizontalGroup(
			gl_panelMostrarInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMostrarInfo.createSequentialGroup()
					.addGap(75)
					.addComponent(btnMostrarInfo, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
///////////////////////////////////////////////////////7
		btnRealizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				realizar_reporte();
				
			}
		});
		
		gl_panelMostrarInfo.setVerticalGroup(
			gl_panelMostrarInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMostrarInfo.createSequentialGroup()
					.addComponent(btnMostrarInfo)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelMostrarInfo.setLayout(gl_panelMostrarInfo);
		
		JLabel lblAgregarActividad = new JLabel("Agregar Actividad");
		lblAgregarActividad.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNombreAutor = new JLabel("Nombre del autor de la actividad:");
		
		textField_autorActividad = new JTextField();
		textField_autorActividad.setColumns(10);
		
		JLabel lblTituloActividad = new JLabel("Titulo de la actividad:");
		
		textField_tituloActividad = new JTextField();
		textField_tituloActividad.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		
		textField_descripcion = new JTextField();
		textField_descripcion.setColumns(10);
		
		JLabel lblTipoActividad = new JLabel("Tipo de Actividad:");
		
		textField_tipoActividad = new JTextField();
		textField_tipoActividad.setColumns(10);
		
		JLabel lblFechaAgregarActividad = new JLabel("Fecha (yyyy-mm-dd):");
		
		textField_AddFechaActividad = new JTextField();
		textField_AddFechaActividad.setText("");
		textField_AddFechaActividad.setColumns(10);
		
		JLabel lblHorainicial_add = new JLabel("Hora inicial (hh:mm:ss):");
		
		textField_AddHoraInicial = new JTextField();
		textField_AddFechaActividad.setText("");
		textField_AddHoraInicial.setColumns(10);
		
		JLabel lblAddhorafinal = new JLabel("Hora final (hh:mm:ss):");
		
		textField_Addhorafinal = new JTextField();
		textField_Addhorafinal.setColumns(10);
		
		JButton btnAgregar2 = new JButton("Agregar");
		btnAgregar2.setBackground(new Color(135, 206, 250));
		GroupLayout gl_panelAgregarActividad = new GroupLayout(panelAgregarActividad);
		gl_panelAgregarActividad.setHorizontalGroup(
			gl_panelAgregarActividad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAgregarActividad.createSequentialGroup()
					.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panelAgregarActividad.createSequentialGroup()
								.addComponent(lblNombreAutor)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_autorActividad, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelAgregarActividad.createSequentialGroup()
								.addComponent(lblTituloActividad, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_tituloActividad))
							.addGroup(gl_panelAgregarActividad.createSequentialGroup()
								.addComponent(lblDescripcion, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_descripcion))
							.addGroup(gl_panelAgregarActividad.createSequentialGroup()
								.addComponent(lblTipoActividad, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_tipoActividad))
							.addGroup(gl_panelAgregarActividad.createSequentialGroup()
								.addComponent(lblFechaAgregarActividad, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_AddFechaActividad, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblAgregarActividad, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelAgregarActividad.createSequentialGroup()
							.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblAddhorafinal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblHorainicial_add, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_Addhorafinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_AddHoraInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelAgregarActividad.createSequentialGroup()
					.addContainerGap(297, Short.MAX_VALUE)
					.addComponent(btnAgregar2)
					.addContainerGap())
		);
		gl_panelAgregarActividad.setVerticalGroup(
			gl_panelAgregarActividad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAgregarActividad.createSequentialGroup()
					.addComponent(lblAgregarActividad)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_autorActividad, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombreAutor))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTituloActividad)
						.addComponent(textField_tituloActividad, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescripcion)
						.addComponent(textField_descripcion, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoActividad)
						.addComponent(textField_tipoActividad, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaAgregarActividad)
						.addComponent(textField_AddFechaActividad, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAgregarActividad.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHorainicial_add)
								.addComponent(textField_AddHoraInicial, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelAgregarActividad.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAddhorafinal)
								.addComponent(textField_Addhorafinal, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(28, Short.MAX_VALUE))
						.addGroup(gl_panelAgregarActividad.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAgregar2)
							.addContainerGap())))
		);
		panelAgregarActividad.setLayout(gl_panelAgregarActividad);
		panelCrear.setLayout(gl_panelCrear);
		contentPane.setSize(400,2000);
		
		//JPanel panelMatrizActividades = new JPanel();
		
	
		
		panelMatrizActividades = new PmatrizAct() ;
		panelMatrizActividades.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelMatrizActividades, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelMatrizActividades, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE))
					.addContainerGap(238, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
//////////////////////////////////////////////////////////////////////////
		btnAgregar2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				agregar_actividad();
			}
		});
		
	} //////////////INPUTS/////////////////


	protected void realizar_reporte() {

		String nombre = textField_nombreReporte.getText();
		FReporte F = new FReporte(this,nombre);
		F.setVisible(true);
		textField_nombreReporte.setText("");
		
	}


	protected void guardardatos() {
		ManejadorArchivos ma = new ManejadorArchivos();
		ma.guardar_proyecto(this.proyecto);
		ma.guardar_participantes(this.proyecto);
		ma.guardar_actividades(this.proyecto);
	}


	protected void cargardatos() {
		ManejadorArchivos ma = new ManejadorArchivos();
		this.proyecto = ma.leer_proyecto(this.proyecto);
		ma.leer_participantes(this.proyecto);
		for (Participante par : this.proyecto.getParticipantes().values()) {
			par.addObserver(panelMatrizActividades);
		}
		ma.leer_actividades(this.proyecto);	
		
	}


	protected void addcrono() {
		String autor = this.textField_autorCrono.getText();
		String titulo = this.textField_tituloactCrono.getText();
		String descripcion = this.textField_descripcionCrono.getText();
		String tipo = this.textField_tipoactCrono.getText();
		Cronometro c = this.cronometro;
		
		this.proyecto.getParticipantes().get(autor).agregar_actividadActividad_Crono(titulo, descripcion, autor, tipo,c.getFecha(),
				c.getHora_inicio(), c.getHora_final(), c.getTiempo_invertido());
		
		this.textField_autorCrono.setText("");
		this.textField_tituloactCrono.setText("");
		this.textField_descripcionCrono.setText("");
		this.textField_tipoactCrono.setText("");
	}


	protected void mostar_info() {
		MostrarInfoproy F = new MostrarInfoproy(this);
		F.setVisible(true);
		
	}


	protected void iniciar() {
		this.cronometro = new Cronometro();
		this.cronometro.iniciar_crono();
		
	}


	protected void pausar() {
		this.cronometro.pausar_crono();
	}


	protected void reanudar() {
		this.cronometro.reanudar();
	}


	protected void terminar() {
		this.cronometro.terminar_crono();
	}


	protected void agregar_actividad() {
		String autor = this.textField_autorActividad.getText();
		String titulo = this.textField_tituloActividad.getText();
		String descripcion = this.textField_descripcion.getText();
		String tipo = this.textField_tipoActividad.getText();
		String fecha = this.textField_AddFechaActividad.getText();
		String Horai = this.textField_AddHoraInicial.getText();
		String Horaf = this.textField_Addhorafinal.getText();
		
		if (fecha.equals("")) {
			if (Horai.equals("")) {
				this.proyecto.getParticipantes().get(autor).agregar_actividadActividad_valorespordefecto(titulo, descripcion, autor, tipo, Horaf);
			}
		}
		else {
			this.proyecto.getParticipantes().get(autor).agregar_actividadActividad_valoresmodificados(titulo, descripcion, autor, tipo, fecha, Horai, Horaf);
		}
		
		this.textField_autorActividad.setText("");
		this.textField_tituloActividad.setText("");
		this.textField_descripcion.setText("");
		this.textField_tipoActividad.setText("");
		this.textField_AddFechaActividad.setText("");
		this.textField_AddHoraInicial.setText("");
		this.textField_Addhorafinal.setText("");
		
	}


	protected void eliminar_participante() {
		
		String nombre = this.textField_nombreEliminarPart.getText();
		this.proyecto.eliminar_participante(nombre);
		this.textField_nombreEliminarPart.setText("");
	}


	protected void agregar_participante() {
		
		String nombre = this.textField_nombreparticipante.getText();
		String correo = this.textField_correopart.getText();
		this.proyecto.agregar_participante(nombre, correo);
		this.proyecto.getParticipantes().get(nombre).addObserver(panelMatrizActividades);
		this.textField_nombreparticipante.setText("");
		this.textField_correopart.setText("");
		
	}


	protected void modificar_fecha() {
		
		String fechaf_mod = this.textField_modFechaFin.getText();
		this.proyecto.setFecha_final(fechaf_mod);
		this.textField_modFechaFin.setText("");
		
	}

	

	protected void crear_proyecto() {
		String nombre = this.textField_nombreproyecto.getText();
		String descripcion = this.textField_descrip.getText();
		String fechai = this.textField_fechaInicio.getText();
		String fechaf = this.textField_fechaFin.getText();
		if (fechaf.equals("")){
			this.proyecto = new Proyecto(nombre, descripcion, fechai, fechai);
		}else {
			this.proyecto = new Proyecto(nombre, descripcion, fechai, fechaf);
		}
		this.textField_nombreproyecto.setText("");
		this.textField_descrip.setText("");
		this.textField_fechaInicio.setText("");
		this.textField_fechaFin.setText("");
		
	}


	public Proyecto getProyecto() {
		return proyecto;
	}	
}
