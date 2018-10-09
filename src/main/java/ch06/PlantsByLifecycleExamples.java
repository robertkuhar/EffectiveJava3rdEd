package ch06;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PlantsByLifecycleExamples {
    public void dontDoThis(Plant[] garden) {
        // Using ordinal() to index into an array - DON'T DO THIS!
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }
        for (Plant p : garden) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }
        // Print the results
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n",
                Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }

    public void doThis(Plant[] garden) {
        // Using an EnumMap to associate data with an enum
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }
        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }
        System.out.println(plantsByLifeCycle);
    }

    public void streamingWTF(Plant[] garden) {
        /*
         * BobK:  This is really clever, but it took a while for me to reason out
         * the sequence of events here.
         */
        // Using a stream and an EnumMap to associate data with an enum
        System.out.println(Arrays.stream(garden)
            .collect(Collectors.groupingBy(p -> p.lifeCycle,
                () -> new EnumMap<>(Plant.LifeCycle.class), Collectors.toSet())));
    }
}
