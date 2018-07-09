package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RepositorioAlumnos extends Repositorio {
	private RepositorioAlumnos() {

	}

	public void resetAlumnos() {
		this.alumnos.clear();
	}

	public static RepositorioAlumnos instancia = new RepositorioAlumnos();

	public ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

	public static void setInstancia(RepositorioAlumnos instancia) {
		RepositorioAlumnos.instancia = instancia;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void agregarAlumno(Alumno alumno) {
		this.validarNoExiste(alumno);
		alumnos.add(alumno);
	}

	public void validarNoExiste(Alumno alumno) {
		if (this.getAlumnos().stream().anyMatch(a -> a.getUsername().equals(alumno.getUsername()))) {
			throw new RuntimeException("Entrada repetida.");
		}
	}

	public Alumno dameAlumno(User user) {
		return this.findAlumno(user.getUsername(), this.getAlumnos());

	}

	public boolean estaRegistrado(Alumno alumno) {
		return this.getAlumnos().stream().anyMatch(a -> a.equals(alumno));
	}

}
