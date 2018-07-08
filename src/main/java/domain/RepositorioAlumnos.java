package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RepositorioAlumnos {
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
		if (this.getAlumnos().stream().anyMatch(a -> a.getLegajo() == alumno.getLegajo())) {
			throw new RuntimeException("Entrada repetida.");
		}
	}

	public Alumno dameAlumno(User user) {
		return this.find(user.getUsername());

	}

	public boolean estaRegistrado(Alumno alumno) {
		return this.getAlumnos().stream().anyMatch(a -> a.equals(alumno));
	}

	public void validarNull(Object obj) {
		if (obj.equals(null)) {
			throw new NullPointerException("Null user");
		}
	}

	public Alumno find(String username) {
		this.validarNull(username);
		Optional<Alumno> ret_alumno = this.getAlumnos().stream().filter(a -> a.getUsername().equalsIgnoreCase(username))
				.findFirst();

		if (!ret_alumno.isPresent()) {
			throw new RuntimeException("No se encuentra registrado.");
		}

		return ret_alumno.get();
	}

}
