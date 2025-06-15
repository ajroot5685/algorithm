package com.baekjoon.samsung;

import java.io.*;
import java.util.*;

public class _12100_gold_1 {

    static FastReader scan = new FastReader();

    static int n;
    static int[][] init;

    static int max;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();

        init = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                init[i][j] = scan.nextInt();
            }
        }
    }

    static void solve() {
        setMax(init);
        back(init, 0);
        System.out.println(max);
    }

    static void back(int[][] map, int depth) {
        if (depth == 5) {
            setMax(map);
            return;
        }

        int[][] copy = deepCopy(map);
        if (up(copy)) {
            back(copy, depth + 1);
        }

        int[][] copy2 = deepCopy(map);
        if (down(copy2)) {
            back(copy2, depth + 1);
        }

        int[][] copy3 = deepCopy(map);
        if (left(copy3)) {
            back(copy3, depth + 1);
        }

        int[][] copy4 = deepCopy(map);
        if (right(copy4)) {
            back(copy4, depth + 1);
        }
    }

    static boolean up(int[][] map) {
        boolean flag = false;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (map[i][j] != 0) {
                    for (int k = i + 1; k < n; k++) {
                        if (map[k][j] == 0) {
                            continue;
                        }
                        if (map[k][j] == map[i][j]) {
                            map[i][j] += map[k][j];
                            map[k][j] = 0;
                            i = k;
                            flag = true;
                        }
                        break;
                    }
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < i; k++) {
                        if (map[k][j] == 0) {
                            map[k][j] = map[i][j];
                            map[i][j] = 0;
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }

        return flag;
    }

    static boolean down(int[][] map) {
        boolean flag = false;

        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (map[i][j] != 0) {
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] == 0) {
                            continue;
                        }
                        if (map[k][j] == map[i][j]) {
                            map[i][j] += map[k][j];
                            map[k][j] = 0;
                            i = k;
                            flag = true;
                        }
                        break;
                    }
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = n - 2; i >= 0; i--) {
                if (map[i][j] != 0) {
                    for (int k = n - 1; k > i; k--) {
                        if (map[k][j] == 0) {
                            map[k][j] = map[i][j];
                            map[i][j] = 0;
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }

        return flag;
    }

    static boolean left(int[][] map) {
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    for (int k = j + 1; k < n; k++) {
                        if (map[i][k] == 0) {
                            continue;
                        }
                        if (map[i][k] == map[i][j]) {
                            map[i][j] += map[i][k];
                            map[i][k] = 0;
                            j = k;
                            flag = true;
                        }
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < j; k++) {
                        if (map[i][k] == 0) {
                            map[i][k] = map[i][j];
                            map[i][j] = 0;
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }

        return flag;
    }

    static boolean right(int[][] map) {
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] != 0) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[i][k] == 0) {
                            continue;
                        }
                        if (map[i][k] == map[i][j]) {
                            map[i][j] += map[i][k];
                            map[i][k] = 0;
                            j = k;
                            flag = true;
                        }
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = n - 2; j >= 0; j--) {
                if (map[i][j] != 0) {
                    for (int k = n - 1; k > j; k--) {
                        if (map[i][k] == 0) {
                            map[i][k] = map[i][j];
                            map[i][j] = 0;
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }

        return flag;
    }

    static void setMax(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, map[i][j]);
            }
        }
    }

    static int[][] deepCopy(int[][] map) {
        int[][] copy = new int[map.length][];
        for (int i = 0; i < map.length; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
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
