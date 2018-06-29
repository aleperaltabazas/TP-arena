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
	
	public Stream<Asignacion> getAsignaciones() {
		return asignaciones.stream();
	}
	public void setAsignaciones(ArrayList<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public IntStream encontrarAsignacion(int codigo, Alumno alumno) {
		return (this.getAsignaciones().filter(a -> a.correspondeA(codigo, alumno)).findFirst().get().getTareas().mapToInt(t->t.getNota().getCalificacion()));
	}
	
}
