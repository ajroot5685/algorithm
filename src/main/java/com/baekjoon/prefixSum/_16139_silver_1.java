package com.baekjoon.prefixSum;

import java.io.*;
import java.util.*;

public class _16139_silver_1 {

    static FastReader scan = new FastReader();

    static String s;
    static int q;

    static int[][] sum;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        s = scan.next();
        q = scan.nextInt();

        solve();

        for (int i = 0; i < q; i++) {
            char c = scan.next().charAt(0);
            int l = scan.nextInt();
            int r = scan.nextInt();

            if (l == 0) {
                sb.append(sum[c - 'a'][r]).append("\n");
            } else {
                sb.append(sum[c - 'a'][r] - sum[c - 'a'][l - 1]).append("\n");
            }
        }
    }

    static void solve() {
        sum = new int[26][s.length()];
        int index = s.charAt(0) - 'a';
        sum[index][0] = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < 26; j++) {
                if ('a' + j == c) {
                    sum[j][i] = sum[j][i - 1] + 1;
                } else {
                    sum[j][i] = sum[j][i - 1];
                }
            }
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
