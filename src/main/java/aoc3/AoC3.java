package aoc3;

import java.io.IOException;

public class AoC3 {

	public static void main(String[] args) throws IOException {
		DiagnosticReport diagnosticReport = new DiagnosticReport("src/main/resources/aoc3-input.txt");
		System.out.println("Power consumption: " + diagnosticReport.getPowerConsumption() + "\n");
	}
}
