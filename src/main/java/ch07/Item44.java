package ch07;

@FunctionalInterface
public interface Item44 {

    void foo();

    // void bar(); // -> multiple non-overriding abstract methods found in interface

    default void baz() {

    }

    boolean equals(Object that);
}
