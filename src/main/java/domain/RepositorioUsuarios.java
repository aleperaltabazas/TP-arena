package domain;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Optional;

public class RepositorioUsuarios extends Repositorio {
	private RepositorioUsuarios() {

	}

	public static RepositorioUsuarios instancia = new RepositorioUsuarios();
	public ArrayList<User> usuarios = new ArrayList<User>();

	public static RepositorioUsuarios getInstancia() {
		return instancia;
	}

	public static void setInstancia(RepositorioUsuarios instancia) {
		RepositorioUsuarios.instancia = instancia;
	}

	public ArrayList<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<User> usuarios) {
		this.usuarios = usuarios;
	}

	public void resetUsuarios() {
		this.usuarios.clear();
	}

	public void autenticar(User usuario) {
		this.validarNull(usuario);
		this.identificar(usuario);
		this.validarPassword(usuario);
	}

	public void identificar(User usuario) {
		if (!this.estaRegistrado(usuario)) {
			throw new RuntimeException("Esa combinación de usuario y contraseña no existe.");
		}
	}

	public boolean estaRegistrado(User usuario) {
		return this.getUsuarios().stream().anyMatch(u -> u.getUsername().equals(usuario.getUsername()));
	}

	public void validarPassword(User usuario) {
		User user = this.dameUsuario(usuario.getUsername());

		if (!user.getDigest().equals(usuario.getDigest())) {
			throw new RuntimeException("Combinación incorrecta.");
		}
	}

	public void agregarUsuario(User usuario) {
		this.validarNull(usuario);
		this.validarDuplicado(usuario);

		User nuevoUsuario = new User(usuario);
		usuarios.add(nuevoUsuario);
	}

	public void validarDuplicado(User usuario) {
		if (this.estaRegistrado(usuario)) {
			throw new RuntimeException("Entrada duplicada.");
		}
	}

	public User dameUsuario(String username) {
		return this.find(username, this.getUsuarios());
	}

	public String byteToHexString(byte[] input) {
		String output = "";
		for (int i = 0; i < input.length; ++i) {
			output += String.format("%02X", input[i]);
		}
		return output;
	}

	public String hash(String value) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return byteToHexString(md.digest(value.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			return null;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

}
