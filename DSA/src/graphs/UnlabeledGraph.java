package graphs;

import java.util.HashMap;
import java.util.HashSet;

public class UnlabeledGraph<E> {
	
	public class Vertex {
		E info;
		HashSet<Vertex> neighbors;
		
		public Vertex(E info) {
			this.info = info;
			neighbors = new HashSet<Vertex>();
		}
	}
	
	HashMap<E, Vertex> vertices = new HashMap<E, Vertex>();

	public void add(E info) {
		Vertex v = new Vertex(info);
		
		if (vertices.containsKey(info)) {
			System.out.println("this data is already stored");
		}
		else {
			vertices.put(info, v);
		}
	}
	
	public void connect(E info1, E info2) {
		
		Vertex v1 = vertices.get(info1), v2 = vertices.get(info2);
		
		if (v1 == null) {
			System.out.println("Data " + 
					info1.toString() + " does not exist in graph");
		}
		else if (v2 == null) {
			System.out.println("Data " + 
					info2.toString() + " does not exist in graph");
		}
		else {
			v1.neighbors.add(v2);
			v2.neighbors.add(v1);
		}
	}
	
	public void remove(E info) {
		
		Vertex v = vertices.get(info);
		
		if (v == null) {
			System.out.println("Data not found");
		}
		
		else {
			
			for (Vertex neighbor : v.neighbors) {
				neighbor.neighbors.remove(v);
			}
		
			vertices.remove(info);
		}
	}
	
}