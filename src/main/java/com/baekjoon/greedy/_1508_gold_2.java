package com.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class _1508_gold_2 {

    static FastReader scan = new FastReader();

    static int n, m, k;
    static int[] arr;

    static int maxDistance = -1;
    static String result;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();

        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void solve() {
        int left = 0;
        int right = arr[k - 1];
        
        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean check(int distance) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        int before = arr[0];

        int count = 1;

        for (int i = 1; i < k; i++) {
            if (arr[i] - before >= distance && count < m) {
                sb.append(1);
                before = arr[i];
                count++;
            } else {
                sb.append(0);
            }
        }

        if (count == m) {
            if (maxDistance < distance) {
                result = sb.toString();
                maxDistance = distance;
            }
            return true;
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
