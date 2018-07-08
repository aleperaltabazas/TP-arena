import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import domain.*;

public class TestRepositorio {
	Alumno lu = new Alumno("Lucila", 1, "lusalmeron", Arrays.asList());
	Alumno mati = new Alumno("Matias", 1111111, "matigiorda", Arrays.asList());
	Alumno ale = new Alumno("Ale", 1591591, "aleperaltabazas", Arrays.asList());

	User userLu = new User();
	User userMati = new User();
	User userAle = new User();

	@Before
	public void start() {
		RepositorioAlumnos.instancia.resetAlumnos();

		mati.setUsername("MatiGiorda");
		mati.setPassword("13");
		userLu.setUsername("LuSalmeron");
		userMati.setUsername("MatiGiorda");
		RepositorioAlumnos.instancia.agregarAlumno(mati);

	}

	@Test(expected = RuntimeException.class)
	public void testAgregoAMatiAlRepositorioYTiraError() {
		RepositorioAlumnos.instancia.agregarAlumno(mati);
	}

	@Test
	public void testAgregoALuYEstaTodoOk() {
		RepositorioAlumnos.instancia.agregarAlumno(lu);
		assertTrue(RepositorioAlumnos.instancia.getAlumnos().contains(lu));
	}

	@Test(expected = RuntimeException.class)
	public void testPidoALuYTiraError() {
		RepositorioAlumnos.instancia.dameAlumno(userLu);
	}

	@Test
	public void testPidoAMatiYMeDevuelveOk() {
		Alumno mati_test = RepositorioAlumnos.instancia.dameAlumno(userMati);
		assertTrue(mati_test.equals(mati));
	}

}
