package ui;

import domain.RepositorioAlumnos;

public class SubirNotasViewModel {
	long legajo;
	String asignacion;
	String tarea;
	String nota;

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public String getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(String asignacion) {
		this.asignacion = asignacion;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public void subirNotas() {
		this.validarElementos();

		RepositorioAlumnos.instancia.actualizarEntrada(this);
	}

	public void validarElementos() {
		if (this.legajo == 0 || this.asignacion.equals(null) || this.nota.equals(null) || this.tarea.equals(null)) {
			throw new RuntimeException("Null error.");
		}
	}

}
