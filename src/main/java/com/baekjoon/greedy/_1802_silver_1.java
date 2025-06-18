package com.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class _1802_silver_1 {

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

        for (int i = 0; i < t; i++) {
            char[] charArray = scan.next().toCharArray();
            arr = new int[charArray.length];
            for (int j = 0; j < charArray.length; j++) {
                arr[j] = charArray[j] - '0';
            }

            solve();
        }
    }

    static void solve() {
        int start = arr.length / 2;

        boolean flag = false;
        while (start != 0) {
            for (int i = 1; i <= start; i++) {
                if (arr[start - i] == arr[start + i]) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }

            start /= 2;
        }

        String result = flag ? "NO\n" : "YES\n";
        sb.append(result);
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
