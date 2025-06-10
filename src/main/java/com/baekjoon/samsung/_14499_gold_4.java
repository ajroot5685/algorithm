package com.baekjoon.samsung;

import java.io.*;
import java.util.*;

public class _14499_gold_4 {

    static FastReader scan = new FastReader();

    static int n, m, x, y, k;
    static int[][] map;

    static int[] dice;
    static int[] diceNum;

    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        x = scan.nextInt();
        y = scan.nextInt();
        k = scan.nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        dice = new int[6];
        // 0 : 아랫면
        // 1 : 윗면
        // 2 : 옆면(왼)
        // 3 : 옆면(오)
        // 4 : 옆면(상)
        // 5 : 옆면(하)
        dice[0] = 6;
        dice[1] = 1;
        dice[2] = 4;
        dice[3] = 3;
        dice[4] = 2;
        dice[5] = 5;

        diceNum = new int[7];

        for (int i = 0; i < k; i++) {
            solve(scan.nextInt());
        }
    }

    static void solve(int op) {
        int nextX = x + dx[op];
        int nextY = y + dy[op];

        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
            return;
        }
        x = nextX;
        y = nextY;
        if (op == 1) {
            int tmp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[2];
            dice[2] = tmp;
        } else if (op == 2) {
            int tmp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[3];
            dice[3] = tmp;
        } else if (op == 3) {
            int tmp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = tmp;
        } else {
            int tmp = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = tmp;
        }

        if (map[x][y] == 0) {
            map[x][y] = diceNum[dice[0]];
        } else {
            diceNum[dice[0]] = map[x][y];
            map[x][y] = 0;
        }

        sb.append(diceNum[dice[1]]).append("\n");
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
