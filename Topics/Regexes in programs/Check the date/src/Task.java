import java.util.*;

class Date {

    public static void main(String[] args) {
        String dateRegex = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$||^([0-9]{4}|[0-9]{2})[./-]([0]?[1-9]|[1][0-2])[./-]([0]?[1-9]|[1|2][0-9]|[3][0|1])$";
        System.out.println(new Scanner(System.in).nextLine().matches(dateRegex) ? "Yes" : "No");
    }
}
