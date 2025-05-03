package com.baekjoon.sort;

import java.io.*;
import java.util.*;

public class _18870 {

    static FastReader scan = new FastReader();

    static int n;
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(scan.nextInt());
        }
    }

    static void solve() {
        Set notDuplicated = new HashSet<>(arr);
        List<Integer> list = new ArrayList<>(notDuplicated);
        Collections.sort(list);

        Map<Integer, Integer> map = new HashMap<>();
        int compression = 0;
        for (Integer num : list) {
            map.put(num, compression++);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer num : arr) {
            sb.append(map.get(num)).append(" ");
        }

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
