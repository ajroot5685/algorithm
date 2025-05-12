package com.baekjoon.dfs;

import java.io.*;
import java.util.*;

public class _10026_gold_5 {

    static FastReader scan = new FastReader();

    static int n;
    static char[][] map;

    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scan.nextChar();
            }
        }
    }

    static void solve() {
        visited = new boolean[n][n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(i, j, false);
                }
            }
        }
        sb.append(count).append(" ");

        visited = new boolean[n][n];
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(i, j, true);
                }
            }
        }
        sb.append(count);

        System.out.println(sb);
    }

    static void dfs(int x, int y, boolean colorProblem) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                if (!colorProblem && map[x][y] == map[nextX][nextY]) {
                    dfs(nextX, nextY, colorProblem);
                } else if (colorProblem) {
                    if (map[x][y] == map[nextX][nextY] ||
                            (map[x][y] == 'R' && map[nextX][nextY] == 'G') ||
                            (map[x][y] == 'G' && map[nextX][nextY] == 'R')
                    ) {
                        dfs(nextX, nextY, colorProblem);
                    }
                }
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        String currentLine = "";
        int charIndex = 0;

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

        char nextChar() {
            while (currentLine == null || charIndex >= currentLine.length()) {
                try {
                    currentLine = br.readLine();
                    charIndex = 0;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return currentLine.charAt(charIndex++);
        }
    }
}
