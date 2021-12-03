package aoc3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DiagnosticReportTest {

	@Test
	public void powerConsumption_shouldReturn_198() {
		DiagnosticReport diagnosticReport = new DiagnosticReport("src/main/resources/aoc3-test.txt");
		assertEquals(198, diagnosticReport.getPowerConsumption());
	}
}