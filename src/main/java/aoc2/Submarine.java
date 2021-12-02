package aoc2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

class Submarine {

	private final String movementInstructions;

	Submarine(String movementInstructions) {
		this.movementInstructions = movementInstructions;
	}

	int getCurrentPositionWithoutAim() {
		List<Movement> movements = parseMovementInstructions();

		Position positionWithoutAim = new PositionWithoutAim();
		movements.forEach(positionWithoutAim::apply);
		System.out.println("Distance: " + positionWithoutAim.getHorizontal());
		int currentPosition = positionWithoutAim.getHorizontal() * positionWithoutAim.getVertical();
		System.out.println("Product: " + currentPosition);
		return currentPosition;
	}

	int getCurrentPositionWithAim() {
		List<Movement> movements = parseMovementInstructions();

		Position positionWithAim = new PositionWithAim();
		movements.forEach(positionWithAim::apply);
		System.out.println("Distance: " + positionWithAim.getHorizontal());
		System.out.println("Depth: " + positionWithAim.getVertical());
		int currentPosition = positionWithAim.getHorizontal() * positionWithAim.getVertical();
		System.out.println("Product: " + currentPosition);
		return currentPosition;
	}

	private List<Movement> parseMovementInstructions() {
		Path path = Paths.get(movementInstructions);
		try {
			return Files.readAllLines(path).stream().map(this::mapStringToMovement).collect(Collectors.toList());
		} catch (IOException e) {
			throw new IllegalStateException("Could not read instructions: " + movementInstructions, e);
		}
	}

	private Movement mapStringToMovement(String inputLine) {
		String[] splitMovement = inputLine.split("\\s+");
		if (splitMovement.length < 2) {
			throw new IllegalStateException("Cannot parse movementString: " + inputLine);
		}
		String direction = splitMovement[0];
		String value = splitMovement[1];
		return new Movement(Movement.Direction.valueOf(direction.toUpperCase(Locale.ENGLISH)), Integer.parseInt(value));
	}
}
