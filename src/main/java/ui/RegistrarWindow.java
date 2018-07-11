package ui;

import org.uqbar.arena.layout.ColumnLayout;
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
		Panel panelUsuario = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		Panel panelContrasenia = new Panel(mainPanel).setLayout(new ColumnLayout(2));

		Panel panelNombre = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		Panel panelLegajo = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		Panel panelGit = new Panel(mainPanel).setLayout(new ColumnLayout(2));

		Label username = new Label(panelUsuario);
		TextBox usernameBox = new TextBox(panelUsuario);

		Label password = new Label(panelContrasenia);
		PasswordField passwordBox = new PasswordField(panelContrasenia);

		Label nombre = new Label(panelNombre);
		TextBox nombreBox = new TextBox(panelNombre);

		Label legajo = new Label(panelLegajo);
		TextBox legajoBox = new TextBox(panelLegajo);

		Label git = new Label(panelGit);
		TextBox gitBox = new TextBox(panelGit);

		nombre.setText("Nombre").setWidth(80);
		legajo.setText("Legajo").setWidth(80);
		git.setText("Github").setWidth(80);
		username.setText("Username").setWidth(80);
		password.setText("Password").setWidth(80);

		nombreBox.setWidth(120).alignLeft();
		legajoBox.setWidth(120).alignLeft();
		gitBox.setWidth(120).alignLeft();
		usernameBox.setWidth(120).alignLeft();
		passwordBox.setWidth(120);

		nombreBox.bindValueToProperty("nombreAlumno");
		legajoBox.bindValueToProperty("legajoAlumno");
		gitBox.bindValueToProperty("gitAlumno");
		usernameBox.bindValueToProperty("username");
		passwordBox.bindValueToProperty("password");

		Button okButton = new Button(mainPanel).setCaption("Ok").onClick(this::registrar);
	}

	public void registrar() {
		try {
			this.getModelObject().crearAlumno();
		} catch (RuntimeException e) {
			this.showError("Por favor, complete todos los campos");
		}

		this.showInfo("Usuario creado correctamente!");
		this.close();
	}
}
