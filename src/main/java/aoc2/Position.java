package aoc2;

interface Position {

	void apply(Movement movement);

	int getHorizontal();

	int getVertical();
}
