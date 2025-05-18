package com.baekjoon.binarySearch;

import java.io.*;
import java.util.*;

public class _2776_silver_4 {

    static FastReader scan = new FastReader();

    static int t, n, m;
    static int[] arr;
    static int[] target;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            n = scan.nextInt();
            arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = scan.nextInt();
            }

            m = scan.nextInt();
            target = new int[m];
            for (int j = 0; j < m; j++) {
                target[j] = scan.nextInt();
            }

            solve();
        }
    }

    static void solve() {
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            if (bs(target[i])) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
    }

    static boolean bs(int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
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
