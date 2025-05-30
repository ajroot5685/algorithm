package com.baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class _18352_silver_2 {

    static FastReader scan = new FastReader();

    static int n, m, k, x;
    static ArrayList<Node>[] edge;

    static int[] distance;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        x = scan.nextInt();

        edge = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();

            edge[from].add(new Node(to, 1));
        }
    }

    static void solve() {
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        visited = new boolean[n + 1];

        dijkstra();

        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }
            if (distance[i] == k) {
                sb.append(i).append("\n");
                flag = true;
            }
        }

        if (!flag) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1.weight));

        distance[x] = 0;
        pq.offer(new Node(x, 0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            int to = poll.to;
            int weight = poll.weight;

            if (visited[to]) {
                continue;
            }
            visited[to] = true;

            for (int i = 0; i < edge[to].size(); i++) {
                Node next = edge[to].get(i);

                int to2 = next.to;
                int weight2 = next.weight;

                if (!visited[to2] && distance[to2] > weight2 + weight) {
                    distance[to2] = weight2 + weight;

                    pq.offer(new Node(to2, distance[to2]));
                }
            }
        }
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
