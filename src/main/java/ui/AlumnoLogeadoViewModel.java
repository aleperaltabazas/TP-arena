package ui;

import java.util.List;
import org.uqbar.commons.model.annotations.Observable;
import domain.Alumno;
import domain.Asignacion;

@Observable
public class AlumnoLogeadoViewModel {

	private Alumno modelAlumno;
	private String nombreAlumno;
	private long legajoAlumno;
	private String gitAlumno;
	private List<Asignacion> asignaciones;
	private String nota;

	public AlumnoLogeadoViewModel(Alumno alumno) {
		this.modelAlumno = alumno;
		this.nombreAlumno = alumno.getNombre();
		this.legajoAlumno = alumno.getLegajo();
		this.gitAlumno = alumno.getUsuarioGit();
		this.asignaciones = alumno.getAsignaciones();
	}

	public Alumno getModelAlumno() {
		return modelAlumno;
	}

	public void setModelAlumno(Alumno modelAlumno) {
		this.modelAlumno = modelAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public long getLegajoAlumno() {
		return legajoAlumno;
	}

	public void setLegajoAlumno(long legajoAlumno) {
		this.legajoAlumno = legajoAlumno;
	}

	public String getGitAlumno() {
		return gitAlumno;
	}

	public void setGitAlumno(String gitAlumno) {
		this.gitAlumno = gitAlumno;
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public void modificarDatos() {
		this.modelAlumno.actualizarDatos(this.getNombreAlumno(), this.getLegajoAlumno(), this.getGitAlumno());
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public void validarDatos() {
		if (this.getNombreAlumno().equals(null) || this.getGitAlumno().equals(null) || this.getLegajoAlumno() == 0) {
			throw new RuntimeException("Datos invalidos");
		}
	}

	public void notaActual() {
		this.setNota("10");
	}

	public void todasLasNotas() {
		this.setNota("2, 2, B");
	}
}
