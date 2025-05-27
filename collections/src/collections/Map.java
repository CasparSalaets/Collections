package collections;

import java.util.Objects;

public interface Map {
	
	/** @immutable */
	class Entry {
		
		/**
		 * @invar | key != null
		 * @invar | value != null
		 */
		private final Object key;
		private final Object value;
		
		/** @post | result != null */
		public Object getKey() { return key; }
		/** @post | result != null */
		public Object getValue() { return value; }
		
		/**
		 * @pre | key != null
		 * @pre | value != null
		 * @post | getKey() == key
		 * @post | getValue() == value
		 */
		public Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public boolean equals(Object other) {
			return other instanceof Entry
				&& key.equals(((Entry)other).getKey())
				&& value.equals(((Entry)other).getValue());
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(key, value);
		}
		
	}
	
	/**
	 * @inspects | this
	 * @creates | result
	 * @post | result != null
	 * @post | result.stream().allMatch(e -> e instanceof Entry)
	 * @post No key appears twice.
	 *       | result.stream().map(e -> ((Entry)e).getKey()).distinct().count()
	 *       | == result.size()
	 */
	Set entrySet();
	
	/**
	 * @post | result == entrySet().stream()
	 *       |     .filter(e -> ((Entry)e).getKey().equals(key))
	 *       |     .map(e -> ((Entry)e).getValue())
	 *       |     .findFirst().orElse(null)
	 */
	Object get(Object key);

	/**
	 * @pre | key != null
	 * @pre | value != null
	 * @mutates | this
	 * @post | entrySet().contains(new Entry(key, value))
	 * @post | old(entrySet()).stream().allMatch(e ->
	 *       |     ((Entry)e).getKey().equals(key) || entrySet().contains(e))
	 * @post | entrySet().stream().allMatch(e ->
	 *       |     ((Entry)e).getKey().equals(key) || old(entrySet()).contains(e))
	 */
	void put(Object key, Object value);
	
	/**
	 * @pre | key != null
	 * @mutates | this
	 * @post | entrySet().stream().allMatch(e -> !((Entry)e).getKey().equals(key)
	 *       |     && old(entrySet()).contains(e))
	 * @post | old(entrySet()).stream().allMatch(e ->
	 *       |     ((Entry)e).getKey().equals(key) || entrySet().contains(e))
	 */
	void remove(Object key);

}