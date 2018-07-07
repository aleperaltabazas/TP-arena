package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import domain.User;

public class RegistrarWindow extends Dialog<RegisterViewModel>{

	public RegistrarWindow(WindowOwner owner, User user) {
		super(owner, new RegisterViewModel(user));
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}

}
