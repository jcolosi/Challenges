package com.google.challenges.level2a;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Answer {

	public static String[] answer(String[] l) {
		Map<Integer, String> data = new TreeMap<Integer, String>();

		for (String version : l) {
			String[] nodes = version.split("\\.");
			int a = Integer.parseInt(nodes[0]);
			int b = nodes.length > 1 ? Integer.parseInt(nodes[1]) : 0;
			int c = nodes.length > 2 ? Integer.parseInt(nodes[2]) : 0;
			int d = nodes.length;
			int key = buildInteger(a, b, c, d);
			data.put(key, version);
		}

		Collection<String> values = data.values();
		String[] out = values.toArray(new String[data.size()]);
		return out;
	}

	static public int buildInteger(int a, int b, int c, int d) {
		int out = 0;
		out += (a & 0x000000ff) << 24;
		out += (b & 0x000000ff) << 16;
		out += (c & 0x000000ff) << 8;
		out += (d & 0x000000ff);
		return out;
	}
}