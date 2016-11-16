
package com.google.challenges.level3a;

public class Answer {

	public static int answer(int start, int length) {
		int out = 0x0000;
		int id = start;
		int[] last = resetLast();
		boolean warped = false;
		for (int i = length; i > 0; i--) {
			warped = false;
			for (int j = 0; j < length; j++) {

				if (j < i) {
					out ^= id;
					if (!warped && isOdd(id) && (last[id % 4] == out)) {
						int warp = wholeByFour(i - j - 1);
						j += warp;
						id += warp;
						warped = true;
					}
					last[id % 4] = out;
				} else {
					id += length - j;
					last = resetLast();
					break;
				}
				id++;
			}
		}
		return out;
	}

	static private int wholeByFour(int x) {
		return (x / 4) * 4;
	}

	static private int[] resetLast() {
		return new int[] { -1, -1, -1, -1 };
	}

	static private boolean isOdd(int x) {
		return (x % 2) == 1;
	}

}
