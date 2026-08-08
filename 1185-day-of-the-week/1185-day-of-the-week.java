import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
public class Solution {
    public static String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek()
                   .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter day:");
        int day = sc.nextInt();
        System.out.println("Enter month:");
        int month = sc.nextInt();
        System.out.println("Enter year:");
        int year = sc.nextInt();
        String result = dayOfTheWeek(day, month, year);
        System.out.println("Day: " + result);
        sc.close();
    }
}