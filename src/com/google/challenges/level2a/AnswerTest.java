package com.google.challenges.level2a;

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
		Assert.assertTrue(test(new String[] { "2", "1" }, new String[] { "1", "2" }));
		Assert.assertTrue(test(new String[] { "1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2" },
				new String[] { "1.0", "1.0.2", "1.0.12", "1.1.2", "1.3.3" }));
		Assert.assertTrue(test(new String[] { "1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0" },
				new String[] { "0.1", "1.1.1", "1.2", "1.2.1", "1.11", "2", "2.0", "2.0.0" }));
	}

	private boolean test(String[] input, String[] expected) {
		String[] answer = Answer.answer(input);
		System.out.format("Assert %s => %s%n", toString(expected), toString(answer)); // DEBUG

		if (expected == null || answer == null) return false;
		if (expected.length != answer.length) return false;
		for (int i = 0; i < expected.length; i++) {
			if (!expected[i].equals(answer[i])) return false;
		}
		return true;
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
