package hashMapNull;

import java.util.HashMap;

public class MyHashMap<K, V> extends HashMap<K, V> {
    private boolean allowNullKeys = false;

    public MyHashMap(boolean allowNullKeys) {
        this.allowNullKeys = allowNullKeys;
    }

    public MyHashMap() {
        this.allowNullKeys = false;
    }

    @Override
    public V put(K key, V value) {
        if (!this.allowNullKeys && key == null) {
            throw new NullHashMapKey("You cannot pass null as key in the hashmap.");
        }

        return super.put(key, value);
    }

    @Override
    public V get(Object key) {
        if (!this.allowNullKeys && key == null) {
            throw new NullHashMapKey("Key cannot be null. This hash map doesnt countain null keys.");
        }

        return super.get(key);
    }
}