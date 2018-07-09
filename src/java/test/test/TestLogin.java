import static org.junit.Assert.*;

import java.security.MessageDigest;

import org.junit.Before;
import org.junit.Test;

import domain.*;
import ui.LoginViewModel;
import ui.RegisterViewModel;

public class TestLogin {
	User user1 = new User();
	User user2 = new User();

	User userLu = new User("LuSalmeron", "123");
	User userMati = new User("MatiGiorda", "456");
	User userAle = new User("aleperaltabazas", "789");

	Alumno lu = new Alumno("Lucila", 1, "lusalmeron", "LuSalmeron", "123");
	Alumno mati = new Alumno("Matias", 1111111, "matigiorda", "MatiGiorda", "456");
	Alumno ale = new Alumno("Ale", 1591591, userAle.getUsername(), "aleperaltabazas", "789");

	RepositorioAlumnos repoAlumnos = RepositorioAlumnos.instancia;
	RepositorioUsuarios repoUsuarios = RepositorioUsuarios.instancia;

	RegisterViewModel vm = new RegisterViewModel(userAle);

	@Before
	public void start() {
		user1.hashText("123");
		user2.hashText("888");

		repoAlumnos.resetAlumnos();
		repoUsuarios.resetUsuarios();
	}

	@Test
	public void testHasheo123Y456YDaDiferente() {
		assertTrue(!user1.getDigest().equals(user2.getDigest()));
	}

	@Test
	public void testAgregoAMatiYLaLogeoConSuUsuarioYContraseña() {
		repoUsuarios.agregarUsuario(userMati);
		repoUsuarios.dameUsuario(userMati.getUsername());

		repoUsuarios.validarPassword(userMati);
	}

	@Test(expected = RuntimeException.class)
	public void testAgregoAMatiYLoLogeoConOtraContraseñaYFalla() {
		repoUsuarios.agregarUsuario(userMati);
		userMati.setDigest("123");

		repoUsuarios.validarPassword(userMati);
	}

	@Test
	public void testAutenticoALuYSaleBien() {
		repoUsuarios.agregarUsuario(userLu);
		repoUsuarios.autenticar(userLu);
	}

	@Test
	public void testUsoCrearUsuarioYApareceEnRepoUsuarios() {
		vm.setGitAlumno("abc");
		vm.setLegajoAlumno(123);
		vm.setNombreAlumno("a");
		vm.setPassword("123");

		vm.crearAlumno();

		assertTrue(repoUsuarios.estaRegistrado(userAle));
	}

	@Test
	public void testUsoCrearUsuarioYApareceEnRepoAlumnos() {
		vm.setGitAlumno("abc");
		vm.setLegajoAlumno(123);
		vm.setNombreAlumno("a");
		vm.setPassword("123");

		vm.crearAlumno();

		assertTrue(repoUsuarios.estaRegistrado(ale));
	}

	@Test(expected = RuntimeException.class)
	public void testAutenticoALuSinAgregarYTiraError() {
		repoUsuarios.autenticar(userLu);
	}

}
