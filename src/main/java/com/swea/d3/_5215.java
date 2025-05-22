package com.swea.d3;

import java.io.*;
import java.util.*;

public class _5215 {

    static FastReader scan = new FastReader();

    static int t;
    static int n, l;
    static List<Node> material;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            n = scan.nextInt();
            l = scan.nextInt();

            material = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                material.add(new Node(scan.nextInt(), scan.nextInt()));
            }

            sb.append("#").append(i).append(" ");
            solve();
        }
    }

    static void solve() {
        Collections.sort(material, (o1, o2) -> o1.calorie - o2.calorie);

        int[][] dp = new int[n + 1][l + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                dp[i][j] = dp[i - 1][j];

                int calorie = material.get(i - 1).calorie;
                if (calorie <= j) {
                    int score = material.get(i - 1).score;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - calorie] + score);
                }
            }
        }

        sb.append(dp[n][l]).append("\n");
    }

    static class Node {
        int score;
        int calorie;

        public Node(int score, int calorie) {
            this.score = score;
            this.calorie = calorie;
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
