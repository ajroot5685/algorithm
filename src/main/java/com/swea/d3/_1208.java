package com.swea.d3;

import java.io.*;
import java.util.*;

public class _1208 {

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
            arr = new int[100];

            for (int j = 0; j < 100; j++) {
                arr[j] = scan.nextInt();
            }

            sb.append("#").append(i).append(" ");
            solve();
        }
    }

    static void solve() {
        while (true) {
            Arrays.sort(arr);
            if (n == 0) {
                sb.append(arr[99] - arr[0]).append("\n");
                return;
            }

            arr[0]++;
            arr[99]--;
            n--;
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
