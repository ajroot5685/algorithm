package com.baekjoon.mst;

import java.io.*;
import java.util.*;

public class _1647_gold_4_prim {

    static FastReader scan = new FastReader();

    static int n, m;
    static ArrayList<Node>[] edgeList;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        edgeList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            edgeList[a].add(new Node(b, c));
            edgeList[b].add(new Node(a, c));
        }
    }

    static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        boolean[] visited = new boolean[n + 1];

        pq.offer(new Node(1, 0));
        int result = 0;
        int max = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (visited[poll.to]) {
                continue;
            }
            visited[poll.to] = true;

            result += poll.weight;
            max = Math.max(max, poll.weight);

            for (Node next : edgeList[poll.to]) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(result - max);
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
