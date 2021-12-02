package aoc2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SubmarineTest {

	@Test
	public void positionWithoutAim_shouldReturn_150() {
		Submarine submarine = new Submarine("src/main/resources/aoc2-test.txt");
		assertEquals(150, submarine.getCurrentPositionWithoutAim());
	}

	@Test
	public void positionWithoutAim_shouldReturn_900() {
		Submarine submarine = new Submarine("src/main/resources/aoc2-test.txt");
		assertEquals(900, submarine.getCurrentPositionWithAim());
	}
}
