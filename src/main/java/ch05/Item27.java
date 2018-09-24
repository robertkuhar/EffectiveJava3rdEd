package ch05;

import java.util.HashSet;
import java.util.Set;

public class Item27 {
    private static class Lark {
    }

    /*
     * $ javac src/main/java/ch05/Item27.java
     * Note: src/main/java/ch05/Item27.java uses unchecked or unsafe operations.
     * Note: Recompile with -Xlint:unchecked for details.
     * $ javac -Xlint:unchecked src/main/java/ch05/Item27.java
     * src/main/java/ch05/Item27.java:11: warning: [unchecked] unchecked conversion
     *        Set<Lark> exaltation = new HashSet();
     *                               ^
     *   required: Set<Lark>
     *   found:    HashSet
     * 1 warning
     */

    public static void main(String[] args) {
        Set<Lark> exaltation = new HashSet();
        Set<Lark> exaltation2 = new HashSet<Lark>();
        Set<Lark> exaltation3 = new HashSet<>();
    }

}
