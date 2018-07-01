package domain;

public class Tarea {
	private Nota nota;

	public Tarea(Nota nota) {
		this.nota = nota;
	}

	public Nota getNota() {
		return nota;
	}

	public boolean aprobo() {
		return nota.estaAprobado();
	}

	public void cambiarNota(int nuevaNota) {
		this.nota = new NotaNumerica(nuevaNota);
	}

	public void cambiarNota(String nuevaNota) {
		this.nota = new NotaConceptual(nuevaNota);
	}
}
