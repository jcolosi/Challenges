package com.google.challenges;

import java.math.BigInteger;
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
	}

	// @Test
	public void assertSmall() {
		for (A a : small) {
			Assert.assertTrue(Answer.answer(a.in) == a.out);
			Assert.assertTrue(Answer.answer2(a.in) == a.out);
			Assert.assertTrue(Answer.answer3(a.in) == a.out);
			Assert.assertTrue(Answer.answer4(a.in) == a.out);
		}
	}

	@Test
	public void testLarge() {
		for (int i = 0; i < 2; i++) {
			compare(getBigInteger());
		}
	}

	@Test
	public void testSmall() {
		for (A a : small) {
			compare(a.in);
		}
	}

	private void compare(String big) {
		BigInteger x = new BigInteger(big);
		System.out.format("%s [%s]%n", x.toString(2), x.toString());
		System.out.format("1: %d%n", Answer.answer(big));
		System.out.format("2: %d%n", Answer.answer2(big));
		System.out.format("3: %d%n", Answer.answer3(big));
		System.out.format("4: %d%n", Answer.answer4(big));
		System.out.println();
	}

	static private String getBigInteger() {
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < 16; i++) {
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