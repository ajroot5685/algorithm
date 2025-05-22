package com.swea.d3;

import java.io.*;
import java.util.*;

public class _2805 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static int[][] map;

    static int result;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

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
            result = 0;

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
        bfs();
        sb.append(result).append("\n");
    }

    static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        boolean[][] visited = new boolean[n][n];

        int mid = n / 2;
        pq.offer(new Node(mid, mid, 0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if (poll.distance > n / 2) {
                break;
            }
            if (visited[poll.x][poll.y]) {
                continue;
            }
            visited[poll.x][poll.y] = true;
            result += map[poll.x][poll.y];

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
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
