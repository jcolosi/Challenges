package com.google.challenges.level1a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Factors {
	static private final int SIZE = 200;

	static private boolean ready = false;
	static public Map<Integer, List<Integer>> factors;
	static public Set<Integer> primes;

	static {
		init();
	}

	static private void init() {
		if (ready) return;

		factors = new HashMap<Integer, List<Integer>>();
		primes = new HashSet<Integer>();
		for (int i = 1; i <= SIZE; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 1; j <= i; j++) {
				double ratio = ((double) i) / j;
				if (Math.floor(ratio) == ratio) list.add(j);
			}
			factors.put(i, list);
			if (list.size() == 2) primes.add(i);
		}

		ready = true;
	}

	static public void show() {

		System.out.println("{");
		for (int i : factors.keySet()) {
			String out = factors.get(i).toString().replaceFirst("\\[", "{").replaceFirst("\\]", "}");
			System.out.format("%s,%n", out);
		}
		System.out.println("}");
	}

	static public void main(String[] args) {
		show();
	}

}
