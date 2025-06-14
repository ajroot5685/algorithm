package com.baekjoon.divideAndConquer;

import java.io.*;
import java.util.*;

public class _10830_gold_4 {

    static FastReader scan = new FastReader();

    static int n;
    static long b;
    static int[][] matrix;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        b = scan.nextLong();

        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
    }

    static void solve() {
        int[][] result = pow(matrix, b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j] % 1000).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int[][] pow(int[][] matrix, long b) {
        if (b == 1) {
            return matrix;
        }
        int[][] divide = pow(matrix, b / 2);

        divide = multi(divide, divide);

        if (b % 2 != 0) {
            divide = multi(divide, matrix);
        }

        return divide;
    }

    static int[][] multi(int[][] a, int[][] b) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
