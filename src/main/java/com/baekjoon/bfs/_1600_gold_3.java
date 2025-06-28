package com.baekjoon.bfs;

import java.io.*;
import java.util.*;

public class _1600_gold_3 {

    static FastReader scan = new FastReader();

    static int k;
    static int w, h;
    static int[][] map;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[] horseDx = {-2, -1, -2, -1, 1, 2, 2, 1};
    static int[] horseDy = {-1, -2, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        k = scan.nextInt();
        w = scan.nextInt();
        h = scan.nextInt();

        map = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }

    static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.move == o2.move) {
                return o1.k - o2.k;
            }
            return o1.move - o2.move;
        });
        pq.offer(new Node(0, 0, 0, 0));

        boolean[][][] visited = new boolean[h][w][k + 1];
        visited[0][0][0] = true;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if (poll.x == h - 1 && poll.y == w - 1) {
                System.out.println(poll.move);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) {
                    continue;
                }
                if (map[nextX][nextY] == 1) {
                    continue;
                }
                if (visited[nextX][nextY][poll.k]) {
                    continue;
                }
                visited[nextX][nextY][poll.k] = true;
                pq.offer(new Node(nextX, nextY, poll.k, poll.move + 1));
            }

            if (poll.k < k) {
                for (int i = 0; i < 8; i++) {
                    int nextX = poll.x + horseDx[i];
                    int nextY = poll.y + horseDy[i];

                    if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) {
                        continue;
                    }
                    if (map[nextX][nextY] == 1) {
                        continue;
                    }
                    if (visited[nextX][nextY][poll.k + 1]) {
                        continue;
                    }
                    visited[nextX][nextY][poll.k + 1] = true;
                    pq.offer(new Node(nextX, nextY, poll.k + 1, poll.move + 1));
                }
            }
        }

        System.out.println(-1);
    }

    static class Node {
        int x;
        int y;
        int k;
        int move;

        public Node(int x, int y, int k, int move) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.move = move;
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
