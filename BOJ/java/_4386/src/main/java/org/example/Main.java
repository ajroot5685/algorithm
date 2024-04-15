package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;

    static ArrayList<Node>[] edge;
    static boolean[] visited;
    static Map<Integer, Star> mapping = new HashMap<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            Star star = new Star(scan.nextFloat(), scan.nextFloat());
            mapping.put(i, star);
        }

        edge = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edge[i] = new ArrayList<>();
        }
    }

    static void solve() {
        double result = 0.0;

        for (int i = 0; i < mapping.size(); i++) {
            for (int j = i+1; j < mapping.size(); j++) {
                Star from = mapping.get(i);
                Star to = mapping.get(j);
                double weight = getDistance(from, to);
                edge[i].add(new Node(j, weight));
                edge[j].add(new Node(i, weight));
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited[node.index]) {
                continue;
            }

            visited[node.index] = true;

            result += node.weight;

            for (Node next : edge[node.index]) {
                if (!visited[next.index]) {
                    queue.add(next);
                }
            }
        }

        System.out.println(result);
    }

    static double getDistance(Star a, Star b) {
        float x = a.x - b.x;
        float y = a.y - b.y;

        return Math.sqrt(x * x + y * y);
    }

    static class Node implements Comparable<Node>{
        int index;
        double weight;

        public Node(int index, double weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            if (this.weight > n.weight)
                return 1;
            else if (this.weight == n.weight)
                return 0;
            else
                return -1;
        }
    }

    static class Star {
        float x;
        float y;

        public Star(float x, float y) {
            this.x = x;
            this.y = y;
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

        float nextFloat() {
            return Float.parseFloat(next());
        }
    }
}