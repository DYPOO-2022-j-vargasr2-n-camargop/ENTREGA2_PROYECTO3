package logica;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Participante extends Observable{
	
	private String nombre;
	private String Correo;
	private Boolean dueno;
	private HashMap<String,ArrayList<Actividad>> Actividades = new HashMap<String,ArrayList<Actividad>>();
	
//------------------------------------------	
	public void agregar_actividadActividad_valorespordefecto(String titulo, String descripcion, String autor,
			String tipo ,String hora_final)
	{
		Actividad Acti = new Actividad(titulo,descripcion,autor, tipo, hora_final);
		
		if (  Actividades.containsKey(titulo) ) {
			Actividades.get(titulo).add(Acti);
		}
		else {
			ArrayList<Actividad> listActi  = new ArrayList<Actividad>();
			listActi.add(Acti);
			Actividades.put(titulo,listActi);
		}
		this.notificar(Acti);
    }
//------------------------------------------			
	public void agregar_actividadActividad_valoresmodificados(String titulo, String descripcion, String autor,
			String tipo ,String fecha,String hora_incio ,String hora_final)
	{
		Actividad Acti = new Actividad(titulo,descripcion,autor, tipo,hora_final);
		Acti.modificar_fecha_y_hora(fecha, hora_incio);
		Acti.tiempo_invertido();
		
		if (  Actividades.containsKey(titulo) ) {
			Actividades.get(titulo).add(Acti);
		}
		else {
			ArrayList<Actividad> listActi  = new ArrayList<Actividad>();
			listActi.add(Acti);
			Actividades.put(titulo,listActi);
		}
		this.notificar(Acti);
    }
//------------------------------------------	
	public void agregar_actividadActividad_Crono(String titulo, String descripcion, String autor, String tipo, 
			LocalDate fecha, LocalTime hora_inicial ,LocalTime hora_final, Double tiempo_invertido){
		
		Actividad Acti = new Actividad(titulo, descripcion, autor, tipo, hora_final.toString());
		Acti.ActividadCrono(titulo, descripcion, autor, tipo, fecha, hora_inicial, hora_final, tiempo_invertido);
		
		if (  Actividades.containsKey(titulo) ) {
			Actividades.get(titulo).add(Acti);
		}
		else {
			ArrayList<Actividad> listActi  = new ArrayList<Actividad>();
			listActi.add(Acti);
			Actividades.put(titulo,listActi);
		}
		this.notificar(Acti);
    }
//------------------------------------------	
	public double calcular_tiempo_invertidototal() {
		double rta = 0;
		try {
			for (String key_ListActi : Actividades.keySet()) {
				
				for (Actividad Acti : Actividades.get(key_ListActi)) {
					rta += Acti.getTiempo_invertido();
				}
			} 
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return rta;
	}
//------------------------------------------	
	public HashMap<String, Double> calcular_tiempo_promedio_tipoActividad() {
		HashMap<String,Double> time_type = new HashMap<String,Double>();
		
		try {
			
			for (String key_ListActi : Actividades.keySet()) {
				for (Actividad Acti : Actividades.get(key_ListActi)) {
					
					if (time_type.containsKey(Acti.getTipo()) == false) {
						time_type.put(Acti.getTipo(),(double) 0);
					}	
				}
			} 
			
			for (String key_tipo : time_type.keySet()) {
				double promedio = 0;
				int conteo = 0;
				double suma_time = 0; 
				for (String key_ListActi : Actividades.keySet()) {
					for (Actividad Acti : Actividades.get(key_ListActi)) {
						
						if (Acti.getTipo().equals(key_tipo)) {
							
							conteo ++ ;
							
							suma_time += Acti.getTiempo_invertido();
							
						}
					}
				}
				promedio = suma_time/conteo;
				//time_type.put(key_tipo, promedio);
				time_type.replace(key_tipo, promedio);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return time_type;
	}

//------------------------------------------
	public HashMap<LocalDate, Double> calcular_tiempo_dia() {
		HashMap<LocalDate,Double> time_day = new HashMap<LocalDate,Double>();
		
		try {
			
			for (String key_ListActi : Actividades.keySet()) {
				for (Actividad Acti : Actividades.get(key_ListActi)) {
					
					if (time_day.containsKey(Acti.getFecha()) == false) {
						time_day.put(Acti.getFecha(), (double) 0);
					}	
				}
			} 
			
			for (LocalDate key_day : time_day.keySet()) {
				double tiempo_t = 0; 
				for (String key_ListActi : Actividades.keySet()) {
					for (Actividad Acti : Actividades.get(key_ListActi)) {
						
						if (Acti.getFecha().equals(key_day) ) {
							tiempo_t = tiempo_t + Acti.getTiempo_invertido();
						}
						
					}
				}
				//time_day.put(key_day, tiempo_t);
				time_day.replace(key_day, tiempo_t);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return time_day;
	}
	
	
//Constructor
	public Participante(String nombre, String correo, String dueño) {
		super();
		this.nombre = nombre;
		this.Correo = correo;
		this.dueno = Boolean.parseBoolean(dueño);
		
	}

//getters and setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
//------------------------------------------	
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
//------------------------------------------
	public HashMap<String,ArrayList<Actividad>> getActividades() {
		return Actividades;
	}



	public Boolean getDueno() {
		return dueno;
	}

	public void setDueño(String dueno) {
		this.dueno = Boolean.parseBoolean(dueno);
	}
	
/////////////NOTIFICAR////////////////
	
	@SuppressWarnings("deprecation")
	public void notificar(Actividad Acti) {
		
		this.setChanged();
		this.notifyObservers(Acti);
		
	}

}
