package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.*;

import org.junit.Before;
import org.junit.Test;

public class TestCreacional {

	Asignacion sistemasOperativos = new Asignacion(3003);
	Asignacion disenioDeSistemas = new Asignacion(3004);

	Alumno unAlumno = new Alumno("Ale", 1591591, Repositorio.instancia, "aleperaltabazas",
			Arrays.asList(sistemasOperativos, disenioDeSistemas));

	NotaNumerica nota6 = new NotaNumerica(6);
	NotaNumerica nota7 = new NotaNumerica(7);

	Tarea tp = new Tarea(nota6);
	Tarea parcial = new Tarea(nota7);

	@Before
	public void inicializar() {
		Repositorio.instancia.agregarAsignacion(sistemasOperativos);
		Repositorio.instancia.agregarAsignacion(disenioDeSistemas);

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
