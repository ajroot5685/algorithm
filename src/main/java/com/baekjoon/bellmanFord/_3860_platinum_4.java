package com.baekjoon.bellmanFord;

import java.io.*;
import java.util.*;

public class _3860_platinum_4 {

    static FastReader scan = new FastReader();

    static int w, h, g, e;
    static ArrayList<Node> edgeList;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        while (true) {
            w = scan.nextInt();
            h = scan.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[w][h];

            g = scan.nextInt();
            for (int i = 0; i < g; i++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                map[x][y] = 1;
            }

            edgeList = new ArrayList<>();

            e = scan.nextInt();
            for (int i = 0; i < e; i++) {
                int x1 = scan.nextInt();
                int y1 = scan.nextInt();
                int x2 = scan.nextInt();
                int y2 = scan.nextInt();
                int t = scan.nextInt();

                map[x1][y1] = 2;
                edgeList.add(new Node(getIndex(x1, y1), getIndex(x2, y2), t));
            }

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (i == w - 1 && j == h - 1) {
                        continue;
                    }
                    if (map[i][j] == 1 || map[i][j] == 2) {
                        continue;
                    }
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];

                        if (nextX < 0 || nextX >= w || nextY < 0 || nextY >= h) {
                            continue;
                        }
                        if (map[nextX][nextY] == 1) {
                            continue;
                        }
                        edgeList.add(new Node(getIndex(i, j), getIndex(nextX, nextY), 1));
                    }
                }
            }

            solve();
        }
    }

    static int getIndex(int x, int y) {
        return x * h + y;
    }

    static void solve() {
        int[] distance = new int[w * h];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        for (int i = 0; i < w * h; i++) {
            for (Node node : edgeList) {
                if (distance[node.from] == Integer.MAX_VALUE) {
                    continue;
                }
                if (distance[node.to] > distance[node.from] + node.weight) {
                    distance[node.to] = distance[node.from] + node.weight;

                    if (i == w * h - 1) {
                        sb.append("Never\n");
                        return;
                    }
                }
            }
        }

        if (distance[w * h - 1] == Integer.MAX_VALUE) {
            sb.append("Impossible\n");
        } else {
            sb.append(distance[w * h - 1]).append("\n");
        }
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
