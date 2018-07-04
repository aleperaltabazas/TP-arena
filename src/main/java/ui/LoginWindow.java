package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.PasswordField;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.WindowOwner;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
@SuppressWarnings("serial")
public class LoginWindow extends Dialog<UnViewModel> {
	String userIngresado;
	String passwordIngresada;

	public LoginWindow(WindowOwner owner) {
		super(owner, new UnViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		TextBox userBox = new TextBox(mainPanel);
		PasswordField pwBox = new PasswordField(mainPanel);
		
		userBox.bindValueToProperty("user");
		pwBox.bindValueToProperty("password");
	}

	public void login() {
		if (userIngresado.equals(null) || passwordIngresada.equals(null)) {
			throw new RuntimeException("No se encontró esa combinación de usuario y contraseña.");
		}

	}

}
