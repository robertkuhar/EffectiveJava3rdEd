package ch09;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class Item65 {
    private static void fatalError(String msg) {
        System.err.println(msg);
        System.exit(1);
    }

    public static void main(String[] args) {
        String setImpl = args[0];

        // Translate the class name into a Class object
        Class<? extends Set<String>> cl = null;
        try {
            // Unchecked cast!
            cl = (Class<? extends Set<String>>) Class.forName(setImpl);
        } catch (ClassNotFoundException e) {
            fatalError("Class not found.");
        }
        // Get the constructor
        Constructor<? extends Set<String>> cons = null;
        try {
            cons = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("No parameterless constructor");
        }
        // Instantiate the set
        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch (IllegalAccessException e) {
            fatalError("Constructor not accessible");
        } catch (InstantiationException e) {
            fatalError("Class not instantiable.");
        } catch (InvocationTargetException e) {
            fatalError("Constructor threw " + e.getCause());
        } catch (ClassCastException e) {
            fatalError("Class doesn't implement Set");
        }
        // Exercise the set
        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.printf("The %s contains %s", s.getClass().getName(), s);
    }
}
