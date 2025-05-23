package com.swea.d4;

import java.io.*;
import java.util.*;

public class _1249 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static int[][] map;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            n = scan.nextInt();
            map = new int[n][n];

            for (int j = 0; j < n; j++) {
                char[] charArray = scan.next().toCharArray();
                for (int k = 0; k < n; k++) {
                    map[j][k] = charArray[k] - '0';
                }
            }

            sb.append("#").append(i).append(" ");
            solve();
        }
    }

    static void solve() {
        bfs(0, 0);
    }

    static void bfs(int startX, int startY) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.time));
        int[][] result = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        pq.offer(new Node(startX, startY, 0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if (visited[poll.x][poll.y] && poll.time >= result[poll.x][poll.y]) {
                continue;
            }
            result[poll.x][poll.y] = poll.time;
            visited[poll.x][poll.y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }
                if (!visited[nextX][nextY] || result[nextX][nextY] > poll.time + map[nextX][nextY]) {
                    pq.offer(new Node(nextX, nextY, poll.time + map[nextX][nextY]));
                }
            }
        }

        sb.append(result[n - 1][n - 1]).append("\n");
    }

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
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
