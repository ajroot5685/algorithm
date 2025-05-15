package com.baekjoon.dp;

import java.io.*;
import java.util.*;

public class _1005_gold_3 {

    static FastReader scan = new FastReader();

    static int t;
    static int n, k;
    static int w;

    static int[] arr, dp;
    static List<List<Integer>> edgeList;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            n = scan.nextInt();
            k = scan.nextInt();

            edgeList = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                edgeList.add(new ArrayList<>());
            }

            arr = new int[n + 1];
            dp = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                arr[j] = scan.nextInt();
                dp[j] = -1;
            }

            for (int j = 0; j < k; j++) {
                int x = scan.nextInt();
                int y = scan.nextInt();

                edgeList.get(y).add(x);
            }

            w = scan.nextInt();

            solve();
        }
    }

    static void solve() {
        sb.append(dfs(w)).append("\n");
    }

    static int dfs(int target) {
        if (dp[target] != -1) {
            return dp[target];
        }

        int max = 0;

        for (Integer i : edgeList.get(target)) {
            max = Math.max(max, dfs(i));
        }

        return dp[target] = arr[target] + max;
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
