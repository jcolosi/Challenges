
package com.google.challenges.level3a;

public class AnswerWorking {

	static private final boolean DEBUG = false;

	public static int answer(int start, int length) {
		return 0;
	}

	public static int answerSimpleDebug(int start, int length) {
		int out = 0x0000;
		int id = start;
		for (int i = length; i > 0; i--) {
			debug(String.format("[[%d]] ", out));
			for (int j = 0; j < length; j++) {
				if (j < i) {
					out ^= id;
					debug(String.format("%d{%d} ", id, out));
				} else {
					debug("/ ");
					id += length - j;
					break;
				}
				id++;
			}
			debug("\n");
		}
		return out;
	}

	public static int answerWarpDebug(int start, int length) {
		int out = 0x0000;
		int id = start;
		int[] last = resetLast();
		boolean warped = false;
		for (int i = length; i > 0; i--) {
			debug(String.format("[[%d]] ", out));
			warped = false;
			for (int j = 0; j < length; j++) {

				if (j < i) {
					out ^= id;
					debug(String.format("%d{%d} ", id, out));
					if (!warped && isOdd(id) && (last[id % 4] == out)) {
						int warp = wholeByFour(i - j - 1);
						debug(String.format("[+%d] ", warp));
						j += warp;
						id += warp;
						warped = true;
					}
					last[id % 4] = out;
				} else {
					debug("/ ");
					id += length - j;
					last = resetLast();
					break;
				}
				id++;
			}
			debug("\n");
		}
		return out;
	}

	public static int answerComplex(int start, int length) {
		int out = 0x0000;
		int id = start;
		for (int i = length; i > 0; i--) {
			for (int j = 0; j < length; j++) {

				if (isPowerOfTwo(id))
					debug(String.format("(%d,%d)\t%d\t%d (%s)%n", start, length, id, out, toBinary(out))); // DEBUG

				if (j < i) {
					// debug(String.format("%02d ", id));
					out ^= id;
				} else {
					// debug("/ ");
					id += length - j;
					break;
				}
				id++;
				if (id > 10000000) break;
			}
			if (id > 10000000) break;
			// debug("\n");
			// debug(String.format("\t%s%n", toBinary(out)));
		}
		return out;
	}

	public static int answer2(int start, int length) {
		int out = 0x0000;
		int id = start;
		for (int i = length; i > 0; i--) {
			for (int j = 0; j < length; j++) {

				if (isPowerOfTwo(id))
					debug(String.format("(%d,%d)\t%d\t%d (%s)%n", start, length, id, out, toBinary(out))); // DEBUG

				if (j < i) {
					// debug(String.format("%02d ", id));
					out ^= id;
				} else {
					// debug("/ ");
					id += length - j;
					break;
				}
				id++;
				// if (id > 10000000) break;
			}
			// if (id > 10000000) break;
			// debug("\n");
			// debug(String.format("\t%s%n", toBinary(out)));
		}
		debug(">>> " + id + "\n");
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

	static private void debug(String msg) {
		if (DEBUG) System.out.print(msg);
	}

	static private String toBinary(int input) {
		return Integer.toString(input, 2);
	}

	static private String toBinary(int input, int pad) {
		return leftPad(Integer.toString(input, 2), pad);
	}

	static private String leftPad(String number, int length) {
		while (number.length() < length) {
			number = "0" + number;
		}
		return number;
	}

	static private final double LOGTWO = Math.log(2);

	static public boolean isPowerOfTwoX(int input) {
		System.out.println();

		double log = Math.log(input) / LOGTWO;
		System.out.format("log(%d): %f%n", input, log);

		double floor = Math.floor(log);
		System.out.format("floor: %f%n", floor);

		double power = Math.pow(2, floor);
		System.out.format("power: %f%n", power);

		int compare = (int) power;
		System.out.format("compare: %d [%d]%n", compare, input);

		return compare == input;
	}

	static public int getLowerPowerOfTwo(int input) {
		return (int) Math.pow(2, Math.floor(Math.log(input) / LOGTWO));
	}

	static public boolean isPowerOfTwo(int input) {
		int compare = (int) Math.pow(2, Math.floor(Math.log(input) / LOGTWO));
		return compare == input;
	}

}
