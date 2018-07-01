package domain;

public class NotaNumerica implements Nota {
	int nota;
	
	public NotaNumerica(int nota){
		this.nota = nota;
	}
	
	public int getCalificacion() {
		return this.nota;
	}
}
