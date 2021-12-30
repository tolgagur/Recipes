import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int totalSecs = scanner.nextInt();


    String time2 = scanner.nextLine();
    LocalTime localTime = LocalTime.parse(time2).withSecond(0);




    int hours = totalSecs / 3600;
    int minutes = (totalSecs % 3600) / 60;
    int seconds = totalSecs % 60;


    System.out.println(LocalTime.of(hours, minutes, seconds));
    LocalTime time = LocalTime.ofSecondOfDay(seconds);

    System.out.println(localTime);







  }
}