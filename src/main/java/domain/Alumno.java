package domain;

import java.util.stream.IntStream;

public class Alumno implements Usuario {
	String nombre;
	long legajo;
	Repositorio repositorio;
	String usuarioGit;

	public Alumno(String nombre, long legajo, Repositorio repositorio, String usuarioGit) {
		this.nombre = nombre;
		this.legajo = legajo;
		this.repositorio = repositorio;
		this.usuarioGit = usuarioGit;
	}

	public IntStream consultarNotas(int codigo) {
		return repositorio.encontrarAsignacion(codigo, this);
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

}
