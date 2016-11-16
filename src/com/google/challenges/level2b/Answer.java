
package com.google.challenges.level2b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Answer {

	public static int answer(String n, int b) {
		String key = n;
		// System.out.format("[%s]%n", key); // DEBUG
		Map<String, Integer> map = new TreeMap<String, Integer>();
		int cycle = 1;
		map.put(key, cycle++);
		while (true) {
			key = next(key, b);
			// System.out.format("[%s]%n", key); // DEBUG
			if (map.containsKey(key)) {
				return cycle - map.get(key);
			} else map.put(key, cycle++);
		}
	}

	static private String next(String input, int base) {
		char[] values = input.toCharArray();
		int length = values.length;
		List<Character> list = toList(values);

		Collections.sort(list);
		int a = toValue(list, base);
		Collections.reverse(list);
		int b = toValue(list, base);

		String out = leftPad(Integer.toString(b - a, base), length);
		// System.out.format("%d - %d = %s%n", b, a, out); // DEBUG

		return out;
	}

	static private int toValue(List<Character> input, int base) {
		StringBuilder builder = new StringBuilder();
		for (char c : input) {
			builder.append(c);
		}
		return toValue(builder.toString().toCharArray(), base);
	}

	static private int toValue(char[] input, int base) {
		return Integer.parseInt(new String(input), base);
	}

	static private List<Character> toList(char[] input) {
		List<Character> out = new ArrayList<Character>();
		for (char c : input) {
			out.add(c);
		}
		return out;
	}

	static private String leftPad(String number, int length) {
		while (number.length() < length) {
			number = "0" + number;
		}
		return number;
	}
}