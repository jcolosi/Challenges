package com.google.challenges;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class AnswerTest {

	@Test
	public void testSmall() {
		Assert.assertTrue(Answer.answer("23") == 6);
		Assert.assertTrue(Answer.answer("43") == 8);
		Assert.assertTrue(Answer.answer("16") == 4);
		Assert.assertTrue(Answer.answer("64") == 6);
		Assert.assertTrue(Answer.answer("4") == 2);
		Assert.assertTrue(Answer.answer("15") == 5);
		Assert.assertTrue(Answer.answer("22") == 6);

		Assert.assertTrue(Answer.answer3("23") == 6);
		Assert.assertTrue(Answer.answer3("43") == 8);
		Assert.assertTrue(Answer.answer3("16") == 4);
		Assert.assertTrue(Answer.answer3("64") == 6);
		Assert.assertTrue(Answer.answer3("4") == 2);
		Assert.assertTrue(Answer.answer3("15") == 5);
		Assert.assertTrue(Answer.answer3("22") == 6);
	}

	@Test
	public void testLarge() {
		for (int i = 0; i < 2; i++) {
			String big = getBigInteger();
			BigInteger x = new BigInteger(big);
			System.out.format("%s (%d, %d, %d)%n", x.toString(), Answer.answer(big),
					Answer.answer2(big), Answer.answer3(big));
		}
		// System.out.format(">>> %d%n", Answer.answer(getBigInteger()));
	}

	@Test
	public void testCompare() {
		compare("23");
		compare("43");
		compare("16");
		compare("64");
		compare("4");
		compare("15");
		compare("22");
	}

	private void compare(String big) {
		BigInteger x = new BigInteger(big);
		System.out.format("%s (%d, %d, %d)%n", x.toString(), Answer.answer(big),
				Answer.answer2(big), Answer.answer3(big));
	}

	static private String getBigInteger() {
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < 16; i++) {
			out.append((int) (Math.random() * 10));
		}
		return out.toString();
	}

}