import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class WeightedGraph {

	private Map<Integer, Map<Integer, Double>> map = new HashMap<>();

	public boolean addNode(int node) {
		if (map.containsKey(node)) return false;
		map.put(node, new HashMap<Integer, Double>());
		return true;
	}

	public void addEdge(int src, int dest, double weight) {
		if (!map.containsKey(src) || !map.containsKey(dest))
			throw new NoSuchElementException("both nodes must be in the graph");
		map.get(src).put(dest, weight);
	}

	public void removeEdge(int src, int dest) {
		if (!map.containsKey(src) || !map.containsKey(dest))
			throw new NoSuchElementException("both nodes must be in the graph");
		map.get(src).remove(dest);
	}

	public boolean containsNode(int node) {
		return map.containsKey(node);
	}

	public Iterable<Integer> adjacents(int node) {
		Map<Integer, Double> edges = map.get(node);
		if (edges == null)
			throw new NoSuchElementException("node doesnot exist in the graph");
		return edges.keySet();
	}

	public double cost(int src, int dest) {
		if (!map.containsKey(src) || !map.containsKey(dest))
			throw new NoSuchElementException("both nodes must be in the graph");
		Double weight = map.get(src).get(dest);
		if (weight == null)
			throw new NoSuchElementException("edge doesnot exist in the graph");
		return weight;
	}

	public Iterator<Integer> iterator() {return map.keySet().iterator();}
	public String toString() {return map.toString();}
	public int size() {return map.size();}
	public boolean empty() {return map.isEmpty();}
}