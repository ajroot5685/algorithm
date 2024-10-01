import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n, k;
    static final int REMAINDER = 10_0000_0000;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % REMAINDER;
                }
            }
        }

        System.out.println(dp[n][k]);
    }

    static void input() {
        n = scan.nextInt();
        k = scan.nextInt();
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

