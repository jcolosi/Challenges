package com.google.challenges.level3c.work;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WorkingTest {
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
			Assert.assertTrue(Working.answer(a.in) == a.out);
			Assert.assertTrue(Working.answer2(a.in) == a.out);
			Assert.assertTrue(Working.answer3(a.in) == a.out);
			Assert.assertTrue(Working.answer4(a.in) == a.out);
			Assert.assertTrue(Working.answer5(a.in) == a.out);
			Assert.assertTrue(Working.answer6(a.in) == a.out);
		}
	}

	@Test
	public void testLarge() {
		for (int i = 0; i < 200; i++) {
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
		int a = Working.answer(big);
		int b = Working.answer6(big);
		System.out.format("%s [%s]%n", x.toString(2), x.toString());
		System.out.format("1: %d%n", Working.answer(big));
		System.out.format("2: %d%n", Working.answer2(big));
		System.out.format("3: %d%n", Working.answer3(big));
		System.out.format("4: %d%n", Working.answer4(big));
		System.out.format("5: %d%n", Working.answer5(big));
		System.out.format("6: %d%n", Working.answer6(big));
		System.out.println();
		Assert.assertTrue(a == b);
	}

	static private String getBigInteger() {
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < 32; i++) {
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