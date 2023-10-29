package migdal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// -- The exercise I got to do in a job interview at Migdal

public class Casche<T> {

	int capacity;

	List<String> keys;
	HashMap<String, T> map;

	public Casche(int capacity) {
		super();
		this.capacity = capacity;
		keys = new LinkedList<>();
		map = new HashMap<>();
	}

	public T get(String key) {
		T t = map.get(key);
		if (t != null) {
			// -- move t to the head of keys;
			moveToHead(key);
			//removeTail();
		}
		return t;
	}

	public void put(String key, T value) {
		T tmp = map.get(key);
		if (tmp == null) {
			map.put(key, value);
			keys.add(0, key);
			if (keys.size() > capacity) {
				// remove tail
				removeTail();
			}
			
		} else { // -- replace
			map.put(key, value);
			// -- move t to the head of keys;
			moveToHead(key);
		}
	}

	private void moveToHead(String key) {

		// Runnable mover = () -> {
		try {
			int idx = keys.indexOf(key);
			if (idx > 0)
				keys.remove(idx);
			keys.add(0, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// };
		// new Thread(mover).start();
	}

	private void removeTail() {
		if (keys.size() < capacity)
			return;
		String kToRemove = keys.get(capacity);
		keys.remove(kToRemove); // -- cut the tail

		map.remove(kToRemove);
	}

	public List<String> getKeys() {

		try {
			List<String> output = new ArrayList<>();// .asList(keys);

			output.addAll(keys);
			return output;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
