import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int k;

    static int[][] table;

    public static void main(String[] args) {
        input();
    }

    static void input() {
        n = scan.nextInt();
        k = scan.nextInt();

        table = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();

            table[from][to] = 1;
        }

        solve();

        int s = scan.nextInt();
        for (int i = 0; i < s; i++) {
            int front = scan.nextInt();
            int back = scan.nextInt();

            if (table[front][back] == 1) {
                sb.append(-1).append("\n");
            } else if (table[back][front] == 1) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (table[j][k] == 0 && table[j][i] == 1 && table[i][k] == 1) {
                        table[j][k] = 1;
                    }
                }
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
