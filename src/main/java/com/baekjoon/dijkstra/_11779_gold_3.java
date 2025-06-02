package com.baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class _11779_gold_3 {

    static FastReader scan = new FastReader();

    static int n, m;
    static int start, end;
    static ArrayList<Node>[] edge;
    static int[] distance;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        edge = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            edge[from].add(new Node(to, weight));
        }

        start = scan.nextInt();
        end = scan.nextInt();
    }

    static void solve() {
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[n + 1];

        int[] parent = new int[n + 1];

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (poll.to == end) {
                sb.append(poll.weight).append("\n");
                break;
            }

            if (visited[poll.to]) {
                continue;
            }
            visited[poll.to] = true;

            for (Node next : edge[poll.to]) {
                if (!visited[next.to] && poll.weight + next.weight < distance[next.to]) {
                    distance[next.to] = poll.weight + next.weight;
                    parent[next.to] = poll.to;
                    pq.offer(new Node(next.to, distance[next.to]));
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(end);

        while (parent[end] != 0) {
            path.add(parent[end]);
            end = parent[end];
        }

        sb.append(path.size()).append("\n");

        Collections.reverse(path);
        for (int p : path) {
            sb.append(p).append(" ");
        }

        System.out.println(sb);
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
