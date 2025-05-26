package collections;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class ArrayListIterator implements Iterator {
		
	public ArrayList arrayList;
	public int index;
	
	public ArrayListIterator(ArrayList arrayList) {
		this.arrayList = arrayList;
	}
	
	public boolean hasNext() { return index < arrayList.elements.length; }
	
	public Object next() { return arrayList.elements[index++]; }
}
