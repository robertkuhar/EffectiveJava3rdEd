package ch05;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /*
     * The elements array will contain only E instances from push(E).
     * This is sufficient to ensure type safety, but the runtime
     * type of the array won't be E[]; it will always be Object[]!
     */
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /*
     * Wildcard type for a parameter that serves as an E producer.
     * PECS stands for producer-extends, consumer-super.
     * pushAll’s src parameter produces E instances for use by the Stack
     */
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    /*
     * Wildcard type for parameter that serves as an E consumer
     * PECS stands for producer-extends, consumer-super.
     * popAll’s dst parameter consumes E instances from the Stack
     */
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}

