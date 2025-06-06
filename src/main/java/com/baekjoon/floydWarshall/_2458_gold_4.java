package com.baekjoon.floydWarshall;

import java.io.*;
import java.util.*;

public class _2458_gold_4 {

    static FastReader scan = new FastReader();

    static int n, m;
    static boolean[][] table;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        table = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();

            table[from][to] = true;
        }
    }

    static void solve() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) {
                    continue;
                }
                for (int j = 1; j <= n; j++) {
                    if (i == j || j == k) {
                        continue;
                    }
                    if (table[i][k] && table[k][j]) {
                        table[i][j] = true;
                    }
                }
            }
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                if (table[i][j]) {
                    count++;
                }
                if (table[j][i]) {
                    count++;
                }
            }
            if (count == n - 1) {
                result++;
            }
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
