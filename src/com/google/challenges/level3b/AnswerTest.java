package com.google.challenges.level3b;

import org.junit.Test;

public class AnswerTest {

	@Test
	public void test() {
		int[][] data1 = { { 0, 1, 1, 0 }, { 0, 0, 0, 1 }, { 1, 1, 0, 0 }, { 1, 1, 1, 0 } };
		Answer.answer(data1);
		int[][] data2 = { { 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0 } };
		Answer.answer(data2);

	}

}
