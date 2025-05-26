package com.baekjoon.prefixSum;

import java.io.*;
import java.util.*;

public class _21758_gold_5 {

    static FastReader scan = new FastReader();

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void solve() {
        int[] dp = new int[n];
        int max = 0;

        // 벌통 - 벌 - 벌
        // 벌통:0, 오른쪽 벌:n-1
        dp[1] = arr[0];
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];
        }
        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, dp[n - 1] + dp[i] - arr[i]);
        }

        // 벌 - 벌 - 벌통
        // 벌통:n-1, 왼쪽 벌:0
        dp = new int[n];
        dp[n - 2] = arr[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = dp[i + 1] + arr[i + 1];
        }
        for (int i = n - 2; i > 0; i--) {
            max = Math.max(max, dp[0] + dp[i] - arr[i]);
        }

        // 벌 - 벌통 - 벌
        // 왼쪽 벌:0, 오른쪽 벌:n-1
        int midSum = dp[0] - arr[n - 1];
        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, midSum + arr[i]);
        }

        System.out.println(max);
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
