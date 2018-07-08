import static org.junit.Assert.*;

import java.security.MessageDigest;

import org.junit.Before;
import org.junit.Test;

import domain.*;
import ui.LoginViewModel;

public class TestLogin {
	User user1 = new User();
	User user2 = new User();

	@Before
	public void start() {
		user1.setPassword("123");
		user2.setPassword("456");

		user1.hash();
		user2.hash();
	}

	@Test
	public void testHasheo123Y456YDaDiferente() {

		assertTrue(!user1.getHashText().equals(user2.getHashText()));
	}

}
