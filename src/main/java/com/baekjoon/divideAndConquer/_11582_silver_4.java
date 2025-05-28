package com.baekjoon.divideAndConquer;

import java.io.*;
import java.util.*;

public class _11582_silver_4 {

    static FastReader scan = new FastReader();

    static int n, k;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

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

        k = scan.nextInt();
    }

    static void solve() {
        dac(n / 2);
    }

    static void dac(int num) {
        for (int i = 0; i < n; i += n / num) {
            Arrays.sort(arr, i, i + n / num);
        }
        if (num == k) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        dac(num / 2);
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
