package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositorioAlumnos {
	private RepositorioAlumnos() {

	}

	public static RepositorioAlumnos instancia = new RepositorioAlumnos();

	public ArrayList<Alumno> alumnos;

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
		alumnos.add(alumno);
	}

	public Alumno dameAlumno(String nombre) {
		/*if (!this.getAlumnos().stream().anyMatch(a -> a.getNombre() == nombre)) {
			throw new RuntimeException("El alumno no se encuentra en la base de datos.");
		}*/

		return new Alumno("Gaston Prieto", 666, "Gaston.Prieto.UTN", Arrays.asList());
	}

}
