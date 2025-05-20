package com.swea.d2;

import java.io.*;
import java.util.*;

public class _1954 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static int[][] map;

    static StringBuilder sb = new StringBuilder();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            n = scan.nextInt();

            sb.append("#").append(i).append("\n");
            solve();
        }
    }

    static void solve() {
        map = new int[n][n];

        int direction = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= n * n; i++) {
            map[x][y] = i;

            int nextX = x + dx[direction];
            int nextY = y + dy[direction];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || map[nextX][nextY] != 0) {
                direction = (direction + 1) % 4;
                x += dx[direction];
                y += dy[direction];
            } else {
                x = nextX;
                y = nextY;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
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
