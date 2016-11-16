package com.google.challenges.prep;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PrepTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testString() {
		DataStore<String> store = new DataStore<String>();
		store.add("business", "adorable", "gleaming", "chess", "week");
		store.add("aback", "eager", "land", "drown", "tall");
		store.add("current", "team", "guide", "sense", "burly");
		store.add("gather", "rural", "attractive", "grumpy", "beam");
		store.add("cat", "purring", "owe", "screw", "watch");
		store.add("spare", "pump", "painstaking", "muddle", "star");
		store.add("tasteful", "mine", "unarmed", "rabbit", "please");
		store.add("happy", "graceful", "jam", "tame", "judge");
		store.add("discussion", "clumsy", "shoe", "straw", "aboard");

		showString(store.index(0).values());
		showString(store.index(1, true).values());
		showString(store.index(2).values());
	}

	@Test
	public void testInteger() {
		DataStore<Integer> store = new DataStore<Integer>();
		store.add(25, 69, 77);
		store.add(94, 43, 81);
		store.add(47, 72, 53);
		store.add(53, 66, 62);
		store.add(24, 93, 93);
		store.add(58, 84, 85);
		store.add(93, 23, 40);
		store.add(10, 46, 38);
		store.add(60, 56, 48);
		store.add(41, 74, 59);
		showInteger(store.index(0).values());
		showInteger(store.index(1, true).values());
		showInteger(store.index(2).values());
	}

	@Test
	public void testObject() {
		DataStore<Object> store = new DataStore<Object>();
		store.add("38", "business", "0.55");
		store.add("28", "adorable", "0.51");
		store.add("23", "gleaming", "0.80");
		store.add("11", "chess", "0.70");
		store.add("36", "week", "0.05");
		store.add("26", "aback", "0.93");
		store.add("26", "eager", "0.89");
		store.add("11", "land", "0.83");
		store.add("89", "drown", "0.07");
		store.add("81", "tall", "0.92");

		showObject(store.index(0).values());
		showObject(store.index(1, true).values());
		showObject(store.index(2).values());
	}

	@Test
	public void testIP() {
		DataStore<String> store = new DataStore<String>();
		for (int i = 0; i < 10; i++) {
			store.add(getRandomIP());
		}
		showString(store.index(0).values());
		showString(store.index(0, true).values());
	}

	private String getRandomIP() {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			if (i > 0) out.append(".");
			out.append((int) (Math.random() * 256));
		}
		return out.toString();
	}

	private void showString(Collection<DataRecord<String>> list) {
		for (DataRecord<String> record : list) {
			System.out.println(record);
		}
		System.out.println();
	}

	private void showInteger(Collection<DataRecord<Integer>> list) {
		for (DataRecord<Integer> record : list) {
			System.out.println(record);
		}
		System.out.println();
	}

	private void showObject(Collection<DataRecord<Object>> list) {
		for (DataRecord<Object> record : list) {
			System.out.println(record);
		}
		System.out.println();
	}

}
