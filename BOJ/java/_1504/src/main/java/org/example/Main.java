package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int e;
    static int v1;
    static int v2;

    static ArrayList<Node>[] edge;
    static int[] distance;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        dijkstra(1);

        if (distance[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        int toV1 = distance[v1];
        int toV2 = distance[v2];

        if (toV1 == Integer.MAX_VALUE || toV2 == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        dijkstra(v1);

        int fromV1ToV2 = distance[v2];
        int fromV1ToN = distance[n];

        dijkstra(v2);

        int fromV2ToN = distance[n];

        System.out.println(Math.min(toV1 + fromV1ToV2 + fromV2ToN, toV2 + fromV1ToV2 + fromV1ToN));
    }

    static void dijkstra(int start) {
        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int vertex = node.to;
            int cost = node.weight;

            if (visited[vertex]) {
                continue;
            }
            visited[vertex] = true;

            for (int i = 0; i < edge[vertex].size(); i++) {
                Node next = edge[vertex].get(i);

                int vertex2 = next.to;
                int cost2 = next.weight;

                if (!visited[vertex2] && distance[vertex2] > cost + cost2) {
                    distance[vertex2] = cost + cost2;

                    queue.add(new Node(vertex2, distance[vertex2]));
                }
            }
        }
    }

    static void input() {
        n = scan.nextInt();
        e = scan.nextInt();

        edge = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            edge[from].add(new Node(to, weight));
            edge[to].add(new Node(from, weight));
        }

        v1 = scan.nextInt();
        v2 = scan.nextInt();
    }

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
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