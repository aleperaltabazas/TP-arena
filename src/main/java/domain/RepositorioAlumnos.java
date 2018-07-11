package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import ui.SubirNotasViewModel;

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

		Alumno nuevoAlumno = new Alumno(alumno);
		alumnos.add(nuevoAlumno);
	}

	public void validarNoExiste(Alumno alumno) {
		if (this.estaRegistrado(alumno)) {
			throw new RuntimeException("Entrada repetida.");
		}
	}

	public Alumno dameAlumno(User user) {
		return this.findAlumno(user.getUsername(), this.getAlumnos());

	}

	public boolean estaRegistrado(Alumno alumno) {
		return this.getAlumnos().stream().anyMatch(a -> a.getUsername().equals(alumno.getUsername()));
	}

	public boolean estaRegistrado(String nombreAlumno) {
		return this.getAlumnos().stream().anyMatch(a -> a.getNombre().equals(nombreAlumno));
	}

	public boolean estaRegistrado(long legajo) {
		return this.getAlumnos().stream().anyMatch(a -> a.getLegajo() == legajo);
	}

	public void actualizarEntrada(SubirNotasViewModel viewModel) {
		this.validarLegajo(viewModel.getLegajo());

		Alumno a = this.findByLegajo(viewModel.getLegajo(), this.getAlumnos());
		a.actualizarNotas(viewModel);
	}

	public void validarLegajo(long legajo) {
		if (!this.estaRegistrado(legajo)) {
			throw new RuntimeException("No se encuentra registrado");
		}
	}

}
