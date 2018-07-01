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
    this.setAsiganciones(model.getAsignaciones());
    this.modelAlumno = model;
  }

private void setGitAlumno(String usuarioGit) {
	this.gitAlumno = usuarioGit;
}
private void setLegajoAlumno(long legajo) {
	this.legajoAlumno = legajo;
}
private void setAsiganciones(List<Asignacion> nuevasAsignaciones) {
	this.asignaciones = nuevasAsignaciones;
}
public void setNombreAlumno(String nuevoNombre) {
	this.nombreAlumno = nuevoNombre;
}
public void setAsignaciones(List<Asignacion> listaAsignaciones) {
	this.asignaciones = listaAsignaciones;
}
public String getNombreAlumno() {
	return nombreAlumno;
}
private String getGitAlumno() {
	return this.gitAlumno;
}
private long getLegajoAlumno() {
	return this.legajoAlumno;
}

public void modificarDatos() {
	this.modelAlumno.actualizarDatos(this.getNombreAlumno(),this.getLegajoAlumno(),this.getGitAlumno());
}
  
  

}
