package com.google.challenges;

import java.math.BigInteger;

public class Answer {
	static private final BigInteger ONE = new BigInteger("1");
	static private final BigInteger THREE = new BigInteger("3");
	static private final BigInteger FOUR = new BigInteger("4");

	public static int answer(String n) {
		BigInteger number = new BigInteger(n);
		int count = 0;
		while (true) {
			// show(count, number);
			if (number.compareTo(THREE) == 0 || number.compareTo(FOUR) == 0) return count + 2;
			if (!number.testBit(0)) {
				number = number.shiftRight(1);
				count++;
			} else {
				if (number.testBit(1)) {
					number = number.add(ONE);
					count++;
				} else {
					number = number.clearBit(0);
					count++;
				}
			}
		}
	}

	public static int answer2(String n) {
		char[] array = new BigInteger(n).toString(2).toCharArray();
		int count = 0;
		for (char ch : array) {
			if (ch == '1') count++;
			else count += 2;
		}
		return count;
	}

	public static int answer3(String n) {
		String input = new BigInteger(n).toString(2);
		int count = 0;

		count += input.length() - 1;
		String[] groups = input.split("0+");
		// System.out.println(">>> " + input + " : " + toString(groups));
		for (String group : groups) {
			if (group.length() > 0) count++;
		}
		if (input.indexOf('0') == -1) count++;
		return count;
	}

	public static int answer4(String n) {
		String input = new BigInteger(n).toString(2);
		StringBuffer buffer = new StringBuffer(input);
		char[] binary = buffer.reverse().toString().toCharArray();
		int len = binary.length;
		int count = 0;

		boolean powerFlag = false;
		for (int i = 0; i < len - 1; i++) {
			if (binary[i] == '0') {
				if (powerFlag) {
					count++;
					powerFlag = false;
				}
				count++;
			} else {
				if (!powerFlag && binary[i + 1] == '1') {
					powerFlag = true;
				}
				count++;
			}
		}
		return count;
	}

	static private String toString(String[] x) {
		StringBuffer out = new StringBuffer();
		for (String z : x) {
			out.append("[" + z + "]");
		}
		return out.toString();
	}

	static public void show(int count, BigInteger number) {
		System.out.format("%d: %s (%s)%n", count, number.toString(2), number.toString());
	}

}
