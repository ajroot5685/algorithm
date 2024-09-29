package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        solve();
    }

    static int n;
    static ArrayList<Node>[] edge;

    static void solve() {
        int maxIndex = dijkstra(1, 0);
        int max = dijkstra(maxIndex, 1);

        System.out.println(max);
    }

    static int dijkstra(int start, int mode) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {return o2.cost - o1.cost;}));

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MIN_VALUE);

        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int to = node.to;
            int cost = node.cost;

            if (!visited[to]) {
                visited[to] = true;
            }

            for (int i = 0; i < edge[to].size(); i++) {
                Node next = edge[to].get(i);

                if (!visited[next.to] && distance[next.to] < cost + next.cost) {
                    distance[next.to] = cost + next.cost;

                    pq.offer(new Node(next.to, distance[next.to]));
                }
            }
        }

        int maxIndex = start;
        int max = distance[start];

        for (int i = 1; i <= n; i++) {
            if (distance[i] > max) {
                maxIndex = i;
                max = distance[i];
            }
        }

        if (mode == 0) {
            return maxIndex;
        } else {
            return max;
        }
    }

    static void input() {
        n = scan.nextInt();
        edge = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int parent = scan.nextInt();
            int child = scan.nextInt();
            int cost = scan.nextInt();

            edge[parent].add(new Node(child, cost));
            edge[child].add(new Node(parent, cost));
        }
    }

    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
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