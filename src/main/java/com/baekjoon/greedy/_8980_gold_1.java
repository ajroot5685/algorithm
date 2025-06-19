package com.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class _8980_gold_1 {

    static FastReader scan = new FastReader();

    static int n, c;
    static int m;

    static PriorityQueue<Node> box = new PriorityQueue<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        c = scan.nextInt();
        m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            box.add(new Node(scan.nextInt(), scan.nextInt(), scan.nextInt()));
        }
    }

    static void solve() {
        int[] capacity = new int[n + 1];
        Arrays.fill(capacity, c);
        int result = 0;

        while (!box.isEmpty()) {
            Node poll = box.poll();

            int min = c;
            for (int i = poll.send; i < poll.receive; i++) {
                min = Math.min(min, capacity[i]);
            }

            int get = Math.min(min, poll.amount);
            if (get != 0) {
                for (int i = poll.send; i < poll.receive; i++) {
                    capacity[i] -= get;
                }
                result += get;
            }
        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node> {
        int send;
        int receive;
        int amount;

        public Node(int send, int receive, int amount) {
            this.send = send;
            this.receive = receive;
            this.amount = amount;
        }

        @Override
        public int compareTo(Node node) {
            if (this.receive == node.receive) {
                return node.send - this.receive;
            }
            return this.receive - node.receive;
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
