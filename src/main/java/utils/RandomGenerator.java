package utils;

import java.util.Random;

public class RandomGenerator {

	private static char randomChar() {
		Random rand = new Random();
		char c = (char) (rand.nextInt(26) + 'a');
		return c;

	}

	private static int bigRandomNum() {
		Random rand = new Random();
		int n = rand.nextInt(999);
		return n;

	}

	private static int smallRandomNum() {
		Random rand = new Random();
		int n = rand.nextInt(9);
		return n;

	}

	public static String generateEmail() {
		// String s = "blucrew";
		StringBuilder sb = new StringBuilder();
		sb.append(generateFirstName() + "." + generateLastName() + "@" + "test.com");
		return sb.toString();
	}

	public static String generateFirstName() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			sb.append(randomChar());
		}
		return sb.toString();
	}

	public static String generateLastName() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(randomChar());
		}
		return sb.toString();
	}

	public static String generatePhoneNumber() {
		StringBuilder sb = new StringBuilder();
		sb.append("408");
		for (int i = 0; i < 7; i++) {
			sb.append(smallRandomNum());
		}
		return sb.toString();
	}
}
