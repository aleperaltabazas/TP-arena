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

import domain.Alumno;
import domain.Asignacion;
import domain.NotaConceptual;
import domain.NotaNumerica;
import domain.Parcial;
import domain.TrabajoPractico;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
@SuppressWarnings("serial")
public class UnaView extends MainWindow<UnViewModel> {

	public UnaView() {
		super(new UnViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {
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
		new Label(panelMedDer).setBackground(Color.WHITE).bindValueToProperty("getNombreAlumno");

		new Label(panelMedIzq).setText("Legajo:");
		new Label(panelMedDer).setBackground(Color.WHITE).bindValueToProperty("getLegajoAlumno");

		new Label(panelMedIzq).setText("Usuario Git:");
		new Label(panelMedDer).setBackground(Color.WHITE).bindValueToProperty("getGitAlumno");

		new Button(panelInfIzq).setCaption("Modificar datos de usuario")
				.onClick(() -> new ViewModificarDatos().startApplication());

		new Button(panelInfDer).setCaption("Ver notas").onClick(this::modificarDatos);

	}

	public static void main(String[] args) {
		new UnaView().startApplication();
	}

	public void modificarDatos() {
		Dialog<?> dialogModificarDatos = new ModificarDatosWindow(this);
		dialogModificarDatos.open();
		dialogModificarDatos.onAccept(() -> {
		});
	}
}
