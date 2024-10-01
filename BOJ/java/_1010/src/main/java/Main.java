import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int t;
    static int n, m;

    public static void main(String[] args) {
        input();
    }

    static void solve() {
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = j + 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            n = scan.nextInt();
            m = scan.nextInt();

            solve();
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

