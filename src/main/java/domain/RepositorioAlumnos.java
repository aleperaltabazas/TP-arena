package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import ui.SubirNotasViewModel;

public class RepositorioAlumnos extends Repositorio {
	private RepositorioAlumnos() {
		this.testHardCodeadoLosOdio();
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

	public void testHardCodeadoLosOdio() {
		this.resetAlumnos();
		Parcial primerParcialMati = new Parcial(new NotaNumerica(2));
		TrabajoPractico tpAnualMati = new TrabajoPractico(new NotaConceptual("B"));
		TrabajoPractico tpArenaMati = new TrabajoPractico(new NotaConceptual("M"));

		Parcial primerParcialLu = new Parcial(new NotaNumerica(2));
		TrabajoPractico tpAnualLu = new TrabajoPractico(new NotaConceptual("B"));
		TrabajoPractico tpArenaLu = new TrabajoPractico(new NotaConceptual("M"));

		Parcial primerParcialAle = new Parcial(new NotaNumerica(7));
		Parcial segundoParcialAle = new Parcial(new NotaNumerica(2));
		TrabajoPractico tpSOAle = new TrabajoPractico(new NotaNumerica(8));

		TrabajoPractico laboratorioAle = new TrabajoPractico(new NotaConceptual("B"));
		Asignacion fisicaAle = new Asignacion(3001, laboratorioAle);

		Asignacion disenioMati = new Asignacion(3002, primerParcialMati);
		disenioMati.agregarTarea(tpAnualMati);
		disenioMati.agregarTarea(tpArenaMati);

		Asignacion disenioLu = new Asignacion(3002, primerParcialLu);
		disenioLu.agregarTarea(tpAnualLu);
		disenioLu.agregarTarea(tpArenaLu);

		Asignacion sisOpAle = new Asignacion(3013, tpSOAle);
		sisOpAle.agregarTarea(primerParcialAle);
		sisOpAle.agregarTarea(segundoParcialAle);

		List<Asignacion> asignacionesMati = new ArrayList<Asignacion>();
		asignacionesMati.add(disenioMati);

		List<Asignacion> asignacionesLu = new ArrayList<Asignacion>();
		asignacionesLu.add(disenioLu);

		List<Asignacion> asignacionesAle = new ArrayList<Asignacion>();
		asignacionesAle.add(sisOpAle);

		Alumno mati = new Alumno("Matias Giorda", 1594369, "matigiorda", asignacionesMati, "matigiorda", "123");
		Alumno lu = new Alumno("Lucila Salmerón", 1594886, "lusalmeron", asignacionesLu, "lusalmeron", "456");
		Alumno ale = new Alumno("Alejandro Peralta Bazas", 1595465, "aleperaltabazas", asignacionesAle,
				"aleperaltabazas", "789");

		ale.agregarAsignacion(fisicaAle);
		
		this.agregarAlumno(mati);
		this.agregarAlumno(lu);
		this.agregarAlumno(ale);
	}

}
