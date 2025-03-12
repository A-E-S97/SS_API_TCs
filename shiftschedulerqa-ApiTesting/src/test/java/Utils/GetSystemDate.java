package Utils;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//import java.time.LocalDate;
//import java.time.ZoneOffset;
//
//public class GetSystemDate {
//    public static LocalDate dateToday() {
//        //LocalDate currentDate = LocalDate.now();
//        LocalDate currentDate = LocalDate.now(ZoneOffset.UTC);
//        //System.out.println("Current Date: " + currentDate);
//        return currentDate;
//    }
//
//    public static void main(String[] args)
//    {
//        System.out.println(dateToday());
//    }
//}
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static java.time.ZoneOffset.UTC;

public class GetSystemDate
{
        static DateTimeFormatter dateTimeFormatPattern = DateTimeFormatter
                .ofPattern("ddMMyyyyhhmmss");

        public static String dateTime()
        {
            return LocalDateTime.now().format(dateTimeFormatPattern);
        }

        public static void main(String[] args){
            System.out.println(dateTime());
        //}
//}



        String inputDateStr = "2023-08-14T00:00:00Z";
        LocalDateTime inputDateTime = LocalDateTime.parse(inputDateStr, DateTimeFormatter.ISO_DATE_TIME.withZone(UTC));
        LocalDate inputDate = inputDateTime.toLocalDate();
        LocalDateTime currentDate1 = LocalDateTime.now();
        LocalDate currentDate = LocalDate.now(UTC);
        LocalDateTime dateTimeNow =LocalDateTime.now();

        System.out.println("try this: "+ inputDateTime);
        System.out.println(inputDate);
        System.out.println("currentDate " + currentDate);
        System.out.println("dateTimeNow: " + currentDate1);
        System.out.println(dateTimeNow);

        if (inputDate.isBefore(currentDate)) {
            System.out.println("The input date is before the current date.");
        } else if (inputDate.isAfter(currentDate)) {
            System.out.println("The input date is after the current date.");
        } else {
            System.out.println("The input date is the same as the current date.");
        }
    }
}
