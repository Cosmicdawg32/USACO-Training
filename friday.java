/*
ID: Nick
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;
public class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        StringTokenizer num = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(num.nextToken());

        int[] day = new int[7]; // [0] = Saturday, [1] = Sunday, ...
        int currentDay = 0; // First 13th is always on a Saturday

        for (int year = 1900; year < 1900 + n; year++) {
            for (int month = 1; month <= 12; month++) {
                day[currentDay]++;

                int daysInMonth = getDaysInMonth(month, year);

                currentDay = (currentDay + daysInMonth)%7;
            }
        }

        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                out.print(day[i]);
                out.println();
            } else {
                out.print(day[i] + " ");
            }

        }
        out.close();
    }

    public static int getDaysInMonth(int month, int year) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            if (isLeapYear(year) == true) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return 31;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year%100 == 0) {
            if (year%400 == 0) {
                return true;
            } else return false;
        } else if (year%4 == 0) {
            return true;
        } else return false;
    }
}