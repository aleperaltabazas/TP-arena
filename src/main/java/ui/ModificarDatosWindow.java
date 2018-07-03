package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.WindowOwner;

public class ModificarDatosWindow extends Dialog<UnViewModel> {

	public ModificarDatosWindow(WindowOwner owner) {
		super(owner, new UnViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Button okButton = new Button(mainPanel);
		okButton.setCaption("Ok");
		okButton.onClick(this::validar);
	}

	public void validar() {

	}
}
