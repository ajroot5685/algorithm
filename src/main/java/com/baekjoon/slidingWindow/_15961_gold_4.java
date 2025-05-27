package com.baekjoon.slidingWindow;

import java.io.*;
import java.util.*;

public class _15961_gold_4 {

    static FastReader scan = new FastReader();

    static int n, d, k, c;
    static int[] arr;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        d = scan.nextInt();
        k = scan.nextInt();
        c = scan.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void solve() {
        int[] count = new int[d + 1];
        int max = 0;
        int kind = 0;

        for (int i = 0; i < k; i++) {
            if (count[arr[i]]++ == 0) {
                kind++;
            }
        }
        if (count[c] == 0) {
            max = kind + 1;
        } else {
            max = kind;
        }

        for (int i = k; i < n + k; i++) {

            int minus = arr[i - k];
            if (--count[minus] == 0) {
                kind--;
            }

            int plus = arr[(i % n)];
            if (count[plus]++ == 0) {
                kind++;
            }

            if (count[c] == 0) {
                max = Math.max(max, kind + 1);
            } else {
                max = Math.max(max, kind);
            }
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
