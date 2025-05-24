package com.swea.d4;

import java.io.*;
import java.util.*;

public class _1210 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int endY;

    static int[] dx = {0, 0, -1};
    static int[] dy = {1, -1, 0};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = 10;

        for (int i = 1; i <= t; i++) {
            scan.nextInt();
            n = 100;
            map = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int num = scan.nextInt();
                    if (j == n - 1 && num == 2) {
                        endY = k;
                    }
                    map[j][k] = num;
                }
            }

            sb.append("#").append(i).append(" ");
            solve();
        }
    }

    static void solve() {
        visited = new boolean[n][n];
        visited[n - 1][endY] = true;
        dfs(n - 1, endY);
    }

    static void dfs(int x, int y) {
        if (x == 0) {
            sb.append(y).append("\n");
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }
            visited[nextX][nextY] = true;

            if (map[nextX][nextY] == 1) {
                dfs(nextX, nextY);
                return;
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
