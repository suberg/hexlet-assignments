package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    Map<String, String> storage = new HashMap<>();

    public InMemoryKV(Map<String, String> initial) {
        storage.putAll(initial);
    }

    @Override
    public void set(String key, String value) {
        if (storage.containsKey(key)) {
            storage.replace(key, value);
        } else {
            storage.put(key, value);
        }
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }
}
// END
