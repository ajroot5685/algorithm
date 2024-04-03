package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int k;
    static int[] coin;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        k = scan.nextInt();

        coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = scan.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(coin);

        int[] dp = new int[k+1];

        dp[0] = 0;   // 동전 개수

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (coin[i] > j) {
                    continue;
                }else if (coin[i] == j) {
                    dp[j] = 1;
                }else{
                    if (dp[j - coin[i]] != 0 && dp[j] != 0) {
                        dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
                    } else if (dp[j - coin[i]] != 0) {
                        dp[j] = dp[j - coin[i]] + 1;
                    }
                }
            }
        }
        if (dp[k] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
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