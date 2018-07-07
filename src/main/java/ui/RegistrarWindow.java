package ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
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
		
		Label nombre = new Label (mainPanel);
		TextBox nombre_box = new TextBox(mainPanel);		
		Label legajo = new Label(mainPanel);
		TextBox legajo_box = new TextBox(mainPanel);
		Label git = new Label(mainPanel);
		TextBox git_box = new TextBox(mainPanel);
		Label username = new Label(mainPanel);
		TextBox username_box = new TextBox(mainPanel);
		Label password = new Label(mainPanel);
		PasswordField pwBox = new PasswordField(mainPanel);
		
		nombre.setText("Nombre");
		legajo.setText("Legajo");
		git.setText("Github");
		username.setText("Username");
		password.setText("Password");		
		
		nombre_box.bindValueToProperty("nombreAlumno");
		legajo_box.bindValueToProperty("legajoAlumno");
		git_box.bindValueToProperty("gitAlumno");		
		username_box.bindValueToProperty("username");
		pwBox.bindValueToProperty("password");
		
		Button okButton = new Button(mainPanel).setCaption("Ok").onClick(this::registrar);
	}

	public void registrar(){
		this.getModelObject().crearAlumno();
		this.close();
	}
}
