package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] parent;
    static ArrayList<Integer>[] edge;
    static boolean[] visited;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();

        edge = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            edge[a].add(b);
            edge[b].add(a);
        }
    }

    static void solve() {
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        visited[1] = true;

        for (int i = 0; i < edge[1].size(); i++) {
            dfs(edge[1].get(i), 1);
        }

        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int now, int p) {
        parent[now] = p;

        visited[now] = true;

        for (int i = 0; i < edge[now].size(); i++) {
            if (!visited[edge[now].get(i)]) {
                dfs(edge[now].get(i), now);
            }
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