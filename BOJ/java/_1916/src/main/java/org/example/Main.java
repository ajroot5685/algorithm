package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int[] distance;
    static ArrayList<Node>[] edge;
    static boolean[] visit;

    static int start;
    static int end;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        distance = new int[n + 1];
        edge = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            edge[scan.nextInt()].add(new Node(scan.nextInt(), scan.nextInt()));
        }

        start = scan.nextInt();
        end = scan.nextInt();
    }

    static void solve() {
        dijkstra();

        System.out.println(distance[end]);
    }

    static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        distance[start] = 0;
        queue.add(new Node(start, 0));

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
                int Nvertex = next.vertex;
                int Ncost = next.cost;

                if (!visit[Nvertex] && distance[Nvertex] > distance[now.vertex] + Ncost) {
                    distance[Nvertex] = distance[now.vertex] + Ncost;
                    queue.add(new Node(Nvertex, distance[Nvertex]));
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