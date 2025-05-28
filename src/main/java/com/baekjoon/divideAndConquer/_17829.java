package com.baekjoon.divideAndConquer;

import java.io.*;
import java.util.*;

public class _17829 {

    static FastReader scan = new FastReader();

    static int n;
    static int[][] map;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }

    static void solve() {
        System.out.println(dac(0, 0, n));
    }

    static int dac(int x, int y, int size) {
        if (size == 2) {
            int[] arr = new int[4];
            int idx = 0;
            for (int i = x; i < x + 2; i++) {
                for (int j = y; j < y + 2; j++) {
                    arr[idx++] = map[i][j];
                }
            }

            Arrays.sort(arr);
            return arr[2];
        } else {
            int[] arr = new int[4];
            size = size / 2;

            arr[0] = dac(x, y, size);
            arr[1] = dac(x, y + size, size);
            arr[2] = dac(x + size, y, size);
            arr[3] = dac(x + size, y + size, size);

            Arrays.sort(arr);
            return arr[2];
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
