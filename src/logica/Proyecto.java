package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;


public class Proyecto {

	private String nombre;
	private String descripcion;
	private LocalDate fecha_inicio;
	private LocalDate fecha_final;
	private HashMap<String,Participante> Participantes = new HashMap<String,Participante>();
	
	
	public void agregar_participante(String nombre, String correo)
	{	
		if (Participantes.isEmpty()) {
			Participante P = new Participante(nombre, correo, "true");
			Participantes.put(nombre,P);
		}
		else {
			Participante P = new Participante(nombre, correo, "false");
			Participantes.put(nombre,P);
		}
	}
	
	public void eliminar_participante(String nombre) {
		Participantes.remove(nombre);
	}
	
	public Reporte realizar_reporte_participante(String nombre){
		Participante P = Participantes.get(nombre);
		Reporte rep = new Reporte(nombre, P.calcular_tiempo_invertidototal(), 
				P.calcular_tiempo_promedio_tipoActividad(), P.calcular_tiempo_dia());
		
		return rep;
	}
////////////////////////////////////////////////////////////////////////////////////
	public HashMap<String, ArrayList<Actividad>>  infowbs() {
		
		HashMap<String, ArrayList<Actividad>> infowbs = new HashMap<String, ArrayList<Actividad>> ();
		
		for (String Part : this.getParticipantes().keySet()) {						
			for (String ActiN : Participantes.get(Part).getActividades().keySet()) {				
				for (Actividad Acti : Participantes.get(Part).getActividades().get(ActiN)){					
					if(infowbs.containsKey(Acti.getTipo())) {		
						
						infowbs.get(Acti.getTipo()).add(Acti);
						
					}
					else {
						ArrayList<Actividad> list = new ArrayList<Actividad>(); 
						list.add(Acti);
						infowbs.put(Acti.getTipo(), list);
						;
					}					
				}				
			}	
		}
		
		return infowbs;
	}
	
	public HashMap<String,Double> infografica1(){
		
		HashMap<String,Double> info = new HashMap<String,Double>();
		
		for (String parti : Participantes.keySet()) {
			
			info.put(parti, Participantes.get(parti).calcular_tiempo_invertidototal());
		}
		
		return info; 
	}
	
	
	public HashMap<String,Double> infografica2(){
		
		HashMap<String,Double> info = new HashMap<String,Double>();
		
		HashMap<String,ArrayList<Actividad>> Actis_Tareas = this.infowbs();
		
		for (String Tarea : Actis_Tareas.keySet()) {
			
			double Time = 0;
			for (Actividad Acti : Actis_Tareas.get(Tarea)) {
				
				Time += Acti.getTiempo_invertido();
			}
			
			info.put(Tarea, Time);
			
		}
		
		
		return info; 
	}
	
	
	
	
////////////////////////////////
////////////////////////////////
	
	
//Constructor	
public Proyecto(String nombre, String descripcion,String fecha_inicio,String fecha_final) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		LocalDate localDate_i = LocalDate.parse(fecha_inicio);
		this.fecha_inicio = localDate_i;
		LocalDate localDate_f = LocalDate.parse(fecha_final);
		this.fecha_final = localDate_f;
		
	}////////////// Observable /////////////


//getters and setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//------------------------------------------
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
//------------------------------------------
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		LocalDate localDate = LocalDate.parse(fecha_inicio);
		this.fecha_inicio = localDate;
	}
//------------------------------------------
	public LocalDate getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(String fecha_final) {
		LocalDate localDate = LocalDate.parse(fecha_final);
		this.fecha_final = localDate;
	}
//------------------------------------------
	public HashMap<String, Participante> getParticipantes() {
		return Participantes;
	}


	
	
	
}
