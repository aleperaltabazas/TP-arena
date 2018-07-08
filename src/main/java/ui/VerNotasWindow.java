package ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import domain.Alumno;

public class VerNotasWindow extends Dialog<AlumnoLogeadoViewModel> {
	public VerNotasWindow(WindowOwner owner, Alumno alumno) {
		super(owner, new AlumnoLogeadoViewModel(alumno));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Label labelAsignacion = new Label(mainPanel);
		Label labelNotas = new Label(mainPanel);

		labelAsignacion.setText("Asignación: Diseño de Sistemas");
		labelNotas.setText("Notas: 2, 2, 2, 2");

		Button okButton = new Button(mainPanel);
		okButton.setCaption("Ok").onClick(this::accept).setAsDefault();

	}

}
