package ch07;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WTFNoThrows {
    public static void main(String[] args) throws IOException {
        List<String> stuff = Arrays.asList("1", "10", "2", "200");

        stuff.stream().filter(e -> {
            /*
             * BobK:  That don't make no sense at all, no Checked Exceptions in there, but RuntimeException is fine?
             * Leaky abstraction on Predicate?  https://stackoverflow.com/questions/42739139/why-cant-we-throw-exception-inside-java-8-stream
             */
            // throw new Exception("WTF");
            return e.startsWith("1");
        }).forEach(System.out::println);
    }
}
