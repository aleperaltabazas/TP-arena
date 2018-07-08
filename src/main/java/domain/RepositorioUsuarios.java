package domain;

import java.util.ArrayList;
import java.util.Optional;

public class RepositorioUsuarios {
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

	public boolean estaRegistrado(User usuario) {
		return this.getUsuarios().stream().anyMatch(u -> u.getUsername().equals(usuario.getUsername()));
	}

	public void validarPassword(String username, String hashed) {
		User user = this.find(username);
		if (!user.getHashText().equals(hashed)) {
			throw new RuntimeException("Combinación incorrecta.");
		}
	}

	public void agregarUsuario(User usuario) {
		this.validarDuplicado(usuario);
		this.validarNull(usuario);
		usuarios.add(usuario);
	}

	public void validarDuplicado(User usuario) {
		if (this.estaRegistrado(usuario)) {
			throw new RuntimeException("Entrada duplicada.");
		}
	}

	public void validarNull(Object obj) {
		if (obj.equals(null)) {
			throw new NullPointerException("Null user");
		}
	}

	public User find(String username) {
		this.validarNull(username);
		Optional<User> ret_user = this.getUsuarios().stream().filter(u -> u.getUsername().equals(username)).findFirst();

		if (!ret_user.isPresent()) {
			throw new RuntimeException("Usuario no encontrado.");
		}

		return ret_user.get();
	}
}
