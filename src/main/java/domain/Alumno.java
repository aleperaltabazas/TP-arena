package domain;

import java.util.List;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import ui.SubirNotasViewModel;

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
		this.usuarioGit = usuarioGit;
	}

	public Alumno(String nombre, long legajo, String usuarioGit, List<Asignacion> asignaciones, String username,
			String password) {
		super(username, password);
		this.nombre = nombre;
		this.legajo = legajo;
		this.usuarioGit = usuarioGit;
		this.asignaciones = asignaciones;
	}

	public Alumno(Alumno clone) {
		super(clone);
		this.nombre = clone.nombre;
		this.legajo = clone.legajo;
		this.asignaciones = clone.asignaciones;
		this.usuarioGit = clone.usuarioGit;
	}

	public IntStream consultarNotas(Asignacion asignacion) {
		return asignacion.obtenerNotas();
	}

	public void actualizarDatos(String nuevoNombre, long nuevoLegajo, String nuevoUsuarioGit) {
		this.nombre = nuevoNombre;
		this.legajo = nuevoLegajo;
		this.usuarioGit = nuevoUsuarioGit;
	}

	public String notaDe(Asignacion asignacion) {
		this.validarTiene(asignacion);

		return asignacion.notasAsString();
	}

	public void validarTiene(Asignacion asignacion) {
		if (!this.getAsignaciones().stream().anyMatch(a -> a.getCodigo() == asignacion.getCodigo())) {
			throw new RuntimeException("Asignación no pertenece al alumno");
		}
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

	public void agregarAsignacion(Asignacion asignacion) {
		this.asignaciones.add(asignacion);
	}

	public void actualizarNotas(SubirNotasViewModel viewModel) {
		if (!this.existe(viewModel.getAsignacion())) {
			this.nuevaAsignacion(viewModel.getAsignacion());
			this.actualizarNotas(viewModel);
		}

		Asignacion asignacion = this.find(viewModel.getAsignacion());
		this.asignaciones.remove(asignacion);

	}

	public Asignacion find(String asignacion) {
		Optional<Asignacion> ret = this.getAsignaciones().stream()
				.filter(a -> a.getCodigo() == Integer.parseInt(asignacion)).findFirst();

		if (!ret.isPresent()) {
			throw new NullPointerException("Asignación inexistente.");
		}

		return ret.get();
	}

	public boolean existe(String asignacion) {
		return this.getAsignaciones().stream().anyMatch(a -> a.getCodigo() == Integer.parseInt(asignacion));
	}

	public void nuevaAsignacion(String asignacion) {

	}
}
