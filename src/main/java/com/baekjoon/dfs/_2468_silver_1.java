package com.baekjoon.dfs;

import java.io.*;
import java.util.*;

public class _2468_silver_1 {

    static FastReader scan = new FastReader();

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int maxHeight;

    static int result = 1;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int next = scan.nextInt();
                maxHeight = Math.max(maxHeight, next);
                map[i][j] = next;
            }
        }
    }

    static void solve() {
        int count;

        for (int i = 1; i <= maxHeight; i++) {
            visited = new boolean[n][n];
            count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && map[j][k] - i > 0) {
                        count++;
                        dfs(j, k, i);
                    }
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }

    static void dfs(int x, int y, int rain) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                    && !visited[nextX][nextY]
                    && map[nextX][nextY] - rain > 0) {
                dfs(nextX, nextY, rain);
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
