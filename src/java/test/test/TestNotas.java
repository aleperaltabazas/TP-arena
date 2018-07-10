import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import domain.*;

public class TestNotas {
	Nota nota8 = new NotaNumerica(8);
	Tarea tarea8 = new Tarea(nota8);
	Asignacion asignacion = new Asignacion(3022, tarea8);

	@Before
	public void start() {
		asignacion.agregarTarea(tarea8);
		asignacion.agregarTarea(tarea8);
	}

	@Test
	public void testLaNotaDeTarea8Es8EnString() {
		assertEquals("8", tarea8.notaAsString());
	}

	@Test
	public void testLaNotaDeTarea8NoEs9() {
		assertNotEquals("9", tarea8.notaAsString());
	}

	@Test
	public void testAsignacionTieneTarea8() {
		assertTrue(asignacion.getTareas().contains(tarea8));
	}

	@Test
	public void testLaLongitudDeTareasDeAsignacionEs3() {
		assertEquals(3, asignacion.getTareas().size());
	}

	@Test
	public void testLasNotasDeAsignacion8Es888() {
		assertEquals("8 8 8 ", asignacion.notasAsString());
	}

}
