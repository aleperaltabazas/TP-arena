package domain;

import java.util.stream.IntStream;

public class Alumno implements Usuario{
	String nombre;
	long legajo;
	Repositorio repositorio;
	
	public Alumno(String nombre, long legajo, Repositorio repositorio) {
		this.nombre = nombre;
		this.legajo = legajo;
		this.repositorio = repositorio;
	}
	
	public IntStream consultarNotas(int codigo) {
		return repositorio.encontrarAsignacion(codigo, this);
	}


	
}
