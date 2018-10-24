package ch07;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Deck {
    // Iterative Cartesian product computation
    private static List<Card> newDeckOldSchool() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                result.add(new Card(rank, suit));
            }
        }
        return result;
    }

    // Stream-based Cartesian product computation
    private static List<Card> newDeckStreamed() {
        List<Card> result = Stream.of(Suit.values())
            .flatMap(suit ->
                Stream.of(Rank.values())
                    .map(rank -> new Card(rank, suit)))
            .collect(toList());
        return result;
    }
}
