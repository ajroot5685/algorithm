package org.example;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;

    static int[] parent;
    static PriorityQueue<Node> queue;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        queue = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            if (from != to) {
                queue.add(new Node(from, to, weight));
            }
        }
    }

    static void solve() {
        int result = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (union(node.from, node.to)) {
                continue;
            }

            result += node.weight;
            count++;

            if (count == n - 1) {
                break;
            }
        }

        System.out.println(result);
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
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
        }
        return false;
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int weight;

        public Node(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.weight = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
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