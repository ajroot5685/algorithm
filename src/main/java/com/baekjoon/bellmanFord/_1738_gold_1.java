package com.baekjoon.bellmanFord;

import java.io.*;
import java.util.*;

public class _1738_gold_1 {

    static FastReader scan = new FastReader();

    static int n, m;
    static ArrayList<Node> edgeList;
    static ArrayList<Integer>[] edgeList2;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        edgeList = new ArrayList<>();
        edgeList2 = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edgeList2[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();

            edgeList.add(new Node(u, v, w));
            edgeList2[u].add(v);
        }
    }

    static void solve() {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MIN_VALUE);
        distance[1] = 0;

        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (Node node : edgeList) {
                if (distance[node.from] == Integer.MIN_VALUE) {
                    continue;
                }
                if (distance[node.to] < distance[node.from] + node.weight) {
                    distance[node.to] = distance[node.from] + node.weight;
                    parent[node.to] = node.from;

                    if (i == n) {
                        if (node.to == n || existPath(node.to)) {
                            System.out.println(-1);
                            return;
                        }
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int end = n;
        path.add(end);

        while (end != 1) {
            path.add(parent[end]);
            end = parent[end];
        }

        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        for (int i : path) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static boolean existPath(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            if (poll == n) {
                return true;
            }

            if (visited[poll]) {
                continue;
            }
            visited[poll] = true;

            for (Integer next : edgeList2[poll]) {
                if (!visited[next]) {
                    queue.offer(next);
                }
            }
        }

        return false;
    }

    static class Node {
        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
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
