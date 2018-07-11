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

	public Alumno findAlumno(String username, ArrayList<Alumno> lista) {
		this.validarNull(username);

		Optional<Alumno> ret = lista.stream().filter(u -> u.getUsername().equals(username)).findFirst();

		if (!ret.isPresent()) {
			throw new NullPointerException("Entrada inválida.");
		}

		return ret.get();
	}

	public Alumno findByName(String nombre, ArrayList<Alumno> lista) {
		this.validarNull(nombre);

		Optional<Alumno> ret = lista.stream().filter(u -> u.getNombre().equals(nombre)).findFirst();

		if (!ret.isPresent()) {
			throw new NullPointerException("Etnrada inválida.");
		}

		return ret.get();
	}

	public Alumno findByLegajo(long legajo, ArrayList<Alumno> lista) {
		this.validarNull(legajo);

		Optional<Alumno> ret = lista.stream().filter(u -> u.getLegajo() == legajo).findFirst();

		if (!ret.isPresent()) {
			throw new NullPointerException("Entrada inválida.");
		}

		return ret.get();
	}

}
