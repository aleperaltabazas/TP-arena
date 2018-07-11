package domain;

import java.util.ArrayList;
import java.util.List;

public class Fixture {
	public static void initialize() {
		Fixture.cargarRepositorioAlumnos();
		Fixture.cargarRepositorioUsuarios();
	}

	public static void cargarRepositorioAlumnos() {
		RepositorioAlumnos.instancia.resetAlumnos();
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

		RepositorioAlumnos.instancia.agregarAlumno(mati);
		RepositorioAlumnos.instancia.agregarAlumno(lu);
		RepositorioAlumnos.instancia.agregarAlumno(ale);
	}

	public static void cargarRepositorioUsuarios() {
		RepositorioUsuarios.instancia.resetUsuarios();
		User mati = new User("matigiorda", "123");
		User lu = new User("lusalmeron", "456");
		User ale = new User("aleperaltabazas", "789");

		RepositorioUsuarios.instancia.agregarUsuario(mati);
		RepositorioUsuarios.instancia.agregarUsuario(lu);
		RepositorioUsuarios.instancia.agregarUsuario(ale);
	}
}
