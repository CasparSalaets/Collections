package collections;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class ClientProgram {
	
	public void printAll(Iterator iterator) {
		while (iterator.hasNext())
			System.out.println(iterator.next());
	}
	
	public void printBoth(ArrayList arrayList, LinkedList linkedList) {
		printAll(new ArrayListIterator(arrayList));
		printAll(new LinkedListIterator(linkedList));
	}
	
	// When ArrayList and LinkedList implement Iterable the code above can be simplified to
	public void printAll1(Iterable iterable) {
		for (Iterator iterator = iterable.iterator(); iterator.hasNext();)
			System.out.println(iterator.next());
	}
	
	public void printBoth1(Iterable collection1, Iterable collection2) {
		printAll1(collection1);
		printAll1(collection2);
	}
	
}
