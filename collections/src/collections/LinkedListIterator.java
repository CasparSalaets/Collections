package collections;

import java.util.Iterator;

public class LinkedListIterator implements Iterator {

	public LinkedList.Node node;
	
	public LinkedListIterator(LinkedList linkedList) {
		node = linkedList.sentinel;
	}
	
	public boolean hasNext() { return node != null; }
	
	public Object next() {
		Object result = node;
		node = node.next;
		return result;
	}
	
}
