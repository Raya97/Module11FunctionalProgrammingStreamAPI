import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<String> sortAndConvertToUpperCase(List<String> strings) {
        List<String> result = new ArrayList<>(strings);
        Collections.sort(result, Collections.reverseOrder());
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).toUpperCase());
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Peter");
        names.add("Alex");
        names.add("John");
        names.add("Mike");

        List<String> result = sortAndConvertToUpperCase(names);
        System.out.println(result); // Output: ["PETER", "MIKE", "JOHN", "IVAN", "ALEX"]
    }
}