package com.google.challenges.prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Prep {

}

@SuppressWarnings("serial")
class DataStore<T> extends ArrayList<DataRecord<T>> {

	@SafeVarargs
	public final void add(T... args) {
		this.add(new DataRecord<T>(args));
	}

	public TreeMap<T, DataRecord<T>> index(int which) {
		return index(which, false);
	}

	public TreeMap<T, DataRecord<T>> index(int which, boolean reverse) {
		TreeMap<T, DataRecord<T>> out;
		if (reverse) out = new TreeMap<T, DataRecord<T>>(Collections.reverseOrder());
		else out = new TreeMap<T, DataRecord<T>>();
		for (DataRecord<T> record : this) {
			out.put(record.get(which), record);
		}
		return out;
	}

}

@SuppressWarnings("serial")
class DataRecord<T> extends ArrayList<T> {

	@SafeVarargs
	public DataRecord(T... args) {
		for (T arg : args) {
			super.add(arg);
		}
	}

}