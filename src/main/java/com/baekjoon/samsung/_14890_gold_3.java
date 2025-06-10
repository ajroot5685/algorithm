package com.baekjoon.samsung;

import java.io.*;
import java.util.*;

public class _14890_gold_3 {

    static FastReader scan = new FastReader();

    static int n, l;
    static int[][] map;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        l = scan.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }

    static void solve() {
        int result = 0;

        for (int i = 0; i < n; i++) {
            int check = map[i][0];
            boolean[] set = new boolean[n + 1];
            boolean flag = false;
            for (int j = 1; j < n; j++) {
                if (map[i][j] == check) {
                    continue;
                }
                if (Math.abs(map[i][j] - check) > 1) {
                    flag = true;
                    break;
                }
                if (map[i][j] > check) {
                    for (int k = j - 1; k > j - 1 - l; k--) {
                        if (k < 0 || map[i][k] != check || set[k]) {
                            flag = true;
                            break;
                        }
                        set[k] = true;
                    }
                } else {
                    for (int k = j; k < j + l; k++) {
                        if (k >= n || map[i][k] != check - 1 || set[k]) {
                            flag = true;
                            break;
                        }
                        set[k] = true;
                    }
                }
                check = map[i][j];

                if (flag) {
                    break;
                }
            }
            if (!flag) {
                result++;
            }
        }

        for (int i = 0; i < n; i++) {
            int check = map[0][i];
            boolean[] set = new boolean[n + 1];
            boolean flag = false;
            for (int j = 1; j < n; j++) {
                if (map[j][i] == check) {
                    continue;
                }
                if (Math.abs(map[j][i] - check) > 1) {
                    flag = true;
                    break;
                }
                if (map[j][i] > check) {
                    for (int k = j - 1; k > j - 1 - l; k--) {
                        if (k < 0 || map[k][i] != check || set[k]) {
                            flag = true;
                            break;
                        }
                        set[k] = true;
                    }
                } else {
                    for (int k = j; k < j + l; k++) {
                        if (k >= n || map[k][i] != check - 1 || set[k]) {
                            flag = true;
                            break;
                        }
                        set[k] = true;
                    }
                }
                check = map[j][i];

                if (flag) {
                    break;
                }
            }
            if (!flag) {
                result++;
            }
        }

        System.out.println(result);
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
