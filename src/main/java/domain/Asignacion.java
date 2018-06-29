package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Asignacion {
	public List<Tarea> tareas;

	Alumno alumno;
	int codigo;
	
	public Asignacion(Alumno alumno, int codigo) {
		this.alumno = alumno;
		this.codigo = codigo;
		this.tareas = new ArrayList<Tarea>(Arrays.asList());
	}
	
	public boolean correspondeA(int codigo, Alumno alumno) {
		return this.codigo == codigo && this.alumno.equals(alumno);
	}
	
	public Stream<Tarea> getTareas(){
		return this.tareas.stream();
	}
	
}
