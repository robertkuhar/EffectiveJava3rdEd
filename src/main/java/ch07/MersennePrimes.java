package ch07;

import java.math.BigInteger;
import java.util.stream.Stream;

public class MersennePrimes {
    private static final BigInteger TWO = BigInteger.valueOf(2L);

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
            .filter(mersenne -> mersenne.isProbablePrime(50))
            .limit(20)
            .forEach(System.out::println);
    }
}
