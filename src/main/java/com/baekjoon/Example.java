package com.baekjoon;

import java.io.*;
import java.util.*;

public class Example {

    static FastReader scan = new FastReader();

    static int n;
    static int m;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
    }

    static void solve() {
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
