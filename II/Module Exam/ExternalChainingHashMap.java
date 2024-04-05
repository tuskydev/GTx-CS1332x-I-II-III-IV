import java.util.NoSuchElementException;

/**
 * Your implementation of a ExternalChainingHashMap.
 */
public class ExternalChainingHashMap<K, V> {

    /*
     * The initial capacity of the ExternalChainingHashMap when created with the
     * default constructor.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * The max load factor of the ExternalChainingHashMap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final double MAX_LOAD_FACTOR = 0.67;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private ExternalChainingMapEntry<K, V>[] table;
    private int size;

    /**
     * Constructs a new ExternalChainingHashMap with an initial capacity of INITIAL_CAPACITY.
     */
    public ExternalChainingHashMap() {
        //DO NOT MODIFY THIS METHOD!
        table = (ExternalChainingMapEntry<K, V>[]) new ExternalChainingMapEntry[INITIAL_CAPACITY];
    }

    /**
     * Gets the value associated with the given key.
     *
     * @param key The key to search for in the map. You may assume that the
     *            key is never null.
     * @return The value associated with the given key.
     * @throws java.util.NoSuchElementException If the key is not in the map.
     */
    public V get(K key) {
        int hash = Math.abs(key.hashCode() % table.length);
        ExternalChainingMapEntry<K, V> curr = table[hash];

        while (curr != null) {
            if (curr.getKey().equals(key)) {
                return curr.getValue();
            }

            curr = curr.getNext();
        }

        throw new NoSuchElementException("Key not found!");
    }

    /**
     * Returns the table of the map.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The table of the map.
     */
    public ExternalChainingMapEntry<K, V>[] getTable() {
        // DO NOT MODIFY THIS METHOD!
        return table;
    }

    /**
     * Returns the size of the map.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the map.
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}

/*
[Executed at: Fri Apr 5 12:41:15 PDT 2024]

============================================================
ExternalChainingHashMap.java successfully compiled.
============================================================
Success: All Tests Passed.

Score: 10.0 / 10.0
============================================================
*/