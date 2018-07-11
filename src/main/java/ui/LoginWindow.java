package ui;

import java.awt.Color;
import java.security.MessageDigest;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.PasswordField;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import domain.Alumno;
import domain.RepositorioAlumnos;
import domain.RepositorioUsuarios;
import domain.User;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
@SuppressWarnings("serial")
public class LoginWindow extends SimpleWindow<LoginViewModel> {
	public LoginWindow(WindowOwner parent) {
		super(parent, new LoginViewModel());
	}

	@Override
	public void createFormPanel(Panel mainPanel) {
		this.setTitle("Sistema de Notas");

		// this.setIconImage("tree.png");

		Panel panelSuperior = new Panel(mainPanel).setLayout(new VerticalLayout());

		Panel panelUsuario = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		Panel panelContrasenia = new Panel(mainPanel).setLayout(new ColumnLayout(2));

		Label username = new Label(panelUsuario).setText("Nombre de usuario");
		TextBox userBox = new TextBox(panelUsuario);

		Label password = new Label(panelContrasenia).setText("Contraseña");
		PasswordField passwordBox = new PasswordField(panelContrasenia);

		new Label(panelSuperior).setText("Ingrese su usuario y contraseña.");

		userBox.bindValueToProperty("user");
		passwordBox.bindValueToProperty("password");

		userBox.setWidth(120);
		passwordBox.setWidth(120);

	}

	public void registrar() {
		Dialog<?> registerView = new RegistrarWindow(this, new User());
		registerView.open();
		registerView.onAccept(() -> {
		});
		registerView.onCancel(() -> {
		});
	}

	public void login() {
		try {
			this.getModelObject().login();
		} catch (Exception e) {
			this.showError("Por favor, complete todos los campos");

			return;
		}

		String username = this.getModelObject().getUser();
		String password = this.getModelObject().getPassword();
		User user = new User(username, password);

		try {
			RepositorioUsuarios.instancia.autenticar(user);
			Alumno alumno = RepositorioAlumnos.instancia.dameAlumno(user);

			Dialog<?> mainView = new AlumnoLogeadoWindow(this, alumno);
			mainView.open();
			mainView.onAccept(() -> {
			});
		} catch (Exception e) {
			this.showError("Oops, parece que hubo un error con el logueo...\n Intente de nuevo");
			return;
		}

	}

	public void subirNotas() {
		Dialog<?> subirNotasView = new SubirNotasWindow(this);
		subirNotasView.open();
		subirNotasView.onAccept(() -> {
		});
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		Panel panelBotones = new Panel(actionsPanel).setLayout(new ColumnLayout(2));
		Panel panelOk = new Panel(panelBotones);
		panelOk.setLayout(new VerticalLayout());

		Panel panelRegistrar = new Panel(panelBotones);
		panelRegistrar.setLayout(new VerticalLayout());

		Button okButton = new Button(panelOk).setCaption("Ok");
		Button registerButton = new Button(panelRegistrar).setCaption("Registrar");

		okButton.setWidth(80);
		okButton.alignCenter();

		registerButton.setWidth(80);
		registerButton.alignCenter();

		okButton.onClick(this::login);
		registerButton.onClick(this::registrar);
	}

}
