import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import domain.*;

public class TestRepositorio {
	Alumno lu = new Alumno("Lucila", 1, "lusalmeron", "LuSalmeron", "123");
	Alumno mati = new Alumno("Matias", 1111111, "matigiorda", "MatiGiorda", "456");
	Alumno ale = new Alumno("Ale", 1591591, "aleperaltabazas", "aleperaltabazas", "789");

	User userLu = new User("LuSalmeron", "123");
	User userMati = new User("MatiGiorda", "456");
	User userAle = new User();

	RepositorioAlumnos repoAlumnos = RepositorioAlumnos.instancia;
	RepositorioUsuarios repoUsuarios = RepositorioUsuarios.instancia;

	@Before
	public void start() {
		repoAlumnos.resetAlumnos();
		repoUsuarios.resetUsuarios();

		repoAlumnos.agregarAlumno(mati);

	}

	@Test(expected = RuntimeException.class)
	public void testAgregoAMatiAlRepositorioYTiraError() {
		repoAlumnos.agregarAlumno(mati);
	}

	@Test
	public void testAgregoALuYEstaTodoOk() {
		repoAlumnos.agregarAlumno(lu);
		assertTrue(repoAlumnos.getAlumnos().contains(lu));
	}

	@Test(expected = RuntimeException.class)
	public void testPidoALuYTiraError() {
		repoAlumnos.dameAlumno(userLu);
	}

	@Test
	public void testPidoAMatiYMeDevuelveOk() {
		Alumno mati_test = repoAlumnos.dameAlumno(userMati);
		assertTrue(mati_test.equals(mati));
	}

	@Test
	public void testAgregoAMatiAlRepoDeUsuarios() {
		repoUsuarios.agregarUsuario(userMati);
		assertTrue(repoUsuarios.estaRegistrado(userMati));
	}

	@Test(expected = RuntimeException.class)
	public void testAgregoAMatiDosVecesYFalla() {
		repoUsuarios.agregarUsuario(userMati);
		repoUsuarios.agregarUsuario(userMati);
	}

	@Test
	public void testAgregoAMatiYLoBuscoEnElRepoDeUsuarios() {
		repoUsuarios.agregarUsuario(userMati);
		User testUser = repoUsuarios.find(userMati.getUsername());

		assertTrue(testUser.getUsername().equals(userMati.getUsername()));
	}

	@Test(expected = RuntimeException.class)
	public void testBuscoAAleYFalla() {
		repoUsuarios.find(userAle.getUsername());
	}

	@Test(expected = NullPointerException.class)
	public void testAgregoNullYFalla() {
		repoUsuarios.agregarUsuario(null);
	}

	@Test
	public void testAgregoAMatiYLaLogeoConSuUsuarioYContraseña() {
		repoUsuarios.agregarUsuario(userMati);

		User test = repoUsuarios.find(userMati.getUsername());

		repoUsuarios.validarPassword(userMati.getUsername(), userMati.getHashText());
	}

	@Test(expected = RuntimeException.class)
	public void testAgregoAMatiYLoLogeoConOtraContraseñaYFalla() {
		repoUsuarios.agregarUsuario(userMati);

		repoUsuarios.validarPassword(userMati.getUsername(), "a");
	}

}
