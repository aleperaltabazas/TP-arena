package ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.PasswordField;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import domain.User;

public class RegistrarWindow extends Dialog<RegisterViewModel> {

	public RegistrarWindow(WindowOwner owner, User user) {
		super(owner, new RegisterViewModel(user));

	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		TextBox nombre_box = new TextBox(mainPanel);
		TextBox legajo_box = new TextBox(mainPanel);
		TextBox git_box = new TextBox(mainPanel);

		TextBox userName = new TextBox(mainPanel);
		PasswordField pwBox = new PasswordField(mainPanel);
		
		nombre_box.bindValueToProperty("nombreAlumno");
		legajo_box.bindValueToProperty("legajoAlumno");
		git_box.bindValueToProperty("gitAlumno");
		
		userName.bindValueToProperty("username");
		pwBox.bindValueToProperty("password");
		
		Button okButton = new Button(mainPanel).setCaption("Ok").onClick(this::registrar);
	}

	public void registrar(){
		this.getModelObject().crearAlumno();
		this.close();
	}
}
