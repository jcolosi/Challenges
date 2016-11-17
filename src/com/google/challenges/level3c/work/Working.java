package com.google.challenges.level3c.work;

import java.math.BigInteger;
import java.util.ArrayList;

public class Working {
	static private final BigInteger ONE = new BigInteger("1");
	static private final BigInteger THREE = new BigInteger("3");
	static private final BigInteger FOUR = new BigInteger("4");

	public static int answer(String n) {
		BigInteger number = new BigInteger(n);
		int count = 0;
		while (true) {
			show(count, number);
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

	public static int answer5(String n) {
		String input = new BigInteger(n).toString(2);
		StringBuffer buffer = new StringBuffer(input);
		char[] binary = buffer.reverse().toString().toCharArray();
		int len = binary.length;
		int count = 0;
		int i = 0;

		if (input.indexOf('0') < 0) {
			if (input.length() < 3) return input.length();
			else return input.length() + 1;
		}

		while (i < len) {

			if (i == len - 2 && binary[i] == '1' && binary[i + 1] == '1') return count + 2;
			if (i == len - 3 && binary[i] == '0' && binary[i + 1] == '0' && binary[i + 2] == '1') return count + 2;

			if (binary[i] == '0') {
				count++;
				i++;
			} else {
				if ((i + 1) < len && binary[i + 1] == '1') {
					int j = i;
					int ones = 0;
					while (true) {
						if (j == len) return count + ones;
						if (binary[j] == '1') {
							binary[j] = '0';
							j++;
							ones++;
						} else {
							binary[j] = '1';
							break;
						}
					}
					count++;
				} else {
					binary[i] = '0';
					count++;
				}
			}
		}
		return count;
	}

	public static int answer6(String n) {
		Blob number = new Blob(n);
		int count = 0;
		while (true) {
			System.out.format("%d: %s%n", count, number.toString());
			if (number.done()) return count + 2;
			if (!number.first()) number.shift();
			else if (number.second()) number.up();
			else number.down();
			count++;
		}
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

// 001 => 4
class Blob extends ArrayList<Bit> {

	public Blob(String n) {
		super();
		String input = new BigInteger(n).toString(2);
		StringBuffer buffer = new StringBuffer(input);
		char[] array = buffer.reverse().toString().toCharArray();
		for (char c : array) {
			this.add(new Bit(c));
		}
	}

	public void up() {
		int i = 0;
		while (get(i).on()) {
			get(i).clear();
			i++;
			if (i == size()) {
				add(new Bit(1));
				return;
			}
		}
		get(i).set();
	}

	public void down() {
		get(0).clear();
	}

	public void shift() {
		remove(0);
	}

	public boolean first() {
		return get(0).on();
	}

	public boolean second() {
		return get(1).on();
	}

	public boolean done() {
		boolean three = size() == 2 && get(0).on() && get(1).on();
		boolean four = size() == 3 && get(0).off() && get(1).off() && get(2).on();
		return three || four;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		for (Bit b : this) {
			out.append(b.on() ? '1' : '0');
		}
		return out.reverse().toString();
	}

}

class Bit {
	private boolean on;

	public Bit(int x) {
		set(x == 1);
	}

	public Bit(char x) {
		set(x == '1');
	}

	public void clear() {
		this.on = false;
	}

	public void set() {
		this.on = true;
	}

	public boolean on() {
		return this.on;
	}

	public boolean off() {
		return !this.on;
	}

	private void set(boolean x) {
		this.on = x;
	}

}