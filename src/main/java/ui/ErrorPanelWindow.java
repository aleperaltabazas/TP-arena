package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.ErrorsPanel;
import org.uqbar.arena.windows.MainWindow;

public class ErrorPanelWindow extends MainWindow<LoginViewModel> {

	public ErrorPanelWindow() {
		super(new LoginViewModel());

	}

	@Override
	public void createContents(Panel mainPanel) {
		new ErrorsPanel(mainPanel, "Oops, esa combinación no se encontró en nuestra base de datos...");
	}

}
