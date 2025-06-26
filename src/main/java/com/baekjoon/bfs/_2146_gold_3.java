package com.baekjoon.bfs;

import java.io.*;
import java.util.*;

public class _2146_gold_3 {

    static FastReader scan = new FastReader();

    static int n;
    static int[][] map;

    static boolean[][] visited;

    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

    static int min = Integer.MAX_VALUE;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }

    static void solve() {
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    putEdge(i, j);

                    boolean[][] newVisited = new boolean[n][n];
                    checkStartIsland(newVisited, i, j);
                    getMinDistance(newVisited);
                }
            }
        }

        System.out.println(min);
    }

    static void checkStartIsland(boolean[][] visited, int x, int y) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            if (map[nextX][nextY] == 1) {
                checkStartIsland(visited, nextX, nextY);
            }
        }
    }

    static void putEdge(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            if (map[nextX][nextY] == 0) {
                pq.offer(new Node(nextX, nextY, 1));
                continue;
            }
            visited[nextX][nextY] = true;
            putEdge(nextX, nextY);
        }
    }

    static void getMinDistance(boolean[][] visited) {
        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (visited[poll.x][poll.y]) {
                continue;
            }
            visited[poll.x][poll.y] = true;

            if (map[poll.x][poll.y] == 1) {
                min = Math.min(min, poll.distance - 1);
                pq.clear();
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }
                pq.offer(new Node(nextX, nextY, poll.distance + 1));
            }
        }
    }

    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
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
