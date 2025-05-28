package com.baekjoon.divideAndConquer;

import java.io.*;
import java.util.*;

public class _18222_silver_2 {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
    }

    static void input() {
        System.out.println(solve(scan.nextLong() - 1));
    }

    static long solve(long k) {
        if (k == 0 || k == 1) {
            return k;
        }

        if (k % 2 == 0) {
            return solve(k / 2);
        } else {
            return solve(k / 2) == 0 ? 1 : 0;
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
