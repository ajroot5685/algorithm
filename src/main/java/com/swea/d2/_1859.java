package com.swea.d2;

import java.io.*;
import java.util.*;

public class _1859 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            n = scan.nextInt();
            arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = scan.nextInt();
            }

            sb.append("#").append(i).append(" ");
            solve();
        }
    }

    static void solve() {
        long sum = 0;
        long high = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > high) {
                high = arr[i];
            } else {
                sum += (high - arr[i]);
            }
        }

        sb.append(sum).append("\n");
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
