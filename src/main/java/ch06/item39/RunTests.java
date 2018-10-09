package ch06.item39;

// Program to process marker annotations

import java.lang.reflect.*;

public class RunTests {
    public static void main(String[] args) throws Exception {
        final String testClassName = (args.length == 0) ? Sample.class.getName() : args[0];
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(testClassName);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
