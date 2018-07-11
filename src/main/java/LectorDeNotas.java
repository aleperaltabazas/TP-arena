import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import domain.Fixture;
import ui.LoginWindow;

public class LectorDeNotas extends Application {

	public static void main(String[] args) {
		Fixture.initialize();
		new LectorDeNotas().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		return new LoginWindow(this);
	}

}
