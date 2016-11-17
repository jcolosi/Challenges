package com.google.challenges.level3c;

import java.math.BigInteger;
import java.util.ArrayList;

public class Answer {

	public static int answer(String n) {
		if (n.equals("0")) return 1;
		if (n.equals("1")) return 0;
		if (n.equals("2")) return 1;
		Blob number = new Blob(n);
		int count = 0;
		while (true) {
			if (number.done()) return count + 2;
			if (!number.first()) number.shift();
			else if (number.second()) number.up();
			else number.down();
			count++;
		}
	}

}

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
