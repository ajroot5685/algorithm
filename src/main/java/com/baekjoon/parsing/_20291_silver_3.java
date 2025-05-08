package com.baekjoon.parsing;

import java.io.*;
import java.util.*;

public class _20291_silver_3 {

    static FastReader scan = new FastReader();

    static int n;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String ext = scan.next().split("\\.")[1];
            map.put(ext, map.getOrDefault(ext, 0) + 1);
        }
    }

    static void solve() {
        StringBuilder sb = new StringBuilder();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n"));

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
