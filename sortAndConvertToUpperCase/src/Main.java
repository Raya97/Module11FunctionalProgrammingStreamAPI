import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<String> uppercaseAndSort(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "cherry", "date", "grape");
        List<String> result = uppercaseAndSort(strings);
        System.out.println(result);
    }
}
