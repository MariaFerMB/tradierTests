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

    public static boolean isBetweenOf(String start,String end,String dateParam) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        LocalDate date = LocalDate.parse(dateParam);
        return (date.isBefore(endDate) || endDate.isEqual(date))&&(date.isAfter(startDate) || startDate.isEqual(date));
    }
}
