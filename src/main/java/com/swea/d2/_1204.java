package com.swea.d2;

import java.io.*;
import java.util.*;

public class _1204 {

    static FastReader scan = new FastReader();

    static int t;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            scan.nextInt();

            arr = new int[101];
            for (int j = 0; j < 1000; j++) {
                arr[scan.nextInt()]++;
            }

            sb.append("#").append(i).append(" ");
            solve();
        }
    }

    static void solve() {
        int max = 0;
        int index = 0;
        for (int i = 0; i <= 100; i++) {
            if (max <= arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        sb.append(index).append("\n");
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
