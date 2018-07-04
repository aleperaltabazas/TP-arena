package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.WindowOwner;

public class ModificarDatosWindow extends Dialog<UnViewModel> {
	String nombreIngresado;
	String gitIngresado;
	long legajoIngresado;

	public ModificarDatosWindow(WindowOwner owner) {
		super(owner, new UnViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		TextBox newNombre = new TextBox(mainPanel);
		TextBox newApellido = new TextBox(mainPanel);
		TextBox newGit = new TextBox(mainPanel);

		newNombre.setWidth(250)
		.bindValueToProperty(gitIngresado);
		newApellido.setWidth(250);
		newGit.setWidth(250);
		
		Button okButton = new Button(mainPanel);
		okButton.setCaption("Ok");
		okButton.onClick(this::validar);

	}

	public void validar() {
		if (nombreIngresado.equals(null) || gitIngresado.equals(null) || legajoIngresado == 0) {
			throw new RuntimeException("Tu vieja");
		}

		this.accept();
	}
}
