package ui;

import java.awt.Color;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;

@SuppressWarnings("serial")
public class ViewModificarDatos extends UnaView {
	
	public ViewModificarDatos() {
	    super();
	  }
	
 @Override
  public void createContents(Panel mainPanel) {
	this.setTitle("Modificar datos");
	mainPanel.setLayout(new VerticalLayout());
	Panel panelSuperior = new Panel(mainPanel);
	Panel panelMedio = new Panel(mainPanel);
	Panel panelInferior = new Panel(mainPanel);
	panelSuperior.setLayout(new VerticalLayout());
	panelMedio.setLayout(new ColumnLayout(2));
	Panel panelMedIzq = new Panel(panelMedio);
	panelMedIzq.setLayout(new VerticalLayout());
	Panel panelMedDer = new Panel(panelMedio);
	panelMedDer.setLayout(new VerticalLayout());
	panelInferior.setLayout(new HorizontalLayout());
	
	new Label(panelSuperior).setText("Ingrese los nuevos datos:");
	  
	  new Label(panelMedIzq).setText("Nombre:");
	  new TextBox(panelMedDer)
	  .setBackground(Color.WHITE)
	  .bindValueToProperty("nombreAlumno");
	  
	  new Label(panelMedIzq).setText("Legajo:");
	  new NumericField(panelMedDer)
	  .setBackground(Color.WHITE)
	  .bindValueToProperty("legajoAlumno");
	  
	  new Label(panelMedIzq).setText("Usuario Git:");
	  new TextBox(panelMedDer)
	  .setBackground(Color.WHITE)
	  .bindValueToProperty("gitAlumno");
	  
	  new Button(panelInferior)
	  .setCaption("Actualizar")
	  .onClick(() -> this.getModelObject().modificarDatos());
 }

}
