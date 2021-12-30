import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class main {
    /* Do not change code below */
    public static void main(String[] args) {
        LocalDateTime time1 = LocalDateTime.parse("2017-03-04T11:20");
        LocalDateTime time2 = LocalDateTime.parse("2017-03-06T11:40");


        System.out.println(time1.compareTo(time1));
        System.out.println(time1.compareTo(time2));
        System.out.println(time1.isAfter(time2));
        System.out.println(time2.compareTo(time1));
        System.out.println(time1.isBefore(time1));


    }
}