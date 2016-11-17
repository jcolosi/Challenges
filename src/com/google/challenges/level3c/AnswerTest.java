package com.google.challenges.level3c;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnswerTest {
	static private ArrayList<A> small;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		small = new ArrayList<A>();
		small.add(new A("4", 2));
		small.add(new A("16", 4));
		small.add(new A("64", 6));
		small.add(new A("3", 2));
		small.add(new A("15", 5));
		small.add(new A("22", 6));
		small.add(new A("23", 6));
		small.add(new A("43", 8));
		small.add(new A("0", 1));
		small.add(new A("1", 0));
		small.add(new A("2", 1));
	}

	@Test
	public void assertSmall() {
		for (A a : small) {
			Assert.assertTrue(Answer.answer(a.in) == a.out);
		}
	}

	@Test
	public void testLarge() {
		for (int i = 0; i < 200; i++) {
			String big = getBigInteger(32);
			int x = Answer.answer(big);
			System.out.format("%s: %d%n", big, x);
		}
	}

	@Test
	public void testVeryLarge() {
		for (int i = 0; i < 200; i++) {
			String big = getBigInteger(309);
			int x = Answer.answer(big);
			System.out.format("%s: %d%n", big, x);
		}
	}

	static private String getBigInteger(int x) {
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < x; i++) {
			out.append((int) (Math.random() * 10));
		}
		return out.toString();
	}

}

class A {
	public String in;
	public int out;

	public A(String in, int out) {
		this.in = in;
		this.out = out;
	}
}