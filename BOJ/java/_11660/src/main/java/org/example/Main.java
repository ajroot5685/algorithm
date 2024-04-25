package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;

    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) {
        input();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        calDP();

        for (int i = 0; i < m; i++) {
            solve(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
        }

        System.out.println(sb);
    }

    static void solve(int x1, int y1, int x2, int y2) {
        int result = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
        sb.append(result).append("\n");
    }

    static void calDP() {
        dp = new int[n + 1][n + 1];

        dp[1][1] = map[1][1];
        for (int i = 2; i <= n; i++) {
            dp[1][i] = dp[1][i - 1] + map[1][i];
            dp[i][1] = dp[i - 1][1] + map[i][1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
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