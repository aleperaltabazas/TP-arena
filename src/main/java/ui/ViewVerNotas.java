package ui;

import java.awt.Color;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;

import domain.Asignacion;

@SuppressWarnings("serial")
public class ViewVerNotas extends UnaView {
	public ViewVerNotas() {
		super();
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Ver notas");
		mainPanel.setLayout(new VerticalLayout());

		new Label(mainPanel).setText("Elija una asigancion para ver las notas");

		new Selector<Asignacion>(mainPanel).allowNull(false).alignCenter().bindValueToProperty("asignaciones");

		new Label(mainPanel).setText("Nota:");

		new Label(mainPanel) //
				.setBackground(Color.ORANGE).bindValueToProperty("nota");

	}
}
