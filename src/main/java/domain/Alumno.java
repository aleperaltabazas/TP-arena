package domain;

import java.util.stream.IntStream;

public class Alumno implements Usuario{
	String nombre;
	long legajo;
	Repositorio repositorio;
	
	public IntStream consultarNotas(int codigo) {
		return repositorio.encontrarAsignacion(codigo, this);
	}


	
}
