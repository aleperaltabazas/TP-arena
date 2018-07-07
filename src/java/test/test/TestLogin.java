import static org.junit.Assert.*;

import java.security.MessageDigest;

import org.junit.Before;
import org.junit.Test;

import domain.*;
import ui.LoginViewModel;

public class TestLogin {
	LoginViewModel vm = new LoginViewModel();
	
	@Before
	public void start(){
	
	}
	
	@Test
	public void testHasheo123Y456YDaDiferente() {
		vm.setPassword("123");
		vm.hash();
		String md123 = vm.getHashText();
		
		vm.setPassword("456");
		vm.hash();
		String md456 = vm.getHashText();
		
		assertTrue(md456.equals(md123));
	}

}
