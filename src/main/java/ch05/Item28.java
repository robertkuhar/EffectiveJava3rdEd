package ch05;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Item28 {
    class SimpleChooser {
        private final Object[] choiceArray;

        public SimpleChooser(Collection choices) {
            choiceArray = choices.toArray();
        }

        public Object choose() {
            Random rnd = ThreadLocalRandom.current();
            return choiceArray[rnd.nextInt(choiceArray.length)];
        }
    }

    class TypeSafeChooser<T> {
        private final List<T> choiceList;

        // Original signature was TypeSafeChooser(Collection<T> choices) changed by Item 31
        public TypeSafeChooser(Collection<? extends T> choices) {
            choiceList = new ArrayList<>(choices);
        }

        public T choose() {
            Random rnd = ThreadLocalRandom.current();
            return choiceList.get(rnd.nextInt(choiceList.size()));
        }
    }

    private static final String[] DEFAULT_ELEMENTS = { "moe", "larry", "curly", "shemp" };

    public static void main(String[] args) {

        String[] elements = (args.length > 0) ? args : DEFAULT_ELEMENTS;
        Stack<String> stack = new Stack<>();
        for (String element : elements) {
            stack.push(element);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
