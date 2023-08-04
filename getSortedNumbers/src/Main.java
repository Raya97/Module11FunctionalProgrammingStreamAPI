import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static String getSortedNumbers(String[] arrays) {
        return Arrays.stream(arrays)
                .flatMap(s -> Arrays.stream(s.split(",\\s*")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        String[] arrays = {"1, 2, 0", "4, 5"};

        String result = getSortedNumbers(arrays);
        System.out.println(result); // Output: "0, 1, 2, 4, 5"
    }
}
