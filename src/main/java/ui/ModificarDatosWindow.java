package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.WindowOwner;

import domain.Alumno;

public class ModificarDatosWindow extends Dialog<AlumnoLogeadoViewModel> {
	AlumnoLogeadoViewModel viewModel;

	public ModificarDatosWindow(WindowOwner owner, Alumno alumno, AlumnoLogeadoViewModel viewModel) {
		super(owner, new AlumnoLogeadoViewModel(alumno));
		this.viewModel = viewModel;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		TextBox newNombre = new TextBox(mainPanel);
		TextBox newLegajo = new TextBox(mainPanel);
		TextBox newGit = new TextBox(mainPanel);

		newNombre.setWidth(250).bindValueToProperty("nombreAlumno");
		newLegajo.setWidth(250).bindValueToProperty("legajoAlumno");
		newGit.setWidth(250).bindValueToProperty("gitAlumno");

		Button actualizarButton = new Button(mainPanel);
		actualizarButton.setCaption("Actualizar");
		actualizarButton.onClick(this::actualizar);

		// De alguna forma estaria bueno que este OK actualice el AlumnoLogeadoWindow,
		// se hace el cambio
		// pero para verlo hay que salir y volver a entrar
		Button okButton = new Button(mainPanel);
		okButton.setCaption("Ok");
		okButton.onClick(this::accept).setAsDefault();

	}

	public void actualizar() {
		try {
			this.getModelObject().validarDatos();
		} catch (RuntimeException e) {
			this.showError(
					"Datos inválidos. Por favor, verifique que ningún campo haya quedado vacío o tenga caracteres incorrectos");
		}

		this.getModelObject().modificarDatos();
		this.viewModel.setNombreAlumno(this.getModelObject().getNombreAlumno());
		this.viewModel.setLegajoAlumno(this.getModelObject().getLegajoAlumno());
		this.viewModel.setGitAlumno(this.getModelObject().getGitAlumno());

	}
}
