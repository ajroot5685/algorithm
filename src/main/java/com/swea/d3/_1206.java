package com.swea.d3;

import java.io.*;
import java.util.*;

public class _1206 {

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
        t = 10;

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
        int count = 0;
        for (int i = 2; i < n - 2; i++) {
            int max = Math.max(Math.max(arr[i - 2], arr[i - 1]), Math.max(arr[i + 1], arr[i + 2]));
            if (arr[i] > max) {
                count += arr[i] - max;
            }
        }

        sb.append(count).append("\n");
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
