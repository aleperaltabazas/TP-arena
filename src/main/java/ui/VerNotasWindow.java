package ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
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
		Panel panelCheckbox = new Panel(mainPanel);
		CheckBox checkbox = new CheckBox(panelCheckbox);

		Label labelAsignacion = new Label(mainPanel);
		Label labelNotas = new Label(mainPanel);

		// this.mostrarAsignaciones(mainPanel);

		Panel panelInferior = new Panel(mainPanel);
		panelInferior.setLayout(new ColumnLayout(2));
		Panel panelNotas = new Panel(mainPanel);
		panelNotas.setLayout(new HorizontalLayout());

		Button notaActual = new Button(panelInferior);
		notaActual.setCaption("Nota actual");
		Button todasLasNotas = new Button(panelInferior);
		Label notas = new Label(panelNotas);
		notas.alignCenter().bindValueToProperty("nota");

		notaActual.onClick(this::notaActual);
		todasLasNotas.onClick(this::todasLasNotas);

		Button okButton = new Button(mainPanel);
		okButton.setCaption("Ok").onClick(this::accept).setAsDefault();

	}

	public void notaActual() {
		this.getModelObject().notaActual();
	}

	public void todasLasNotas() {
		this.getModelObject().todasLasNotas();
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
