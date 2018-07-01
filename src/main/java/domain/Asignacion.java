package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Asignacion {
	public List<Tarea> tareas;

	int codigo;

	public Asignacion(int codigo) {
		this.codigo = codigo;
		this.tareas = new ArrayList<Tarea>(Arrays.asList());
	}

	public int getCodigo() {
		return this.codigo;
	}

	public Stream<Tarea> getTareas() {
		return this.tareas.stream();
	}

	public void agregarTarea(Tarea unaTarea) {
		this.tareas.add(unaTarea);
	}

	public IntStream obtenerNotas() {
		return tareas.stream().mapToInt(t -> t.getNota().getCalificacion());
	}

}
