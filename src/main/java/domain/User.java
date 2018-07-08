package domain;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class User {
	String username;
	String password;

	MessageDigest hashed;

	public User() {

	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.hash();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MessageDigest getHashed() {
		return hashed;
	}

	public void setHashed(MessageDigest hashed) {
		this.hashed = hashed;
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
