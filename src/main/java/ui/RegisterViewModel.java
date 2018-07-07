package ui;

import java.security.MessageDigest;

import org.uqbar.commons.model.annotations.Observable;

import domain.User;

@Observable
public class RegisterViewModel {
	String username;
	MessageDigest hashed;
	User user;
	
	public RegisterViewModel(User user){
		this.username = user.getUsername();
		this.hashed = user.getHashed();
		this.user = user;
	}
}
