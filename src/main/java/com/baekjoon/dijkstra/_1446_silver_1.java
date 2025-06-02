package com.baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class _1446_silver_1 {

    static FastReader scan = new FastReader();

    static int n, d;
    static List<Node> fast;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        d = scan.nextInt();

        fast = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            int weight = scan.nextInt();

            if (start < d && end <= d) {
                fast.add(new Node(start, end, weight));
            }
        }
    }

    static void solve() {
        fast.sort(Comparator.comparingInt(o -> o.from));

        int[] dp = new int[d + 1];
        for (int i = 1; i <= d; i++) {
            dp[i] = i;
        }

        int index = 0;
        for (int i = 0; i < d; i++) {
            while (fast.size() > index && fast.get(index).from <= i) {
                Node node = fast.get(index);
                dp[node.to] = Math.min(dp[node.to], dp[node.from] + node.weight);
                index++;
            }
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }

        System.out.println(dp[d]);
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
