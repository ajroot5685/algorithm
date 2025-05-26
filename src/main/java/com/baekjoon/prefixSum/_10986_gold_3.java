package com.baekjoon.prefixSum;

import java.io.*;
import java.util.*;

public class _10986_gold_3 {

    static FastReader scan = new FastReader();

    static int n, m;
    static int[] rest;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        rest = new int[m];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();
            sum = (sum + num) % m;
            rest[sum]++;
        }
    }

    static void solve() {
        long result = rest[0];
        for (int i = 0; i < m; i++) {
            result += (long) rest[i] * (rest[i] - 1) / 2;
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
