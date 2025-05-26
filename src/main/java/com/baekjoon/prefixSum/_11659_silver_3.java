package com.baekjoon.prefixSum;

import java.io.*;
import java.util.*;

public class _11659_silver_3 {

    static FastReader scan = new FastReader();

    static int n, m;
    static int[] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = scan.nextInt();
            } else {
                dp[i] = dp[i - 1] + scan.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            solve(scan.nextInt(), scan.nextInt());
        }
    }

    static void solve(int i, int j) {
        int result = dp[j - 1];
        if (i != 1) {
            result -= dp[i - 2];
        }

        sb.append(result).append("\n");
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
