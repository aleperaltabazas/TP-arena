package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
@SuppressWarnings("serial")
public class LoginWindow extends MainWindow<UnViewModel> {
	private static final long serialVersionUID = 1L;
	String userIngresado;
	String passwordIngresada;

	public LoginWindow() {
		super(new UnViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {

	}

	public static void main(String[] args) {
		new LoginWindow().startApplication();
	}

	public void login() {
		if (userIngresado.equals(null) || passwordIngresada.equals(null)) {
			throw new RuntimeException("No se encontró esa combinación de usuario y contraseña.");
		}

	}

}
