import java.time.*;
import java.time.format.DateTimeFormatter;

public class main4 {

    public static void main(String[] args) {

        // 1. LOCALDATE
        System.out.println("\n1. LOCALDATE");
        LocalDate date = LocalDate.now();
        System.out.println("Current Date: " + date);

        // 2. LOCALTIME
        System.out.println("\n2. LOCALTIME");
        LocalTime time = LocalTime.now();
        System.out.println("Current Time: " + time);

        // 3. LOCALDATETIME
        System.out.println("\n3. LOCALDATETIME");
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + dateTime);

        // 4. CREATE CUSTOM DATE
        System.out.println("\n4. CUSTOM DATE");
        LocalDate customDate = LocalDate.of(2026, 11, 19);
        System.out.println("Custom Date: " + customDate);

        // 5. CREATE CUSTOM TIME
        System.out.println("\n5. CUSTOM TIME");
        LocalTime customTime = LocalTime.of(10, 30, 45);
        System.out.println("Custom Time: " + customTime);

        // 6. GET YEAR, MONTH, DAY
        System.out.println("\n6. DATE DETAILS");
        System.out.println("Year: " + date.getYear());
        System.out.println("Month: " + date.getMonth());
        System.out.println("Day: " + date.getDayOfMonth());

        // 7. ADD DAYS
        System.out.println("\n7. ADD DAYS");
        System.out.println("After 5 Days: " + date.plusDays(5));

        // 8. SUBTRACT DAYS
        System.out.println("\n8. MINUS DAYS");
        System.out.println("Before 5 Days: " + date.minusDays(5));

        // 9. ADD MONTHS
        System.out.println("\n9. ADD MONTHS");
        System.out.println("After 2 Months: " + date.plusMonths(2));

        // 10. COMPARE DATES
        System.out.println("\n10. COMPARE DATES");
        LocalDate date1 = LocalDate.of(2026, 11, 19);
        LocalDate date2 = LocalDate.of(2026, 12, 19);

        System.out.println("Is date1 before date2? " + date1.isBefore(date2));
        System.out.println("Is date1 after date2? " + date1.isAfter(date2));
        System.out.println("Are dates equal? " + date1.isEqual(date2));

        // 11. PERIOD
        System.out.println("\n11. PERIOD");
        Period period = Period.between(date1, date2);
        System.out.println("Difference: " + period);

        // 12. DURATION
        System.out.println("\n12. DURATION");
        LocalTime start = LocalTime.of(10, 0);
        LocalTime end = LocalTime.of(12, 30);

        Duration duration = Duration.between(start, end);
        System.out.println("Hours: " + duration.toHours());
        System.out.println("Minutes: " + duration.toMinutes());

        // 13. FORMAT DATE
        System.out.println("\n13. FORMAT DATE");
        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Formatted Date: " + date.format(formatter));

        // 14. DAY OF WEEK
        System.out.println("\n14. DAY OF WEEK");
        System.out.println("Today: " + date.getDayOfWeek());

        // 15. MONTH
        System.out.println("\n15. MONTH");
        System.out.println("Current Month: " + date.getMonth());

    }
}