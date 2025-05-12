package com.baekjoon.dfs;

import java.io.*;
import java.util.*;

public class _9466_gold_3 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static int[] arr;

    static boolean[] done;
    static boolean[] visited;
    static int teamCount;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            n = scan.nextInt();
            arr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                arr[j] = scan.nextInt();
            }
            solve();
        }
    }

    static void solve() {
        done = new boolean[n + 1];
        visited = new boolean[n + 1];
        teamCount = 0;

        for (int i = 1; i <= n; i++) {
            if (!done[i]) {
                dfs(i);
            }
        }

        sb.append(n - teamCount).append("\n");
    }

    static void dfs(int index) {
        if (done[index]) {
            return;
        }

        if (visited[index]) {
            teamCount++;
            done[index] = true;
        }
        visited[index] = true;

        dfs(arr[index]);
        done[index] = true;
        visited[index] = false;
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
