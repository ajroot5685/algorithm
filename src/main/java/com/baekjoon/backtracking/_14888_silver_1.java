package com.baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class _14888_silver_1 {

    static FastReader scan = new FastReader();

    static int n;
    static int[] arr;
    static int[] opArr = new int[4];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

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

        opArr[0] = scan.nextInt();
        opArr[1] = scan.nextInt();
        opArr[2] = scan.nextInt();
        opArr[3] = scan.nextInt();
    }

    static void solve() {
        for (int i = 0; i < 4; i++) {
            if (opArr[i] > 0) {
                opArr[i]--;
                backTracking(1, i, arr[0]);
                opArr[i]++;
            }
        }

        System.out.println(max);
        System.out.println(min);
    }

    static void backTracking(int arrIndex, int op, int result) {
        result = calculate(result, arr[arrIndex], op);
        if (arrIndex == n - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opArr[i] > 0) {
                opArr[i]--;
                backTracking(arrIndex + 1, i, result);
                opArr[i]++;
            }
        }
    }

    static int calculate(int x, int y, int op) {
        if (op == 0) {
            return x + y;
        } else if (op == 1) {
            return x - y;
        } else if (op == 2) {
            return x * y;
        } else {
            if (x < 0) {
                return -(-x / y);
            } else {
                return x / y;
            }
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
