import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String getOddIndexedNames(List<String> names) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (i % 2 == 0) {
                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(i + 1).append(". ").append(names.get(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Peter");
        names.add("Alex");
        names.add("John");
        names.add("Mike");

        String result = getOddIndexedNames(names);
        System.out.println(result); // Output: "1. Ivan, 3. Alex, 5. Mike"
    }
}
