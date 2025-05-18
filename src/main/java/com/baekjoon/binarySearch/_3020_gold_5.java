package com.baekjoon.binarySearch;

import java.io.*;
import java.util.*;

public class _3020_gold_5 {

    static FastReader scan = new FastReader();

    static int n, h;
    static int[] up;
    static int[] down;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        h = scan.nextInt();

        up = new int[n / 2];
        down = new int[n / 2];

        for (int i = 0; i < n / 2; i++) {
            down[i] = scan.nextInt();
            up[i] = scan.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(up);
        Arrays.sort(down);

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= h; i++) {
            int amount = bs(i, down) + bs(h - i + 1, up);
            if (min > amount) {
                count = 1;
                min = amount;
            } else if (min == amount) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }

    static int bs(int h, int[] arr) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return arr.length - left;
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
