package de.aoc.aoc1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AoC1 {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src/main/resources/aoc1-input.txt");
		List<Integer> numbers = Files.readAllLines(path).stream().map(e -> Integer.valueOf(e)).collect(Collectors.toList());

		System.out.println("SingleIncrease: " + singleIncrease(numbers));
		System.out.println("TripletIncrease: " + tripletIncrease(numbers));
	}

	public static int singleIncrease(List<Integer> numbers) {
		int increase = 0;
		increase += IntStream.range(1, numbers.size()).filter(i -> numbers.get(i) > numbers.get(i - 1)).count();
		return increase;
	}

	public static int tripletIncrease(List<Integer> numbers) {
		int increase = 0;
		increase += IntStream.range(1, numbers.size() - 2).filter(i -> getTripletSum(i, numbers) > getTripletSum(i - 1, numbers)).count();
		return increase;
	}

	public static int getTripletSum(int startIndex, List<Integer> numbers) {
		return numbers.get(startIndex) + numbers.get(startIndex + 1) + numbers.get(startIndex + 2);
	}
}
