import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Alumno;
import domain.RepositorioAlumnos;
import domain.User;
import ui.RegisterViewModel;

public class TestRegistrar {
	User unUser = new User("Carlos", "123");
	RegisterViewModel registerVM = new RegisterViewModel(unUser);

	@Before
	public void start() {
		RepositorioAlumnos.instancia.resetAlumnos();
	}

	@Test(expected = RuntimeException.class)
	public void testLlamoACrearAlumnoYTiraExcepcion() {
		registerVM.setGitAlumno("carlitos");
		registerVM.setNombreAlumno("carlinho");

		registerVM.crearAlumno();
	}

	@Test
	public void testCreoUnAlumnoYApareceEnElRepo() {
		registerVM.setGitAlumno("carlitos");
		registerVM.setNombreAlumno("carlinho");
		registerVM.setLegajoAlumno(123);
		registerVM.setPassword("123");

		registerVM.crearAlumno();

		Alumno unAlumno = RepositorioAlumnos.instancia.dameAlumno(unUser);
		assertTrue(unAlumno.getUsername().equals(unUser.getUsername()));
	}

	@Test
	public void testValidoElUserYPasaOk() {
		registerVM.setGitAlumno("carlitos");
		registerVM.setNombreAlumno("carlinho");
		registerVM.setLegajoAlumno(123);
		registerVM.setPassword("123");

		registerVM.validarElementos();
	}

}
