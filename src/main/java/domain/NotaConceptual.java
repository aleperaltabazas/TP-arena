package domain;

public class NotaConceptual implements Nota {
	String nota;

	public NotaConceptual(String nota) {
		this.nota = nota;
	}

	public int getCalificacion() {
		if (nota.equals("E"))
			return 10;
		else if (nota.equals("MB"))
			return 8;
		else if (nota.equals("B+"))
			return 7;
		else if (nota.equals("B"))
			return 6;
		else
			return 2;

	}

	public boolean estaAprobado() {
		return this.getCalificacion() >= 6;
	}

	public String notaAsString() {
		return this.nota.toString();
	}
}
