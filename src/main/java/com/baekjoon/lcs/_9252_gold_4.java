package com.baekjoon.lcs;

import java.io.*;
import java.util.*;

public class _9252_gold_4 {

    static FastReader scan = new FastReader();

    static String s1;
    static String s2;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        s1 = scan.next();
        s2 = scan.next();
    }

    static void solve() {
        int s1Size = s1.length();
        int s2Size = s2.length();
        int[][] dp = new int[s1Size + 1][s2Size + 1];

        for (int i = 1; i <= s1Size; i++) {
            for (int j = 1; j <= s2Size; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = s1Size;
        int y = s2Size;
        while (true) {
            if (x == 0 || y == 0 || dp[x][y] == 0) {
                break;
            }

            if (dp[x - 1][y] == dp[x][y]) {
                x--;
            } else if (dp[x][y - 1] == dp[x][y]) {
                y--;
            } else {
                sb.append(s1.charAt(x - 1));
                x--;
                y--;
            }
        }

        System.out.println(dp[s1Size][s2Size]);
        System.out.println(sb.reverse());
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
