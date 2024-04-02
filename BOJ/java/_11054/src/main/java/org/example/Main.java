package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

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
        int[] dp_up = new int[n];
        int[] dp_dw = new int[n];

        for (int i = 0; i < n; i++) {
            dp_up[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dp_up[i] = Math.max(dp_up[i], dp_up[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            dp_dw[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    dp_dw[i] = Math.max(dp_dw[i], dp_dw[j] + 1);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp_up[i] + dp_dw[i] - 1, max);
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