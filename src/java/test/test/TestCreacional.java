import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.*;

import org.junit.Before;
import org.junit.Test;

public class TestCreacional {

	NotaNumerica nota6 = new NotaNumerica(6);
	NotaNumerica nota7 = new NotaNumerica(7);

	Parcial example_parcial = new Parcial(new NotaNumerica(4));
	TrabajoPractico tp = new TrabajoPractico(nota6);
	Parcial parcial = new Parcial(nota7);
	
	Asignacion sistemasOperativos = new Asignacion(3003, example_parcial);
	Asignacion disenioDeSistemas = new Asignacion(3004, example_parcial);

	Alumno unAlumno = new Alumno("Ale", 1591591, "aleperaltabazas",
			Arrays.asList(sistemasOperativos, disenioDeSistemas));

	@Before
	public void inicializar() {
		/*Repositorio.instancia.agregarAsignacion(sistemasOperativos);
		Repositorio.instancia.agregarAsignacion(disenioDeSistemas);*/

		sistemasOperativos.agregarTarea(tp);
		sistemasOperativos.agregarTarea(parcial);

		disenioDeSistemas.agregarTarea(parcial);
	}

	@Test
	public void testLaSumaDeLasNotasDeUnAlumnoEnSistemasOperativosEsLaSumaDeCadaNotaDeLaAsignacion() {
		assertEquals(unAlumno.consultarNotas(sistemasOperativos).sum(),
				sistemasOperativos.obtenerNotas().sum());
	}
	
	@Test
	public void testLasTareasDeSistemasOperativosEsTPYParcial() {
		assertTrue(sistemasOperativos.tareas.contains(tp));
		assertTrue(sistemasOperativos.tieneTarea(parcial));
	}

}
