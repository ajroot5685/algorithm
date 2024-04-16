package org.example;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int n;
    static int m;
    static int[][] map;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }

    static int[][] transMap;
    static HashMap<Edge, Integer> edgeHM;

    static ArrayList<Node>[] edgeList;
    static int result = 0;
    static int count = 0;
    static void solve() {
        transMap = new int[n][m];

        int nextNum = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && transMap[i][j] == 0){
                    record(i, j, nextNum);
                    nextNum++;
                }
            }
        }

        edgeHM = new HashMap<>();

        int checkNum = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (checkNum == nextNum) {
                    break;
                }
                if (transMap[i][j] == checkNum) {
                    boolean[][] visited = new boolean[n][m];
                    check(i, j, checkNum, new int[]{0, 0}, visited);
                    checkNum++;
                }
            }
        }

        edgeList = new ArrayList[nextNum];
        for (int i = 2; i < nextNum; i++) {
            edgeList[i] = new ArrayList<>();
        }
        Set<Edge> key = edgeHM.keySet();

        for (Edge edge : key) {
            edgeList[edge.from].add(new Node(edge.to, edgeHM.get(edge)));
        }

        prim();

        if (count == nextNum - 2) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    static void prim() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(2, 0));
        boolean[] visited = new boolean[edgeList.length];

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited[node.to]) {
                continue;
            }
            visited[node.to] = true;

            result += node.weight;
            count++;

            for (Node next : edgeList[node.to]) {
                if (!visited[next.to]) {
                    queue.add(next);
                }
            }
        }
    }

    static void check(int x, int y, int num, int[] prevD, boolean[][] visited) {

        if (visited[x][y])
            return;
        if (transMap[x][y] != 0)
            visited[x][y] = true;
        if (transMap[x][y] == 0) {
            checkDistance(x, y, num, prevD, 0);
            return;
        }


        int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < d.length; i++) {
            if (d[i][0] + x < n && d[i][0] + x >= 0 && d[i][1] + y < m && d[i][1] + y >= 0) {
                check(d[i][0] + x, d[i][1] + y, num, d[i], visited);
            }
        }
    }

    static void checkDistance(int x, int y, int num, int[] prevD, int distance) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }

        if (transMap[x][y] == 0) {
            checkDistance(x + prevD[0], y + prevD[1], num, prevD, distance + 1);
        } else if (transMap[x][y] != num) {
            if (distance != 1) {
                Edge edge = new Edge(num, transMap[x][y]);
                if (edgeHM.containsKey(edge)) {
                    edgeHM.put(edge, Math.min(edgeHM.get(edge), distance));
                } else {
                    edgeHM.put(edge, distance);
                }
            }
        }
    }

    static void record(int x, int y, int num) {
        if (map[x][y] == 0 || transMap[x][y] != 0) {
            return;
        }
        transMap[x][y] = num;

        int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < d.length; i++) {
            if (d[i][0] + x < n && d[i][0] + x >= 0 && d[i][1] + y < m && d[i][1] + y >= 0) {
                record(d[i][0] + x, d[i][1] + y, num);
            }
        }
    }

    static class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "from : " + this.from + ", to : " + this.to;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Edge edge = (Edge) obj;
            return from == edge.from && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }

    }

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
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