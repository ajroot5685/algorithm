package org.example;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int v;
    static int e;

    static ArrayList<Node>[] edge;
    static boolean[] visit;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        v = scan.nextInt();
        e = scan.nextInt();

        edge = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++) {
            edge[i] = new ArrayList<>();
        }

        visit = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            edge[from].add(new Node(to, weight));
            edge[to].add(new Node(from, weight));
        }
    }

    static void solve() {
        long result = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visit[node.to]) {
                continue;
            }
            visit[node.to] = true;

            result += node.weight;

            for (Node next : edge[node.to]) {
                if (!visit[next.to]) {
                    queue.add(next);
                }
            }
        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node(int to, int w) {
            this.to = to;
            this.weight = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
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