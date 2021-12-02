package aoc2;

public class PositionWithoutAim implements Position {

	private int horizontal = 0;
	private int vertical = 0;

	@Override
	public void apply(Movement movement) {
		switch (movement.getDirection()) {
		case FORWARD:
			horizontal += movement.getValue();
			break;
		case DOWN:
			vertical += movement.getValue();
			break;
		case UP:
			vertical -= movement.getValue();
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
