package com.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class _1826_gold_2 {

    static FastReader scan = new FastReader();

    static int n;
    static int l, p;

    static PriorityQueue<Node> remain = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            remain.offer(new Node(scan.nextInt(), scan.nextInt()));
        }

        l = scan.nextInt();
        p = scan.nextInt();
    }

    static void solve() {
        PriorityQueue<Node> candidate = new PriorityQueue<>((o1, o2) -> o2.amount - o1.amount);

        int now = 0;
        int count = 0;
        while (true) {
            now += p;
            p = 0;

            if (now >= l) {
                System.out.println(count);
                return;
            }

            while (!remain.isEmpty() && remain.peek().distance <= now) {
                candidate.offer(remain.poll());
            }

            if (!candidate.isEmpty()) {
                p = candidate.poll().amount;
                count++;
            } else {
                System.out.println(-1);
                return;
            }
        }
    }

    static class Node {
        int distance;
        int amount;

        public Node(int distance, int amount) {
            this.distance = distance;
            this.amount = amount;
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
