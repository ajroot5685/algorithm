package com.baekjoon.string;

import java.io.*;
import java.util.*;

public class _2941_silver_5 {

    static FastReader scan = new FastReader();

    static String s;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        s = scan.next();
    }

    static void solve() {
        List<String> croatia = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        for (String substitution : croatia) {
            s = s.replaceAll(substitution, "1");
        }
        
        System.out.println(s.length());
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
