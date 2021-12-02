package aoc2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AoC2 {

	public static void main(String[] args) throws IOException {
		Submarine submarine = new Submarine("src/main/resources/aoc2-input.txt");

		System.out.println("Current posistion without aim: "+submarine.getCurrentPositionWithoutAim()+"\n");
		System.out.println("Current posistion with aim: "+submarine.getCurrentPositionWithAim()+"\n");
	}
}
