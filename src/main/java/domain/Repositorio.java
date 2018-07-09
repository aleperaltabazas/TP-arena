package domain;

import java.util.ArrayList;
import java.util.Optional;

public abstract class Repositorio {
	public void validarNull(Object obj) {
		if (obj.equals(null)) {
			throw new NullPointerException("Null user");
		}
	}

	public User find(String name, ArrayList<User> lista) {
		this.validarNull(name);

		Optional<User> ret = lista.stream().filter(u -> u.getUsername().equals(name)).findFirst();

		if (!ret.isPresent()) {
			throw new NullPointerException("Entrada inválida.");
		}

		return ret.get();
	}

	public Alumno findAlumno(String name, ArrayList<Alumno> lista) {
		this.validarNull(name);

		Optional<Alumno> ret = lista.stream().filter(u -> u.getUsername().equals(name)).findFirst();

		if (!ret.isPresent()) {
			throw new NullPointerException("Entrada inválida.");
		}

		return ret.get();
	}
}
