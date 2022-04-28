package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import logica.Cronometro;
import logica.ManejadorArchivos;
import logica.Participante;
import logica.Proyecto;
import logica.Reporte;

public class consola {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Proyecto proyecto;
//------------------------------------------
	public void crear_proyecto() {
		try {
			System.out.println("\nCrear Proyecto ");
			System.out.println("Nombre del Proyecto: ");
			String nombre = this.br.readLine();
			System.out.println("Descripcion del Proyecto: ");
			String descripcion = this.br.readLine();
			System.out.println("Ingrese la fecha de Inicio del Proyecto:(yyyy-mm-dd)");
			String fecha_inicio = this.br.readLine();
			System.out.println("¿Conoce la fecha de Fin del Proyecto?\n"
					+"1. Si\n"+"2. No\n");
			int op = Integer.parseInt(this.br.readLine());
			if (op == 1) {
				System.out.println("Ingrese la fecha de Fin del Proyecto:(yyyy-mm-dd)");
				String fecha_final = this.br.readLine();
				this.proyecto = new Proyecto(nombre, descripcion,fecha_inicio,fecha_final);
			}else if (op == 2){
				this.proyecto = new Proyecto(nombre, descripcion,fecha_inicio,fecha_inicio);
			}
			
			

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
//------------------------------------------
	public void ejecutar_modificarfechafinal_proyecto() {
		try {
			System.out.println("Ingrese la fecha de Fin del Proyecto:(yyyy-mm-dd)");
			String fecha_final = this.br.readLine();
			this.proyecto.setFecha_final(fecha_final);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
//------------------------------------------
	public void ejecutar_agregar_participante() {
		try {
			System.out.println("Nombre del Participante a Agregar: ");
			String nombre = this.br.readLine();
			System.out.println("Correo del Participante: ");
			String correo = this.br.readLine();
			
			this.proyecto.agregar_participante(nombre, correo);	
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
//------------------------------------------
	public void ejecutar_eliminar_participante() {
		try {
			System.out.println("Nombre del Participante a Eliminar: ");
			String nombre = this.br.readLine();
			
			this.proyecto.eliminar_participante(nombre);	
			System.out.println("Nombre del Participante: ");
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
//------------------------------------------	
	public void mostra_info() {
		System.out.println("Info del Proyecto\n");
		
		System.out.printf("Nombre Proyecto: "+this.proyecto.getNombre()+"\n"
		+"Descripcion: "+this.proyecto.getDescripcion()+"\n");
		System.out.print("Fecha Inicio: "+this.proyecto.getFecha_inicio()+" \n");
		System.out.print("Fecha Final: "+this.proyecto.getFecha_final()+" \n");
		System.out.print("Participantes: "+this.proyecto.getParticipantes().keySet()+"\n");
		
		for (String key_participante : this.proyecto.getParticipantes().keySet() ) {
			
			Participante P = this.proyecto.getParticipantes().get(key_participante);
			System.out.print("\nNombre Participante: "+P.getNombre()+" |");
			System.out.print("Correo: "+P.getCorreo()+" |Dueño: "+P.getDueno()+"\n");
			System.out.print("Actividades:"+P.getActividades().keySet()+"\n");
			
			
		}
				
	}
//------------------------------------------	
	public void ejecutar_agregar_actividad(){
		
		try {
			System.out.print("Digite una opcion:\n"
					+"1. Agregar Actividad con fecha y hora de inicio por defecto\n"
					+"2. Agregar Actividad con fecha y hora de inicio modificados\n");
			int op = Integer.parseInt(this.br.readLine());
			
			if (op == 1) {
				
				System.out.print("Ingrese el nombre del participante autor de la Actividad: ");
				String autor = this.br.readLine();
				System.out.print("Ingrese el titulo de la Actividad: ");
				String titulo = this.br.readLine();
				System.out.print("Ingrese una descripcion de la Actividad: ");
				String descripcion = this.br.readLine();
				System.out.print("Ingrese de que tipo es la Actividad: ");
				String tipo = this.br.readLine();
				System.out.print("Ingrese la hora final de la Actividad (hh:mm:ss): ");
				String hora_final = this.br.readLine();
				
				this.proyecto.getParticipantes().get(autor).agregar_actividadActividad_valorespordefecto(titulo,
						descripcion,autor,tipo,hora_final);
			}
			else if (op == 2){
				
				System.out.print("Ingrese el nombre del participante autor de la Actividad: ");
				String autor = this.br.readLine();
				System.out.print("Ingrese el titulo de la Actividad: ");
				String titulo = this.br.readLine();
				System.out.print("Ingrese una descripcion de la Actividad: ");
				String descripcion = this.br.readLine();
				System.out.print("Ingrese de que tipo es la Actividad: ");
				String tipo = this.br.readLine();
				System.out.print("Ingrese la fecha de la Actividad:(yyyy-mm-dd) ");
				String fecha = this.br.readLine();
				System.out.print("Ingrese la hora Inicial de la Actividad:(hh:mm:ss) ");
				String hora_inicio = this.br.readLine();
				System.out.print("Ingrese la hora final de la Actividad:(hh:mm:ss) ");
				String hora_final = this.br.readLine();
				
				this.proyecto.getParticipantes().get(autor).agregar_actividadActividad_valoresmodificados(titulo, 
						descripcion, autor, tipo, fecha, hora_inicio, hora_final);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//------------------------------------------
	public void ejecutar_relizar_reporte() {
		try {
			System.out.println("Ingrese el nombre del Participante del cual quiere el reporte");
			String nombre = this.br.readLine();
			Reporte rep = this.proyecto.realizar_reporte_participante(nombre);
			System.out.println("\nNombre:"+nombre+" (Los tiempos son en minutos)"+"\n");
			System.out.println("Tiempo Total Invertido: "+rep.getTiempo_invertido()+"\n");
			System.out.println("Tiempo promedio por Tipo de Actividad");
			System.out.println(rep.getTiempo_invertido_tipo()+"\n");
			System.out.println("Tiempo promedio por dia");
			System.out.println(rep.getTiempo_invertido_dia()+"\n");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
//------------------------------------------
	
	public void ejecutar_agregar_actividadCrono(){
		
		try {
			
			int opc;
			Cronometro crono = new Cronometro();
			do {
				System.out.println("\nDigite una opcion:\n"
						+"1. Iniciar\n"
						+"2. Pausar\n"
						+"3. reanudar\n"
						+"4. Terminar\n"
						+"5. Guardar Tiempo de la Actividad\n");
				opc = Integer.parseInt(this.br.readLine()); 
				
				
				
				if(opc == 1) {
					crono.iniciar_crono();
					System.out.print("CRONOMETRO INICIADO\n");
				}
				else if(opc == 2){
					System.out.print("CRONOMETRO PAUSADO\n");
					crono.pausar_crono();
				}
				else if(opc == 3){
					crono.reanudar();
					System.out.print("CRONOMETRO REANUDADO");
				}
				else if(opc == 4){
					crono.terminar_crono();
					System.out.print("CRONOMETRO TERMINADO\n");
					System.out.print("Tiempo Total (min): "+crono.getTiempo_invertido()+"\n");
					System.out.print("Hora Inicio: "+crono.getHora_inicio()+"\n");
					System.out.print("Hora Final: "+crono.getHora_final()+"\n");	
				}
				else if(opc == 5) {
					
					System.out.print("Ingrese el nombre del participante autor de la Actividad: ");
					String autor = this.br.readLine();
					System.out.print("Ingrese el titulo de la Actividad: ");
					String titulo = this.br.readLine();
					System.out.print("Ingrese una descripcion de la Actividad: ");
					String descripcion = this.br.readLine();
					System.out.print("Ingrese de que tipo es la Actividad: ");
					String tipo = this.br.readLine();
					System.out.print("\n");
					
					
					this.proyecto.getParticipantes().get(autor).agregar_actividadActividad_Crono(titulo,
							descripcion, autor, tipo, crono.getFecha(), crono.getHora_inicio(), crono.getHora_final(), 
							crono.getTiempo_invertido());
					
				}
				
			}while(opc != 5);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
			
		
		
	
//------------------------------------------
	
//------------------------------------------
	public static void main(String[] args) {
		consola c = new consola();
		c.ejecutar_Aplicacion();
	}
//------------------------------------------
	private void mostrar_menu(){
		System.out.println("\nDigite una opcion:\n"
						+ "1. Crear Proyecto\n"
						+ "2. Modificar Fecha Final del Proyecto\n"
						+ "3. Agregar Participantes\n"
						+ "4. Eliminar Participantes\n"
						+ "5. Mostrar Info del Proyecto\n"
						+ "6. Regsitar Activdidad\n"
						+ "7. Realizar Reporte\n"
						+ "8. Cronometrar Actividad y Agregarla\n"
						+ "9. Guardar Datos\n"
						+ "10. Cargar Datos\n"
						+ "0. Salir");
	}
	
	private void ejecutar_Aplicacion(){
		try {
			int op;
			do {
				
				mostrar_menu();
				op = Integer.parseInt(this.br.readLine()); 
				
				if(op == 1) {
					crear_proyecto();
				}
				else if(op == 2){
					ejecutar_modificarfechafinal_proyecto();
				}
				else if(op == 3){
					ejecutar_agregar_participante();
				}
				else if(op == 4){
					ejecutar_eliminar_participante();
				}
				else if(op == 5){
					mostra_info();
				}
				else if(op == 6){
					ejecutar_agregar_actividad();
				}
				else if(op == 7){
					ejecutar_relizar_reporte();
				}
				else if(op == 8){
					ejecutar_agregar_actividadCrono();
				}
				else if(op == 9){
					guardardatos();
				}
				else if(op == 10){
					leerdatos();
				}
			}while(op != 0);
			

			
		} catch (Exception e) {
			// TODO: handle exception
			ejecutar_Aplicacion();
		}
	}
	
	//------------------------------------------
	
		public void guardardatos() {
			ManejadorArchivos ma = new ManejadorArchivos();
			ma.guardar_proyecto(this.proyecto);
			ma.guardar_participantes(this.proyecto);
			ma.guardar_actividades(this.proyecto);
		}
		public void leerdatos() {
			ManejadorArchivos ma = new ManejadorArchivos();
			this.proyecto = ma.leer_proyecto(this.proyecto);
			ma.leer_participantes(this.proyecto);
			ma.leer_actividades(this.proyecto);		
		}
}
