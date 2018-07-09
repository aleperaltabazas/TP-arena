package domain;

import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class User {
	String username;
	String digest;

	public User() {

	}

	public User(String username, String password) {
		this.username = username;
		this.hashText(password);
	}

	public User(User clone) {
		this.username = clone.username;
		this.digest = clone.digest;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDigest() {
		return this.digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String byteToHexString(byte[] input) {
		String output = "";
		for (int i = 0; i < input.length; ++i) {
			output += String.format("%02X", input[i]);
		}
		return output;
	}

	public String hashText(String value) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String hash = byteToHexString(md.digest(value.getBytes("UTF-8")));
			this.setDigest(hash);
			return hash;
		} catch (NoSuchAlgorithmException e) {
			return null;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

}
