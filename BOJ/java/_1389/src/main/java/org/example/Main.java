package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int m;
    static int[][] bacon;
    static final int MAX = 10_0000_0000;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    bacon[j][k] = Math.min(bacon[j][k], bacon[j][i] + bacon[i][k]);
                }
            }
        }

        int[] result = new int[2];
        result[1] = MAX;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += bacon[i][j];
            }
            if (result[1] > sum) {
                result[0] = i;
                result[1] = sum;
            }
        }

        System.out.println(result[0]);
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        bacon = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    bacon[i][j] = MAX;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();

            bacon[from][to] = 1;
            bacon[to][from] = 1;
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