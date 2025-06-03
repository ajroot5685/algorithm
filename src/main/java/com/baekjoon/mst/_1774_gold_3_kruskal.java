package com.baekjoon.mst;

import java.io.*;
import java.util.*;

public class _1774_gold_3_kruskal {

    static FastReader scan = new FastReader();

    static int n, m;
    static int[][] pos;

    static ArrayList<Integer>[] connect;
    static int[] parent;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        pos = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            pos[i][0] = x;
            pos[i][1] = y;
        }

        connect = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            connect[i] = new ArrayList<>();
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            if (a != b) {
                union(a, b);
            }
        }
    }

    static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (i != j) {
                    pq.offer(new Node(i, j, getDistance(i, j)));
                }
            }
        }

        double result = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (union(poll.a, poll.b)) {
                continue;
            }

            result += poll.weight;
        }

        System.out.printf("%.2f", result);
    }

    static double getDistance(int a, int b) {
        long dx = pos[a][0] - pos[b][0];
        long dy = pos[a][1] - pos[b][1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return true;
        }

        if (rootX > rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
        return false;
    }

    static class Node implements Comparable<Node> {
        int a;
        int b;
        double weight;

        public Node(int a, int b, double weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.weight, o.weight);
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
