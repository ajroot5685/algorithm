package com.baekjoon.lcs;

import java.io.*;
import java.util.*;

public class _5582_gold_5 {

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

        int max = 0;

        for (int i = 1; i <= s1Size; i++) {
            for (int j = 1; j <= s2Size; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        if (max == 1) {
            System.out.println(0);
        } else {
            System.out.println(max);
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
