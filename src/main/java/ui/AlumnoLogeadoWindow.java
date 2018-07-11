package ui;

import java.awt.Color;
import java.util.Arrays;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.WindowOwner;

import domain.*;

//IMPORTANTE: correr con -Djava.system.class.loader=org.uqbar.apo.APOClassLoader
@SuppressWarnings("serial")
public class AlumnoLogeadoWindow extends Dialog<AlumnoLogeadoViewModel> {
	Alumno alumno;

	public AlumnoLogeadoWindow(WindowOwner owner, Alumno alumno) {
		super(owner, new AlumnoLogeadoViewModel(alumno));
		this.alumno = alumno;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Sistema de Notas");
		mainPanel.setLayout(new VerticalLayout());

		Panel panelSuperior = new Panel(mainPanel);
		panelSuperior.setLayout(new VerticalLayout());

		Panel panelMedio = new Panel(mainPanel);
		panelMedio.setLayout(new ColumnLayout(2));
		Panel panelMedIzq = new Panel(panelMedio);
		panelMedIzq.setLayout(new VerticalLayout());
		Panel panelMedDer = new Panel(panelMedio);
		panelMedDer.setLayout(new VerticalLayout());

		Panel panelInferior = new Panel(mainPanel);
		panelInferior.setLayout(new ColumnLayout(2));
		Panel panelInfIzq = new Panel(panelInferior);
		panelInfIzq.setLayout(new VerticalLayout());
		Panel panelInfDer = new Panel(panelInferior);
		panelInfDer.setLayout(new VerticalLayout());

		new Label(panelSuperior).setText("¡Bienvenido! ¿Qué desea hacer?");

		new Label(panelMedIzq).setText("Nombre:");
		new Label(panelMedDer).setWidth(120).bindValueToProperty("nombreAlumno");

		new Label(panelMedIzq).setText("Legajo:");
		new Label(panelMedDer).setWidth(120).bindValueToProperty("legajoAlumno");

		new Label(panelMedIzq).setText("Usuario Git:");
		new Label(panelMedDer).setWidth(120).bindValueToProperty("gitAlumno");

		new Button(panelInfIzq).setCaption("Modificar datos de usuario").onClick(this::modificarDatos);

		new Button(panelInfDer).setCaption("Ver notas").onClick(this::verNotas);

	}

	public void modificarDatos() {
		Dialog<?> dialogModificarDatos = new ModificarDatosWindow(this, this.getAlumno(), this.getModelObject());
		dialogModificarDatos.open();
		dialogModificarDatos.onAccept(() -> {
		});
	}

	public void verNotas() {
		Dialog<?> dialogVerNotas = new VerNotasWindow(this, this.getAlumno());
		dialogVerNotas.open();
		dialogVerNotas.onAccept(() -> {
		});
	}

	public Alumno getAlumno() {
		return this.alumno;
	}
}
