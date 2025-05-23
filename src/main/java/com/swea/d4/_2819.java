package com.swea.d4;

import java.io.*;
import java.util.*;

public class _2819 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static int[][] map;
    static char[] number;
    static Set<String> set;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            n = 4;
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
        result = 0;
        number = new char[7];
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                number[0] = (char) map[i][j];
                dfs(i, j, 1);
            }
        }

        sb.append(set.size()).append("\n");
    }

    static void dfs(int x, int y, int depth) {
        if (depth == 7) {
            set.add(new String(number));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                continue;
            }

            char tmp = number[depth];
            number[depth] = (char) map[nextX][nextY];
            dfs(nextX, nextY, depth + 1);
            number[depth] = tmp;
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
