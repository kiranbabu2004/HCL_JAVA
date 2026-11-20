
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;

 class Main {
    public static void main(String[] args) {

        // Create a list of employee attendance percentages
        List<Integer> attendance = Arrays.asList(95, 45, 80, 30, 100);

        // Predicate to check attendance >= 75
        Predicate<Integer> eligible = a -> a >= 75;

        // Consumer to print attendance percentage
        Consumer<Integer> print = a -> System.out.println(a + "%");

        // Process the list using forEach()
        attendance.forEach(a -> {
            if (eligible.test(a)) {
                print.accept(a);
            }
        });
    }
}
