import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String regex = "\\b((25[0-5]|2[0-4]\\d|[01]?\\d{1,2})(\\.|$)){4}\\b";
        System.out.println(new Scanner(System.in).nextLine().matches(regex) ? "YES" : "NO");
    }
}
