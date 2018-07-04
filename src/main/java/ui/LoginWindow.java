package ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.PasswordField;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.WindowOwner;

import domain.Alumno;
import domain.RepositorioAlumnos;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
@SuppressWarnings("serial")
public class LoginWindow extends MainWindow<LoginViewModel> {
	LoginViewModel viewModel;

	public LoginWindow() {
		super(new LoginViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {
		TextBox userBox = new TextBox(mainPanel);
		PasswordField pwBox = new PasswordField(mainPanel);

		userBox.bindValueToProperty("user");
		pwBox.bindValueToProperty("password");
		
		Button okButton = new Button(mainPanel).setCaption("Ok").onClick(this::login);
	}

	public void login() {
		this.getModelObject().login();
		
		Alumno alumno = RepositorioAlumnos.instancia.dameAlumno(this.getModelObject().user);
		
		Dialog<?> mainView = new UnaView(this, alumno);
		mainView.open();
		mainView.onAccept(this::close);
	}
	
	public static void main(String[] args) {
		new LoginWindow().startApplication();
	}

}
