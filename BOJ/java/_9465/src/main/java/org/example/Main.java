package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int t;
    static int n;
    static int[][] sticker;
    static int[][] dp;

    public static void main(String[] args) {
        input();
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            n = scan.nextInt();

            sticker = new int[2][n];
            for (int j = 0; j < n; j++) {
                sticker[0][j] = scan.nextInt();
            }

            for (int j = 0; j < n; j++) {
                sticker[1][j] = scan.nextInt();
            }

            dp = new int[2][n];

            solve();
        }

        System.out.println(sb);
    }

    static void solve() {
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[0][i] = sticker[0][i];
            dp[1][i] = sticker[1][i];

            if (i >= 1) {
                dp[0][i] = Math.max(dp[0][i], dp[1][i - 1] + sticker[0][i]);
                dp[1][i] = Math.max(dp[1][i], dp[0][i - 1] + sticker[1][i]);
            }
            if (i >= 2) {
                dp[0][i] = Math.max(dp[0][i], dp[0][i - 2] + sticker[0][i]);
                dp[0][i] = Math.max(dp[0][i], dp[1][i - 2] + sticker[0][i]);

                dp[1][i] = Math.max(dp[1][i], dp[0][i - 2] + sticker[1][i]);
                dp[1][i] = Math.max(dp[1][i], dp[1][i - 2] + sticker[1][i]);
            }

            max = Math.max(dp[0][i], max);
            max = Math.max(dp[1][i], max);
        }

        sb.append(max).append("\n");
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