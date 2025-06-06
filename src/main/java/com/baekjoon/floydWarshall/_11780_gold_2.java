package com.baekjoon.floydWarshall;

import java.io.*;
import java.util.*;

public class _11780_gold_2 {

    static FastReader scan = new FastReader();

    static int n, m;
    static int[][] table;
    static List<Integer>[][] route;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        table = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    table[i][j] = 1_000_000;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();

            table[from][to] = Math.min(table[from][to], cost);
        }
    }

    static void solve() {
        route = new List[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                route[i][j] = new ArrayList<>();
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) {
                    continue;
                }
                for (int j = 1; j <= n; j++) {
                    if (j == i || j == k) {
                        continue;
                    }
                    if (table[i][k] == 1_000_000 || table[k][j] == 1_000_000) {
                        continue;
                    }
                    if (table[i][j] > table[i][k] + table[k][j]) {
                        table[i][j] = table[i][k] + table[k][j];
                        tracking(i, k, j);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (table[i][j] == 1_000_000) {
                    table[i][j] = 0;
                }
                sb.append(table[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (table[i][j] == 0) {
                    sb.append("0\n");
                } else {
                    sb.append(route[i][j].size() + 2).append(" ");
                    sb.append(i).append(" ");
                    for (int path : route[i][j]) {
                        sb.append(path).append(" ");
                    }
                    sb.append(j).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    static void tracking(int i, int k, int j) {
        route[i][j].clear();
        for (int path : route[i][k]) {
            route[i][j].add(path);
        }
        route[i][j].add(k);
        for (int path : route[k][j]) {
            route[i][j].add(path);
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
