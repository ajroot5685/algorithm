package com.baekjoon.bfs;

import java.io.*;
import java.util.*;

public class _16236_gold_3 {

    static FastReader scan = new FastReader();

    static int n;
    static int[][] map;
    static int sharkX;
    static int sharkY;
    static int size = 2;
    static int remainExp = size;

    // 우선순위 : 상 -> 좌 -> 우 -> 하 로는 조건을 만족시킬 수 없음
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
                int status = scan.nextInt();
                if (status == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                } else {
                    map[i][j] = status;
                }
            }
        }
    }

    static void solve() {
        int result = 0;
        while (true) {
            int roundResult = bfs();
            if (roundResult == -1) {
                break;
            }
            result += roundResult;
        }

        System.out.println(result);
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        int minDistance = Integer.MAX_VALUE;
        List<Node> fishes = new ArrayList<>();

        queue.offer(new Node(sharkX, sharkY, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.distance > minDistance) {
                continue;
            }

            if (map[node.x][node.y] != 0 && map[node.x][node.y] < size) {
                fishes.add(node);
                minDistance = node.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }
                if (visited[nextX][nextY] || map[nextX][nextY] > size) {
                    continue;
                }

                visited[nextX][nextY] = true;
                queue.offer(new Node(nextX, nextY, node.distance + 1));
            }
        }

        if (fishes.isEmpty()) {
            return -1;
        }

        Collections.sort(fishes);
        Node fish = fishes.get(0);

        map[fish.x][fish.y] = 0;
        sharkX = fish.x;
        sharkY = fish.y;
        if (--remainExp == 0) {
            remainExp = ++size;
        }
        return fish.distance;
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o2) {
            if (this.distance == o2.distance) {
                if (this.x == o2.x) {
                    return this.y - o2.y;
                } else {
                    return this.x - o2.x;
                }
            } else {
                return this.distance - o2.distance;
            }
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
