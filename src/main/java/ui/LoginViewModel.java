package ui;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class LoginViewModel {
	public String user;
	public String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void login() {
		if(user.equals(null) || password.equals(null)) {
			throw new NullPointerException("Usuario o contraseña inválida.");
		}
	}

}
