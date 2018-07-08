import static org.junit.Assert.*;

import java.security.MessageDigest;

import org.junit.Before;
import org.junit.Test;

import domain.*;
import ui.LoginViewModel;

public class TestLogin {
	LoginViewModel vm1 = new LoginViewModel();
	LoginViewModel vm2 = new LoginViewModel();

	@Before
	public void start() {
		vm1.setPassword("123");
		vm2.setPassword("456");
		
		vm1.hash();
		System.out.println(vm1.getHashText());
		vm2.hash();
		System.out.println(vm2.getHashText());
	}

	@Test
	public void testHasheo123Y456YDaDiferente() {
		
		assertTrue(!vm1.getHashText().equals(vm2.getHashText()));
	}

}
