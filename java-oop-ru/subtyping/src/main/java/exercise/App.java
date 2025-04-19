package exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> copy = new HashMap<>();

        for (Entry<String, String> storageSet : storage.toMap().entrySet()) {
            String key = storageSet.getKey();
            String value = storageSet.getValue();

            copy.put(value, key);
        }

        for (Entry<String, String> copySet : copy.entrySet()) {
            storage.unset(copySet.getValue());
        }


        for (Entry<String, String> copySet : copy.entrySet()) {
            String key = copySet.getKey();
            String value = copySet.getValue();

            storage.set(key, value);
        }
    }
}
// END
