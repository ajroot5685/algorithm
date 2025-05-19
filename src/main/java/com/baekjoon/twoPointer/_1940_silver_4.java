package com.baekjoon.twoPointer;

import java.io.*;
import java.util.*;

public class _1940_silver_4 {

    static FastReader scan = new FastReader();

    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        int count = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == m) {
                count++;
                right--;
            } else if (sum < m) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
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
