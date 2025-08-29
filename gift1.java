/*
ID: Nick
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;
public class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> money = new ArrayList<>();
        int NP = Integer.parseInt(in.readLine());

        for (int i = 0; i < NP; i++) {
            String name = in.readLine();
            names.add(name);
            money.add(0);
        }

        for (int i = 0; i < NP; i++) {
            String tmp = in.readLine();
            if (names.contains(tmp)) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int index = names.indexOf(tmp);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (b == 0) {
                    continue;
                }

                money.set(index, money.get(index) - a);
                int x = a/b;
                int y = a%b;
                while (b > 0) {
                    String z = in.readLine();
                    if (names.contains(z)) {
                        int tmpIndex = names.indexOf(z);
                        money.set(tmpIndex, money.get(tmpIndex) + x);
                    } else {
                        System.exit(0);
                    }
                    b--;
                }
                money.set(index, money.get(index) + y);
            } else {
                System.exit(0);
            }
        }

        for (int i = 0; i < NP; i++) {
            out.println(names.get(i) + " " + money.get(i));
        }
        out.close();
    }
}