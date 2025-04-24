package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();

        for (Field field : address.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            NotNull notNullAnnotation = field.getAnnotation(NotNull.class);
            String value = null;
            try {
                value = (String) field.get(address);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            if (notNullAnnotation != null && value == null) {
                result.add(field.getName());
            }
        }

        return result;
    }
}
// END
