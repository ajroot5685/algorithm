package com.baekjoon.twoPointer;

import java.io.*;
import java.util.*;

public class _17609_gold_5 {

    static FastReader scan = new FastReader();

    static int t;
    static String s;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            s = scan.next();
            solve();
        }
    }

    static void solve() {
        int left = 0;
        int right = s.length() - 1;

        int flag = 0;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }

            flag = 1;
            break;
        }

        if (flag == 1) {
            if (tp(s.substring(left + 1, right + 1)) != 1 && tp(s.substring(left, right)) != 1) {
                flag = 2;
            }
        }

        sb.append(flag).append("\n");
    }

    static int tp(String s) {
        int left = 0;
        int right = s.length() - 1;

        int flag = 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }

            flag = 2;
            break;
        }

        return flag;
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
