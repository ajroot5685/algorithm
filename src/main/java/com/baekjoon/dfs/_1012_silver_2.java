package com.baekjoon.dfs;

import java.io.*;
import java.util.*;

public class _1012_silver_2 {

    static FastReader scan = new FastReader();

    static int t;
    static int m, n, k;
    static int[][] map;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            m = scan.nextInt();
            n = scan.nextInt();
            k = scan.nextInt();

            map = new int[m][n];
            for (int j = 0; j < k; j++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                map[x][y] = 1;
            }

            solve();
        }
    }

    static void solve() {
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    dfs(i, j);
                    result++;
                }
            }
        }

        sb.append(result).append("\n");
    }

    static void dfs(int x, int y) {
        map[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && map[nextX][nextY] == 1) {
                dfs(nextX, nextY);
            }
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
