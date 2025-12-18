package main;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Node {
	private String id;
	private Map<String, String> data = new HashMap<>();

	public Node(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void put(String key, String value) {
		data.put(key, value);
	}

	public String get(String key) {
		return data.get(key);
	}

	public Map<String, String> getData() {
		return data;
	}

	public void removeKeys(List<String> keys) {
		keys.forEach(data::remove);
	}
	
	@Override
	public String toString() {
		return id;
	}
}
