package com.baekjoon.sort;

import java.io.*;
import java.util.*;

public class _2075 {

    static FastReader scan = new FastReader();

    static int n;
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 0; i < n * n; i++) {
            arr.add(scan.nextInt());
        }
    }

    static void solve() {
        arr.sort(Comparator.reverseOrder());

        System.out.println(arr.get(n - 1));
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
