package com.google.challenges.level3a;

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
		Assert.assertTrue(test(0, 3, 2));
		Assert.assertTrue(test(17, 4, 14));
		Assert.assertTrue(test(0, 50000, -1));
	}

	@Test
	public void testFour() {
		for (int i = 0; i < 10; i++) {
			testCompare((int) (Math.random() * 1000), (int) (Math.random() * 5000) + 5000);
		}
	}

	private void testCompare(int start, int length) {
		long time;

		time = System.currentTimeMillis();
		int simple = AnswerWorking.answerSimpleDebug(start, length);
		time = System.currentTimeMillis() - time;
		System.out.format("%d,%d => %d [%d]%n%n", start, length, simple, time);

		time = System.currentTimeMillis();
		int warp = Answer.answer(start, length);
		time = System.currentTimeMillis() - time;
		System.out.format("%d,%d => %d [%d]%n%n", start, length, warp, time);

		Assert.assertTrue(simple == warp);
	}

	private boolean test(int start, int length, int expected) {
		int answer = Answer.answer(start, length);
		System.out.format("Test(%d, %d) => %d [%d]%n", start, length, expected, answer); // DEBUG
		return answer == expected;
	}

	static public String toString(String[] input) {
		if (input == null) return "<null>";
		StringBuilder out = new StringBuilder();
		for (String s : input) {
			if (out.length() > 0) out.append(", ");
			out.append(s);
		}
		return out.toString();
	}

}
