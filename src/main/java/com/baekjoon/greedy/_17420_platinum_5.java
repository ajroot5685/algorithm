package com.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class _17420_platinum_5 {

    static FastReader scan = new FastReader();

    static int n;
    static int[][] gifticon;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();

        gifticon = new int[n][2];

        for (int i = 0; i < n; i++) {
            gifticon[i][0] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            gifticon[i][1] = scan.nextInt();
        }
    }

    static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(new Node(gifticon[i][0], gifticon[i][1]));
        }

        long result = 0;
        int lastRemain = 0;
        int tmpRemain = 0;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            int extensionDay = 0;

            if (lastRemain > poll.useAt && poll.remain < lastRemain) {
                extensionDay = (lastRemain - poll.remain - 1) / 30 + 1;
            } else if (poll.remain < poll.useAt) {
                extensionDay = (poll.useAt - poll.remain - 1) / 30 + 1;
            }

            result += extensionDay;
            tmpRemain = Math.max(tmpRemain, poll.remain + extensionDay * 30);
            if (!pq.isEmpty() && pq.peek().useAt != poll.useAt) {
                lastRemain = tmpRemain;
            }
        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node> {
        int remain;
        int useAt;

        public Node(int remain, int useAt) {
            this.remain = remain;
            this.useAt = useAt;
        }

        @Override
        public int compareTo(Node n) {
            if (this.useAt == n.useAt) {
                return this.remain - n.remain;
            }
            return this.useAt - n.useAt;
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
