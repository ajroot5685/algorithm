package com.baekjoon.binarySearch;

import java.io.*;
import java.util.*;

public class _1072_silver_3 {

    static FastReader scan = new FastReader();

    static int x, y;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        x = scan.nextInt();
        y = scan.nextInt();
    }

    static void solve() {
        long z = y * 100L / x;

        System.out.println(bs(z));
    }

    static long bs(long target) {
        long start = x;
        long end = Integer.MAX_VALUE;

        while (start < end) {
            long mid = (start + end) / 2;
            long difference = mid - x;

            if ((y + difference) * 100 / mid <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (start >= Integer.MAX_VALUE) {
            return -1;
        } else {
            return start - x;
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
