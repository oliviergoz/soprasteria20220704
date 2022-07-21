package eshop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DemoTest {

	@Test
	@Disabled
	public void demo1Test() {
		assertEquals(5, 2 + 4);
	}

	@Test
	public void test() {
		assertEquals(2, 2);
	}

	@Test
	public void divisionPar0Test() {
		assertThrows(ArithmeticException.class, () -> {
			int a = 5 / 0;
		});
	}
}
