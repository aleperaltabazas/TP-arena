package ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import domain.Alumno;
import domain.Asignacion;

public class VerNotasWindow extends Dialog<AlumnoLogeadoViewModel> {
	public VerNotasWindow(WindowOwner owner, Alumno alumno) {
		super(owner, new AlumnoLogeadoViewModel(alumno));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Label labelAsignacion = new Label(mainPanel);
		Label labelNotas = new Label(mainPanel);

		this.mostrarAsignaciones(mainPanel);

		Button okButton = new Button(mainPanel);
		okButton.setCaption("Ok").onClick(this::accept).setAsDefault();

	}

	public void mostrarAsignaciones(Panel mainPanel) {

		int size = this.getModelObject().getAsignaciones().size();

		for (int i = 0; i < size; i++) {
			Asignacion a = this.getModelObject().getAsignaciones().get(i);
			new Label(mainPanel).setText("Asignación: " + String.valueOf(a.getCodigo()));
			new Label(mainPanel).setText("Notas: " + a.notasAsString());
		}
	}

}
