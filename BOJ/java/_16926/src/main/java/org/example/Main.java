package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int r;

    static int[][] map;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        r = scan.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }

    static void solve() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < Math.min(n, m) / 2; j++) {
                int tmp = map[j][j];

                // 위쪽
                for (int k = j; k < m - j - 1; k++) {
                    map[j][k] = map[j][k + 1];
                }

                // 오른쪽
                for (int k = j; k < n - 1 - j; k++) {
                    map[k][m - j - 1] = map[k + 1][m - j - 1];
                }

                // 아래쪽
                for (int k = m - j - 1; k > j; k--) {
                    map[n - 1 - j][k] = map[n - 1 - j][k - 1];
                }

                // 왼쪽
                for (int k = n - j - 1; k > j; k--) {
                    map[k][j] = map[k - 1][j];
                }
                map[j + 1][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                sb.append("\n");
            }
            for (int j = 0; j < m; j++) {
                if (j != 0) {
                    sb.append(" ");
                }
                sb.append(map[i][j]);
            }
        }
        System.out.println(sb);
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