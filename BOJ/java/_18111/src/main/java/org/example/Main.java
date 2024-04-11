package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int b;
    static int[][] map;
    static int total_block = 0;
    static int max_height;
    static int min_height;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        b = scan.nextInt();

        total_block += b;

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = scan.nextInt();
                map[i][j] = num;
                total_block += num;
            }
        }

        max_height = total_block / (n * m);

        min_height = (total_block - b) / (n * m);
    }

    static int time = Integer.MAX_VALUE;
    static int height = Integer.MIN_VALUE;

    static void solve() {
        for (int i = min_height; i <= max_height; i++) {
            brute(i);
        }

        sb.append(time);
        sb.append(" ");
        sb.append(height);

        System.out.println(sb.toString());
    }

    static void brute(int target) {
        int result_time = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > target) {
                    result_time += (map[i][j]-target) * 2;
                } else if (map[i][j] < target) {
                    result_time += target - map[i][j];
                }
            }
        }

        if (time > result_time) {
            time = result_time;
            height = target;
        } else if (time == result_time && height < target) {
            height = target;
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