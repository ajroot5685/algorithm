package com.baekjoon.parsing;

import java.io.*;
import java.util.*;

public class _10821_bronze_2 {

    static FastReader scan = new FastReader();

    static String input;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        input = scan.next();
    }

    static void solve() {
        String[] split = input.split(",");
        System.out.println(split.length);
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
