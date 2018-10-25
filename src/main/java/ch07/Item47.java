package ch07;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Item47 {

    static List<String> words = ImmutableList.of("hello", "world", "bye");

    public static void main(String[] args) {

        Iterable<String> lines = () -> words.iterator(); // functional interface!
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
