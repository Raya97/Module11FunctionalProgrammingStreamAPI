import java.util.stream.Stream;

public class Main {
    public static Stream<Long> linearCongruentialGenerator(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (1L << 48);
        long seed = 12345L;

        Stream<Long> generatedStream = linearCongruentialGenerator(a, c, m, seed);
        generatedStream.limit(10).forEach(System.out::println);
    }
}