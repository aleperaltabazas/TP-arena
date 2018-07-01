package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Alumno {
	String nombre;
	long legajo;
	Repositorio repositorio;
	String usuarioGit;
	List<Asignacion> asignaciones;

	public Alumno(String nombre, long legajo, Repositorio repositorio, String usuarioGit,
			List<Asignacion> asignaciones) {
		this.nombre = nombre;
		this.legajo = legajo;
		this.repositorio = repositorio;
		this.usuarioGit = usuarioGit;
		this.asignaciones = asignaciones;
	}

	public IntStream consultarNotas(Asignacion asignacion) {
		return asignacion.obtenerNotas();
	}

	public void actualizarDatos(String nuevoNombre, long nuevoLegajo, String nuevoUsuarioGit) {
		this.nombre = nuevoNombre;
		this.legajo = nuevoLegajo;
		this.usuarioGit = nuevoUsuarioGit;
	}

	public String getNombre() {
		return nombre;
	}

	public long getLegajo() {
		return legajo;
	}

	public String getUsuarioGit() {
		return usuarioGit;
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

}
