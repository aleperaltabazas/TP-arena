package domain;

import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class User {
	String username;

	MessageDigest hashed;

	public User() {

	}

	public User(String username, String password) {
		this.username = username;
		this.hash(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MessageDigest getHashed() {
		return hashed;
	}

	public void setHashed(MessageDigest hashed) {
		this.hashed = hashed;
	}

	public void hash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes(), 0, password.length());
			md.digest();
			this.setHashed(md);

		} catch (NoSuchAlgorithmException except) {
			except.printStackTrace();
		}
	}

}
