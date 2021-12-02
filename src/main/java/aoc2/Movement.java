package aoc2;

public class Movement {

	enum Direction {
		FORWARD,
		DOWN,
		UP
	}

	private int value = 0;
	private Direction direction;

	Movement(Direction direction, int value) {
		this.direction = direction;
		this.value = value;
	}

	Direction getDirection() {
		return direction;
	}

	int getValue() {
		return value;
	}
}
