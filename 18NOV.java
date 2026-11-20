
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Order {
    int orderId;
    String customerName;
    String product;
    String category;
    double amount;
    String status;
    String city;

    Order(int orderId, String customerName, String product,
          String category, double amount, String status, String city) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        this.category = category;
        this.amount = amount;
        this.status = status;
        this.city = city;
    }

    public String toString() {
        return orderId + " " + customerName + " " +
               product + " " + category + " " +
               amount + " " + status + " " + city;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
            new Order(101, "Ravi", "Laptop", "Electronics", 55000, "Delivered", "Vijayawada"),
            new Order(102, "Kiran", "Mobile", "Electronics", 25000, "Pending", "Guntur"),
            new Order(103, "Sai", "Shoes", "Fashion", 3000, "Delivered", "Hyderabad"),
            new Order(104, "Arjun", "Watch", "Fashion", 5000, "Cancelled", "Guntur"),
            new Order(105, "Rahul", "TV", "Electronics", 40000, "Delivered", "Vijayawada"),
            new Order(106, "Teja", "Bag", "Fashion", 2000, "Pending", "Hyderabad")
        );

        // 1. Filter orders based on amount and status
        System.out.println("\n1. FILTER ORDERS:");
        orders.stream()
              .filter(o -> o.amount > 5000 && o.status.equals("Delivered"))
              .forEach(System.out::println);

        // 2. Sort orders by amount
        System.out.println("\n2. SORT BY AMOUNT:");
        orders.stream()
              .sorted(Comparator.comparingDouble(o -> o.amount))
              .forEach(System.out::println);

        // 3. Highest and Lowest order amounts
        System.out.println("\n3. HIGHEST AND LOWEST:");
        double highest = orders.stream()
                .mapToDouble(o -> o.amount)
                .max().orElse(0);

        double lowest = orders.stream()
                .mapToDouble(o -> o.amount)
                .min().orElse(0);

        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);

        // 4. Calculate total sales
        System.out.println("\n4. TOTAL SALES:");
        double total = orders.stream()
                .mapToDouble(o -> o.amount)
                .sum();

        System.out.println("Total Sales: " + total);

        // 5. Count number of orders
        System.out.println("\n5. TOTAL ORDERS:");
        long count = orders.stream().count();
        System.out.println("Number of Orders: " + count);

        // 6. Group orders by category
        System.out.println("\n6. GROUP BY CATEGORY:");
        Map<String, List<Order>> categoryGroup =
                orders.stream()
                      .collect(Collectors.groupingBy(o -> o.category));

        categoryGroup.forEach((key, value) ->
                System.out.println(key + " : " + value));

        // Group orders by city
        System.out.println("\nGROUP BY CITY:");
        Map<String, List<Order>> cityGroup =
                orders.stream()
                      .collect(Collectors.groupingBy(o -> o.city));

        cityGroup.forEach((key, value) ->
                System.out.println(key + " : " + value));

        // 7. Calculate average order amount
        System.out.println("\n7. AVERAGE ORDER AMOUNT:");
        double average = orders.stream()
                .mapToDouble(o -> o.amount)
                .average().orElse(0);

        System.out.println("Average: " + average);

        // 8. Count orders by status using Collectors
        System.out.println("\n8. COUNT BY STATUS:");
        Map<String, Long> statusCount =
                orders.stream()
                      .collect(Collectors.groupingBy(
                          o -> o.status,
                          Collectors.counting()
                      ));

        statusCount.forEach((key, value) ->
                System.out.println(key + " : " + value));
    }
}
