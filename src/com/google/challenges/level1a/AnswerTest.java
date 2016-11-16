package com.google.challenges.level1a;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnswerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testManual() {
		Assert.assertTrue(test("abccbaabccba", 2));
	}

	@Test
	public void testRandom() {
		for (int i = 0; i < 10000; i++) {
			int pieces = (int) (Math.random() * 20) + 1;
			Assert.assertTrue(test(getRandomCake(pieces), pieces));
		}
	}

	@Test
	public void testNegative() {
		Integer[] primes = new Integer[Factors.primes.size()];
		primes = Factors.primes.toArray(primes);

		for (int i = 0; i < 100; i++) {
			int index = (int) (Math.random() * Factors.primes.size());
			String cake = getRandomPiece(primes[index] - 1) + 'z';
			Assert.assertTrue(test(cake, 1));
		}
	}

	private boolean test(String s, int n) {
		System.out.format("%s=>%d%n%n", s, Answer.answer(s)); // DEBUG
		return Answer.answer(s) == n;
	}

	private String getRandomCake(int pieces) {
		StringBuilder out = new StringBuilder();
		int size = (int) (Math.random() * 10);
		String cake = getRandomPiece(size) + 'z';
		for (int i = 0; i < pieces; i++) {
			out.append(cake);
		}
		System.out.format("\"%s\" x %d =>%s%n", cake, pieces, out.toString()); // DEBUG
		return out.toString();
	}

	private String getRandomPiece(int size) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < size; i++) {
			out.append(getRandomColor());
		}
		return out.toString();
	}

	private char getRandomColor() {
		return (char) ('a' + ((int) (Math.random() * 25)));
	}

}
