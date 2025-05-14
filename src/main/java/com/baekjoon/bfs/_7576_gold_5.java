package com.baekjoon.bfs;

import java.io.*;
import java.util.*;

public class _7576_gold_5 {

    static FastReader scan = new FastReader();

    static int n, m;
    static int[][] map;

    static Deque<Node> queue = new ArrayDeque<>();

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        map = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int status = scan.nextInt();
                if (status == 1) {
                    queue.offer(new Node(i, j, 0));
                }
                map[i][j] = status;
            }
        }
    }

    static void solve() {
        int count = bfs();

        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    static int bfs() {
        int minDay = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = 1;
                        queue.offer(new Node(nextX, nextY, node.day + 1));
                    }
                }
            }

            minDay = node.day;
        }

        return minDay;
    }

    static class Node {
        int x;
        int y;
        int day;

        public Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
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
