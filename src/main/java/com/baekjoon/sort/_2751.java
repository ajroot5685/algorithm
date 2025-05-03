package com.baekjoon.sort;

import java.io.*;
import java.util.*;

public class _2751 {

    static FastReader scan = new FastReader();

    static int n;
    static List<Integer> arr;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scan.nextInt());
        }
    }

    static void solve() {
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (Integer num : arr) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
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
