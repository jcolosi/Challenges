package com.google.challenges.level2b;

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
		Assert.assertTrue(test("1211", 10, 1));
		Assert.assertTrue(test("210022", 3, 3));
		Assert.assertTrue(test("6147", 10, 1));
	}

	private boolean test(String input, int base, int expected) {
		int answer = Answer.answer(input, base);
		System.out.format("Test: %s, %d (%d <=> %d)%n%n", input, base, expected, answer); // DEBUG
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
