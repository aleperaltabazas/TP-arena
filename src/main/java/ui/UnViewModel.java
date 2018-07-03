package ui;

import java.util.List;
import org.uqbar.commons.model.annotations.Observable;
import domain.Alumno;
import domain.Asignacion;

@Observable
public class UnViewModel {

	private Alumno modelAlumno;
	private String nombreAlumno;
	private long legajoAlumno;
	private String gitAlumno;
	private List<Asignacion> asignaciones;

	public UnViewModel(Alumno model) {
		this.setNombreAlumno(model.getNombre());
		this.setLegajoAlumno(model.getLegajo());
		this.setGitAlumno(model.getUsuarioGit());
		this.setAsignaciones(model.getAsignaciones());
		this.modelAlumno = model;
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

}
