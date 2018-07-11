package ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.PasswordField;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class SubirNotasWindow extends Dialog<SubirNotasViewModel> {
	public SubirNotasWindow(WindowOwner owner) {
		super(owner, new SubirNotasViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel panelNombre = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		Panel panelAsignacion = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		Panel panelTarea = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		Panel panelNota = new Panel(mainPanel).setLayout(new ColumnLayout(2));

		Label nombre = new Label(panelNombre);
		TextBox nombreBox = new TextBox(panelNombre);

		Label legajo = new Label(panelAsignacion);
		TextBox legajoBox = new TextBox(panelAsignacion);

		Label git = new Label(panelTarea);
		TextBox gitBox = new TextBox(panelTarea);

		Label nota = new Label(panelNota);
		TextBox notaBox = new TextBox(panelNota);

		nombre.setText("Nombre").setWidth(80);
		legajo.setText("Asignación").setWidth(80);
		git.setText("Tarea").setWidth(80);
		nota.setText("Nota").setWidth(80);

		nombreBox.setWidth(120).alignLeft();
		legajoBox.setWidth(120).alignLeft();
		gitBox.setWidth(120).alignLeft();
		notaBox.setWidth(120).alignLeft();

		Button okButton = new Button(mainPanel).setCaption("Ok").onClick(this::subirNotas);

	}

	public void subirNotas() {
		this.getModelObject().subirNotas();
	}
}
