import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int[] t;
    static int[] p;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        int[] dp = new int[n + 2];

        for (int i = n; i >= 1; i--) {
            if (t[i] + i - 1 > n) { // 상담 끝나는 시간 > n
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], p[i] + dp[t[i] + i]);
            }
        }

        System.out.println(dp[1]);
    }

    static void input() {
        n = scan.nextInt();

        t = new int[n + 1];
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = scan.nextInt();
            p[i] = scan.nextInt();
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

