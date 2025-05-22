package com.swea.d3;

import java.io.*;
import java.util.*;

public class _2806 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;

    static int[] arr;
    static int count;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            n = scan.nextInt();

            sb.append("#").append(i).append(" ");
            solve();
        }
    }

    static void solve() {
        arr = new int[n];
        count = 0;

        back(0);
        sb.append(count).append("\n");
    }

    static void back(int queenCount) {
        if (queenCount == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[queenCount] = i;
            if (check(queenCount)) {
                back(queenCount + 1);
            }
        }
    }

    static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }
            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
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
