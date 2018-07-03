import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import domain.Alumno;
import domain.Asignacion;
import domain.NotaConceptual;
import domain.NotaNumerica;
import domain.Parcial;
import domain.Tarea;

public class TestAprobo {
	
	Parcial example_parcial = new Parcial(new NotaNumerica(6));
	
	Asignacion sistemasOperativos = new Asignacion(3003, example_parcial);
	Asignacion disenioDeSistemas = new Asignacion(3004, example_parcial);

	Alumno lu = new Alumno("Lucila", 2222222, "lusalmeron",
			Arrays.asList(disenioDeSistemas, sistemasOperativos));

	NotaNumerica nota6 = new NotaNumerica(6);
	NotaNumerica nota7 = new NotaNumerica(7);
	NotaConceptual notaB = new NotaConceptual("B");

	Tarea tp = new Tarea(nota6);
	Tarea parcial1 = new Tarea(nota7);
	Tarea parcial2 = new Tarea(notaB);

	@Before
	public void start() {
		sistemasOperativos.agregarTarea(tp);
		sistemasOperativos.agregarTarea(parcial1);
	}

	@Test
	public void testPreguntoSiApruebaParcial1YDiceQueSi() {
		assertTrue(sistemasOperativos.aprobo(parcial1));
	}

	@Test(expected = RuntimeException.class)
	public void testPreguntoSiApruebaParcial2YTiraExcepcionDeConsultaInvalida() {
		assertTrue(sistemasOperativos.aprobo(parcial2));
	}
	
	@Test
	public void testCambioLaNotaDeParcial1A5YNoEstaAprobado() {
		parcial1.cambiarNota(5);
		assertFalse(sistemasOperativos.aprobo(parcial1));
	}
	
	@Test
	public void testCambioLaNotaDeParcial1ABYEstaAprobado() {
		parcial1.cambiarNota("B");
		assertTrue(sistemasOperativos.aprobo(parcial1));
	}
}
