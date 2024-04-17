package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static List<Planet> planet;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();

        planet = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            planet.add(new Planet(i, scan.nextLong(), scan.nextLong(), scan.nextLong()));
        }
    }


    static PriorityQueue<Node> queue;
    static int[] parent;

    static void solve() {

        long result = 0;

        queue = new PriorityQueue<>();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        addEdge();

        int count = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (union(node.from, node.to)) {
                continue;
            }

            result += node.weight;
            count++;

            if (count == n - 1) {
                break;
            }
        }

        System.out.println(result);
    }

    static void addEdge() {
        List<Planet> planetX = new ArrayList<>(planet);
        planetX.sort((o1, o2) -> {
            if (o1.x > o2.x) {
                return 1;
            } else if (o1.x == o2.x) {
                return 0;
            } else {
                return -1;
            }
        });
        List<Planet> planetY = new ArrayList<>(planet);
        planetY.sort((o1, o2) -> {
            if (o1.y > o2.y) {
                return 1;
            } else if (o1.y == o2.y) {
                return 0;
            } else {
                return -1;
            }
        });
        List<Planet> planetZ = new ArrayList<>(planet);
        planetZ.sort((o1, o2) -> {
            if (o1.z > o2.z) {
                return 1;
            } else if (o1.z == o2.z) {
                return 0;
            } else {
                return -1;
            }
        });

        Planet px = planetX.get(0);
        Planet py = planetY.get(0);
        Planet pz = planetZ.get(0);
        for (int i = 0; i < n - 1; i++) {
            Planet nextpx = planetX.get(i+1);
            Planet nextpy = planetY.get(i+1);
            Planet nextpz = planetZ.get(i+1);

            queue.add(new Node(px.index, nextpx.index, Math.abs(px.x - nextpx.x)));
            queue.add(new Node(py.index, nextpy.index, Math.abs(py.y - nextpy.y)));
            queue.add(new Node(pz.index, nextpz.index, Math.abs(pz.z - nextpz.z)));

            px = nextpx;
            py = nextpy;
            pz = nextpz;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return true;
        }
        if (rootX > rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
        return false;
    }

    static class Node implements Comparable<Node>{
        int from;
        int to;
        long weight;

        public Node(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            if (this.weight > node.weight) {
                return 1;
            } else if (this.weight == node.weight) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    static class Planet {
        int index;
        long x;
        long y;
        long z;

        public Planet(int index, long x, long y, long z) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}