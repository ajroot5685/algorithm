package com.swea.d3;

import java.io.*;
import java.util.*;

public class _1220 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static int[][] map;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = 10;

        for (int i = 1; i <= t; i++) {
            n = scan.nextInt();
            map = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    map[j][k] = scan.nextInt();
                }
            }

            sb.append("#").append(i).append(" ");
            solve();
        }
    }

    static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[j][i] == 2) {
                    map[j][i] = 0;
                } else if (map[j][i] == 1) {
                    break;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (map[j][i] == 1) {
                    map[j][i] = 0;
                } else if (map[j][i] == 2) {
                    break;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (map[j][i] == 1) {
                    flag = true;
                } else if (map[j][i] == 2) {
                    if (flag) {
                        count++;
                        flag = false;
                    }
                }
            }
        }

        sb.append(count).append("\n");
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
