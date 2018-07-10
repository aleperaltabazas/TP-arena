package domain;

public class NotaNumerica implements Nota {
	int nota;

	public NotaNumerica(int nota) {
		this.nota = nota;
	}

	public int getCalificacion() {
		return this.nota;
	}

	public boolean estaAprobado() {
		return nota >= 6;
	}

	public String notaAsString() {
		return String.valueOf(this.nota);
	}
}
