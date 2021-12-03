package aoc3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class DiagnosticReport {

	private static final int ZERO = 48;
	private static final int ONE = 49;

	private final String reportDataLocation;

	public DiagnosticReport(String reportDataLocation) {
		this.reportDataLocation = reportDataLocation;
	}

	public int getPowerConsumption() {
		byte[][] report = parseReport();
		byte[] gammaRate = getGammaRate(report);
		byte[] epsilonRate = getEpsilonRate(gammaRate);
		int gamma = Integer.parseInt(new String(gammaRate), 2);
		int epsilon = Integer.parseInt(new String(epsilonRate), 2);
		return gamma * epsilon;
	}

	private byte[] getGammaRate(byte[][] report) {
		byte[] gammaRate = new byte[report.length];
		for (int i = 0; i < report.length; i++) {
			gammaRate[i] = mapGammaValue(report[i]);
		}
		return gammaRate;
	}

	private byte mapGammaValue(byte[] bytes) {
		long sum = IntStream.range(0, bytes.length).filter(e -> bytes[e] == ONE).count();
		return (byte) (sum > bytes.length / 2 ? ONE : ZERO);
	}

	private byte[] getEpsilonRate(byte[] gammaRate) {
		byte[] epsilonRate = new byte[gammaRate.length];
		for (int i = 0; i < epsilonRate.length; i++) {
			epsilonRate[i] = (byte) (ONE - Byte.toUnsignedInt(gammaRate[i]) % ZERO);
		}
		return epsilonRate;
	}

	private byte[][] parseReport() {
		Path path = Paths.get(reportDataLocation);
		try {
			byte[][] reportData = Files.readAllLines(path).stream().map(e -> e.getBytes(StandardCharsets.UTF_8)).toArray(byte[][]::new);
			if (reportData.length == 0) {
				return reportData;
			}

			int lengthY = reportData.length;
			int lengthX = reportData[0].length;
			byte[][] invertAxxisReportDate = new byte[lengthX][lengthY];
			for (int y = 0; y < lengthY; y++) {
				for (int x = 0; x < lengthX; x++) {
					invertAxxisReportDate[x][y] = reportData[y][x];
				}
			}
			return invertAxxisReportDate;
		} catch (IOException e) {
			throw new IllegalStateException("Could not parse report: " + reportDataLocation, e);
		}
	}
}
