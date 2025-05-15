package com.baekjoon.dp;

import java.io.*;
import java.util.*;

public class _1520_gold_3 {

    static FastReader scan = new FastReader();

    static int n, m;
    static int[][] map;
    static int[][] dp;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scan.nextInt();
                dp[i][j] = -1;
            }
        }
    }

    static void solve() {
        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                continue;
            }
            if (map[nextX][nextY] >= map[x][y]) {
                continue;
            }

            dp[x][y] += dfs(nextX, nextY);
        }

        return dp[x][y];
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
