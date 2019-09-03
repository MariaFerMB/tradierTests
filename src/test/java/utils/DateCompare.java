package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateCompare {

    //LocalDateTime


    public static boolean isBeforeOrEqual(String dateParam){
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(dateParam);
        return date.isBefore(currentDate) || currentDate.isEqual(date);
    }

    public static boolean isAfterOrEqual(String dateParam){
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(dateParam);
        return date.isAfter(currentDate) || currentDate.isEqual(date);
    }

//    public static boolean isCorrecteInterval(String dateParam){
//        LocalDateTime currentDate = LocalDateTime.parse(dateParam.replace("T","-"));
//        LocalDate date = LocalDate.parse(dateParam);
//        return date.isAfter(currentDate) || currentDate.isEqual(date);
//    }


    private LocalDateTime formateDate(String date){
        String formateDate = date.replace("T","-").replaceAll(":","-");
        LocalDateTime dateTime = LocalDateTime.parse(formateDate);
        return dateTime;
    }




}
