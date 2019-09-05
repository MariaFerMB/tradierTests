package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateCompare {

    public static boolean isBeforeOrEqual(String dateParam) {
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(dateParam);
        return date.isBefore(currentDate) || currentDate.isEqual(date);
    }

    public static boolean isAfterOrEqual(String dateParam) {
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(dateParam);
        return date.isAfter(currentDate) || currentDate.isEqual(date);
    }

    public static boolean isEqual(String dateParam) {
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(dateParam);
        return currentDate.isEqual(date);
    }

    public static boolean isEqualForDateTime(String dateParam) {
        LocalDate currentDate = LocalDate.now();
        LocalDateTime date = LocalDateTime.parse(dateParam);
        return currentDate.isEqual(date.toLocalDate());
    }
}
