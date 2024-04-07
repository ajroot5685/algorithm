package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int v;
    static int e;
    static int k;
    static int[] distance;
    static ArrayList<Node>[] edge;
    static boolean[] visit;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        v = scan.nextInt();
        e = scan.nextInt();
        k = scan.nextInt();

        distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        edge = new ArrayList[v + 1];

        visit = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            int weight = scan.nextInt();

            edge[start].add(new Node(end, weight));
        }
    }

    static void solve() {
        dijkstra();

        for (int i = 1; i <= v; i++) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(distance[i]);
            }
        }

        System.out.println(sb.toString());
    }

    static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        distance[k] = 0;
        queue.add(new Node(k, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int vertex = node.vertex;
            int cost = node.cost;

            if (!visit[vertex])
                visit[vertex] = true;

            if (distance[vertex] < cost) {
                continue;
            }

            for (int i = 0; i < edge[vertex].size(); i++) {
                Node node2 = edge[vertex].get(i);

                int vertex2 = node2.vertex;
                int cost2 = node2.cost;

                if (!visit[vertex2] && distance[vertex2] > cost2 + cost) {
                    distance[vertex2] = cost2 + cost;

                    queue.add(new Node(vertex2, distance[vertex2]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
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