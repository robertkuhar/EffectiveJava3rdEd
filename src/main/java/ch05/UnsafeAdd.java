package ch05;

import java.util.ArrayList;
import java.util.List;

public class UnsafeAdd {
    // Fails at runtime - unsafeAdd method uses a raw type (List)!
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // Has compiler-generated cast
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
