package com.baekjoon.binarySearch;

import java.io.*;
import java.util.*;

public class _1939_gold_3 {

    static FastReader scan = new FastReader();

    static int n, m;
    static List<List<Node>> edgeList = new ArrayList<>();
    static int x, y;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        for (int i = 0; i <= n; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            edgeList.get(a).add(new Node(b, c));
            edgeList.get(b).add(new Node(a, c));
        }

        x = scan.nextInt();
        y = scan.nextInt();
    }

    static void solve() {
        int left = 1;
        int right = 1_000_000_001;

        while (left < right) {
            int mid = (left + right) / 2;

            if (bfs(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left - 1);
    }

    static boolean bfs(int weight) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(new Node(x, 0));
        visited[x] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.to == y) {
                return true;
            }

            for (Node next : edgeList.get(poll.to)) {
                if (!visited[next.to] && next.weight >= weight) {
                    visited[next.to] = true;
                    queue.offer(next);
                }
            }
        }

        return false;
    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
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
