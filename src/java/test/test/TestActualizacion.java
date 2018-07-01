package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import domain.Alumno;

public class TestActualizacion {

	Alumno mati = new Alumno("Matias", 1111111, "matigiorda", Arrays.asList());

	@Before
	public void start() {
		mati.actualizarDatos("Matias Giorda", 420, "UnUsuarioDeGitPiola");
	}

	@Test
	public void testQueAhoraMatiSeLlamaMatiasGiorda() {
		assertTrue(mati.getNombre().equals("Matias Giorda"));
	}

	@Test
	public void testQueAhoraElLegajoDeMatiEs420() {
		assertEquals(mati.getLegajo(), 420);
	}

	@Test
	public void testQueAhoraElUsuarioDeGitDeMatiEsUnUsuarioDeGitPiola() {
		assertTrue(mati.getUsuarioGit().equals("UnUsuarioDeGitPiola"));
	}

}
