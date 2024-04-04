package org.example;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] dp;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
    }

    static void solve() {

        if (n == 1) {
            System.out.println(0);
            return;
        }

        dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            if (i % 2 == 1) {
                dp[i] = 0;
            }else{
                dp[i] += 2 + dp[i - 2] * 3;
                for (int j = i-4; j >= 2; j -= 2) {
                    dp[i] += dp[j]*2;
                }
            }
        }

        System.out.println(dp[n]);
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