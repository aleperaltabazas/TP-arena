package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Repositorio {
	
	public List<Asignacion> asignaciones;

	public static Repositorio instancia = new Repositorio();
	
	private Repositorio() {
		this.asignaciones = new ArrayList<Asignacion>(Arrays.asList());
	}
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}
	
	public Repositorio getInstancia() {
		return Repositorio.instancia;
	}
	
	public void setAsignaciones(ArrayList<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public IntStream encontrarAsignacion(int codigo, Alumno alumno) {
		return (this.getAsignaciones().stream().filter(a -> a.correspondeA(codigo, alumno)).findFirst().get().getTareas().mapToInt(t->t.getNota().getCalificacion()));
	}
	
	public void agregarAsignacion(Asignacion asignacion) {
		instancia.getAsignaciones().add(asignacion);
	}
	
}
