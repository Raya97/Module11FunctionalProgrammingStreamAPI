import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        // Завдання 1: Отримання рядка з іменами під нечітними індексами
        List<String> names = Arrays.asList("Іван", "Петро", "Ірина", "Марія", "Олександр", "Ольга");
        String oddIndexedNamesString = getOddIndexedNamesString(names);
        System.out.println("Завдання 1: " + oddIndexedNamesString);

        // Завдання 2: Отримання списку рядків у верхньому регістрі, відсортованих у зворотному порядку
        List<String> strings = Arrays.asList("яблуко", "банан", "апельсин", "виноград");
        List<String> sortedUpperCaseStrings = getSortedUpperCaseStrings(strings);
        System.out.println("Завдання 2: " + sortedUpperCaseStrings);

        // Завдання 3: Отримання відсортованих чисел із масиву рядків
        String[] numberArrays = {"1, 2, 0", "4, 5"};
        String sortedNumbersString = getSortedNumbersString(numberArrays);
        System.out.println("Завдання 3: " + sortedNumbersString);

        // Завдання 4: Отримання нескінченного стріму випадкових чисел
        Stream<Long> randomStream = generateRandomStream(25214903917L, 11L, (1L << 48), 12345L);
        randomStream.limit(10).forEach(System.out::println);

        // Завдання 5: "Перемішування" елементів із двох стрімів
        Stream<Integer> firstStream = Stream.of(1, 2, 3, 4);
        Stream<Integer> secondStream = Stream.of(5, 6, 7, 8, 9);
        Stream<Integer> zippedStream = zip(firstStream, secondStream);
        zippedStream.forEach(System.out::println);
    }

    // Завдання 1
    public static String getOddIndexedNamesString(List<String> names) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (i % 2 != 0) {
                result.append((i + 1)).append(". ").append(names.get(i)).append(", ");
            }
        }
        // Видалення останніх двох символів (зайвої коми та пробілу) з результату
        if (result.length() > 2) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }

    // Завдання 2
    public static List<String> getSortedUpperCaseStrings(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // Завдання 3
    public static String getSortedNumbersString(String[] numberArrays) {
        return Arrays.stream(numberArrays)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    // Завдання 4
    public static Stream<Long> generateRandomStream(long a, long c, long m, long seed) {
        return Stream.iterate(seed, n -> (a * n + c) % m);
    }

    // Завдання 5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> secondIterator = second.iterator();
        return first.flatMap(e -> secondIterator.hasNext() ? Stream.of(e, secondIterator.next()) : Stream.of(e));
    }
}
