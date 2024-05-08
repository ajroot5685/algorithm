package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int n;
    static int m;
    static ArrayList<Node> edge;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        long[] distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        distance[1] = 0;

        for (int i = 1; i <= n; i++) {
            for (Node node : edge) {
                if (distance[node.from] == Long.MAX_VALUE) {
                    continue;
                }

                if (distance[node.to] > distance[node.from] + node.cost) {
                    distance[node.to] = distance[node.from] + node.cost;

                    if (i == n) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (distance[i] == Long.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        edge = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();

            edge.add(new Node(from, to, cost));
        }
    }

    static class Node {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
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