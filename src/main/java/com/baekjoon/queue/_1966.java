package com.baekjoon.queue;

import java.io.*;
import java.util.*;

public class _1966 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static int m;
    static List<Node> arr;
    static int[] amount;
    static Deque<Node> queue;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            n = scan.nextInt();
            m = scan.nextInt();
            arr = new ArrayList<>();
            amount = new int[10];
            queue = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                Node node = new Node(j, scan.nextInt());
                arr.add(node);
                amount[node.priority]++;
                queue.offer(node);
            }
            solve();
        }
    }

    static void solve() {
        Node target = arr.get(m);
        int result = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (isBiggest(node.priority)) {
                amount[node.priority]--;
                result++;
                if (node.index == target.index) {
                    sb.append(result).append("\n");
                }
            } else {
                queue.offer(node);
            }
        }
    }

    static boolean isBiggest(int priority) {
        for (int i = priority + 1; i <= 9; i++) {
            if (amount[i] > 0) {
                return false;
            }
        }
        return true;
    }

    static class Node {
        int index;
        int priority;

        public Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
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
