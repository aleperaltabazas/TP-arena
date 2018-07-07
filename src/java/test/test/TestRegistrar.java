import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Alumno;
import domain.RepositorioAlumnos;
import domain.User;
import ui.RegisterViewModel;

public class TestRegistrar {
	User user = new User();
	RegisterViewModel registerVM;
	
	@Before
	public void start(){
		user.setUsername("Carlitos");
		user.setPassword("1233");
		
		registerVM = new RegisterViewModel(user);
	}
	
	@Test
	public void testLlamoACrearAlumnoYApareceEnElRepositorio() {
		registerVM.crearAlumno();
		Alumno unAlumno = RepositorioAlumnos.instancia.dameAlumno(user);
		assertTrue(unAlumno.getUsername().equals(user.getUsername()));
	}

}
