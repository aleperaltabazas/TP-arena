package ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import domain.Alumno;

public class VerNotasWindow extends Dialog<UnViewModel> {
	public VerNotasWindow(WindowOwner owner, Alumno alumno) {
		super(owner, new UnViewModel(alumno));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {

		Button okButton = new Button(mainPanel);
		okButton.setCaption("Ok").onClick(this::accept).setAsDefault();

	}

}
