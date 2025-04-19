package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    String filePath;
    Map<String, String> storage;

    public FileKV(String filePath, Map<String, String> storage) {
        this.filePath = filePath;
        this.storage = storage;

//        Files.createFile(Path.of(filePath));
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> storage = Utils.deserialize(Utils.readFile(filePath));
        storage.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        Map<String, String> storage = Utils.deserialize(Utils.readFile(filePath));
        storage.remove(key);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> storage = Utils.deserialize(Utils.readFile(filePath));
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.deserialize(Utils.readFile(filePath));
    }
}
// END
