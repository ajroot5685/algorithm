package com.baekjoon.bfs;

import java.io.*;
import java.util.*;

public class _1260_silver_2 {

    static FastReader scan = new FastReader();

    static int n, m, v;
    static List<List<Integer>> edgeList = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        v = scan.nextInt();

        for (int i = 0; i <= n; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            edgeList.get(x).add(y);
            edgeList.get(y).add(x);
        }
    }

    static void solve() {
        for (int i = 1; i <= n; i++) {
            Collections.sort(edgeList.get(i));
        }

        dfs(v, new boolean[n + 1]);
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }

    static void dfs(int from, boolean[] visited) {
        visited[from] = true;
        sb.append(from).append(" ");

        for (int i = 0; i < edgeList.get(from).size(); i++) {
            Integer next = edgeList.get(from).get(i);
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }

    static void bfs(int start) {
        Deque<Integer> pq = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        pq.offer(start);
        while (!pq.isEmpty()) {
            Integer poll = pq.poll();

            if (visited[poll]) {
                continue;
            }
            visited[poll] = true;
            sb.append(poll).append(" ");

            for (int i = 0; i < edgeList.get(poll).size(); i++) {
                Integer next = edgeList.get(poll).get(i);
                if (!visited[next]) {
                    pq.offer(next);
                }
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
