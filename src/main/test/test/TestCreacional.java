package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import domain.*;

import org.junit.Before;
import org.junit.Test;

public class TestCreacional {
	
	Alumno unAlumno = new Alumno("Ale", 1591591, Repositorio.instancia);
	
	Asignacion sistemasOperativos = new Asignacion(unAlumno, 3003);
	Asignacion disenioDeSistemas = new Asignacion(unAlumno, 3004);
	
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
		assertEquals(unAlumno.consultarNotas(sistemasOperativos.getCodigo()).sum(), sistemasOperativos.obtenerNotas().sum());
	}
	
}
