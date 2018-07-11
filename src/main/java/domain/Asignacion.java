package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Asignacion {
	public List<Tarea> tareas = new ArrayList<Tarea>(Arrays.asList());
	private int codigo;

	public Asignacion(int codigo, Tarea unaTarea) {
		this.codigo = codigo;
		this.tareas.add(unaTarea);
	}

	public int getCodigo() {
		return this.codigo;
	}

	public List<Tarea> getTareas() {
		return this.tareas;
	}

	public void agregarTarea(Tarea unaTarea) {
		this.tareas.add(unaTarea);
	}

	public IntStream obtenerNotas() {
		return tareas.stream().mapToInt(t -> t.getNota().getCalificacion());
	}

	public boolean tieneTarea(Tarea tarea) {
		return tareas.contains(tarea);
	}

	public boolean aprobo(Tarea tarea) {
		this.validar(tarea);
		return tarea.aprobo();
	}

	public void validar(Tarea tarea) {
		if (!this.tieneTarea(tarea)) {
			throw new RuntimeException("Consultando tarea inválida.");
		}
	}

	public String notasAsString() {
		String notas = "";

		int length = this.getTareas().size();

		for (int i = 0; i < length; i++) {
			if (i > 0) {
				notas += ", ";
			}
			Tarea t = this.getTareas().get(i);
			notas += t.notaAsString();
		}

		return notas;
	}

}
