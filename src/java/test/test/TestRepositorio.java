import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import domain.*;

public class TestRepositorio {
	Alumno lu = new Alumno("Lucila", 1, "lusalmeron", Arrays.asList());
	Alumno mati = new Alumno("Matias", 1111111, "matigiorda", Arrays.asList());
	Alumno ale = new Alumno("Ale", 1591591, "aleperaltabazas", Arrays.asList());
	
	@Before
	public void start(){
		RepositorioAlumnos.instancia.agregarAlumno(lu);
	}

	@Test
	public void test() {
		Alumno alumno = RepositorioAlumnos.instancia.dameAlumno("Lucila");
		assertTrue(!alumno.getNombre().equals(lu.getNombre()));
	}
	
	@Test(expected = RuntimeException.class)
	public void testPreguntoPorMatiYTiraError() {
		RepositorioAlumnos.instancia.dameAlumno("Matias");
	}

}
