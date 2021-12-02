package aoc2;

public class PositionWithAim implements Position {

	private int horizontal = 0;
	private int vertical = 0;
	private int aim = 0;

	@Override
	public void apply(Movement movement) {
		switch (movement.getDirection()) {
		case FORWARD:
			horizontal += movement.getValue();
			vertical += aim * movement.getValue();
			break;
		case DOWN:
			aim += movement.getValue();
			break;
		case UP:
			aim -= movement.getValue();
			break;
		}
	}

	@Override
	public int getHorizontal() {
		return horizontal;
	}

	@Override
	public int getVertical() {
		return vertical;
	}
}
