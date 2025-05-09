package com.baekjoon.string;

import java.io.*;
import java.util.*;

public class _5052_gold_4 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static List<String> phoneList = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            n = scan.nextInt();
            phoneList.clear();

            for (int j = 0; j < n; j++) {
                phoneList.add(scan.next());
            }
            solve();
        }
    }

    static void solve() {
        Collections.sort(phoneList);

        boolean flag = true;
        for (int i = 0; i < phoneList.size() - 1; i++) {
            if (phoneList.get(i + 1).startsWith(phoneList.get(i))) {
                flag = false;
                break;
            }
        }
        sb.append(flag ? "YES\n" : "NO\n");
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
