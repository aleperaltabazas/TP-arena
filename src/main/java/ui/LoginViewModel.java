package ui;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class LoginViewModel {
	public String user;
	public String password;
	public MessageDigest hashed;

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

	public MessageDigest getHashed() {
		return this.hashed;
	}

	public void setHashed(MessageDigest md) {
		this.hashed = md;
	}

	public String getHashText() {
		return this.getHashed().toString();
	}

	public void login() {
		if (user.equals(null) || password.equals(null)) {
			throw new NullPointerException("Usuario o contraseña inválida.");
		}
		
		this.hash();
	}

	public void hash() {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(this.getPassword().getBytes(), 0, this.getPassword().length());
			md.digest();
			this.setHashed(md);
		} catch (NoSuchAlgorithmException except) {
			except.printStackTrace();
		}
	}
}
