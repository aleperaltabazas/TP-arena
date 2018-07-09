package ui;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.uqbar.commons.model.annotations.Observable;

import domain.Alumno;
import domain.RepositorioAlumnos;
import domain.RepositorioUsuarios;
import domain.User;

@Observable
public class RegisterViewModel {
	String username;
	String password;
	MessageDigest hashed;
	User user;

	String nombreAlumno;
	long legajoAlumno;
	String gitAlumno;

	public RegisterViewModel(User user) {
		this.user = user;
		this.setUsername(user.getUsername());
		this.setHashed(user.getHashed());
	}

	public void crearAlumno() {
		this.validarElementos();
		Alumno nuevoAlumno = new Alumno(this.getNombreAlumno(), this.getLegajoAlumno(), this.getGitAlumno(),
				this.getUsername(), this.getPassword());

		User nuevoUser = new User(this.getUsername(), this.getPassword());

		RepositorioUsuarios.instancia.agregarUsuario(nuevoUser);
		RepositorioAlumnos.instancia.agregarAlumno(nuevoAlumno);
	}

	public void validarElementos() {
		if (nombreAlumno.equals(null) || legajoAlumno <= 0 || gitAlumno.equals(null) || username.equals(null)
				|| password.equals(null)) {
			throw new RuntimeException("Error en la creación del alumno");
		}
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

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public long getLegajoAlumno() {
		return legajoAlumno;
	}

	public void setLegajoAlumno(long legajoAlumno) {
		this.legajoAlumno = legajoAlumno;
	}

	public String getGitAlumno() {
		return gitAlumno;
	}

	public void setGitAlumno(String gitAlumno) {
		this.gitAlumno = gitAlumno;
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

	public void setHashed(MessageDigest md) {
		this.hashed = md;
	}
}