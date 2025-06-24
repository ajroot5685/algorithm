package com.baekjoon.binarySearch;

import java.io.*;
import java.util.*;

public class _12738_gold_2 {

    static FastReader scan = new FastReader();

    static int n;
    static int[] arr;

    static List<Integer> sub = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void solve() {
        for (int i = 0; i < n; i++) {
            bs(arr[i]);
        }

        System.out.println(sub.size());
    }

    static void bs(int next) {
        if (sub.isEmpty()) {
            sub.add(next);
            return;
        }

        int left = 0;
        int right = sub.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (sub.get(mid) == next) {
                return;
            } else if (sub.get(mid) < next) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left >= sub.size()) {
            sub.add(next);
        } else {
            sub.set(left, next);
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
