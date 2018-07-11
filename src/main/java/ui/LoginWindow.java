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
import org.uqbar.arena.windows.WindowOwner;

import domain.Alumno;
import domain.RepositorioAlumnos;
import domain.RepositorioUsuarios;
import domain.User;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
@SuppressWarnings("serial")
public class LoginWindow extends MainWindow<LoginViewModel> {
	public LoginWindow() {
		super(new LoginViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Sistema de Notas");

		// this.setIconImage("tree.png");

		Panel panelSuperior = new Panel(mainPanel).setLayout(new VerticalLayout());

		Panel panelUsuario = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		Panel panelContrasenia = new Panel(mainPanel).setLayout(new ColumnLayout(2));

		Panel panelBotones = new Panel(mainPanel).setLayout(new ColumnLayout(2));

		Label username = new Label(panelUsuario).setText("Nombre de usuario");
		TextBox userBox = new TextBox(panelUsuario);

		Label password = new Label(panelContrasenia).setText("Contraseña");
		PasswordField passwordBox = new PasswordField(panelContrasenia);

		Button okButton = new Button(panelBotones).setCaption("Ok");
		Button registerButton = new Button(panelBotones).setCaption("Registrar");

		new Label(panelSuperior).setText("Ingrese su usuario y contraseña.");

		userBox.bindValueToProperty("user");
		passwordBox.bindValueToProperty("password");

		userBox.setWidth(120);
		passwordBox.setWidth(120);

		okButton.setWidth(80);
		okButton.alignCenter();

		registerButton.setWidth(80);
		registerButton.alignCenter();

		okButton.onClick(this::login);
		registerButton.onClick(this::registrar);
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
		this.getModelObject().login();

		String username = this.getModelObject().getUser();
		String password = this.getModelObject().getPassword();
		User user = new User(username, password);

		RepositorioUsuarios.instancia.autenticar(user);
		Alumno alumno = RepositorioAlumnos.instancia.dameAlumno(user);

		// La idea sería tener una clase intermedia o algo en el user tal que
		// podamos saber si se logea un alumno o un profesor sin tener que usar
		// ifs

		Dialog<?> mainView = new AlumnoLogeadoWindow(this, alumno);
		mainView.open();
		mainView.onAccept(() -> {
		});
		mainView.onCancel(this::close);
	}

	public void subirNotas() {
		Dialog<?> subirNotasView = new SubirNotasWindow(this);
		subirNotasView.open();
		subirNotasView.onAccept(() -> {
		});
	}

	public static void main(String[] args) {
		new LoginWindow().startApplication();
	}

}
