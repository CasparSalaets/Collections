package collections;

import java.util.Iterator;

public interface Iterable {
	
	/** Returns a new iterator that points to the start of the data structure. */
	@SuppressWarnings("rawtypes")
	Iterator iterator();

}
