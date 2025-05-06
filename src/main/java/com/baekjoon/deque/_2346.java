package com.baekjoon.deque;

import java.io.*;
import java.util.*;

public class _2346 {

    static FastReader scan = new FastReader();

    static int n;
    static Deque<Node> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            deque.offerLast(new Node(i, scan.nextInt()));
        }
    }

    static void solve() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            Node now = deque.pollFirst();
            sb.append(now.index).append(" ");

            if (deque.isEmpty()) {
                break;
            }

            if (now.paper > 0) {
                for (int i = 0; i < now.paper - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < -now.paper; i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb);
    }

    static class Node {
        int index;
        int paper;

        public Node(int index, int paper) {
            this.index = index;
            this.paper = paper;
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
