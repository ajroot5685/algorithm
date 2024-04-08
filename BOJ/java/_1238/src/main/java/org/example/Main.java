package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int x;

    static int[] distance1;
    static int[] distance2;

    static ArrayList<Node>[] edge1;
    static ArrayList<Node>[] edge2;

    static boolean[] visit;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        x = scan.nextInt();

        distance1 = new int[n + 1];
        distance2 = new int[n + 1];

        Arrays.fill(distance1, Integer.MAX_VALUE);
        Arrays.fill(distance2, Integer.MAX_VALUE);

        edge1 = new ArrayList[n + 1];
        edge2 = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            edge1[i] = new ArrayList<>();
            edge2[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int time = scan.nextInt();

            edge1[a].add(new Node(b, time));
            edge2[b].add(new Node(a, time));
        }
    }

    static void solve() {
        dijkstra(distance1, edge1);
        dijkstra(distance2, edge2);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance1[i] + distance2[i] > max) {
                max = distance1[i] + distance2[i];
            }
        }

        System.out.println(max);
    }

    static void dijkstra(int[] distance, ArrayList<Node>[] edge) {
        visit = new boolean[n + 1];
        PriorityQueue<Node> queue = new PriorityQueue<>();

        distance[x] = 0;
        queue.add(new Node(x, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (!visit[now.vertex]) {
                visit[now.vertex] = true;
            }

            if (distance[now.vertex] < now.cost) {
                continue;
            }

            for (int i = 0; i < edge[now.vertex].size(); i++) {
                Node next = edge[now.vertex].get(i);

                if (!visit[next.vertex] && distance[next.vertex] > next.cost + now.cost) {
                    distance[next.vertex] = next.cost + now.cost;
                    queue.add(new Node(next.vertex, distance[next.vertex]));
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