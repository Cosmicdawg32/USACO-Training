/*
ID: Nick
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;
public class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        StringTokenizer aString = new StringTokenizer(in.readLine());
        String a = aString.nextToken();
        StringTokenizer bString = new StringTokenizer(in.readLine());
        String b = bString.nextToken();
        int x = 1;
        int y = 1;
        for (int i = 0; i < a.length(); i++) {
            x *= a.charAt(i) - 'A' + 1;
        }

        for (int i = 0; i < b.length(); i++) {
            y *= b.charAt(i)- 'A' + 1;
        }

        if (x%47 == y%47) {
            out.println("GO");
        } else {
            out.println("STAY");
        }
        out.close();
    }
}