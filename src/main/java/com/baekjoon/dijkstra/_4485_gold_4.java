package com.baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class _4485_gold_4 {

    static FastReader scan = new FastReader();

    static int n;
    static int[][] map;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        int t = 1;
        while (true) {
            n = scan.nextInt();
            if (n == 0) {
                break;
            }

            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = scan.nextInt();
                }
            }

            sb.append("Problem ").append(t++).append(": ");
            solve();
        }
    }

    static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        boolean[][] visited = new boolean[n][n];
        pq.offer(new Node(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (poll.x == n - 1 && poll.y == n - 1) {
                sb.append(poll.weight).append("\n");
                return;
            }

            if (visited[poll.x][poll.y]) {
                continue;
            }
            visited[poll.x][poll.y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                pq.offer(new Node(nextX, nextY, map[nextX][nextY] + poll.weight));
            }
        }
    }

    static class Node {
        int x;
        int y;
        int weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
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
