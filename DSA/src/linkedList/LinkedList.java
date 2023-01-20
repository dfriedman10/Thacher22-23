package linkedList;


public class LinkedList<T> {
	
	private Node first;

	private class Node {
		
		T info;
		Node next;
		
		public Node(T info) {
			this.info = info;
		}
	}
	
	public void add(T data) {
		
		Node newNode = new Node(data);

		
		if (first == null) {
			first = newNode;
		}
		
		
		Node current;
		for (current = first; 
				current.next != null; current = current.next) {
			continue;
		}
		
		current.next = newNode;
		
	}
	
}
