package ui;

import java.security.MessageDigest;

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
import domain.User;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
@SuppressWarnings("serial")
public class LoginWindow extends MainWindow<LoginViewModel> {
	LoginViewModel viewModel;

	public LoginWindow() {
		super(new LoginViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {
		Label username = new Label(mainPanel);
		username.alignLeft();
		username.setText("User");
		
		TextBox userBox = new TextBox(mainPanel);
		
		Label password = new Label(mainPanel);
		password.alignLeft();
		password.setText("Password");
		
		PasswordField pwBox = new PasswordField(mainPanel);

		userBox.bindValueToProperty("user");
		pwBox.bindValueToProperty("password");

		Button okButton = new Button(mainPanel).setCaption("Ok").onClick(this::login);
		Button registerButton = new Button(mainPanel).setCaption("Registrar").onClick(this::registrar);
	}
		
	public void registrar(){
		String username = this.getModelObject().getUser();
		String password = this.getModelObject().getPassword();
		MessageDigest md = this.getModelObject().getHashed();
		
		User user = new User(username, password, md);
		
		Dialog<?> registerView = new RegistrarWindow(this, user);
		registerView.open();
		registerView.onAccept(null);
		registerView.onCancel(null);
	}
	
	public void login() {
		this.getModelObject().login();

		String username = this.getModelObject().getUser();
		String password = this.getModelObject().getPassword();
		MessageDigest hashed = this.getModelObject().getHashed();
		User user = new User(username, password, hashed);

		Alumno alumno = RepositorioAlumnos.instancia.dameAlumno(user);

		// La idea sería tener una clase intermedia o algo en el user tal que
		// podamos saber si se logea un alumno o un profesor sin tener que usar
		// ifs

		Dialog<?> mainView = new AlumnoLogeadoWindow(this, alumno);
		mainView.open();
		mainView.onAccept(this::close);
		mainView.onCancel(this::close);
	}

	public static void main(String[] args) {
		new LoginWindow().startApplication();
	}

}
