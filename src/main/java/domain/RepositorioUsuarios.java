package domain;

import java.security.MessageDigest;
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
		this.validarPassword(usuario.getUsername(), usuario.getHashed());
	}

	public void identificar(User usuario) {
		if (!this.estaRegistrado(usuario)) {
			throw new RuntimeException("Esa combinación de usuario y contraseña no existe.");
		}
	}

	public boolean estaRegistrado(User usuario) {
		return this.getUsuarios().stream().anyMatch(u -> u.getUsername().equals(usuario.getUsername()));
	}

	public void validarPassword(String username, MessageDigest digest) {
		User user = this.dameUsuario(username);
		if (!user.getHashed().equals(digest)) {
			throw new RuntimeException("Combinación incorrecta.");
		}
	}

	public void agregarUsuario(User usuario) {
		this.validarNull(usuario);
		this.validarDuplicado(usuario);
		usuarios.add(usuario);
	}

	public void validarDuplicado(User usuario) {
		if (this.estaRegistrado(usuario)) {
			throw new RuntimeException("Entrada duplicada.");
		}
	}

	public User dameUsuario(String username) {
		return this.find(username, this.getUsuarios());
	}

}
