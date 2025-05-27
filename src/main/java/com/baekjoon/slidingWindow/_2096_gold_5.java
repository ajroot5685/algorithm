package com.baekjoon.slidingWindow;

import java.io.*;
import java.util.*;

public class _2096_gold_5 {

    static FastReader scan = new FastReader();

    static int n;
    static int[] arr = new int[3];
    static int[] minDp = new int[3];
    static int[] maxDp = new int[3];

    public static void main(String[] args) {
        input();
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[j] = scan.nextInt();
            }
            if (i == 0) {
                minDp[0] = maxDp[0] = arr[0];
                minDp[1] = maxDp[1] = arr[1];
                minDp[2] = maxDp[2] = arr[2];
            } else {
                solve();
            }
        }

        int max = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
        int min = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));

        System.out.println(max + " " + min);
    }

    static void solve() {
        int[] minTmp = minDp.clone();
        minDp[0] = Math.min(minTmp[0], minTmp[1]) + arr[0];
        minDp[1] = Math.min(minTmp[0], Math.min(minTmp[1], minTmp[2])) + arr[1];
        minDp[2] = Math.min(minTmp[1], minTmp[2]) + arr[2];

        int[] maxTmp = maxDp.clone();
        maxDp[0] = Math.max(maxTmp[0], maxTmp[1]) + arr[0];
        maxDp[1] = Math.max(maxTmp[0], Math.max(maxTmp[1], maxTmp[2])) + arr[1];
        maxDp[2] = Math.max(maxTmp[1], maxTmp[2]) + arr[2];
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
