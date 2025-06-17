package com.baekjoon.samsung;

import java.io.*;
import java.util.*;

public class _15683_gold_3 {

    static FastReader scan = new FastReader();

    static int n, m;
    static int[][] map;

    static ArrayList<Node> cctv;
    static List<Node> cctv5;

    static int min;

    static int[] direction;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    // 1: 0, 1, 2, 3
    // 2: 0/1, 2/3
    // 3: 0/2, 2/1, 1/3, 3/0
    // 4: 0/1/2, 0/1/3, 0/2/3, 1/2/3

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        map = new int[n][m];
        cctv = new ArrayList<>();
        cctv5 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = scan.nextInt();
                map[i][j] = num;

                if (num == 5) {
                    cctv5.add(new Node(i, j, num));
                } else if (num >= 1 && num < 5) {
                    cctv.add(new Node(i, j, num));
                }
            }
        }
    }

    static void solve() {
        for (Node node : cctv5) {
            updateMap(map, node.x, node.y, 0);
            updateMap(map, node.x, node.y, 1);
            updateMap(map, node.x, node.y, 2);
            updateMap(map, node.x, node.y, 3);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    min++;
                }
            }
        }

        if (!cctv.isEmpty()) {
            direction = new int[cctv.size()];
            for (int i = 0; i < 4; i++) {
                direction[0] = i;
                dfs(1);
            }
        }

        System.out.println(min);
    }

    static void dfs(int index) {
        if (index == direction.length) {
            check();
            return;
        }

        for (int i = 0; i < 4; i++) {
            direction[index] = i;
            dfs(index + 1);
        }
    }

    static void check() {
        int[][] map = deepCopy();

        for (int i = 0; i < cctv.size(); i++) {
            Node node = cctv.get(i);

            if (node.num == 1) {
                updateMap(map, node.x, node.y, direction[i]);
            } else if (node.num == 2) {
                if (direction[i] == 0) {
                    updateMap(map, node.x, node.y, 0);
                    updateMap(map, node.x, node.y, 1);
                } else if (direction[i] == 1) {
                    updateMap(map, node.x, node.y, 2);
                    updateMap(map, node.x, node.y, 3);
                } else {
                    // 2번은 방향이 2가지만 있음
                    return;
                }
            } else if (node.num == 3) {
                if (direction[i] == 0) {
                    updateMap(map, node.x, node.y, 0);
                    updateMap(map, node.x, node.y, 2);
                } else if (direction[i] == 1) {
                    updateMap(map, node.x, node.y, 2);
                    updateMap(map, node.x, node.y, 1);
                } else if (direction[i] == 2) {
                    updateMap(map, node.x, node.y, 1);
                    updateMap(map, node.x, node.y, 3);
                } else {
                    updateMap(map, node.x, node.y, 3);
                    updateMap(map, node.x, node.y, 0);
                }
            } else if (node.num == 4) {
                if (direction[i] == 0) {
                    updateMap(map, node.x, node.y, 0);
                    updateMap(map, node.x, node.y, 1);
                    updateMap(map, node.x, node.y, 2);
                } else if (direction[i] == 1) {
                    updateMap(map, node.x, node.y, 0);
                    updateMap(map, node.x, node.y, 1);
                    updateMap(map, node.x, node.y, 3);
                } else if (direction[i] == 2) {
                    updateMap(map, node.x, node.y, 0);
                    updateMap(map, node.x, node.y, 2);
                    updateMap(map, node.x, node.y, 3);
                } else {
                    updateMap(map, node.x, node.y, 1);
                    updateMap(map, node.x, node.y, 2);
                    updateMap(map, node.x, node.y, 3);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    result++;
                }
            }
        }

        min = Math.min(min, result);
    }

    static void updateMap(int[][] map, int x, int y, int direction) {
        int nextX = x + dx[direction];
        int nextY = y + dy[direction];

        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
            return;
        }

        if (map[nextX][nextY] <= 0) {
            map[nextX][nextY] = -1;
            updateMap(map, nextX, nextY, direction);
        } else if (map[nextX][nextY] < 6) {
            updateMap(map, nextX, nextY, direction);
        }
    }

    static int[][] deepCopy() {
        int[][] copy = new int[n][];
        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
    }

    static class Node {
        int x;
        int y;
        int num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
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
