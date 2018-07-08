package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Alumno extends User {
	String nombre;
	long legajo;
	String usuarioGit;
	List<Asignacion> asignaciones;

	public Alumno(String nombre, long legajo, String usuarioGit, List<Asignacion> lasAsignaciones) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		this.usuarioGit = usuarioGit;
		this.asignaciones = lasAsignaciones;
	}

	public Alumno(String nombre, long legajo, String usuarioGit, String username, String password) {
		super(username, password);
		this.nombre = nombre;
		this.legajo = legajo;
		this.asignaciones = Arrays.asList();
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

	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}

	public void setLegajo(long unLegajo) {
		this.legajo = unLegajo;
	}

	public void setUsuarioGit(String unGit) {
		this.usuarioGit = unGit;
	}

}
