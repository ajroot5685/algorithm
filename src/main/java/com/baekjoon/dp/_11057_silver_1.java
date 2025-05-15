package com.baekjoon.dp;

import java.io.*;
import java.util.*;

public class _11057_silver_1 {

    static FastReader scan = new FastReader();

    static int n;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
    }

    static void solve() {
        int[] dp = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 1; i < n; i++) {
            int[] tmp = new int[10];
            for (int j = 0; j < 10; j++) {
                int sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum = (sum + dp[k]) % 10007;
                }
                tmp[j] = sum;
            }
            dp = tmp;
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[i]) % 10007;
        }

        System.out.println(result);
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
